package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.CRAAgency;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class CRAAgencyPageUtils {

	protected CRAAgency craagency;

	public CRAAgencyPageUtils() {
		craagency = new CRAAgency();
	}

	@Step("To get the header of CRA Agency page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("CRA Agency");
		WebInteract.waitForVisibility(craagency.Page_Header);
		String PageHeader = Selenium.getText(craagency.Page_Header);
		Asserts.assertEqual(PageHeader, "CRA Agency","CRA Agency page header is Correct");
	}

	@Step("To get the header of Add new CRA Agency page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(craagency.Add_btn);
		WebInteract.waitForVisibility(craagency.Company_address);
		Logger.logMessage("Add CRA Agency page is displayed");
		String PageHeader = Selenium.getText(craagency.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Correct page header is displayed for Add new CRA Agency");
	}

	@Step("To get the header of Edit CRA Agency page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(craagency.Edit_Page_Header);
		String PageHeader = Selenium.getText(craagency.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit CRA Agency page header is correct");
	}

	@Step("To add new CRA agency")
	public void AddCRAAgency(String CompanyName, String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(craagency.Company_name, CompanyName);
		Selenium.sendKeys(craagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(craagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(craagency.City, City);
		Selenium.sendKeys(craagency.Pin_code, Pincode);
		Selenium.sendKeys(craagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(craagency.Phone_no, PhoneNo);
		Selenium.sendKeys(craagency.Mobile_no, MobileNo);
		Selenium.sendKeys(craagency.Email_id, Emailid);
		Selenium.click(craagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message for Add CRA Agency page is displayed");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(craagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(craagency.Successfull_message);
		Asserts.assertEqual(message, "CRA agency Added successfully.","CRA agency Added successfully");
		Selenium.click(craagency.Close_btn);
		Logger.logMessage("CRA agency details added successfully");
		WebInteract.waitForVisibility(craagency.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(craagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(craagency.CompanyName_txt), CompanyName,"Correct company name is displayed for added cra agency details");
		Asserts.assertEqual(Selenium.getText(craagency.State_txt), State,"Correct state name is displayed for added cra agency details");
		Asserts.assertEqual(Selenium.getText(craagency.City_txt), City,"Correct city name is displayed for added cra agency details");
		Asserts.assertEqual(Selenium.getText(craagency.Address_txt), CompanyAddress,"Correct company address is displayed for added cra agency details");
		Asserts.assertEqual(Selenium.getText(craagency.ContactPerson_txt), ContactPerson,"Correct contact person name is displayed for added cra agency details");
		Asserts.assertEqual(Selenium.getText(craagency.Phoneno_txt), PhoneNo,"COrrect Phone no of CRA agency is display");
		Asserts.assertEqual(Selenium.getText(craagency.Mobile_txt), MobileNo,"Correct Mobile no of CRA agency is display");
		Asserts.assertEqual(Selenium.getText(craagency.Emailid_txt), Emailid,"Correct Email id of CRA agency is display");
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid) throws Throwable {
		Selenium.sendKeys(craagency.Company_name, CompanyName);
		Selenium.sendKeys(craagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(craagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(craagency.City, City);
		Selenium.sendKeys(craagency.Pin_code, Pincode);
		Selenium.sendKeys(craagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(craagency.Phone_no, PhoneNo);
		Selenium.sendKeys(craagency.Email_id, Emailid);
		Selenium.click(craagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed for Add new CRA agency details");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(craagency.Validation_message);
		Asserts.assertEqual(Selenium.getText(craagency.Validation_message), "Required","Validation message is displayed for Mandatory fields on CRA Agency");
		Selenium.click(craagency.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(craagency.Company_name, CompanyName);
		Selenium.sendKeys(craagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(craagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(craagency.City, City);
		Selenium.sendKeys(craagency.Pin_code, Pincode);
		Selenium.sendKeys(craagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(craagency.Phone_no, PhoneNo);
		Selenium.sendKeys(craagency.Mobile_no, MobileNo);
		Selenium.sendKeys(craagency.Email_id, Emailid);
		Selenium.click(craagency.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(craagency.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(craagency.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(craagency.State, "value").isEmpty(),"Company state field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(craagency.Pin_code, "value").isEmpty(),"Company pincode field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(craagency.Phone_no, "value").isEmpty(),"Company phone no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(craagency.Mobile_no, "value").isEmpty(),"Company mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(craagency.Email_id, "value").isEmpty(),"Company email id field is blank on refreshing");
		Selenium.click(craagency.Close_btn);
	}

	@Step("To Validate whether duplicate entries allowed or not")
	public void Validateduplicaterecord(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(craagency.Company_name, CompanyName);
		Selenium.sendKeys(craagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(craagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(craagency.City, City);
		Selenium.sendKeys(craagency.Pin_code, Pincode);
		Selenium.sendKeys(craagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(craagency.Phone_no, PhoneNo);
		Selenium.sendKeys(craagency.Mobile_no, MobileNo);
		Selenium.sendKeys(craagency.Email_id, Emailid);
		Selenium.click(craagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(craagency.Error_message);
		String message = WebInteract.getNonstaleElementGetText(craagency.Error_message);
		Asserts.assertEqual(message, "This Agency details already exists.","Validation message is displayed for Duplicate records of CRA agency page");
		Selenium.click(craagency.Close_btn);
	}

	@Step("To Edit the existing record")
	public void EditCRAAgency(String CompanyName, String CompanyAddress, String Emailid, String MobileNo)
			throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(craagency.Edit_btn);
		Selenium.click(craagency.Edit_btn);
		WebInteract.waitForVisibility(craagency.Company_name);
		GetEditPageHeader();
		Selenium.clear(craagency.Company_address);
		Selenium.sendKeys(craagency.Company_address, CompanyAddress);
		Selenium.clear(craagency.Email_id);
		Selenium.sendKeys(craagency.Email_id, Emailid);
		Selenium.clear(craagency.Mobile_no);
		Selenium.sendKeys(craagency.Mobile_no, MobileNo);
		Selenium.click(craagency.Email_id);
		Selenium.click(craagency.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Details?","Alert message is displayed for Add new CRA agency details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(craagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(craagency.Successfull_message);
		Asserts.assertEqual(message, "CRA agency details updated successfully.","CRA agency details updated successfully");
		Selenium.click(craagency.Close_btn);
		Logger.logMessage("CRA agency details updated Successfully");
		WebInteract.waitForVisibility(craagency.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(craagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(craagency.CompanyName_txt), CompanyName,"Correct Company name of CRA agency is display");
		Asserts.assertEqual(Selenium.getText(craagency.Address_txt), CompanyAddress,"correct Company address of CRA agency is display");
		Asserts.assertEqual(Selenium.getText(craagency.Emailid_txt), Emailid,"correct Email id of CRA Agency is display");
		Asserts.assertEqual(Selenium.getText(craagency.Mobile_txt), MobileNo,"correct Mobile no of CRA agency is display");

	}

	@Step("To Delete the entry of the page")
	public void DeleteCRAAgencydetails(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(craagency.Delete_btn);
		Selenium.click(craagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Alert message is displayed for deletion of CRA agency details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "CRA agency details deleted successfully.","CRA agency details deleted successfully");
		WebInteract.AcceptAlert();
		Logger.logMessage("CRA agency details deleted successfully");
		WebInteract.waitForVisibility(craagency.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(craagency.Search_option, searchtext);
		Selenium.click(craagency.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(craagency.Search_option, searchtext);
		Selenium.click(craagency.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Validation message is displayed for No records on CRA Agency page");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(craagency.Delete_btn);
		Selenium.click(craagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Alert message is displayed for Deletion of CRA agency details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Record can not be Deleted. It has a dependency.","Validation message is displayed while deletinh Used records of CRA agency page");
		WebInteract.AcceptAlert();
	}

}
