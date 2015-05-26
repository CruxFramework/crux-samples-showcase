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
	
	@DefaultMessage("<p>O componente TabViewContainer permite que várias views compartilhem o mesmo espaço. "
			+"Uma aba pode ser selecionada para visualização clicando-se sobre seu nome na parte superior ou pode ser fechada " 
			+"através de um clique no botão fechar (x).</p>"
			+"<p>No exemplo apresentado é possível remover uma aba clicando no botão Remover aba selecionada e também é "
			+"possível adicionar uma nova aba clicando no botão 'Adicionar Url'.</p>")
	String htmlDescText();
}
 
 


  
