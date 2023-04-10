package com.concerto.cams.test.pageutils;

import org.gradle.internal.impldep.org.testng.Assert;

import com.concerto.cams.test.pages.OperatorComment;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class OperatorCommentsPageutils {

	protected OperatorComment operatorcmt;

	public OperatorCommentsPageutils() {
		operatorcmt = new OperatorComment();
	}

	@Step("To get the header of operator comment page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Operator Comments");
		WebInteract.waitForVisibility(operatorcmt.Page_Header);
		String PageHeader = Selenium.getText(operatorcmt.Page_Header);
		Asserts.assertEqual(PageHeader, "Operator Comments","Page header of operator comment page is Correct");
	}

	@Step("To get the header of Add new operator comment page")
	public void GetAddPageHeader() throws Throwable {
		String PageHeader = Selenium.getText(operatorcmt.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new operator comment page header is Correct");
	}

	@Step("To get the header of Edit operator comment page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(operatorcmt.Edit_Page_Header);
		String PageHeader = Selenium.getText(operatorcmt.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit operator comment page header is Correct");
	}

	@Step("To Add new User comment")
	public void AddUsercomment(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Add_Cmt);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure to Add this User Comments?","Alert message is displayed for Add user comments");
		WebInteract.AcceptAlert();
		String Success_message = WebInteract.getNonstaleElementGetText(operatorcmt.Successfull_message);
		Asserts.assertEqual(Success_message, "User Comments added successfully.","User Comments added successfully.");
		Selenium.click(operatorcmt.Close_btn);
		WebInteract.waitForVisibility(operatorcmt.Search_option);
		searchfuncforValidData(comment);
		WebInteract.waitForVisibility(operatorcmt.Usercmt_text);
		Asserts.assertEqual(Selenium.getText(operatorcmt.Usercmt_text), comment,"Added User comment is Correct on user comment page");
	}

	@Step("To Validate whether Duplicate entries are allowed or not for user comment")
	public void ValidateDuplicateEnteriesForUsercmt(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Add_Cmt);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure to Add this User Comments?","Alert message is displayed for adding new user comment");
		WebInteract.AcceptAlert();
		String Success_message = WebInteract.getNonstaleElementGetText(operatorcmt.Error_message);
		Asserts.assertEqual(Success_message, "This User Comments already exists.","Validation message is displayed for adding duplicate user comment");
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To refresh user comment")
	public void Refreshusercomment(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Refresh_btn);
		Assert.assertTrue(Selenium.getAttribute(operatorcmt.comment, "value").isEmpty());
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To add new Closure comment")
	public void AddClosurecomment(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.closure_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Add_Cmt);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure to Add this User Comments?","Alert message is displayed for adding new closure comment");
		WebInteract.AcceptAlert();
		String Success_message = WebInteract.getNonstaleElementGetText(operatorcmt.Successfull_message);
		Asserts.assertEqual(Success_message, "Closure Comments added successfully.","Closure Comments added successfully.");
		Selenium.click(operatorcmt.Close_btn);
		WebInteract.waitForVisibility(operatorcmt.Search_option);
		searchfuncforValidData(comment);
		WebInteract.waitForVisibility(operatorcmt.Closure_txt);
		Asserts.assertEqual(Selenium.getText(operatorcmt.Closure_txt), comment,"Added closure comment is Correct on closure comment page");
	}

	@Step("To Validate whether Duplicate entries are allowed or not for closure comment")
	public void ValidateDuplicateEnteriesForClosurecmt(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.closure_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Add_Cmt);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure to Add this User Comments?","Alert message is displayed for adding new closure comment");
		WebInteract.AcceptAlert();
		String Success_message = WebInteract.getNonstaleElementGetText(operatorcmt.Error_message);
		Asserts.assertEqual(Success_message, "This Closure Comments already exists.","Validation message is displayed for duplicate closure comment");
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To refresh Closure comment")
	public void RefreshClosurecomment(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.closure_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.commenttxt);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Refresh_btn);
		Assert.assertTrue(Selenium.getAttribute(operatorcmt.comment, "value").isEmpty());
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To add new Reopen comment")
	public void AddReopencomment(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Reopen_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Add_Cmt);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure to Add this User Comments?","Alert message is displayed for Add new Reopen comment");
		WebInteract.AcceptAlert();
		String Success_message = WebInteract.getNonstaleElementGetText(operatorcmt.Successfull_message);
		Asserts.assertEqual(Success_message, "Reopen Comments added successfully.","Reopen Comments added successfully.");
		Selenium.click(operatorcmt.Close_btn);
		WebInteract.waitForVisibility(operatorcmt.Search_option);
		searchfuncforValidData(comment);
		WebInteract.waitForVisibility(operatorcmt.Reopen_txt);
		Asserts.assertEqual(Selenium.getText(operatorcmt.Reopen_txt), comment,"Added reopen comment is Correct on reopen");
	}

	@Step("To refresh Closure comment")
	public void RefreshReopencomment(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Reopen_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.Refresh_btn);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Refresh_btn);
		Assert.assertTrue(Selenium.getAttribute(operatorcmt.comment, "value").isEmpty());
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To Validate whether Duplicate entries are allowed or not for Reopen comment")
	public void ValidateDuplicateEnteriesForReopencmt(String comment) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Reopen_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetAddPageHeader();
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Add_Cmt);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure to Add this User Comments?","Alert message is displayed while adding new reopen comment");
		WebInteract.AcceptAlert();
		String Success_message = WebInteract.getNonstaleElementGetText(operatorcmt.Error_message);
		Asserts.assertEqual(Success_message, "This Reopen Comments already exists.","Validation message is displayed for duplicate reopen comments");
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To Edit user comment")
	public void EditUsercomment(String comment, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Edit_btn);
		Selenium.click(operatorcmt.Edit_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetEditPageHeader();
		Selenium.clear(operatorcmt.comment);
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Update_btn);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Do you want to Update this Comments?","Alert message is displayed while updating user comment");
		WebInteract.AcceptAlert();
		String Update_message = WebInteract.getNonstaleElementGetText(operatorcmt.Update_message);
		Asserts.assertEqual(Update_message, "User Comments updated successfully.","User Comments updated successfully.");
		Selenium.click(operatorcmt.Close_btn);
		WebInteract.waitForVisibility(operatorcmt.Search_option);
		searchfuncforValidData(comment);
		WebInteract.waitForVisibility(operatorcmt.Usercmt_text);
		Asserts.assertEqual(Selenium.getText(operatorcmt.Usercmt_text), comment,"Updated user comment is Correct");

	}

	@Step("To Edit closure comment")
	public void Editclosurecomment(String comment, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.closure_cmt);
		WebInteract.waitForVisibility(operatorcmt.Edit_btn);
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Edit_btn);
		Selenium.click(operatorcmt.Edit_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetEditPageHeader();
		Selenium.clear(operatorcmt.comment);
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Update_btn);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Do you want to Update this Comments?","Alert message is displayed while updating closure comment");
		WebInteract.AcceptAlert();
		String Update_message = WebInteract.getNonstaleElementGetText(operatorcmt.Update_message);
		Asserts.assertEqual(Update_message, "Closure Comments updated successfully.","Closure Comments updated successfully.");
		Selenium.click(operatorcmt.Close_btn);
		WebInteract.waitForVisibility(operatorcmt.Search_option);
		searchfuncforValidData(comment);
		WebInteract.waitForVisibility(operatorcmt.Closure_txt);
		Asserts.assertEqual(Selenium.getText(operatorcmt.Closure_txt), comment,"Updated closure comment is Correct");
	}

	@Step("To Edit Reopen comment")
	public void EditReopenComment(String comment, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Reopen_cmt);
		WebInteract.waitForVisibility(operatorcmt.Edit_btn);
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Edit_btn);
		Selenium.click(operatorcmt.Edit_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		GetEditPageHeader();
		Selenium.clear(operatorcmt.comment);
		Selenium.sendKeys(operatorcmt.comment, comment);
		Selenium.click(operatorcmt.Update_btn);
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Do you want to Update this Comments?","Alert message is displayed while updating reopen comment");
		WebInteract.AcceptAlert();
		String Update_message = WebInteract.getNonstaleElementGetText(operatorcmt.Update_message);
		Asserts.assertEqual(Update_message, "Reopen Comments updated successfully.","Reopen Comments updated successfully.");
		Selenium.click(operatorcmt.Close_btn);
		WebInteract.waitForVisibility(operatorcmt.Search_option);
		searchfuncforValidData(comment);
		WebInteract.waitForVisibility(operatorcmt.Reopen_txt);
		Asserts.assertEqual(Selenium.getText(operatorcmt.Reopen_txt), comment,"Updated reopen comment is Correct");
	}

	@Step("To Delete user comment")
	public void Deleteusercomment(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		Selenium.click(operatorcmt.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Comments?","Alert message is displayed for deletion of user comment");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Assert.assertTrue(Deletemessage.contains("Deleted successfully."));
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To delete used User comment")
	public void DeleteUsedUsercmt(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		Selenium.click(operatorcmt.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Comments?","Alert message is displayed for deletion of used user comment");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Assert.assertTrue(Deletemessage.contains("Unable to delete"));
		WebInteract.AcceptAlert();
	}

	@Step("To Delete Closure comment")
	public void DeleteClosurecomment(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.closure_cmt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		Selenium.click(operatorcmt.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Comments?","Alert message is displayed for deletion of Closure comment");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Assert.assertTrue(Deletemessage.contains("Deleted successfully."));
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To Delete Used Closure comment")
	public void DeleteUsedClosurecomment(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.closure_cmt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		Selenium.click(operatorcmt.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Comments?","Alert message is displayed for deletion of used Closure comment");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Assert.assertTrue(Deletemessage.contains("Unable to delete"));
		WebInteract.AcceptAlert();
	}

	@Step("To Delete Reopen comment")
	public void DeleteReopencomment(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Reopen_cmt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		Selenium.click(operatorcmt.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Comments?","Alert message is displayed for deletion of Reopen comment");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Assert.assertTrue(Deletemessage.contains("Deleted successfully."));
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To Delete used Reopen comment")
	public void DeleteUsedReopencomment(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Reopen_cmt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(operatorcmt.Delete_btn);
		Selenium.click(operatorcmt.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Comments?","Alert message is displayed for deletion of used Reopen comment");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Assert.assertTrue(Deletemessage.contains("Unable to delete"));
		WebInteract.AcceptAlert();
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(operatorcmt.Search_option, searchtext);
		Selenium.click(operatorcmt.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(operatorcmt.Search_option, searchtext);
		Selenium.click(operatorcmt.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message for No records on Operator comment page");
		WebInteract.AcceptAlert();
	}

	@Step("To get validation message for User comment")
	public void GetValidationUsercmt() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		Selenium.click(operatorcmt.Add_Cmt);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(operatorcmt.Validation_usercmt), "Required","Validation message is displayed for mandatory fields of user comment page");
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To get validation message for Closure comment")
	public void GetValidationClosurecmt() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(operatorcmt.closure_cmt);
		Selenium.click(operatorcmt.closure_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		Selenium.click(operatorcmt.Add_Cmt);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(operatorcmt.Validation_Closurecmt), "Required","Validation message is displayed for mandatory fields of Closure comment page");
		Selenium.click(operatorcmt.Close_btn);
	}

	@Step("To get validation message for Reopen comment")
	public void GetValidationReopencmt() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(operatorcmt.Reopen_cmt);
		Selenium.click(operatorcmt.Reopen_cmt);
		WebInteract.waitForVisibility(operatorcmt.Add_btn);
		Selenium.click(operatorcmt.Add_btn);
		WebInteract.waitForVisibility(operatorcmt.comment);
		Selenium.click(operatorcmt.Add_Cmt);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(operatorcmt.Validation_Reopencmt), "Required","Validation message is displayed for mandatory fields of Reopen comment page");
		Selenium.click(operatorcmt.Close_btn);
	}
}
