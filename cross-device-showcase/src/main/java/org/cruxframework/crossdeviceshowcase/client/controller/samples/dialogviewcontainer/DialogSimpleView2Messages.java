package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_dialogSimpleView1")
public interface DialogSimpleView2Messages extends Messages
{
	@DefaultMessage("View 1")
	String title();
	
	@DefaultMessage("View simples carregada por um Dialog View Container.")
	String labelSimpleViewText();
	
	@DefaultMessage("Carregar View 2")
	String buttonView();
}
