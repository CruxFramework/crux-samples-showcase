package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabpanel;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_tabPanel")
public interface TabPanelMessages extends Messages
{
	@DefaultMessage("TabPanel")
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
}

