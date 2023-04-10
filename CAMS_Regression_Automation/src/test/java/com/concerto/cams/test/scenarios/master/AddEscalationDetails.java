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

public class AddEscalationDetails extends BaseClass {

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

	@Test(description = "TC0001:To add new Escalation details", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateAddEscalationdetails(String TCNo, String Description, String Templatename, String Name,
			String Comment, String Telephoneno, String Mobileno, String Emailid, String Priority, String interval,
			String Repeatinterval, String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetEscalationPage();
		escutils.GetHeader();
		if (Switch.equalsIgnoreCase("AddNew")) {
			escutils.GetEscalationPageHeader();
			escutils.AddnewEscalation(Templatename, Name, Comment, Telephoneno, Mobileno, Emailid, Priority, interval,
					Repeatinterval);
		} else if (Switch.equalsIgnoreCase("Duplicate")) {
			escutils.GetEscalationPageHeader();
			escutils.ValidateDuplicateEscalation(Templatename, Name, Comment, Telephoneno, Mobileno, Emailid, Priority, interval,
					Repeatinterval);
		} else if (Switch.equalsIgnoreCase("ErrorMessage")) {
			escutils.GetEscalationPageHeader();
			escutils.GetValidationMessage(Templatename);
		} else if (Switch.equalsIgnoreCase("Refreshbutton")) {
			escutils.GetEscalationPageHeader();
			escutils.RefreshAddedDetails(Templatename, Name, Comment, Telephoneno, Mobileno, Emailid, Priority,
					interval, Repeatinterval);
		} else if (Switch.equalsIgnoreCase("Deletion")) {
			escutils.GetEscalationPageHeader();
			escutils.AddnewEscalation(Templatename, Name, Comment, Telephoneno, Mobileno, Emailid, Priority, interval,
					Repeatinterval);
		}
		LoginPageUtils.Logout();
		if(Switch.equalsIgnoreCase("AddNew") || Switch.equalsIgnoreCase("Deletion")) {
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("TemplateName"), Templatename, "Correct template name is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("Contact_Person"), Name, "Correct Contact person is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("Tel_No"), Telephoneno, "Correct telephone no is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("Cell_No"), Mobileno, "Correct Cell no is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("EmailID"), Emailid, "Correct EmailID is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("Priority"), Priority, "Correct Priority is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("Interval"), interval, "Correct Interval is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetEscalationDetails(Templatename).get(0).get("RepeatInterval"), Repeatinterval, "Correct RepeatInterval is displayed in database");
		}
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
