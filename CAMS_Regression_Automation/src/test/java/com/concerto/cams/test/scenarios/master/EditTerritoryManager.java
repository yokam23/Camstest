package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.TerritoryManagerPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class EditTerritoryManager extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	TerritoryManagerPageUtils TMutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		TMutils = new TerritoryManagerPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());
	}

	@Test(description = "TC0001:To Edit territory details", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditterritory(String TCNo, String Description, String TerritoryName, String TerritoryManager,
			String MobileNo, String Emailid, String Searchtxt) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetTerritoryManagerPage();
		TMutils.EditTerritoryManagerDetails(TerritoryName, TerritoryManager, MobileNo, Searchtxt);
		LoginPageUtils.Logout();
		Asserts.assertEqual(MasterDBDetails.GetTerritoryDetails(TerritoryName).get(0).get("TerritoryManager"), TerritoryManager, "Correct territory manager is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetTerritoryDetails(TerritoryName).get(0).get("EmailID"), Emailid, "Correct territory Emailid is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetTerritoryDetails(TerritoryName).get(0).get("MobileNo"), MobileNo, "Correct territory MobileNo is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetTerritoryDetails(TerritoryName).get(0).get("TerritoryName"), TerritoryName, "Correct TerritoryName is displayed in database");
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
