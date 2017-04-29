package edu.gcu.model;

import java.util.List;

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
