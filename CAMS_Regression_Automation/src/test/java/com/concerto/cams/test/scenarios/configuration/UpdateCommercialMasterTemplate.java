package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.MasterTemplatePageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;

public class UpdateCommercialMasterTemplate extends BaseClass{
	
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
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	

	@Test(description = "TC0001::Validate Update ATM Master Details for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateUpdateATMMasterTemplate(String TCNo, String Location, String Description, String Scheduler, String Camera ,
			String SMS) throws Throwable {
		TCName.append(TCNo);
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
		MasterTemplatePageUtils.UpdateATMMasterTemplate(Location, Description, Camera);
		LoginPageUtils.Logout();
		Asserts.AssertAll(TCNo);
	}
}
