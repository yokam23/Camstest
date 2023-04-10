package com.concerto.cams.test.scenarios.HouseKeeping;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.HKMonitoringPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class HKMonitoring extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	HKMonitoringPageUtils HKMutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		HKMutils = new HKMonitoringPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::To get the monitoring record", groups = { "UI" }, dataProvider = "DataReader")
	public void ValidateMonitoredRecord(String TCNo, String Description,String ClientName,String PoolName,String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		if(Switch.equals("MonitoredData")) {
		LoginPageUtils.ValidLoginToCams(Config.supervisorun, Config.supervisorpwd);
		}else {
			LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);	
		}
        Homepageutils.GetHKMonitoringpage();
        if(Switch.equalsIgnoreCase("ErrorMsg")) {
        HKMutils.GetvalidationMessage(ClientName, PoolName);
        }else if(Switch.equalsIgnoreCase("Resetbtn")) {
        	HKMutils.ValidateResetButton(ClientName, PoolName);
        }else if(Switch.equalsIgnoreCase("MonitoredData")) {
        	HKMutils.GetMonitoringData(ClientName, PoolName);
        } 
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
