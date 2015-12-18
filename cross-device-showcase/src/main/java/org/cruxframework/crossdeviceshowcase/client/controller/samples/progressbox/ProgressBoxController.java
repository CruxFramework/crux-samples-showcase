package org.cruxframework.crossdeviceshowcase.client.controller.samples.progressbox;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.smartfaces.client.dialog.ProgressBox;

import com.google.gwt.user.client.Timer;

@Controller("progressBoxController")
public class ProgressBoxController 
{
	private static int DURATION = 5;
	private ProgressBox progress;
	private int timeLeftToHide = DURATION;
	private Timer timer;	

	@Expose
	public void showProgress()
	{
		progress = ProgressBox.show("");
		progress.setMax(DURATION);
		progress.setValue(DURATION);
		updateTitle();
		timer = new Timer()
		{
			@Override
			public void run()
			{
				timeLeftToHide--;
				progress.setValue(timeLeftToHide);
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
		progress.setMessage("Please wait for " + timeLeftToHide + " seconds...");
	}

	private void hideProgress()
	{
		progress.hide();
		timer.cancel();
		timeLeftToHide = DURATION;
	}
}
