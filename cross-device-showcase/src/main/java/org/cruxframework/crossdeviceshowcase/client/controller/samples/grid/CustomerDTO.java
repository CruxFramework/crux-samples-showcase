package org.cruxframework.crossdeviceshowcase.client.controller.samples.grid;

import java.io.Serializable;

public class CustomerDTO implements Serializable
{	
	private static final long serialVersionUID = 8443393820212497006L;
	
	private String code;
	private String company;
	private String contactName;
	private String email;
	
	public CustomerDTO()
	{
	}
	
	public CustomerDTO(String code, String company, String contactName, String email)
	{
		this.code = code;
		this.company = company;
		this.contactName = contactName;
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
