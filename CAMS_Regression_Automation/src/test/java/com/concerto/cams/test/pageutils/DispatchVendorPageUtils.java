package com.concerto.cams.test.pageutils;

import org.gradle.internal.impldep.org.testng.Assert;

import com.concerto.cams.test.pages.DispatchVendor;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class DispatchVendorPageUtils {

	protected DispatchVendor vendor;

	public DispatchVendorPageUtils() {
		vendor = new DispatchVendor();
	}

	@Step("To get the header of Dispatch vendor page")
	public void GetPageHeader() throws Throwable {
		if(WebInteract.isAlertPresent()) {
			Asserts.assertTrue(true, "Alert is present on page opening");
			WebInteract.AcceptAlert();
		}
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Dispatch Vendor");
		WebInteract.waitForVisibility(vendor.Page_Header);
		String PageHeader = Selenium.getText(vendor.Page_Header);
		Asserts.assertEqual(PageHeader, "Dispatch Vendor","Page header of Dispatch vendor is correct");
	}

	@Step("To get the header of Add Dispatch vendor page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(vendor.Add_btn);
		WebInteract.waitForVisibility(vendor.Company_name);
		Logger.logMessage("Add Dispatch vendor page is displayed");
		String PageHeader = Selenium.getText(vendor.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new Dispatch vendor page header is correct");
	}

	@Step("To get the header of Edit Dispatch vendor page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(vendor.Edit_Page_Header);
		String PageHeader = Selenium.getText(vendor.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit Dispatch vendor page header is Correct");
	}

	@Step("To add new Dispatch vendor")
	public void AddDispatchvendor(String CompanyName, String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(vendor.Company_name, CompanyName);
		Selenium.sendKeys(vendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(vendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(vendor.City, City);
		Selenium.sendKeys(vendor.Pin_code, Pincode);
		Selenium.sendKeys(vendor.Contact_person_name, ContactPerson);
		Selenium.sendKeys(vendor.Phone_no, PhoneNo);
		Selenium.sendKeys(vendor.Mobile_no, MobileNo);
		Selenium.sendKeys(vendor.Email_id, Emailid);
		Selenium.click(vendor.Mobile_no);
		Selenium.click(vendor.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Dispatch Vendor?","Alert message is displayed while adding new Dispatch vendor");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(vendor.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(vendor.Successfull_message);
		Asserts.assertEqual(message, "Dispatch vendor added successfully.","Dispatch vendor added successfully");
		Selenium.click(vendor.Close_btn);
		Logger.logMessage("Dispatch vendor details added successfully");
		WebInteract.waitForVisibility(vendor.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(vendor.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(vendor.CompanyName_txt), CompanyName,"Correct company name is displayed for added Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.State_txt), State,"Correct State name is displayed for added Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.City_txt), City,"Correct City name is displayed for added Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.Address_txt), CompanyAddress,"Correct Address txt is displayed for added Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.ContactPerson_txt), ContactPerson,"Correct Contact person name is displayed for added Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.Phoneno_txt), PhoneNo,"Correct phone no is displayed for added Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.Mobile_txt), MobileNo,"Correct mobile no is displayed for added Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.Emailid_txt), Emailid,"Correct Email id is displayed for added Dispatch vendor");
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(vendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(vendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(vendor.City, City);
		Selenium.sendKeys(vendor.Pin_code, Pincode);
		Selenium.sendKeys(vendor.Contact_person_name, ContactPerson);
		Selenium.sendKeys(vendor.Phone_no, PhoneNo);
		Selenium.sendKeys(vendor.Mobile_no, MobileNo);
		Selenium.sendKeys(vendor.Email_id, Emailid);
		Selenium.click(vendor.Add_button);
		//WebInteract.waitForVisibility(vendor.Validation_message);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(vendor.Validation_message), "Required","Validation message is displayed for mandatory fields on Dispatch vendors page");
		Selenium.click(vendor.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(vendor.Company_name, CompanyName);
		Selenium.sendKeys(vendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(vendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(vendor.City, City);
		Selenium.sendKeys(vendor.Pin_code, Pincode);
		Selenium.sendKeys(vendor.Contact_person_name, ContactPerson);
		Selenium.sendKeys(vendor.Phone_no, PhoneNo);
		Selenium.sendKeys(vendor.Mobile_no, MobileNo);
		Selenium.sendKeys(vendor.Email_id, Emailid);
		Selenium.click(vendor.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(vendor.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(vendor.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(vendor.State, "value").isEmpty(),"Company state field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(vendor.Pin_code, "value").isEmpty(),"Company pincode field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(vendor.Contact_person_name, "value").isEmpty(),"Company person name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(vendor.Phone_no, "value").isEmpty(),"Company phone no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(vendor.Mobile_no, "value").isEmpty(),"Company mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(vendor.Email_id, "value").isEmpty(),"Company email id field is blank on refreshing");
		Selenium.click(vendor.Close_btn);
	}

	@Step("To validate whether duplicate entries are allowed or not")
	public void ValidateDuplicateEntries(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(vendor.Company_name, CompanyName);
		Selenium.sendKeys(vendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(vendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(vendor.City, City);
		Selenium.sendKeys(vendor.Pin_code, Pincode);
		Selenium.sendKeys(vendor.Contact_person_name, ContactPerson);
		Selenium.sendKeys(vendor.Phone_no, PhoneNo);
		Selenium.sendKeys(vendor.Mobile_no, MobileNo);
		Selenium.sendKeys(vendor.Email_id, Emailid);
		Selenium.click(vendor.Add_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Dispatch Vendor?","Alert message is dsiplayed for Add new dispatch vendor details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(vendor.Error_message);
		String message = WebInteract.getNonstaleElementGetText(vendor.Error_message);
		Asserts.assertEqual(message, "This Dispatch vendor already exists.","Validation message is displayed for duplicate dispatch vendor");
		Selenium.click(vendor.Close_btn);
	}

	@Step("To Edit Dispatch vendor")
	public void EditNewvendor(String CompanyName, String State, String City, String Pincode) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(vendor.Edit_btn);
		Selenium.click(vendor.Edit_btn);
		WebInteract.waitForVisibility(vendor.Company_name);
		GetEditPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(vendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(vendor.City, City);
		Selenium.clear(vendor.Pin_code);
		Selenium.sendKeys(vendor.Pin_code, Pincode);
		Selenium.click(vendor.Email_id);
		Selenium.click(vendor.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to update this Dispatch Vendor Details?","Alert message is displayed for updating Dispatch vendor details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(vendor.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(vendor.Successfull_message);
		Asserts.assertEqual(message, "Dispatch vendor updated successfully.","Dispatch vendor updated successfully");
		Selenium.click(vendor.Close_btn);
		Logger.logMessage("Dispatch vendor updated successfully");
		WebInteract.waitForVisibility(vendor.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(vendor.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(vendor.State_txt), State,"Correct state name is displayed for updated Dispatch vendor");
		Asserts.assertEqual(Selenium.getText(vendor.City_txt), City,"Correct City name is displayed for added Dispatch vendor");

	}

	@Step("To Delete the entry of the page")
	public void DeleteVendor(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(vendor.Delete_btn);
		Selenium.click(vendor.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to delete this Dispatch service vendor Details?","Alert message is displayed while deleting Dispatch service vendor details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Dispatch vendor deleted successfully.","Dispatch vendor deleted successfully");
		WebInteract.AcceptAlert();
		Logger.logMessage("Dispatch vendor detail deleted successfully");
		WebInteract.waitForVisibility(vendor.Add_btn);
		searchfuncforInValidData(Searchtxt);

	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(vendor.Delete_btn);
		Selenium.click(vendor.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to delete this Dispatch service vendor Details?","Alert message is displayed while deleting Dispatch service vendor");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Record can not be Deleted. It has a dependency.","Validation message is displayed while deleting used Disaptch vendor details");
		WebInteract.AcceptAlert();
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(vendor.Search_option, searchtext);
		Selenium.click(vendor.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(vendor.Search_option, searchtext);
		Selenium.click(vendor.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is displayed for No records on Dispatch vendor page");
		WebInteract.AcceptAlert();
	}

}
