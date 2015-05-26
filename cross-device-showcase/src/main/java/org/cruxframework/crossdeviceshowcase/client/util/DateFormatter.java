package org.cruxframework.crossdeviceshowcase.client.util;

import java.util.Date;

import org.cruxframework.crux.core.client.formatter.Formatter;
import org.cruxframework.crux.core.client.formatter.InvalidFormatException;
import org.cruxframework.crux.core.client.formatter.annotation.FormatterName;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;

/**
 * Formatter for date fields.
 */
@FormatterName("dateFormatter")
public class DateFormatter implements Formatter
{
	private DateTimeFormat formatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM);
	
	@Override
	public String format(Object input) throws InvalidFormatException
	{
		return formatter.format((Date) input);
	}

	@Override
	public Object unformat(String input) throws InvalidFormatException
	{
		return formatter.parse(input);
	}

}
