package edu.gcu.model;

public class WeatherSensorModel 
{
	private int deviceID;
	private float temperature;
	private float humidity;

	public WeatherSensorModel()
	{
		this.deviceID = -1;
		this.temperature = 0;
		this.humidity = 0;
	}
	
	public WeatherSensorModel(int deviceID, float temperature, float humidity)
	{
		this.deviceID = deviceID;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public int getDeviceID() 
	{
		return deviceID;
	}
	public void setDeviceID(int deviceID) 
	{
		this.deviceID = deviceID;
	}
	
	public float getTemperature() 
	{
		return temperature;
	}
	public void setTemperature(float temperature) 
	{
		this.temperature = temperature;
	}
	
	public float getHumidity() 
	{
		return humidity;
	}
	public void setHumidity(float humidity) 
	{
		this.humidity = humidity;
	}
	
	@Override
	public String toString() 
	{
		return new StringBuffer("Device ID: ").append(this.deviceID).append("  Temperature: ").append(this.temperature).append("  Humidity: ").append(this.humidity).toString();
	}
}
