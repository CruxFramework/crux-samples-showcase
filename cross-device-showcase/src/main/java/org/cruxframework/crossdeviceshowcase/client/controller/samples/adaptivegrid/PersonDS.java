package org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid;

import java.util.List;

import org.cruxframework.crux.core.client.datasource.LocalPagedDataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSourceRecordIdentifier;

@DataSource("personDS")
@DataSourceRecordIdentifier("name")
public class PersonDS extends LocalPagedDataSource<PersonDTO>
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
