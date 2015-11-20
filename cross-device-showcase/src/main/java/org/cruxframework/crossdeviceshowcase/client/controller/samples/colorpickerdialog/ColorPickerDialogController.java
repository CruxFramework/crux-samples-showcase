package org.cruxframework.crossdeviceshowcase.client.controller.samples.colorpickerdialog;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.ViewDeactivateEvent;
import org.cruxframework.crux.core.client.screen.views.ViewDeactivateHandler;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.widgets.client.colorpicker.ColorPickerDialog;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

@Controller("colorPickerDialogController")
public class ColorPickerDialogController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		myWidgetAccessor.labelClickButton().getElement().getStyle().setColor("#1c5994");
		myWidgetAccessor.labelColorValue().setText("Chosen color: "+" #1c5994");
		
		View.of(this).addViewDeactivateHandler(new ViewDeactivateHandler()
		{
			@Override
			public void onDeactivate(ViewDeactivateEvent event)
			{
				if (myWidgetAccessor.colorPicker().isAttached() && myWidgetAccessor.colorPicker().isShowing())
				{ 
					myWidgetAccessor.colorPicker().hide();
				}
			}
		});
	}
	
	@Expose
	public void showColorPicker()
	{
		myWidgetAccessor.colorPicker().show();
		myWidgetAccessor.colorPicker().setPopupPosition(700, 200);
		close();
	}	

	private void close()
	{
		History.addValueChangeHandler(new ValueChangeHandler<String>()
		{
			ColorPickerDialog colorPicker = myWidgetAccessor.colorPicker();
			
			public void onValueChange(ValueChangeEvent<String> event)
			{
				if (colorPicker.isAttached() && colorPicker.isShowing())
				{
					colorPicker.hide();						
				}
			}
		});
	}

	@Expose
	public void changeColor()
	{
		if (myWidgetAccessor.colorPicker().getColor() != null)
		{
			myWidgetAccessor.labelClickButton().getElement().getStyle().setColor("#"+myWidgetAccessor.colorPicker().getColor());
			myWidgetAccessor.labelColorValue().setText("Chosen color: "+" #"+myWidgetAccessor.colorPicker().getColor());
		}
	}

	@BindView("colorPickerDialog")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ColorPickerDialog colorPicker();
		Label labelClickButton();
		Label labelColorValue();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
