package com.concerto.common.exceptions;

import java.net.SocketException;

public class APIConnectionFailed extends SocketException{

	/**
	 * @author abhijit.bhattacharya
	 */
	private static final long serialVersionUID = 1L;
	
	public APIConnectionFailed(String reason) {
		super(reason);
	}

}
