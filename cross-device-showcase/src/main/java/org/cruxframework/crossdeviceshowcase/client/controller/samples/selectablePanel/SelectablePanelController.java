package org.cruxframework.crossdeviceshowcase.client.controller.samples.selectablePanel;

import org.cruxframework.crossdeviceshowcase.client.util.StyleHelper;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.panel.SelectablePanel;

@Controller("selectablePanelController")
public class SelectablePanelController
{
	@Inject
	private MyWidgets myWidgets;
	
	@BindView("selectablePanel")
	public interface MyWidgets extends WidgetAccessor
	{
		SelectablePanel selectablePanel();
	}

	private void handleStates(String state)
	{
		StyleHelper.getInstance().changeWidgetState(myWidgets.selectablePanel(), state);
	}

	@Expose
	public void setStateDefault()
	{	
		handleStates("default");
	}

	@Expose
	public void setStateSuccess()
	{
		handleStates("success");
	}

	@Expose
	public void setStateWarning()
	{
		handleStates("warn");
	}

	@Expose
	public void setStateError()
	{
		handleStates("error");
	}
	
	public void setMyWidgets(MyWidgets myWidgets) 
	{
		this.myWidgets = myWidgets;
	}
}
