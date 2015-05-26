package org.cruxframework.crossdeviceshowcase.client.controller.samples.progressbox;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.widgets.client.dialog.ProgressBox;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;

@Controller("progressBoxController")
public class ProgressBoxController 
{
	@Inject
	private ProgressBoxMessages messages;

	private static int DURATION = 5;
	private ProgressBox progress;
	private int timeLeftToHide = DURATION;
	private Timer timer;	

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		HTML widgetHtml= View.of(this).getWidget("htmlDescText", HTML.class);
		widgetHtml.setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void showProgress()
	{
		progress = ProgressBox.show("");		
		updateTitle();

		timer = new Timer()
		{
			@Override
			public void run()
			{
				timeLeftToHide--;

				if(timeLeftToHide == 0)
				{
					hideProgress();
				}
				else
				{
					updateTitle();
				}
			}
		};

		timer.scheduleRepeating(1000);
	}

	private void updateTitle()
	{
		progress.setMessage(messages.pleaseWait() + timeLeftToHide + messages.seconds());
	}

	private void hideProgress()
	{
		progress.hide();
		timer.cancel();
		timeLeftToHide = DURATION;
	}

	public void setMessages(ProgressBoxMessages messages) 
	{
		this.messages = messages;
	}
}
