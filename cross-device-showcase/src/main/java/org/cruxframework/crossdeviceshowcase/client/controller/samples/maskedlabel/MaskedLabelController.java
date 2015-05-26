package org.cruxframework.crossdeviceshowcase.client.controller.samples.maskedlabel;

import java.util.Date;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.widgets.client.maskedlabel.MaskedLabel;

import com.google.gwt.user.client.ui.HTML;

@Controller("maskedLabelController")
public class MaskedLabelController 
{
	@Inject
	private MaskedLabelMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		HTML widgetHtml= View.of(this).getWidget("htmlDescText", HTML.class);
		widgetHtml.setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void setDate()
	{
		MaskedLabel widget = View.of(this).getWidget("birthDate", MaskedLabel.class);
		
		@SuppressWarnings("deprecation") // Don't try this at home! :D
		Date birth = new Date(61,11,23);
		
		widget.setUnformattedValue(birth);
	}

	public void setMessages(MaskedLabelMessages messages) {
		this.messages = messages;
	}
}
