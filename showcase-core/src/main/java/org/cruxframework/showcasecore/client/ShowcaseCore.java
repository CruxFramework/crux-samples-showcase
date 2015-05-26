package org.cruxframework.showcasecore.client;

import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;

public class ShowcaseCore implements EntryPoint 
{
	@Override
	public void onModuleLoad() 
	{
		final ShowcaseResourcesCommon bundle = GWT.create(ShowcaseResourcesCommon.class);
		
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() 
		{
			@Override
			public boolean execute() 
			{
				ScriptInjector.fromString(bundle.jsPrism().getText()).setRemoveTag(false).setWindow(ScriptInjector.TOP_WINDOW).inject();
				StyleInjector.injectStylesheet(bundle.cssPrism().getText());
				return false;
			}
		}, 500);
		
	}
}
