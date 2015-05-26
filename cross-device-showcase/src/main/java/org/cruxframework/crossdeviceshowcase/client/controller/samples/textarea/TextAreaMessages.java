package org.cruxframework.crossdeviceshowcase.client.controller.samples.textarea;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_textArea")
public interface TextAreaMessages extends Messages
{
	@DefaultMessage("Text Area")
	String title();
	
	@DefaultMessage("Um Text Area com max-length (comprimento) dinâmico:")
	String labelText();
	
	@DefaultMessage("Insira um novo número abaixo e clique em 'Aplicar' para mudar o max-length")
	String textArea();
	
	@DefaultMessage("Aplicar")
	String applyButton();
	
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
	
	@DefaultMessage("Por favor, insira um valor inteiro válido como: 50, 73, 95 etc.")
	String invalidNumber();
	
	@DefaultMessage("Por favor, insira um valor positivo.")
	String negativeNumber();
	
	@DefaultMessage("<p>Text Area é um campo de texto multi-linha, que poder ser definido por número de linhas e número máximo de caracteres (maxLength). </p>" 
					+"<p>Neste exemplo o número máximo de caracteres se inicia em 150, insira um novo número, clique em aplicar e faça o teste.</p>")
	String htmlDescText();
}




