package edu.gcu.models;

public class WeatherSensorModel 
{
	private int deviceID;
	private float temperature;
	private float humidity;
	
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
