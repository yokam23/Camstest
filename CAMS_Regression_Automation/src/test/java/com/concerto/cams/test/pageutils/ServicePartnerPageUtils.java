package com.concerto.cams.test.pageutils;

import org.gradle.internal.impldep.org.testng.Assert;

import com.concerto.cams.test.pages.Servicepartner;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ServicePartnerPageUtils {

	protected Servicepartner servicepartner;

	public ServicePartnerPageUtils() {

		servicepartner = new Servicepartner();
	}

	@Step("To get the page Header of Service partner page")
	public void GetpageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		if(WebInteract.isAlertPresent()) {
			Asserts.assertTrue(true, "Alert is present on page opening");
			WebInteract.AcceptAlert();
		}
		WebInteract.validatePageTitle("Service Partner");
		WebInteract.waitForVisibility(servicepartner.Page_Header);
		String PageHeader = Selenium.getText(servicepartner.Page_Header);
		Asserts.assertEqual(PageHeader, "Service Partner","Correct Header page is displayed");
	}

	@Step("To get the header of Add service partner page")
	public void GetAddpageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(servicepartner.Add_btn);
		WebInteract.waitForVisibility(servicepartner.Company_address);
		String PageHeader = Selenium.getText(servicepartner.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Correct Add page header is displayed");
	}

	@Step("To get the header of Edit service partner page")
	public void GetEditpageHeader() throws Throwable {
		WebInteract.waitForVisibility(servicepartner.Edit_Page_Header);
		String PageHeader = Selenium.getText(servicepartner.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Correct Edit page is displayed");
	}

	@Step("To add new CRA agency")
	public void Addservicepartner(String CompanyName, String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(servicepartner.Company_name, CompanyName);
		Selenium.sendKeys(servicepartner.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.City, City);
		Selenium.sendKeys(servicepartner.Pin_code, Pincode);
		Selenium.sendKeys(servicepartner.Contact_person_name, ContactPerson);
		Selenium.sendKeys(servicepartner.Phone_no, PhoneNo);
		Selenium.sendKeys(servicepartner.Mobile_no, MobileNo);
		Selenium.sendKeys(servicepartner.Email_id, Emailid);
		Selenium.click(servicepartner.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(servicepartner.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(servicepartner.Successfull_message);
		Asserts.assertEqual(message, "Service partner Added successfully.","Correct message is displayed on addition of service partner");
		Selenium.click(servicepartner.Close_btn);
		WebInteract.waitForVisibility(servicepartner.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(servicepartner.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(servicepartner.CompanyName_txt), CompanyName,"Correct company name is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.State_txt), State,"Correct state name is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.City_txt), City,"Correct city name is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.Address_txt), CompanyAddress,"Correct company address is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.ContactPerson_txt), ContactPerson,"Correct contact person name is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.Phoneno_txt), PhoneNo,"Correct phone no is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.Mobile_txt), MobileNo,"Correct mobile no is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.Emailid_txt), Emailid,"Correct email id is displayed");
	}

	@Step("To get the Validation message")
	public void GetValidationMessage(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String PhoneNo, String Emailid) throws Throwable {
		Selenium.sendKeys(servicepartner.Company_name, CompanyName);
		Selenium.sendKeys(servicepartner.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.City, City);
		Selenium.sendKeys(servicepartner.Pin_code, Pincode);
		Selenium.sendKeys(servicepartner.Phone_no, PhoneNo);
		Selenium.sendKeys(servicepartner.Email_id, Emailid);
		Selenium.click(servicepartner.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(servicepartner.Validation_Contactperson);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(servicepartner.Validation_Contactperson), "Required","Correct validation message is displayed");
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(servicepartner.Validation_MobileNo), "Required","Correct validation message is displayed");
		Selenium.click(servicepartner.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(servicepartner.Company_name, CompanyName);
		Selenium.sendKeys(servicepartner.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.City, City);
		Selenium.sendKeys(servicepartner.Pin_code, Pincode);
		Selenium.sendKeys(servicepartner.Contact_person_name, ContactPerson);
		Selenium.sendKeys(servicepartner.Phone_no, PhoneNo);
		Selenium.sendKeys(servicepartner.Mobile_no, MobileNo);
		Selenium.sendKeys(servicepartner.Email_id, Emailid);
		Selenium.click(servicepartner.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.State, "value").isEmpty(),"State field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.Pin_code, "value").isEmpty(),"Pin code field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.Mobile_no, "value").isEmpty(),"Mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.Email_id, "value").isEmpty(),"Email id field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.Contact_person_name, "value").isEmpty(),"Contact person name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(servicepartner.Phone_no, "value").isEmpty(),"Phone no field is blank on refreshing");
		Selenium.click(servicepartner.Close_btn);
	}

	@Step("To Validate whether duplicate entries allowed or not")
	public void Validateduplicaterecord(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(servicepartner.Company_name, CompanyName);
		Selenium.sendKeys(servicepartner.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(servicepartner.City, City);
		Selenium.sendKeys(servicepartner.Pin_code, Pincode);
		Selenium.sendKeys(servicepartner.Contact_person_name, ContactPerson);
		Selenium.sendKeys(servicepartner.Phone_no, PhoneNo);
		Selenium.sendKeys(servicepartner.Mobile_no, MobileNo);
		Selenium.sendKeys(servicepartner.Email_id, Emailid);
		Selenium.click(servicepartner.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(servicepartner.Error_message);
		String message = WebInteract.getNonstaleElementGetText(servicepartner.Error_message);
		Asserts.assertEqual(message, "This Agency details already exists.","Correct alert message is displayed for duplicate records");
		Selenium.click(servicepartner.Close_btn);
	}

	@Step("To Edit the existing record")
	public void Editservicepartner(String CompanyName, String CompanyAddress, String Emailid, String MobileNo) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(servicepartner.Edit_btn);
		Selenium.click(servicepartner.Edit_btn);
		WebInteract.waitForVisibility(servicepartner.Company_name);
		GetEditpageHeader();
		Selenium.clear(servicepartner.Company_address);
		Selenium.sendKeys(servicepartner.Company_address, CompanyAddress);
		Selenium.clear(servicepartner.Email_id);
		Selenium.sendKeys(servicepartner.Email_id, Emailid);
		Selenium.clear(servicepartner.Mobile_no);
		Selenium.sendKeys(servicepartner.Mobile_no, MobileNo);
		Selenium.click(servicepartner.Email_id);
		Selenium.click(servicepartner.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Details?","Correct alert message is displayed for updating service partner records");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(servicepartner.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(servicepartner.Successfull_message);
		Asserts.assertEqual(message, "Service partner details updated successfully.","Correct updation message is displayed");
		Selenium.click(servicepartner.Close_btn);
		WebInteract.waitForVisibility(servicepartner.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(servicepartner.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(servicepartner.CompanyName_txt), CompanyName,"Correct company name is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.Address_txt), CompanyAddress,"Correct company address is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.Mobile_txt), MobileNo,"Correct Mobile no is displayed");
		Asserts.assertEqual(Selenium.getText(servicepartner.Emailid_txt), Emailid,"Correct Emailid is displayed");
	}

	@Step("To Delete the entry of the page")
	public void DeleteServicepartnerdetails(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(servicepartner.Delete_btn);
		Selenium.click(servicepartner.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Correct alert message is displayed on deletion");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Service partner details deleted successfully.","Correct message is displayed on deletion record");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(servicepartner.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(servicepartner.Search_option, searchtext);
		Selenium.click(servicepartner.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(servicepartner.Search_option, searchtext);
		Selenium.click(servicepartner.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Correct message is displayed for no records");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(servicepartner.Delete_btn);
		Selenium.click(servicepartner.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Correct alert message is displayed for deletion of records");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertTrue(Deletemessage.contains("Record can not be Deleted. It has a dependency."),"Correct message is displayed while deleting used record");
		WebInteract.AcceptAlert();
	}

}