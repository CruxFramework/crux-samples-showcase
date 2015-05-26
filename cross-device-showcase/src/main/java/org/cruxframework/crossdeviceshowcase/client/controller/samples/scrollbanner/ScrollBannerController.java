package org.cruxframework.crossdeviceshowcase.client.controller.samples.scrollbanner;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.scrollbanner.ScrollBanner;

import com.google.gwt.user.client.ui.HTML;

@Controller("scrollBannerController")
public class ScrollBannerController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private ScrollBannerMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		addMessages();
	}

	private void addMessages()
	{
		myWidgetAccessor.scrollBanner().addMessage(messages.programMessage());
	}

	@BindView("scrollBanner")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ScrollBanner scrollBanner();
		Button next();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(ScrollBannerMessages messages) 
	{
		this.messages = messages;
	}    
}
