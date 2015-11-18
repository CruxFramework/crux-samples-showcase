package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import java.io.Serializable;

import org.cruxframework.crux.core.client.dto.DataObject;

/**
 * @author samuel.cardoso
 *
 */
@DataObject("personRest")
public class PersonDTO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String lastName;
	
	public PersonDTO()
	{
	}
	
	public PersonDTO(int id, String name, String lastName)
	{
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PersonDTO other = (PersonDTO) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
}
