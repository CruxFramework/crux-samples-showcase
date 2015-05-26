package org.cruxframework.crossdeviceshowcase.client.controller.samples.colorpickerdialog;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.ViewDeactivateEvent;
import org.cruxframework.crux.core.client.screen.views.ViewDeactivateHandler;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.colorpicker.ColorPickerDialog;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

@Controller("colorPickerDialogController")
public class ColorPickerDialogController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;

	@Expose
	public void onLoad()
	{
		 /* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.colorPickerDialogDescription());

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
