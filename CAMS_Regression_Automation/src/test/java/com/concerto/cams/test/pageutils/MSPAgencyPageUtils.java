package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.MSPAgency;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class MSPAgencyPageUtils {

	protected MSPAgency mspagency;

	public MSPAgencyPageUtils() {
		mspagency = new MSPAgency();
	}

	@Step("To get the header of MSP Agency page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("MSP Vendors");
		WebInteract.waitForVisibility(mspagency.Page_Header);
		String PageHeader = Selenium.getText(mspagency.Page_Header);
		Asserts.assertEqual(PageHeader, "MSP Vendors","MSP agency page header is correct");
	}

	@Step("To get the header of Add new MSP Agency page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(mspagency.Add_btn);
		WebInteract.waitForVisibility(mspagency.Company_name);
		String PageHeader = Selenium.getText(mspagency.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new MSP agency page header is Correct");
	}

	@Step("To get the header of Edit MSP Agency page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(mspagency.Edit_Page_Header);
		String PageHeader = Selenium.getText(mspagency.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit MSP agency page header is Correct");
	}

	@Step("To add new MSP agency")
	public void Addmspagency(String CompanyName, String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(mspagency.Company_name, CompanyName);
		Selenium.sendKeys(mspagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.City, City);
		Selenium.sendKeys(mspagency.Pin_code, Pincode);
		Selenium.sendKeys(mspagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(mspagency.Phone_no, PhoneNo);
		Selenium.sendKeys(mspagency.Mobile_no, MobileNo);
		Selenium.sendKeys(mspagency.Email_id, Emailid);
		Selenium.click(mspagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this MSP Vendor Details?","Alert message is displayed for add new MSP vendor details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(mspagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(mspagency.Successfull_message);
		Asserts.assertEqual(message, "MSP Vendor Details Added Successfully.","MSP Vendor Details Added Successfully.");
		Selenium.click(mspagency.Close_btn);
		WebInteract.waitForVisibility(mspagency.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(mspagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(mspagency.CompanyName_txt), CompanyName,"Company name of MSP vendor is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.State_txt), State,"State name of MSP vendor is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.City_txt), City,"City name of MSP vendor is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.Address_txt), CompanyAddress,"Company address of MSP vendor is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.ContactPerson_txt), ContactPerson,"Contact persion name of MSP vendor is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.Phoneno_txt), PhoneNo,"Phone no of MSP vendor is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.Mobile_txt), MobileNo,"Mobile no of MSP vendor is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.Emailid_txt), Emailid,"Email id of MSP vendor is Correct");

	}

	@Step("To get the validation message")
	public void GetValidationMessage(String CompanyName, String CompanyAddress, String State, String City,
			String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(mspagency.Company_name, CompanyName);
		Selenium.sendKeys(mspagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.City, City);
		Selenium.sendKeys(mspagency.Phone_no, PhoneNo);
		Selenium.sendKeys(mspagency.Mobile_no, MobileNo);
		Selenium.sendKeys(mspagency.Email_id, Emailid);
		Selenium.click(mspagency.Add_button);
		//WebInteract.waitForVisibility(mspagency.Validation_contactPerson);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(mspagency.Validation_contactPerson), "Required","Validation message is displayed for mandatory field of MSP Agency page");
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(mspagency.Validation_Pincode), "Required","Validation message is displayed for mandatory field of MSP Agency page");
		Selenium.click(mspagency.Close_btn);

	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(mspagency.Company_name, CompanyName);
		Selenium.sendKeys(mspagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.City, City);
		Selenium.sendKeys(mspagency.Pin_code, Pincode);
		Selenium.sendKeys(mspagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(mspagency.Phone_no, PhoneNo);
		Selenium.sendKeys(mspagency.Mobile_no, MobileNo);
		Selenium.sendKeys(mspagency.Email_id, Emailid);
		Selenium.click(mspagency.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(mspagency.Company_name, "value").isEmpty(),"Company name field is blank");
		Asserts.assertTrue(Selenium.getAttribute(mspagency.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(mspagency.State, "value").isEmpty(),"State field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(mspagency.Pin_code, "value").isEmpty(),"Pin code field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(mspagency.Mobile_no, "value").isEmpty(),"Mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(mspagency.Email_id, "value").isEmpty(),"Email id field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(mspagency.Contact_person_name, "value").isEmpty(),"Contact person name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(mspagency.Phone_no, "value").isEmpty(),"Phone no field is blank on refreshing");
		Selenium.click(mspagency.Close_btn);
	}

	@Step("To Validate whether duplicate entries allowed or not")
	public void Validateduplicaterecord(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(mspagency.Company_name, CompanyName);
		Selenium.sendKeys(mspagency.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(mspagency.City, City);
		Selenium.sendKeys(mspagency.Pin_code, Pincode);
		Selenium.sendKeys(mspagency.Contact_person_name, ContactPerson);
		Selenium.sendKeys(mspagency.Phone_no, PhoneNo);
		Selenium.sendKeys(mspagency.Mobile_no, MobileNo);
		Selenium.sendKeys(mspagency.Email_id, Emailid);
		Selenium.click(mspagency.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this MSP Vendor Details?","Alert message is displayed for add new MSP vendor ");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(mspagency.Error_message);
		String message = WebInteract.getNonstaleElementGetText(mspagency.Error_message);
		Asserts.assertEqual(message, "This MSP Vendor Already Exists.","Validation message is displayed for duplicate records of MSPAgency record");
		Selenium.click(mspagency.Close_btn);
	}

	@Step("To edit the existing record")
	public void EditMSPdetailsrecord(String Companyname, String CompanyAddress, String Phoneno, String Emailid) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Companyname);
		WebInteract.waitForVisibility(mspagency.Edit_btn);
		Selenium.click(mspagency.Edit_btn);
		WebInteract.waitForVisibility(mspagency.Company_name);
		GetEditPageHeader();
		Selenium.clear(mspagency.Company_address);
		Selenium.sendKeys(mspagency.Company_address, CompanyAddress);
		Selenium.clear(mspagency.Phone_no);
		Selenium.sendKeys(mspagency.Phone_no, Phoneno);
		Selenium.clear(mspagency.Email_id);
		Selenium.sendKeys(mspagency.Email_id, Emailid);
		Selenium.click(mspagency.Phone_no);
		Selenium.click(mspagency.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Vendor Details?","Alert message is displayed for update vendor details");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(mspagency.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(mspagency.Successfull_message);
		Asserts.assertEqual(message, "MSP Vendor Details Updated Successfully.","MSP Vendor Details Updated Successfully");
		Selenium.click(mspagency.Close_btn);
		WebInteract.waitForVisibility(mspagency.Search_option);
		searchfuncforValidData(Companyname);
		WebInteract.waitForVisibility(mspagency.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(mspagency.CompanyName_txt), Companyname,"Company name of MSP agency details is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.Address_txt), CompanyAddress,"Company Address of MSP agency details is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.Phoneno_txt), Phoneno,"Phone no of MSP agency details is Correct");
		Asserts.assertEqual(Selenium.getText(mspagency.Emailid_txt), Emailid,"Email id of MSP agency details is Correct");
	}

	@Step("To Delete the entry of the page")
	public void DeleteMSPdetails(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(mspagency.Delete_btn);
		Selenium.click(mspagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this MSP Vendor Details?","Alert message is displayed for Deletion of MSP vendor details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "MSP Vendor Details Deleted Successfully.","MSP Vendor Details Deleted Successfully");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(mspagency.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(mspagency.Search_option, searchtext);
		Selenium.click(mspagency.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(mspagency.Search_option, searchtext);
		Selenium.click(mspagency.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is displayed for No records on MSPAgency page");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(mspagency.Delete_btn);
		Selenium.click(mspagency.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this MSP Vendor Details?","Alert message is displayed while deleting MSP Agency record");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage,
				"This MSP Vendor is Used in Panel , hence unable to Delete this MSP vendor Details.","Validation message is displayed while deleting used MSP agency record");
		WebInteract.AcceptAlert();
	}

}
