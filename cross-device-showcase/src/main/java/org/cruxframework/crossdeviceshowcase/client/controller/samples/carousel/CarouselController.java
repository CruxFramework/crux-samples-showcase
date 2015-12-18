package org.cruxframework.crossdeviceshowcase.client.controller.samples.carousel;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;

@Controller("carouselController")
public class CarouselController 
{
	@Expose
	public void onLoadData(EagerLoadEvent<Car> event)
	{
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(new Car(0, "Audi", "Germany", 1909));
		cars.add(new Car(1, "BMW", "Germany", 1916));
		cars.add(new Car(2, "Chevrolet", "EUA", 1911));
		cars.add(new Car(3, "Ford", "EUA", 1919));
		cars.add(new Car(4, "GMC", "EUA", 1908));
		cars.add(new Car(5, "Honda Cars", "Japan", 1948));
		cars.add(new Car(6, "Hyundai", "South Korea", 1967));
		cars.add(new Car(7, "Mercedes", "Germany", 1926));
		cars.add(new Car(8, "Mitsubishi", "Japan", 1970));
		cars.add(new Car(9, "Peterbilt", "EUA", 1939));
		cars.add(new Car(10, "Scania", "Sweden", 1891));
		cars.add(new Car(11, "Volkswagen", "Germany", 1937));
		cars.add(new Car(12, "Volvo", "Sweden", 1927));
		cars.add(new Car(13, "Yamaha", "Japan", 1955));
		
		event.getSource().setData(cars);
	}
}
