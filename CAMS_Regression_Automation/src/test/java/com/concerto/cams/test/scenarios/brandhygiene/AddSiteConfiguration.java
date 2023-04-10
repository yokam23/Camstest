package com.concerto.cams.test.scenarios.brandhygiene;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.SiteConfigurationPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class AddSiteConfiguration extends BaseClass{


	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	SiteConfigurationPageUtils SiteConfigurationPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		SiteConfigurationPageUtils = new SiteConfigurationPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());
	}

	@Test(description = "TC0001::Validate Add Site Configuration for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddSiteConfiguration(String TcNO, String ClientName, String SiteID, String StateName, String CityName, String Pincode, 
			String SiteAddress,String SiteLocation, String SiteName, String HKAgency, String MDNNo, 
			String Antenna, String DVRType, String  DVRIP, String DVRUserID,String DVRPassword, 
			String DVRPort, String DVRChannels, String HDD1TotalSpace, String HDD2TotalSpace, 
			String EmailID, String ContactName, String  MobileNo,String Location ,String Username) throws Throwable {
		TCName.append(TcNO);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Username, Config.Clientpassword);
		
		/*
		 * Navigate To Site Configuration  Screen
		 */		
		Homepageutils.GetBrandHygieneSiteConfigurationPage();
		/**
		 * Site Configuration 
		 */
		SiteConfigurationPageUtils.navigateToAddSiteConfiguration();
		SiteConfigurationPageUtils.AddSiteConfiguration(ClientName, SiteID, StateName, CityName, Pincode, SiteAddress, SiteLocation, SiteName, HKAgency, MDNNo, Antenna, DVRType, DVRIP, DVRUserID, DVRPassword, DVRPort, DVRChannels, HDD1TotalSpace, HDD2TotalSpace, EmailID, ContactName, MobileNo,Location);
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
