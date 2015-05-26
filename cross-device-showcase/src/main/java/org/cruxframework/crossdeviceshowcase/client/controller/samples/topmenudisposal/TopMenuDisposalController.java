package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

@Controller("topMenuDisposalController")
public class TopMenuDisposalController 
{
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.topMenuDisposalDescription());
		
		showPanels();
	}
	
	private void showPanels()
	{
		if(isMobile())
		{
			myWidgetAccessor.topMenuDisposalPanel().setVisible(false);
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
	
	@Expose
	public void showMessage()
	{
		DialogBox.show(new Label("You clicked on a sub-item under construction."));
	}
	
	@BindView("topMenuDisposal")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		FlowPanel topMenuDisposalPanel();
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
