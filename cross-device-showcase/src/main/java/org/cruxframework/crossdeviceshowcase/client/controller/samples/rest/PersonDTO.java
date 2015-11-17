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
	private static int idCounter = 0;
	private Integer id;
	private String name;
	private String lastName;
	
	public PersonDTO()
	{
	}
	
	public PersonDTO(String name, String lastName)
	{
		this.id = idCounter++;
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
}
