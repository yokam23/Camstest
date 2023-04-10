package com.concerto.cams.test.pageutils;

import org.gradle.internal.impldep.org.testng.Assert;

import com.concerto.cams.test.pages.PanelServiceVendor;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class PanelServiceVendorPageUtils {

	protected PanelServiceVendor panelvendor;

	public PanelServiceVendorPageUtils() {
		panelvendor = new PanelServiceVendor();
	}

	@Step("To get the header of Panel service vendor page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Panel Service Vendor");
		WebInteract.waitForVisibility(panelvendor.Page_Header);
		String PageHeader = Selenium.getText(panelvendor.Page_Header);
		Asserts.assertEqual(PageHeader, "Panel Service Vendor","Page header of panel service vendor is Correct");
	}

	@Step("To get the header of Add new Panel service vendor page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(panelvendor.Add_btn);
		WebInteract.waitForVisibility(panelvendor.City);
		String PageHeader = Selenium.getText(panelvendor.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Page header of Add new panel service vendor is correct");
	}

	@Step("To get the header of Edit Panel service vendor page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(panelvendor.Edit_Page_Header);
		String PageHeader = Selenium.getText(panelvendor.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit panel service vendor page header is correct");
	}

	@Step("To Add new Panel service vendor")
	public void AddnewPanelVendor(String CompanyName, String CompanyAddress, String State, String City, String Pincode,
			String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(panelvendor.Company_name, CompanyName);
		Selenium.sendKeys(panelvendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.City, City);
		Selenium.sendKeys(panelvendor.Pin_code, Pincode);
		Selenium.sendKeys(panelvendor.Contact_person_name, ContactPerson);
		Selenium.sendKeys(panelvendor.Phone_no, PhoneNo);
		Selenium.sendKeys(panelvendor.Mobile_no, MobileNo);
		Selenium.sendKeys(panelvendor.Email_id, Emailid);
		Selenium.click(panelvendor.Mobile_no);
		Selenium.click(panelvendor.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Panel Service Vendor?","Alert message is displayed while adding new panel service vendor");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(panelvendor.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(panelvendor.Successfull_message);
		Asserts.assertEqual(message, "Panel service vendor added successfully.","Panel service vendor added successfully.");
		Selenium.click(panelvendor.Close_btn);
		WebInteract.waitForVisibility(panelvendor.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(panelvendor.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(panelvendor.CompanyName_txt), CompanyName,"Company name of added panel service vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.State_txt), State,"State name of added panel service vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.City_txt), City,"City name of added panel service vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.Address_txt), CompanyAddress,"Company address of added panel service vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.ContactPerson_txt), ContactPerson,"Contact person name of added panel service vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.Phoneno_txt), PhoneNo,"Phone no of added panel service vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.Mobile_txt), MobileNo,"Mobile no of added panel service vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.Emailid_txt), Emailid,"Email id of added panel service vendor is Correct");

	}

	@Step("To get the validation message")
	public void GetValidationMessage(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson) throws Throwable {
		Selenium.sendKeys(panelvendor.Company_name, CompanyName);
		Selenium.sendKeys(panelvendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.State, State);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.City, City);
		Selenium.sendKeys(panelvendor.Pin_code, Pincode);
		Selenium.sendKeys(panelvendor.Contact_person_name, ContactPerson);
		Selenium.click(panelvendor.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Panel Service Vendor?","Alert message is displayed while adding new panel service vendor");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(panelvendor.Validation_EmailField);
		Asserts.assertEqual(Selenium.getText(panelvendor.Validation_PhoneField), "Required","Validation message is displayed for mandatory fields of panel service vendor page");
		Asserts.assertEqual(Selenium.getText(panelvendor.Validation_MobileField), "Required","Validation message is displayed for mandatory fields of panel service vendor page");
		Asserts.assertEqual(Selenium.getText(panelvendor.Validation_EmailField), "Required","Validation message is displayed for mandatory fields of panel service vendor page");
		Selenium.click(panelvendor.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(panelvendor.Company_name, CompanyName);
		Selenium.sendKeys(panelvendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.City, City);
		Selenium.sendKeys(panelvendor.Pin_code, Pincode);
		Selenium.sendKeys(panelvendor.Contact_person_name, ContactPerson);
		Selenium.sendKeys(panelvendor.Phone_no, PhoneNo);
		Selenium.sendKeys(panelvendor.Mobile_no, MobileNo);
		Selenium.sendKeys(panelvendor.Email_id, Emailid);
		Selenium.click(panelvendor.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.Company_name, "value").isEmpty(),"Company name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.Company_address, "value").isEmpty(),"Company address field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.State, "value").isEmpty(),"State field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.Pin_code, "value").isEmpty(),"Pin code field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.Contact_person_name, "value").isEmpty(),"Person name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.Phone_no, "value").isEmpty(),"Phone no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.Mobile_no, "value").isEmpty(),"Mobile no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(panelvendor.Email_id, "value").isEmpty(),"Email id field is blank on refreshing");
		Selenium.click(panelvendor.Close_btn);
	}

	@Step("To Edit Panel service vendor")
	public void EditPanelvendor(String State,String City, String PersonName, String Mobileno, String CompanyName) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(panelvendor.Edit_btn);
		Selenium.click(panelvendor.Edit_btn);
		WebInteract.waitForVisibility(panelvendor.Company_name);
		GetEditPageHeader();
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.City, City);
		Selenium.clear(panelvendor.Contact_person_name);
		Selenium.sendKeys(panelvendor.Contact_person_name, PersonName);
		Selenium.clear(panelvendor.Mobile_no);
		Selenium.sendKeys(panelvendor.Mobile_no, Mobileno);
		Selenium.click(panelvendor.Email_id);
		Selenium.click(panelvendor.Mobile_no);
		Selenium.click(panelvendor.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Panel Service Vendor Details?","Alert message is displayed while updating panel service vendor details");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(panelvendor.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(panelvendor.Successfull_message);
		Asserts.assertEqual(message, "Panel service vendor updated successfully.","Panel service vendor updated successfully.");
		Selenium.click(panelvendor.Close_btn);
		WebInteract.waitForVisibility(panelvendor.Search_option);
		searchfuncforValidData(CompanyName);
		WebInteract.waitForVisibility(panelvendor.CompanyName_txt);
		Asserts.assertEqual(Selenium.getText(panelvendor.State_txt), State,"State name for added panel vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.ContactPerson_txt), PersonName,"Person name for added panel vendor is Correct");
		Asserts.assertEqual(Selenium.getText(panelvendor.Mobile_txt), Mobileno,"Mobile no for added panel service vendor is Correct");

	}

	@Step("To validate whether duplicate entries are allowed or not")
	public void ValidateDuplicateEntries(String CompanyName, String CompanyAddress, String State, String City,
			String Pincode, String ContactPerson, String PhoneNo, String Emailid, String MobileNo) throws Throwable {
		Selenium.sendKeys(panelvendor.Company_name, CompanyName);
		Selenium.sendKeys(panelvendor.Company_address, CompanyAddress);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.State, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(panelvendor.City, City);
		Selenium.sendKeys(panelvendor.Pin_code, Pincode);
		Selenium.sendKeys(panelvendor.Contact_person_name, ContactPerson);
		Selenium.sendKeys(panelvendor.Phone_no, PhoneNo);
		Selenium.sendKeys(panelvendor.Mobile_no, MobileNo);
		Selenium.sendKeys(panelvendor.Email_id, Emailid);
		Selenium.click(panelvendor.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Panel Service Vendor?","Alert message is displayed while adding new panel service vendor records");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(panelvendor.Error_message);
		String message = WebInteract.getNonstaleElementGetText(panelvendor.Error_message);
		Asserts.assertEqual(message, "This Panel service vendor already exists.","Validation message is displayed while adding duplicate record");
		Selenium.click(panelvendor.Close_btn);
	}

	@Step("To Delete the entry of the page")
	public void DeletePanelVendor(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(panelvendor.Delete_btn);
		Selenium.click(panelvendor.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Panel Service Vendors Details?","Alert message is displayed while deleting panel service vendor details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Panel service vendor deleted successfully.","Panel service vendor deleted successfully");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(panelvendor.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(panelvendor.Delete_btn);
		Selenium.click(panelvendor.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Panel Service Vendors Details?","Alert message is displayed while deleting panel service vendor details");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Record can not be Deleted. It has a dependency.","Alert message while deleting used panel service vendor record");
		WebInteract.AcceptAlert();
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(panelvendor.Search_option, searchtext);
		Selenium.click(panelvendor.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(panelvendor.Search_option, searchtext);
		Selenium.click(panelvendor.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is display for No records on panel service vendor page");
		WebInteract.AcceptAlert();
	}
}
