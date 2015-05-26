package org.cruxframework.crossdeviceshowcase.client.controller.samples.slideshow;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_slideshow")
public interface SlideshowMessages extends Messages
{
	@DefaultMessage("Slideshow")
	String title();
	
	@DefaultMessage("<p>O Slideshow é um componente usado para apresentação de imagens, de forma otimizada para "
			+"cada tipo de dispositivo. Suporta descrições, miniaturas, pré-carga das próximas imagens, "
			+"cache local de imagens visualizadas, redimensionamento automático de imagens, agrupamento "
			+"em álbuns, etc.</p>"
			+"<p>Possui um modelo flexível que permite ao desenvolvedor adaptar praticamente qualquer "
			+"modelo de layout desejado, além de realizar integração com APIs externas de serviços de " 
			+"imagens, como o Picasa.</p>")
	String htmlDescText();
}

