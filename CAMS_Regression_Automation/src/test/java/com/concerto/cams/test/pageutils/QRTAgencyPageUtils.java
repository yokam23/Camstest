package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.QRTAgency;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class QRTAgencyPageUtils {

	protected QRTAgency qrtagency;

	public QRTAgencyPageUtils() {
		qrtagency = new QRTAgency();
	}

	@Step("To get the header of QRT Agency page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("QRT Agency");
		WebInteract.waitForVisibility(qrtagency.Page_Header);
		String PageHeader = Selenium.getText(qrtagency.Page_Header);
		Asserts.assertEqual(PageHeader, "QRT Agency","Page header of QRT agency page is Correct");
	}

	@Step("To get the header of Add new QRT Agency page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(qrtagency.Add_btn);
		WebInteract.waitForVisibility(qrtagency.Company_name);
		String PageHeader = Selenium.getText(qrtagency.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new QRT agency page header is Correct");
	}

	@Step("To get the header of Edit QRT Agency page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(qrtagency.Edit_Page_Header);
		String PageHeader = Selenium.getText(qrtagency.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit QRT agency page header is Correct");
	}

	@Step("To add new QRT agency")
	public void AddQRTAgency(String CompanyName, String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(qrtagency.Company_name, CompanyName);
		Selenium.sendKeys(qrtagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.City, City);
		Selenium.sendKeys(qrtagency.Pin_code, Pincode);
		Selenium.sendKeys(qrtagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(qrtagency.Phone_no, PhoneNo);
		Selenium.sendKeys(qrtagency.Mobile_no, MobileNo);
		Selenium.sendKeys(qrtagency.Email_id, Emailid);
		Selenium.click(qrtagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed while adding new QRT Agency details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(qrtagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(qrtagency.Successfull_message);
		Asserts.assertEqual(message, "QRT agency Added successfully.","QRT agency Added successfully.");
		Selenium.click(qrtagency.Close_btn);
		WebInteract.waitForVisibility(qrtagency.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(qrtagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(qrtagency.CompanyName_txt), CompanyName,"Company name of added QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.State_txt), State,"State name of added QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.City_txt), City,"City name of added QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.Address_txt), CompanyAddress,"Company address of added QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.ContactPerson_txt), ContactPerson,"Contact persion of added QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.Phoneno_txt), PhoneNo,"Phone no of Added QRT agency page is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.Mobile_txt), MobileNo,"Mobile no of added QRT agency page is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.Emailid_txt), Emailid,"Email id of added QRT agency is Correct");

	}

	@Step("To get the validation message")
	public void GetValidationMessage(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String MobileNo) throws Throwable {
		Selenium.sendKeys(qrtagency.Company_name, CompanyName);
		Selenium.sendKeys(qrtagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.City, City);
		Selenium.sendKeys(qrtagency.Pin_code, Pincode);
		Selenium.sendKeys(qrtagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(qrtagency.Phone_no, PhoneNo);
		Selenium.sendKeys(qrtagency.Mobile_no, MobileNo);
		Selenium.click(qrtagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed while adding new QRT Agency details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(qrtagency.Validation_message);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(qrtagency.Validation_message), "Required","Validation message is displayed for mandatory fields of QRT agency details");
		Selenium.click(qrtagency.Close_btn);

	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(qrtagency.Company_name, CompanyName);
		Selenium.sendKeys(qrtagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.City, City);
		Selenium.sendKeys(qrtagency.Pin_code, Pincode);
		Selenium.sendKeys(qrtagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(qrtagency.Phone_no, PhoneNo);
		Selenium.sendKeys(qrtagency.Mobile_no, MobileNo);
		Selenium.sendKeys(qrtagency.Email_id, Emailid);
		Selenium.click(qrtagency.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.State, "value").isEmpty(),"State name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.Pin_code, "value").isEmpty(),"Pin code field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.Mobile_no, "value").isEmpty(),"Mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.Email_id, "value").isEmpty(),"Email id field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.Contact_person_name, "value").isEmpty(),"Contact person name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(qrtagency.Phone_no, "value").isEmpty(),"Phone no field is blank on refreshing");
		Selenium.click(qrtagency.Close_btn);
	}

	@Step("To Validate whether duplicate entries allowed or not")
	public void Validateduplicaterecord(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(qrtagency.Company_name, CompanyName);
		Selenium.sendKeys(qrtagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(qrtagency.City, City);
		Selenium.sendKeys(qrtagency.Pin_code, Pincode);
		Selenium.sendKeys(qrtagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(qrtagency.Phone_no, PhoneNo);
		Selenium.sendKeys(qrtagency.Mobile_no, MobileNo);
		Selenium.sendKeys(qrtagency.Email_id, Emailid);
		Selenium.click(qrtagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed while adding new QRT Agency details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(qrtagency.Error_message);
		String message = WebInteract.getNonstaleElementGetText(qrtagency.Error_message);
		Asserts.assertEqual(message, "This Agency details already exists.","Validation message is displayed while adding duplicate QRT agency details");
		Selenium.click(qrtagency.Close_btn);
	}

	@Step("To edit the existing record")
	public void EditQRTrecord(String CompanyName, String CompanyAddress, String Phoneno, String Emailid)
			throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(qrtagency.Edit_btn);
		Selenium.click(qrtagency.Edit_btn);
		WebInteract.waitForVisibility(qrtagency.Company_name);
		GetEditPageHeader();
		Selenium.clear(qrtagency.Company_address);
		Selenium.sendKeys(qrtagency.Company_address, CompanyAddress);
		Selenium.clear(qrtagency.Phone_no);
		Selenium.sendKeys(qrtagency.Phone_no, Phoneno);
		Selenium.clear(qrtagency.Email_id);
		Selenium.sendKeys(qrtagency.Email_id, Emailid);
		Selenium.click(qrtagency.Phone_no);
		Selenium.click(qrtagency.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Details?","Alert message is displayed for update QRT agency details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(qrtagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(qrtagency.Successfull_message);
		Asserts.assertEqual(message, "QRT Agency details updated successfully.","QRT Agency details updated successfully.");
		Selenium.click(qrtagency.Close_btn);
		WebInteract.waitForVisibility(qrtagency.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(qrtagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(qrtagency.CompanyName_txt), CompanyName,"Company name of updated QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.Address_txt), CompanyAddress,"Company address of updated QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.Phoneno_txt), Phoneno,"Phone no of updated QRT agency is Correct");
		Asserts.assertEqual(Selenium.getText(qrtagency.Emailid_txt), Emailid,"Email id of updated QRT agency is Correct");

	}

	@Step("To Delete the entry of the page")
	public void DeleteQRTAgency(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(qrtagency.Delete_btn);
		Selenium.click(qrtagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Alert message is displayed while deleting QRT agency details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "QRT Agency details deleted successfully.","QRT Agency details deleted successfully.");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(qrtagency.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(qrtagency.Search_option, searchtext);
		Selenium.click(qrtagency.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(qrtagency.Search_option, searchtext);
		Selenium.click(qrtagency.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is displayed for No records on QRT page");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(qrtagency.Delete_btn);
		Selenium.click(qrtagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Alert message is displayed while deleting QRT agency details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		WebInteract.AcceptAlert();
		Asserts.assertEqual(Deletemessage, "Record can not be Deleted. It has a dependency.","Validation message is displayed for deletion of Used records");
		
	}
}
