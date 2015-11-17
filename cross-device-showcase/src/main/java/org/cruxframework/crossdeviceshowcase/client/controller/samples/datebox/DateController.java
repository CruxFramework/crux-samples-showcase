package org.cruxframework.crossdeviceshowcase.client.controller.samples.datebox;

import java.util.Date;
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

@Controller("dateController")
public class DateController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
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
	}
	
	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
