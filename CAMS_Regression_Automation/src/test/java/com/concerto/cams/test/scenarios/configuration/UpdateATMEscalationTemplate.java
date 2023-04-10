package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.MasterTemplatePageUtils;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class UpdateATMEscalationTemplate {


	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	MasterTemplatePageUtils MasterTemplatePageUtils;
	

	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		MasterTemplatePageUtils = new MasterTemplatePageUtils();
	}
	
	@Test(description = "TC0001::Validate Update ATM Escalation Template Details for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateUpdateATMMasterTemplate(String TCNo,String ATM, String Name, String Comments, String TelephoneNo, String SMS , String MobileNo,
			String Email, String EmailID, String Priority, String RepeatIntervalMin) throws Throwable {
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		
		/*
		 * Navigate To ATM Master Template Screen
		 */		
		Homepageutils.GetMasterTemplatePage();
		/**
		 * Master Template
		 */
		MasterTemplatePageUtils.navigateToUpdateATMMasterTemplate();
		MasterTemplatePageUtils.UpdateATMEscalationTemplate(Name, Comments, TelephoneNo, SMS, MobileNo, Email, EmailID, Priority, RepeatIntervalMin);
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
