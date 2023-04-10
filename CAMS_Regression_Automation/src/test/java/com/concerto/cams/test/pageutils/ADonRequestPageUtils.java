package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.ADonRequestPage;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ADonRequestPageUtils {
	
	ADonRequestPage ADonRequestPage;

	public ADonRequestPageUtils() {
		
		ADonRequestPage = new ADonRequestPage();
	}
	
	@Step("navigate to search AD on Request")
	public void navigateToSearchADRequest() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		//Selenium.click(ADonRequestPage.LaunchADonRequestPage);	
	}
	
	@Step("Entries for search AD on Request")
	public void SearchADRequest(String ClientName, String PanelID, String FrameFrequency, String CameraNo,String StartDate, 
			String StartTime, String EndTime) throws Throwable {
		WebInteract.waitForVisibility(ADonRequestPage.SelectClientNameDD);
		WebInteract.selectByTextFomDropdownfromStale(ADonRequestPage.SelectClientNameDD, ClientName);
		Selenium.sendKeys(ADonRequestPage.SelectPanelIDText, PanelID);
		Selenium.sendKeys(ADonRequestPage.SelectFramefrequencyText, FrameFrequency);
		WebInteract.selectByTextFomDropdownfromStale(ADonRequestPage.SelectCameraNo, CameraNo);
		Selenium.sendKeys(ADonRequestPage.StartDateCal, StartDate);
		Selenium.sendKeys(ADonRequestPage.StartTime, StartTime);
		Selenium.sendKeys(ADonRequestPage.EndTime, EndTime);
		Selenium.click(ADonRequestPage.SearchADReuqestBtn);
		WebInteract.WaitForAlert();
	
		
	}
		
}
