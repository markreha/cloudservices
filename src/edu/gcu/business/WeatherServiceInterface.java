package edu.gcu.business;

import java.util.Date;
import java.util.List;

import edu.gcu.exceptions.NotFoundException;
import edu.gcu.model.WeatherSensorModel;

public interface WeatherServiceInterface 
{
	/**
	 * Save WeatherSensorData.
	 * 
     * @param model WeatherSensorModel populated with data to save.
     * @return True if OK else False if Error.
	 */
    public boolean saveTemperatureSensorData(WeatherSensorModel model);
    
    /**
 	 * Get Weather Sensor Data by Data ID.
	 * 
	 * @param deviceID The Device to find data for.
	 * @param id The Weather Data ID to retrieve.
	 * @return WeatherSensorModel populated with data else null if not found.
	 * @throws NotFoundException Checked exception thrown if no search results.
     */
    public WeatherSensorModel getTemperatureSensorData(int deviceID, int id) throws NotFoundException;
    
    /**
     * Get Weather Sensor Data by a Data Range.
     * 
     * @param deviceID deviceID The Device to find data for.
     * @param from Beginning DateTime to retrieve.
     * @param to End DateTime to retrieve.
     * @return List of WeatherSensorModel populated with data else empty list if not found.
 	 * @throws NotFoundException Checked exception thrown if no search results.
    */
    public List<WeatherSensorModel> getTemperatureSensorDataInRange(int deviceID, Date from, Date to) throws NotFoundException;
}
