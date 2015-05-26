package org.cruxframework.crossdeviceshowcase.client.controller.samples.maskedtextbox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_maskedTextBox")
public interface MaskedTextBoxMessages extends Messages
{
	@DefaultMessage("Masked TextBox")
	String title();
	 
	@DefaultMessage("Insira uma data:")
	String ipLabel();
	
	@DefaultMessage("Verifique")
	String btnParseDate();
	
	@DefaultMessage("Por favor, preencha o campo vazio.")
	String emptyFild();

	@DefaultMessage("Por favor, informe uma data válida como: dd/mm/aaaa")
	String wrongFormat();
	
	@DefaultMessage("A data informada foi: ")
	String infoDate();
	
	@DefaultMessage("Você informou uma data inválida, por favor tente novamente.")
	String invalidDate();
	
	@DefaultMessage("<p>MaskedTextBox é um componente de entrada de informações que tem a capacidade de ser associado "
			+"a um Formatter para guiar o usuário durante o preenchimento e garantir a conversão dessas informações" 
			+"em dados tipados a serem consumidos pela aplicação.</p>"
			+"<p>Neste exemplo associamos o MaskedTextBox para ler uma data digitada pelo usuário.</p>")
	String htmlDescText();
}




