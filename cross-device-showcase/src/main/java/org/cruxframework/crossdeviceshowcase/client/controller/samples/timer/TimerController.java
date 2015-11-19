package org.cruxframework.crossdeviceshowcase.client.controller.samples.timer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.widgets.client.event.timeout.TimeoutEvent;
import org.cruxframework.crux.widgets.client.event.timeout.TimeoutHandler;
import org.cruxframework.crux.widgets.client.timer.Timer;

@Controller("timerController")
public class TimerController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	private boolean statusStart = false;
	private boolean statusStop = false;
	
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
				MessageBox.show("We get 5 seconds", MessageType.ERROR);
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
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
