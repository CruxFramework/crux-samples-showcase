package org.cruxframework.crossdeviceshowcase.client.controller.samples.image;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.image.Image;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

@Controller("imageController")
public class ImageController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ImageMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void image1()
	{
		myWidgetAccessor.labelInformImage().setText(messages.informImage1());
		myWidgetAccessor.labelTitleImage().setText(messages.titleImage1());
		myWidgetAccessor.image1().setStyleName("imageStyleBig1");
		myWidgetAccessor.image2().setStyleName("imageStyleSmall2");
		myWidgetAccessor.image3().setStyleName("imageStyleSmall3");
	}
		
	@Expose
	public void image2()
	{
		myWidgetAccessor.labelInformImage().setText(messages.informImage2());
		myWidgetAccessor.labelTitleImage().setText(messages.titleImage2());
		myWidgetAccessor.image2().setStyleName("imageStyleBig2");
		myWidgetAccessor.image1().setStyleName("imageStyleSmall1");
		myWidgetAccessor.image3().setStyleName("imageStyleSmall3");
	}
	
	@Expose
	public void image3()
	{
		myWidgetAccessor.labelInformImage().setText(messages.informImage3());
		myWidgetAccessor.labelTitleImage().setText(messages.titleImage3());
		myWidgetAccessor.image3().setStyleName("imageStyleBig3");
		myWidgetAccessor.image1().setStyleName("imageStyleSmall1");
		myWidgetAccessor.image2().setStyleName("imageStyleSmall2");
	}
	
	@BindView("image")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Image image1();
		Image image2();
		Image image3();
		Label labelTitleImage();
		Label labelInformImage();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(ImageMessages messages) {
		this.messages = messages;
	}
}
