package org.cruxframework.crossdeviceshowcase.client.controller.samples.messagebox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_messageBox")
public interface MessageBoxMessages extends Messages
{
	@DefaultMessage("Message Box")
	String title();
	
	@DefaultMessage("Mostrar Info")
	String showMessageBtnInfo();
	
	@DefaultMessage("Mostrar Sucesso")
	String showMessageBtnSuccess();
	
	@DefaultMessage("Mostrar Alerta")
	String showMessageBtnWarn();
	
	@DefaultMessage("Mostrar Erro")
	String showMessageBtnError();
		
	@DefaultMessage("Esta é uma mensagem do tipo: ")
	String messageType();	
	
	@DefaultMessage("<p>MessageBox é uma janela flutuante usada para exibir informações textuais ao usuário."
			+"De acordo com a categoria da mensagem exibida ( <code>INFO</code>, <code>SUCCESS</code>, "
			+"<code>WARN</code> ou <code>ERROR</code>), o MessageBox apresenta um estilo visual específico.</p>")
	String htmlDescText();
}
