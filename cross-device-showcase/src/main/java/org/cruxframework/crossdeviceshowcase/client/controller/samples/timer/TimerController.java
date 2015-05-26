package org.cruxframework.crossdeviceshowcase.client.controller.samples.timer;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.event.timeout.TimeoutEvent;
import org.cruxframework.crux.widgets.client.event.timeout.TimeoutHandler;
import org.cruxframework.crux.widgets.client.timer.Timer;

import com.google.gwt.user.client.ui.HTML;

@Controller("timerController")
public class TimerController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	private boolean statusStart = false;
	private boolean statusStop = false;
	
	@Expose
	public void onLoad()
	{
		//Insert the component description
		myWidgetAccessor.componentDescription().setHTML(componentDescription.timerDescription());
	}

	@Expose
	public void start()
	{
		warnTime();
		myWidgetAccessor.timer().reset();
		statusStart = true;
		statusStop = false;
		changeStatusButton();
	}
	
	@Expose
	public void warnTime()
	{
		myWidgetAccessor.timer().addTimeoutHandler(new TimeoutHandler() 
		{
			@Override
			public void onTimeout(TimeoutEvent event) 
			{
				FlatMessageBox.show("We get 5 seconds", MessageType.ERROR);
			}
			
			@Override
			public long getScheduledTime() {
				return 5;
			}
		});
	}
	
	@Expose
	public void stopAndRestart()
	{
		if(statusStart == true && statusStop == false)
		{
			myWidgetAccessor.timer().stop();
			statusStart = false;
			statusStop = true;
			changeStatusButton();
		}else if(statusStart == false && statusStop == true)
		{
			myWidgetAccessor.timer().start();
			statusStart = true;
			statusStop = false;
			changeStatusButton();
		}
	}
	
	@Expose
	public void clear()
	{
		myWidgetAccessor.timer().clear();
		statusStop = false;
		statusStart = false;
		changeStatusButton();
	}
	
	private void changeStatusButton()
	{
		if(statusStart == true && statusStop == false)
		{
			myWidgetAccessor.buttonStop().setText("Stop");
		}else if(statusStart == false && statusStop == true)
		{
			myWidgetAccessor.buttonStop().setText("Restart");
		}else
		{
			myWidgetAccessor.buttonStop().setText("Stop");
		}
	}
	
	@BindView("timer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Timer timer();
		Button buttonStop();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
