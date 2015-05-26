package org.cruxframework.crossdeviceshowcase.client.controller.samples.listshuttle;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_listShuttle")
public interface ListShuttleMessages extends Messages
{
	@DefaultMessage("List Shuttle")
	String title();
	 
	@DefaultMessage("Monte seu time com os jogadores disponíveis:")
	String labelChoosePlayers();
	
	@DefaultMessage("Disponíveis")
	String availableHeader();
	
	@DefaultMessage("Escalados")
	String selectedHeader();
	
	@DefaultMessage("<p>O ListShuttle é um componente que possibilita a transferência de ítens de uma lista para outra. " 
			+ "É possível transferir um, vários ou todos os elementos de uma só vez.</p>"
			+ "<p>No exemplo apresentado os ítens das listas foram adicionados através de uma controller, " 
			+ "possibilitando buscar estas informações de uma fonte de dados.</p>")
	String htmlDescText();
}
