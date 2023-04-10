package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.ProjectTeamPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

public class AddProjectTeam extends BaseClass{
	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	ProjectTeamPageUtils ProjectTeamPageUtils;
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		ProjectTeamPageUtils = new ProjectTeamPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::Validate Project team for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddProjectTeam(String TcNo, String MemberName, String Role, String EmailID, String MobileNo,String Switch) throws Throwable {
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);	
		Homepageutils.GetProjectTeamPage();
		ProjectTeamPageUtils.navigateToAddProjectTeam();
		if(Switch.equalsIgnoreCase("Add")) {
		ProjectTeamPageUtils.AddProjectTeam(MemberName, Role, EmailID, MobileNo);
		}else if(Switch.equalsIgnoreCase("Deletion")) {
			ProjectTeamPageUtils.AddProjectTeam(MemberName, Role, EmailID, MobileNo);
		}
		LoginPageUtils.Logout();
		Asserts.AssertAll(TcNo);
	}
	
	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}
}

