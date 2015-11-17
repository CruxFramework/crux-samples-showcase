package org.cruxframework.showcasecore.client.util;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.cruxframework.crux.core.client.css.animation.Animation.Callback;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.event.SelectHandler;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.util.animation.InOutAnimation;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.logging.client.TextLogFormatter;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class VisualBoxLogHandler extends Handler 
{
	private static InOutAnimation animationLogEntries = InOutAnimation.fade;
	private static InOutAnimation animationEnableDisable = InOutAnimation.slideRight;
	private static final Button close = new Button();
	private static FlowPanel logEntries = new FlowPanel();
	private static FlowPanel logWrapper = new FlowPanel();
	private static final Button open = new Button();
	static
	{
		open.addStyleName("openLogButton");
		close.addStyleName("closeLogButton");

		close.addSelectHandler(new SelectHandler()
		{
			@Override
			public void onSelect(SelectEvent event)
			{
				animationEnableDisable.animateExit(logWrapper, new Callback()
				{
					@Override
					public void onAnimationCompleted()
					{
						close.setVisible(false);
						open.setVisible(true);
						logEntries.setVisible(false);
					}
				});
			}
		});

		open.addSelectHandler(new SelectHandler()
		{
			@Override
			public void onSelect(SelectEvent event)
			{
				logEntries.setVisible(true);
				open.setVisible(false);
				animationEnableDisable.animateEntrance(logWrapper, new Callback()
				{
					@Override
					public void onAnimationCompleted()
					{
						close.setVisible(true);
					}
				});
			}
		});

		logEntries.addStyleName("entriesWrapper");
		logWrapper.addStyleName("logWrapper");
		FlowPanel wrapperButtons = new FlowPanel();
		wrapperButtons.add(open);
		wrapperButtons.add(close);
		logWrapper.add(wrapperButtons);
		FlowPanel wrapperLog = new FlowPanel();
		wrapperLog.add(logEntries);
		logWrapper.add(wrapperLog);

		RootPanel.get().add(logWrapper);

		if(Screen.getCurrentDevice().equals(Device.smallDisplayArrows)
			|| Screen.getCurrentDevice().equals(Device.smallDisplayTouch))
		{
			close.setVisible(false);
			open.setVisible(true);
			logEntries.setVisible(false);
		}
		else
		{
			close.setVisible(true);
			open.setVisible(false);
			logEntries.setVisible(true);
		}

		Scheduler.get().scheduleFixedDelay(new RepeatingCommand()
		{
			@Override
			public boolean execute()
			{
				Widget widget = null;
				
				if(logEntries.getWidgetCount() <= 0)
				{
					return true;
				}
				
				widget = logEntries.getWidget(0);
				
				if(!open.isVisible())
				{
					close.setVisible(true);
				}

				animationLogEntries.animateExit(widget, new Callback()
				{
					@Override
					public void onAnimationCompleted()
					{
						try
						{
							logEntries.remove(0);
							
							if(logEntries.getWidgetCount() <= 0)
							{
								close.setVisible(false);
							}
							
						} catch (IndexOutOfBoundsException e)
						{
							//do nothing
						}
					}
				});

				return true;
			}
		}, 3000);
	}

	public VisualBoxLogHandler(String enableLogMessage, String disableLogMessage) 
	{
		open.setText(enableLogMessage);
		close.setText(disableLogMessage);
		setFormatter(new TextLogFormatter(true));
		setLevel(Level.INFO);
	}

	@Override
	public void close() 
	{
		// No action needed
	}

	@Override
	public void flush() 
	{
		// No action needed
	}

	@Override
	public void publish(LogRecord record)
	{
		if (!isLoggable(record)) 
		{
			return;
		}

		while(logEntries.getWidgetCount() > 5)
		{
			logEntries.remove(0);
		}

		if(!open.isVisible())
		{
			close.setVisible(true);
		}
		
		final FlowPanel wrapperEntry = new FlowPanel(); 
		wrapperEntry.addStyleName("logEntry");
		Label label = new Label();
		label.setText(record.getMessage());
		wrapperEntry.add(label);
		logEntries.add(wrapperEntry);
		animationLogEntries.animateEntrance(wrapperEntry, new Callback()
		{
			@Override
			public void onAnimationCompleted()
			{

			}
		});
	}
}