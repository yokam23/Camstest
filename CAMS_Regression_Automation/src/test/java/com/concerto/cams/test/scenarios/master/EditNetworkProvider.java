package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.NetworkProviderPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class EditNetworkProvider extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	NetworkProviderPageUtils nputils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		nputils = new NetworkProviderPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001:To Edit network provider", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditNetworkprover(String TCNo, String Description, String AgencyName, String Searchtxt)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetNetworkProviderPage();
		nputils.Editnetworkprovider(AgencyName, Searchtxt);
		LoginPageUtils.Logout();
		Asserts.assertEqual(MasterDBDetails.GetNetworkProviderDetails(AgencyName, "NTW").get(0).get("AgencyName"), AgencyName, "Correct agency name is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetNetworkProviderDetails(AgencyName, "NTW").get(0).get("AgencyType"), "NTW", "Correct Agency type is displayed in database");
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
