package org.cruxframework.crossdeviceshowcase.client.controller.samples.staledpanel;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_styledPanel")
public interface StyledPanelMessages extends Messages
{
	@DefaultMessage("Styled Panel")
	String title();
	
	@DefaultMessage("Eu sou um button")
	String btnSample();
	
	@DefaultMessage("Eu sou um label")
	String txtSample();
	
	@DefaultMessage("<p>O StyledPanel é um painel simples, cuja utilidade é agrupar " 
			+"visualmente componentes que possuem algum tipo de relação entre si. Em geral, é usado para "
			+"delimitar fomrulários, menus e criar barras de ferramentas. Sua estrutura interna é leve, sendo "
			+"constituído por duas DIVs aninhadas, o que permite uma grande flexibilidade de estilização "
			+"através dos recursos CSS3.</p>"
			+"<p>Suporta apenas um componente em seu interior, pois não provê nenhum recurso para alinhamento "
			+"dos componentes internos. Dessa forma, para abrigar diversos componentes dentro de um StyledPanel, "
			+"é necessário agrupá-los logicamente em outro componente que possua essa capacidade, como, por exemplo, "
			+"o FormDisplay.</p>")
	String htmlDescText();
}
