package org.cruxframework.showcasecore.server.rest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.RestException;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.PathParam;
import org.cruxframework.showcasecore.server.GitExplorer;
import org.json.JSONException;

@RestService("sourceCodeService")
@Path("source")
public class SourceCodeRestService
{
	private static final Log LOG = LogFactory.getLog(SourceCodeRestService.class);
	
	@GET
	@Path("sourceFile/{path}")
	public String getSourceFile(@PathParam("path") String path) throws RestException
	{
		try
		{
			return GitExplorer.getSourceFile(path);
		}
		catch (IOException | JSONException e)
		{
			LOG.error(e);
			throw new RestException(e);
		}
	}
	
	@GET
	@Path("listSourceFiles/{viewName}")
	public ArrayList<String> listSourceFilesForView(@PathParam("viewName") String viewName) throws RestException
	{
		try
		{
			ArrayList<String> listSourceFilesForView = GitExplorer.getListSourceFilesForView(viewName.toLowerCase().trim());
			if(listSourceFilesForView == null || listSourceFilesForView.isEmpty())
			{
				throw new RestException("GitHub souce code server offline. Try again later.");
			}
			return listSourceFilesForView;
		}
		catch (IOException | JSONException e)
		{
			LOG.error(e);
			throw new RestException(e);
		}
	}
}
