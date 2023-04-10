package com.concerto.common.exceptions;

public class UnknownException extends Exception{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 1L;
	
	public UnknownException(String message, Throwable cause) {
	    super(message, cause);
	  }

}
