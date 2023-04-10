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
import com.concerto.db.methods.ConfigurationDBdetails;

public class AddClient extends BaseClass{

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
	
	@Test(description = "TC0001::Validate Login For InValid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddClient(String TcNO, String Client, String ClientAddress,  String StateName,
			String CityName, String pincodeNo, String SLAInMIN, String Subscription,String CircleName,String Switch) throws Throwable {
		TCName.append(TcNO);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetClientPage();
		ClientPageUtils.navigateToAddClient();
		if(Switch.equalsIgnoreCase("Add")) {
		ClientPageUtils.AddClient(Client, ClientAddress, StateName, CityName, pincodeNo, SLAInMIN, Subscription,CircleName);
		} else if(Switch.equalsIgnoreCase("Deletion")) {
			ClientPageUtils.AddClient(Client, ClientAddress, StateName, CityName, pincodeNo, SLAInMIN, Subscription,CircleName);
		}
		Asserts.assertEqual(ConfigurationDBdetails.GetClientdetails(Client).get(0).get("Client_Name"), Client, "Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetClientdetails(Client).get(0).get("Pincode"), pincodeNo, "Correct pincodeNo is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetClientdetails(Client).get(0).get("CityName"), CityName, "Correct CityName is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetClientdetails(Client).get(0).get("StateName"), StateName, "Correct StateName is displayed in database");
		
		LoginPageUtils.Logout();
		
		Asserts.AssertAll(TcNO);
	}
	
	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}
}
