package org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.deviceadaptivegrid.DeviceAdaptiveGrid;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

@Controller("adaptivegridController")
public class AdaptiveGridController
{
	@Inject
	private GridView gridView;
	
	@Inject
	private AdaptiveGridMessages messages;
	
	@Expose
	public void onLoad()
	{
		loadData();

		 /* Insert the component description*/
		gridView.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@SuppressWarnings("unused")
	private void loadData(){
		final DeviceAdaptiveGrid grid = gridView.gridSample();
		PersonDS personDS = (PersonDS) grid.getDataSource();
		List<PersonDTO> personList = new ArrayList<PersonDTO>();
		
		PersonDTO p1 = new PersonDTO("John",67,new Date(),personList,messages.active());
		PersonDTO p2 = new PersonDTO("Bob",37,new Date(),personList,messages.inactive());
		PersonDTO p3 = new PersonDTO("Sam",19,new Date(),personList,messages.active());
		PersonDTO p4 = new PersonDTO("Jack",28,new Date(),personList,messages.inactive());
		PersonDTO p5 = new PersonDTO("Charlie",55,new Date(),personList,messages.active());
		
		PersonDTO p11 = new PersonDTO("Dean",37,new Date(),personList,messages.inactive());
		PersonDTO p12 = new PersonDTO("Crowley",57,new Date(),personList,messages.inactive());
		PersonDTO p13 = new PersonDTO("Rick",39,new Date(),personList,messages.active());
		PersonDTO p14 = new PersonDTO("Darryl",38,new Date(),personList,messages.active());
		PersonDTO p15 = new PersonDTO("Hershel",65,new Date(),personList,messages.inactive());
		
		personDS.setPersons(personList);
		grid.loadData();
		grid.refresh();
	}
	
	@BindView("adaptiveGrid")
	public static interface GridView extends WidgetAccessor
	{
		DeviceAdaptiveGrid gridSample();
		Label labelInfo();
		HTML htmlDescText();
	}

	public void setMessages(AdaptiveGridMessages messages) 
	{
		this.messages = messages;
	}

	public void setGridView(GridView gridView) 
	{
		this.gridView = gridView;
	}
	
}
