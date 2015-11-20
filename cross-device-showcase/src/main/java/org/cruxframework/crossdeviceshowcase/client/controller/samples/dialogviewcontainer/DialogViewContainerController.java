package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.DialogViewContainer;

@Controller("dialogViewContainerController")
public class DialogViewContainerController
{
	@Inject
	private ViewDialog viewDialog;
	
	@Expose
	public void openDialog()
	{	
		viewDialog.dialogViewContainer().loadView("viewRegister", true);
		viewDialog.dialogViewContainer().show();
		viewDialog.dialogViewContainer().center();
	}
	
	@BindView("dialogViewContainer")
	public static interface ViewDialog extends WidgetAccessor
	{
		DialogViewContainer dialogViewContainer();
	}

	public void setViewDialog(ViewDialog viewDialog) 
	{
		this.viewDialog = viewDialog;
	}
}
