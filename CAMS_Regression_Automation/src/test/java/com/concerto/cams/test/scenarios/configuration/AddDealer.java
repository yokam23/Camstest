package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.DealersPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.ConfigurationDBdetails;

public class AddDealer extends BaseClass{
	
	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	DealersPageUtils DealersPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		DealersPageUtils = new DealersPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());
	}
	@Test(description = "TC0001::Validate Add dealer for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddDealer(String TCNo, String DealerName, String Address, String State, String City,String Pincode, 
			String ContactPerson, String PhoneNo, String MobileNo, String EmailID) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		
		/*
		 * Navigate To Dealer Screen
		 */		
		Homepageutils.GetDealerPage();
		/**
		 * Dealer
		 */
		DealersPageUtils.navigateToAddDealer();
		DealersPageUtils.AddDealer(DealerName, Address, State, City, Pincode, ContactPerson, PhoneNo, MobileNo, EmailID);
		LoginPageUtils.Logout();
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("Dealer_Name"), DealerName, "Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("ContactPerson"), ContactPerson, "Correct pincodeNo is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("Pincode"), Pincode, "Correct pincodeNo is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("Dealer_Phone"), PhoneNo, "Correct pincodeNo is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("Dealer_EmailID"), EmailID, "Correct pincodeNo is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("Dealer_Mobile"), MobileNo, "Correct pincodeNo is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("CityName"), City, "Correct CityName is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetDealerdetails(DealerName).get(0).get("StateName"), State, "Correct StateName is displayed in database");
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




