package org.cruxframework.crossdeviceshowcase.client.controller.samples.downloadbutton;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.encoder.Base64;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.DownloadButton;
import org.cruxframework.crux.widgets.client.button.DownloadButton.DownloadInfo;

@Controller("downloadButtonController")
public class DownloadButtonController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void download()
	{
		myWidgetAccessor.downloadButton().fireDownload(new DownloadInfo() 
		{
			@Override
			public String getFilename() 
			{
				String filename = "downloadTest.txt";
				return filename;
			}
			
			@Override
			public String getBase64Data() 
			{
				String base64Data = "data:text/plain;base64," + Base64.encode(new String("This is a sample text!"));
				return base64Data;
			}
		});
    }

	@BindView("downloadButton")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		DownloadButton downloadButton();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
