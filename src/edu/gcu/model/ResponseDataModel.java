package edu.gcu.model;

import java.util.List;

/**
 * This class is the DTO to return not only a status code and message back to a client
 * but also a data payload which is a list of Weather Sensor Models (can be empty).
 * 
 * @author markreha
 * @version $Revision$
 */
public class ResponseDataModel extends ResponseModel
{
	List<WeatherSensorModel> data;
	
	public ResponseDataModel(int status, String message, List<WeatherSensorModel> data) 
	{
		super(status, message);
		this.data = data;
	}

	public List<WeatherSensorModel> getData() 
	{
		return this.data;
	}
	public void setDatas(List<WeatherSensorModel> data) 
	{
		this.data = data;
	}
}
