package org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.event.OkEvent;
import org.cruxframework.crux.core.client.event.OkHandler;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.Confirm;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.widgets.client.deviceadaptivegrid.DeviceAdaptiveGrid;
import org.cruxframework.crux.widgets.client.grid.DataRow;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

@Controller("adaptivegridController")
public class AdaptiveGridController
{
	private final String DIALOG_TITLE = "Confirm Your Action";
	private final String SEND_EMAIL = "Send e-mail to ";
	private final String SUCCSESS_EMAIL = "E-mail successfully sent!";
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	/** Calls methods at adaptiveGrid view on Load moment. */
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.adaptivegridDescription());
		
		loadData();
	}
	
	/*Method responsible for populating the grid*/
	@SuppressWarnings("unused")
	private void loadData()
	{
		final DeviceAdaptiveGrid grid = myWidgetAccessor.grid();
		PersonDS personDS = (PersonDS) grid.getDataSource();
		List<PersonDTO> personList = new ArrayList<PersonDTO>();
		
		PersonDTO p1 = new PersonDTO("John D. Onorato",67,new Date(),personList,"active");
		PersonDTO p2 = new PersonDTO("Bob J. Peck",37,new Date(),personList,"inactive");
		PersonDTO p3 = new PersonDTO("Sam A. Payne",19,new Date(),personList,"active");
		PersonDTO p4 = new PersonDTO("Jack J. Worthy",28,new Date(),personList,"inactive");
		PersonDTO p5 = new PersonDTO("Charlie T. Ramer",55,new Date(),personList,"active");
		
		PersonDTO p11 = new PersonDTO("Dean J. Worthy",37,new Date(),personList,"inactive");
		PersonDTO p12 = new PersonDTO("Crowley J. Wardell",57,new Date(),personList,"inactive");
		PersonDTO p13 = new PersonDTO("Rick S. Gerlach",39,new Date(),personList,"active");
		PersonDTO p14 = new PersonDTO("Darryl M. Gray",38,new Date(),personList,"active");
		PersonDTO p15 = new PersonDTO("Hershel J. Murphy",65,new Date(),personList,"inactive");
		
		personDS.setPersons(personList);
		grid.loadData();
		grid.refresh();
	}
	
	/**Method to send email to person of the grid row*/
	@Expose
	public void sendEmail(SelectEvent event)
	{
		DataRow row = myWidgetAccessor.grid().getRow((Widget) event.getSource());
		PersonDTO dto = (PersonDTO) row.getBoundObject();
		Confirm.show(DIALOG_TITLE, SEND_EMAIL + dto.getName()+"?", new OkHandler() 
		{
			@Override
			public void onOk(OkEvent event) 
			{					
				DialogBox.show(new Label(SUCCSESS_EMAIL));
			}
		}, null);		
	}
	
	/**
	 * Interface that allows to access the widgets of the "adaptiveGrid" view.
	 */
	@BindView("adaptiveGrid")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		DeviceAdaptiveGrid grid();
		Label labelInfo();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
