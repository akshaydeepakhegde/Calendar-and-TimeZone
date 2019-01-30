package com.randstand.cal;
/**
 * The TimezoneException is user-defined exception class extended from the class Exception
 * 
 * @author Akshay_Hegde
 *
 */
public class TimezoneException extends Exception {
	private String message;
	
	public TimezoneException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
