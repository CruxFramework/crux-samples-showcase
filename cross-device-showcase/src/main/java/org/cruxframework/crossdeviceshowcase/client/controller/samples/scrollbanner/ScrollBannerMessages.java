package org.cruxframework.crossdeviceshowcase.client.controller.samples.scrollbanner;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_scrollBanner")
public interface ScrollBannerMessages extends Messages
{
	@DefaultMessage("Scroll Banner")
	String title();
	
	@DefaultMessage("Três Leis de Asimov")
	String initMessage();
	
	@DefaultMessage("1. Um robô não pode ferir um ser humano ou, por inação, permitir que um ser humano sofra algum mal.")
	String message1();
	
	@DefaultMessage("2. Um robô deve obedecer às ordens dadas por seres humanos, exceto quando essas ordens entrarem em conflito com a Primeira Lei.")
	String message2();
	
	@DefaultMessage("3. Um robô deve proteger sua própria existência desde que tal proteção não entre em conflito com a Primeira ou a Segunda Lei.")
	String message3();
	
	@DefaultMessage("Esta mensagem foi adicionada através de uma controller.")
	String programMessage();
	
	@DefaultMessage("<p>O ScrollBanner é um componente para mostrar várias mensagens de texto, uma de cada vez, "
			+"apresentadas de forma periódica e sequencial."
			+"As mensagens podem ser adicionadas de forma declarativa ou programática e o tempo de transição "
			+"entre elas é definido no próprio componente.</p>"
			+"<p>No exemplo acima as 2 primeiras mensagens foram adicionadas de forma declarativa e as últimas "
			+"de forma programática através da controller.</p>")
	String htmlDescText();
}


