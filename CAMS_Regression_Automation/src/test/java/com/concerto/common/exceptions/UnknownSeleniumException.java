package com.concerto.common.exceptions;

import org.openqa.selenium.WebDriverException;

public class UnknownSeleniumException extends WebDriverException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 1L;
	
	  public UnknownSeleniumException(String message, Throwable cause) {
		    super(message, cause);
		  }
}
