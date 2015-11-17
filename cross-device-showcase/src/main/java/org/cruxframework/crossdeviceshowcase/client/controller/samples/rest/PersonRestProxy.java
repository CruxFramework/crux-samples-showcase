package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.rest.RestProxy;
import org.cruxframework.crux.core.client.rest.RestProxy.TargetRestService;

@TargetRestService("personRestService")
public interface PersonRestProxy extends RestProxy
{
	void remove(Integer id, Callback<Void> callback);
	
	void save(PersonDTO person, Callback<Integer> callback);
	
	void update(Integer id, PersonDTO person, Callback<Void> callback);
	
	void get(Integer id, Callback<PersonDTO> callback);
	
	void search(Callback<ArrayList<PersonDTO>> callback);
}