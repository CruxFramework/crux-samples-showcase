package org.cruxframework.crossdeviceshowcase.client.controller.samples.pagers;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;
import org.cruxframework.crux.core.client.dataprovider.FetchDataEvent;
import org.cruxframework.crux.core.client.dataprovider.MeasureDataEvent;
import org.cruxframework.crux.core.client.dataprovider.PagedDataProvider;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.grid.DataGrid;
import org.cruxframework.crux.smartfaces.client.list.WidgetList;

@Controller("pagersController")
public class PagersController 
{
	private ArrayList<Person> people = mockPersonData(100);
	
	@Inject
	private Widgets widgets;
	
	@Expose
	public void onLoadData(EagerLoadEvent<Person> event)
	{
		event.getSource().setData(people);
	}
	
	@Expose
	public void onFetchData(FetchDataEvent<Person> event)
	{
		event.getSource().setData(getPeopleByInterval(event.getStartRecord(), event.getEndRecord()));
	}
	
	@Expose
	public void onMeasureData(MeasureDataEvent<Person> event)
	{
		event.getSource().setSize(people.size());
	}

	//@Expose
	@SuppressWarnings({"unchecked", "unused"})
	private void onSelectSwitchPager()
	{
		if(widgets.buttonSwitchPager().getText().contains("Lazy"))
		{
			widgets.buttonSwitchPager().setText("Data Provider");
			PagedDataProvider<Person> dataProvider = (PagedDataProvider<Person>) View.of(this).getDataProvider("dataProvider");
			widgets.widgetList().setDataProvider(dataProvider, true);
			widgets.widgetListScrollable().setDataProvider(dataProvider, true);
			widgets.widgetListSwap().setDataProvider(dataProvider, true);
			
			dataProvider.reset();
			dataProvider.load();
		}
		else
		{
			widgets.buttonSwitchPager().setText("Lazy Data Provider");
			PagedDataProvider<Person> lazyDataProvider = (PagedDataProvider<Person>) View.of(this).getDataProvider("lazyDataProvider");
			widgets.widgetList().setDataProvider(lazyDataProvider, true);
			widgets.widgetListScrollable().setDataProvider(lazyDataProvider, true);
			widgets.widgetListSwap().setDataProvider(lazyDataProvider, true);
			
			lazyDataProvider.reset();
			lazyDataProvider.load();
		}
	}
	
	private ArrayList<Person> getPeopleByInterval(int startRecord, int endRecord)
	{
		ArrayList<Person> ans = new ArrayList<Person>();
		int i = 0;
		for(Person person : people)
		{
			if(i>=startRecord && i<=endRecord)
			{
				ans.add(person);
			}
			i++;
		}
		return ans;
	}
	
	private Person mockPerson(int seed)
	{
		return new Person("name_" + seed, "lastName_" + seed);
	}
	
	private ArrayList<Person> mockPersonData(int numItems)
	{
		ArrayList<Person> people = new ArrayList<Person>();

		for(int i=0;i<numItems;i++)
		{
			people.add(mockPerson(i));
		}

		return people;
	}
	
	@BindView("pagers")
	public static interface Widgets extends WidgetAccessor
	{
		DataGrid<Person> grid();
		WidgetList<Person> widgetList();
		WidgetList<Person> widgetListSwap();
		WidgetList<Person> widgetListScrollable();
		Button buttonSwitchPager();
	}
	
	public void setWidgets(Widgets widgets)
	{
		this.widgets = widgets;
	}
}
