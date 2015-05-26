package org.cruxframework.crossdeviceshowcase.client.controller.samples.sequentialpager;

import java.util.List;

import org.cruxframework.crux.core.client.datasource.LocalPagedDataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSource;
import org.cruxframework.crux.core.client.datasource.annotation.DataSourceRecordIdentifier;

@DataSource("discDS")
@DataSourceRecordIdentifier("artistName")
public class DiscDS extends LocalPagedDataSource<DiscDTO>
{
	private List<DiscDTO> discs;
	
	public List<DiscDTO> getDiscs()
	{
		return discs;
	}

	public void setDiscs(List<DiscDTO> discs)
	{
		this.discs = discs;
	}
	
	@Override
	public void load()
	{
		updateData(getDiscs());
	}
}
