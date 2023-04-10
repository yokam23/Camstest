package com.concerto.cams.test.scenarios.brandhygiene;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.MonitoringPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class ViewScheduledMonitoring extends BaseClass{
	

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	MonitoringPageUtils MonitoringPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		MonitoringPageUtils = new MonitoringPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());
	}

	@Test(description = "TC0001::Validate View Monitoring for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateViewScheduledMonitoring(String TcNO,String Client, String SiteID,String SiteLocation, String Location) throws Throwable {
		TCName.append(TcNO);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.Clientadmin, Config.Clientpassword);
		/*
		 * Navigate To Monitoring Screen
		 */		
		Homepageutils.GetBrandHygieneMonitoringPage();
		/**
		 * Monitoring 
		 */
		MonitoringPageUtils.ViewScheduledMonitoring(Client, SiteID,SiteLocation, Location);
		LoginPageUtils.Logout();
		Asserts.AssertAll(TcNO);
	}
	
	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}


}
