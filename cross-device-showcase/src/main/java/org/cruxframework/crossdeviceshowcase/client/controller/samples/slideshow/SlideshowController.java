package org.cruxframework.crossdeviceshowcase.client.controller.samples.slideshow;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.View;

import com.google.gwt.user.client.ui.HTML;

@Controller("slideshowController")
public class SlideshowController 
{	
	@Inject
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		HTML widgetHtml= View.of(this).getWidget("componentDescription", HTML.class);
		widgetHtml.setHTML(componentDescription.slideShowDescription());
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
	
}
