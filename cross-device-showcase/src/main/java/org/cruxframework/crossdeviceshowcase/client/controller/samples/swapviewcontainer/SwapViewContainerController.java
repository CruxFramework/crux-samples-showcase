package org.cruxframework.crossdeviceshowcase.client.controller.samples.swapviewcontainer;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.swappanel.SwapAnimation;
import org.cruxframework.crux.smartfaces.client.swappanel.SwapViewContainer;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author flavia.jesus
 */
@Controller("swapViewContainerController")
public class SwapViewContainerController 
{	
	int count = 1;
	
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	/** Calls methods at swapViewContainer view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.swapViewContainerDescription());
	}
	
	/** Calls the next view in accordance with the current state*/
	@Expose
	public void nextView()
	{
		switch (count) 
		{
		case 1:
			setState2();
			break;
		case 2:
			setState3();
			break;
		case 3:
			setState1();
			break;	
		}
	}
	
	/** Calls the previous view in accordance with the current state*/
	@Expose
	public void previousView()
	{
		switch (count) 
		{
		case 2:
			setState1();
			break;
		case 3:
			setState2();
			break;
		}
	}
	
	private void setState1()
	{
		myWidgetAccessor.viewContainer().setAnimationBackward(chooseAnimation());
		myWidgetAccessor.viewContainer().showView("swapView1");
		myWidgetAccessor.backButton().setVisible(false);
		myWidgetAccessor.buyButton().setText("Buy Now");
		count = 1;
	}
	
	private void setState2()
	{
		myWidgetAccessor.viewContainer().setAnimationBackward(chooseAnimation());
		myWidgetAccessor.viewContainer().showView("swapView2");
		myWidgetAccessor.backButton().setVisible(true);
		myWidgetAccessor.buyButton().setText("Checkout");
		count = 2;
	}
	
	private void setState3()
	{
		myWidgetAccessor.viewContainer().setAnimationBackward(chooseAnimation());
		myWidgetAccessor.viewContainer().showView("swapView3");
		myWidgetAccessor.backButton().setVisible(true);
		myWidgetAccessor.buyButton().setText("Back to Start");
		count = 3;
	}
	
//	Returns animation type chosen in the listBox by the user
	private SwapAnimation chooseAnimation()
	{
		SwapAnimation swapAnimation = null;
		
		String animation = myWidgetAccessor.listAnimation().getValue(myWidgetAccessor.listAnimation().getSelectedIndex());
		
		switch (animation) 
		{
		case "bounce":
			swapAnimation = SwapAnimation.bounce;
			break;
		case "fade":
			swapAnimation = SwapAnimation.fade;
			break;	
		case "flipX":
			swapAnimation = SwapAnimation.flipX;
			break;	
		case "flipY":
			swapAnimation = SwapAnimation.flipY;
			break;	
		case "lightSpeed":
			swapAnimation = SwapAnimation.lightSpeed;
			break;			
		case "roll":
			swapAnimation = SwapAnimation.roll;
			break;	
		case "rotate":
			swapAnimation = SwapAnimation.rotate;
			break;		
		default:
			break;
		}
		return swapAnimation;
	}
	
	/**
	 * Interface that allows to access the widgets of the "swapViewContainer" view.
	 */
	@BindView("swapViewContainer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Button buyButton();
		Button backButton();
		ListBox listAnimation();
		SwapViewContainer viewContainer();
		HTML componentDescription();
	}

	/** @param myWidgetAccessor the myWidgetAccessor to set */
	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	/** @param componentDescription the componentDescription to set */
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
