package org.cruxframework.crossdeviceshowcase.client.controller.samples.sortablelist;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.widgets.client.sortablelist.SortableList;
import org.cruxframework.crux.widgets.client.sortablelist.SortableList.BeanRenderer;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author flavia.jesus
 *
 */
@Controller("sortableListController")
public class SortableListController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private DescriptionMessages componentDescription;

	/** Calls methods at sortableList view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.sortableListDescription());
		myWidgetAccessor.sortableList().setBeanRenderer(new BeanRenderer<Widget>() 
		{
			@Override
			public String render(Widget bean) 
			{
				return bean != null ? ((Label)bean).getText() : "";
			}
		});
	}
	
	/**Adds a activity in sortableList component*/
	@Expose
	public void addActivity()
	{
		String activityText = myWidgetAccessor.textBoxActivity().getValue();
		
		if (!activityText.equals(""))
		{
			Label activity = new Label();
			activity.addStyleName("sortableList-item");
			activity.setText(activityText);
			
			myWidgetAccessor.sortableList().addItem(activity);
			myWidgetAccessor.textBoxActivity().setValue("");
		}
	}
	
	/**Remove the selected activity in sortableList component*/
	@Expose
	public void removeActivity()
	{
		myWidgetAccessor.sortableList().removeSelectedItem();
	}
	
	/**
	 * Interface that allows to access the widgets of the "sortableList" view.
	 */
	@BindView("sortableList")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		SortableList sortableList();
		TextBox textBoxActivity();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) 
	{
		this.componentDescription = componentDescription;
	}
}
