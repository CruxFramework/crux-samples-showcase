package org.cruxframework.showcasecore.client.remote.showcase;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

public interface SVNService extends RemoteService
{
	String getSourceFile(String path) throws ShowcaseException;
	List<String> listSourceFilesForView(String viewName) throws ShowcaseException;
}
