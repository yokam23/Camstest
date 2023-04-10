package com.concerto.common.exceptions;

import org.openqa.selenium.NoSuchElementException;

public class CannotFindElementOnPageException  extends NoSuchElementException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 5151248855325312801L;

	public CannotFindElementOnPageException(String reason, Throwable cause) {
		super(reason, cause);
	}

}
