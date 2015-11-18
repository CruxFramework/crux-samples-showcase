package org.cruxframework.crossdeviceshowcase.client.controller.samples.pagers;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.grid.DataGrid;

@Controller("pagersController")
public class PagersController 
{
	@Expose
	public void onLoadData(EagerLoadEvent<Person> event)
	{
		event.getSource().setData(mockPersonData(100));
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
	
	@BindView("datagrid")
	public static interface Widgets extends WidgetAccessor
	{
		DataGrid<Person> grid();
	}
}
