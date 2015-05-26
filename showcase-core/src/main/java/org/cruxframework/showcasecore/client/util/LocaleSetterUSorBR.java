package org.cruxframework.showcasecore.client.util;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

public class LocaleSetterUSorBR implements EntryPoint
{
	@Override
	public void onModuleLoad() 
	{
		if(!hasLocaleURL())
		{
			Window.Location.replace("?locale=" + getUserConfigLocale() + Window.Location.getHash());
		}
	}

	private boolean hasLocaleURL()
	{
		if(Window.Location.getHref().indexOf("?locale") > -1)
		{
			return true;
		}
		return false;
	}
	
	private native String getUserConfigLocale() /*-{
		if($wnd.navigator !== undefined)
		{
			if($wnd.navigator.language !== undefined)
			{
				if($wnd.navigator.language == "pt"              || 
				  ($wnd.navigator.language.indexOf("pt-") > -1) || 
				  ($wnd.navigator.language.indexOf("pt_") > -1))
				{
					return "pt_BR";
				}
			}
		}
		return "en_US";
	}-*/;
}
