package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.Manufacturer;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ManufacturerPageUtils {

	protected Manufacturer manufacturer;

	public ManufacturerPageUtils() {
		manufacturer = new Manufacturer();
	}

	@Step("To get the header of manufacturer page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Manufacturer");
		WebInteract.waitForVisibility(manufacturer.Page_Header);
		String PageHeader = Selenium.getText(manufacturer.Page_Header);
		Asserts.assertEqual(PageHeader, "Manufacturer","Page header of Manufacturer is correct");
	}

	@Step("To get the header of Add new manufacturer page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(manufacturer.Add_btn);
		WebInteract.waitForVisibility(manufacturer.Company_name);
		Logger.logMessage("Add Manufacturer page is displayed");
		String PageHeader = Selenium.getText(manufacturer.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new manufacturer page header is Correct");
	}

	@Step("To get the header of Edit manufacturer page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(manufacturer.Edit_Page_Header);
		String PageHeader = Selenium.getText(manufacturer.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit manufacturer page header is Correct");
	}

	@Step("To add new Manufacturer")
	public void AddnewManufacturer(String Devicename, String companyName) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(manufacturer.Device_name, Devicename);
		Selenium.sendKeys(manufacturer.Company_name, companyName);
		Selenium.click(manufacturer.Add_manufacturer);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Manufacturer Details?","Alert message is displayed while adding new manufacturer details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(manufacturer.Successfull_message);
		String successfull_message = WebInteract.getNonstaleElementGetText(manufacturer.Succesfull_message);
		Asserts.assertEqual(successfull_message, "Device Manufacturer details added successfully.","Device Manufacturer details added successfully.");
		Selenium.click(manufacturer.Close_btn);
		Logger.logMessage("Device Manufaturer details added successfully");
		WebInteract.waitForVisibility(manufacturer.Search_option);
		searchfuncforValidData(companyName);
		WebInteract.waitForVisibility(manufacturer.Device_txt);
		Asserts.assertEqual(Selenium.getText(manufacturer.Device_txt), Devicename,"Device name of manufacturer details is Correct");
		Asserts.assertEqual(Selenium.getText(manufacturer.companyName_txt), companyName,"Company name of manufacturer details is Correct");
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String companyName) throws Throwable {
		Selenium.sendKeys(manufacturer.Company_name, companyName);
		Selenium.click(manufacturer.Add_manufacturer);
		//WebInteract.waitForVisibility(manufacturer.Validation_message);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(manufacturer.Validation_message), "Required","Validation message is displayed for mandatory fields on manufacturer page");
		Selenium.click(manufacturer.Close_btn);
	}

	@Step("To validate whether duplicate entries allowed or not")
	public void ValidateDuplicateEntries(String Devicename, String companyName) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(manufacturer.Device_name, Devicename);
		Selenium.sendKeys(manufacturer.Company_name, companyName);
		Selenium.click(manufacturer.Add_manufacturer);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Manufacturer Details?","Alert message is displayed for adding new Manufacturer details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(manufacturer.Error_message);
		String successfull_message = WebInteract.getNonstaleElementGetText(manufacturer.Error_message);
		Asserts.assertEqual(successfull_message, "This Company name is already exists.","Validation message is displayed for adding duplicate records of manufacturer");
		Selenium.click(manufacturer.Close_btn);
	}

	@Step("To refresh the Manufacturer added details")
	public void RefreshManufacturerdetails(String Devicename, String companyName) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(manufacturer.Device_name, Devicename);
		Selenium.sendKeys(manufacturer.Company_name, companyName);
		Selenium.click(manufacturer.Refresh_btn);
		Asserts.assertTrue(Selenium.getAttribute(manufacturer.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(manufacturer.Device_name, "value").isEmpty(),"Device name field is blank on refreshing");
		Selenium.click(manufacturer.Close_btn);
	}

	@Step("To Update the entry of manufacturer page")
	public void EditManufacturer(String Devicename, String companyName, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(manufacturer.Edit_btn);
		Selenium.click(manufacturer.Edit_btn);
		WebInteract.waitForVisibility(manufacturer.Company_name);
		GetEditPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(manufacturer.Device_name, Devicename);
		Selenium.clear(manufacturer.Company_name);
		Selenium.sendKeys(manufacturer.Company_name, companyName);
		Selenium.click(manufacturer.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to update this Manufacturer Details?","Alert message is displayed for updating manufacturer details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(manufacturer.Successfull_message);
		String successfull_message = WebInteract.getNonstaleElementGetText(manufacturer.Update_message);
		Asserts.assertEqual(successfull_message, "Manufacturer details updated successfully.","Manufacturer details updated successfully.");
		Selenium.click(manufacturer.Edit_closeBtn);
		Logger.logMessage("Manufacturer details updated successfully");
		searchfuncforValidData(companyName);
		WebInteract.waitForVisibility(manufacturer.Device_txt);
		Asserts.assertEqual(Selenium.getText(manufacturer.Device_txt), Devicename,"Device name of manufacturer is Correct");
		Asserts.assertEqual(Selenium.getText(manufacturer.companyName_txt), companyName,"Company name of manufacurer is Correct");
	}

	@Step("To delete the entry of page")
	public void DeleteManufacturer(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(manufacturer.Delete_btn);
		Selenium.click(manufacturer.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Manufacturer Details?","Alert message is dispayed while deleting manufacturer details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Manufacturer details deleted successfully.","Manufacturer details deleted successfully");
		WebInteract.AcceptAlert();
		Logger.logMessage("Manufacturer details deleted successfully.");
		WebInteract.waitForVisibility(manufacturer.Add_btn);
	}

	@Step("To delete the Used records")
	public void DeleteUsedManufacturer(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(manufacturer.Delete_btn);
		Selenium.click(manufacturer.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		WebInteract.WaitForAlert();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Manufacturer Details?","Alert message is displayed while deleting manufacturer details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage,"Can not Delete Manufacturer details.It may have Dependencies.","Correct message is displayed on deletion of used records");
		WebInteract.AcceptAlert();
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(manufacturer.Search_option, searchtext);
		Selenium.click(manufacturer.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(manufacturer.Search_option, searchtext);
		Selenium.click(manufacturer.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message for No records on Manufacturer page");
		WebInteract.AcceptAlert();
	}

}
