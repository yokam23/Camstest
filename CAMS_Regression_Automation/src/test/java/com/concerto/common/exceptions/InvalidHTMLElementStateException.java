package com.concerto.common.exceptions;

import org.openqa.selenium.InvalidElementStateException;

public class InvalidHTMLElementStateException extends InvalidElementStateException{
	
	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = -2140014204978847494L;

	public InvalidHTMLElementStateException(String message, Throwable cause) {
		super(message, cause);
	}

}
