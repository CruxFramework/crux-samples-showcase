package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.storyboard.Storyboard;

import com.google.gwt.user.client.ui.HTML;

@Controller("storyboardController")
public class StoryboardController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private StoryBoardMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		loadItens();
	}

	private void loadItens()
	{
		List<StoryboardItem> listItem = new ArrayList<StoryboardItem>();

		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 1", "$ 899.00",messages.addCart()));
		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 2", "$ 399.00",messages.addCart()));
		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 3", "$ 1,899.00",messages.addCart()));
		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 4", "$ 159.00",messages.addCart()));
		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 5", "$ 839.00",messages.addCart()));
		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 6", "$ 729.00",messages.addCart()));
		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 7", "$ 2.199.00",messages.addCart()));
		listItem.add(new StoryboardItem(messages.clicked(), messages.product()+" 8", "$ 599.00",messages.addCart()));

		for(StoryboardItem w : listItem){
			myWidgetAccessor.storyboard().add(w);
		}
	}

	@BindView("storyBoard")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Storyboard storyboard();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(StoryBoardMessages messages) 
	{
		this.messages = messages;
	}
}
