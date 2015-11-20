package org.cruxframework.crossdeviceshowcase.client.controller.samples.listshuttle;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.listshuttle.ListShuttle;

@Controller("listShuttleController")
public class ListShuttleController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		loadItems();
	}

	private void loadItems(){

		List<String> itemsA = new ArrayList<String>();
		itemsA.add("Alex");
		itemsA.add("Bruno");
		itemsA.add("Charlie ");
		itemsA.add("Samuel");
		itemsA.add("Davis ");
		itemsA.add("Wesley");
		itemsA.add("Richard");
		itemsA.add("John");
		itemsA.add("Peter");
		itemsA.add("Jorge");

		List<String> itemsS = new ArrayList<String>();
		itemsS.add("Peter");
		itemsS.add("Jorge");

		myWidgetAccessor.listShuttle().setAvailableItems(itemsA);
		myWidgetAccessor.listShuttle().setSelectedItems(itemsS);
	}

	@BindView("listShuttle")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ListShuttle<String> listShuttle();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
