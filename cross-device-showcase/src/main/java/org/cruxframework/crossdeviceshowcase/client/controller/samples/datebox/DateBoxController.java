package org.cruxframework.crossdeviceshowcase.client.controller.samples.datebox;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.datebox.DateBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;

import com.google.gwt.user.client.ui.HTML;

@Controller("dateBoxController")
public class DateBoxController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;

	@Expose
	public void onLoad()
	{
		// Insert the component description
		myWidgetAccessor.componentDescription().setHTML(componentDescription.dateBoxDescription());
	}

	@Expose
	public void onClickButtonValueTextBox()
	{
		if(myWidgetAccessor.dateBox().getValue() == null)
		{
			FlatMessageBox.show("Please enter a valid date.", MessageType.WARN);
		}else
		{
			FlatMessageBox.show(myWidgetAccessor.dateBox().getValue().toString(), MessageType.INFO);
		}
	}
	
	@BindView("dateBox")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		DateBox dateBox();
		HTML componentDescription();
	}
	
	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
