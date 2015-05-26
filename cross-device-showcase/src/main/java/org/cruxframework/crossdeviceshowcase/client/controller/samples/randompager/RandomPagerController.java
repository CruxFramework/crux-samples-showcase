package org.cruxframework.crossdeviceshowcase.client.controller.samples.randompager;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.deviceadaptivegrid.DeviceAdaptiveGrid;
import org.cruxframework.crux.widgets.client.event.row.RowRenderEvent;
import org.cruxframework.crux.widgets.client.event.row.RowRenderHandler;
import org.cruxframework.crux.widgets.client.grid.DataRow;
import org.cruxframework.crux.widgets.client.image.Image;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;


import com.google.gwt.user.client.ui.HTML;

@Controller("randomPagerController")
public class RandomPagerController
{
	@Inject
	private DescriptionMessages componentDescription;
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private ShowcaseResourcesCommon showcaseResourcesCommon;
	
	/** Calls methods at randomPager view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.randomPagerDescription());
		
		loadData();
	}
	
//	Method responsible for populating the grid
	private void loadData(){
		
		CountryDS countryDS = (CountryDS) myWidgetAccessor.grid().getDataSource();
		List<CountryDTO> countryList = new ArrayList<CountryDTO>();
		
		countryList.add(new CountryDTO(showcaseResourcesCommon.argentina().getSafeUri().asString(), "Argentina", "Buenos Aires", "South America"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.brazil().getSafeUri().asString(), "Brazil", "Brasília", "South America"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.chile().getSafeUri().asString(), "Chile", "Santiago", "South America"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.costaRica().getSafeUri().asString(), "Costa Rica", "San José", "Central America"));
		
		countryList.add(new CountryDTO(showcaseResourcesCommon.usa().getSafeUri().asString(), "USA", "Washington", "America"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.mexico().getSafeUri().asString(), "Mexico", "Mexico City", "America"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.canada().getSafeUri().asString(), "Canada", "Ottawa", "America"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.germany().getSafeUri().asString(), "Germany", "Berlin", "Europe"));
		
		countryList.add(new CountryDTO(showcaseResourcesCommon.spain().getSafeUri().asString(), "Spain", "Madrid", "Europe"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.france().getSafeUri().asString(), "France", "Paris",  "Europe"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.italy().getSafeUri().asString(), "Italy", "Rome",  "Europe"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.china().getSafeUri().asString(), "China", "Beijing", "Asia"));
		
		countryList.add(new CountryDTO(showcaseResourcesCommon.southKorea().getSafeUri().asString(), "SouthKorea", "Seoul", "Asia"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.japan().getSafeUri().asString(), "Japan", "Tokyo", "Asia"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.southAfrica().getSafeUri().asString(),"SouthAfrica", "Pretoria", "Africa"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.algeria().getSafeUri().asString(), "Algeria", "Algiers", "Africa"));
		
		countryList.add(new CountryDTO(showcaseResourcesCommon.morocco().getSafeUri().asString(), "Morocco", "Rabat", "Africa"));
		countryList.add(new CountryDTO(showcaseResourcesCommon.australia().getSafeUri().asString(), "Australia", "Canberra", "Oceania"));
		
		countryDS.setCountries(countryList);
		
//		Adds a image in the flag column according to the dataSource datas
		myWidgetAccessor.grid().addRowRenderHandler(new RowRenderHandler()
		{
			@Override
			public void onRowRender(RowRenderEvent event) {
				DataRow row = event.getRow();
				Image image = (Image) row.getWidget("flag");
				image.setUrl(((CountryDTO)row.getDataSourceRecord().getRecordObject()).getFlag());
			}
		});
		
		myWidgetAccessor.grid().loadData();
		myWidgetAccessor.grid().refresh();	
	}

	/**
	 * Interface that allows to access the widgets of the "randomPager" view.
	 */
	@BindView("randomPager")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{	
		DeviceAdaptiveGrid grid();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}

	public void setShowcaseResourcesCommon(
			ShowcaseResourcesCommon showcaseResourcesCommon) {
		this.showcaseResourcesCommon = showcaseResourcesCommon;
	}
	
}
