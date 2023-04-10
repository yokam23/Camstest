package com.concerto.common.exceptions;

public class NullDriverException extends NullPointerException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 1L;
	
	public NullDriverException(String message) {
		super(message);
	}

}
