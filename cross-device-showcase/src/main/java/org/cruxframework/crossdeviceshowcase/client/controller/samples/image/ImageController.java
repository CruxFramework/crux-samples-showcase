package org.cruxframework.crossdeviceshowcase.client.controller.samples.image;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
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
	private DescriptionMessages componentDescription;
	
	private String MESSAGE_COLOSSEUM_TEXT;
	private String MESSAGE_COLOSSEUM_TITLE;
	private String MESSAGE_STATUE_TEXT;
	private String MESSAGE_STATUE_TITLE;
	private String MESSAGE_TOWER_TEXT;
	private String MESSAGE_TOWER_TITLE;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.imageDescription());
		
		MESSAGE_COLOSSEUM_TITLE = "Colosseum - Italy";
		
		MESSAGE_COLOSSEUM_TEXT = "Coliseum is an amphitheater built in the period of ancient Rome. "
				+ "Located in central Rome, 48 meters high, was able to house some 50,000 people.";
		
		MESSAGE_STATUE_TITLE = "Statue of Liberty - United States";
		
		MESSAGE_STATUE_TEXT = "Statue of Liberty is a monument built on Liberty Island in New York City. Opened in 1886, "
				+ "the monument commemorates the centennial of the signing of the Declaration of American Independence.";
		
		MESSAGE_TOWER_TEXT = "Eiffel Tower is a nineteenth-century iron lattice tower located on the Champ de Mars in Paris. "
				+ "It is the tallest building in Paris, is the most visited paid monument in the world.";
		
		MESSAGE_TOWER_TITLE = "Eiffel Tower - France";
	}
	
	@Expose
	public void image1()
	{
		myWidgetAccessor.labelInformImage().setText(MESSAGE_COLOSSEUM_TEXT);
		myWidgetAccessor.labelTitleImage().setText(MESSAGE_COLOSSEUM_TITLE);
		myWidgetAccessor.image1().setStyleName("imageStyleBig1");
		myWidgetAccessor.image2().setStyleName("imageStyleSmall2");
		myWidgetAccessor.image3().setStyleName("imageStyleSmall3");
	}
		
	@Expose
	public void image2()
	{
		myWidgetAccessor.labelInformImage().setText(MESSAGE_TOWER_TEXT);
		myWidgetAccessor.labelTitleImage().setText(MESSAGE_TOWER_TITLE);
		myWidgetAccessor.image2().setStyleName("imageStyleBig2");
		myWidgetAccessor.image1().setStyleName("imageStyleSmall1");
		myWidgetAccessor.image3().setStyleName("imageStyleSmall3");
	}
	
	@Expose
	public void image3()
	{
		myWidgetAccessor.labelInformImage().setText(MESSAGE_STATUE_TEXT);
		myWidgetAccessor.labelTitleImage().setText(MESSAGE_TOWER_TITLE);
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
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
