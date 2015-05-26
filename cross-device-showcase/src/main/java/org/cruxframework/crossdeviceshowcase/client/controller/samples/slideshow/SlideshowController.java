package org.cruxframework.crossdeviceshowcase.client.controller.samples.slideshow;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.View;

import com.google.gwt.user.client.ui.HTML;

@Controller("slideshowController")
public class SlideshowController 
{
	@Inject
	private SlideshowMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		HTML widgetHtml= View.of(this).getWidget("htmlDescText", HTML.class);
		widgetHtml.setHTML(messages.htmlDescText());
	}

	public void setMessages(SlideshowMessages messages) {
		this.messages = messages;
	}
	
}
