package com.concerto.cams.test.scenarios.INStool;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.InstallationToolPageUtils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;


public class StartTrack extends BaseClass{
	String PackageName;
	String ClassName;
	LoginPageUtils LoginPageUtils;
	InstallationToolPageUtils instoolutils;
	
	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		instoolutils = new InstallationToolPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	
	@Test(description="To validate start tracking of the panel", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateStartTracking(String TCNo,String Description) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchIns(Config.APPURL_INS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToInstool(Config.Serviceuser, Config.Servicepwd);
		instoolutils.StartTracking();
		instoolutils.SaveRemark();
		instoolutils.ErrorMsgOutgoingCommands();
		LoginPageUtils.InsLogout();
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
