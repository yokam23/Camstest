package com.concerto.common.exceptions;

import org.openqa.selenium.WebDriverException;

public class SeleniumDriverException extends WebDriverException{	
	  /**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 3291962765943526073L;

	public SeleniumDriverException(String message, Throwable cause) {
		    super(message, cause);
		  }
}
