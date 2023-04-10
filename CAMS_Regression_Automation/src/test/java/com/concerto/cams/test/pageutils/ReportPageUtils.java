package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.ReportsPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ReportPageUtils {
	
	protected ReportsPage ReportsPage;

	public ReportPageUtils() {
		ReportsPage = new ReportsPage();
	}

	@Step("Generate Panel Report")
	public void SearchPanelAlert(String ReportName,String PanelId) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.selectByTextFomDropdownfromStale(ReportsPage.ddlReportType, ReportName);
		Thread.sleep(1000);
		WebInteract.getNonstaleElementAndSendKeys(ReportsPage.txtPanelID, PanelId);
		Selenium.click(ReportsPage.btnGenerateReport);
		Thread.sleep(1000);
	}
	
	public void validateAlarmPanel(String PanelId,String Client) throws Throwable {
		Asserts.assertEqual(Selenium.getText(ReportsPage.Panel), PanelId, "Correct Panel Id is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.Client), Client, "Correct Client is displayed");		
	}
	
	public void validatePanelNotResponding(String PanelId,String Client,String RouterModel,String NetworkType,String NetworkProvider) throws Throwable {
		Asserts.assertEqual(Selenium.getText(ReportsPage.Panel), PanelId, "Correct Panel Id is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.Client), Client, "Correct Client is displayed");	
		Asserts.assertEqual(Selenium.getText(ReportsPage.RouterModel), RouterModel, "Correct RouterModel is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.NetworkType), NetworkType, "Correct NetworkType is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.NetworkProvider), NetworkProvider, "Correct NetworkProvider is displayed");
	}
	
	public void validateBranchReports(String PanelId,String Client,String BranchStatus,String LastStatus) throws Throwable {
		Asserts.assertEqual(Selenium.getText(ReportsPage.Panel), PanelId, "Correct Panel Id is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.Client), Client, "Correct Client is displayed");	
		Asserts.assertEqual(Selenium.getText(ReportsPage.BranchStatus), BranchStatus, "Correct RouterModel is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.LastStatus), LastStatus, "Correct NetworkType is displayed");
	}
	
	public void validateBranchOpenReports(String PanelId,String Client,String BranchStatus,String LastStatus) throws Throwable {
		Asserts.assertEqual(Selenium.getText(ReportsPage.Panel), PanelId, "Correct Panel Id is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.Client), Client, "Correct Client is displayed");	
		Asserts.assertEqual(Selenium.getText(ReportsPage.BranchOpenStatus), BranchStatus, "Correct RouterModel is displayed");
		Asserts.assertEqual(Selenium.getText(ReportsPage.BranchOpenLastStatus), LastStatus, "Correct NetworkType is displayed");
	}

}
