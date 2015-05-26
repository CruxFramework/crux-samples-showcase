package org.cruxframework.showcasecore.client.controller.showcase;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.ViewActivateEvent;
import org.cruxframework.crux.core.client.screen.views.ViewActivateHandler;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.widgets.client.dialogcontainer.DialogViewContainer;
import org.cruxframework.crux.widgets.client.disposal.menutabsdisposal.MenuTabsDisposal;
import org.cruxframework.crux.widgets.client.disposal.panelchoicedisposal.PanelChoiceDisposal;
import org.cruxframework.crux.widgets.client.event.SelectEvent;
import org.cruxframework.crux.widgets.client.event.SelectHandler;
import org.cruxframework.crux.widgets.client.filter.Filter;
import org.cruxframework.crux.widgets.client.filter.Filterable;
import org.cruxframework.crux.widgets.client.swappanel.HorizontalSwapPanel.Direction;
import org.cruxframework.showcasecore.client.remote.showcase.SVNServiceAsync;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.gargoylesoftware.htmlunit.protocol.javascript.Handler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

@Controller("mainController")
public class MainController 
{
	final ShowcaseResourcesCommon bundle = GWT.create(ShowcaseResourcesCommon.class);
	
	@Inject
	public SVNServiceAsync service;
	
	/////////////////////////////////////////////////////////////////////////toggle language/////////////////////////////////

	private void verifyAndToggleLanguage()
	{
		String uriLocale = Window.Location.getParameter("locale");
		switchLocaleToggle(uriLocale);
	}

	private void switchLocaleToggle(String locale)
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
	
	@Expose
	public void switchLocaleUrl()
	{
		Widget langEn = View.of(this).getWidget("langEn");

		if(langEn.getStyleName().contains("active"))
		{
			switchLocaleUrl("pt_BR");
		} else
		{
			switchLocaleUrl("en_US");
		}
	}

	private void switchLocaleUrl(String localeParameter)
	{
		Window.Location.replace("?locale=" + localeParameter + Window.Location.getHash());
	}

	@Expose
	public void loadShowcaseUrl()
	{
		Window.Location.replace("http://showcase.cruxframework.org/");
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Expose
	public void wellcome()
	{
		final MenuTabsDisposal menuDisposal = (MenuTabsDisposal) Screen.get("menuDisposal");
		menuDisposal.showView("wellcome", Direction.FORWARD);
		
		//Call method to verify browser language
		verifyAndToggleLanguage();
		
		final Filter filter = (Filter) Screen.get("filter");
		
		filter.setFilterable(new Filterable<String>()
				{

			@Override
			public List<FilterResult<String>> filter(String query) 
			{	
				List<FilterResult<String>> widgetList = new ArrayList<FilterResult<String>>();
				widgetList.add(new FilterResult<String>("cruxButton", "Button", "button"));
				widgetList.add(new FilterResult<String>("filter", "Filter", "filter"));
				widgetList.add(new FilterResult<String>("image", "Imagem", "imagem"));
				widgetList.add(new FilterResult<String>("slider", "Slide", "slide"));
				widgetList.add(new FilterResult<String>("rollingPanel", "RollinPanel", "RollinPanel"));
				widgetList.add(new FilterResult<String>("adaptiveGrid", "Grid", "grid"));
				widgetList.add(new FilterResult<String>("randomPager", "RandomPager", "randomPager"));
				
				
				List<FilterResult<String>> result = new ArrayList<FilterResult<String>>();
				
				for (FilterResult<String> filterResult : widgetList) 
				{
					if(filterResult.getLabel().toLowerCase().contains(query.toLowerCase()))
					{
						result.add(filterResult);
					}
				}

				return result;
			}

			@Override
			public void onSelectItem(String selectedItem)
			{
				menuDisposal.showView(selectedItem, null);
				filter.setText("");
			}
			
		});
				
	}
	
	@Expose
	public void showMenu()
	{
		MenuTabsDisposal menuDisposal = (MenuTabsDisposal) Screen.get("menuDisposal");
		menuDisposal.showMenu();
	}
	
	@Expose
	public void navigateToSite()
	{
		Window.open("http://www.cruxframework.org", "_self", null);
	}
	
	@Expose
	public void navigateToProject()
	{
		Window.open("https://code.google.com/p/crux-framework", "_self", null);
	}
	
	@Expose
	public void viewSourceCode()
	{
		MenuTabsDisposal menuDisposal = (MenuTabsDisposal) Screen.get("menuDisposal");
		String viewId = menuDisposal.getCurrentView();
		
		service.listSourceFilesForView(viewId, new Callback<List<String>>()
		{
			@Override
			public void applyResult(List<String> result)
			{
				if(result.size() > 0)
				{
					showSourcesDialog(result);
				}
			}			
		});
	}

	/**
	 * Shows a dialog box with the source files contents
	 * @param files
	 */
	private void showSourcesDialog(final List<String> files)
	{
		DialogViewContainer dialog = DialogViewContainer.createDialog("sourcesPopup");
		dialog.openDialog();
		dialog.center();
		
		final PanelChoiceDisposal sourceChoice = dialog.getView().getWidget("sourceChoice", PanelChoiceDisposal.class);
		
		for (int i = files.size() - 1; i >= 0; i--)
		{
			final String path = files.get(i);
			final String fileName = getFileName(path);
			addSourceChoice(sourceChoice, path, fileName);
		}
		
		if(files.size() > 0)
		{
			Scheduler.get().scheduleDeferred(new ScheduledCommand()
			{
				@Override
				public void execute()
				{
					String fileName = getFileName(files.get(0));
					sourceChoice.choose(fileName, fileName);
				}
			});
		}						
	}

	/**
	 * @param sourceChoice
	 * @param path
	 * @param fileName
	 */
	private void addSourceChoice(final PanelChoiceDisposal sourceChoice, final String path, final String fileName)
	{
		sourceChoice.addChoice(fileName, fileName, "sourceCode", new ViewActivateHandler()
		{
			private boolean loaded = false;
			
			@Override
			public void onActivate(ViewActivateEvent event)
			{
				if(!loaded)
				{
					loaded = true;
					
					service.getSourceFile(path, new Callback<String>()
					{
						@Override
						public void applyResult(String source)
						{
							View view = View.getView(fileName);
							Widget sourceEditor = view.getWidget("sourceEditor");
							Element editor = sourceEditor.getElement();
							String brush = "class=\"language-" + (fileName.endsWith("java") ? "java": "markup") + "\"";
							source = new SafeHtmlBuilder().appendEscaped(source).toSafeHtml().asString();
							editor.setInnerHTML("<pre class=\"line-numbers\"><code " + brush + ">" + source + "</code></pre>");
							syntaxHighlight();
						}
					});
				}
			}
		});
	}

	/**
	 * @param path
	 * @return
	 */
	private String getFileName(final String path)
	{
		return path.indexOf("/") >= 0 ? path.substring(path.lastIndexOf("/") + 1) : path;
	}
	
	public native void syntaxHighlight()/*-{
		$wnd.Prism.highlightAll();
	}-*/;
}
