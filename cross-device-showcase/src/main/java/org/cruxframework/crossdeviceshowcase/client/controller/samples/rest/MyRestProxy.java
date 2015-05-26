package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import org.cruxframework.crossdeviceshowcase.shared.dto.MyDTO;
import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.rest.RestProxy;
import org.cruxframework.crux.core.client.rest.RestProxy.TargetRestService;

@TargetRestService("myRestService")
public interface MyRestProxy extends RestProxy
{
	void validate(String name, String password, Callback<MyDTO> callback);
	
	void save(String name, String password, Callback<Void> callback);
}