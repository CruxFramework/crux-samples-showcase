package org.cruxframework.crossdeviceshowcase.client.controller.samples.datebox;

import java.util.Date;

import org.cruxframework.crossdeviceshowcase.client.util.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.widgets.client.datebox.DateBox;
import org.cruxframework.crux.widgets.client.datepicker.DatePicker;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HTML;

@Controller("dateController")
public class DateController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;

	@Expose
	public void onLoad()
	{
		// Insert the component description
		myWidgetAccessor.componentDescription().setHTML(componentDescription.dateBoxDescription());
		addValueChangeHandlers();
	}

	private void addValueChangeHandlers()
	{
		myWidgetAccessor.dateBox().addValueChangeHandler(new ValueChangeHandler<Date>()
		{
			@Override
			public void onValueChange(ValueChangeEvent<Date> event)
			{
				if(myWidgetAccessor.dateBox().getValue() == null)
				{
					MessageBox.show("Please enter a valid date.", MessageType.WARN);
				}
				else
				{
					MessageBox.show(myWidgetAccessor.dateBox().getValue().toString(), MessageType.INFO);
				}				
			}
		});
		
		myWidgetAccessor.datePicker().addValueChangeHandler(new ValueChangeHandler<Date>()
		{
			@Override
			public void onValueChange(ValueChangeEvent<Date> event)
			{
				MessageBox.show(myWidgetAccessor.datePicker().getValue().toString(), MessageType.INFO);	
			}
		});
	}

	@BindView("date")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		DateBox dateBox();
		DatePicker datePicker();
		HTML componentDescription();
	}
	
	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) 
	{
		this.componentDescription = componentDescription;
	}
}
