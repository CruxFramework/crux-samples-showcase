package org.cruxframework.crossdeviceshowcase.client.controller.samples.simpleviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_view3")
public interface View3Messages extends Messages
{
	@DefaultMessage("View Exemplo 3")
	String title();
	
	@DefaultMessage("Esta é uma view simples carregada por um Simple View Container.")
	String labelTextView();
}




