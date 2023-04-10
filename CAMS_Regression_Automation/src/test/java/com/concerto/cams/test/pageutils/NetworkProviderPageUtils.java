package com.concerto.cams.test.pageutils;

import org.gradle.internal.impldep.org.testng.Assert;

import com.concerto.cams.test.pages.Networkprovider;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class NetworkProviderPageUtils {

	protected Networkprovider networkprovider;

	public NetworkProviderPageUtils() {

		networkprovider = new Networkprovider();
	}

	@Step("To get the header of Network provider page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Network Provider");
		WebInteract.waitForVisibility(networkprovider.Page_Header);
		String PageHeader = Selenium.getText(networkprovider.Page_Header);
		Asserts.assertEqual(PageHeader, "Network Provider","Page header of Network provider is Correct");
	}

	@Step("To get the header of Add new Network provider page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(networkprovider.Add_btn);
		WebInteract.waitForVisibility(networkprovider.Agency_name);
		String PageHeader = Selenium.getText(networkprovider.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new network provider page header is Correct");
	}

	@Step("To get the header of Edit Network provider page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(networkprovider.Edit_Page_Header);
		String PageHeader = Selenium.getText(networkprovider.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit network provider page header is Correct");
	}

	@Step("To add new network provider")
	public void AddnewNetworkvendor(String AgencyName) throws Throwable {
		Selenium.sendKeys(networkprovider.Agency_name, AgencyName);
		Selenium.click(networkprovider.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add New Network Provider?","Alert message is displayed for Add new network provider");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(networkprovider.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(networkprovider.Successfull_message);
		Asserts.assertEqual(message, "Network provider agency details added successfully.","Network provider agency details added successfully.");
		Selenium.click(networkprovider.AddCancel_btn);
		WebInteract.waitForVisibility(networkprovider.Search_option);
		searchfuncforValidData(AgencyName);
		WebInteract.waitForVisibility(networkprovider.AgencyName_txt);
		Asserts.assertEqual(Selenium.getText(networkprovider.AgencyName_txt), AgencyName,"Agency name of Network provider is Correct");
	}

	@Step("To get validation message")
	public void GetValidationMessage() throws Throwable {
		Selenium.click(networkprovider.Add_button);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(networkprovider.Validation_message), "Required","Validation message is displayed for mandatory fields of Network provider page");
		Selenium.click(networkprovider.AddCancel_btn);
	}

	@Step("To validate whether duplicate entries are allowed or not")
	public void validateduplicaterecords(String AgencyName) throws Throwable {
		Selenium.sendKeys(networkprovider.Agency_name, AgencyName);
		Selenium.click(networkprovider.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add New Network Provider?","Alert message is displayed while adding new network provider");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(networkprovider.Error_message);
		String message = WebInteract.getNonstaleElementGetText(networkprovider.Error_message);
		Asserts.assertEqual(message, "This Network provider already exists.","Validation message is displayed for duplicate records of network provider");
		Selenium.click(networkprovider.AddCancel_btn);
	}

	@Step("To Edit existing record")
	public void Editnetworkprovider(String AgencyName, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(networkprovider.Edit_button);
		Selenium.click(networkprovider.Edit_button);
		WebInteract.waitForVisibility(networkprovider.Agency_name);
		GetEditPageHeader();
		Selenium.clear(networkprovider.Agency_name);
		Selenium.sendKeys(networkprovider.Agency_name, AgencyName);
		Selenium.click(networkprovider.Validationtxt);
		Selenium.click(networkprovider.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update Network Provider Details?","Alert message is displayed for update network proider details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(networkprovider.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(networkprovider.Successfull_message);
		Asserts.assertEqual(message, "Network provider agency details updated successfully.","Network provider agency details updated successfully.");
		Selenium.click(networkprovider.Cancel_btn);
		WebInteract.waitForVisibility(networkprovider.Search_option);
		searchfuncforValidData(AgencyName);
		WebInteract.waitForVisibility(networkprovider.AgencyName_txt);
		Asserts.assertEqual(Selenium.getText(networkprovider.AgencyName_txt), AgencyName,"Agency name of Network provider is Correct");
	}

	@Step("To Delete the entry of the page")
	public void DeleteNetworkprovider(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(networkprovider.Delete_btn);
		Selenium.click(networkprovider.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Network Provider Details?","Alert message is displayed while deleting network provider details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Network provider agency details deleted successfully.","Network provider agency details deleted successfully.");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(networkprovider.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(networkprovider.Search_option, searchtext);
		Selenium.click(networkprovider.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(networkprovider.Search_option, searchtext);
		Selenium.click(networkprovider.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is displayed for No records on Network provider page");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(networkprovider.Delete_btn);
		Selenium.click(networkprovider.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Network Provider Details?","Alert message is displayed while deleting Network provider record");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertTrue(Deletemessage.contains("Record can not be Deleted. It has a dependency."),"Correct alert message is displayed on deletion of used records");
		WebInteract.AcceptAlert();
	}
}
