package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
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
	private String CLICKED;
	private String PRODUCT;
	private String ADD_TO_CART;
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.storyBoardDescription());
		
		CLICKED = "You clicked Add to cart!";
		PRODUCT = "Product";
		ADD_TO_CART = "Add to Cart";
		
		loadItens();
	}

	private void loadItens()
	{
		List<StoryboardItem> listItem = new ArrayList<StoryboardItem>();

		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 1", "$ 899.00", ADD_TO_CART));
		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 2", "$ 399.00", ADD_TO_CART));
		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 3", "$ 1,899.00", ADD_TO_CART));
		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 4", "$ 159.00", ADD_TO_CART));
		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 5", "$ 839.00", ADD_TO_CART));
		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 6", "$ 729.00", ADD_TO_CART));
		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 7", "$ 2.199.00", ADD_TO_CART));
		listItem.add(new StoryboardItem(CLICKED, PRODUCT+" 8", "$ 599.00", ADD_TO_CART));

		for(StoryboardItem w : listItem){
			myWidgetAccessor.storyboard().add(w);
		}
	}

	@BindView("storyBoard")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Storyboard storyboard();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
