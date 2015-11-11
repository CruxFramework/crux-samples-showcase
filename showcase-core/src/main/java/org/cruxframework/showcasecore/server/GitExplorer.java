package org.cruxframework.showcasecore.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GitExplorer
{
	private static final String ENCODING = "UTF-8";
	private static final String RECURSIVE = "?recursive=1";
	private static final String BASE_URL = "https://api.github.com/repos/CruxFramework/crux-samples-showcase/git/trees/";
	private static final String CONTROLLER_HASH = "2c3b6759399f045cd49a9e8a3c8bcd1d5861c60c"; //src\main\java\org\cruxframework\crossdeviceshowcase\client\controller\samples
	private static final String VIEW_HASH = "1c494cf4e1ee22c4ad5e846317b2b04bf5e29a0b"; //src\main\resources\org\cruxframework\crossdeviceshowcase\client\view\samples
	private static final String SERVER_HASH = ""; //src\main\java\org\cruxframework\showcasecore\server\samples
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

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException 
	{
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName(ENCODING)));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
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
		
		files.addAll(getSourceFilesForView("src/main/java/org/cruxframework/crossdeviceshowcase/client/controller/samples/", CONTROLLER_HASH, viewName));
		files.addAll(getSourceFilesForView("src/main/resources/org/cruxframework/crossdeviceshowcase/client/view/samples/", VIEW_HASH, viewName));

		return files;
	}
	
	private static ArrayList<String> getSourceFilesForView(String urlPrefix, String hash, String viewName) throws IOException, JSONException 
	{
		ArrayList<String> files = new ArrayList<String>();
		
		JSONObject json = readJsonFromUrl(BASE_URL + hash + RECURSIVE);
		JSONArray list = (JSONArray) json.get("tree");
		for(int i=0; i<list.length(); i++)
		{
			String path = (String) list.getJSONObject(i).get("path");
			if(
				!StringUtils.isEmpty(path) 
				&& path.contains("/")
				&& ((path.split("/")[0]).trim()).equals(viewName.toLowerCase())
				)
			{
				files.add(urlPrefix + path);
			}
		}
		
		return files;
	}
}
