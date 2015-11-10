package org.cruxframework.showcasecore.client.proxy;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.rest.RestProxy;
import org.cruxframework.crux.core.client.rest.RestProxy.TargetRestService;
import org.cruxframework.showcasecore.client.util.LoadingCallback;

@TargetRestService("sourceCodeService")
public interface SourceCodeRestProxy extends RestProxy
{
	void getSourceFile(String path, LoadingCallback<String> response);
	void listSourceFilesForView(String viewName, LoadingCallback<ArrayList<String>> response);
}
