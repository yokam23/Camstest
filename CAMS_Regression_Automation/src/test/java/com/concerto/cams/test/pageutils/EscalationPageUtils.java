package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.Escalation;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class EscalationPageUtils {

	protected Escalation escalation;

	public EscalationPageUtils() {

		escalation = new Escalation();
	}

	@Step("To get the header of page")
	public void GetHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Escalation Master");
		WebInteract.waitForVisibility(escalation.Page_Header);
		String Page_Header = Selenium.getText(escalation.Page_Header);
		Asserts.assertEqual(Page_Header, "Escalation Master","Page header of escalation is correct");
	}

	@Step("To get the header of escalation page")
	public void GetEscalationPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(escalation.Add_btn);
		WebInteract.waitForVisibility(escalation.Escalation_Page_Header);
		Logger.logMessage("Add Escalation page is displayed");
		String Page_Header = Selenium.getText(escalation.Escalation_Page_Header);
		Asserts.assertEqual(Page_Header, "Add New Escalation","Page header of Add new Escalation page is correct");
	}

	@Step("To Add new Escalation details")
	public void AddnewEscalation(String Templatename, String Name, String Comment, String Telephoneno, String Mobileno,
			String Emailid, String Priority, String interval, String Repeatinterval) throws Throwable {
		Selenium.sendKeys(escalation.Template_name_search, Templatename);
		Selenium.sendKeys(escalation.Name, Name);
		Selenium.sendKeys(escalation.Comment, Comment);
		Selenium.sendKeys(escalation.Telephone_no, Telephoneno);
		Selenium.click(escalation.sms);
		Selenium.sendKeys(escalation.Mobile_no, Mobileno);
		Selenium.click(escalation.Email_checkbox);
		Selenium.sendKeys(escalation.Email, Emailid);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Priority, Priority);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Interval, interval);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Repeat_Interval, Repeatinterval);
		WebInteract.scrollDown(0, 600);
		Selenium.click(escalation.Add_esc);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Escalation Template added successfully.","Escalation Template added successfully");
		WebInteract.AcceptAlert(); 
		Logger.logMessage("Escalation Template added successfully");
	}
	
	@Step("To validate duplicate entries of escalation details")
	public void ValidateDuplicateEscalation(String Templatename, String Name, String Comment, String Telephoneno, String Mobileno,
			String Emailid, String Priority, String interval, String Repeatinterval) throws Throwable {
		Selenium.sendKeys(escalation.Template_name_search, Templatename);
		Selenium.sendKeys(escalation.Name, Name);
		Selenium.sendKeys(escalation.Comment, Comment);
		Selenium.sendKeys(escalation.Telephone_no, Telephoneno);
		Selenium.click(escalation.sms);
		Selenium.sendKeys(escalation.Mobile_no, Mobileno);
		Selenium.click(escalation.Email_checkbox);
		Selenium.sendKeys(escalation.Email, Emailid);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Priority, Priority);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Interval, interval);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Repeat_Interval, Repeatinterval);
		WebInteract.scrollDown(0, 600);
		Selenium.click(escalation.Add_esc);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, " This Escalation Template already exists.","Validation message is displayed for duplicate records on duplicate records");
		WebInteract.AcceptAlert(); 
	}
	
	@Step("To refresh the added details ")
	public void RefreshAddedDetails(String Templatename, String Name, String Comment, String Telephoneno,
		String Mobileno, String Emailid, String Priority, String interval, String Repeatinterval) throws Throwable {
		Selenium.sendKeys(escalation.Template_name_search, Templatename);
		Selenium.sendKeys(escalation.Name, Name);
		Selenium.sendKeys(escalation.Comment, Comment);
		Selenium.sendKeys(escalation.Telephone_no, Telephoneno);
		Selenium.click(escalation.sms);
		Selenium.sendKeys(escalation.Mobile_no, Mobileno);
		Selenium.click(escalation.Email_checkbox);
		Selenium.sendKeys(escalation.Email, Emailid);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Priority, Priority);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Interval, interval);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Repeat_Interval, Repeatinterval);
		Selenium.click(escalation.Refresh_btn);
		Asserts.assertTrue(Selenium.getAttribute(escalation.Template_name_search, "value").isEmpty(),"Template name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(escalation.Name, "value").isEmpty(),"Esaclation name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(escalation.Comment, "value").isEmpty(),"Escalation comment field is blank on refreshing");
		Asserts.assertTrue(!(escalation.sms.isSelected()),"Sms checkbox is uncheck on refreshing");
		Asserts.assertTrue(!(escalation.Email_checkbox.isSelected()),"Email checkbox is uncheck on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(escalation.Telephone_no, "value").isEmpty(),"Telephone no field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(escalation.Email, "value").isEmpty(),"Email field is blank on refreshing");
	}

	@Step("To Edit escalation details")
	public void EditEscalationdetails(String Templatename, String Name, String Emailid, String priority,
			String Repeatinterval) throws Throwable {
		WebInteract.waitForVisibility(escalation.Page_Header);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Template_name, Templatename);
		Selenium.clear(escalation.Edit_name);
		Selenium.sendKeys(escalation.Edit_name, Name);
		Selenium.clear(escalation.Edit_email);
		Selenium.sendKeys(escalation.Edit_email, Emailid);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Edit_priority, priority);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Edit_repeat_interval, Repeatinterval);
		Selenium.click(escalation.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Escalation updated successfully.","Escalation updated successfully.");
		WebInteract.AcceptAlert();
		Logger.logMessage("Escalation updated successfully");
	}

	@Step("To delete the escalation details")
	public void DeleteEscalationdetails(String Templatename) throws Throwable {
		WebInteract.waitForVisibility(escalation.Page_Header);
		WebInteract.selectByTextFomDropdownfromStale(escalation.Template_name, Templatename);
		WebInteract.waitForVisibility(escalation.deletebutton);
		WebInteract.scrollDown(0, 600);
		Selenium.click(escalation.deletebutton);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Delete this Escalation ?","Alert message is displayed while deleting Escalation details");
		WebInteract.AcceptAlert();
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Escalation Template deleted successfully.","Escalation Template deleted successfully.");
		WebInteract.AcceptAlert();
		Logger.logMessage("Escalation Template deleted successfully");
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String Templatename) throws Throwable {
		Selenium.sendKeys(escalation.Template_name_search, Templatename);
		Selenium.click(escalation.Add_esc);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Please fill the Details.","Validation message is displayed for Mandatory fields on Escalation details page");
        WebInteract.AcceptAlert();  
	}
}
