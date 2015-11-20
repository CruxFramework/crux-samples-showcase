package org.cruxframework.showcasecore.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;

public class GitExplorer
{
	private static final String SLASH = "/";
	private final static Logger LOGGER = Logger.getLogger(GitExplorer.class.getName()); 
	private static final String ENCODING = "UTF-8";
	private static final String BRANCH = "?ref=master";
	private static final String BASE_URL = "https://api.github.com/repos/CruxFramework/crux-samples-showcase/contents/cross-device-showcase/";
	private static final String CONTROLLER_PATH = "src/main/java/org/cruxframework/crossdeviceshowcase/client/controller/samples/";
	private static final String VIEW_PATH = "src/main/resources/org/cruxframework/crossdeviceshowcase/client/view/samples/";
	private static final String SERVER_PATH = "src/main/java/org/cruxframework/showcasecore/server/samples/";
	private static final String RAWPATH = "https://raw.githubusercontent.com/CruxFramework/crux-samples-showcase/master/cross-device-showcase/";

	private static String readAll(Reader rd) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) 
		{
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static JSONArray readJsonFromUrl(String url) 
	{
		InputStream is = null;
		try 
		{
			is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName(ENCODING)));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} catch (IOException e) 
		{
			//the file was not found on the server. We don't have to log here.
			//LOGGER.log(Level.SEVERE, "The response could not be deserialized.", e);
		} catch (JSONException e)
		{
			LOGGER.log(Level.SEVERE, "The JSON is not in a parsable format.");
		}
		finally 
		{
			if(is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					LOGGER.log(Level.SEVERE, "The buffer could not be closed.", e);
				}
			}
		}
		return null;
	}

	public static String getSourceFile(String path) throws IOException, JSONException
	{
		InputStream is = new URL(RAWPATH + path).openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName(ENCODING)));
		String source = readAll(rd);
		return source;
	}
	
	public static ArrayList<String> getListSourceFilesForView(String viewName) throws IOException, JSONException 
	{
		ArrayList<String> files = new ArrayList<String>();
		
		ArrayList<String> sourceControllerFiles = getSourceFilesForView(CONTROLLER_PATH, viewName);
		if(sourceControllerFiles != null)
		{
			files.addAll(sourceControllerFiles);
		}
		
		ArrayList<String> sourceViewFiles = getSourceFilesForView(VIEW_PATH, viewName);
		if(sourceViewFiles != null)
		{
			files.addAll(sourceViewFiles);
		}
		
		ArrayList<String> sourceServerFiles = getSourceFilesForView(SERVER_PATH, viewName);
		if(sourceServerFiles != null)
		{
			files.addAll(sourceServerFiles);
		}

		return files;
	}
	
	private static ArrayList<String> getSourceFilesForView(String path, String viewName) throws IOException, JSONException 
	{
		JSONArray json = readJsonFromUrl(BASE_URL + path + viewName + BRANCH);
		if(json != null)
		{
			ArrayList<String> files = new ArrayList<String>();
			for(int i=0; i<json.length(); i++)
			{
				String name = (String) json.getJSONObject(i).get("name");
				files.add(path + viewName + SLASH + name);
			}
			return files;
		}
		
		return null;
	}
}
