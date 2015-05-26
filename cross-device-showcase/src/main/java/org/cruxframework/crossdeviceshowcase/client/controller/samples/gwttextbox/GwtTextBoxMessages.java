package org.cruxframework.crossdeviceshowcase.client.controller.samples.gwttextbox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_gwtTextBox")
public interface GwtTextBoxMessages extends Messages
{
	@DefaultMessage("Textbox")
	String title();
	
	@DefaultMessage("Edite-me.")
	String gwtTxtBox();
	
	@DefaultMessage("Estados:")
	String h4();
	
	@DefaultMessage("Padrão")
	String radioDefault();
	
	@DefaultMessage("Sucesso")
	String radioSuccess();
	
	@DefaultMessage("Alerta")
	String radioWarning();
	
	@DefaultMessage("Erro")
	String radioError();
	
	@DefaultMessage("<p>Textboxes são campos de texto simples fornecidos pelo GWT. Podem ser estilizados dependendo do seu estado, " 
					+"e mostram de forma visal seu estado atual para o usuário.</p>")
	String htmlDescText();
}




