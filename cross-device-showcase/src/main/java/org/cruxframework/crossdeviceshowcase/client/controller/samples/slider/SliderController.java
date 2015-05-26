package org.cruxframework.crossdeviceshowcase.client.controller.samples.slider;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.event.swap.SwapEvent;
import org.cruxframework.crux.widgets.client.event.swap.SwapHandler;
import org.cruxframework.crux.widgets.client.slider.Slider;
import org.cruxframework.crux.widgets.client.textbox.NumberTextBox;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

@Controller("sliderController")
public class SliderController 
{
	private final String THANKS_MESSAGE = "Thank you for the informations.";
	private final String EMPTY_FIELDS_MESSAGE = "Fill in all fields."; 
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private DescriptionMessages componentDescription;

	/** Calls methods at slider view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.sliderDescription());
		
		myWidgetAccessor.slider().changeControlsVisibility(false);
//		Show first slider widget
		myWidgetAccessor.slider().showFirstWidget();
	
		statusButtons();

		changeMobileStatus();
		
		mobileDisplayButtons(false);
		
		mobileText();
	}
	
	/**Cleans data fields and goes to the first step of the wizard.*/
	@Expose
	public void cancel()
	{
		clearFields();
		myWidgetAccessor.slider().showFirstWidget();
		statusButtons();
	}
	
	/**Goes to the previous step of the wizard.*/
	@Expose
	public void previous()
	{
		myWidgetAccessor.slider().previous();
		statusButtons();
	}
	
	/**Identifies which position is the wizard and checks if can move to the next step 
	 * validating fields completed. If not, shows warning message.*/
	@Expose
	public void next()
	{
		int currentWidgetIndex = myWidgetAccessor.slider().getCurrentWidgetIndex();
		
		if(currentWidgetIndex == 1)
		{
			if(verifyPersonal())
			{
				myWidgetAccessor.slider().next();
				statusButtons();
			}else
			{
				FlatMessageBox.show(EMPTY_FIELDS_MESSAGE, MessageType.WARN);
			}
		}
		else if(currentWidgetIndex == 2)
		{
			if(verifyProfessional())
			{
				printResult();
				myWidgetAccessor.slider().next();
				statusButtons();
			}else
			{
				FlatMessageBox.show(EMPTY_FIELDS_MESSAGE, MessageType.WARN);
			}
		}
		else
		{
			myWidgetAccessor.slider().next();
			statusButtons();
		}			
	}
		
	/**Finalizes the wizard and back to the first step*/
	@Expose
	public void finish()
	{
		if(verifyPersonal() && verifyProfessional())
		{
			clearFields();
			FlatMessageBox.show(THANKS_MESSAGE, MessageType.SUCCESS);
			myWidgetAccessor.slider().showFirstWidget();
			statusButtons();
		}
	}
	
//	Fills the final screen with the data received
	private void printResult()
	{
		mobileDisplayButtons(true);
		
		String experience = " Month(s)";
		
		if (myWidgetAccessor.radioButtonYears().getValue())
		{
			experience = " Year(s)";
		}
		
		myWidgetAccessor.panelFinish().setVisible(true);
		
		myWidgetAccessor.labelResultName().setText("Name: " + myWidgetAccessor.textBoxName().getText());
		myWidgetAccessor.labelResultAge().setText("Age: " + myWidgetAccessor.numberBoxAge().getValue());
		myWidgetAccessor.labelResultPhone().setText("Phone: " + myWidgetAccessor.numberCodPhone().getValue());
		myWidgetAccessor.labelResultProfession().setText("Profession: " + myWidgetAccessor.textBoxProfession().getText());
		myWidgetAccessor.labelResultExperience().setText("Length of experience: " + myWidgetAccessor.numberExperience().getValue() + experience);
	}
	
	private void changeMobileStatus()
	{
		myWidgetAccessor.slider().addSwapHandler(new SwapHandler() 
		{
			@Override
			public void onSwap(SwapEvent event) 
			{
				mobileNext();
			}
		});
	}
	
	private void mobileNext()
	{
		int currentWidgetIndex = myWidgetAccessor.slider().getCurrentWidgetIndex();
		
		switch (currentWidgetIndex) 
		{
		case 0:
			{
				mobileDisplayButtons(false);
			}
			break;
		case 2:
			
			mobileDisplayButtons(false);
			
			if(!verifyPersonal())
			{
				myWidgetAccessor.slider().previous();
				FlatMessageBox.show(EMPTY_FIELDS_MESSAGE, MessageType.WARN);
			}
			break;
		case 3:
			
			mobileDisplayButtons(false);
			
			if(!verifyProfessional())
			{
				myWidgetAccessor.slider().previous();
				FlatMessageBox.show(EMPTY_FIELDS_MESSAGE, MessageType.WARN);
			}
			else
			{
				printResult();
			}
			break;
		}			
	}
	
//	Checks that all personal fields are filled
	private boolean verifyPersonal()
	{
		boolean complete = false;
		
		if(!myWidgetAccessor.textBoxName().getValue().equals("") &&  
			myWidgetAccessor.numberBoxAge().getValue() != null && 
			myWidgetAccessor.numberCodPhone().getValue() != null &&
			myWidgetAccessor.numberInitPhone().getValue() != null &&
			myWidgetAccessor.numberFinalPhone().getValue() != null)
		{
			complete = true;
		}
		return complete;
	}
	
//	Checks that all professional fields are filled
	private boolean verifyProfessional()
	{
		boolean complete = false;
		
		if(!myWidgetAccessor.textBoxProfession().getValue().equals("") && 
			myWidgetAccessor.numberExperience().getValue() != null) 
		{
			complete = true;
		}
		return complete;
	}
	
//	Set buttons status
	private void statusButtons()
	{
		int widgetIndex = myWidgetAccessor.slider().getCurrentWidgetIndex();
		
		switch (widgetIndex)
		{
			case 0: 
				myWidgetAccessor.btnCancel().setEnabled(false);
				myWidgetAccessor.btnPrevious().setEnabled(false);
				myWidgetAccessor.btnNext().setEnabled(true);
				myWidgetAccessor.btnFinish().setEnabled(false);
			break;	
			
			case 1: 
				myWidgetAccessor.btnCancel().setEnabled(true);
				myWidgetAccessor.btnPrevious().setEnabled(true);
				myWidgetAccessor.btnNext().setEnabled(true);
				myWidgetAccessor.btnFinish().setEnabled(false);
			break;	
			
			case 2: 
				myWidgetAccessor.btnCancel().setEnabled(true);
				myWidgetAccessor.btnPrevious().setEnabled(true);
				myWidgetAccessor.btnNext().setEnabled(true);
				myWidgetAccessor.btnFinish().setEnabled(false);
			break;	
			
			case 3: 
				myWidgetAccessor.btnCancel().setEnabled(true);
				myWidgetAccessor.btnPrevious().setEnabled(true);
				myWidgetAccessor.btnNext().setEnabled(false);
				myWidgetAccessor.btnFinish().setEnabled(true);
			break;	
		}
	}
	
	private boolean isMobile()
	{
		if(Screen.getCurrentDevice().getInput().equals(DeviceAdaptive.Input.touch))
		{
			return true;
		}
		return false;
	}
	
	private void mobileText()
	{
		if(isMobile())
		{
			myWidgetAccessor.labeNext().setText("Slide to start");
		}
	}
	
//	Display buttons in mobile versions
	private void mobileDisplayButtons(boolean statusBtnFinish)
	{
		if(isMobile())
		{
			myWidgetAccessor.btnCancel().setVisible(false);
			myWidgetAccessor.btnPrevious().setVisible(false);
			myWidgetAccessor.btnNext().setVisible(false);
			myWidgetAccessor.btnFinish().setVisible(statusBtnFinish);
			myWidgetAccessor.btnFinish().setEnabled(true);
		}
	}
	
//	cleans the fields of the wizard screens
	private void clearFields()
	{
		myWidgetAccessor.textBoxName().setText(null); 
		myWidgetAccessor.numberBoxAge().setValue(null); 
		myWidgetAccessor.numberCodPhone().setValue(null);
		myWidgetAccessor.numberInitPhone().setValue(null);
		myWidgetAccessor.numberFinalPhone().setValue(null);
		myWidgetAccessor.textBoxProfession().setText(null);
		myWidgetAccessor.numberExperience().setValue(null);
		myWidgetAccessor.radioButtonYears().setValue(true);
		myWidgetAccessor.panelFinish().setVisible(false);		
	}

	/**
	 * Interface that allows to access the widgets of the "slider" view.
	 */
	@BindView("slider")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Slider slider();
		HTMLPanel panelFinish();
		Label labeNext();
		
		TextBox textBoxName();
		NumberTextBox numberBoxAge();
		NumberTextBox numberCodPhone();
		NumberTextBox numberInitPhone();
		NumberTextBox numberFinalPhone();
		
		TextBox textBoxProfession();
		NumberTextBox numberExperience();
		RadioButton radioButtonYears();
		
		Label labelResultName();
		Label labelResultAge();
		Label labelResultPhone();
		Label labelResultProfession();
		Label labelResultExperience();
		
		Button btnCancel();
		Button btnPrevious();
		Button btnNext();
		Button btnFinish();
		
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
