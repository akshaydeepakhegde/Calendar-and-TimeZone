package com.randstand.cal;
/**
 * The InvalidDateFormatException is user-defined exception class extended from the class Exception  
 * @author Akshay_Hegde
 *
 */
public class InvalidDateFormatException extends Exception {
	private String message;
	
	/**
	 * 
	 * @param message the error message when the exception is hit
	 */
	public InvalidDateFormatException(String message) {
		this.message = message;
	}
	
	/**
	 * Returns the error message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the error message.
	 * @param message error message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
