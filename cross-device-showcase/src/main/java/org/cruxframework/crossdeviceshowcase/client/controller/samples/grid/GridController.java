package org.cruxframework.crossdeviceshowcase.client.controller.samples.grid;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.grid.Grid;

import com.google.gwt.user.client.ui.HTML;

@Controller("gridController")
public class GridController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private GridMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		loadData();
	}

	private void loadData()
	{
		CustomerDS countryDS = (CustomerDS) myWidgetAccessor.grid().getDataSource();
		
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		
		customerList.add(new CustomerDTO("001", "BHG", "Joan D. Onorato", "joan_onorato@bhg.com"));
		customerList.add(new CustomerDTO("003", "System Security", "Wilber T. Ramer", "wilber_ramer@systemsecurity.com"));
		customerList.add(new CustomerDTO("004", "Gutters and Flashings", "Carolyn J. Peck", "carolyn.peck@guttersandflashings.com"));
		customerList.add(new CustomerDTO("005", "W & V", "Cora J. Worthy", "cora_worthy@wv.com"));
		customerList.add(new CustomerDTO("007", "Plus Machine", "John A. Payne", "john.payne@plusmachine.com"));
		
		customerList.add(new CustomerDTO("008", "Robie and Robert", "Caroline J. Wardell", "robie_robert@robierobert.com"));
		customerList.add(new CustomerDTO("010", "MMC", "Pablo T. Johnson", "pablo_johnson@mmc.com"));
		customerList.add(new CustomerDTO("011", "Frames´s Doug", "Scott S. Gerlach", "scott.gerlach@framessdoug.com"));
		customerList.add(new CustomerDTO("012", "Miller Manson", "Norma M. Gray", "norma_gray@millermanson.com"));
		customerList.add(new CustomerDTO("015", "PBH", "Jestine J. Murphy", "jestine.murphy@pbh.com"));
		
		countryDS.setCustomers(customerList);
		myWidgetAccessor.grid().loadData();
		myWidgetAccessor.grid().refresh();
	}
	
	@BindView("grid")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		Grid grid();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(GridMessages messages) {
		this.messages = messages;
	}
}
