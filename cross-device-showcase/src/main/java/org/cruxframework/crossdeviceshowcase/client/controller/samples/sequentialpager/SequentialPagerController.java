package org.cruxframework.crossdeviceshowcase.client.controller.samples.sequentialpager;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.deviceadaptivegrid.DeviceAdaptiveGrid;

import com.google.gwt.user.client.ui.HTML;

/**
 * @author flavia.jesus
 */
@Controller("sequentialPagerController")
public class SequentialPagerController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	/** Calls methods at sequentialPager view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.sequentialPagerDescription());
		
		loadData();
	}
	
//	Method responsible for populating the grid
	private void loadData()
	{
		DiscDS discDS = (DiscDS) myWidgetAccessor.grid().getDataSource();
		List<DiscDTO> discList = new ArrayList<DiscDTO>();
		
		discList.add(new DiscDTO("Journals", "Justin Bieber", 2013, 239));
		discList.add(new DiscDTO("Sheezus (Deluxe)", "Lily Allen", 2014, 75));
		discList.add(new DiscDTO("Xscape", "Michael Jackson", 2014, 33));
		discList.add(new DiscDTO("Unapologetic", "Rihanna", 2012, 346));
		discList.add(new DiscDTO("21", "Adele", 2011, 14));
		
		discList.add(new DiscDTO("The 20/20 Experience", "Justin Timberlake", 2013, 23));
		discList.add(new DiscDTO("Ghost Stories", "Coldplay", 2014, 176));
		discList.add(new DiscDTO("Ultraviolence", "Lana Del Rey", 2014, 99));
		discList.add(new DiscDTO("Bangerz", "Miley Cyrus", 2013, 199));
		discList.add(new DiscDTO("Unorthodox Jukebox", "Bruno Mars", 2012, 17));
		
		discList.add(new DiscDTO("Continued Silence", "Imagine Dragons", 2012, 34));
		discList.add(new DiscDTO("Girl", "Pharrell Williams", 2014, 57));
		discList.add(new DiscDTO("Demi", "Demi Lovato", 2013, 42));
		discList.add(new DiscDTO("Beyoncé", "Beyoncé", 2013, 123));
		discList.add(new DiscDTO("Midnight Memories", "One Direction", 2013, 41));
		
		discList.add(new DiscDTO("X", "Ed Sheeran", 2014, 35));
		discList.add(new DiscDTO("Shakira", "Shakira", 2014, 39));
		discList.add(new DiscDTO("Prism", "Katy Perry", 2013, 16));
		discList.add(new DiscDTO("Avril Lavigne", "Avril Lavigne", 2013, 11));
		discList.add(new DiscDTO("The Marshall Mathers LP 2", "Eminem", 2013, 27));

		discDS.setDiscs(discList);
		
		myWidgetAccessor.grid().loadData();
		myWidgetAccessor.grid().refresh();
	}
	
	/**
	 * Interface that allows to access the widgets of the "sequentialPager" view.
	 */
	@BindView("sequentialPager")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		DeviceAdaptiveGrid grid();
		HTML componentDescription();
	}

	/** @param myWidgetAccessor the myWidgetAccessor to set */
	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	/** @param componentDescription the componentDescription to set */
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
