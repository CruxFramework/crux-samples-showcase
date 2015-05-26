package org.cruxframework.crossdeviceshowcase.client.controller.samples.image;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.image.Image;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.user.client.ui.HTML;

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
	public void detailColosseum()
	{
		myWidgetAccessor.labelInformImage().setText(MESSAGE_COLOSSEUM_TEXT);
		myWidgetAccessor.labelTitleImage().setText(MESSAGE_COLOSSEUM_TITLE);
		myWidgetAccessor.colosseum().setStyleName("faces-Image imageBig");
		myWidgetAccessor.tower().setStyleName("faces-Image imageSmall");
		myWidgetAccessor.statue().setStyleName("faces-Image imageSmall");
	}
		
	@Expose
	public void detailTower()
	{
		myWidgetAccessor.labelInformImage().setText(MESSAGE_TOWER_TEXT);
		myWidgetAccessor.labelTitleImage().setText(MESSAGE_TOWER_TITLE);
		myWidgetAccessor.tower().setStyleName("faces-Image imageBig");
		myWidgetAccessor.colosseum().setStyleName("faces-Image imageSmall");
		myWidgetAccessor.statue().setStyleName("faces-Image imageSmall");
	}
	
	@Expose
	public void detailStatue()
	{
		myWidgetAccessor.labelInformImage().setText(MESSAGE_STATUE_TEXT);
		myWidgetAccessor.labelTitleImage().setText(MESSAGE_STATUE_TITLE);
		myWidgetAccessor.statue().setStyleName("faces-Image imageBig");
		myWidgetAccessor.colosseum().setStyleName("faces-Image imageSmall");
		myWidgetAccessor.tower().setStyleName("faces-Image imageSmall");
	}
	
	@BindView("image")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Image colosseum();
		Image tower();
		Image statue();
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
