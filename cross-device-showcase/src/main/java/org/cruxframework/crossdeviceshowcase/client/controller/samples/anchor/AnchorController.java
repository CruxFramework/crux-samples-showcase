package org.cruxframework.crossdeviceshowcase.client.controller.samples.anchor;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.widgets.client.anchor.Anchor;

import com.google.gwt.user.client.ui.TextBox;

@Controller("anchorController")
public class AnchorController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void openUrl()
	{
		String url = myWidgetAccessor.textBoxUrl().getText();
		
		if (url != null)
		{
			myWidgetAccessor.anchor().setHref(url);
			myWidgetAccessor.anchor().setTarget("_self");
			myWidgetAccessor.anchor().select();
		}
	}
	
	@Expose
	public void pgEnd()
	{
		MessageBox.show("Going to the Bottom of page", MessageType.INFO);
	}
	
	@Expose
	public void pgHome()
	{
		MessageBox.show("Going to the Top of page", MessageType.INFO);
	}

	@BindView("anchor")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Anchor anchor();
		TextBox textBoxUrl();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
