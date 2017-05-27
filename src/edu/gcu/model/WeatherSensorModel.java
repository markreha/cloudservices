package edu.gcu.model;

/**
 * This class is the model for the Weather Sensor data.
 * This class holds data to represent the Device ID, Temperature, Humidity, and Air Pressure for Weathor IoT.
 * 
 * @author markreha
 * @version $Revision$
 */
public class WeatherSensorModel 
{
	private int deviceID;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherSensorModel()
	{
		this.deviceID = -1;
		this.temperature = 0;
		this.humidity = 0;
	}
	
	public WeatherSensorModel(int deviceID, float temperature, float humidity, float pressure)
	{
		this.deviceID = deviceID;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
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
	
	public float getPressure() 
	{
		return pressure;
	}
	public void setPressure(float pressure) 
	{
		this.pressure = pressure;
	}

	@Override
	public String toString() 
	{
		return new StringBuffer("Device ID: ").append(this.deviceID).append("  Temperature: ").append(this.temperature).append("  Humidity: ").append(this.humidity).append("  Pressure: ").append(this.pressure).toString();
	}
}
