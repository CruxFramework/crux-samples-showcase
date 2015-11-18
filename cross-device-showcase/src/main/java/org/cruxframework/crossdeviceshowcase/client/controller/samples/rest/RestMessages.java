package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("rest_messages")
public interface RestMessages extends Messages
{	
	@DefaultMessage("Erro de conexão: {0}")
	String connectionError(String msg);

	@DefaultMessage("id")
	String id();
	
	@DefaultMessage("Nome")
	String name();
	
	@DefaultMessage("Último nome")
	String lastName();
	
	@DefaultMessage("Remover")
	String remove();

	@DefaultMessage("Salvar")
	String save();

	@DefaultMessage("Criar")
	String create();
	
	@DefaultMessage("Registro atualizado com sucesso.")
	String successUpdate();

	@DefaultMessage("Registro salvo com sucesso.")
	String successSave();

	@DefaultMessage("Registro removido com sucesso.")
	String successRemove();

	@DefaultMessage("Por favor, selecione uma pessoa para continuar.")
	String selectPerson();
}
