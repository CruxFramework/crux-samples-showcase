package org.cruxframework.showcasecore.client.controller.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Size;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindRootView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.ViewActivateEvent;
import org.cruxframework.crux.core.client.screen.views.ViewActivateHandler;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.core.client.utils.StringUtils;
import org.cruxframework.crux.widgets.client.dialogcontainer.DialogViewContainer;
import org.cruxframework.crux.widgets.client.disposal.menutabsdisposal.MenuTabsDisposal;
import org.cruxframework.crux.widgets.client.disposal.panelchoicedisposal.PanelChoiceDisposal;
import org.cruxframework.crux.widgets.client.filter.Filter;
import org.cruxframework.crux.widgets.client.filter.Filterable;
import org.cruxframework.crux.widgets.client.swappanel.HorizontalSwapPanel.Direction;
import org.cruxframework.showcasecore.client.proxy.SourceCodeRestProxy;
import org.cruxframework.showcasecore.client.resource.ShowcaseCoreMessages;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;
import org.cruxframework.showcasecore.client.util.LoadingCallback;
import org.cruxframework.showcasecore.client.util.VisualBoxLogHandler;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
@SuppressWarnings("deprecation")
@Controller("mainController")
public class MainController 
{
	private ShowcaseResourcesCommon bundle = GWT.create(ShowcaseResourcesCommon.class);

	@Inject
	private ShowcaseCoreMessages messages;

	@Inject
	public SourceCodeRestProxy service;

	private Logger logger = Logger.getLogger("");

	@Inject
	private LanguageManager languageManager;

	@Expose
	public void replaceText(AttachEvent event)
	{
		Label label = (Label)event.getSource();
		HTML html = (HTML) View.getView(widgets.menuDisposal().getCurrentView()).getWidget("descriptionCointainer");
		html.setHTML(label.getText());
	}
	
	@Inject
	private MyWidgetAccessor widgets;
	
	public void setWidgets(MyWidgetAccessor widgets)
	{
		this.widgets = widgets;
	}

	@BindRootView
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		MenuTabsDisposal menuDisposal();
	}
	
	
	@Expose
	public void switchLocaleUrl()
	{
		Widget langEn = View.of(this).getWidget("langEn");

		if(langEn.getStyleName().contains("active"))
		{
			languageManager.switchLocaleUrl("pt_BR");
		} else
		{
			languageManager.switchLocaleUrl("en_US");
		}
	}

	@Expose
	public void loadShowcaseUrl()
	{
		Window.Location.replace("http://showcase.cruxframework.org/");
	}

	@Expose
	public void wellcome()
	{
		//add the event log window
		if(Screen.getCurrentDevice().getSize().equals(Size.large))
		{
			logger.addHandler(new VisualBoxLogHandler(messages.enableLog(), messages.disableLog()));
		}

		String hash = Window.Location.getHash();
		MenuTabsDisposal menuDisposal = (MenuTabsDisposal) Screen.get("menuDisposal");
		
		if(!StringUtils.isEmpty(hash))
		{
			String viewName = hash.split(":")[1];
			
			if(!"wellcome".equals(viewName))
			{
				menuDisposal.showView(viewName, Direction.FORWARD);
			}
			else
			{
				menuDisposal.showView("wellcome", Direction.FORWARD);
			}
		}
		else
		{
			menuDisposal.showView("wellcome", Direction.FORWARD);			
		}

		//Call method to verify browser language
		languageManager.verifyAndToggleLanguage();

		if(Screen.getCurrentDevice().getSize().equals(Size.large))
		{
			//Setup the top filters
			setupFilters(menuDisposal);
		}
	}

	private void setupFilters(final MenuTabsDisposal menuDisposal)
	{
		final Filter filter = (Filter) Screen.get("filter");

		filter.setFilterable(new Filterable<String>()
		{
			@Override
			public List<FilterResult<String>> filter(String query) 
			{	
				List<FilterResult<String>> widgetList = new ArrayList<FilterResult<String>>();
				widgetList.add(new FilterResult<String>("cruxButton", "Button", "cruxButton"));
				widgetList.add(new FilterResult<String>("anchor", "Anchor", "anchor"));
				widgetList.add(new FilterResult<String>("cruxLabel", "Label", "cruxLabel"));
				widgetList.add(new FilterResult<String>("colorPickerDialog", "ColorPicker", "colorPickerDialog"));
				widgetList.add(new FilterResult<String>("date", "Date", "date"));
				widgetList.add(new FilterResult<String>("fileUploader", "FileUploader", "fileUploader"));
				widgetList.add(new FilterResult<String>("maskedLabel", "MaskedLabel", "maskedLabel"));
				widgetList.add(new FilterResult<String>("maskedTextBox", "MaskedTextBox", "maskedTextBox"));
				widgetList.add(new FilterResult<String>("numberTextBox", "NumberTextBox", "numberTextBox"));
				widgetList.add(new FilterResult<String>("textArea", "TextArea", "textArea"));
				widgetList.add(new FilterResult<String>("gwtTextBox", "TextBox", "gwtTextBox"));
				widgetList.add(new FilterResult<String>("singleSelect", "SingleSelect", "singleSelect"));
				widgetList.add(new FilterResult<String>("selectablePanel", "Selectable Panel", "selectablePanel"));
				widgetList.add(new FilterResult<String>("tabPanel", "Tab Panel", "tabPanel"));
				widgetList.add(new FilterResult<String>("menu", "Menu", "menu"));
				widgetList.add(new FilterResult<String>("sideMenuDisposal", "SideMenuDisposal", "sideMenuDisposal"));
				widgetList.add(new FilterResult<String>("topMenuDisposal", "TopMenuDisposal", "topMenuDisposal"));
				widgetList.add(new FilterResult<String>("filter", "Filter", "filter"));
				widgetList.add(new FilterResult<String>("listShuttle", "ListShuttle", "listShuttle"));
				widgetList.add(new FilterResult<String>("sortableList", "SortableList", "sortableList"));
				widgetList.add(new FilterResult<String>("breadcrumb", "Breadcrumb", "breadcrumb"));
				widgetList.add(new FilterResult<String>("datagrid", "DataGRID", "datagrid"));
				widgetList.add(new FilterResult<String>("widgetList", "WidgetList", "widgetList"));
				widgetList.add(new FilterResult<String>("comboBox", "ComboBox", "comboBox"));
				widgetList.add(new FilterResult<String>("carousel", "Carousel", "carousel"));
				widgetList.add(new FilterResult<String>("pagers", "Pagers", "pagers"));
				widgetList.add(new FilterResult<String>("formDisplay", "FormDisplay", "formDisplay"));
				widgetList.add(new FilterResult<String>("rollingPanel", "RollingPanel", "rollingPanel"));
				widgetList.add(new FilterResult<String>("storyBoard", "StoryBoard", "storyBoard"));
				widgetList.add(new FilterResult<String>("styledPanel", "StyledPanel", "styledPanel"));
				widgetList.add(new FilterResult<String>("confirm", "Confirm", "confirm"));
				widgetList.add(new FilterResult<String>("dialogBox", "DialogBox", "dialogBox"));
				widgetList.add(new FilterResult<String>("dialogViewContainer", "DialogViewContainer", "dialogViewContainer"));
				widgetList.add(new FilterResult<String>("messageBox", "MessageBox", "messageBox"));
				widgetList.add(new FilterResult<String>("progressBox", "ProgressBox", "progressBox"));
				widgetList.add(new FilterResult<String>("image", "Image", "image"));
				widgetList.add(new FilterResult<String>("promoBanner", "PromoBanner", "promoBanner"));
				widgetList.add(new FilterResult<String>("slideshow", "SlideShow", "slideshow"));
				widgetList.add(new FilterResult<String>("scrollBanner", "ScrollBanner", "scrollBanner"));
				widgetList.add(new FilterResult<String>("swapPanel", "SwapPanel", "swapPanel"));
				widgetList.add(new FilterResult<String>("tabViewContainer", "Tab View Container", "tabViewContainer"));
				widgetList.add(new FilterResult<String>("swapViewContainer", "SwapViewContainer", "swapViewContainer"));
				widgetList.add(new FilterResult<String>("simpleViewContainer", "Simple View Container", "simpleViewContainer"));
				widgetList.add(new FilterResult<String>("binding", "Binding", "binding"));
				widgetList.add(new FilterResult<String>("rest", "Rest Communication", "rest"));
				widgetList.add(new FilterResult<String>("objectcloner", "Object Cloner", "objectcloner"));
				widgetList.add(new FilterResult<String>("simpleDatabase", "Simple Database", "simpleDatabase"));
				widgetList.add(new FilterResult<String>("timer", "Timer", "timer"));

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
		Window.open("https://github.com/CruxFramework", "_self", null);
	}

	@Expose
	public void viewSourceCode()
	{
		MenuTabsDisposal menuDisposal = (MenuTabsDisposal) Screen.get("menuDisposal");
		String viewId = menuDisposal.getCurrentView();

		service.listSourceFilesForView(viewId, new LoadingCallback<ArrayList<String>>()
		{
			@Override
			public void onComplete(ArrayList<String> result)
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

					service.getSourceFile(path, new LoadingCallback<String>()
					{
						@Override
						public void onComplete(String source)
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

	public void setService(SourceCodeRestProxy service)
	{
		this.service = service;
	}

	public void setMessages(ShowcaseCoreMessages messages)
	{
		this.messages = messages;
	}

	public void setLanguageManager(LanguageManager languageManager)
	{
		this.languageManager = languageManager;
	}
}
