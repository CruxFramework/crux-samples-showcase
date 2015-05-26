package org.cruxframework.crossdeviceshowcase.client.controller.samples.horizontalswapviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_horizontalSwapViewContainer")
public interface HorizontalSwapViewContainerMessages extends Messages
{
	@DefaultMessage("HorizontalSwapViewContainer")
	String title();
	
	@DefaultMessage("Número de trocas efetuadas")
	String labelCount();
	
	@DefaultMessage("Escolha a direção da transição")
	String labelDirection();
	
	@DefaultMessage("Para trás")
	String rbDirectionBackward();
	
	@DefaultMessage("Para frente")
	String rbDirectionForward();

	@DefaultMessage("<p>O HorizontalSwapViewContainer é um container de views (pode conter várias) que utiliza "
			+ "animações em slide para efetuar a troca das views.</p> "
			+ "<p>A animação pode ser habilitada em dispositivos de tela grande como desktops, ou pequena como celulares "
			+ "e ainda é possível definir o tempo de transição, a direção (no exemplo: Para trás ou Para frente) "
			+ "ou disparar um evento no momento da troca das views (contagem do número de trocas das views do exemplo).</p>")
	String htmlDescText(); 
}