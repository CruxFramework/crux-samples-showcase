package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.disposal.topmenudisposal.TopMenuDisposal;

import com.google.gwt.user.client.ui.HTML;

@Controller("topMenuDisposalController")
public class TopMenuDisposalController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;

	@Expose
	public void onLoad()
	{	
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.topMenuDisposalDescription());
		
		myWidgetAccessor.menu().addMenuEntry("Store Finder", "viewSearchStore");
	}

	@BindView("topMenuDisposal")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		TopMenuDisposal menu();
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
