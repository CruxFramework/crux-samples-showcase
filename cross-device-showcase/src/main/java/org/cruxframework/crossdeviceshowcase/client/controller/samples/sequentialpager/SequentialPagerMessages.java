package org.cruxframework.crossdeviceshowcase.client.controller.samples.sequentialpager;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_sequentialPager")
public interface SequentialPagerMessages extends Messages
{
	@DefaultMessage("SequentialPager")
	String title();
	
	@DefaultMessage("<p>SequentialPager é um componente.</p>")
	String htmlDescText();
}
