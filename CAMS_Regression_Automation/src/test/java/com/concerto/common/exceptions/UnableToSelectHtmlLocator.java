package com.concerto.common.exceptions;

import org.openqa.selenium.ElementNotSelectableException;

public class UnableToSelectHtmlLocator extends ElementNotSelectableException {

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = -1948865798696829385L;

	public UnableToSelectHtmlLocator(String message, Throwable cause) {
		super(message, cause);
	}
}
