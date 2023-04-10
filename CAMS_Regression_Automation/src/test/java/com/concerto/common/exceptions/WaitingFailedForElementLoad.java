package com.concerto.common.exceptions;

import org.openqa.selenium.TimeoutException;

public class WaitingFailedForElementLoad extends TimeoutException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 1L;
	
	public WaitingFailedForElementLoad(String message, Throwable cause) {
		super(message, cause);
	}

}
