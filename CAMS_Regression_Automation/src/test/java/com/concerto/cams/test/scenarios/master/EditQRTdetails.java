package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.QRTAgencyPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class EditQRTdetails extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	QRTAgencyPageUtils qrtutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		qrtutils = new QRTAgencyPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001:To Edit QRT agency", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditQRTdetails(String TCNo, String Description, String CompanyName, String CompanyAddress,
			String Phoneno, String Emailid) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetQRTAgencyPage();
		qrtutils.EditQRTrecord(CompanyName, CompanyAddress, Phoneno, Emailid);
		LoginPageUtils.Logout();
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "QRT").get(0).get("AgencyName"), CompanyName, "Correct company name displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "QRT").get(0).get("AgencyType"), "QRT", "Correct company name displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "QRT").get(0).get("AgencyAddress"),CompanyAddress , "Correct AgencyAddress displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "QRT").get(0).get("PhoneNo"),Phoneno , "Correct PhoneNo name displayed in database");	
		Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "QRT").get(0).get("EmailID"),Emailid , "Correct EmailID name displayed in database");
	
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
