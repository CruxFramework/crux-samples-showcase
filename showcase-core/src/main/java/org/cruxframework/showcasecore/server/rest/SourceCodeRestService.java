package org.cruxframework.showcasecore.server.rest;

import java.io.IOException;
import java.util.ArrayList;

import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.PathParam;
import org.cruxframework.showcasecore.server.GitExplorer;
import org.json.JSONException;

@RestService("sourceCodeService")
@Path("source")
public class SourceCodeRestService
{
	@GET
	@Path("sourceFile/{path}")
	public String getSourceFile(@PathParam("path") String path)
	{
		try
		{
			return GitExplorer.getSourceFile(path);
		}
		catch (IOException | JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("listSourceFiles/{viewName}")
	public ArrayList<String> listSourceFilesForView(@PathParam("viewName") String viewName)
	{
		try
		{
			return GitExplorer.getListSourceFilesForView(viewName.toLowerCase().trim());
		}
		catch (IOException | JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
