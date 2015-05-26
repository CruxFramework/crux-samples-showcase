package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.styledpanel.StyledPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

public class StoryboardItem extends Composite{
	
	/*
	 * Note that in this example we "simulate" a image.
	 * In real applications you can use Image() instead of FlowPanel().
	 */

	private FlowPanel image = new FlowPanel();
	private StyledPanel wrapper = new StyledPanel();	
	private Label labelName = new Label();
	private Label labelPrice = new Label();
	private Button button = new Button();
	private String url;
	private HTMLPanel htmlPanel = new HTMLPanel(url); 

	public StoryboardItem(final String clickedMsg, String name, String price, String textButton)
	{
		initWidget(wrapper);

		wrapper.add(htmlPanel);

		htmlPanel.add(image);
		htmlPanel.add(labelName);
		htmlPanel.add(labelPrice);
		htmlPanel.add(button);	

		this.addStyleNames();

		/*
		 * In real applications this is how you would
		 * set a url for the Image()
		 */
		//image.setUrl(url);

		labelName.setText(name);
		labelPrice.setText(price);
		button.setText(textButton);

		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event) 
			{
				FlatMessageBox.show(clickedMsg, MessageType.INFO);
			}
		});
	}

	private void addStyleNames()
	{
		wrapper.addStyleName("storeItem");
		htmlPanel.addStyleName("cf");
		image.addStyleName("productImage");
		labelName.removeStyleName("gwt-Label");
		labelName.addStyleName("productName");
		labelPrice.removeStyleName("gwt-Label");
		labelPrice.addStyleName("productPrice");
		button.addStyleName("productButton");
	}
}
