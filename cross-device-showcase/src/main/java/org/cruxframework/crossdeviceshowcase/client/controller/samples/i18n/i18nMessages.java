package org.cruxframework.crossdeviceshowcase.client.controller.samples.i18n;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("i18n_messages")
public interface i18nMessages extends Messages
{	
	@DefaultMessage("Nome:")
	String name();
	
	@DefaultMessage("Idade:")
	String age();
	
	@DefaultMessage("Profissão:")
	String profession();
}
