package org.cruxframework.crossdeviceshowcase.client.controller.samples.pagers;

import org.cruxframework.crux.core.client.collection.Array;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerPagedDataProvider;
import org.cruxframework.crux.core.client.factory.WidgetFactory;
import org.cruxframework.crux.smartfaces.client.list.WidgetList;
import org.cruxframework.crux.smartfaces.client.pager.BulletsPager;
import org.cruxframework.crux.smartfaces.client.pager.PredictivePager;
import org.cruxframework.crux.smartfaces.client.pager.SequentialPager;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

@Controller("myController")
public class MyController 
{
	@Expose
	public void onLoad()
	{
		EagerPagedDataProvider<Person> dataProvider = new EagerPagedDataProvider<Person>();
		dataProvider.setData(myPeopleList());
		
		WidgetList<Person> widgetList = new WidgetList<Person>(new WidgetFactory<Person>()
		{
			@Override
			public IsWidget createWidget(Person value)
			{
				return new Label(value.getName());
			}
		});
		
		widgetList.setDataProvider(dataProvider, true);
		
		SequentialPager<Person> sequentialPager = new SequentialPager<Person>();
		sequentialPager.setDataProvider(dataProvider, true);
		
		BulletsPager<Person> bulletsPager = new BulletsPager<Person>();
		bulletsPager.setDataProvider(dataProvider, true);
		
		PredictivePager<Person> predictivePager = new PredictivePager<Person>();
		predictivePager.setDataProvider(dataProvider, true);
		
		RootPanel.get().add(widgetList);
		RootPanel.get().add(sequentialPager);
		RootPanel.get().add(bulletsPager);
		RootPanel.get().add(predictivePager);
	
	}
	
	private Array<Person> myPeopleList()
	{
		return null;
	}
}
