package org.cruxframework.crossdeviceshowcase.client.controller.samples.widgetlist;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;

@Controller("widgetListController")
public class WidgetListController 
{
	@Expose
	public void onLoadData(EagerLoadEvent<Car> event)
	{
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(new Car("Audi", "Germany", 1909));
		cars.add(new Car("BMW", "Germany", 1916));
		cars.add(new Car("Chevrolet", "EUA", 1911));
		cars.add(new Car("Ford", "EUA", 1919));
		cars.add(new Car("GMC", "EUA", 1908));
		cars.add(new Car("Honda Cars", "Japan", 1948));
		cars.add(new Car("Hyundai", "South Korea", 1967));
		cars.add(new Car("Mercedes", "Germany", 1926));
		cars.add(new Car("Peterbilt", "EUA", 1939));
		cars.add(new Car("Scania", "Sweden", 1891));
		cars.add(new Car("Volkswagen", "Germany", 1937));
		cars.add(new Car("Volvo", "Sweden", 1927));
		cars.add(new Car("Yamaha", "Japan", 1955));
		cars.add(new Car("Honda", "Japan", 1948));
		cars.add(new Car("Mitsubishi", "Japan", 1970));
		
		event.getSource().setData(cars);
	}
}
