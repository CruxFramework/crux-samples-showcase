package org.cruxframework.crossdeviceshowcase.client.controller.samples.timer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_timer")
public interface TimerMessages extends Messages
{
	@DefaultMessage("Timer")
	String title();
	
	@DefaultMessage("Iniciar")
	String buttonStart();
	
	@DefaultMessage("Parar")
	String buttonStop();
	
	@DefaultMessage("Reiniciar")
	String buttonRestart();
	
	@DefaultMessage("Zerar")
	String buttonClear();
	
	@DefaultMessage("Chegamos em 10 segundos.")
	String warnTime();
	
	@DefaultMessage("<p>O componente timer é um contador de tempo capaz de disparar eventos programados. Este componente "
			+ "Também permite ativar contagem regressiva ou definir um determinado valor para início da contagem.</p>"
			+ "<p>No exemplo apresentado o Timer realiza as funções de um cronômetro que se inicia automaticamente e dispara "
			+ "uma mensagem quando alcança a contagem de 10 segundos.</p>")
	String htmlDescText();
}
