package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.Makemodel;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class MakeModelPageUtils {

	protected Makemodel makemodel;

	public MakeModelPageUtils() {
		makemodel = new Makemodel();
	}

	@Step("To get the header of Makemodel page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Make Model");
		WebInteract.waitForVisibility(makemodel.Page_Header);
		String PageHeader = Selenium.getText(makemodel.Page_Header);
		Asserts.assertEqual(PageHeader, "Make Model","Page header of Make model is Correct");
	}

	@Step("To get the header of Add new Makemodel page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Logger.logMessage("Add make model page is displayed");
		String PageHeader = Selenium.getText(makemodel.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Page header of Add new make model is Correct");
	}

	@Step("To get the header of Edit Makemodel page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(makemodel.Edit_Page_Header);
		String PageHeader = Selenium.getText(makemodel.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit make model page header is Correct");
	}

	@Step("Add new Make model")
	public void AddMakeModel(String GenericName, String Manufacturer, String ModelName, String DeviceName,
			String DeviceCapacity, String searchtext) throws Throwable {
		searchfuncforValidData(searchtext);
		Thread.sleep(3000);
		WebInteract.waitForVisibility(makemodel.Add_btn);
		Selenium.click(makemodel.Add_btn);
		WebInteract.waitForVisibility(makemodel.Device_capacity);
		GetAddPageHeader();
		Selenium.sendKeys(makemodel.Generic_name, GenericName);
		WebInteract.selectByTextFomDropdownfromStale(makemodel.Manufacturer_name, Manufacturer);
		Selenium.sendKeys(makemodel.Model_name, ModelName);
		Selenium.sendKeys(makemodel.Device_version, DeviceName);
		Selenium.sendKeys(makemodel.Device_capacity, DeviceCapacity);
		Selenium.click(makemodel.Add_button);
		String message = WebInteract.getNonstaleElementGetText(makemodel.Successfull_message);
		Asserts.assertEqual(message, "Make model details added successfully.","Make model details added successfully.");
		Selenium.click(makemodel.Close_btn);
		Logger.logMessage("Make model details added successfully");
	}

	@Step("To get validation message")
	public void GetValidationMessage(String GenericName, String ModelName, String DeviceName, String DeviceCapacity,
			String searchtext) throws Throwable {
		searchfuncforValidData(searchtext);
		WebInteract.waitForVisibility(makemodel.Add_btn);
		Selenium.click(makemodel.Add_btn);
		WebInteract.waitForVisibility(makemodel.Generic_name);
		GetAddPageHeader();
		Selenium.sendKeys(makemodel.Generic_name, GenericName);
		Selenium.sendKeys(makemodel.Model_name, ModelName);
		Selenium.sendKeys(makemodel.Device_version, DeviceName);
		Selenium.sendKeys(makemodel.Device_capacity, DeviceCapacity);
		Selenium.click(makemodel.Add_button);
		// WebInteract.waitForVisibility(makemodel.Validation_message);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(makemodel.Validation_message), "Required","Validation message is displayed for Mandatory field of make model page");
		Selenium.click(makemodel.Close_btn);
	}

	@Step("To validate duplicate entries are allowed or not")
	public void ValidateDuplicateEntries(String GenericName, String Manufacturer, String ModelName, String DeviceName,
			String DeviceCapacity, String searchtext) throws Throwable {
		searchfuncforValidData(searchtext);
		Thread.sleep(2000);
		WebInteract.waitForVisibility(makemodel.Add_btn);
		Selenium.click(makemodel.Add_btn);
		WebInteract.waitForVisibility(makemodel.Generic_name);
		GetAddPageHeader();
		Selenium.sendKeys(makemodel.Generic_name, GenericName);
		WebInteract.selectByTextFomDropdownfromStale(makemodel.Manufacturer_name, Manufacturer);
		Selenium.sendKeys(makemodel.Model_name, ModelName);
		Selenium.sendKeys(makemodel.Device_version, DeviceName);
		Selenium.sendKeys(makemodel.Device_capacity, DeviceCapacity);
		Selenium.click(makemodel.Add_button);
		//String message = WebInteract.getNonstaleElementGetText(makemodel.Error_message);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(makemodel.Error_message), "This make model combination already exists.","Validation message is displayed for Duplicate make model record");
		Selenium.click(makemodel.Close_btn);
	}

	@Step("To refresh the added details")
	public void Refreshdetails(String GenericName, String Manufacturer, String ModelName, String DeviceName,
			String DeviceCapacity, String searchtext) throws Throwable {
		searchfuncforValidData(searchtext);
		WebInteract.waitForVisibility(makemodel.Add_btn);
		Selenium.click(makemodel.Add_btn);
		WebInteract.waitForVisibility(makemodel.Generic_name);
		GetAddPageHeader();
		Selenium.sendKeys(makemodel.Generic_name, GenericName);
		WebInteract.selectByTextFomDropdownfromStale(makemodel.Manufacturer_name, Manufacturer);
		Selenium.sendKeys(makemodel.Model_name, ModelName);
		Selenium.sendKeys(makemodel.Device_version, DeviceName);
		Selenium.sendKeys(makemodel.Device_capacity, DeviceCapacity);
		Selenium.click(makemodel.Refresh_btn);
		Asserts.assertTrue(Selenium.getAttribute(makemodel.Generic_name, "value").isEmpty(),"Generic name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(makemodel.Manufacturer_name, "value").isEmpty(),"Manufacturer name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(makemodel.Model_name, "value").isEmpty(),"Model name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(makemodel.Device_version, "value").isEmpty(),"Device version field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(makemodel.Device_capacity, "value").isEmpty(),"Device capacity field is blank on refreshing");
		Selenium.click(makemodel.Close_btn);
	}

	@Step("Edit Make model")
	public void EditmakeModel(String Manufacturer, String ModelName) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(makemodel.Edit_btn);
		WebInteract.waitForVisibility(makemodel.Generic_name);
		GetEditPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(makemodel.Manufacturer_name, Manufacturer);
		Selenium.clear(makemodel.Model_name);
		Selenium.sendKeys(makemodel.Model_name, ModelName);
		Selenium.click(makemodel.Update_btn);
		String message = WebInteract.getNonstaleElementGetText(makemodel.Successfull_message);
		Asserts.assertEqual(message, "Make model details updated successfully.","Make model details updated successfully");
		Selenium.click(makemodel.Close_btn);
		Logger.logMessage("Make model details updated successfully");
	}

	@Step("To delete the Makemodel")
	public void DeleteMakeModel(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(makemodel.Delete_btn);
		Selenium.click(makemodel.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Device Details?","Alert message is displayed while deleting make model record");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Make model deleted successfully.","Make model details deleted successfully");
		WebInteract.AcceptAlert();
		Logger.logMessage("Make model deleted successfully.");
		WebInteract.waitForVisibility(makemodel.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To delete the Used records")
	public void DeleteUsedMakemodel(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(makemodel.Delete_btn);
		Selenium.click(makemodel.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Make model Details?","Alert message is displayed while deleting make model details");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Can not delete make model details. It may have Dependencies.","Alert message is displayed while deleting used make model records");
		WebInteract.AcceptAlert();
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(makemodel.Search_option, searchtext);
		Selenium.click(makemodel.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(makemodel.Search_option, searchtext);
		Selenium.click(makemodel.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is displayed for No records on make model page");
		WebInteract.AcceptAlert();
	}

}
