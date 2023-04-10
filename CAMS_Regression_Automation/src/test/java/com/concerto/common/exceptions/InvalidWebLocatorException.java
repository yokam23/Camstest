package com.concerto.common.exceptions;

import org.openqa.selenium.InvalidSelectorException;

public class InvalidWebLocatorException extends InvalidSelectorException  {
	
	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = -2354435428101931363L;

	public InvalidWebLocatorException(String reason, Throwable cause) {
		super(reason, cause);
	}	
	
}
