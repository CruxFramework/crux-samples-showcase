package org.cruxframework.crossdeviceshowcase.client.controller.samples.disposal;

import org.cruxframework.crossdeviceshowcase.client.util.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;
import org.cruxframework.crux.smartfaces.client.disposal.menudisposal.SideMenuDisposal;
import org.cruxframework.crux.smartfaces.client.disposal.menudisposal.TopMenuDisposal;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.menu.Type.LargeType;
import org.cruxframework.crux.smartfaces.client.menu.Type.SmallType;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

@Controller("disposalController")
public class DisposalController {
	
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.topMenuDisposalDescription());
		
		showTopMenuDisposal();
	}
	
	@Expose
	public void showTopMenuDisposal()
	{
		if(!isMobile())
		{
			myWidgetAccessor.sideMenuDisposalPanel().setVisible(false);
			myWidgetAccessor.typeMenuPanel().setVisible(false);
			myWidgetAccessor.topMenuDisposalPanel().setVisible(true);
			myWidgetAccessor.btnTopMenuDisposal().removeStyleName("unselected-button");
			myWidgetAccessor.btnSideMenuDisposal().addStyleName("unselected-button");
		}
		else
		{
			mobileVisiblePanels();
			myWidgetAccessor.mobileTopMenuDisposalPanel().setVisible(true);
			myWidgetAccessor.mobileSideMenuDisposalPanel().setVisible(false);
			myWidgetAccessor.btnTopMenuDisposal().removeStyleName("unselected-button");
			myWidgetAccessor.btnSideMenuDisposal().addStyleName("unselected-button");
		}
	}
	
	@Expose
	public void showSideMenuDisposal()
	{
		if(!isMobile())
		{
			myWidgetAccessor.topMenuDisposalPanel().setVisible(false);	
			myWidgetAccessor.sideMenuDisposalPanel().setVisible(true);
			myWidgetAccessor.typeMenuPanel().setVisible(true);
			myWidgetAccessor.btnSideMenuDisposal().removeStyleName("unselected-button");
			myWidgetAccessor.btnTopMenuDisposal().addStyleName("unselected-button");
		}
		else
		{
			mobileVisiblePanels();
			myWidgetAccessor.mobileTopMenuDisposalPanel().setVisible(false);
			myWidgetAccessor.mobileSideMenuDisposalPanel().setVisible(true);
			myWidgetAccessor.btnSideMenuDisposal().removeStyleName("unselected-button");
			myWidgetAccessor.btnTopMenuDisposal().addStyleName("unselected-button");
		}
	}
	
	private void mobileVisiblePanels()
	{
		myWidgetAccessor.disposalsPanel().setVisible(false);
		myWidgetAccessor.mobileDisposalPanel().setVisible(true);
		myWidgetAccessor.typeMenuPanel().setVisible(false);
	}
	
	/*Check device type*/
	private boolean isMobile()
	{
		if(!Screen.getCurrentDevice().getInput().equals(DeviceAdaptive.Input.mouse))
		{
			return true;
		}else
		{
			return false;
		}	
	}
	
	/*Defines vertical menu type choosed by user*/
	@Expose
	public void changeVerticalMenuType()
	{
		String menuType = myWidgetAccessor.listVerticalMenuType().getValue(myWidgetAccessor.listVerticalMenuType().getSelectedIndex());
		
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
	
	@BindView("disposal")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		FlowPanel disposalsPanel();
		FlowPanel typeMenuPanel();
		ListBox listVerticalMenuType();
		Button btnTopMenuDisposal();
		Button btnSideMenuDisposal();
		FlowPanel topMenuDisposalPanel();
		FlowPanel sideMenuDisposalPanel();
		TopMenuDisposal topMenuDisposal();
		SideMenuDisposal sideMenuDisposal();
		HTML componentDescription();
		
		FlowPanel mobileSideMenuDisposalPanel();
		FlowPanel mobileTopMenuDisposalPanel();
		FlowPanel mobileDisposalPanel();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}

}
