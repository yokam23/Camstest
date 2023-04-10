package com.concerto.cams.test.scenarios.brandhygiene;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.OfficeMonitoringReportPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class ViewOfficeMonitoringReport extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	OfficeMonitoringReportPageUtils OfficeMonitoringReportPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		OfficeMonitoringReportPageUtils = new OfficeMonitoringReportPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add View Office Monitoring Report for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateViewOfficeMonitoringReport(String TcNO, String SiteID, String SiteLocation,String Location) throws Throwable {
		TCName.append(TcNO);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.Clientadmin, Config.Clientpassword);
		/*
		 * Navigate To Surveillance Indicator  Screen
		 */		
		Homepageutils.GetBrandHygieneReportsPage();
		/**
		 * Surveillance Indicator 
		 */
		//SurveillanceIndicatorPageUtils.navigateToAddSurveillanceIndicator();
		OfficeMonitoringReportPageUtils.ViewOfficeMonitoringReport(SiteID,SiteLocation, Location);
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
