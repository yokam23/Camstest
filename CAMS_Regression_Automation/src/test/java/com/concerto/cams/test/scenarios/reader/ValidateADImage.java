package com.concerto.cams.test.scenarios.reader;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.ADPageUtils;
import com.concerto.cams.test.pageutils.TicketTransactionPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.GetTicketName;

public class ValidateADImage   extends BaseClass {

	String PackageName;
	String ClassName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	TicketTransactionPageUtils TicketTransactionPageUtils;
	ADPageUtils ADPageUtils;
	

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		TicketTransactionPageUtils = new TicketTransactionPageUtils();
		ADPageUtils= new ADPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add new city ", groups = { "UI" })
	public void validateAddCity()
			throws Throwable {
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.Ticketoperatorlogin, Config.Ticketoperatorpassword);

		/*
		 * Navigate To Ticket Transaction Screen
		 */
		Homepageutils.GetTicketTransactionPage();
		TicketTransactionPageUtils.NavigateToADPage();
		ArrayList<String> tabs2 = new ArrayList<String>(DriverManager.getWebDriver().getWindowHandles());
		DriverManager.getWebDriver().switchTo().window(tabs2.get(1));
		String TicketNumber = ADPageUtils.GetTicketNumber();
		Thread.sleep(1000);
		ArrayList<LinkedHashMap<String,String>> Results = GetTicketName.GetTicketDetails(TicketNumber);
		ADPageUtils.ValidateAD(Results.get(0).get("ActivityID"), Results.get(0).get("ZoneNo"), Results.get(0).get("PanelID"));

		String CloseTicket = ADPageUtils.CloseTicket();
		ArrayList<LinkedHashMap<String,String>> Results1 = GetTicketName.GetTicketDetails(CloseTicket);
		Asserts.assertEqual(Results1.get(0).get("Ticket_Status"), "CLOSED", "Ticket Status Updated To CLosed Successfully");
		
		Thread.sleep(1000);
		
		DriverManager.getWebDriver().close();
		DriverManager.getWebDriver().switchTo().window(tabs2.get(0));
		Asserts.AssertAll("TC0001");
	}


	
	

}
