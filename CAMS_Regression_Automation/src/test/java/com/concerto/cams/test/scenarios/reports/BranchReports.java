package com.concerto.cams.test.scenarios.reports;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.ReportPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.GetTicketName;

public class BranchReports extends BaseClass {

	String PackageName;
	String ClassName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	ReportPageUtils ReportPageUtils;

	@BeforeMethod(alwaysRun = true, groups = { "UI" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils = new Homepageutils();
		ReportPageUtils = new ReportPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add new city ", groups = { "UI" }, dataProvider = "DataReader")
	public void validateBranchReports(String TCNo, String Description,String ReportName, String PanelId, String ClientId,
			String BranchStatus,String LastStatus)
			throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);

		/*
		 * Navigate To Ticket Transaction Screen
		 */
		Homepageutils.GetReportsPage();
		ReportPageUtils.SearchPanelAlert(ReportName, PanelId);
		if(ReportName.equalsIgnoreCase("Consolidated Branch Open")||ReportName.equalsIgnoreCase("Consolidated Branch Close")) {
			ReportPageUtils.validateBranchOpenReports(PanelId, ClientId, BranchStatus, LastStatus);
		}else {
		ReportPageUtils.validateBranchReports(PanelId, ClientId, BranchStatus, LastStatus);
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
