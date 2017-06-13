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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import edu.gcu.business.WeatherServiceInterface;
import edu.gcu.model.ResponseDataModel;
import edu.gcu.model.ResponseModel;
import edu.gcu.model.WeatherSensorModel;
import edu.gcu.exceptions.DAOException;
import edu.gcu.exceptions.NotFoundException;

/**
 * This class is REST Service that implements the REST API to support the Weather Sensor IoT.
 * 
 * @author markreha
 * @version $Revision$
 */
@Path("weather")
public class RestService
{
    Logger logger = LoggerFactory.getLogger(RestService.class);
	static WeatherServiceInterface service;
	
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
     * @param model The Weather Data to save.
     * @return Response Model with error code of 1 for no error, 0 if save failed, -2 if database error
     */
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveTemperatureSensorData(WeatherSensorModel model)
    {
       	try 
       	{
			// Log the API call
			logger.info("Entering RestService.saveTemperatureSensorData()");
			logger.debug("Model: " + model.toString());
			
			// Call Business Service to save the Sensor Data
			boolean OK = service.saveTemperatureSensorData(model);
			
			// Return OK Response
			ResponseModel response = new ResponseModel(OK ? 1 : 0, OK ? "OK" : "Error");
			return response;
		} 
       	catch (DAOException e) 
       	{
			// Return Database Exception Response
			ResponseModel response = new ResponseModel(-2, "Database Exception: " + e.getMessage());
			return response;
		}
    }

    /**
     * Get Sensor Data in a Date Range at /get/{device}/YYYY-MM-dd HH:mm:ss using HTTP GET.
     * 
     * @param deviceID Device ID to query Sensor Data from
     * @param from Start date and time to query where format is YYYY-MM-dd HH:mm:ss
     * @param to End date and time to query where format is YYYY-MM-dd HH:mm:ss
     * @return Response Model with error code of 0 for no error, -1 if no sensor data found, -2 if database error, -3 if input data parsing error
     */
    @GET
    @Path("/get/{device}/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDataModel getTemperatureSensorDataInRange(@PathParam("device") int deviceID, @PathParam("from") String from, @PathParam("to") String to)
    {
       	// Log the API call
    	logger.info("Entering RestService.getTemperatureSensorDataInRange()");
    	logger.debug("Device ID: " + deviceID + " From: " + from + " To: " + to);
    	
    	// Parse parameters and call Business Service to get the Sensor Data in a Date Range
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	format.setTimeZone(TimeZone.getTimeZone("US/Arizona"));
    	try 
    	{
        	// Call Business Service to get the Sensor Data in a Date Range
			Date fromDate = format.parse(from);
			Date toDate = format.parse(to);
			List<WeatherSensorModel>data = service.getTemperatureSensorDataInRange(deviceID, fromDate, toDate);
			
	    	// Return Response and Data
	    	int returnError = 0;
	    	String returnMessage = "OK";
	    	ResponseDataModel response = new ResponseDataModel(returnError, returnMessage, data);
	    	return response;
		} 
       	catch (NotFoundException e) 
       	{
			// Return Database Error Response
       		ResponseDataModel response = new ResponseDataModel(-1, "Sensor Data Not Found" + e.getMessage(), new ArrayList<WeatherSensorModel>());
			return response;
		}
       	catch (DAOException e) 
       	{
			// Return Database Error Response
       		ResponseDataModel response = new ResponseDataModel(-2, "Database Exception: " + e.getMessage(), new ArrayList<WeatherSensorModel>());
			return response;
		}
    	catch (ParseException e) 
    	{
    		// Return Input Data Parameter Error Response
    		ResponseDataModel response = new ResponseDataModel(-3, "Bad Parameter Value", new ArrayList<WeatherSensorModel>());
	    	return response;
		}
    }

    /**
     * Get Sensor Data for a specified Sensor Device ID at /get/{device}/{id} using HTTP GET.
     * 
     * @param deviceID Device ID to query Sensor Data from
     * @param id Sensor ID to return
     * @return Response Model with error code of 0 for no error, -1 if no sensor data found, -2 if database error
     */
    @GET
    @Path("/get/{device}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDataModel getTemperatureSensorData(@PathParam("device") int deviceID, @PathParam("id") int id)
    {
       	try 
       	{
			// Log the API call
			logger.info("Entering RestService.getTemperatureSensorData()");
			logger.debug("Device ID: " + deviceID + " Sensor Data ID: " + id);
			
			// Call Business Service to get the Sensor Data for a specified Sensor Data ID
			WeatherSensorModel data = service.getTemperatureSensorData(deviceID, id);
			
			// Return Response and Data
			int returnError = 0;
			String returnMessage = "OK";
			List<WeatherSensorModel> returnData = new ArrayList<WeatherSensorModel>();
			returnData.add(data);
			ResponseDataModel response = new ResponseDataModel(returnError, returnMessage, returnData);
			return response;
		} 
       	catch (NotFoundException e) 
       	{
			// Return Database Error Response
       		ResponseDataModel response = new ResponseDataModel(-1, "Sensor Data Not Found" + e.getMessage(), new ArrayList<WeatherSensorModel>());
			return response;
		}
       	catch (DAOException e) 
       	{
			// Return Database Error Response
       		ResponseDataModel response = new ResponseDataModel(-2, "Database Exception: " + e.getMessage(), new ArrayList<WeatherSensorModel>());
			return response;
		}
    }

    // ***** Dependencies and Helper Functions *****
    
    /**
     * IoC helper function.
     * 
     * @param service WeatherServiceInterface to inject into this service implementation.
     */
    public void setService(WeatherServiceInterface service)
    {
    	RestService.service = service;
    }
}