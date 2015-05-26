package org.cruxframework.crossdeviceshowcase.client.controller.samples.grid;

import java.util.List;

import org.cruxframework.crux.core.client.datasource.LocalPagedDataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSourceRecordIdentifier;

@DataSource("customerDS")
@DataSourceRecordIdentifier("company")
public class CustomerDS extends LocalPagedDataSource<CustomerDTO>
{
	private List<CustomerDTO> customers;
	
	public List<CustomerDTO> getCustomers()
	{
		return customers;
	}

	public void setCustomers(List<CustomerDTO> customers)
	{
		this.customers = customers;
	}
	
	@Override
	public void load()
	{
		updateData(getCustomers());
	}
}
