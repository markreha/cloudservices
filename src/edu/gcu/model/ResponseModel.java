package edu.gcu.model;

/**
 * This class is the DTO to simply return a status code and message back to a client.
 * 
 * @author markreha
 * @version $Revision$
 */
public class ResponseModel 
{
	int status;
	String message;
	
	public ResponseModel(int status, String message) 
	{
		this.status = status;
		this.message = message;
	}

	public int getStatus() 
	{
		return status;
	}
	public void setStatus(int status) 
	{
		this.status = status;
	}
	
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
}
