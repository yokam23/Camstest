package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.ClientPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class UpdateClient extends BaseClass{
	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	ClientPageUtils ClientPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		ClientPageUtils = new ClientPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::Validate Update Client For Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateUpdateClient(String TCNo,String ClientName, String ClientAddress,String VersionNo, String StateName,
			String CityName, String pincodeNo, String Subscription,String Searchtxt) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		
		/*
		 * Navigate To Dealer Screen
		 */		
		Homepageutils.GetClientPage();
		/**
		 * Dealer
		 */
		
		ClientPageUtils.EditClient(ClientName, ClientAddress, VersionNo, StateName, CityName, pincodeNo, Subscription,Searchtxt);
		LoginPageUtils.Logout();
		
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
