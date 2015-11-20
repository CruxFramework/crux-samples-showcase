package org.cruxframework.crossdeviceshowcase.client.controller.samples.datagrid;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("datagrid_messages")
public interface DataGridMessages extends Messages
{	
	@DefaultMessage("Nome")
	String name();
	
	@DefaultMessage("Último Name")
	String lastName();
	
	@DefaultMessage("Informações básicas")
	String basicinfo();
	
	@DefaultMessage("Idade")
	String age();
	
	@DefaultMessage("Profissão")
	String profession();

	@DefaultMessage("editar")
	String edit();

	@DefaultMessage("voltar")
	String back();

	@DefaultMessage("ok")
	String ok();

	@DefaultMessage("Ação")
	String action();

	@DefaultMessage("Editar todos")
	String editAll();

	@DefaultMessage("Consolidar alterações")
	String commit();

	@DefaultMessage("Desfazer alterações")
	String rollback();
}
