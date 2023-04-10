package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.PanelsPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class PanelsPageUtils {

	PanelsPage PanelsPage;

	public PanelsPageUtils() {
		
		PanelsPage = new PanelsPage();
	}
	
	@Step("navigate to add panel")
	public void navigateToAddPanel() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(PanelsPage.AddButton);
	}
	
	@Step("Entries for add panel")
	public void AddPanel(String ClientName, String PanelType, String ProjectName, String PanelID,String ClientCircle, 
	String SOLID, String ManufacturingID, String State, String City, String Pincode, String SiteAddress, String SiteLocation,
    String BranchName, String PanelManufacturer, String PanelModel, String InstallationVendor, String CRAAgency,
    String HKAgency, String MSPAgency, String ProjectCoOrdinator, String ProjectLead, String ProjectManager,
    String TerritoryName, String TerritoryMgrName, String SubscriptionName, String MDNtextNo, String Antenna,
    String ATM1ID, String ATM2ID, String ATM3ID, String ATM4ID, String ATM5ID, String PanelCurVersion, String ServerPort,
    String Latitude, String Longitude, String DVRType, String DVRID, String DVRPassword, String DVRPort, String DVRChannelDD,
    String HDD1Space, String HDD2Space) throws Throwable {
		WebInteract.waitForVisibility(PanelsPage.ClientNameDD);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.ClientNameDD, ClientName);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.PanelTypeDD, PanelType);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.ProjectName, ProjectName);
		Selenium.sendKeys(PanelsPage.PanelIDText, PanelID);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.ClientCircle, ClientCircle);
		Selenium.sendKeys(PanelsPage.SOLID, SOLID);
		Selenium.sendKeys(PanelsPage.ManufacturingIDText, ManufacturingID);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.StateDD, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.CityDD, City);
		Selenium.sendKeys(PanelsPage.PincodeText, Pincode);
		Selenium.sendKeys(PanelsPage.SiteAddressText, SiteAddress);
		Selenium.clear(PanelsPage.SIteLocationText);
		Selenium.sendKeys(PanelsPage.SIteLocationText, SiteLocation);
		Selenium.sendKeys(PanelsPage.BranchText, BranchName);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.PanelMfgDD, PanelManufacturer);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.PanelModelDD, PanelModel);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.InstallationVendorDD, InstallationVendor);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.CRAAgencyDD, CRAAgency);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.HKAgencyDD, HKAgency);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.MSPAgencyDD, MSPAgency);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.ProCodDD, ProjectCoOrdinator);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.ProjectLeadDD, ProjectLead);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.ProjectManagerDD, ProjectManager);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.TerritoryName, TerritoryName);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.TerritoryMgrName, TerritoryMgrName);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.Subscription, SubscriptionName);
		Selenium.sendKeys(PanelsPage.MDNTextbox, MDNtextNo);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.AntennaDD, Antenna);
		Selenium.sendKeys(PanelsPage.ATM1ID, ATM1ID);
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.DVRTypeDD, DVRType);
		Selenium.sendKeys(PanelsPage.DVRIDDD, DVRID);
		Selenium.sendKeys(PanelsPage.DVRPass, DVRPassword);
		Selenium.sendKeys(PanelsPage.DVRPort,DVRPort );
		WebInteract.selectByTextFomDropdownfromStale(PanelsPage.DVRChannelDD, DVRChannelDD);
		Selenium.sendKeys(PanelsPage.HDD1SpaceText,HDD1Space);
		Selenium.click(PanelsPage.SaveButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you wish to add this panel?", "Correct Alert Message Is Displayed for Add Panel");
		WebInteract.AcceptAlert();
		String SuccessMessage =WebInteract.getNonstaleElementGetText(PanelsPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Panel added successfully", "Success Message Displayed for Panel Addition");
		WebInteract.moveToElement(PanelsPage.Sensorbtn);
		Selenium.click(PanelsPage.Sensorbtn);
		WebInteract.waitForVisibility(PanelsPage.AddSensorButton);
		WebInteract.validatePageTitle("Template Details");
		Selenium.click(PanelsPage.CheckAll);
		WebInteract.moveToElement(PanelsPage.UpdateSensorButton);
		Selenium.click(PanelsPage.UpdateSensorButton);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you want to update ?", "Correct alert message is displayed");
		WebInteract.AcceptAlert();
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(PanelsPage.Templatemsg),"Templates has been updated successfully","Correct message is displayed on sensor updation");
	    Selenium.click(PanelsPage.sensordetails);
		WebInteract.waitForVisibility(PanelsPage.Sensorupdatebtn);
		WebInteract.validatePageTitle("Sensor Details");
		Selenium.click(PanelsPage.Sensorupdatebtn);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you want to update ?", "Correct alert update message is displayed on sensor details page");
		WebInteract.AcceptAlert();
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(PanelsPage.sensorupdatemsg), "Sensor details updated successfully", "Correct message is displayed on sensor details updation");
		Selenium.click(PanelsPage.Cameradetails);
		WebInteract.waitForVisibility(PanelsPage.cameraupdatebtn);
		WebInteract.validatePageTitle("Camera Details");
		Selenium.click(PanelsPage.cameraupdatebtn);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you want to update ?", "Correct alert update message is displayed on camera details page");
		WebInteract.AcceptAlert();
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(PanelsPage.cameraupdatemsg), "Camera details updated successfully", "Correct message is displayed on camera details updation");
		Selenium.click(PanelsPage.Assetdetails);
		WebInteract.waitForVisibility(PanelsPage.Assetupdatebtn);
		WebInteract.validatePageTitle("Asset Details");
		Selenium.click(PanelsPage.Assetupdatebtn);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you want to update ?", "Correct alert update message is displayed on Asset details page");
		WebInteract.AcceptAlert();
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(PanelsPage.cameraupdatemsg), "Asset details updated successfully", "Correct message is displayed on Asset details updation");
	}
	
	@Step("navigate to Search panel")
	public void navigateToSearchPanel(String Searchpanel) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(PanelsPage.SearchPanels, Searchpanel);
		Selenium.click(PanelsPage.SearchPanelsBtn);
		}
	
	@Step("navigate to Delete panel")
	public void navigateToDeletePanel(String Searchpanel) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(PanelsPage.DeletePanelButton);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Assert.assertEquals(DeleteValidationMessage, "Do you want to delete this dealer?");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Assert.assertEquals(Deletemessage, "Panel deleted successfully");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(PanelsPage.AddButton);
		searchfuncforInValidData(Searchpanel);
	}
	
	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String SearchPanel) throws Throwable {
		Selenium.sendKeys(PanelsPage.SearchPanels, SearchPanel);
		Selenium.click(PanelsPage.SearchPanelsBtn);
		String Alertmessage = WebInteract.AlertGetText();
		Assert.assertEquals(Alertmessage, "There are no such records available.");
		WebInteract.AcceptAlert();
	}
	
	@Step("navigate to Edit panel")
	public void navigateToEditPanel() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(PanelsPage.EditPanelButton);
	}
	
	@Step("Entries for Edit panel")
	public void EditPanel(String PanelID, String Pincode, String SiteLocation, String SiteAddress,String BranchName, 
	String DVRChannelDD) throws Throwable {
				WebInteract.waitForVisibility(PanelsPage.SearchPanels);
				Selenium.sendKeys(PanelsPage.SearchPanels, PanelID);
				Selenium.click(PanelsPage.SearchPanelsBtn);
				WebInteract.waitForVisibility(PanelsPage.editbtn);
				Selenium.click(PanelsPage.editbtn);
				WebInteract.waitForVisibility(PanelsPage.Editpageheader);
				Selenium.clear(PanelsPage.pincode);
				Selenium.sendKeys(PanelsPage.pincode, Pincode);
				Selenium.clear(PanelsPage.sitelocation);
				Selenium.sendKeys(PanelsPage.sitelocation, SiteLocation);
				Selenium.clear(PanelsPage.siteaddress);
				Selenium.sendKeys(PanelsPage.siteaddress, SiteAddress);
				Selenium.clear(PanelsPage.Branch);
				Selenium.sendKeys(PanelsPage.Branch, BranchName);
				WebInteract.moveToElement(PanelsPage.Channels);
				WebInteract.selectByTextFomDropdownfromStale(PanelsPage.Channels, DVRChannelDD);
				Selenium.click(PanelsPage.UpdateButton);
				WebInteract.WaitForAlert();
				Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you wish to update this panel?", "Correct alert message is displayed while updating panel details");
	            WebInteract.AcceptAlert();
	            //WebInteract.waitForVisibility(PanelsPage.updatemessage);
	            Asserts.assertEqual(WebInteract.getNonstaleElementGetText(PanelsPage.Updatemsg), "Panel updated successfully", "Correct message is displayed on panel details updation");
	}
	
	@Step("To delete the panel record")
	public void DeletePanelRecord(String panelid) throws Throwable {
		WebInteract.waitForVisibility(PanelsPage.SearchPanels);
		Selenium.sendKeys(PanelsPage.SearchPanels, panelid);
		Selenium.click(PanelsPage.SearchPanelsBtn);
		WebInteract.waitForVisibility(PanelsPage.editbtn);
		Selenium.click(PanelsPage.editbtn);
		WebInteract.waitForVisibility(PanelsPage.Editpageheader);
		WebInteract.moveToElement(PanelsPage.DeletePanelButton);
	    Selenium.click(PanelsPage.DeletePanelButton);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you wish to delete this panel?", "Correct alert message is displayed");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Panel Deleted successfully", "Correct alert message is displayed on panel deletion");
		WebInteract.AcceptAlert();
	}
	}
















