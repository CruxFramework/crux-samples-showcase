package org.cruxframework.crossdeviceshowcase.client.controller.samples.progressbox;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
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
	private DescriptionMessages componentDescription;

	private static int DURATION = 5;
	private ProgressBox progress;
	private int timeLeftToHide = DURATION;
	private Timer timer;	

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		HTML widgetHtml= View.of(this).getWidget("componentDescription", HTML.class);
		widgetHtml.setHTML(componentDescription.progressBoxDescription());
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
		progress.setMessage("Please wait for " + timeLeftToHide + " seconds...");
	}

	private void hideProgress()
	{
		progress.hide();
		timer.cancel();
		timeLeftToHide = DURATION;
	}
	
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
