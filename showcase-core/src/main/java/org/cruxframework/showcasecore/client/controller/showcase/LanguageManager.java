package org.cruxframework.showcasecore.client.controller.showcase;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public class LanguageManager 
{
	private Widget langToggler;
	private Widget langEn;
	private Widget langPt;

	public LanguageManager(Widget langToggler, Widget langEn, Widget langPt)
	{
		this.langEn = langEn;
		this.langPt = langPt;
		this.langToggler = langToggler;
	}
	
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
	
	//not used for now...
	private native String getBrowserLocale()/*-{
	
		if($wnd.navigator !== undefined && $wnd.navigator.language !== undefined)
		{
			if($wnd.navigator.language == "pt" || ($wnd.navigator.language.indexOf("pt-") > -1) || ($wnd.navigator.language.indexOf("pt_") > -1))
			{
				return "pt_BR";
			}
		}
		return "en_US";
	}-*/;

	public void switchLocaleUrl(String localeParameter)
	{
		Window.Location.replace("?locale=" + localeParameter + Window.Location.getHash());
	}
}
