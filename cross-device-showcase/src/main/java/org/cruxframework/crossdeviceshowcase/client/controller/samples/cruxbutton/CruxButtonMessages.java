package org.cruxframework.crossdeviceshowcase.client.controller.samples.cruxbutton;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_cruxButton")
public interface CruxButtonMessages extends Messages
{
	@DefaultMessage("Button")
	String title();
	
	@DefaultMessage("Eu sou um botão!")
	String cruxBtn();
	
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
	
	@DefaultMessage("<p>Buttons são elementos que disparam ações quando clicados, este componente foi feito pensando também em " 
					+"dispositivos de toque, tratando os eventos de forma diferenciada em um smartphone ou tablet, por exemplo.</p>")
	String htmlDescText();
}