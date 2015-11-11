package org.cruxframework.crossdeviceshowcase.client.controller.samples.datagrid;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("datagrid_messages")
public interface DataGridMessages extends Messages
{	
	@DefaultMessage("Name")
	String name();
	
	@DefaultMessage("LastName")
	String lastName();
	
	@DefaultMessage("Basic Info")
	String basicinfo();
	
	@DefaultMessage("Age")
	String age();
	
	@DefaultMessage("Profession")
	String profession();

	@DefaultMessage("edit")
	String edit();

	@DefaultMessage("back")
	String back();

	@DefaultMessage("ok")
	String ok();

	@DefaultMessage("Action")
	String action();

	@DefaultMessage("Edit All")
	String editAll();

	@DefaultMessage("Commit Changes")
	String commit();

	@DefaultMessage("Rollback Changes")
	String rollback();
}
