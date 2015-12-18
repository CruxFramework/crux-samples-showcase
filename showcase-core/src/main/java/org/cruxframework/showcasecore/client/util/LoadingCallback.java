package org.cruxframework.showcasecore.client.util;

import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.smartfaces.client.dialog.WaitBox;
import org.cruxframework.crux.smartfaces.client.dialog.animation.DialogAnimation;
import org.cruxframework.showcasecore.client.resource.ShowcaseCoreMessages;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HTML;

@SuppressWarnings("deprecation")
public abstract class LoadingCallback<T> implements Callback<T>
{
	private static HTML message = new HTML();
	private static int numChamadas;
	private final static WaitBox wait = new WaitBox();
	static
	{
		wait.setAnimation(DialogAnimation.fade);
		
		wait.setWidget(message);
	} 
	private ShowcaseCoreMessages commonMessages = GWT.create(ShowcaseCoreMessages.class);

	/**
	 * Construtor padrão.
	 */
	public LoadingCallback()
	{
		initCallback(commonMessages.loading());
	}
	
	/**
	 * Fecha uma popup de Dialog.
	 */
	private void closeWaitPopup()
	{
		numChamadas--;
		if(wait.isAttached() && wait.isShowing() && numChamadas == 0)
		{
			wait.hide();
		}
		
		if(numChamadas > 0)
		{
			Scheduler.get().scheduleFixedDelay(new RepeatingCommand()
			{
				@Override
				public boolean execute()
				{
					if(wait.isAttached() && wait.isShowing())
					{
						wait.hide();
						return false;
					}
					
					if(!wait.isShowing())
					{
						return false;
					}
					
					return true;
				}
			}, 100);
		}
	}

	private void initCallback(String message)
	{
		numChamadas++;
		
		if(message != null)
		{
			LoadingCallback.message.setHTML(new SafeHtmlBuilder().appendHtmlConstant(message).toSafeHtml());
		}
		
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand()
		{
			@Override
			public boolean execute()
			{
				if(wait.isAnimating())
				{
					return true;
				}
				
				if(!wait.isShowing() && numChamadas > 0)
				{
					wait.show();
					wait.center();
				}
				
				return false;
			}
		}, 100);
	}

	/**
	 * @param result
	 * Chamdo quando o REST retornar sua ação no servidor.
	 */
	public abstract void onComplete(T result);

	/**
	 * Método que retorna uma exceção do servidor.
	 */
	@Override
	public void onError(Exception e)
	{
		try
		{
			MessageBox.show(e.getMessage(), MessageType.ERROR);
		} 
		finally
		{
			closeWaitPopup();			
		}
	}

	/**
	 * Override do método de salvar para inserir o Dialog de processamento.
	 */
	@Override
	public final void onSuccess(T result)
	{
		try
		{
			onComplete(result);
		}
		finally
		{
			closeWaitPopup();
		}
	}
}