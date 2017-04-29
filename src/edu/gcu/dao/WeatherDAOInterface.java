package edu.gcu.dao;

import java.util.Date;
import java.util.List;
import edu.gcu.model.WeatherSensorModel;

public interface WeatherDAOInterface
{
	/**
	 * Find Weather Sensor Data by Data ID from the database.
	 * 
	 * @param deviceID The Device to find data for.
	 * @param id The Weather Data ID to retrieve.
	 * @return WeatherSensorModel populated with data else null if not found.
	 */
    public WeatherSensorModel findByID(int deviceID, int id);
    
    /**
     * Find Weather Sensor Data by a Data Range from the database.
     * 
     * @param deviceID deviceID The Device to find data for.
     * @param from Beginning DateTime to retrieve.
     * @param to End DateTime to retrieve.
     * @return List of WeatherSensorModel populated with data else empty list if not found.
     */
    public List<WeatherSensorModel> findByDateRange(int deviceID, Date from, Date to);
    
    /**
     * Insert WeatherSensorData into the database.
     * 
     * @param model WeatherSensorModel populated with data to save.
     * @return True if OK else False if Error.
     */
    public boolean insert(WeatherSensorModel model);
}
