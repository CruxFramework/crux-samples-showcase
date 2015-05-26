package org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_adaptivegrid")
public interface AdaptiveGridMessages extends Messages
{
	@DefaultMessage("Adaptive Grid")
	String title();
	
	@DefaultMessage("Ativo")
	String active();
	
	@DefaultMessage("Inativo")
	String inactive();
	
	@DefaultMessage("Nome")
	String name();
	
	@DefaultMessage("Idade")
	String age();
	
	@DefaultMessage("Estado")
	String status();
	
	@DefaultMessage("Dia de Nascimento")
	String dayOfBirth();
	
	@DefaultMessage("<p>O componente DeviceAdaptiveGrid permite exibir as colunas de acordo com o tipo de dispositivo "
			+ "que o está visualizado. Para dispositivos com display grande (PC, tablet etc.), o grid exibirá "
			+ "as colunas definidas na tag <largeColumns>, já para dispositivos pequenos, ele exibirá as "
			+ "colunas definidas na tag <smallColumns>.</p>")
	String htmlDescText();
}
