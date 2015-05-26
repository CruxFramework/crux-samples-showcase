package org.cruxframework.crossdeviceshowcase.client.util;

import com.google.gwt.user.client.ui.Widget;


public class StyleHelper
{
	private static StyleHelper instance;

	private String[] acceptedStyleNames = 
		{
			"success",
			"warn",
			"error",
			"default"
		};

	private StyleHelper(String[] acceptedStyleNames) 
	{
		this.acceptedStyleNames = acceptedStyleNames;
	}

	private StyleHelper() 
	{
	}

	public static StyleHelper getInstance()
	{
		if(instance == null)
		{
			instance = new StyleHelper();
		}

		return instance;
	}

	public static StyleHelper getInstance(String[] acceptedStyleNames)
	{
		if(instance == null)
		{
			instance = new StyleHelper(acceptedStyleNames);
		}

		return instance;
	}

	private void setState(Widget widget, String state)
	{		
		for(int i = 0; i < acceptedStyleNames.length; i++)
		{
			widget.removeStyleName(acceptedStyleNames[i]);
		}

		if(java.util.Arrays.asList(acceptedStyleNames).indexOf(state) != -1)
		{
			widget.addStyleName(state);
		} else
		{
			throw new RuntimeException("Invalid state type.");
		}
	}

	public void changeWidgetState(Widget widget, String state)
	{
		setState(widget,state);
	}

}
