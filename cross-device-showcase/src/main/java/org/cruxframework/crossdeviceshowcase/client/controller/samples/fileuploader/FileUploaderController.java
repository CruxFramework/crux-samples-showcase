package org.cruxframework.crossdeviceshowcase.client.controller.samples.fileuploader;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;

import com.google.gwt.user.client.ui.HTML;

@Controller("fileUploaderController")
public class FileUploaderController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private FileUploaderMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@BindView("fileUploader")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(FileUploaderMessages messages) {
		this.messages = messages;
	}
	
}
