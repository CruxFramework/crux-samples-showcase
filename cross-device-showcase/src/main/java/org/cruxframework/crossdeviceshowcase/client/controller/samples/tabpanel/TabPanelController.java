package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabpanel;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.widgets.client.rollingtabs.RollingTabPanel;

import com.google.gwt.user.client.ui.HTML;

@Controller("tabPanelController")
public class TabPanelController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private TabPanelMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void onClickButton()
	{
		MessageBox.show(messages.clickTab1(), MessageType.INFO);
	}
	
	@Expose
	public void onClickTab2()
	{
		MessageBox.show(messages.clickTab2(), MessageType.INFO);
	}
	
	@Expose
	public void onClickTab3()
	{
		MessageBox.show(messages.clickTab3(), MessageType.INFO);
	}

	@BindView("tabPanel")
	public interface MyWidgetAccessor extends WidgetAccessor
	{
		RollingTabPanel rollingTabPanel();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(TabPanelMessages messages) 
	{
		this.messages = messages;
	}
}

