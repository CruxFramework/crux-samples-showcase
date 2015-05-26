package org.cruxframework.crossdeviceshowcase.client.controller.samples.promobanner;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.View;

import com.google.gwt.user.client.ui.HTML;

@Controller("promoBannerController")
public class PromoBannerController 
{
	@Inject
	private PromoBannerMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		HTML widgetHtml= View.of(this).getWidget("htmlDescText", HTML.class);
		widgetHtml.setHTML(messages.htmlDescText());
	}

	public void setMessages(PromoBannerMessages messages) {
		this.messages = messages;
	}
}
