package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.ServicePartnerPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddServicePartner extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	ServicePartnerPageUtils SPutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		SPutils = new ServicePartnerPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001:To add new Service partner", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateAddServicePartner(String TCNo, String Description, String CompanyName, String CompanyAddress,
			String State, String City, String Pincode, String ContactPerson, String PhoneNo, String Emailid,
			String MobileNo, String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetServicePartnerPage();
		SPutils.GetpageHeader();
		SPutils.GetAddpageHeader();
		if (Switch.equalsIgnoreCase("AddNew")) {
			SPutils.Addservicepartner(CompanyName, CompanyAddress, State, City, Pincode, ContactPerson, PhoneNo,
					Emailid, MobileNo);
		} else if (Switch.equalsIgnoreCase("ErrorMessage")) {
			SPutils.GetValidationMessage(CompanyName, CompanyAddress, State, City, Pincode, PhoneNo, Emailid);
		} else if (Switch.equalsIgnoreCase("Duplicate")) {
			SPutils.Validateduplicaterecord(CompanyName, CompanyAddress, State, City, Pincode, ContactPerson, PhoneNo,
					Emailid, MobileNo);
		} else if (Switch.equalsIgnoreCase("Refreshbutton")) {
			SPutils.RefreshAddedDetails(CompanyName, CompanyAddress, State, City, Pincode, ContactPerson, PhoneNo,
					Emailid, MobileNo);
		} else if (Switch.equalsIgnoreCase("Deletion")) {
			SPutils.Addservicepartner(CompanyName, CompanyAddress, State, City, Pincode, ContactPerson, PhoneNo,
					Emailid, MobileNo);
		}
		LoginPageUtils.Logout();
		if(Switch.equalsIgnoreCase("Deletion") || Switch.equalsIgnoreCase("AddNew")) {
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("AgencyName"), CompanyName, "Correct company name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("AgencyType"), "SRV", "Correct company name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("AgencyAddress"),CompanyAddress , "Correct AgencyAddress displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("CityName"),City , "Correct City name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("StateName"),State , "Correct StateName name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("Pincode"),Pincode , "Correct Pincode name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("ContactPerson"),ContactPerson , "Correct StateName name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("PhoneNo"),PhoneNo , "Correct ContactPerson name displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("MobileNo"),MobileNo , "Correct PhoneNo displayed in database");	
			Asserts.assertEqual(MasterDBDetails.GetAgencyDetails(CompanyName, "SRV").get(0).get("EmailID"),Emailid , "Correct EmailID displayed in database");
		
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
