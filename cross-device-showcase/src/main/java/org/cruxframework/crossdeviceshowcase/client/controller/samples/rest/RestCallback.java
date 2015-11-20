package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.smartfaces.client.dialog.WaitBox;

import com.google.gwt.core.shared.GWT;

public abstract class RestCallback<T> implements Callback<T>
{
	private final static WaitBox wait = new WaitBox();
	private static RestMessages messages = GWT.create(RestMessages.class);
	
	private void closeWaitPopup()
	{
		if(wait.isAttached() && wait.isShowing())
		{
			wait.hide();
		}
	}
	
	public RestCallback()
	{
		wait.center();
	}

	public abstract void onComplete(T result);

	@Override
	public void onError(Exception e)
	{
		try
		{
			MessageBox.show(messages.connectionError(e.getMessage()), MessageType.ERROR);
		} 
		finally
		{
			closeWaitPopup();			
		}
	}

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