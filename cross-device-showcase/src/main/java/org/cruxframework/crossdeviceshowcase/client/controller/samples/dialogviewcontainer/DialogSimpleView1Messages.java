package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_dialogSimpleView2")
public interface DialogSimpleView1Messages extends Messages
{
	@DefaultMessage("View 2")
	String title();
	
	@DefaultMessage("View simples carregada por um Dialog View Container.")
	String labelSimpleViewText();
	
	@DefaultMessage("Carregar View 1")
	String buttonView();
}
