package org.cruxframework.crossdeviceshowcase.client.controller.samples.formdisplay;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_formDisplay")
public interface FormDisplayMessages extends Messages
{
	@DefaultMessage("Form Display")
	String title();
	
	@DefaultMessage("Versão:")
	String entryVersion();
	
	@DefaultMessage("Assunto:")
	String entrySubject();
	
	@DefaultMessage("Suporte:")
	String entrySupport();
	
	@DefaultMessage("Exemplos Cross-Device")
	String subjectTextBox();
	
	@DefaultMessage("Limpar campos")
	String btn();
	
	@DefaultMessage("<p>O propósito do FormDisplay é organizar os elementos de um formulário, "
			+"tornando mais simples a construção de telas cujo conteúdo seja essencialmente "
			+"de entrada de dados. Ele organiza os componentes de forma automática, provendo "
			+"diferentes posicionamentos de acordo com as características do dispositivo "
			+"cliente.</p>"
			+"<p>Em dispositivos de tela pequena, tais como smart phones, os componentes "
			+"são ordenados de forma vertical, evitando a rolagem horizontal da tela."
			+"Em dispositivos maiores, labels e componentes são alinhados lado a lado, aproveitando melhor "
			+"a largura da janela do navegador.</p>")
	String htmlDescText();
}




