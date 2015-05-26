package org.cruxframework.crossdeviceshowcase.client.controller.samples.randompager;

import java.io.Serializable;


public class CountryDTO implements Serializable
{	
	private static final long serialVersionUID = -1342454642270818357L;
	
	private String flag;
	private String country;
	private String capital;
	private String continent;
	
	public CountryDTO()
	{
	}
			
	public CountryDTO(String flag, String country, String capital, String continent)
	{
		this.flag = flag;
		this.country = country;
		this.capital = capital;
		this.continent = continent;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
}
