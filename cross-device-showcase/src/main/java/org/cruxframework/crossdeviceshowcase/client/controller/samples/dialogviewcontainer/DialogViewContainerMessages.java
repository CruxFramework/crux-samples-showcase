package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_dialogViewContainer")
public interface DialogViewContainerMessages extends Messages
{
	@DefaultMessage("Dialog View Container")
	String title();
	
	@DefaultMessage("Mostrar Dialog")
	String buttonShowDialog();
	
	@DefaultMessage("<p>Dialog View Container é um container de views que utiliza uma caixa de diálogo "
			+ "flutuante para apresentá-las.</p> <p>No exemplo apresentado 2 views são carregadas em momentos "
			+ "diferentes, cada uma delas possui um botão para chamar e carregar a próxima view no container.</p>")
	String htmlDescText();
}
