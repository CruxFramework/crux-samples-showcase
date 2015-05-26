package org.cruxframework.crossdeviceshowcase.client.controller.samples.stackmenu;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.stackmenu.StackMenu;
import org.cruxframework.crux.widgets.client.stackmenu.StackMenuItem;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.user.client.ui.HTML;

@Controller("stackMenuController")
public class StackMenuController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;

	@Expose
	public void onLoad()
	{	
		// Insert the component description
		myWidgetAccessor.componentDescription().setHTML(componentDescription.stackMenuDescription());
		
		loadItems();
	}	

	//Add items programmatically.
	private void loadItems()
	{
		for (StackMenuItem listParentItems : myWidgetAccessor.menu().getItems())
		{
			if(listParentItems.getLabel().equals("DVD"))
			{
				listParentItems.add(new StackMenuItem("romance","Romance"));
				listParentItems.add(new StackMenuItem("terror","Terror"));
				for(StackMenuItem listItems : listParentItems.getSubItems())
				{
					if (listItems.getLabel().equals("Romance"))
					{
						listItems.add(new StackMenuItem("prideAndPrejudice","Pride And Prejudice"));
						listItems.add(new StackMenuItem("titanic","Titanic"));
					}
					else if(listItems.getLabel().equals("Terror"))
					{
						listItems.add(new StackMenuItem("constantine","Constantine"));
						listItems.add(new StackMenuItem("orphan","Orphan"));
					}
				}
			}
		}
	}

	@Expose
	public void selectedItem(SelectionEvent<StackMenuItem> evt)
	{
		StackMenuItem item = evt.getSelectedItem();
		String nameItem = item.getLabel();

		String nameParentItem = null;

		if(item.getParentItem() != null)
		{
			nameParentItem = item.getParentItem().getLabel();
		}

		if (nameParentItem == null || nameParentItem.equals(""))
		{
			FlatMessageBox.show("You selected " + nameItem + " item", MessageType.INFO);
		}
		else
		{
			FlatMessageBox.show("You selected " + nameItem + " item in " +nameParentItem, MessageType.INFO);
		}	
	}

	@BindView("stackMenu")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		StackMenu menu();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
