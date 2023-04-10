package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.InstallationPartner;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class InstallationPartnerPageUtils {

	protected InstallationPartner partner;

	public InstallationPartnerPageUtils() {

		partner = new InstallationPartner();
	}

	@Step("To get the header of Netowrk provider page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Installation Partner");
		WebInteract.waitForVisibility(partner.Page_Header);
		String PageHeader = Selenium.getText(partner.Page_Header);
		Asserts.assertEqual(PageHeader, "Installation Partner","Page header of Installation partner page is Correct");
	}

	@Step("To get the header of Add new Netowrk provider page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(partner.Add_btn);
		WebInteract.waitForVisibility(partner.Company_name);
		Logger.logMessage("Add Network provider page is displayed");
		String PageHeader = Selenium.getText(partner.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Page header of Add new installation partner page is Correct");
	}

	@Step("To get the header of Edit Netowrk provider page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(partner.Edit_Page_Header);
		String PageHeader = Selenium.getText(partner.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit page header of Installation partner is Correct");
	}

	@Step("To add new CRA agency")
	public void AddInstallationpartner(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(partner.Company_name, CompanyName);
		Selenium.sendKeys(partner.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(partner.State, State);
		WebInteract.selectByTextFomDropdownfromStale(partner.City, City);
		Selenium.sendKeys(partner.Pin_code, Pincode);
		Selenium.sendKeys(partner.Contact_person_name, ContactPerson);
		Selenium.sendKeys(partner.Phone_no, PhoneNo);
		Selenium.sendKeys(partner.Mobile_no, MobileNo);
		Selenium.sendKeys(partner.Email_id, Emailid);
		Selenium.click(partner.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed while adding new Installation partner");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(partner.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(partner.Successfull_message);
		Asserts.assertEqual(message, "Installation partner Added successfully.","Installation partner Added successfully");
		Selenium.click(partner.Close_btn);
		Logger.logMessage("Installation partner Added successfully.");
		WebInteract.waitForVisibility(partner.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(partner.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(partner.CompanyName_txt), CompanyName,"Correct company name is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.State_txt), State,"Correct state name is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.City_txt), City,"Correct city name is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.Address_txt), CompanyAddress,"Correct company address is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.ContactPerson_txt), ContactPerson,"Correct contact person is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.Phoneno_txt), PhoneNo,"Correct phone no is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.Mobile_txt), MobileNo,"Correct mobile name is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.Emailid_txt), Emailid,"Correct email id is displayed for added Installation partner details");
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String State, String City, String Pincode, String ContactPerson, String PhoneNo,
			String Emailid, String MobileNo) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(partner.State, State);
		WebInteract.selectByTextFomDropdownfromStale(partner.City, City);
		Selenium.sendKeys(partner.Pin_code, Pincode);
		Selenium.sendKeys(partner.Contact_person_name, ContactPerson);
		Selenium.sendKeys(partner.Phone_no, PhoneNo);
		Selenium.sendKeys(partner.Mobile_no, MobileNo);
		Selenium.sendKeys(partner.Email_id, Emailid);
		Selenium.click(partner.Add_button);
		// WebInteract.waitForVisibility(partner.Validation_companyaddress);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(partner.Validation_companyaddress), "Required","Validation message is displayed for mandatory field");
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(partner.Validation_companyName), "Required","Validation message is displayed for mandatory field");
		Selenium.click(partner.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(partner.Company_name, CompanyName);
		Selenium.sendKeys(partner.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(partner.State, State);
		WebInteract.selectByTextFomDropdownfromStale(partner.City, City);
		Selenium.sendKeys(partner.Pin_code, Pincode);
		Selenium.sendKeys(partner.Contact_person_name, ContactPerson);
		Selenium.sendKeys(partner.Phone_no, PhoneNo);
		Selenium.sendKeys(partner.Mobile_no, MobileNo);
		Selenium.sendKeys(partner.Email_id, Emailid);
		Selenium.click(partner.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(partner.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(partner.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(partner.State, "value").isEmpty(),"Company state field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(partner.Pin_code, "value").isEmpty(),"Company Pincode field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(partner.Mobile_no, "value").isEmpty(),"Company Mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(partner.Email_id, "value").isEmpty(),"Company Emailid field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(partner.Contact_person_name, "value").isEmpty(),"Company Person name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(partner.Phone_no, "value").isEmpty(),"Company Phone no field is blank on refreshing");
		Selenium.click(partner.Close_btn);
	}

	@Step("To Validate whether duplicate entries allowed or not")
	public void Validateduplicaterecord(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(partner.Company_name, CompanyName);
		Selenium.sendKeys(partner.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(partner.State, State);
		WebInteract.selectByTextFomDropdownfromStale(partner.City, City);
		Selenium.sendKeys(partner.Pin_code, Pincode);
		Selenium.sendKeys(partner.Contact_person_name, ContactPerson);
		Selenium.sendKeys(partner.Phone_no, PhoneNo);
		Selenium.sendKeys(partner.Mobile_no, MobileNo);
		Selenium.sendKeys(partner.Email_id, Emailid);
		Selenium.click(partner.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Details ?","Alert message is displayed while adding new Installation partner details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(partner.Error_message);
		String message = WebInteract.getNonstaleElementGetText(partner.Error_message);
		Asserts.assertEqual(message, "This Agency details already exists.","Validation message is displayed for duplicate installation partner records");
		Selenium.click(partner.Close_btn);
	}

	@Step("To Edit the existing record")
	public void EditInstallationpartner(String CompanyName, String CompanyAddress, String Emailid, String MobileNo)
			throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(partner.Edit_btn);
		Selenium.click(partner.Edit_btn);
		WebInteract.waitForVisibility(partner.Company_name);
		GetEditPageHeader();
		Selenium.clear(partner.Company_address);
		Selenium.sendKeys(partner.Company_address, CompanyAddress);
		Selenium.clear(partner.Email_id);
		Selenium.sendKeys(partner.Email_id, Emailid);
		Selenium.clear(partner.Mobile_no);
		Selenium.sendKeys(partner.Mobile_no, MobileNo);
		Selenium.click(partner.Email_id);
		Selenium.click(partner.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Details?","Alert message is displayed while updating Installation partner details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(partner.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(partner.Successfull_message);
		Asserts.assertEqual(message, "Installation partner details updated successfully.","Installation partner details updated successfully.");
		Selenium.click(partner.Close_btn);
		Logger.logMessage("Installation partner details updated successfully.");
		WebInteract.waitForVisibility(partner.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(partner.Address_txt);
		Asserts.assertEqual(Selenium.getText(partner.CompanyName_txt), CompanyName,"Correct company name is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.Address_txt), CompanyAddress,"Correct company address is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.Emailid_txt), Emailid,"Correct Email id is displayed for added Installation partner details");
		Asserts.assertEqual(Selenium.getText(partner.Mobile_txt), MobileNo,"Correct Mobile no is displayed for added Installation partner details");
	}

	@Step("To Delete the entry of the page")
	public void DeleteInstallationVendor(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(partner.Delete_btn);
		Selenium.click(partner.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Alert message is displayed while deleting Installation partner details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Installation partner details deleted successfully.","Installation partner details deleted successfully");
		WebInteract.AcceptAlert();
        Logger.logMessage("Installation partner details deleted successfully.");
		WebInteract.waitForVisibility(partner.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(partner.Search_option, searchtext);
		Selenium.click(partner.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(partner.Search_option, searchtext);
		Selenium.click(partner.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is displayed for No records on installation partner page");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(partner.Delete_btn);
		Selenium.click(partner.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Details?","Alert message is displayed while deleting installation partner record");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertTrue(Deletemessage.contains("Record can not be Deleted. It has a dependency."),"Correct message is displayed while deleting used records");
		WebInteract.AcceptAlert();
	}

}