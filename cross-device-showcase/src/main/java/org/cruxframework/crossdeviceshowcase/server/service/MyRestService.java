package org.cruxframework.crossdeviceshowcase.server.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cruxframework.crossdeviceshowcase.shared.dto.MyDTO;
import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.QueryParam;

/**
 * @author samuel.cardoso
 *
 */
@RestService("myRestService")
@Path("/myRestService")
public class MyRestService
{
	private static final Log LOG = LogFactory.getLog(MyRestService.class);

	@GET
	@Path("myRestCall")
	public MyDTO myRestCall(@QueryParam("param1") String param1, @QueryParam("param2") int param2)
	{
		LOG.info("Calling REST service");
		
		MyDTO dto = new MyDTO();
		dto.setA(param1);
		dto.setB(param2);
		
		return dto;
	}
}