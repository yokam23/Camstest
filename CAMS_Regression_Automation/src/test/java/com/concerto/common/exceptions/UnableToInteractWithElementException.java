package com.concerto.common.exceptions;

import org.openqa.selenium.ElementNotInteractableException;

public class UnableToInteractWithElementException extends ElementNotInteractableException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 433915189644005164L;

	public UnableToInteractWithElementException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
