package org.cruxframework.crossdeviceshowcase.client.controller.samples.swappanel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid.PersonDTO;
import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.swappanel.SwapAnimation;
import org.cruxframework.crux.smartfaces.client.swappanel.SwapPanel;
import org.cruxframework.crux.widgets.client.deviceadaptivegrid.DeviceAdaptiveGrid;
import org.cruxframework.crux.widgets.client.formdisplay.FormDisplay;
import org.cruxframework.crux.widgets.client.image.Image;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author flavia.jesus
 *
 */
@Controller("swapPanelController")
public class SwapPanelController 
{
	private int status = 0;
	private final String MESSAGE = "Swaped Widget";
	
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ShowcaseResourcesCommon showcaseResourcesCommon;
	
	/** Calls methods at swapPanel view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.swapPanelDescription());
		
		loadData();
	}
	
	/** Performs exchange of widgets on the panel according to the status variable*/
	@Expose
	public void swapPanel()
	{
		switch (status) {
		case 0:
			myWidgetAccessor.swapPanel().transitTo(new Image(showcaseResourcesCommon.crux()), chooseAnimation());
			status = 1;
			break;
		case 1:
			myWidgetAccessor.grid().setVisible(true);
			myWidgetAccessor.swapPanel().transitTo(myWidgetAccessor.grid(), chooseAnimation());
			status = 2;
			break;	
		case 2:
			myWidgetAccessor.swapPanel().transitTo(myWidgetAccessor.form(), chooseAnimation());
			status = 0;
			break;	
		default:
			break;
		}
	}
	
	/*Method responsible for populating the grid*/
	private void loadData()
	{
		final DeviceAdaptiveGrid grid = myWidgetAccessor.grid();
		SimplePersonDS personDS = (SimplePersonDS) grid.getDataSource();
		List<PersonDTO> personList = new ArrayList<PersonDTO>();

		PersonDTO p1 = new PersonDTO("John D. Onorato",67,new Date(),personList,"active");
		PersonDTO p2 = new PersonDTO("Bob J. Peck",37,new Date(),personList,"inactive");
		PersonDTO p3 = new PersonDTO("Sam A. Payne",19,new Date(),personList,"active");
		PersonDTO p4 = new PersonDTO("Jack J. Worthy",28,new Date(),personList,"inactive");
		PersonDTO p5 = new PersonDTO("Charlie T. Ramer",55,new Date(),personList,"active");
		
		PersonDTO p11 = new PersonDTO("Dean J. Worthy",37,new Date(),personList,"inactive");
		PersonDTO p12 = new PersonDTO("Crowley J. Wardell",57,new Date(),personList,"inactive");
		PersonDTO p13 = new PersonDTO("Rick S. Gerlach",39,new Date(),personList,"active");
		PersonDTO p14 = new PersonDTO("Darryl M. Gray",38,new Date(),personList,"active");
		PersonDTO p15 = new PersonDTO("Hershel J. Murphy",65,new Date(),personList,"inactive");
		
		personDS.setPersons(personList);
		grid.loadData();
		grid.refresh();
	}
	
//	Returns animation type chosen in the listBox by the user
	private SwapAnimation chooseAnimation()
	{
		String animation = myWidgetAccessor.listAnimation().getValue(myWidgetAccessor.listAnimation().getSelectedIndex());
		SwapAnimation swapAnimation = null;
		
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
	
	/**Shows message when occurs swap widget*/
	@Expose
	public void showMessage()
	{
		DialogBox.show(new Label(MESSAGE));
	}
	
	/**
	 * Interface that allows to access the widgets of the "swapPanel" view.
	 */
	@BindView("swapPanel")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{			
		DeviceAdaptiveGrid grid();
		FormDisplay form();
		ListBox listAnimation();
		SwapPanel swapPanel();
		HTML componentDescription();
	}

	/** @param myWidgetAccessor the myWidgetAccessor to set */
	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	/** @param componentDescription the componentDescription to set */
	public void setComponentDescription(DescriptionMessages componentDescription) 
	{
		this.componentDescription = componentDescription;
	}
	
	/** @param showcaseResourcesCommon the showcaseResourcesCommon to set*/
	public void setShowcaseResourcesCommon(ShowcaseResourcesCommon showcaseResourcesCommon) 
	{
		this.showcaseResourcesCommon = showcaseResourcesCommon;
	}
}
