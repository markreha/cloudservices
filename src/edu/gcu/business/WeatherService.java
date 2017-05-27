package edu.gcu.business;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.gcu.dao.WeatherDAOInterface;
import edu.gcu.exceptions.NotFoundException;
import edu.gcu.model.WeatherSensorModel;

/**
 * This class is the Business Service that implements the business methods to support the Weather Sensor IoT.
 * 
 * @author markreha
 * @version $Revision$
 */
public class WeatherService implements WeatherServiceInterface
{
	WeatherDAOInterface dao;
    Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	/**
	 * Save WeatherSensorData.
	 * 
     * @param model WeatherSensorModel populated with data to save.
     * @return True if OK else False if Error.
	 */
    public boolean saveTemperatureSensorData(WeatherSensorModel model)
    {
    	// Log the API call
    	logger.info("Entering WeatherService.saveTemperatureSensorData()");
    	
    	// Call DAO
    	return dao.insert(model);
    }

     /**
 	 * Get Weather Sensor Data by Data ID.
	 * 
	 * @param deviceID The Device to find data for.
	 * @param id The Weather Data ID to retrieve.
	 * @return WeatherSensorModel populated with data else null if not found.
	 * @throws NotFoundException Checked exception thrown if no search results.
     */
     public WeatherSensorModel getTemperatureSensorData(int deviceID, int id) throws NotFoundException
    {
    	try 
    	{
			// Log the API call
			logger.info("Entering WeatherService.getTemperatureSensorData()");
			
			// Call DAO
			return dao.findByID(deviceID, id);
		} 
    	catch (NotFoundException e) 
    	{
			// Rethrow exception
			throw new NotFoundException();
		}
    }

    /**
     * Get Weather Sensor Data by a Data Range.
     * 
     * @param deviceID deviceID The Device to find data for.
     * @param from Beginning DateTime to retrieve.
     * @param to End DateTime to retrieve.
     * @return List of WeatherSensorModel populated with data else empty list if not found.
	 * @throws NotFoundException Checked exception thrown if no search results.
     */
    public List<WeatherSensorModel> getTemperatureSensorDataInRange(int deviceID, Date from, Date to) throws NotFoundException
    {
    	try 
    	{
    		// Log the API call
    		logger.info("Entering WeatherService.getTemperatureSensorDataInRange()");

    		// Call DAO
    		return dao.findByDateRange(deviceID, from, to);
		} 
    	catch (NotFoundException e) 
    	{
			// Rethrow exception
			throw new NotFoundException();
		}
    }

    // ***** Dependencies and Helper Functions *****
    
    /**
     * IoC helper function.
     * 
     * @param dao WeatherDAOInterface to inject into this service implementation.
     */
    public void setDao(WeatherDAOInterface dao)
    {
        this.dao = dao;
    }
}
