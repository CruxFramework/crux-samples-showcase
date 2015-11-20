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
	private static final int MAX_PERSON_TO_SAVE = 100;
	private static Random random = new Random();
	private static ArrayList<PersonDTO> persons = new ArrayList<PersonDTO>();
	
	static
	{
		mockMapFill();
	}
	
	private static void mockMapFill()
	{
		persons = new ArrayList<PersonDTO>();
		persons.add(new PersonDTO(random.nextInt(), "John", "Nash"));
		persons.add(new PersonDTO(random.nextInt(), "Paul", "McCartney"));
		persons.add(new PersonDTO(random.nextInt(), "Ravi", "Shankar"));
	}
	
	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Integer id)
	{
		if(persons != null)
		{
			PersonDTO personToRemove = null;
			for(PersonDTO person : persons)
			{
				if(person.getId() != null && person.getId().equals(id))
				{
					personToRemove = person;
				}
			}
			
			if(personToRemove != null)
			{
				persons.remove(personToRemove);
			}
		}
	}
	
	@POST
	@Path("add")
	public Integer save(PersonDTO person)
	{
		int id = random.nextInt();
		person.setId(id);
		addPerson(person);
		return id;
	}
	
	@PUT
	@Path("update/{id}")
	public void update(@PathParam("id") Integer id, PersonDTO personToSave)
	{
		if(persons != null)
		{
			PersonDTO personToRemove = null;
			for(PersonDTO person : persons)
			{
				if(person.getId() != null && person.getId().equals(id))
				{
					personToRemove = person;
				}
			}
			
			if(personToRemove != null)
			{
				persons.remove(personToRemove);
				addPerson(personToSave);
			}
		}
	}
	
	@GET
	@Path("{id}")
	public PersonDTO get(@PathParam("id") Integer id)
	{
		if(persons != null)
		{
			for(PersonDTO person : persons)
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
		return persons;
	}
	
	private static void addPerson(PersonDTO person)
	{
		if(persons == null || persons.size() > MAX_PERSON_TO_SAVE)
		{
			persons = new ArrayList<PersonDTO>();			
		}
		persons.add(person);
	}
}