/**
 * 
 */
package org.cruxframework.showcasecore.client.resource;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

/**
 * @author Thiago da Rosa de Bustamante
 *
 */
@MessageName("messages_core")
public interface ShowcaseCoreMessages extends Messages
{
	//TODO fix this: https://github.com/CruxFramework/crux/issues/913
//	@DefaultMessage("O seu navegador não suporta a criação de bancos de dados locais.")
	@DefaultMessage("Database not supported by your browser")
	String databaseNotSupportedError();
	
//	@DefaultMessage("Código Fonte")
	@DefaultMessage("Source")
	String viewSourceCode();
	
//	@DefaultMessage("Carregando")
	@DefaultMessage("Loading")
	String loading();

//	@DefaultMessage("Enable Log")
	@DefaultMessage("Enable Log")
	String enableLog();

//	@DefaultMessage("X")
	@DefaultMessage("X")
	String disableLog();
}