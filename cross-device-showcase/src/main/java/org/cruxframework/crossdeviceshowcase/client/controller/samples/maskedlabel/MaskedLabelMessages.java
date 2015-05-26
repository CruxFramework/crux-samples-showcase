package org.cruxframework.crossdeviceshowcase.client.controller.samples.maskedlabel;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_maskedLabel")
public interface MaskedLabelMessages extends Messages
{
	@DefaultMessage("Masked Label")
	String title();
	 
	@DefaultMessage("Caracter:")
	String entryCaracter();
	
	@DefaultMessage("Guile")
	String nameLabel();
	
	@DefaultMessage("Data de Nascimento:")
	String entryDate();
	
	@DefaultMessage("<p>MaskedLabel é um componente de exibição de informações que tem a capacidade de ser "
			+"associado a um Formatter para exibir dados tipados em formato textual amigável. </p>" 
			+"<p> Neste exemplo associamos o MaskedLabel a um formatador de data, para exibirmos "
			+"a data de nascimento do personagem.</p>")
	String htmlDescText();
}




