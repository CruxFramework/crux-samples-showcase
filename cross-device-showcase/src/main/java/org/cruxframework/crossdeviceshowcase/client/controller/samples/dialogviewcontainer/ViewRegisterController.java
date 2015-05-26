package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.styledpanel.StyledPanel;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

@Controller("viewRegisterController")
public class ViewRegisterController
{
	@Inject
	private ViewRegister viewRegister;
	
	@Expose
	public void showResult()
	{
		if(!viewRegister.txtName().getText().isEmpty() && 
		   !viewRegister.txtEmail().getText().isEmpty() &&
		   !viewRegister.txtAddress().getText().isEmpty())
		{
			viewRegister.formPanel().setVisible(false);
			viewRegister.labelText().setVisible(false);
			viewRegister.panelError().setVisible(false);
			viewRegister.panelResult().setVisible(true);
			viewRegister.labelResultName().setText("Name: "+viewRegister.txtName().getText());
			viewRegister.labelResultEmail().setText("E-mail: "+viewRegister.txtEmail().getText());
			viewRegister.labelResultAddress().setText("Address: "+viewRegister.txtAddress().getText());
		}else
		{
			viewRegister.panelError().setVisible(true);
		}
	}
	
	@BindView("viewRegister")
	public static interface ViewRegister extends WidgetAccessor
	{
		Label labelText();
		TextBox txtName();
		TextBox txtEmail();
		TextBox txtAddress();
		
		StyledPanel formPanel();
		HTMLPanel panelError();
		HTMLPanel panelResult();
		
		Label labelResult();
		Label labelResultName();
		Label labelResultEmail();
		Label labelResultAddress();
	}

	public void setViewRegister(ViewRegister viewRegister) {
		this.viewRegister = viewRegister;
	}

}
