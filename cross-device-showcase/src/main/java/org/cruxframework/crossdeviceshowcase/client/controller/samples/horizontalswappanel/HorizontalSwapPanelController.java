package org.cruxframework.crossdeviceshowcase.client.controller.samples.horizontalswappanel;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.image.Image;
import org.cruxframework.crux.widgets.client.swappanel.HorizontalSwapPanel;
import org.cruxframework.crux.widgets.client.swappanel.HorizontalSwapPanel.Direction;
import org.cruxframework.crux.widgets.client.textarea.TextArea;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

@Controller("horizontalSwapPanelController")
public class HorizontalSwapPanelController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private HorizontalSwapPanelMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void showImage()
	{
//		Image image = new Image();
//		ImageResourceHorizontalSwapPanel imageResource = new ImageResourceHorizontalSwapPanel();
//		image.setResource(imageResource);
//		//image.setUrl("https://www.google.com.br/images/srpr/logo11w.png");
//		myWidgetAccessor.swapPanel().transitTo(image, Direction.FORWARD);
	}
	
	@Expose
	public void showButton()
	{
		Button button = new Button();
		button.setText("Eu sou um botão");
		myWidgetAccessor.swapPanel().transitTo(button, Direction.FORWARD);
	}
	
	@Expose
	public void showPanel()
	{
		FlowPanel panel = new FlowPanel();
		panel.setWidth("400px");
		panel.setHeight("400px");	
		
		Label label = new Label();
		label.setText("Este é um painel contendo um Label, um TextArea e um Botão.");
		
		TextArea textArea = new TextArea();
		textArea.setText("Eu sou o TextArea do painel");
		textArea.setReadOnly(true);
		
		Button panelButton = new Button();
		panelButton.setText("Eu sou o botão de um painel");
		
		panel.add(label);
		panel.add(textArea);
		panel.add(panelButton);
		
		myWidgetAccessor.swapPanel().transitTo(panel, Direction.FORWARD);
	}

	@BindView("horizontalSwapPanel")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		HorizontalSwapPanel swapPanel();
		Image image();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(HorizontalSwapPanelMessages messages) 
	{
		this.messages = messages;
	}
}
