package org.cruxframework.crossdeviceshowcase.client.controller.samples.menu;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.menu.Menu;
import org.cruxframework.crux.smartfaces.client.menu.MenuItem;
import org.cruxframework.crux.smartfaces.client.menu.Type.LargeType;
import org.cruxframework.crux.smartfaces.client.menu.Type.SmallType;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

@Controller("menuController")
public class MenuController {
	
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ShowcaseResourcesCommon resources;

	/** Calls methods at menu view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.menuDescription());		
		
		insertItem();
		
		defineListBoxItems();
	}
	
	/*Insert the new items in menu*/
	private void insertItem()
	{
		/*Select menu item for insert new subItems*/
		MenuItem item0 = myWidgetAccessor.menu().getItem(0);
		MenuItem item1 = myWidgetAccessor.menu().getItem(1);
		MenuItem item2 = myWidgetAccessor.menu().getItem(2);
		
		/*Insert subItems in Truck menu item*/
		myWidgetAccessor.menu().addItem(item0, new MyMenuItem("Mercedes-Benz", resources.mercedes()));	
		myWidgetAccessor.menu().addItem(item0, new MyMenuItem("Peterbilt", resources.peterbilt()));
		myWidgetAccessor.menu().addItem(item0, new MyMenuItem("Scania", resources.scania()));
		myWidgetAccessor.menu().addItem(item0, new MyMenuItem("Volvo", resources.volvo()));			
		
		/*Insert subItems in Car menu item*/
		myWidgetAccessor.menu().addItem(item1, new MyMenuItem("Ford", resources.ford()));
		myWidgetAccessor.menu().addItem(item1, new MyMenuItem("Honda", resources.hondaCar()));
		myWidgetAccessor.menu().addItem(item1, new MyMenuItem("Hyundai", resources.hyundai()));
		myWidgetAccessor.menu().addItem(item1, new MyMenuItem("Volkswagen", resources.volkswagen()));
		
		/*Insert subItems in Motorcycle menu item*/
		myWidgetAccessor.menu().addItem(item2, new MyMenuItem("Honda", resources.honda()));
		myWidgetAccessor.menu().addItem(item2, new MyMenuItem("Mitsubishi", resources.mitsubishi()));
		myWidgetAccessor.menu().addItem(item2, new MyMenuItem("Yamaha", resources.yamaha()));
	}
	
	/*Defines menu types according to the device*/
	private void defineListBoxItems()
	{
		if(!Screen.getCurrentDevice().getInput().equals(DeviceAdaptive.Input.mouse))
		{
			myWidgetAccessor.listMenuType().removeItem(0);
			myWidgetAccessor.listMenuType().removeItem(0);
			myWidgetAccessor.listMenuType().removeItem(1);
		}	
	}
	
	/**Defines menu type choosed by user*/
	@Expose
	public void changeMenuType()
	{
		String menuType = myWidgetAccessor.listMenuType().getValue(myWidgetAccessor.listMenuType().getSelectedIndex());
		
		switch (menuType) 
		{
		case "horizontalDropdown":
			myWidgetAccessor.menu().setMenuType(LargeType.HORIZONTAL_DROPDOWN, null);
			break;
		case "horizontalAccordion":
			myWidgetAccessor.menu().setMenuType(LargeType.HORIZONTAL_ACCORDION, SmallType.HORIZONTAL_ACCORDION);
			break;
		case "verticalAccordion":
			myWidgetAccessor.menu().setMenuType(LargeType.VERTICAL_ACCORDION, SmallType.VERTICAL_ACCORDION);
			break;
		case "verticalDropdown":
			myWidgetAccessor.menu().setMenuType(LargeType.VERTICAL_DROPDOWN, null);
			break;	
		case "verticalTree":
			myWidgetAccessor.menu().setMenuType(LargeType.VERTICAL_TREE, SmallType.VERTICAL_TREE);
			break;		
		case "verticalSlide":
			myWidgetAccessor.menu().setMenuType(LargeType.VERTICAL_SLIDE, SmallType.VERTICAL_SLIDE);
			break;		
		default:
			break;
		}
	}
	
	/**
	 * Interface that allows to access the widgets of the "menu" view.
	 */
	@BindView("menu")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Menu menu();
		ListBox listMenuType();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}

	public void setResources(ShowcaseResourcesCommon resources) {
		this.resources = resources;
	}
}
