package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.PanelCategoryPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class PanelCategoryPageUtils {
	
	PanelCategoryPage PanelCategoryPage;
	

	public PanelCategoryPageUtils() {
		
		PanelCategoryPage = new PanelCategoryPage();
	}
	
	@Step("navigate to Change panel category from Genral to VIP")
	public void navigateToPanelCategoryGenralToVIP() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(PanelCategoryPage.SearchPanelID);	
	}
	
	@Step("Entries for Change panel category from Genral to VIP")
	public void PanelCategoryGenralToVIP(String SearchPanel) throws Throwable {
		WebInteract.waitForVisibility(PanelCategoryPage.SelectPanlCategory);
		Selenium.click(PanelCategoryPage.GeneralRButton);
		Selenium.sendKeys(PanelCategoryPage.SearchPanelID, SearchPanel);
		Selenium.click(PanelCategoryPage.AssignCheckbox);
		Selenium.click(PanelCategoryPage.VIPRButtonChg);
		Selenium.click(PanelCategoryPage.ChangePanelCatBtn);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you want to change Panel Category?", "Correct Alert Message Is Displayed for change Panel Category");
		WebInteract.AcceptAlert();
		
		String SuccessMessage =WebInteract.AlertGetText();
		Asserts.assertEqual(SuccessMessage, "Panels category updated successfully.", "Success Message Displayed for change Panel Category");		
	}
	
	

	@Step("navigate to Change panel category from VIP to Genral")
	public void navigateToPanelCategoryVIPToGenral() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(PanelCategoryPage.SearchPanelID);	
	}
	
	@Step("Entries for Change panel category from  VIP to Genral")
	public void PanelCategoryVIPToGenral(String SearchPanel) throws Throwable {
		WebInteract.waitForVisibility(PanelCategoryPage.SelectPanlCategory);
		Selenium.click(PanelCategoryPage.VIPRButton);
		Selenium.sendKeys(PanelCategoryPage.SearchPanelID, SearchPanel);
		Selenium.click(PanelCategoryPage.AssignCheckbox);
		Selenium.click(PanelCategoryPage.GeneralRButtonChg);
		Selenium.click(PanelCategoryPage.ChangePanelCatBtn);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you want to change Panel Category?", "Correct Alert Message Is Displayed for change Panel Category");
		WebInteract.AcceptAlert();
		
		String SuccessMessage =WebInteract.AlertGetText();
		Asserts.assertEqual(SuccessMessage, "Panels category updated successfully.", "Success Message Displayed for change Panel Category");		
	}

}
