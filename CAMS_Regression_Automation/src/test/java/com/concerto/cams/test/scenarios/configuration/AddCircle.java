package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.CirclePageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.ConfigurationDBdetails;

public class AddCircle extends BaseClass{
	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	CirclePageUtils CirclePageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		CirclePageUtils = new CirclePageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::Validate Add Circle name for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddCircle(String TCNo, String  CircleName,String Switch,String ClientName) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.adminUsername, Config.adminPassword);	
		Homepageutils.GetCirclePage(); 
		CirclePageUtils.navigateToAddCircle();
		if(Switch.equalsIgnoreCase("AddCircle") || Switch.equalsIgnoreCase("Deletion")) {
			CirclePageUtils.AddCircle(CircleName,ClientName);
		}
		
		LoginPageUtils.Logout();
		Asserts.assertEqual(ConfigurationDBdetails.GetCirclesdetails(CircleName).get(0).get("CircleName"), CircleName, "Correct circle name is displayed in database");
      //Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("Dealer_Name"), DealerName, "Correct client name is displayed in database");
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
