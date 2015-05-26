package org.cruxframework.crossdeviceshowcase.client.controller.samples.rollingtabpanel;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.rollingtabs.RollingTabPanel;

import com.google.gwt.user.client.ui.HTML;

@Controller("rollingTabPanelController")
public class RollingTabPanelController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private RollingTabPanelMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void onClickButton()
	{
		FlatMessageBox.show(messages.clickTab1(), MessageType.INFO);
	}
	
	@Expose
	public void onClickTab2()
	{
		FlatMessageBox.show(messages.clickTab2(), MessageType.INFO);
	}
	
	@Expose
	public void onClickTab3()
	{
		FlatMessageBox.show(messages.clickTab3(), MessageType.INFO);
	}

	@BindView("rollingTabPanel")
	public interface MyWidgetAccessor extends WidgetAccessor
	{
		RollingTabPanel rollingTabPanel();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(RollingTabPanelMessages messages) {
		this.messages = messages;
	}
}

