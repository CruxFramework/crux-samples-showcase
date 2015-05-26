package org.cruxframework.crossdeviceshowcase.client.controller.samples.fileuploader;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_fileUploader")
public interface FileUploaderMessages extends Messages
{	
	@DefaultMessage("File Uploader")
	String title();
	 
	@DefaultMessage("Escolha os arquivos")
	String inputText();
	
	@DefaultMessage("<p>O FileUploader é um componente capaz de transmitir arquivos existentes no "
			+"dispositivo cliente para o servidor de aplicação. Construído sobre a especificação "
			+"XMLHttpRequest 2, é capaz de enviar múltiplos arquivos simultaneamente e prover "
			+"feedback de progresso ao usuário. Além disso, caso um arquivo enviado seja uma imagem, "
			+"exibe uma miniatura desse arquivo, enriquecendo a usabilidade do sistema.</p>")
	String htmlDescText();
}
