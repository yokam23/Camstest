package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.SubscriptionPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddSubscription extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	SubscriptionPageUtils subscriptionutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		subscriptionutils = new SubscriptionPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001:To add new Subscription details", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateAddSubscription(String TCNo, String Description, String SubscriptionName, String SMScount,
			String PhoneCount, String EmailCount, String Repeatcount, String VideoVerification, String Switch)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetSubscriptionPage();
		subscriptionutils.GetpageHeader();
		subscriptionutils.GetAddpageHeader();
		if (Switch.equalsIgnoreCase("AddNew")) {
			subscriptionutils.Addsubscriptiondetails(SubscriptionName, SMScount, PhoneCount, EmailCount, Repeatcount,
					VideoVerification);
		} else if (Switch.equalsIgnoreCase("ErrorMessage")) {
			subscriptionutils.GetValidationMessage(SubscriptionName);
		} else if (Switch.equalsIgnoreCase("Duplicate")) {
			subscriptionutils.ValidateDuplicateEntries(SubscriptionName, SMScount, PhoneCount, EmailCount, Repeatcount,
					VideoVerification);
		} else if (Switch.equalsIgnoreCase("Refreshbutton")) {
			subscriptionutils.RefreshAddedDetails(SubscriptionName, SMScount, PhoneCount, EmailCount, Repeatcount,
					VideoVerification);
		} else if (Switch.equalsIgnoreCase("Deletion")) {
			subscriptionutils.Addsubscriptiondetails(SubscriptionName, SMScount, PhoneCount, EmailCount, Repeatcount,
					VideoVerification);
		}
		LoginPageUtils.Logout();
		if(Switch.equalsIgnoreCase("Deletion") || Switch.equalsIgnoreCase("AddNew")) {
			Asserts.assertEqual(MasterDBDetails.GetSubscriptionDetails(SubscriptionName).get(0).get("SubName"),SubscriptionName,"Correct subscription name is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetSubscriptionDetails(SubscriptionName).get(0).get("SMS_Cnt"),SMScount,"Correct subscription name is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetSubscriptionDetails(SubscriptionName).get(0).get("Phone_Cnt"),PhoneCount,"Correct Phone count is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetSubscriptionDetails(SubscriptionName).get(0).get("Email_Cnt"),EmailCount,"Correct Email count is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetSubscriptionDetails(SubscriptionName).get(0).get("Repeat"),Repeatcount,"Correct Repeat count is displayed in database");
			//Asserts.assertEqual(MasterDBDetails.GetSubscriptionDetails(SubscriptionName).get(0).get("VideoConfirmation"),true,"Correct VideoVerification count is displayed in database");
			
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