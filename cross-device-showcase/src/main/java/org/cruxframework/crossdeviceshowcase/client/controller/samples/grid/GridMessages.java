package org.cruxframework.crossdeviceshowcase.client.controller.samples.grid;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_grid")
public interface GridMessages extends Messages
{
	@DefaultMessage("Grid")
	String title();
	
	@DefaultMessage("<p>O componente Grid.</p>")
	String htmlDescText();
}
