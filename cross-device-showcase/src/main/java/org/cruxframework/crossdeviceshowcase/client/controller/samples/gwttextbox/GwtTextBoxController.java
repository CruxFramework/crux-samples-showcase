package org.cruxframework.crossdeviceshowcase.client.controller.samples.gwttextbox;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

@Controller("gwtTextBoxController")
public class GwtTextBoxController 
{
	@Inject
	private DescriptionMessages componentDescription;
	
	@Inject 
	private MyWidgetAccessor myWidgetAccessor;
	
	private Widget getGwtTxtBox()
	{
		Widget textbox = View.of(this).getWidget("gwtTxtBox");
		return textbox;
	}

	private void setState(String state)
	{
		Widget textbox = this.getGwtTxtBox();

		textbox.removeStyleName("success");
		textbox.removeStyleName("warn");
		textbox.removeStyleName("error");
		textbox.setStyleName("gwt-TextBox w200 " + state);
	}

	@Expose
	public void handleDefault()
	{
		this.setState("");
	}

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.textBoxDescription());
		
		Widget textbox = this.getGwtTxtBox();
		/*
		 * It seems that GWT don't support the class appending via View,
		 * so we have to add the styleName from here.
		 * */
		textbox.setStyleName("gwt-TextBox w200");
	}

	@Expose
	public void handleSuccess()
	{
		this.setState("success");
	}

	@Expose
	public void handleWarning()
	{
		this.setState("warn");
	}

	@Expose
	public void handleError()
	{
		this.setState("error");
	}
	
	@BindView("gwtTextBox")
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
