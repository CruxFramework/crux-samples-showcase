package org.cruxframework.crossdeviceshowcase.shared.dto;

import java.io.Serializable;

/**
 * @author samuel.cardoso
 *
 */
public class MyDTO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String a;
	private int b;
	
	public String getA() 
	{
		return a;
	}
	public void setA(String a) 
	{
		this.a = a;
	}
	public int getB() 
	{
		return b;
	}
	public void setB(int b) 
	{
		this.b = b;
	}
}
