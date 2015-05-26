package org.cruxframework.crossdeviceshowcase.client.controller.samples.filter;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.filter.Filter;
import org.cruxframework.crux.widgets.client.filter.Filterable;

import com.google.gwt.user.client.ui.HTML;

@Controller("filterController")
public class FilterController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.filterDescription());
		
		myWidgetAccessor.filterWidget().setFilterable(new Filterable<String>() 
		{		
			@Override
			public void onSelectItem(String selectedItem) {
				FlatMessageBox.show("Suggested word selected.", MessageType.SUCCESS);
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
		HTML componentDescription();
		Filter filterWidget();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
