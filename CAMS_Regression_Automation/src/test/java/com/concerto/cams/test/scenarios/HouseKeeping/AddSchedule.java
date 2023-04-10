package com.concerto.cams.test.scenarios.HouseKeeping;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.HKSchedulerPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.HouseKeepingDBdetails;

public class AddSchedule extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	HKSchedulerPageUtils hkschedule;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		hkschedule = new HKSchedulerPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::To Add new scheduler", groups = {
			"UI" }, dataProvider = "DataReader")
	public void ValidateAddSchedule(String TCNo, String Description,String ClientName,String PoolName,String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetHKSchedulerpage();
		hkschedule.GetPageHeader();
		if(Switch.equalsIgnoreCase("AddScheduler")) {
		hkschedule.AddScheduler(ClientName, PoolName);
		} else if(Switch.equalsIgnoreCase("GetValidation")) {
			hkschedule.GetValidationmsg(ClientName, PoolName);
		}
		LoginPageUtils.Logout();
		
		if(Switch.equalsIgnoreCase("AddScheduler")) {
			HouseKeepingDBdetails.GetHKSchedulerDetails(ClientName, PoolName).get(0).get("PoolName");
			Asserts.assertEqual(HouseKeepingDBdetails.GetHKSchedulerDetails(ClientName, PoolName).get(0).get("PoolName"), PoolName, "Correct poolname is displayed in database");
			Asserts.assertEqual(HouseKeepingDBdetails.GetHKSchedulerDetails(ClientName, PoolName).get(0).get("Client_Name"), ClientName, "Correct Client_Name is displayed in database");
			//String FromTime = HouseKeepingDBdetails.GetHKSchedulerDetails(ClientName, PoolName).get(0).get("TimeFrom");
		}
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
