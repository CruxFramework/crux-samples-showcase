package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_tabViewContainer")
public interface TabViewContainerMessages extends Messages
{
	@DefaultMessage("TabViewContainer")
	String title();
	
	@DefaultMessage("http://www.cruxframework.org")
	String textBoxUrl();

	@DefaultMessage("Adicionar URL")
	String buttonAddUrl();
	
	@DefaultMessage("Remover aba selecionada")
	String buttonRemove();
	
	@DefaultMessage("Não há aba para ser removida.")
	String alert();
}
 
 


  
