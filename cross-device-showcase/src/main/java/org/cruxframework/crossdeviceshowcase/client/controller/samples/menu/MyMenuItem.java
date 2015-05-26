package org.cruxframework.crossdeviceshowcase.client.controller.samples.menu;

import org.cruxframework.crux.smartfaces.client.image.Image;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class MyMenuItem extends Composite{

	private Image image = new Image();
	private Label label = new Label();
	
	public MyMenuItem(final String text, ImageResource resource)
	{
		FlowPanel wrapper = new FlowPanel();
		
		label.setText(text);
		image.setResource(resource);
		
		label.addStyleName("menuItem-label-style");
		image.addStyleName("menuItem-image-style");
		wrapper.addStyleName("menuItem-wrapper");
		
		wrapper.add(image);
		wrapper.add(label);
		initWidget(wrapper);
	}
	
}
