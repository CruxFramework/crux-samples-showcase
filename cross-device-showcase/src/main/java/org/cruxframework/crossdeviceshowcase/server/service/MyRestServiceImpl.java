package org.cruxframework.crossdeviceshowcase.server.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cruxframework.crossdeviceshowcase.shared.dto.MyDTO;
import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.POST;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.QueryParam;

@RestService("myRestService")
@Path("/users")
public class MyRestServiceImpl
{
	private static List<MyDTO> mockUsers;
	private static final Log LOG = LogFactory.getLog(MyRestServiceImpl.class);
	
	static
	{
		mockMapFill();
	}
	
	private static void mockMapFill()
	{
		mockUsers = new ArrayList<MyDTO>();
		
		mockUsers.add(new MyDTO("admin", "admin"));
	}

	@GET
	@Path("users")
	public MyDTO validate(@QueryParam("name") String name, @QueryParam("password") String password)
	{
		LOG.info("Calling REST service");
		
		for (MyDTO myDTO : mockUsers) 
		{
			if(name.equals(myDTO.getName()) && password.equals(myDTO.getPassword()))
			{
				return myDTO;
			}
		}
		return null;
	}
	
	@POST
	@Path("add")
	public void save(@QueryParam("name") String name, @QueryParam("password") String password)
	{
		LOG.info("Add user");
		if(name!=null && !name.equals("") && password!=null && !password.equals(""))
		{
			MyDTO myDTO = new MyDTO(name, password);
			mockUsers.add(myDTO);
		}
	}
}