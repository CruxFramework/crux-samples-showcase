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
	
	@DefaultMessage("O Crux Framework 5 provê uma série de componentes cross-device para aplicações Web. "
			+ "Neste showcase são apresentados exemplos de uso dos componentes oferecidos pelo Crux.") 
	String info1();
	
	@DefaultMessage("Em cada exemplo é apresentado o componente, como é o seu funcionamento e sua apresentação na tela. "
			+ "Também está disponível para consulta o código fonte de cada exemplo.")
	String info2();
	
	@DefaultMessage("Atualmente o crux mantém duas bibliotecas de componentes: SmartFaces e Widgets.")
	String info3();

	@DefaultMessage("Componentes que exploram os novos padrões HTML5 e CSS3, disponíveis para os browsers mais modernos.")
	String facesText();
	
	@DefaultMessage("Componentes que possuem implementações compatíveis com browsers antigos.")
	String widgetText();
	
	@DefaultMessage("Biblioteca: ")
	String library();
	
	@DefaultMessage("Browsers compatíveis:")
	String browsers();
	
	@DefaultMessage("Elementos de Formulário")
	String formElements();
	
	@DefaultMessage("Layouts e Painéis")
	String layoutsAndPanels();
	
	@DefaultMessage("Caixas de Diálogo")
	String dialogBoxes();
	
	@DefaultMessage("Elementos de Dados")
	String dataElements();
	
	@DefaultMessage("Imagens e Outros")
	String imagesAndOthers();

	@DefaultMessage("Menus e Listas")
	String menusAndLists();
	
	@DefaultMessage("Funcionalidades Lógicas")
	String logicalFeatures();
	
	@DefaultMessage("Database não suportada")
	String databaseNotSupportedError();
	
}
