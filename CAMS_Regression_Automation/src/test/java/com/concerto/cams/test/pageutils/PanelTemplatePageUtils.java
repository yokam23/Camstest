package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.PanelTemplatePage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class PanelTemplatePageUtils {

	
	PanelTemplatePage PanelTemplatePage;

	public PanelTemplatePageUtils() {
		
		PanelTemplatePage = new PanelTemplatePage();
	}
	
	
	@Step("navigate to add  Panel Template")
	public void navigateToAddPanelTemplate() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(PanelTemplatePage.AddButton);	
	}
	
	@Step("Entries for add Panel Template")
	public void AddPanelTemplate(String TemplateName, String Client, String PanelType, String State, String City, String PhoneNo, 
		String Pincode, String CRAAgency, String MSPAgency, String PanelManufacturer, String PanelModel, String HKAgency,String InstallationVendor,
		 String ProjectCoOrdinator, String ProjectLead, String TerritoryName, String TerritoryManager, String ProjectManager) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(PanelTemplatePage.AddTemplateName);
		Selenium.sendKeys(PanelTemplatePage.AddTemplateName, TemplateName);	
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.AddClient, Client);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.AddPanelType, PanelType);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.StateDD, State);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.CityDD, City);
		Selenium.sendKeys(PanelTemplatePage.AddPhoneNo1, PhoneNo);	
		Selenium.sendKeys(PanelTemplatePage.PanelTempPincode, Pincode);		
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PAnelTempCRAAgencyDD, CRAAgency);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempMSPAgencyDD, MSPAgency);
		Selenium.sendKeys(PanelTemplatePage.PanelTempPanelMfgDD, PanelManufacturer);	
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempPanelModelDD, PanelModel);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempHKAgencyDD, HKAgency);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempInstallationVendorDD, InstallationVendor);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempProCodDD, ProjectCoOrdinator);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempProjectLeadDD, ProjectLead);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempTerritoryNameDD, TerritoryName);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempTerritoryMgrName, TerritoryManager);
		WebInteract.selectByTextFomDropdownfromStale(PanelTemplatePage.PanelTempProjectDD, ProjectManager);
		Selenium.click(PanelTemplatePage.CreateButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you wish to add panel template?", "Correct Alert Message Is Displayed for Add Panel template");
		WebInteract.AcceptAlert();
		
		String SuccessMessage =Selenium.getText(PanelTemplatePage.PanelTempSuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Panel template added successfully", "Success Message Displayed for panel template Addition");		
		
	}
	
	@Step("navigate to search Panel Template")
	public void navigateToSearchPanelTemplate(String SearchPanelTemp) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(PanelTemplatePage.PanelTempSearch, SearchPanelTemp);
		Selenium.click(PanelTemplatePage.GoButton);	
	}
	
	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String SearchPanelTemp) throws Throwable {
		Selenium.sendKeys(PanelTemplatePage.PanelTempSearch, SearchPanelTemp);
		Selenium.click(PanelTemplatePage.GoButton);
		String Alertmessage = WebInteract.AlertGetText();
		Assert.assertEquals(Alertmessage, "There are no such records available.");
		WebInteract.AcceptAlert();
	}
}











