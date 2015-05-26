package org.cruxframework.crossdeviceshowcase.client.controller.samples.image;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_image")
public interface ImageMessages extends Messages
{
	@DefaultMessage("Image")
	String title();
	
	@DefaultMessage("Coliseu - Itália")
	String titleImage1();
	
	@DefaultMessage("Torre Eiffel - França")
	String titleImage2();
	
	@DefaultMessage("Estátua da Liberdade - Estados Unidos")
	String titleImage3();
	
	@DefaultMessage("O Coliseu, é um anfiteatro construído no período da Roma Antiga. Deve seu nome à expressão latina "
			+ "Colosseum (ou Coliseus, no latim tardio), devido à estátua colossal do imperador romano Nero, que ficava "
			+ "perto da edificação. Localizado no centro de Roma, é uma exceção em anfiteatros por seu volume e relevo "
			+ "arquitetônico. Originalmente capaz de abrigar perto de 50.000 pessoas , e com 48 metros de altura, era usado "
			+ "para variados espetáculos.")
	String informImage1();
	
	@DefaultMessage("A Torre Eiffel é uma torre treliça de ferro do século XIX localizada no Champ de Mars, em Paris, que se "
			+ "tornou um ícone mundial da França e uma das estruturas mais reconhecidas no mundo. A Torre Eiffel, que é o "
			+ "edifício mais alto de Paris, é o monumento pago mais visitado do mundo. Nomeada em homenagem ao seu projetista, "
			+ "o engenheiro Gustave Eiffel, foi construída como o arco de entrada da Exposição Universal de 1889.")
	String informImage2();
	
	@DefaultMessage("A Estátua da Liberdade é um monumento inaugurado em 28 de outubro de 1886, construído na Ilha da "
			+ "Liberdade, na entrada do Porto de Nova Iorque. O Monumento comemora o centenário da assinatura da Declaração "
			+ "da Independência dos Estados Unidos e é um gesto de amizade da França para com os Estados Unidos. Foi projetada "
			+ "e construída pelo escultor alsaciano Frédéric Auguste Bartholdi (1834-1904) com a assistência do engenheiro "
			+ "francês Gustave Eiffel para a construção da estrutura metálica interna da estátua.")
	String informImage3();
	
	@DefaultMessage("<p>O componente Image exibe imagens em formatos padrão da web (png, gif, jpg) com ajuste de tamanho (altura e largura).</p>"
			+ "<p>No exemplo apresentado, ao clicar em uma imagem, seu tamanho é modificado e suas informações são apresentadas logo abaixo.</p>")
	String htmlDescText();
}
