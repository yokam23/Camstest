package com.concerto.common.exceptions;

import org.openqa.selenium.StaleElementReferenceException;

public class HTMLElementExpiredException extends StaleElementReferenceException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 3924436192546522173L;

	public HTMLElementExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

}
