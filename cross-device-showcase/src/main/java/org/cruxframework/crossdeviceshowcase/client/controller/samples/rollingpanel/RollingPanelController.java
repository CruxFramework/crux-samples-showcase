package org.cruxframework.crossdeviceshowcase.client.controller.samples.rollingpanel;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.rollingpanel.RollingPanel;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

@Controller("rollingPanelController")
public class RollingPanelController {
	
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ShowcaseResourcesCommon resources;
	
	/** Calls methods at rollingPanel view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.rollingPanelDescription());	
		
		loadSaleItems();
	}
	
	/*Insert list components created to Sport Store*/
	private void loadSaleItems()
	{
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Football Boots", "$89,99", resources.footballboots()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Pink Ball", "$12,99", resources.pinkball()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Basketball shoes ", "$149,99", resources.basketballshoes()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Back Pack", "$99,99", resources.backpack()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Swim Shorts", "$59,99", resources.swimshorts()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Baseball Bats", "$112,99", resources.baseballbats()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Boxing Gloves", "$49,99", resources.gloves()));
	}

	/**
	 * Interface that allows to access the widgets of the "rollingPanel" view.
	 */
	@BindView("rollingPanel")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		FlowPanel innerPanel();
		RollingPanel rollingPanelCustomizedWidget();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}

	public void setResources(ShowcaseResourcesCommon resources) {
		this.resources = resources;
	}
}
