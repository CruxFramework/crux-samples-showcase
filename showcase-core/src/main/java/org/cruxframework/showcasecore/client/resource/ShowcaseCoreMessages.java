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
	@DefaultMessage("O seu navegador não suporta a criação de bancos de dados locais.")
	String databaseNotSupportedError();
}
