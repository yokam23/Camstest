package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.NationalHolidayPageutils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class EditNationalHoliday extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	NationalHolidayPageutils NHpageutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		NHpageutils = new NationalHolidayPageutils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate to edit national details", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditNationalHoliday(String TCNo,String Description, String Holidayname, String Date, String Searchtxt)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetNationalHolidayPage();
		NHpageutils.EditnationalHoliday(Holidayname, Date, Searchtxt);
		LoginPageUtils.Logout();
		MasterDBDetails.GetHolidayDetails(Holidayname).get(0).get("HolidayName");
		Asserts.assertEqual(MasterDBDetails.GetHolidayDetails(Holidayname).get(0).get("HolidayName"), Holidayname, "Correct Holiday name displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetHolidayDetails(Holidayname).get(0).get("HDate"), NHpageutils.getDateFormat(Date), "Correct Holiday Date displayed in database");
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
