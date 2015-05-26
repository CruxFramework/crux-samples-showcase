package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_storyBoard")
public interface StoryBoardMessages extends Messages
{
	@DefaultMessage("Story Board")
	String title();
	
	@DefaultMessage("Você clicou em Adicionar ao carrinho!")
	String clicked();
	
	@DefaultMessage("Produto")
	String product();
	
	@DefaultMessage("Adicionar ao carrinho")
	String addCart();
	
	@DefaultMessage("<p>O Storyboard é um painel de distribuição de elementos que se adapta "
			+"ao tipo de dispositivo.</p>"
			+"<p>Em dispositivos de tela grande como desktops, os elementos são "
			+"distribuídos lado a lado até o final da largura determinada, gerando uma "
			+"quebra de linha automática e continuando o preenchimento com os elementos "
			+"até o final."
			+"Em dispositivos de tela pequena como celulares o processo é o mesmo, "
			+"porém os elementos são dispostos um abaixo do outro se adequando a "
			+"visibilidade do celular.</p>"
			+"<p>Os itens do Storyboard podem ser inseridos de forma declarativa ou "
			+"programática, possibilitando o uso de uma lista de dados como neste exemplo.</p>")
	String htmlDescText();
}

