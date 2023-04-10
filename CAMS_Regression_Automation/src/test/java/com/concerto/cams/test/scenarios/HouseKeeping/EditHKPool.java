package com.concerto.cams.test.scenarios.HouseKeeping;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.HouseKeepingPoolUtils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.HouseKeepingDBdetails;

public class EditHKPool extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	HouseKeepingPoolUtils poolutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		poolutils = new HouseKeepingPoolUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Edit House keeping pool ", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditPool(String TCNo, String Description,String ClientName, String PoolName,String Searchtxt)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetHKpoolpage();
		poolutils.GetPageHeader();
        poolutils.EditPoolrecord(PoolName, Searchtxt);
        LoginPageUtils.Logout();
        HouseKeepingDBdetails.GetHKPoolDetails(ClientName, PoolName).get(0).get("PoolName");
		Asserts.assertEqual(HouseKeepingDBdetails.GetHKPoolDetails(ClientName, PoolName).get(0).get("Client_Name"), ClientName,"Correct Clientname is displayed in database");
		Asserts.assertEqual(HouseKeepingDBdetails.GetHKPoolDetails(ClientName, PoolName).get(0).get("PoolName"), PoolName,"Correct poolname is displayed in database");
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
