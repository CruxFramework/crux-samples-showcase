package org.cruxframework.crossdeviceshowcase.client.controller.samples.confirm;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.Confirm;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.user.client.ui.TextBox;

@Controller("confirmController")
public class ConfirmController 
{
	private Byte status = 0;
	private static final String MESSAGE_NAME = "Are you sure that want send your name?";
	private static final String MESSAGE_NAME_EMPTY = "Are you sure that want send your name empty?";
	private static final String MESSAGE_CLEAR_TEXT = "Are you sure that want clear text?";
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	/**Shows confirm dialog with informations according to status value*/
	@Expose
	public void showDialog()
	{
		if(status == 0)
		{
			if(myWidgetAccessor.textBoxName().getText().equals(""))
			{
				myWidgetAccessor.confirm().setMessage(MESSAGE_NAME_EMPTY);
			}
			else 
			{
				myWidgetAccessor.confirm().setMessage(MESSAGE_NAME);
			}
		}
		else
		{
			myWidgetAccessor.confirm().setMessage(MESSAGE_CLEAR_TEXT);
		}
			myWidgetAccessor.confirm().center();
			myWidgetAccessor.confirm().show();
	}
	
	/**Calls method according to status value*/
	@Expose
	public void launchAction()
	{
		if(status == 0)
		{
			sendName();
		}
		else
		{
			clearLabel();
		}
	}
	
	private void sendName()
	{		
		myWidgetAccessor.textBoxName().setVisible(false);
		myWidgetAccessor.labelName().setText("Your name is: "+myWidgetAccessor.textBoxName().getText());
		myWidgetAccessor.btnAction().setText("Clear text");
		status = 1;
	}
	
	private void clearLabel()
	{
		myWidgetAccessor.labelName().setText("");
		myWidgetAccessor.textBoxName().setText("");
		myWidgetAccessor.textBoxName().setVisible(true);
		myWidgetAccessor.btnAction().setText("Send Name");
		status = 0;
	}

	/**
	 * Interface that allows to access the widgets of the "confirm" view.
	 */
	@BindView("confirm")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Confirm confirm();
		Button btnAction();
		Label labelName();
		TextBox textBoxName();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
