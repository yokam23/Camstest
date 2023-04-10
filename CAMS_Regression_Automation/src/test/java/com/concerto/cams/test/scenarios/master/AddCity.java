package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.CityPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.Excel;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddCity extends BaseClass {

	String PackageName;
	String ClassName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	CityPageUtils CityPageUtils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		CityPageUtils = new CityPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());
	}

	@Test(description = "TC0001::Validate Add new city ", groups = { "UI" }, dataProvider = "DataReader")
	public void validateAddCity(String TCNo, String Description, String Statename, String Cityname, String Switch)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);

		/*
		 * Navigate To City Screen
		 */
		Homepageutils.GetCityPage();
		/**
		 * City
		 */
		CityPageUtils.GetPageHeader();
		CityPageUtils.GetAddPageHeader();
		if (Switch.equalsIgnoreCase("DuplicateCity")) {
			CityPageUtils.ValidateDuplicateEntries(Statename, Cityname);
		} else if (Switch.equalsIgnoreCase("ErrorMessage")) {
			CityPageUtils.GetValidationMessage(Statename);
		} else if (Switch.equalsIgnoreCase("CityDeletion")) {
			CityPageUtils.AddnewCity(Statename, Cityname);
		} else if (Switch.equalsIgnoreCase("AddCity")) {
			CityPageUtils.AddnewCity(Statename, Cityname);
		}
		LoginPageUtils.Logout();

		if (Switch.equalsIgnoreCase("AddCity") || Switch.equalsIgnoreCase("CityDeletion")) {
			MasterDBDetails.GetCityDetails(Cityname).get(0).get("CityName");
			Asserts.assertEqual(MasterDBDetails.GetCityDetails(Cityname).get(0).get("CityName"), Cityname,
					"Correct city name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetCityDetails(Cityname).get(0).get("StateName"), Statename,
					"Correct State name displayed in database");
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
