package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.storyboard.Storyboard;

@Controller("storyboardController")
public class StoryboardController
{
	private static final String CLICKED = "You clicked Add to cart!";
	private static final String PRODUCT = "Product";
	private static final String ADD_TO_CART = "Add to Cart";
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
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
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
