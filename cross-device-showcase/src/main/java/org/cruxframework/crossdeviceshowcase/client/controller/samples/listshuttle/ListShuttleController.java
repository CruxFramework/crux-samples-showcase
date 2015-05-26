package org.cruxframework.crossdeviceshowcase.client.controller.samples.listshuttle;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.listshuttle.ListShuttle;

import com.google.gwt.user.client.ui.HTML;

@Controller("listShuttleController")
public class ListShuttleController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ListShuttleMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		loadItems();
	}

	private void loadItems(){

		List<String> itemsA = new ArrayList<String>();
		itemsA.add("Alexandre");
		itemsA.add("Bruno");
		itemsA.add("Cláudio ");
		itemsA.add("Samuel");
		itemsA.add("Thiago ");
		itemsA.add("Wesley");
		itemsA.add("Ricardo");
		itemsA.add("Felipe");
		itemsA.add("Guilherme");
		itemsA.add("Juliano");

		List<String> itemsS = new ArrayList<String>();
		itemsS.add("Guilherme");
		itemsS.add("Juliano");

		myWidgetAccessor.listShuttle().setAvailableItems(itemsA);
		myWidgetAccessor.listShuttle().setSelectedItems(itemsS);
	}

	@BindView("listShuttle")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ListShuttle<String> listShuttle();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(ListShuttleMessages messages) {
		this.messages = messages;
	}
}
