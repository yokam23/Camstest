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

public class EditHKSchedule  extends BaseClass {

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
	
	@Test(description="TC0001::To edit the added schedule", groups = {"UI" }, dataProvider = "DataReader")
    public void ValidateEditSchedule(String TCNo, String Description,String ClientName,String PoolName) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetHKSchedulerpage();
		hkschedule.GetPageHeader();
		hkschedule.EditSchedulerdetails(ClientName, PoolName);
		LoginPageUtils.Logout();
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
