package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialogcontainer.DialogViewContainer;

import com.google.gwt.user.client.ui.HTML;

@Controller("dialogViewContainerController")
public class DialogViewContainerController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DialogViewContainerMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void openDialog()
	{	
		myWidgetAccessor.dialogViewContainer().openDialog();
		myWidgetAccessor.dialogViewContainer().center();
		myWidgetAccessor.dialogViewContainer().setUnloadViewOnClose(false);
	}
	
	@Expose
	public void showView1()
	{
		View view = myWidgetAccessor.dialogViewContainer().getView();
		if (view != null)
		{
			myWidgetAccessor.dialogViewContainer().remove(view);
			myWidgetAccessor.dialogViewContainer().showView("simpleView1");
		}	
	}
	
	@Expose
	public void showView2()
	{
		View view = myWidgetAccessor.dialogViewContainer().getView();
		if (view != null)
		{
			myWidgetAccessor.dialogViewContainer().remove(view);
			myWidgetAccessor.dialogViewContainer().showView("simpleView2");
		}	
	}
	
	@BindView("dialogViewContainer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		DialogViewContainer dialogViewContainer();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(DialogViewContainerMessages messages) {
		this.messages = messages;
	}
}
