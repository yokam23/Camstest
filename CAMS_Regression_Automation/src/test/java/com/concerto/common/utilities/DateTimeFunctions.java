package com.concerto.common.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class DateTimeFunctions {
	

	public static String generateDateTime() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(System.currentTimeMillis());		
		return formatter.format(date);

	}
	
	public static String GenerateOffsetDateDDMMYYYY(int i) throws Throwable {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
		String date = formatter.format(cal.getTime());
		return  date;
	}
	
	public static String GenerateOffsetDateYYYYMMDD(int i) throws Throwable {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
		String date = formatter.format(cal.getTime());
		return  date;
	}
	
	public static String GenerateOffsetDateMMDDYYYY(int i) throws Throwable {
		SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy");
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, i);
		String date = formatter.format(cal.getTime());
		return  date;
	}
	
	public static String GenerateOffsetDateMMDDYYYY() throws Throwable {
		SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date(System.currentTimeMillis());
		return  formatter.format(date);
	}
	
	public static String GenerateOffsetDateDDMMYYYY() throws Throwable {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date(System.currentTimeMillis());
		return  formatter.format(date);
	}
	
	public static String GenerateOffsetTimeHHMMSS() throws Throwable {
		SimpleDateFormat Timformatter= new SimpleDateFormat("HH:mm:ss");
		Date Time = new Date(System.currentTimeMillis());
		return  Timformatter.format(Time);
	}
	

	public static String GenerateRandom() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 4;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    String generatedString2 = random.ints(leftLimit, rightLimit + 1)
	  	      .limit(targetStringLength)
	  	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	  	      .toString();
	    
	    return generatedString+generatedString2;
	}
	
	public static int Randomnumber() {
		int value = ThreadLocalRandom.current().nextInt(1000, 9999);
		return value;
	}

}
