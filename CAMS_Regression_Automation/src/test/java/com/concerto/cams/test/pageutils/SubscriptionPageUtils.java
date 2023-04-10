package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.Subscription;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class SubscriptionPageUtils {

	protected Subscription sub;

	public SubscriptionPageUtils() {

		sub = new Subscription();
	}

	@Step("To get the page Header of Subscription details page")
	public void GetpageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Subscription Details");
		WebInteract.waitForVisibility(sub.Page_Header);
		String PageHeader = WebInteract.getNonstaleElementGetText(sub.Page_Header);
		Asserts.assertEqual(PageHeader, "Subscription Details","Correct page is displayed");
	}

	@Step("To get the header of Add Subscription details page")
	public void GetAddpageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(sub.Add_btn);
		WebInteract.waitForVisibility(sub.Subscription_name);
		String PageHeader = Selenium.getText(sub.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Correct add page header is displayed");
	}

	@Step("To get the header of Edit service partner page")
	public void GetEditpageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(sub.Edit_btn);
		//WebInteract.waitForVisibility(sub.Edit_Page_Header);
		String PageHeader =WebInteract.getNonstaleElementGetText(sub.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Correct edit page header is displayed");
	}

	@Step("To add subscription details")
	public void Addsubscriptiondetails(String SubscriptionName, String SMScount, String PhoneCount, String EmailCount,
			String Repeatcount, String VideoVerification) throws Throwable {
		Selenium.sendKeys(sub.Subscription_name, SubscriptionName);
		Selenium.clear(sub.SMS_Count);
		Selenium.sendKeys(sub.SMS_Count, SMScount);
		Selenium.clear(sub.Phone_count);
		Selenium.sendKeys(sub.Phone_count, PhoneCount);
		Selenium.clear(sub.Email_count);
		Selenium.sendKeys(sub.Email_count, EmailCount);
		Selenium.clear(sub.Repeat_count);
		Selenium.sendKeys(sub.Repeat_count, Repeatcount);
		Selenium.click(sub.Video_confirmation_yes);
		Selenium.clear(sub.SLA_For_Video);
		Selenium.sendKeys(sub.SLA_For_Video, VideoVerification);
		Selenium.click(sub.Dispatch_yes);
		Selenium.click(sub.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Subscription Details?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(sub.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(sub.Successfull_message);
		Asserts.assertEqual(message, "Subscription added successfully.","Correct message is displayed on addition of subscription");
		Selenium.click(sub.Close_btn);
		WebInteract.waitForVisibility(sub.Search_option);
		searchfuncforValidData(SubscriptionName);
		WebInteract.waitForVisibility(sub.Subscription_txt);
		Asserts.assertEqual(Selenium.getText(sub.Subscription_txt), SubscriptionName,"Correct subscription name is displayed");
		Asserts.assertEqual(Selenium.getText(sub.Phone_txt), PhoneCount,"Correct phone count is displayed");
		Asserts.assertEqual(Selenium.getText(sub.SMS_txt), SMScount,"Correct sms count is displayed");
		Asserts.assertEqual(Selenium.getText(sub.Email_txt), EmailCount,"Correct email count is displayed");
		Asserts.assertEqual(Selenium.getText(sub.Repeat_txt), Repeatcount,"Correct repeat count is displayed");
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String SubscriptionName) throws Throwable {
		Selenium.click(sub.Add_button);
		//WebInteract.waitForVisibility(sub.Validation_message);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(sub.Validation_message), "Required","Correct validation message is displayed");
		Selenium.click(sub.Close_btn);
	}

	@Step("To refresh the added details")
	public void RefreshAddedDetails(String SubscriptionName, String SMScount, String PhoneCount, String EmailCount,
			String Repeatcount, String VideoVerification) throws Throwable {
		Selenium.sendKeys(sub.Subscription_name, SubscriptionName);
		Selenium.clear(sub.SMS_Count);
		Selenium.sendKeys(sub.SMS_Count, SMScount);
		Selenium.clear(sub.Phone_count);
		Selenium.sendKeys(sub.Phone_count, PhoneCount);
		Selenium.clear(sub.Email_count);
		Selenium.sendKeys(sub.Email_count, EmailCount);
		Selenium.clear(sub.Repeat_count);
		Selenium.sendKeys(sub.Repeat_count, Repeatcount);
		Selenium.click(sub.Video_confirmation_yes);
		Selenium.clear(sub.SLA_For_Video);
		Selenium.sendKeys(sub.SLA_For_Video, VideoVerification);
		Selenium.click(sub.Dispatch_yes);
		Selenium.click(sub.Refresh_button);
		Asserts.assertTrue(Selenium.getAttribute(sub.Subscription_name, "value").isEmpty(),"Subscription name field is blank on refreshing");
		Selenium.click(sub.Close_btn);
	}

	@Step("To validate Whether duplicate entries are allowed or not")
	public void ValidateDuplicateEntries(String SubscriptionName, String SMScount, String PhoneCount, String EmailCount,
			String Repeatcount, String VideoVerification) throws Throwable {
		Selenium.sendKeys(sub.Subscription_name, SubscriptionName);
		Selenium.clear(sub.SMS_Count);
		Selenium.sendKeys(sub.SMS_Count, SMScount);
		Selenium.clear(sub.Phone_count);
		Selenium.sendKeys(sub.Phone_count, PhoneCount);
		Selenium.clear(sub.Email_count);
		Selenium.sendKeys(sub.Email_count, EmailCount);
		Selenium.clear(sub.Repeat_count);
		Selenium.sendKeys(sub.Repeat_count, Repeatcount);
		Selenium.click(sub.Video_confirmation_yes);
		Selenium.clear(sub.SLA_For_Video);
		Selenium.sendKeys(sub.SLA_For_Video, VideoVerification);
		Selenium.click(sub.Dispatch_yes);
		Selenium.click(sub.Add_button);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure to Add this Subscription Details?","Correct alert message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(sub.Error_message);
		String message = WebInteract.getNonstaleElementGetText(sub.Error_message);
		Asserts.assertEqual(message, "Subscription already exists.","Correct message is display for duplicate records");
		Selenium.click(sub.Close_btn);

	}

	@Step("To edit Subscription details")
	public void EditSubscriptionDetails(String Emailcount, String SMScount, String PhoneCount, String Searchtxt)
			throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(sub.Edit_btn);
		Selenium.click(sub.Edit_btn);
		WebInteract.waitForVisibility(sub.Email_count);
        GetEditpageHeader();
		Selenium.clear(sub.Email_count);
		Selenium.sendKeys(sub.Email_count, Emailcount);
		Selenium.clear(sub.SMS_Count);
		Selenium.sendKeys(sub.SMS_Count, SMScount);
		Selenium.clear(sub.Phone_count);
		Selenium.sendKeys(sub.Phone_count, PhoneCount);
		Selenium.click(sub.SMS_Count);
		Selenium.click(sub.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Do you want to Update this Subscription Details?","Correct message is displayed on updation of records");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(sub.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(sub.Successfull_message);
		Asserts.assertEqual(message, "Subscription updated successfully.","Correct message is displayed on updation");
		Selenium.click(sub.Close_btn);
	}

	@Step("To Delete the entry of the page")
	public void DeleteSubscriptiondetails(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(sub.Delete_btn);
		Selenium.click(sub.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Subscription Details?","Correct alert message is displayed on deletion");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Subscription deleted successfully.","Correct message is displayed on deletion of subscription records");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(sub.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(sub.Search_option, searchtext);
		Selenium.click(sub.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(sub.Search_option, searchtext);
		Selenium.click(sub.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Correct alert message is displayed for no records");
		WebInteract.AcceptAlert();
	}

	@Step("To delete used record")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(sub.Delete_btn);
		Selenium.click(sub.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Subscription Details?","Correct alert message is displayed for deletion of records");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertTrue(Deletemessage.contains("Unable to delete subscription. It is used in panels."),"Correct message is displayed for used records");
		WebInteract.AcceptAlert();
	}

}
