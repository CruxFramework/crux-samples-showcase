package org.cruxframework.crossdeviceshowcase.client.controller.samples.combobox;

import org.cruxframework.crux.core.client.dto.DataObject;

@DataObject("countryComboBox")
public class Country 
{
	private Integer id;
	private String name;
	private String capital;

	public Country()
	{
	}
	
	public Country(Integer id, String name, String capital)
	{
		this.id = id;
		this.name = name;
		this.capital = capital;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getCapital()
	{
		return capital;
	}

	public void setCapital(String capital)
	{
		this.capital = capital;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (id != other.id)
			return false;
		return true;
	}
}