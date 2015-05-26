package org.cruxframework.crossdeviceshowcase.client.controller.samples.singleselect;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.select.SingleSelect;

import com.google.gwt.user.client.ui.HTML;

@Controller("singleSelectController")
public class SingleSelectController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.singleSelectDescription());
	}
	
	@Expose
	public void selectedItemDepartments()
	{
		int index = myWidgetAccessor.singleSelectDepartments().getSelectedIndex();
		if (index >= 0)
		{
			String item = myWidgetAccessor.singleSelectDepartments().getValue(index);
			loadEmployees(item);
		}	
	}
	
	private void loadEmployees(String department)
	{
		myWidgetAccessor.singleSelectEmployees().clear();
		
		if(department.equals("accounting"))
		{
			myWidgetAccessor.singleSelectEmployees().insertItem("Jorge Smith", "jorgesmith", 0);
			myWidgetAccessor.singleSelectEmployees().insertItem("Chralie Jones", "chraliejones", 1);			
			myWidgetAccessor.singleSelectEmployees().insertItem("Jessica Hughes ", "jessicahughes", 2);
			myWidgetAccessor.singleSelectEmployees().insertItem("Michael Patel", "michaelpatel", 3);
			myWidgetAccessor.singleSelectEmployees().insertItem("Alice Hill", "alicehill", 4);
			myWidgetAccessor.singleSelectEmployees().insertItem("Andrea Cooper", "andreacooper", 5);	
		}else if(department.equals("marketing"))
		{
			myWidgetAccessor.singleSelectEmployees().insertItem("Frank Walker", "frankwalker", 0);
			myWidgetAccessor.singleSelectEmployees().insertItem("Davi Smith", "davismith", 1);
			myWidgetAccessor.singleSelectEmployees().insertItem("Brenda Moore", "brendamoore", 2);
			myWidgetAccessor.singleSelectEmployees().insertItem("Carol Clark", "carolclark", 3);
			myWidgetAccessor.singleSelectEmployees().insertItem("Victor Hall", "victorhall", 4);
		}else
		{
			myWidgetAccessor.singleSelectEmployees().insertItem("Alex Johnson", "alexjohnson", 0);
			myWidgetAccessor.singleSelectEmployees().insertItem("Tony White", "tonywhite", 1);
			myWidgetAccessor.singleSelectEmployees().insertItem("Mary Green", "marygreen", 2);
			myWidgetAccessor.singleSelectEmployees().insertItem("Robert Jones", "robertjones", 3);
			myWidgetAccessor.singleSelectEmployees().insertItem("Peter Lewis", "peterlewis", 4);
		}
	}
	
	@Expose
	public void selectedItemEmployees()
	{
		
		int indexDepartment = myWidgetAccessor.singleSelectDepartments().getSelectedIndex();
		if (indexDepartment >= 0)
		{
			String itemDepartment = myWidgetAccessor.singleSelectDepartments().getItemText(indexDepartment);
			
			int indexEmployee = myWidgetAccessor.singleSelectEmployees().getSelectedIndex();
			
			if (indexEmployee >= 0)
			{
				String itemEmployee = myWidgetAccessor.singleSelectEmployees().getItemText(indexEmployee);
				FlatMessageBox.show("You selected the employee (a) " + itemEmployee + " of the " + itemDepartment+" department.", MessageType.INFO);
			}
		}				
	}

	@BindView("singleSelect")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		SingleSelect singleSelectDepartments();
		SingleSelect singleSelectEmployees();
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
