package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.City;
import com.concerto.common.utilities.AllureManager;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;


import io.qameta.allure.Step;

public class CityPageUtils {

	protected City city;

	public CityPageUtils() {
		city = new City();
	}

	@Step("To get the header of City page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("City :: CAMSPlus");
		WebInteract.waitForVisibility(city.Page_Header);
		String PageHeader = Selenium.getText(city.Page_Header);
		System.out.println(PageHeader);
		Asserts.assertEqual(PageHeader, "City Master", "Correct City Page header is displayed");
		
	}

	@Step("To get the header of Add city page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(city.Add_City);
		Logger.logMessage("Add city page is displayed");
		WebInteract.waitForVisibility(city.statename);
		String PageHeader = Selenium.getText(city.Add_Page_Header);
		System.out.println(PageHeader);
		Asserts.assertEqual(PageHeader, "Add", "Correct add city page is displayed");
	}

	@Step("To get the header of Edit city page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(city.Edit_Page_Header);
		String PageHeader = Selenium.getText(city.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit City Master", "Correct edit city page is displayed");
	}

	@Step("To Add new city")
	public void AddnewCity(String Statename, String Cityname) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		// Selenium.click(city.Add_City);
		// WebInteract.waitForVisibility(city.statename);
		WebInteract.selectByTextFomDropdownfromStale(city.statename, Statename);
		Selenium.sendKeys(city.cityname, Cityname);
		Selenium.click(city.Add_btn);
		WebInteract.WaitForAlert();
		String message = WebInteract.AlertGetText();
		System.out.println(message);
		Asserts.assertEqual(message, "Are you sure to add this city?", "Correct alert message is displayed for add city details");
		WebInteract.WaitForAlert();
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(city.Successfull_message);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(city.Successfull_message);
		// String SuccessMessage = Selenium.getText(city.Successfull_message);
		Asserts.assertEqual(SuccessMessage, "City added successfully", "City added successfully");
		Selenium.click(city.Close_btn);
		Logger.logMessage("City is added Successfully");
		WebInteract.waitForVisibility(city.Search_option);
		searchfuncforValidData(Cityname);
		WebInteract.waitForVisibility(city.City_text);
		Asserts.assertEqual(Selenium.getText(city.City_text), Cityname,"Correct city name is displayed on city page");
		Asserts.assertEqual(Selenium.getText(city.State_text), Statename,"Correct State name is display on city page");
		try {
			AllureManager.attachScreenshot();
		}catch(Exception E) {
			Logger.logConsoleMessage(">>>>Unable To Attach Screenshot<<<<");
		}
	}

	@Step("To validate whether duplicate entries are allowed or not")
	public void ValidateDuplicateEntries(String Statename, String Cityname) throws Throwable {
		// Selenium.click(city.Add_City);
	   // WebInteract.waitForVisibility(city.statename);
		WebInteract.selectByTextFomDropdownfromStale(city.statename, Statename);
		Selenium.sendKeys(city.cityname, Cityname);
		Selenium.click(city.Add_btn);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to add this city?", "Correct alert message is displayed for add city details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(city.Error_message);
		String message = WebInteract.getNonstaleElementGetText(city.Error_message);
		//String message = Selenium.getText(city.Error_message);
		Asserts.assertEqual(message, "City already added","Validation message of city page is correct");
		Selenium.click(city.Close_btn);
		Logger.logMessage("Validation message is displayed for duplicate entries on city page");
	}

	@Step("To Edit the record of city page")
	public void EditCity(String Statename, String Cityname, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(city.Edit_btn);
		Selenium.click(city.Edit_btn);
		WebInteract.waitForVisibility(city.cityname);
		GetEditPageHeader();
		//Selenium.clear(city.EditStateName);
		WebInteract.selectByTextFomDropdownfromStale(city.EditStateName, Statename);
		Selenium.clear(city.cityname);
		Selenium.sendKeys(city.cityname, Cityname);
		Selenium.click(city.Update_btn);
		WebInteract.WaitForAlert();
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Do you want to update this city?","Alert message of edit city page is correct");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(city.Update_message);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(city.Update_message);
		//String SuccessMessage = Selenium.getText(city.Update_message);
		Asserts.assertEqual(SuccessMessage, "City updated successfully","City gets updated successfully");
		Selenium.click(city.Cancel_btn);
		Logger.logMessage("City details is updated successfully");
		WebInteract.waitForVisibility(city.Search_option);
		searchfuncforValidData(Cityname);
		WebInteract.waitForVisibility(city.City_text);
		Asserts.assertEqual(Selenium.getText(city.City_text), Cityname, "Correct city name is displayed on page");
		//Asserts.assertEqual(Selenium.getText(city.statename), Statename);
	}

	@Step("To delete the city from records")
	public void DeleteCity(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(city.Delete_btn);
		Selenium.click(city.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to delete this City?","Correct alert message is displayed while adding new city");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "City deleted successfully","City deleted successfully");
		Logger.logMessage("City is deleted successfully");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(city.Page_Header);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(city.Search_option, searchtext);
		Selenium.click(city.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(city.Search_option, searchtext);
		Selenium.click(city.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Correct alert Message is displayed for No records");
		WebInteract.AcceptAlert();
	}

	@Step("To delete the used data")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(city.Delete_btn);
		Selenium.click(city.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to delete this City?","Correct Alert message displayed while deleting city");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Unable to delete City details","Correct Validation message is displayed for used city record");
		WebInteract.AcceptAlert();
	}

	@Step("To get validation message")
	public void GetValidationMessage(String Statename) throws Throwable {
		// WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		// Selenium.click(city.Add_City);
		// WebInteract.waitForVisibility(city.statename);
		WebInteract.selectByTextFomDropdownfromStale(city.statename, Statename);
		Selenium.click(city.Add_btn);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure to add this city?","Correct Alert message is displayed for add new city");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(city.Validation_message);
		String Validationmessage = WebInteract.getNonstaleElementGetText(city.Validation_message);
		//String Validationmessage = Selenium.getText(city.Validation_message);
		Asserts.assertEqual(Validationmessage, "Required","Correct Validation message is displayed for mandatory field on city page");
		Selenium.click(city.Close_btn);
	}
}
