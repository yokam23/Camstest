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

public class UpdateMFG extends BaseClass{
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
	
	@Test(description="TC0001::To Test the functionality of installation tool", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateUpdateMFG(String TCNO,String Desciption,String Mfgid,String Switch) throws Throwable {
		TCName.append(TCNO);
		boolean status = LoginPageUtils.LaunchIns(Config.APPURL_INS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToInstool(Config.Serviceuser, Config.Servicepwd);
		if(Switch.equalsIgnoreCase("UpdateMfgid")) {
			instoolutils.UpdateMFGID(Mfgid);
		}if(Switch.equalsIgnoreCase("ValidateDuplicate")) {
			instoolutils.ValidateDuplicateMFGID(Mfgid);
		}
		LoginPageUtils.InsLogout();
		Asserts.AssertAll(TCNO);
	}
	
	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}
}
