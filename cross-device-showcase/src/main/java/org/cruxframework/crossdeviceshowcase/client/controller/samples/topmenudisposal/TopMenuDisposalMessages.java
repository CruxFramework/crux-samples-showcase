package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_topMenuDisposal")
public interface TopMenuDisposalMessages extends Messages
{
	@DefaultMessage("Top Menu Disposal")
	String title();
	
	@DefaultMessage("Início")
	String labelHome();
	
	@DefaultMessage("Ítem 1")
	String labelItem1();
	
	@DefaultMessage("Ítem 2")
	String labelItem2();
	
	@DefaultMessage("<p>Menu interativo cross-device, se adpta a dispositivos de tela grande como desktops e telas pequenas como celulares. "
			+"Possui definição da página inicial do menu e também possibilita que as páginas possam ser inseridas no menu de forma declarativa e programática.</p>" 
			+"<p>Neste exemplo a página Ítem 2 foi adicionada programaticamente através de uma controller.</p>")
	String htmlDescText();
}
  




  
