package com.concerto.cams.test.scenarios.login;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.Excel;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.cams.test.pageutils.LoginPageUtils;

public class InvalidLogin extends BaseClass{
	
	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::Validate Login For InValid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateCorrectLogin(String TCNO,String Description,String username,String Password,String Errormessage) throws Throwable {
		//Map<String, String> TestData = Excel.getTestData(Config.TEST_DATA_FILE_PATH, ClassName, PackageName);
		TCName.append(TCNO);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.InValidLoginToCams(username, Password, Errormessage);
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
