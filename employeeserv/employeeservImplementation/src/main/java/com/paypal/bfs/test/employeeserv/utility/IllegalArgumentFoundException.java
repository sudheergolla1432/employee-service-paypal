package com.paypal.bfs.test.employeeserv.utility;

/**
 * Custom exception created to handle our exceptions
 * 
 */
public class IllegalArgumentFoundException extends RuntimeException {

	public IllegalArgumentFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalArgumentFoundException(String message) {
		super(message);
	}

	public IllegalArgumentFoundException(Throwable cause) {
		super(cause);
	}
	
}
