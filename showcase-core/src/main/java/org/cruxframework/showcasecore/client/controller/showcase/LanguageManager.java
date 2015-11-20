package org.cruxframework.showcasecore.client.controller.showcase;

import org.cruxframework.crux.core.client.screen.views.View;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public class LanguageManager 
{
	public void verifyAndToggleLanguage()
	{
		String uriLocale = Window.Location.getParameter("locale");
		switchLocaleToggle(uriLocale);
	}

	public void switchLocaleToggle(String locale)
	{
		if(locale == null)
		{
			return;
		}

		Widget langToggler = View.of(this).getWidget("langToggler");

		Widget langEn = View.of(this).getWidget("langEn");
		Widget langPt = View.of(this).getWidget("langPt");

		if(locale.contains("pt_BR"))
		{
			langEn.removeStyleName("active");
			langToggler.addStyleName("active");
			langPt.addStyleName("active");
		} else
		{
			langPt.removeStyleName("active");
			langToggler.removeStyleName("active");
			langEn.addStyleName("active");
		}
	}

	private native String getBrowserLocale()/*-{
		if($wnd.navigator.language == "pt-br")
		{
			return "pt_BR";
		}
		return "en_US";
	}-*/;

	public void switchLocaleUrl(String localeParameter)
	{
		Window.Location.replace("?locale=" + localeParameter + Window.Location.getHash());
	}
}
