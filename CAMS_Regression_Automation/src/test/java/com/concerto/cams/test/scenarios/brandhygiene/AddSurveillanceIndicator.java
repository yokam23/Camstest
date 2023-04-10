package com.concerto.cams.test.scenarios.brandhygiene;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.SurveillanceIndicatorPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.BrandHygieneDBdetails;

public class AddSurveillanceIndicator extends BaseClass{


	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	SurveillanceIndicatorPageUtils SurveillanceIndicatorPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		SurveillanceIndicatorPageUtils = new SurveillanceIndicatorPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add Surveillance Indicator for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddSurveillanceIndicator(String TcNO, String Cameralocation, String	Category, String Indicator,  String Priority) throws Throwable {
		TCName.append(TcNO);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.Clientadmin, Config.Clientpassword);
		
		/*
		 * Navigate To Surveillance Indicator  Screen
		 */		
		Homepageutils.GetBrandHygieneIndicatorPage();
		/**
		 * Surveillance Indicator 
		 */
		SurveillanceIndicatorPageUtils.navigateToAddSurveillanceIndicator();
		SurveillanceIndicatorPageUtils.AddSurveillanceIndicator(Cameralocation, Category, Indicator, Priority);
		LoginPageUtils.Logout();
		Asserts.assertEqual(BrandHygieneDBdetails.GetSurveillanceIndicator(Indicator).get(0).get("Location"), Cameralocation, "Correct  Camera location ID is displayed in database");
		Asserts.assertEqual(BrandHygieneDBdetails.GetSurveillanceIndicator(Indicator).get(0).get("CategoryType"), Category, "Correct Category is displayed in database");
		Asserts.assertEqual(BrandHygieneDBdetails.GetSurveillanceIndicator(Indicator).get(0).get("ItemName"), Indicator, "Correct Indicator is displayed in database");
		Asserts.assertEqual(BrandHygieneDBdetails.GetSurveillanceIndicator(Indicator).get(0).get("PriorityType"), Priority, "Correct Priority is displayed in database");
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
