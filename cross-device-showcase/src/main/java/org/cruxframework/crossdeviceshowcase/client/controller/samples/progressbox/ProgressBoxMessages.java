package org.cruxframework.crossdeviceshowcase.client.controller.samples.progressbox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_progressBox")
public interface ProgressBoxMessages extends Messages
{
	@DefaultMessage("Progress Box")
	String title();
	
	@DefaultMessage("Mostrar Progress Box")
	String showProgressBtn();
	
	@DefaultMessage("Por favor, aguarde por ")
	String pleaseWait();
			
	@DefaultMessage(" segundos... ")
	String seconds();
	
	@DefaultMessage("<p>ProgressBox é um componente flutuante, usado para para indicar ao usuário que algum " 
			+"processamento interno está ocorrendo e evitar que ele realize outras ações antes que o "
			+"processamento termine. Pode ser exibido e ocultado programaticamente. É bastante útil nas "
			+"chamadas a serviços remotos, devido à natureza assíncrona dessa comunicação.</p>")
	String htmlDescText();
}

