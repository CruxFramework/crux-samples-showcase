package org.cruxframework.crossdeviceshowcase.client.controller.samples.rollingpanel;

import org.cruxframework.crux.smartfaces.client.image.Image;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class SaleItem extends Composite{

	static final String DEFAULT_STYLE_NAME = "saleItem";
	private FlowPanel wrapper = new FlowPanel();
	private Label labelText = new Label();
	private Label labelPrice = new Label();

	public SaleItem(final String text, String price, ImageResource imageResource)
	{
		labelText.setText(text);
		labelPrice.setText(price);
		labelPrice.addStyleName("label-price");
		wrapper.addStyleName("saleItem-wrapper-panel");
		wrapper.add(labelText);
		wrapper.add(new Image(imageResource));
		wrapper.add(labelPrice);
		initWidget(wrapper);
		setStyleName(DEFAULT_STYLE_NAME, true);
	}
}
