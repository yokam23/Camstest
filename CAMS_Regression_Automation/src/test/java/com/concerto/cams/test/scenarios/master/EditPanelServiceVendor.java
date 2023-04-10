package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.MakeModelPageUtils;
import com.concerto.cams.test.pageutils.PanelServiceVendorPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class EditPanelServiceVendor extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	MakeModelPageUtils makemodel;
	PanelServiceVendorPageUtils panelservice;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		panelservice = new PanelServiceVendorPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Edit Panel service vendor", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditPanelServiceVendor(String TCNo, String Description, String CompanyName, String State,
			String City, String PersonName, String Mobileno) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetPanelServiceVendorPage();
		panelservice.EditPanelvendor(State,City, PersonName, Mobileno, CompanyName);
		LoginPageUtils.Logout();
		Asserts.assertEqual(MasterDBDetails.GetPanelServiceVendorDetails(CompanyName).get(0).get("CompanyName"), CompanyName, "Correct company name is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetPanelServiceVendorDetails(CompanyName).get(0).get("CityName"), City, "Correct CityName  is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetPanelServiceVendorDetails(CompanyName).get(0).get("StateName"), State, "Correct StateName is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetPanelServiceVendorDetails(CompanyName).get(0).get("ContactPerson"), PersonName, "Correct ContactPerson is displayed in database");
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
