package org.cruxframework.crossdeviceshowcase.client.controller.samples.numbertextbox;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.storyboard.Storyboard;
import org.cruxframework.crux.widgets.client.textbox.NumberTextBox;

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
		myWidgetAccessor.boxNumber().setMaxLength(valueMaxLength());
	}
	
	private int valueMaxLength()
	{
		if (myWidgetAccessor.radioButton09().getValue())
		{
			return 1;
		} else if(myWidgetAccessor.radioButton099().getValue())
		{
			return 2;
		}else if(myWidgetAccessor.radioButton0999().getValue())
		{
			return 3;
		}else
		{
			return 524288;
		}
	}
	
	@BindView("numberTextBox")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Storyboard radios();
		NumberTextBox boxNumber();
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
