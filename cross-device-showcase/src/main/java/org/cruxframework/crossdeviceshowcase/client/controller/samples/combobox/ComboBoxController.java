package org.cruxframework.crossdeviceshowcase.client.controller.samples.combobox;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import com.google.gwt.user.client.ui.FlowPanel;

@Controller("comboBoxController")
public class ComboBoxController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoadData(EagerLoadEvent<Country> event)
	{
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(new Country(0, "Algeria", "Argel"));
		countries.add(new Country(1, "Argentina", "Buenos Aires"));
		countries.add(new Country(2, "Australia", "Camberra"));
		countries.add(new Country(3, "Brazil", "Brasília"));
		countries.add(new Country(4, "Canada", "Ottawa"));
		countries.add(new Country(5, "Chile", "Santiago"));
		countries.add(new Country(6, "China", "Pequim"));
		countries.add(new Country(7, "CostaRica", "San José"));
		countries.add(new Country(8, "France", "Paris"));
		countries.add(new Country(9, "Germany", "Berlim"));
		countries.add(new Country(10, "Italy", "Roma"));
		countries.add(new Country(11, "Japan", "Tóquio"));
		countries.add(new Country(12, "Mexico", "México"));
		countries.add(new Country(13, "Morocco", "Rabat"));
		countries.add(new Country(14, "South Africa", "Pretória, Cabo, Bloemfontein"));
		countries.add(new Country(15, "South Korea", "Seul"));
		countries.add(new Country(16, "Spain", "Madri"));
		countries.add(new Country(17, "USA", "Washington, D.C."));
		event.getSource().setData(countries);
	}

	@BindView("comboBox")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		FlowPanel innerPanel();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
