package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogbox;

import org.cruxframework.crossdeviceshowcase.client.util.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.event.SelectHandler;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

@Controller("dialogBoxController")
public class DialogBoxController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;	
	
	DialogBox dialogBox = new DialogBox();
	
	@Expose
	public void onLoad()
	{
		myWidgetAccessor.componentDescription().setHTML(componentDescription.dialogBoxDescription());
		FlowPanel panel = new FlowPanel();
		panel.setStyleName("dialogBoxPanel");
		
		Label label = new Label("A dialogBox can contain any valid component.");
		
		Button button = new Button("Close", new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
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
	
	@BindView("dialogBox")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
