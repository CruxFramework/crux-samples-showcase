package org.cruxframework.crossdeviceshowcase.client.controller.samples.textarea;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.textarea.TextArea;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

@Controller("textAreaController")
public class TextAreaController 
{
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	private String MESSAGE_INVALID_NUMBER;
	private String MESSAGE_NEGATIVE_NUMBER;
	private static final String SUCCESS = "success";
	private static final String WARN = "warn";
	private static final String ERROR = "error";
	private static final String DEFAULT = "default";

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.textAreaDescription());
		
		MESSAGE_INVALID_NUMBER = "Please enter a valid integer value such as 50, 73, 95 etc.";
		MESSAGE_NEGATIVE_NUMBER = "Please enter a positive value.";

		applyMaxLength();	
	}

	@Expose
	public void applyMaxLength()
	{
		try
		{
			myWidgetAccessor.textArea().setMaxLength(valueMaxLenght());
		}
		catch (NumberFormatException e)
		{
			FlatMessageBox.show(MESSAGE_INVALID_NUMBER, MessageType.ERROR);
		}
		catch (IllegalArgumentException e1)
		{
			FlatMessageBox.show(MESSAGE_NEGATIVE_NUMBER, MessageType.ERROR);
		}
	}

	private int valueMaxLenght()
	{
		return Integer.parseInt(myWidgetAccessor.textBox().getText());
	}
	
	@Expose
	public void setChosenStyle()
	{
		if (myWidgetAccessor.radioSuccess().getValue())
		{
			setState(SUCCESS);
		} else if(myWidgetAccessor.radioWarning().getValue())
		{
			setState(WARN);
		}else if(myWidgetAccessor.radioError().getValue())
		{
			setState(ERROR);
		}else
		{
			setState(DEFAULT);
		}
	}
	
	@Expose
	public void teste()
	{
		setState(ERROR);
	}
	
	private void setState(String state)
	{	
		myWidgetAccessor.textArea().removeStyleName("success");
		myWidgetAccessor.textArea().removeStyleName("warn");
		myWidgetAccessor.textArea().removeStyleName("error");
		myWidgetAccessor.textArea().setStyleName("gwt-TextArea " + state);
	}

	@BindView("textArea")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		TextArea textArea();
		TextBox textBox();

		RadioButton radioSuccess();
		RadioButton radioWarning();
		RadioButton radioError();
		
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
