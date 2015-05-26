package org.cruxframework.crossdeviceshowcase.client.controller.samples.promobanner;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_promoBanner")
public interface PromoBannerMessages extends Messages
{
	@DefaultMessage("PromoBanner")
	String title();
	
	@DefaultMessage("Vida")
	String banner1title();
	
	@DefaultMessage("Apressa-te a viver bem e pensa que cada dia é, por si só, uma vida. (Sêneca)")
	String banner1text();
	
	@DefaultMessage("Sonhe e viva")
	String banner2title();
	
	@DefaultMessage("Sonhe como se fosse viver para sempre, viva como se fosse morrer amanhã. (James Dean)")
	String banner2text();
	
	@DefaultMessage("Viver")
	String banner3title();
	
	@DefaultMessage("Viver é a coisa mais rara do mundo. A maioria das pessoas apenas existe. (Oscar Wilde)")
	String banner3text();
	
	@DefaultMessage("<p>PromoBanner é um componente para promover algo: um produto, uma ideia, um assunto, entre outros.</p>" 	
			+"<p>Pode ser adaptado para o uso em dispositivos de tela grande como desktops e pequenos como celulares."
			+"Possui vários recursos como: transição automática de uma imagem para outra com determinação de intervalo, "
			+"programação do tempo de transição, botão para controle e entre outros.</p>")
	String htmlDescText();
}

