package org.cruxframework.crossdeviceshowcase.client.controller.samples.maskedlabel;

import java.util.Date;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
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
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		HTML widgetHtml= View.of(this).getWidget("componentDescription", HTML.class);
		widgetHtml.setHTML(componentDescription.maskedTextBoxDescription());
	}
	
	@Expose
	public void setDate()
	{
		MaskedLabel widget = View.of(this).getWidget("birthDate", MaskedLabel.class);
		
		@SuppressWarnings("deprecation") // Don't try this at home! :D
		Date birth = new Date(61,11,23);
		
		widget.setUnformattedValue(birth);
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
