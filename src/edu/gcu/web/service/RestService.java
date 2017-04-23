package edu.gcu.web.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import edu.gcu.web.model.WeatherSensorModel;
import edu.gcu.web.model.ResponseModel;

@Path("services")
public class RestService
{
    Logger logger = LoggerFactory.getLogger(RestService.class);

    /**
     * Test Service API at /test using HTTP GET.
     * 
     * @return Response Model
     */
    @GET
    @Path("/test")
    @Produces("application/json")
    public ResponseModel test()
    {
    	// Log the API call
    	logger.info("Entering RestService.test()");
    	
    	// Return a Test Response
    	ResponseModel response = new ResponseModel(0, "This is a test");
    	return response;
    }
    
    /**
     * Save Sensor Data API at /save using HTTP POST.
     * 
     * @param model The Sensor Data to save.
     * @return Response Model
     */
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveTemperatureSensorData(WeatherSensorModel model)
    {
       	// Log the API call
    	logger.info("Entering RestService.saveTemperatureSensorData()");
    	logger.debug("Model: " + model.toString());
    	
    	// Call Business Service to save the Sensor Data
    	// TODO: Need to implement the Business Service to save the Sensor Data
    	
    	// Return OK Response
    	ResponseModel response = new ResponseModel(0, "OK");
    	return response;
    }

    /**
     * Get Sensor Data in a Date Range at /get/{device}/YYYY-MM-dd HH:mm:ss using HTTP GET.
     * 
     * @param Device ID to all Sensor Data for
     * @return Response Model
     */
    @GET
    @Path("/get/{device}/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getTemperatureSensorDataInRange(@PathParam("device") int deviceID, @PathParam("from") String from, @PathParam("to") String to)
    {
       	// Log the API call
    	logger.info("Entering RestService.getTemperatureSensorDataInRange()");
    	logger.debug("Device ID: " + deviceID + " From: " + from + " To: " + to);
    	
    	// Call Business Service to get the Sensor Data in a Date Range
    	// TODO: Need to implement the Business Service to get the Sensor Data in a Date Range
    	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    	try 
    	{
			Date fromDate = format.parse(from);
			Date toDate = format.parse(to);
		} 
    	catch (ParseException e) 
    	{
	    	ResponseModel response = new ResponseModel(-1, "Bad Parameter Value");
	    	return response;
		}
    	
    	
    	// Return OK Response
    	ResponseModel response = new ResponseModel(0, "OK");
    	return response;
    }

    /**
     * Get Sensor Data for a specified Sensor Data ID at /get/{device}/{id} using HTTP GET.
     * 
     * @param Device ID to all Sensor Data for
     * @param id Sensor ID to return
     * @return Response Model
     */
    @GET
    @Path("/get/{device}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getTemperatureSensorData(@PathParam("device") int deviceID, @PathParam("id") int id)
    {
       	// Log the API call
    	logger.info("Entering RestService.getTemperatureSensorData()");
    	logger.debug("Device ID: " + deviceID + " Sensor Data ID: " + id);
    	
    	// Call Business Service to get the Sensor Data for a specified Sensor Data ID
    	// TODO: Need to implement the Business Service to get the Sensor Data for a specified Sensor Data ID
    	
    	// Return OK Response
    	ResponseModel response = new ResponseModel(0, "OK");
    	return response;
    }
}
