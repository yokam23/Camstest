package com.concerto.common.exceptions;

public class ArrayIndexExceeded extends ArrayIndexOutOfBoundsException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayIndexExceeded(String message) {
		super(message);
	}

}
