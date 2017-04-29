package edu.gcu.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import edu.gcu.model.WeatherSensorModel;

@SuppressWarnings("unused")
public class WeatherDAO implements WeatherDAOInterface
{
	Logger logger = LoggerFactory.getLogger(WeatherDAO.class);
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Find Weather Sensor Data by Data ID from the database.
	 * 
	 * @param deviceID The Device to find data for.
	 * @param id The Weather Data ID to retrieve.
	 * @return WeatherSensorModel populated with data else null if not found.
	 */
    public WeatherSensorModel findByID(int deviceID, int id)
    {
    	// Log the API call
    	logger.info("Entering WeatherDAO.findByID()");
    	
    	// Execute SQL using JDBC Template, read the query data, and return a WeatherSensorModel if valid else return null
        String sql = "SELECT * FROM weather WHERE device_id=? AND id=?";
        SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, deviceID, id);
        boolean OK = srs.first();
        if(OK)
        {
        	return new WeatherSensorModel(srs.getInt("device_id"), srs.getFloat("temp"), srs.getFloat("humidity"));
        }        
        else
        {
        	return null;
        }
    }
    
    /**
     * Find Weather Sensor Data by a Data Range from the database.
     * 
     * @param deviceID deviceID The Device to find data for.
     * @param from Beginning DateTime to retrieve.
     * @param to End DateTime to retrieve.
     * @return List of WeatherSensorModel populated with data else empty list if not found.
     */
    public List<WeatherSensorModel> findByDateRange(int deviceID, Date from, Date to)
    {
    	// Log the API call
    	logger.info("Entering WeatherDAO.findByDateRange()");
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	
    	// Execute SQL using JDBC Template, read the query data, and return a WeatherSensorModel if valid else return null
    	List<WeatherSensorModel> list = new ArrayList<WeatherSensorModel>();
        String sql = "SELECT * FROM weather WHERE device_id=? AND date >= ? AND date <= ?";
        SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, deviceID, from, to);
        while(srs.next())
        {
        	WeatherSensorModel data = new WeatherSensorModel(srs.getInt("device_id"), srs.getFloat("temp"), srs.getFloat("humidity"));
        	list.add(data);
        }        
        return list;
    }

    /**
     * Insert WeatherSensorData into the database.
     * 
     * @param model WeatherSensorModel populated with data to save.
     * @return True if OK else False if Error.
     */
    public boolean insert(WeatherSensorModel model)
    {
    	// Log the API call
    	logger.info("Entering WeatherDAO.insert()");
    	
    	// Execute SQL using JDBC Template
        String sql = "INSERT INTO weather (device_id, temp, humidity, date) VALUES (?, ?, ?, ?)";
        int rows = jdbcTemplateObject.update(sql, model.getDeviceID(), model.getTemperature(), model.getHumidity(), new Date());
    	
        // Return result of Insert
    	return rows == 1 ? true : false;
    }

    // ***** Dependencies and Helper Functions *****
    
    /**
     * IoC helper function.
     * 
     * @param dataSource Spring Data Source to inject into this DAO
     */
     public void setDataSource(DataSource dataSource) 
    {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
}
