package org.cruxframework.crossdeviceshowcase.client.controller.samples.textarea;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.widgets.client.textarea.TextArea;

import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

@Controller("textAreaController")
public class TextAreaController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	private static final String MESSAGE_INVALID_NUMBER = "Please enter a valid integer value such as 50, 73, 95 etc.";
	private static final String MESSAGE_NEGATIVE_NUMBER = "Please enter a positive value.";
	private static final String SUCCESS = "success";
	private static final String WARN = "warn";
	private static final String ERROR = "error";
	private static final String DEFAULT = "default";

	@Expose
	public void onLoad()
	{
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
			MessageBox.show(MESSAGE_INVALID_NUMBER, MessageType.ERROR);
		}
		catch (IllegalArgumentException e1)
		{
			MessageBox.show(MESSAGE_NEGATIVE_NUMBER, MessageType.ERROR);
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
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
