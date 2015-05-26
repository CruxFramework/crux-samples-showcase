package org.cruxframework.crossdeviceshowcase.client.controller.samples.i18n;

import java.util.Locale;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.disposal.menutabsdisposal.MenuTabsDisposal;
import org.cruxframework.crux.widgets.client.swapcontainer.HorizontalSwapContainer;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

@Controller("i18nController")
public class I18nController
{
	private String locale;
	
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		locale = Window.Location.getParameter("locale");
        if ("pt_BR".equals(locale))
        {
            myWidgetAccessor.listLocale().setSelectedIndex(1);
        }
	}
	
	@Expose
	public void changeLocale()
	{
        final String Selectedlocale = myWidgetAccessor.listLocale().getValue(myWidgetAccessor.listLocale().getSelectedIndex());

	}
	
	@BindView("i18n")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HorizontalSwapContainer viewContainer();
		ListBox listLocale();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) 
	{
		this.componentDescription = componentDescription;
	}
}
