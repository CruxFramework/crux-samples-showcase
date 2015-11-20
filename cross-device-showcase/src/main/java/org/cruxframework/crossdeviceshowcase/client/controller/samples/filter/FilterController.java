package org.cruxframework.crossdeviceshowcase.client.controller.samples.filter;

import java.util.ArrayList;
import java.util.List;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.widgets.client.filter.Filter;
import org.cruxframework.crux.widgets.client.filter.Filterable;

@Controller("filterController")
public class FilterController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		myWidgetAccessor.filterWidget().setFilterable(new Filterable<String>() 
		{		
			@Override
			public void onSelectItem(String selectedItem) {
				MessageBox.show("Suggested word selected.", MessageType.SUCCESS);
			}
			
			@Override
			public List<FilterResult<String>> filter(String query) 
			{	
				List<String> wordList = new ArrayList<String>();
				wordList.add("Airplane"); 
				wordList.add("Airship");
				wordList.add("Balloon");
				wordList.add("Barge");
				wordList.add("Bike");
				wordList.add("Boat");
				wordList.add("Bus");
				wordList.add("Caption");
				wordList.add("Car");
				wordList.add("Caravela");
				wordList.add("Raft");
				wordList.add("Ship");
				wordList.add("Subway");
				wordList.add("Train");
				wordList.add("Truck");
				
				List<FilterResult<String>> result = new ArrayList<FilterResult<String>>();
				
				for(String wordItem : wordList)
				{
					if (wordItem.toLowerCase().contains(query.toLowerCase()))
					{
						result.add(new FilterResult<String>(wordItem, wordItem, wordItem));
					}
				}
				return result;
			}
		});
	}
	
	@BindView("filter")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Filter filterWidget();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
