package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.MakeModelPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddMakeModel extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	MakeModelPageUtils makemodel;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		makemodel = new MakeModelPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add new Makemodel", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateAddMakemodel(String TCNo, String Description, String GenericName, String Manufacturer,
			String ModelName, String Deviceversion, String DeviceCapacity, String Switch,String Device) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetMakeModelPage();
		makemodel.GetPageHeader();
		//makemodel.GetAddPageHeader();
		if (Switch.equalsIgnoreCase("AddMakemodel")) {
			makemodel.AddMakeModel(GenericName, Manufacturer, ModelName, Deviceversion, DeviceCapacity,Device);
		} else if (Switch.equalsIgnoreCase("Duplicate")) {
			makemodel.ValidateDuplicateEntries(GenericName, Manufacturer, ModelName, Deviceversion, DeviceCapacity,Device);
		} else if (Switch.equalsIgnoreCase("ErrorMessage")) {
			makemodel.GetValidationMessage(GenericName, ModelName, Deviceversion, DeviceCapacity,Device);
		} else if (Switch.equalsIgnoreCase("Refresh")) {
			makemodel.Refreshdetails(GenericName, Manufacturer, ModelName, Deviceversion, DeviceCapacity,Device);
		} else if (Switch.equalsIgnoreCase("Deletion")) {
			makemodel.AddMakeModel(GenericName, Manufacturer, ModelName, Deviceversion, DeviceCapacity,Device);
		}
		LoginPageUtils.Logout();
		
		if(Switch.equalsIgnoreCase("AddMakemodel") || Switch.equalsIgnoreCase("Deletion")) {
			MasterDBDetails.GetMakeModelDetails(GenericName, Device, Manufacturer).get(0).get("GenericName");
			Asserts.assertEqual(MasterDBDetails.GetMakeModelDetails(GenericName, Device, Manufacturer).get(0).get("GenericName"), GenericName, "Correct Generic name is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetMakeModelDetails(GenericName, Device, Manufacturer).get(0).get("CompanyName"), Manufacturer, "Correct Manufacturer name is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetMakeModelDetails(GenericName, Device, Manufacturer).get(0).get("ModelName"), ModelName, "Correct ModelName is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetMakeModelDetails(GenericName, Device, Manufacturer).get(0).get("DeviceTypeName"), Device, "Correct DeviceTypeName is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetMakeModelDetails(GenericName, Device, Manufacturer).get(0).get("DeviceVersion"), Deviceversion, "Correct DeviceVersion is displayed in database");
			Asserts.assertEqual(MasterDBDetails.GetMakeModelDetails(GenericName, Device, Manufacturer).get(0).get("DeviceValue"), DeviceCapacity, "Correct DeviceValue is displayed in database");	
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
