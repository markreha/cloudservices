package edu.gcu.dao;

import java.util.Date;
import java.util.List;

import edu.gcu.exceptions.DAOException;
import edu.gcu.exceptions.NotFoundException;
import edu.gcu.model.WeatherSensorModel;

/**
 * This class is the interface class for Data Access Object that implements the CRUD methods for the Weather Sensor data.
 * 
 * @author markreha
 * @version $Revision$
 */
public interface WeatherDAOInterface
{
	/**
	 * Find Weather Sensor Data by Device ID from the database.
	 * 
	 * @param deviceID The Device to find data for.
	 * @param id The Weather Data ID to retrieve.
	 * @return WeatherSensorModel populated with data else null if not found.
	 * @throws DAOException Unchecked exception thrown for all exception.
	 * @throws NotFoundException Checked exception thrown if no search results.
	 */
    public WeatherSensorModel findByID(int deviceID, int id) throws NotFoundException;
    
    /**
     * Find Weather Sensor Data by a Data Range from the database.
     * 
     * @param deviceID deviceID The Device to find data for.
     * @param from Beginning DateTime to retrieve.
     * @param to End DateTime to retrieve.
     * @return List of WeatherSensorModel populated with data else empty list if not found.
	 * @throws DAOException Unchecked exception thrown for all exception.
	 * @throws NotFoundException Checked exception thrown if no search results.
     */
    public List<WeatherSensorModel> findByDateRange(int deviceID, Date from, Date to) throws NotFoundException;
    
    /**
     * Insert WeatherSensorData into the database.
     * 
     * @param model WeatherSensorModel populated with data to save.
     * @return True if OK else False if Error.
 	 * @throws DAOException Unchecked exception thrown for all exception.
    */
    public boolean insert(WeatherSensorModel model);
}
