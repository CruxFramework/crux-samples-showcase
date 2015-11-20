package org.cruxframework.crossdeviceshowcase.client.controller.samples.datagrid;

import org.cruxframework.crux.core.client.dto.DataObject;

@DataObject("personGrid")
public class Person 
{
	private static int idCounter = 0;
	private int id;
	private String name;
	private String lastName;
	private int age;
	private String profession;

	public Person()
	{
	}
	
	public Person(String name, String lastName, int age, String profession)
	{
		this.id = idCounter++;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.profession = profession;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getProfession() 
	{
		return profession;
	}

	public void setProfession(String profession) 
	{
		this.profession = profession;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
}