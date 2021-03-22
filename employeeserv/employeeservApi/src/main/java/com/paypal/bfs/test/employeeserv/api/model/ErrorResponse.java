package com.paypal.bfs.test.employeeserv.api.model;

/**
 * Error response pojo
 * <p>
 * Error response object
 * 
 * Created to accomadate error responses
 * 
 */
public class ErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	public ErrorResponse() {}
	

}
