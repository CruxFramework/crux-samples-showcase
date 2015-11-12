package org.cruxframework.crossdeviceshowcase.client.controller.samples.combobox;

import java.util.ArrayList;

import org.cruxframework.crossdeviceshowcase.client.util.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

@Controller("comboBoxController")
public class ComboBoxController {
	
	@Inject
	private DescriptionMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(messages.comboBoxDescription());		
	}
	
	@Expose
	public void onLoadData(EagerLoadEvent<Country> event)
	{
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(new Country("Algeria", "Argel"));
		countries.add(new Country("Argentina", "Buenos Aires"));
		countries.add(new Country("Australia", "Camberra"));
		countries.add(new Country("Brazil", "Brasília"));
		countries.add(new Country("Canada", "Ottawa"));
		countries.add(new Country("Chile", "Santiago"));
		countries.add(new Country("China", "Pequim"));
		countries.add(new Country("CostaRica", "San José"));
		countries.add(new Country("France", "Paris"));
		countries.add(new Country("Germany", "Berlim"));
		countries.add(new Country("Italy", "Roma"));
		countries.add(new Country("Japan", "Tóquio"));
		countries.add(new Country("Mexico", "México"));
		countries.add(new Country("Morocco", "Rabat"));
		countries.add(new Country("South Africa", "Pretória, Cabo, Bloemfontein"));
		countries.add(new Country("South Korea", "Seul"));
		countries.add(new Country("USA", "Washington, D.C."));
		event.getSource().setData(countries);
	}

	@BindView("comboBox")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		FlowPanel innerPanel();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(DescriptionMessages messages) 
	{
		this.messages = messages;
	}
}
