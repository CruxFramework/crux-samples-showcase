package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialogcontainer.DialogViewContainer;

import com.google.gwt.user.client.ui.HTML;

@Controller("dialogViewContainerController")
public class DialogViewContainerController
{
	@Inject
	private ViewDialog viewDialog;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		// Insert the component description
		viewDialog.componentDescription().setHTML(componentDescription.dialogViewContainerDescription());
	}
	
	@Expose
	public void openDialog()
	{	
		viewDialog.dialogViewContainer().loadView("viewRegister", true);
		viewDialog.dialogViewContainer().openDialog();
		viewDialog.dialogViewContainer().center();
	}
	
	@BindView("dialogViewContainer")
	public static interface ViewDialog extends WidgetAccessor
	{
		DialogViewContainer dialogViewContainer();
		HTML componentDescription();
	}

	public void setViewDialog(ViewDialog viewDialog) {
		this.viewDialog = viewDialog;
	}
	
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
