package org.cruxframework.crossdeviceshowcase.client.controller.samples.combobox;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.controller.Factory;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.list.ComboBox;
import org.cruxframework.crux.smartfaces.client.list.AbstractComboBox.OptionsRenderer;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;

@Controller("comboBoxController")
public class ComboBoxController {
	
	private final List<Person> dataList = new ArrayList<Person>();
	
	@Inject
	private DescriptionMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(messages.menuDescription());		
	}
	
	@Expose
	public Person loadComboData()
	{
		Person person = new Person("crux", 29, "desenv");
		return person;
	}
	

	@BindView("comboBox")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		FlowPanel innerPanel();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(DescriptionMessages messages) 
	{
		this.messages = messages;
	}
}
