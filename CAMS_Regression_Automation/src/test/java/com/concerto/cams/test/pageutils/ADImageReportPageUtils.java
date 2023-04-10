package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.ADImageReportPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ADImageReportPageUtils {

	
	ADImageReportPage ADImageReportPage;

	public ADImageReportPageUtils() {
		
		ADImageReportPage = new ADImageReportPage();
	}
	
	@Step("navigate to search AD Image Report")
	public void navigateToSearchADImageReport() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(ADImageReportPage.LaunchADImageReportPage);
		
	}

	
	@Step("Entries search AD Image Report")
	public void SearchADImageReport(String StartDate, String Client, String PanelID, String TicketList) throws Throwable {
		
		WebInteract.waitForVisibility(ADImageReportPage.StartDateCal);
		WebInteract.selectByTextFomDropdownfromStale(ADImageReportPage.StartDateCal, StartDate);
		WebInteract.selectByTextFomDropdownfromStale(ADImageReportPage.SelectClientDD, Client);
		WebInteract.selectByTextFomDropdownfromStale(ADImageReportPage.SelectPanelID, PanelID);
		WebInteract.selectByTextFomDropdownfromStale(ADImageReportPage.SelectTicketList, TicketList);
		Selenium.click(ADImageReportPage.SearchButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you wish to search AD Image Report?", "Correct Alert Message Is Displayed for search AD Image Repor");
		WebInteract.AcceptAlert();
		
	}
}
