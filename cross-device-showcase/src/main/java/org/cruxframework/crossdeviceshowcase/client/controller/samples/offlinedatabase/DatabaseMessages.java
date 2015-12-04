package org.cruxframework.crossdeviceshowcase.client.controller.samples.offlinedatabase;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("database_messages")
public interface DatabaseMessages extends Messages
{	
	@DefaultMessage("Adicionar")
	String addPerson();
	
	@DefaultMessage("Atualizar Lista")
	String updateList();
	
	@DefaultMessage("Edição de Pessoa")
	String editPerson();
	
	@DefaultMessage("Id")
	String id();
	
	@DefaultMessage("Nome")
	String name();
	
	@DefaultMessage("Data de Nascimento")
	String birthday();
	
	@DefaultMessage("Endereço")
	String address();
	
	@DefaultMessage("Número")
	String number();
	
	@DefaultMessage("Salvar")
	String save();
	
	@DefaultMessage("Remover")
	String remove();
	
	@DefaultMessage("Objeto salvo com sucesso!")
	String saveSuccessfully();
	
	@DefaultMessage("Objeto removido com sucesso!")
	String removeSuccessfully();
	
	@DefaultMessage("Sucesso")
	String success();
}