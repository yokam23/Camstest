package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.EscalationPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class EditEscalationdetails extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	EscalationPageUtils escutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		escutils = new EscalationPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001:To Edit Escalation details", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateEditEscalationdetails(String TCNo, String Description, String Templatename, String Name,
			String Emailid, String priority, String Repeatinterval) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetEscalationPage();
		escutils.EditEscalationdetails(Templatename, Name, Emailid, priority, Repeatinterval);
		LoginPageUtils.Logout();
		Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("TemplateName"), Templatename, "Correct template name is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("Contact_Person"), Name, "Correct Contact person is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("EmailID"), Emailid, "Correct EmailID is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("Priority"), priority, "Correct Priority is displayed in database");
		Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("RepeatInterval"), Repeatinterval, "Correct RepeatInterval is displayed in database");
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
