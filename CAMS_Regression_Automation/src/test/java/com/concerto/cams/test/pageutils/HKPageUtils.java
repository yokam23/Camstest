package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.HKAgency;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class HKPageUtils {

	protected HKAgency HKagency;

	public HKPageUtils() {
		HKagency = new HKAgency();
	}

	@Step("To get the header of HK Agency page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("House Keeping Agency");
		WebInteract.waitForVisibility(HKagency.Page_Header);
		String PageHeader = Selenium.getText(HKagency.Page_Header);
		Asserts.assertEqual(PageHeader, "House Keeping Agency","Page header of HK agency is Correct");
	}

	@Step("To get the header of Add new HK Agency page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(HKagency.Add_btn);
		WebInteract.waitForVisibility(HKagency.Company_name);
		Logger.logMessage("Add Hk page is displayed");
		String PageHeader = Selenium.getText(HKagency.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new HK agency page header is Correct");
	}

	@Step("To get the header of Edit HK Agency page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(HKagency.Edit_Page_Header);
		String PageHeader = Selenium.getText(HKagency.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit HK agency page header is Correct");
	}

	@Step("To add new CRA agency")
	public void AddhkAgency(String CompanyName, String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(HKagency.Company_name, CompanyName);
		Selenium.sendKeys(HKagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.City, City);
		Selenium.sendKeys(HKagency.Pin_code, Pincode);
		Selenium.sendKeys(HKagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(HKagency.Phone_no, PhoneNo);
		Selenium.sendKeys(HKagency.Mobile_no, MobileNo);
		Selenium.sendKeys(HKagency.Email_id, Emailid);
		Selenium.click(HKagency.Phone_no);
		Selenium.click(HKagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed while adding new HK details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(HKagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(HKagency.Successfull_message);
		Asserts.assertEqual(message, "House keeping agency Added successfully.","House keeping agency Added successfully.");
		Selenium.click(HKagency.Close_btn);
		Logger.logMessage("House keeping agency Added successfully");
		WebInteract.waitForVisibility(HKagency.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(HKagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(HKagency.CompanyName_txt), CompanyName,"Correct company name is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.State_txt), State,"Correct state name is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.City_txt), City,"Correct city name is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.Address_txt), CompanyAddress,"Correct company address is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.ContactPerson_txt), ContactPerson,"Correct contact person is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.Phoneno_txt), PhoneNo,"Correct phone no is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.Mobile_txt), MobileNo,"Correct Mobile no is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.Emailid_txt), Emailid,"Correct Email id is displayed for added Hk details");
	}

	@Step("To get Validation message")
	public void GetValidationMessage() throws Throwable {
		Selenium.click(HKagency.Add_button);
		WebInteract.waitForVisibility(HKagency.Validation_Companyname);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(HKagency.Validation_Companyname), "Required","Validaion message is displayed for Mandatory field(Company field) on HK agency page");
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(HKagency.Validation_StateField), "Required","Validaion message is displayed for Mandatory field(State field) on HK agency page");
		Selenium.click(HKagency.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(HKagency.Company_name, CompanyName);
		Selenium.sendKeys(HKagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.City, City);
		Selenium.sendKeys(HKagency.Pin_code, Pincode);
		Selenium.sendKeys(HKagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(HKagency.Phone_no, PhoneNo);
		Selenium.sendKeys(HKagency.Mobile_no, MobileNo);
		Selenium.sendKeys(HKagency.Email_id, Emailid);
		Selenium.click(HKagency.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(HKagency.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(HKagency.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(HKagency.State, "value").isEmpty(),"State field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(HKagency.Pin_code, "value").isEmpty(),"Phone no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(HKagency.Mobile_no, "value").isEmpty(),"Mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(HKagency.Email_id, "value").isEmpty(),"Email id field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(HKagency.Contact_person_name, "value").isEmpty(),"Contact person name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(HKagency.Phone_no, "value").isEmpty(),"Phone no field is blank on refreshing");
		Selenium.click(HKagency.Close_btn);
	}

	@Step("To Validate whether duplicate entries allowed or not")
	public void Validateduplicaterecord(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(HKagency.Company_name, CompanyName);
		Selenium.sendKeys(HKagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.City, City);
		Selenium.sendKeys(HKagency.Pin_code, Pincode);
		Selenium.sendKeys(HKagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(HKagency.Phone_no, PhoneNo);
		Selenium.sendKeys(HKagency.Mobile_no, MobileNo);
		Selenium.sendKeys(HKagency.Email_id, Emailid);
		Selenium.click(HKagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed while adding new HK agency");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(HKagency.Error_message);
		String message = WebInteract.getNonstaleElementGetText(HKagency.Error_message);
		Asserts.assertEqual(message, "This Agency details already exists.","Validation message is displayed for duplicate HK details");
		Selenium.click(HKagency.Close_btn);
	}

	@Step("To edit the existing record")
	public void EditHKrecord(String CompanyName, String CompanyAddress, String State, String City) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(HKagency.Edit_btn);
		Selenium.click(HKagency.Edit_btn);
		WebInteract.waitForVisibility(HKagency.Company_name);
		GetEditPageHeader();
		Selenium.clear(HKagency.Company_address);
		Selenium.sendKeys(HKagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(HKagency.City, City);
		Selenium.click(HKagency.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Details?","Alert message is display for Updating HK details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(HKagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(HKagency.Successfull_message);
		Asserts.assertEqual(message, "House keeping agency details updated successfully.","House keeping agency details updated successfully");
		Selenium.click(HKagency.Close_btn);
		Logger.logMessage("House keeping agency details updated successfully");
		WebInteract.waitForVisibility(HKagency.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(HKagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(HKagency.CompanyName_txt), CompanyName,"Correct company name is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.Address_txt), CompanyAddress,"Correct company address is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.State_txt), State,"Correct state name is displayed for added Hk details");
		Asserts.assertEqual(Selenium.getText(HKagency.City_txt), City,"Correct city name is displayed for added Hk details");

	}

	@Step("To Delete the entry of the page")
	public void DeleteHKagencydetails(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(HKagency.Delete_btn);
		Selenium.click(HKagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Alert message is displayed while deleting hk details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "House keeping agency details deleted successfully.","House keeping agency details deleted successfully");
		WebInteract.AcceptAlert();
		Logger.logMessage("House keeping agency details deleted successfully.");
		WebInteract.waitForVisibility(HKagency.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(HKagency.Search_option, searchtext);
		Selenium.click(HKagency.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(HKagency.Search_option, searchtext);
		Selenium.click(HKagency.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(HKagency.Delete_btn);
		Selenium.click(HKagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Älert message is displayed for deleting HK agency details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Record can not be Deleted. It has a dependency.","Validation message is displayed while deleting Used HK agency details");
		WebInteract.AcceptAlert();
	}
}
