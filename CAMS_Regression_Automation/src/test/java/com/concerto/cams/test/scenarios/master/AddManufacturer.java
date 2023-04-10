package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.ManufacturerPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddManufacturer extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	ManufacturerPageUtils manufacturer;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		manufacturer = new ManufacturerPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add Manufacturer", groups = { "UI" }, dataProvider = "DataReader")
	public void validateAddManufacturer(String TCNo, String Description, String Devicename, String companyName,
			String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetManufacturerPage();
		manufacturer.GetPageHeader();
		manufacturer.GetAddPageHeader();
		if (Switch.equalsIgnoreCase("AddManufacturer")) {
			manufacturer.AddnewManufacturer(Devicename, companyName);
		} else if (Switch.equalsIgnoreCase("Deletion")) {
			manufacturer.AddnewManufacturer(Devicename, companyName);
		} else if (Switch.equalsIgnoreCase("DuplicateManufacturer")) {
			manufacturer.ValidateDuplicateEntries(Devicename, companyName);
		} else if (Switch.equalsIgnoreCase("Refreshbutton")) {
			manufacturer.RefreshManufacturerdetails(Devicename, companyName);
		} else if (Switch.equalsIgnoreCase("ErrorMessage")) {
			manufacturer.GetValidationMessage(companyName);
		}
		LoginPageUtils.Logout();
		
		if(Switch == "AddManufacturer" || Switch == "Deletion") {
			MasterDBDetails.GetManufacturerDetails(Devicename,companyName).get(0).get("DeviceTypeName");
			Asserts.assertEqual(MasterDBDetails.GetManufacturerDetails(Devicename,companyName).get(0).get("DeviceTypeName"), Devicename, "Correct device name is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetManufacturerDetails(Devicename,companyName).get(0).get("CompanyName"), companyName, "Correct company name is displayed in database");
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
