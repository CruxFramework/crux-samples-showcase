package org.cruxframework.crossdeviceshowcase.client.controller.samples.colorpickerdialog;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_colorPickerDialog")
public interface ColorPickerDialogMessages extends Messages
{
	@DefaultMessage("Color Picker")
	String title();
	 
	@DefaultMessage("Clique no botão abaixo para mudar a cor deste texto.")
	String labelClickButton();
	
	@DefaultMessage("Cor escolhida:")
	String labelColorValue();
	
	@DefaultMessage("Mude a cor")
	String buttonChangeColor();
	
	@DefaultMessage("Escolha a cor")
	String colorPickerText();
	
	@DefaultMessage("<p>O Color Picker é um componente que permite que o usuário selecione uma cor do espectro de "
			+"cores e aplique esta cor para um elemento determinado. A funcionalidade é semelhante selecionadores " 
			+"de cores encontrados em softwares desktop.</p>")
	String htmlDescText();
}
