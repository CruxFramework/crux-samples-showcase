package org.cruxframework.crossdeviceshowcase.client.controller.samples.rollingpanel;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.rollingpanel.RollingPanel;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.user.client.ui.FlowPanel;

@Controller("rollingPanelController")
public class RollingPanelController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ShowcaseResourcesCommon resources;
	
	/** Calls methods at rollingPanel view on Load moment. */
	@Expose
	public void onLoad()
	{
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
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setResources(ShowcaseResourcesCommon resources) 
	{
		this.resources = resources;
	}
}
