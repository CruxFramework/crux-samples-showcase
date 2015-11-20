package org.cruxframework.crossdeviceshowcase.client.controller.samples.simpleviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_simpleViewContainer")
public interface SimpleViewContainerMessages extends Messages
{
	@DefaultMessage("SimpleViewContainer")
	String title();
	
	@DefaultMessage("Próxima view")
	String nextView();
	
	@DefaultMessage("View anterior")
	String previousView();
}


