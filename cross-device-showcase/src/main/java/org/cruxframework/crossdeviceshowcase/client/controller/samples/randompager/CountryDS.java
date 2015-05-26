package org.cruxframework.crossdeviceshowcase.client.controller.samples.randompager;

import java.util.List;

import org.cruxframework.crux.core.client.datasource.LocalPagedDataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSourceRecordIdentifier;

@DataSource("countryDS")
@DataSourceRecordIdentifier("country")
public class CountryDS extends LocalPagedDataSource<CountryDTO>
{
	private List<CountryDTO> countries;
	
	public List<CountryDTO> getCountries()
	{
		return countries;
	}

	public void setCountries(List<CountryDTO> countries)
	{
		this.countries = countries;
	}
	
	@Override
	public void load()
	{
		updateData(getCountries());
	}
}
