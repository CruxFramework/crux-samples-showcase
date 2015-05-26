package org.cruxframework.crossdeviceshowcase.client.controller.samples.singleselect;

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
	private SingleSelectMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@Expose
	public void selectedItemDepartments()
	{
		int index = myWidgetAccessor.singleSelectDepartments().getSelectedIndex();
		if (index > -1)
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
			myWidgetAccessor.singleSelectEmployees().insertItem("Jorge Henrique", "jorgeHenrique", 0);
			myWidgetAccessor.singleSelectEmployees().insertItem("Lucas Rodrigues", "lucasRodrigues", 1);			
			myWidgetAccessor.singleSelectEmployees().insertItem("Marco Aurélio", "marcoAurelio", 2);
			myWidgetAccessor.singleSelectEmployees().insertItem("Pedro Alcantara", "pedroAlcantara", 3);
			myWidgetAccessor.singleSelectEmployees().insertItem("Sônia Lima", "soniaLima", 4);
			myWidgetAccessor.singleSelectEmployees().insertItem("Vera Lúcia", "veraLucia", 5);	
		}else if(department.equals("marketing"))
		{
			myWidgetAccessor.singleSelectEmployees().insertItem("Guilherme Martins", "guilhermeMartins", 0);
			myWidgetAccessor.singleSelectEmployees().insertItem("Henrique locco", "henriquelocco", 1);
			myWidgetAccessor.singleSelectEmployees().insertItem("Luana Rezende", "luanaRezende", 2);
			myWidgetAccessor.singleSelectEmployees().insertItem("Marcia da Silva", "marciadaSilva", 3);
			myWidgetAccessor.singleSelectEmployees().insertItem("Victor Junqueira", "victorJunqueira", 4);
		}else
		{
			myWidgetAccessor.singleSelectEmployees().insertItem("Alexandre Costa", "alexandreCosta", 0);
			myWidgetAccessor.singleSelectEmployees().insertItem("Antônio Eduardo", "antonioEduardo", 1);
			myWidgetAccessor.singleSelectEmployees().insertItem("Cláudio Holanda", "claudioHolanda", 2);
			myWidgetAccessor.singleSelectEmployees().insertItem("Roberta Miranda", "robertaMiranda", 3);
			myWidgetAccessor.singleSelectEmployees().insertItem("Renaldo Motta", "renaldoMotta", 4);
		}
	}
	
	@Expose
	public void selectedItemEmployees()
	{
		
		int indexDepartment = myWidgetAccessor.singleSelectDepartments().getSelectedIndex();
		if (indexDepartment > -1)
		{
			String itemDepartment = myWidgetAccessor.singleSelectDepartments().getItemText(indexDepartment);
			
			int indexEmployee = myWidgetAccessor.singleSelectEmployees().getSelectedIndex();
			
			if (indexEmployee > -1)
			{
				String itemEmployee = myWidgetAccessor.singleSelectEmployees().getItemText(indexEmployee);
				FlatMessageBox.show(messages.messageItemSelectedEmployee()+itemEmployee+messages.messageItemSelectedEmployeeContinue()+itemDepartment+".", MessageType.INFO);
			}
		}				
	}

	@BindView("singleSelect")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		SingleSelect singleSelectDepartments();
		SingleSelect singleSelectEmployees();
		HTML htmlDescText();

	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(SingleSelectMessages messages) 
	{
		this.messages = messages;
	}
	
}
