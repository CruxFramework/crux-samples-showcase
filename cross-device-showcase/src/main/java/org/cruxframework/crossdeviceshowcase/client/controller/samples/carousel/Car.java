package org.cruxframework.crossdeviceshowcase.client.controller.samples.carousel;

import org.cruxframework.crux.core.client.dto.DataObject;

@DataObject("carCarousel")
public class Car 
{
	private Integer id;
	private String brand;
	private String source;
	private int year;

	public Car()
	{
	}
	
	public Car(Integer id, String brand, String source, int year)
	{
		this.id = id;
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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
}