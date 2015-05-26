package org.cruxframework.crossdeviceshowcase.client.controller.samples.combobox;

import org.cruxframework.crux.core.client.dto.DataObject;

@DataObject("person")
public class Person 
{
	private String name; 
	private int age;
	private String profession;
	
	public Person(String name, int age, String profession)
	{
		this.name = name;
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
}
