package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogbox;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.event.SelectHandler;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

@Controller("dialogBoxController")
public class DialogBoxController 
{
	private DialogBox dialogBox = new DialogBox();

	@Expose
	public void onLoad()
	{
		FlowPanel panel = new FlowPanel();
		panel.setStyleName("dialogBoxPanel");

		Label label = new Label("A dialogBox can contain any valid component.");

		Button button = new Button("Close", new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				closeDialog();
			}
		});
		button.setStyleName("crux-Button dialogBoxPanelButton");
		panel.add(label);
		panel.add(button);

		dialogBox.add(panel);
	}

	@Expose
	public void openDialog()
	{		
		dialogBox.setTitle("DialogBox");
		dialogBox.show();
		dialogBox.center();	
	}

	private void closeDialog()
	{
		dialogBox.hide();
	}
}
