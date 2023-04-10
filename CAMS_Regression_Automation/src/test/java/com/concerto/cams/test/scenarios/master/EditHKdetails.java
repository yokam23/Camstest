package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.HKPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class EditHKdetails extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	HKPageUtils hkutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		hkutils = new HKPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Edit hk agency", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditHKagency(String TCNo, String Description, String CompanyName, String CompanyAddress,
			String State, String City) throws Throwable{
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetHKAgencyPage();
		hkutils.EditHKrecord(CompanyName, CompanyAddress, State, City);
		LoginPageUtils.Logout();
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "HKA").get(0).get("AgencyName"), CompanyName, "Correct company name displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "HKA").get(0).get("AgencyType"), "HKA", "Correct company name displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "HKA").get(0).get("AgencyAddress"),CompanyAddress , "Correct AgencyAddress displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "HKA").get(0).get("CityName"),City , "Correct City name displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "HKA").get(0).get("StateName"),State , "Correct StateName name displayed in database");
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
