package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.TerritoryManager;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class TerritoryManagerPageUtils {

	protected TerritoryManager territory;

	public TerritoryManagerPageUtils() {

		territory = new TerritoryManager();
	}

	@Step("To get the header of Territory manager page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Territory manager");
		WebInteract.waitForVisibility(territory.Page_Header);
		String PageHeader = Selenium.getText(territory.Page_Header);
		Asserts.assertEqual(PageHeader, "Territory Manager","Correct page header is displayed");
	}

	@Step("To get the header of Add new Territory manager page")
	public void GetAddPageHeader() throws Throwable {
		String PageHeader = Selenium.getText(territory.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Correct add page header is displayed");
	}

	@Step("To get the header of Edit Territory manager page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(territory.Edit_Page_Header);
		String PageHeader = Selenium.getText(territory.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Correct edit page header is displayed");
	}


	@Step("To add new territory")
	public void AddnewTerritory(String TerritoryName) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(territory.Add_new_territory);
		WebInteract.waitForVisibility(territory.territory_name);
		Asserts.assertEqual(Selenium.getText(territory.Add_Territory_Page_Header), "Add New Territory Name","Correct page header is displayed");
		Selenium.sendKeys(territory.territory_name, TerritoryName);
		Selenium.click(territory.Add_territory_name);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add Territory Name?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(territory.Successfull_message);
		String Successmessage = WebInteract.getNonstaleElementGetText(territory.Successfull_message);
		Asserts.assertEqual(Successmessage, "Territory name added successfully.","Correct message is displayed on adding territory");
		Selenium.click(territory.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshNewTerritory(String TerritoryName) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(territory.Add_new_territory);
		WebInteract.waitForVisibility(territory.territory_name);
		Asserts.assertEqual(Selenium.getText(territory.Add_Territory_Page_Header), "Add New Territory Name","Correct page header is displayed");
		Selenium.sendKeys(territory.territory_name, TerritoryName);
		Selenium.click(territory.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(territory.territory_name, "value").isEmpty(),"Territory name field is blank on refreshing");
		Selenium.click(territory.Cancel_btn);
	}

	@Step("To validate the duplicate entry for territory name")
	public void ValidateDuplicateEntryForName(String TerritoryName) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(territory.Add_new_territory);
		WebInteract.waitForVisibility(territory.territory_name);
		Asserts.assertEqual(Selenium.getText(territory.Add_Territory_Page_Header), "Add New Territory Name","Correct add territory name page header is displayed");
		Selenium.sendKeys(territory.territory_name, TerritoryName);
		Selenium.click(territory.Add_territory_name);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add Territory Name?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(territory.Error_message);
		String Successmessage = WebInteract.getNonstaleElementGetText(territory.Error_message);
		Asserts.assertEqual(Successmessage, "This territory name already exists.","Correct validation message is displayed for duplicate records on territory page");
		Selenium.click(territory.Close_btn);
	}

	@Step("To add new territory manager")
	public void AddTerritoryManager(String TerritoryName, String TerritoryManager, String MobileNo, String Emailid)
			throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(territory.Create_territory);
		WebInteract.waitForVisibility(territory.Add_territory);
		GetAddPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(territory.Add_territory, TerritoryName);
		Selenium.sendKeys(territory.Territory_manager, TerritoryManager);
		Selenium.sendKeys(territory.Mobile_no, MobileNo);
		Selenium.sendKeys(territory.Email_id, Emailid);
		Selenium.click(territory.Add_master_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you want to Add this Territory Datails?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(territory.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(territory.Successfull_message);
		Asserts.assertEqual(message, "Territory details added successfully.","Correct successful message is displayed on adding territory");
		Selenium.click(territory.Close_btn);
		WebInteract.waitForVisibility(territory.Search_option);
		searchfuncforValidData(TerritoryManager);
		WebInteract.waitForVisibility(territory.Territoryname_txt);
		Asserts.assertEqual(Selenium.getText(territory.Territoryname_txt), TerritoryName,"Correct territory name is displayed");
		Asserts.assertEqual(Selenium.getText(territory.TerritoryManagername_txt), TerritoryManager,"Correct territory manager name is displayed");
		Asserts.assertEqual(Selenium.getText(territory.Phoneno_txt), MobileNo,"Correct mobile no is displayed on territory page");
		Asserts.assertEqual(Selenium.getText(territory.Emailid_txt), Emailid,"Correct email id is displayed on territory page");
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String TerritoryName, String MobileNo, String Emailid) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(territory.Create_territory);
		WebInteract.waitForVisibility(territory.Add_territory);
		GetAddPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(territory.Add_territory, TerritoryName);
		Selenium.sendKeys(territory.Mobile_no, MobileNo);
		Selenium.sendKeys(territory.Email_id, Emailid);
		Selenium.click(territory.Add_master_button);
		//WebInteract.waitForVisibility(territory.Validation_message);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(territory.Validation_message), "Required","Correct validation message is displayed");
		Selenium.click(territory.Close_btn);
	}

	@Step("To validate duplicate entry of  territory manager")
	public void ValidateDuplicateEntry(String TerritoryName, String TerritoryManager, String MobileNo, String Emailid)
			throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(territory.Create_territory);
		WebInteract.waitForVisibility(territory.Add_territory);
		GetAddPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(territory.Add_territory, TerritoryName);
		Selenium.sendKeys(territory.Territory_manager, TerritoryManager);
		Selenium.sendKeys(territory.Mobile_no, MobileNo);
		Selenium.sendKeys(territory.Email_id, Emailid);
		Selenium.click(territory.Add_master_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you want to Add this Territory Datails?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(territory.Error_message);
		String message = WebInteract.getNonstaleElementGetText(territory.Error_message);
		Asserts.assertEqual(message, "This territory name already exists.","Correct alert message is displayed");
		Selenium.click(territory.Close_btn);
	}

	@Step("To edit territory manager details")
	public void EditTerritoryManagerDetails(String TerritoryName, String TerritoryManager, String MobileNo,
			String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(territory.Edit_btn);
		Selenium.click(territory.Edit_btn);
		WebInteract.waitForVisibility(territory.Add_territory);
		GetEditPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(territory.Add_territory, TerritoryName);
		Selenium.clear(territory.Mobile_no);
		Selenium.sendKeys(territory.Mobile_no, MobileNo);
		Selenium.click(territory.Email_id);
		Selenium.click(territory.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you want to Update this Vendor Territory Master ?","Correct alert message is displayed on territory page");
		//WebInteract.waitForVisibility(territory.Successfull_message);
		WebInteract.AcceptAlert();
		String message = WebInteract.getNonstaleElementGetText(territory.Successfull_message);
		Asserts.assertEqual(message, "Territory details updated successfully.","Correct message is displayed on updating territory");
		Selenium.click(territory.Edit_Closebtn);
		WebInteract.waitForVisibility(territory.Search_option);
		searchfuncforValidData(TerritoryName);
		WebInteract.waitForVisibility(territory.Territoryname_txt);
		Asserts.assertEqual(Selenium.getText(territory.Territoryname_txt), TerritoryName,"Correct territory name is displayed");
		Asserts.assertEqual(Selenium.getText(territory.Phoneno_txt), MobileNo,"Correct mobile no is displayed");
	}


	@Step("To Delete the entry of the page")
	public void DeleteTerritoryManagerVendor(String searchtext) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(searchtext);
		WebInteract.waitForVisibility(territory.Delete_btn);
		Selenium.click(territory.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Are you sure you want to Delete this Territory Details ?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Territory details deleted successfully.","Correct message is displayed on deletion of territory");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(territory.Create_territory);
		searchfuncforInValidData(searchtext);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(territory.Search_option, searchtext);
		Selenium.click(territory.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(territory.Search_option, searchtext);
		Selenium.click(territory.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are No Records available.","Correct alert message is displayed");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used territory manager record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(territory.Delete_btn);
		Selenium.click(territory.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Are you sure you want to Delete this Territory Details ?","Correct alert message is displayed on deletion of territory name");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage,"Record can not be Deleted. It has a dependency.","Correct message is displayed while deleting used records");
		WebInteract.AcceptAlert();
	}

}