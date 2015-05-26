package org.cruxframework.crossdeviceshowcase.client.controller.samples.horizontalswappanel;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_horizontalSwapPanel")
public interface HorizontalSwapPanelMessages extends Messages
{
	@DefaultMessage("HorizontalSwapPanel")
	String title();
	
	@DefaultMessage("Clique nos botões abaixo para a trocar os componentes no painel")
	String labelClick();
	
	@DefaultMessage("Imagem")
	String buttonImage();
	
	@DefaultMessage("Botão")
	String buttonButton();
	
	@DefaultMessage("Painel")
	String buttonPanel();
	
	@DefaultMessage("<p>O HorizontalSwapPanel é um painel no qual é possível efetuar a troca de seu conteúdo "
			+ "utilizando animações em slide, podendo-se definir a direção da animação, duração de transição ou ainda disparar "
			+ "um evento no momento da troca.</p>"
			+ "<p>O conteúdo do painel pode ser qualquer outro componente válido. No exemplo acima foram "
			+ "utilizados os componentes Image, Button e até mesmo um outro painel simples contendo outros componentes.</p>")
	String htmlDescText();
}

