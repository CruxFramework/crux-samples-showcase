package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import org.cruxframework.crossdeviceshowcase.client.controller.samples.ShowcaseMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.smartfaces.client.dialog.WaitBox;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.util.animation.InOutAnimation;
import com.google.gwt.user.client.ui.TextBox;

@Controller("restController")
public class RestController 
{
	private WaitBox loadingBox = new WaitBox();
	
	  @Inject
	private ShowcaseMessages messages; 

	/**
	 * Create a Rest proxy to talk to the server-side.
	 */
	@Inject
	private MyRestProxy myRestProxy; 
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	private String name;
	private String password;
	private int state;
	
	@Expose
	public void createUser()
	{
		if(checkRequiredFields())
		{
			loadingBox.center();
			myRestProxy.save(name, password, new Callback<Void>()
				{
					@Override
					public void onError(Exception e) 
					{
						loadingBox.hide();
						MessageBox.show("Error in REST communication", MessageType.ERROR);
					}

					@Override
					public void onSuccess(Void result) 
					{
						loadingBox.hide();
						setState(1);
						MessageBox.show("Usuário criado com sucesso!", MessageType.SUCCESS);
					}
			
				});
		}
		else
		{
			MessageBox.show("Preencha todos os campos", MessageType.WARN);
		}
	}
	
	
	@Expose
	public void onLoad()
	{
//		loadingBox.setAnimation(InOutAnimation.fade);
	}
	
	public void setMessages(ShowcaseMessages messages)
	{
		this.messages = messages;
	}
    
    public void setMyRestProxy(MyRestProxy myRestProxy) 
	{
		this.myRestProxy = myRestProxy;
	}  
    
    public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
    
    @Expose   
    public void validateUser()
    {
    	if(checkRequiredFields())
    	{
    		loadingBox.center();
    		myRestProxy.validate(name, password, new Callback<MyDTO>() 
    			{
					//Show the Rest error message to the user
					@Override
					public void onError(Exception e) 
					{
						loadingBox.hide();
						MessageBox.show("Error in REST communication", MessageType.ERROR);
					}
					
					@Override
					public void onSuccess(MyDTO result) 
					{
						loadingBox.hide();
						if(result!=null)
						{
							setState(0);
							MessageBox.show("Welcome, "+result.getName()+"!", MessageType.SUCCESS);
						}
						else
						{
							MessageBox.show("Username or password is invalid.", MessageType.ERROR);
						}
					}
				});
    	}
    	else
		{
			MessageBox.show("Preencha todos os campos", MessageType.WARN);
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
        Button btnCreate();
        Button btnLogin();
        TextBox txtLogin();
        TextBox txtPassword();
    }
}
