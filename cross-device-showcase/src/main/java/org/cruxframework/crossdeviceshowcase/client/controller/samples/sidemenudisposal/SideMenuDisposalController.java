package org.cruxframework.crossdeviceshowcase.client.controller.samples.sidemenudisposal;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;
import org.cruxframework.crux.smartfaces.client.disposal.menudisposal.SideMenuDisposal;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.menu.Type.LargeType;
import org.cruxframework.crux.smartfaces.client.menu.Type.SmallType;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

@Controller("sideMenuDisposalController")
public class SideMenuDisposalController {
	
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.sideMenuDisposalDescription());
		
		showPanels();
	}
	
	private void showPanels()
	{
		if(isMobile())
		{
			myWidgetAccessor.sideMenuDisposalPanel().setVisible(false);
			myWidgetAccessor.typeMenuPanel().setVisible(false);
			myWidgetAccessor.mobileDisposalPanel().setVisible(true);
		}
	}
	
	/*Check device type*/
	private boolean isMobile()
	{
		if(Screen.getCurrentDevice().getSize().equals(DeviceAdaptive.Size.small))
		{
			return true;
		}else
		{
			return false;
		}	
	}
	
	/*Defines menu type choosed by user*/
	@Expose
	public void changeMenuType()
	{
		String menuType = myWidgetAccessor.listMenuType().getValue(myWidgetAccessor.listMenuType().getSelectedIndex());
		
		switch (menuType) 
		{
		case "verticalAccordion":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_ACCORDION, SmallType.VERTICAL_ACCORDION);
			break;
		case "verticalDropdown":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_DROPDOWN, null);
			break;	
		case "verticalTree":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_TREE, SmallType.VERTICAL_TREE);
			break;		
		case "verticalSlide":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_SLIDE, SmallType.VERTICAL_SLIDE);
			break;		
		default:
			break;
		}
	}
	
	@Expose
	public void showMessage()
	{
		DialogBox.show(new Label("You clicked on a sub-item under construction."));
	}
	
	@BindView("sideMenuDisposal")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		SideMenuDisposal sideMenuDisposal();
		ListBox listMenuType();
		FlowPanel typeMenuPanel();
		FlowPanel sideMenuDisposalPanel();
		FlowPanel mobileDisposalPanel();
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
