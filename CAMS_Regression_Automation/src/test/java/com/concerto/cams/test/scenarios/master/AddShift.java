package com.concerto.cams.test.scenarios.master;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.ShiftPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.MasterDBDetails;

public class AddShift extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	ShiftPageUtils shiftutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		shiftutils = new ShiftPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::Validate Add new Shift details", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateAddNewShift(String TCNo, String Description,String Shiftname,String Timefrom,String Timeto,String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetShiftPage();
		shiftutils.GetPageHeader();
		shiftutils.GetAddPageHeader();
		if(Switch.equalsIgnoreCase("AddNew")) {
		shiftutils.AddnewShift(Shiftname, Timefrom, Timeto);
		}else if(Switch.equalsIgnoreCase("Duplicate")) {
			shiftutils.ValidateDuplicateEnteries(Shiftname, Timefrom, Timeto);
		}else if(Switch.equalsIgnoreCase("ErrorMessage")) {
			shiftutils.GetValidationMessage(Shiftname);
		}else if(Switch.equalsIgnoreCase("Deletion")) {
			shiftutils.AddnewShift(Shiftname, Timefrom, Timeto);
		}
		LoginPageUtils.Logout();
		
		if(Switch.equalsIgnoreCase("Deletion") || Switch.equalsIgnoreCase("AddNew")) {
			Asserts.assertEqual(MasterDBDetails.GetShiftDetails(Shiftname).get(0).get("ShiftName"), Shiftname, "Correct shiftname is displayed in database");
			String FromTime = MasterDBDetails.GetShiftDetails(Shiftname).get(0).get("TimeFrom");
			String ToTime = MasterDBDetails.GetShiftDetails(Shiftname).get(0).get("TimeTo");
			Asserts.assertContains(FromTime, Timefrom, "Correct time is displayed in database");
			Asserts.assertContains(ToTime, Timeto, "Correct time is displayed in database");
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
