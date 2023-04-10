package com.concerto.common.exceptions;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelFormatException extends InvalidFormatException{
/**
 * @author abhijit.bhattacharya
 * @param p
 * @param msg
 * @param value
 * @param targetType
 */
	public ExcelFormatException(JsonParser p, String msg, Object value, Class<?> targetType) {
		super(p, msg, value, targetType);
		// TODO Auto-generated constructor stub
	}

}
