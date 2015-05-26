package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import org.cruxframework.crossdeviceshowcase.shared.dto.MyDTO;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;

import com.google.gwt.user.client.ui.TextBox;

@Controller("restController")
public class RestController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	  /**
		 * Create a Rest proxy to talk to the server-side.
		 */
	@Inject
	private MyRestProxy myRestProxy; 
	
	private String name;
	private String password;
	private int state;
	
	@Expose
	public void createUser()
	{
		if(checkRequiredFields())
		{
			myRestProxy.save(name, password, new Callback<Void>()
				{
					@Override
					public void onSuccess(Void result) 
					{
						setState(1);
						FlatMessageBox.show("Usuário criado com sucesso!", MessageType.SUCCESS);
					}

					@Override
					public void onError(Exception e) 
					{
						FlatMessageBox.show("Error in REST communication", MessageType.ERROR);
					}
			
				});
		}
		else
		{
			FlatMessageBox.show("Preencha todos os campos", MessageType.WARN);
		}
	}
    
    @Expose   
    public void validateUser()
    {
    	if(checkRequiredFields())
    	{
    		myRestProxy.validate(name, password, new Callback<MyDTO>() 
    			{
					@Override
					public void onSuccess(MyDTO result) 
					{
						if(result!=null)
						{
							setState(0);
							FlatMessageBox.show("Welcome, "+result.getName()+"!", MessageType.SUCCESS);
						}
						else
						{
							FlatMessageBox.show("Username or password is invalid.", MessageType.ERROR);
						}
					}
					
					//Show the Rest error message to the user
					@Override
					public void onError(Exception e) 
					{
						FlatMessageBox.show("Error in REST communication", MessageType.ERROR);
					}
				});
    	}
    	else
		{
			FlatMessageBox.show("Preencha todos os campos", MessageType.WARN);
		} 	
    }  
    
    private boolean checkRequiredFields()
    {
    	name = myWidgetAccessor.txtLogin().getText();
		password = myWidgetAccessor.txtPassword().getText();
		
		if(name!=null && !name.equals("") && password!=null && !password.equals(""))
		{
			return true;
		}
		return false;
    }
    
    private void setState(int value)
    {
    	state = value;
    	
    	myWidgetAccessor.txtLogin().setText("");
		myWidgetAccessor.txtPassword().setText("");
    	
    	if(state == 0)
    	{
    		myWidgetAccessor.btnCreate().setVisible(true);
    		myWidgetAccessor.btnLogin().setVisible(false);
    	}
    	else
    	{
    		myWidgetAccessor.btnCreate().setVisible(false);
    		myWidgetAccessor.btnLogin().setVisible(true);
    	}
    }
    
    @BindView("rest")
    public static interface MyWidgetAccessor extends WidgetAccessor
    {
        TextBox txtLogin();
        TextBox txtPassword();
        Button btnCreate();
        Button btnLogin();
    }

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMyRestProxy(MyRestProxy myRestProxy) 
	{
		this.myRestProxy = myRestProxy;
	}
}
