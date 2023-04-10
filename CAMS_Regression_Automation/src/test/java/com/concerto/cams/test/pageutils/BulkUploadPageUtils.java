package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.BulkUploadPage;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class BulkUploadPageUtils {


	BulkUploadPage BulkUploadPage;

	public BulkUploadPageUtils() {
		
		BulkUploadPage = new BulkUploadPage();
	}
	
	@Step("navigate to add bulk upload")
	public void navigateToBulkUpload() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(BulkUploadPage.UploadRadioButton);	
	}
	
	@Step("Entries for add bulk upload")
	public void BulkUpload(String sheet) throws Throwable {
	        Selenium.click(BulkUploadPage.ChoosetoUpload);
	        WebInteract.selectByTextFomDropdownfromStale(BulkUploadPage.SelectSheetDD, sheet);
	        Selenium.click(BulkUploadPage.DownloadSample);	
	}
	
	@Step("navigate to bulk update")
	public void navigateToBulkUpdate() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(BulkUploadPage.UpdateRadioButton);	
	}
	
	@Step("Entries for bulk update")
	public void BulkUpdate(String sheet) throws Throwable {
	        Selenium.click(BulkUploadPage.ChoosetoUpdate);
	        WebInteract.selectByTextFomDropdownfromStale(BulkUploadPage.SelectSheetDD, sheet);
	}
}
