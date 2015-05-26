package org.cruxframework.crossdeviceshowcase.client.controller.samples;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_showcase")
public interface ShowcaseMessages extends Messages
{
	@DefaultMessage("Bem-vindo")
	String shortWelcome();
	
	@DefaultMessage("Site")
	String site();
	
	@DefaultMessage("Projeto")
	String project();
	
	@DefaultMessage("Bem-vindo ao Crux 5 Showcase!")
	String welcome();
	
	@DefaultMessage("O Crux Framework 5 provê uma série de componentes cross-device para aplicações Web."
			+ "Neste showcase são apresentados exemplos de uso dos componentes oferecidos pelo Crux.") 
	String info1();
	
	@DefaultMessage("Em cada exemplo é apresentado o componente, como é o seu funcionamento e sua apresentação na tela."
			+ "Também está disponível para consulta o código fonte de cada exemplo.")
	String info2();
	
	@DefaultMessage("Este site está em construção, a cada dia novos exemplos são elaborados e adicionados ao showcase.")
	String info3();
	
	@DefaultMessage("Elementos de Formulário")
	String formElements();
	
	@DefaultMessage("Elementos de Layout")
	String layoutElements();
	
	@DefaultMessage("Caixas de Diálogo")
	String dialogBoxes();
	
	@DefaultMessage("Elementos de Dados")
	String dataElements();
	
	@DefaultMessage("Elementos de Imagem")
	String imageElements();
	
	@DefaultMessage("Elementos de Informação")
	String infoElements();
	
	@DefaultMessage("Database não suportada")
	String databaseNotSupportedError();
	
	@DefaultMessage("Elementos de menu e Lista")
	String menuElements();
	
	@DefaultMessage("Elementos diversos")
	String miscellaneousElements();
	
}
