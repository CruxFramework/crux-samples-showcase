package org.cruxframework.crossdeviceshowcase.client.controller.samples.numbertextbox;

import org.cruxframework.crossdeviceshowcase.client.util.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.input.NumberBox;
import org.cruxframework.crux.widgets.client.storyboard.Storyboard;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;

@Controller("numberTextBoxController")
public class NumberTextBoxController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.numberTextBoxDescription());
		
		maxLength();
		myWidgetAccessor.boxNumber().setValue(225);
	}
	
	@Expose
	public void maxLength()
	{
		myWidgetAccessor.boxNumber().setValue(null);
		myWidgetAccessor.boxNumber().setMaxValue(valueMaxLength());
	}
	
	private int valueMaxLength()
	{
		if (myWidgetAccessor.radioButton09().getValue())
		{
			return 9;
		} 
		else if(myWidgetAccessor.radioButton099().getValue())
		{
			return 99;
		}
		else if(myWidgetAccessor.radioButton0999().getValue())
		{
			return 999;
		}
		else
		{
			return Integer.MAX_VALUE;
		}
	}
	
	@BindView("numberTextBox")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Storyboard radios();
		NumberBox boxNumber();
		HTML componentDescription();
		
		RadioButton radioButton09();
		RadioButton radioButton099();
		RadioButton radioButton0999();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
