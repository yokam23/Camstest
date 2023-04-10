package com.concerto.cams.test.scenarios.reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.TicketTransactionPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.GetTicketName;
import com.concerto.db.methods.MasterDBDetails;

public class ValidateTicketTransaction  extends BaseClass {

	String PackageName;
	String ClassName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	TicketTransactionPageUtils TicketTransactionPageUtils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		TicketTransactionPageUtils = new TicketTransactionPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());
	}

	@Test(description = "TC0001::Validate Add new city ", groups = { "UI" }, dataProvider = "DataReader")
	public void validateAddCity(String TCNo, String Description, String PanelId, String Sensor,String SolId)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.Ticketoperatorlogin, Config.Ticketoperatorpassword);

		/*
		 * Navigate To Ticket Transaction Screen
		 */
		Homepageutils.GetTicketTransactionPage();
		String TicketNumber = GetTicketName.GetUserTicket(PanelId, Sensor,Config.Ticketoperatorlogin).get(0).get("TicketNo");
		TicketTransactionPageUtils.GetTicketTransactionPage(TicketNumber);
		Thread.sleep(10000);
		TicketTransactionPageUtils.ValidateTicketNo(TicketNumber, Sensor, SolId);

		Asserts.AssertAll(TCNo);
	}

	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}

}
