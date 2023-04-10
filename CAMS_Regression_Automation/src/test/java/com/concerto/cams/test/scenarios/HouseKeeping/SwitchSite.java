package com.concerto.cams.test.scenarios.HouseKeeping;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.SiteAllocationUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class SwitchSite extends BaseClass {

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	SiteAllocationUtils siteutils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		siteutils = new SiteAllocationUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());
	}


	@Test(description="TC0001::To switch site from one pool to another pool", groups = { "UI" }, dataProvider = "DataReader")
	public void Switchpool(String TCNo, String Description,String poolname,String Camera,String SwitchPool,String Switch) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		Homepageutils.GetHKSiteAllocationpage();
		siteutils.GetPageHeader();
		if(Switch.equalsIgnoreCase("SwitchPool")) {
		siteutils.AllocateSites(poolname, Camera);
		siteutils.SwitchPool(poolname, SwitchPool);
		} else if (Switch.equalsIgnoreCase("Deallocate")) {
		siteutils.DeallocateSites(poolname);
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
