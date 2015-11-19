package org.cruxframework.crossdeviceshowcase.client.controller.samples.pagers;

import org.cruxframework.crux.core.client.dto.DataObject;

@DataObject("personPagers")
public class Person 
{
	private String name;
	private String lastName;

	public Person()
	{
	}
	
	public Person(String name, String lastName)
	{
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (lastName == null)
		{
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
}