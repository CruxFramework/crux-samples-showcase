package org.cruxframework.crossdeviceshowcase.client.controller.samples.rollingtabpanel;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_rollingTabPanel")
public interface RollingTabPanelMessages extends Messages
{
	@DefaultMessage("RollingTabPanel")
	String title();
	
	@DefaultMessage("Esta aba contém apenas o componente botão.")
	String clickTab1();
	
	@DefaultMessage("Note que o título 'página 2' é uma imagem, mas poderia ser qualquer outro elemento HTML válido.")
	String clickTab2();
	
	@DefaultMessage("Perceba que este evento foi disparado pelo clique na aba 'página 3'")
	String clickTab3();
	
	@DefaultMessage("Clique-me!")
	String buttonClickMe();
	
	@DefaultMessage("Nome:")
	String formName();
	
	@DefaultMessage("Idade:")
	String formAge();
	
	@DefaultMessage("Endereço:")
	String formAdress();
	
	@DefaultMessage("Este é um painel completo")
	String labelPanel();
	
	@DefaultMessage("Contém um componente de painel, labels, imagem e botões.")
	String labelPanelContent();
	
	@DefaultMessage("Botão 1")
	String button1();
	
	@DefaultMessage("Botão 2")
	String button2();
	
	@DefaultMessage("<p>RollingTabPanel é um painel onde é possível apresentar várias páginas no mesmo espaço, "
			+ "sendo que a troca do conteúdo a ser visualizado é feita através de abas.</p>"
			+ "<p>Este componente possui uma animação para a transição das páginas que pode ser ativada ou não. "
			+ "Cada aba do componente pode váriar entre opções de título (da aba) e conteúdo. As abas podem conter "
			+ "qualquer componente válido, desde um simples botão até um painel completo como no exemplo da página 3.</p>")
	String htmlDescText();
}

