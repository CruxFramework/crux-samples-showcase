package org.cruxframework.crossdeviceshowcase.client.controller.samples.singleselect;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_singleSelect")
public interface SingleSelectMessages extends Messages
{
	@DefaultMessage("Single Select")
	String title();
	
	@DefaultMessage("Escolha um dos departamentos e em seguida selecione um dos funcionários listados.")
	String labelText();
	
	@DefaultMessage("Departamentos")
	String labelDepartments();
	
	@DefaultMessage("Funcionários")
	String labelEmployees();
	
	@DefaultMessage("Contabilidade")
	String labelAccounting();
	
	@DefaultMessage("Marketing")
	String labelMarketing();
	
	@DefaultMessage("Produção")
	String labelProduction();
	
	@DefaultMessage("Você selecionou o funcionário(a) ")
	String messageItemSelectedEmployee();
	
	@DefaultMessage(" do departamento de ")
	String messageItemSelectedEmployeeContinue();
	
	@DefaultMessage("<p>O componente Single Select é uma caixa de listagem de seleção única e simples. "
			+ "Os ítens podem ser adicionados de forma declarativa e programática e também pode-se definir "
			+"se algum ítem já iniciará selecionado ou não.</p>" 	
			+"<p>No exemplo apresentado, os ítens da caixa à direita somente serão carregados a partir da seleção de um ítem na caixa à esquerda.</p>")
	String htmlDescText();
}
