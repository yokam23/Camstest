package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.PanelMessageTrackingPage;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class PanelMessageTrackingPageUtils {

	
	PanelMessageTrackingPage PanelMessageTrackingPage;

	public PanelMessageTrackingPageUtils() {
		
		PanelMessageTrackingPage = new PanelMessageTrackingPage();
	}
	
	@Step("navigate to Panel Message Tracking")
	public void navigateToPanelMessageTracking() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(PanelMessageTrackingPage.LaunchPanelMessageTrackingPage);	
	}
	
	@Step("Entries for Panel Message Tracking")
	public void PanelMessageTracking(String ClientName, String PanelID) throws Throwable {
		WebInteract.waitForVisibility(PanelMessageTrackingPage.ClientNameDD);
		WebInteract.selectByTextFomDropdownfromStale(PanelMessageTrackingPage.ClientNameDD, ClientName);
		WebInteract.selectByTextFomDropdownfromStale(PanelMessageTrackingPage.PanelID, PanelID);
		Selenium.click(PanelMessageTrackingPage.StartTrackBtn);
		Selenium.click(PanelMessageTrackingPage.StopTrackBtn);
		Selenium.click(PanelMessageTrackingPage.PrintButton);	
		
	}
}
