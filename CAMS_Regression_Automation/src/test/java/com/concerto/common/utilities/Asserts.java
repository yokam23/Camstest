package com.concerto.common.utilities;

import static org.testng.Assert.fail;

import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.concerto.common.BaseClass;
import com.concerto.common.reports.ExcelReport;

public class Asserts extends BaseClass{
	
	public static StringBuffer verificationErrors = new StringBuffer();
	public static HashMap<String,String> Error = new HashMap<>();

	public static void assertEqual(Object Actual, Object Expected, String Message) {
		try {
			if(Expected != null && Expected.equals("null")) {
				Expected = null;
			}
		Assert.assertEquals(Actual, Expected, Message);
		Logger.logMessage(Message);
		} catch(Error E1) {
			verificationErrors.append(E1.toString());			
			Logger.logMessage(Message+ " :Failed");
			Error.put("Error", Message+ " :Failed");
			try {
				if(!DriverManager.getWebDriver().equals(null)) {
				Error.put("Page", DriverManager.getWebDriver().getTitle());
				}else {
					Error.put("Page", "NA");
				}}catch(NullPointerException e) {
					Error.put("Page", "NA");
				}
			//if(!AllErrors.contains(Error));
			AllErrors.add(Error);
			System.out.println(AllErrors);
		}
	}
	
	public static void assertEqualIgnoreSpaces(Object Actual, Object Expected, String Message) {
		Actual= Actual.toString().replaceAll("\\s+", "");
		Expected= Expected.toString().replaceAll("\\s+", "");
		try {
		Assert.assertEquals(Actual, Expected, Message);
		Logger.logMessage(Message);
		} catch(Error E1) {
			verificationErrors.append(E1.toString());			
			Logger.logMessage(Message+ " :Failed");
			Error.put("Error", Message+ " :Failed");
			try {
				if(!DriverManager.getWebDriver().equals(null)) {
				Error.put("Page", DriverManager.getWebDriver().getTitle());
				}else {
					Error.put("Page", "NA");
				}}catch(NullPointerException e) {
					Error.put("Page", "NA");
				}
			//if(!AllErrors.contains(Error));
			AllErrors.add(Error);
			System.out.println(AllErrors);
		}
	}
	
	public static void assertTrue(Boolean Flag, String Message) {
		try {
		Assert.assertTrue(Flag,Message);
		Logger.logMessage(Message);
		} catch(Error E1) {
			verificationErrors.append(E1.toString());			
			Logger.logMessage(Message+ " :Failed");
			Error.put("Error", Message+ " :Failed");
			try {
			if(!DriverManager.getWebDriver().equals(null)) {
			Error.put("Page", DriverManager.getWebDriver().getTitle());
			}else {
				Error.put("Page", "NA");
			}}catch(NullPointerException e) {
				Error.put("Page", "NA");
			}
			AllErrors.add(Error);
		}
	}
	
	public static void assertNotNull(Object Actual, String Message) {
		try {
			Assert.assertNotNull(Actual);
		Logger.logMessage(Message);
		} catch(Error E1) {
			verificationErrors.append(E1.toString());			
			Logger.logMessage(Message+" :Failed");
			Error.put("Error", Message+" :Failed");
			try {
				if(!DriverManager.getWebDriver().equals(null)) {
				Error.put("Page", DriverManager.getWebDriver().getTitle());
				}else {
					Error.put("Page", "NA");
				}}catch(NullPointerException e) {
					Error.put("Page", "NA");
				}
			AllErrors.add(Asserts.Error);
		}
	}
	
	public static void assertNull(Object Actual, String Message) {
		try {
			Assert.assertNull(Actual, Message);
		Logger.logMessage(Message);
		} catch(Error E1) {
			verificationErrors.append(E1.toString());			
			Logger.logMessage(Message+ " :Failed");
			Error.put("Error", Message+ " :Failed");
			try {
				if(!DriverManager.getWebDriver().equals(null)) {
				Error.put("Page", DriverManager.getWebDriver().getTitle());
				}else {
					Error.put("Page", "NA");
				}}catch(NullPointerException e) {
					Error.put("Page", "NA");
				}
			AllErrors.add(Asserts.Error);
		}
	}
	
	
	public static void assertContains(String Actual, String SubString, String Message) {
		try {
			Assert.assertTrue(Actual.contains(SubString),Message);
		Logger.logMessage(Message);
		} catch(Error E1) {
			verificationErrors.append(E1.toString());			
			Logger.logMessage(Message+ " :Failed");
			Error.put("Error", Message+ " :Failed");
			try {
				if(!DriverManager.getWebDriver().equals(null)) {
				Error.put("Page", DriverManager.getWebDriver().getTitle());
				}else {
					Error.put("Page", "NA");
				}}catch(NullPointerException e) {
					Error.put("Page", "NA");
				}
			AllErrors.add(Asserts.Error);
		}
	}
	
	public static void verifyVisible(WebElement Element, String Message) {
	    try {
	    	Assert.assertTrue(Element.isDisplayed(),Message);
	    	Logger.logMessage(Message+ " :Is Visible");
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	        Logger.logMessage(Message+ " :Is Not Visible");
			Error.put("Error", Message+ " :Failed");
			Error.put("Page", DriverManager.getWebDriver().getTitle());
			AllErrors.add(Asserts.Error);
	      }
	}
	
	public static void verifyElementPresent(WebElement Element, String Message) {
	    try {
	    	Assert.assertTrue(WebInteract.isPresent(Element,30),Message);
	    	Logger.logMessage(Message+ " :Is Present");
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	        Logger.logMessage(Message+ " :Is Not Present");
			Error.put("Error", Message+ " :Failed");
			Error.put("Page", DriverManager.getWebDriver().getTitle());
			AllErrors.add(Asserts.Error);
	      }
	}
	
	public static void verifyElementNotPresent(WebElement Element, String Message) {
	    try {
	    	Assert.assertFalse(WebInteract.isPresent(Element,30),Message);
	    	Logger.logMessage(Message+ " :Is Not Present");
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	        Logger.logMessage(Message+ " :Is Present");
			Error.put("Error", Message+ " :Failed");
			Error.put("Page", DriverManager.getWebDriver().getTitle());
			AllErrors.add(Asserts.Error);
	      }
	}
	
	public static void AssertAll() {
		
		String verificationErrorString = Asserts.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	
	/**
	 * Use This
	 * @param TCID
	 * @throws Throwable
	 */
	public static void AssertAll(String TCID) throws Throwable {
		
		String verificationErrorString = Asserts.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			ExcelReport.GenerateExcelReport(TCID, "FAILED",verificationErrorString);
			fail(verificationErrorString);
			
			
		}
		else {
			ExcelReport.GenerateExcelReport(TCID, "PASSED","NA");
		}
	}

}
