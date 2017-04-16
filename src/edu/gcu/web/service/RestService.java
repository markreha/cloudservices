package edu.gcu.web.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.DefaultValue;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Path("services")
public class RestService
{
    Logger logger = LoggerFactory.getLogger(RestService.class);

    /**
     * Test Service at /.
     * 
     * @return Test String
     */
    @GET
    @Path("/test")
    @Produces("application/json")
    public String onIndex()
    {
    	logger.info("Entering RestService.onIndex()");
    	return "{\"data\" : \"This is a test\"}";
    }
}