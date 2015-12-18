package org.cruxframework.crossdeviceshowcase.server.service.samples.rest;

import java.util.ArrayList;
import java.util.Random;

import org.cruxframework.crossdeviceshowcase.client.controller.samples.rest.PersonDTO;
import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.annotation.DELETE;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.POST;
import org.cruxframework.crux.core.shared.rest.annotation.PUT;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.PathParam;

@RestService("personRestService")
@Path("/person")
public class PersonRestService
{
	private static final int MAX_VALUE_ID = 1000;
	private static ArrayList<PersonDTO> people = new ArrayList<PersonDTO>();
	private static Random random = new Random();
	
	static
	{
		mockMapFill();
	}
	
	private static int getRandomId()
	{
		return Math.abs(random.nextInt(MAX_VALUE_ID));
	}
	
	private static void mockMapFill()
	{
		people = new ArrayList<PersonDTO>();
		people.add(new PersonDTO(getRandomId(), "John", "Nash"));
		people.add(new PersonDTO(getRandomId(), "Paul", "McCartney"));
		people.add(new PersonDTO(getRandomId(), "Ravi", "Shankar"));
	}
	
	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Integer id)
	{
		//code your remove person method
	}
	
	@POST
	@Path("add")
	public Integer save(PersonDTO person)
	{
		//code your save person method
		return getRandomId();
	}
	
	@PUT
	@Path("update/{id}")
	public void update(@PathParam("id") Integer id, PersonDTO personToSave)
	{
		//code your update person method
	}
	
	@GET
	@Path("{id}")
	public PersonDTO get(@PathParam("id") Integer id)
	{
		if(people != null)
		{
			for(PersonDTO person : people)
			{
				if(person.getId() != null && person.getId().equals(id))
				{
					return person;
				}
			}
		}
		return null;
	}
	
	@GET
	@Path("all")
	public ArrayList<PersonDTO> search()
	{
		return people;
	}
}