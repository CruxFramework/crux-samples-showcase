package org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PersonDTO implements Serializable
{
	private static final long serialVersionUID = 3877579684349043370L;
	
	private String name;
	private int age;
	private Date birthday;
	private String status;
	
	public PersonDTO(String name, int age, Date birthday,List<PersonDTO> personList)
	{
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		if(personList != null)
		{
			personList.add(this);
		}
	}
	
	public PersonDTO(String name, int age, Date birthday,List<PersonDTO> personList,String status)
	{
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.status = status;
		if(personList != null)
		{
			personList.add(this);
		}
	}
	
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
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
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
}
