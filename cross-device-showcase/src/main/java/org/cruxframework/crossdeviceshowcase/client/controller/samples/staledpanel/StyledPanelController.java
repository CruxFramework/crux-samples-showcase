package org.cruxframework.crossdeviceshowcase.client.controller.samples.staledpanel;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;

import com.google.gwt.user.client.ui.HTML;

@Controller("styledPanelController")
public class StyledPanelController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private StyledPanelMessages messages;

	@Expose
	public void onLoad()
	{	
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}	

	@BindView("styledPanel")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(StyledPanelMessages messages) {
		this.messages = messages;
	}
}
