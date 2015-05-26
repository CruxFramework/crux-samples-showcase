package org.cruxframework.crossdeviceshowcase.client.controller.samples.swappanel;

import java.util.List;

import org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid.PersonDTO;
import org.cruxframework.crux.core.client.datasource.LocalPagedDataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSourceRecordIdentifier;

@DataSource("simplePersonDS")
@DataSourceRecordIdentifier("name")
public class SimplePersonDS extends LocalPagedDataSource<PersonDTO>
{
	private List<PersonDTO> persons;
	
	public List<PersonDTO> getPersons()
	{
		return persons;
	}

	public void setPersons(List<PersonDTO> persons)
	{
		this.persons = persons;
	}


	@Override
	public void load()
	{
		updateData(getPersons());
	}

}
