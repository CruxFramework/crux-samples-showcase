package org.cruxframework.crossdeviceshowcase.client.controller.samples.scrollbanner;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
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
	private DescriptionMessages componentDescription;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.scrollBannerDescription());
		
		addMessages();
	}

	private void addMessages()
	{
		myWidgetAccessor.scrollBanner().addMessage("This post was added via a controller.");
	}

	@BindView("scrollBanner")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ScrollBanner scrollBanner();
		Button next();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
