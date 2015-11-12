package org.cruxframework.crossdeviceshowcase.client.controller.samples.widgetlist;

import org.cruxframework.crux.core.client.dto.DataObject;

@DataObject("carWidgetList")
public class Car 
{
	private static int idCounter = 0;
	private int id;
	private String brand;
	private String source;
	private int year;

	public Car()
	{
	}
	
	public Car(String brand, String source, int year)
	{
		this.id = idCounter++;
		this.source = source;
		this.brand = brand;
		this.year = year;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}
	
	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}