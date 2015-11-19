package org.cruxframework.crossdeviceshowcase.client.controller.samples.messagebox;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;

@Controller("messageBoxController")
public class MessageBoxController 
{
	private String MESSAGE_TYPE = "This is a message kind: ";
	
	@Expose
	public void showInfo()
	{
		showMessage(MessageType.INFO);
	}
	
	@Expose
	public void showSuccess()
	{
		showMessage(MessageType.SUCCESS);
	}
	
	@Expose
	public void showWarn()
	{
		showMessage(MessageType.WARN);
	}
	
	@Expose
	public void showError()
	{
		showMessage(MessageType.ERROR);
	}
	
	private void showMessage(MessageType type)
	{
		MessageBox.show(MESSAGE_TYPE + type.name(), type);
	}
}
