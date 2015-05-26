package org.cruxframework.crossdeviceshowcase.client.controller.samples.simpleviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.simplecontainer.SimpleViewContainer;

import com.google.gwt.user.client.ui.HTML;

@Controller("simpleViewContainerController")
public class SimpleViewContainerController 
{
	boolean view1 = true;
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private SimpleViewContainerMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void swapView()
	{
		//myWidgetAccessor.viewContainer().showView("view2");
		myWidgetAccessor.viewContainer().getView().removeFromContainer();
		if (view1)
		{
			myWidgetAccessor.viewContainer().loadView("view2", true);
			myWidgetAccessor.buttonChangeView().setText(messages.previousView());
			view1 = false;
		}
		else
		{
			myWidgetAccessor.viewContainer().loadView("view1", true);
			myWidgetAccessor.buttonChangeView().setText(messages.nextView());
			view1 = true;
		}
	}

	@BindView("simpleViewContainer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		SimpleViewContainer viewContainer();
		Button buttonChangeView();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(SimpleViewContainerMessages messages) 
	{
		this.messages = messages;
	}
}
