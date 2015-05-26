package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.tabcontainer.TabContainer;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;

@Controller("tabViewContainerController")
public class TabViewContainerController 
{
	@Inject
	private TabViewContainerMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		myWidgetAccessor.tabView().showView("simpleViewTab2");
		myWidgetAccessor.tabView().focusView("simpleViewTab1");
	}
	
	@Expose
	public void add()
	{
			String url = myWidgetAccessor.textBoxUrl().getText();
			myWidgetAccessor.tabView().showView("tabNewView", "3", url);
			myWidgetAccessor.tabView().focusView("3");
	}

	@Expose
	public void remove()
	{
		if(myWidgetAccessor.tabView().getFocusedViewIndex()>=0)
		{
			String viewRemove = myWidgetAccessor.tabView().getViewId(myWidgetAccessor.tabView().getFocusedViewIndex());
			myWidgetAccessor.tabView().remove(myWidgetAccessor.tabView().getView(viewRemove));
		} else
		{
			FlatMessageBox.show(messages.alert(), MessageType.ERROR);
		}
	}

	@BindView("tabViewContainer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		TabContainer tabView();
		TextBox textBoxUrl();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	public void setMessages(TabViewContainerMessages messages) 
	{
		this.messages = messages;
	}
}
