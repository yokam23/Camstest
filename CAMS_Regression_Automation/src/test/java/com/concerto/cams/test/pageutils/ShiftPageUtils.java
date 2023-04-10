package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.Shift;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ShiftPageUtils {

	protected Shift shift;

	public ShiftPageUtils() {
		shift = new Shift();
	}

	@Step("To get the header of shift page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("ShiftMaster");
		WebInteract.waitForVisibility(shift.Page_Header);
		String PageHeader = Selenium.getText(shift.Page_Header);
		Asserts.assertEqual(PageHeader, "Shift Master","Correct page is displayed");
	}

	@Step("To get the header of Add new shift page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(shift.Add_btn);
		WebInteract.waitForVisibility(shift.Shift);
		String PageHeader = Selenium.getText(shift.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Correct add page header is displayed");
	}

	@Step("To get the header of Edit shift page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(shift.Edit_Page_Header);
		String PageHeader = Selenium.getText(shift.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Correct edit page header is displayed");
	}

	@Step("To add New Shift")
	public void AddnewShift(String Shiftname, String Timefrom, String Timeto) throws Throwable {
		Selenium.sendKeys(shift.Shift, Shiftname);
		Selenium.sendKeys(shift.TimeFrom, Timefrom);
		Selenium.sendKeys(shift.TimeTo, Timeto);
		Selenium.click(shift.Create_button);
		WebInteract.WaitForAlert();
		String Alertmessaege = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessaege, "Are you sure you wish to add this Shift?","Correct alert message is displayed for add shift");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(shift.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(shift.Successfull_message);
		Asserts.assertEqual(message, "Shift added successfully","Correct message is displayed on add shift");
		Selenium.click(shift.Cancel_btn);
		WebInteract.waitForVisibility(shift.Search_option);
		searchfuncforValidData(Shiftname);
		WebInteract.waitForVisibility(shift.Shift_txt);
		Asserts.assertEqual(Selenium.getText(shift.Shift_txt), Shiftname,"Correct shift name is displayed");
		String FromTime = Selenium.getText(shift.TimeFrom_txt);
		String ToTime = Selenium.getText(shift.TimeTo_txt);
		Asserts.assertTrue(FromTime.contains(Timefrom),"Correct from time is displayed");
		Asserts.assertTrue(ToTime.contains(Timeto),"Correct To time is displayed");

	}

	@Step("To get the Validation message")
	public void GetValidationMessage(String Shiftname) throws Throwable {
		Selenium.sendKeys(shift.Shift, Shiftname);
		Selenium.click(shift.Create_button);
		WebInteract.WaitForAlert();
		String Alertmessaege = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessaege, "Are you sure you wish to add this Shift?","Correct alert message is displayed on add shift");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(shift.Validation_message);
		Asserts.assertEqual(Selenium.getText(shift.Validation_message), "The Time From field is required.","Correct validation message is displayed");
		Selenium.click(shift.Cancel_btn);
	}

	@Step("To Edit existing Shift")
	public void EditShift(String Shiftname, String Timefrom, String Timeto, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(shift.Edit_btn);
		Selenium.click(shift.Edit_btn);
		WebInteract.waitForVisibility(shift.Shift);
		GetEditPageHeader();
		Selenium.clear(shift.Shift);
		Selenium.sendKeys(shift.Shift, Shiftname);
		Selenium.clear(shift.TimeFrom);
		Selenium.sendKeys(shift.TimeFrom, Timefrom);
		Selenium.clear(shift.TimeTo);
		Selenium.sendKeys(shift.TimeTo, Timeto);
		Selenium.click(shift.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessaege = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessaege, "Are you sure you wish to update this Shift?","Correct alert message is displayed on update shift");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(shift.Successfull_message);
		String message = WebInteract.getNonstaleElementGetText(shift.Successfull_message);
		Asserts.assertEqual(message, "Shift updated successfully","Correct message is displayed on shift details updation");
		Selenium.click(shift.Close_btn);
		WebInteract.waitForVisibility(shift.Search_option);
		searchfuncforValidData(Shiftname);
		WebInteract.waitForVisibility(shift.Shift_txt);
		Asserts.assertEqual(Selenium.getText(shift.Shift_txt), Shiftname,"Correct shift name is displayed");
		String FromTime = Selenium.getText(shift.TimeFrom_txt);
		String ToTime = Selenium.getText(shift.TimeTo_txt);
		Asserts.assertTrue(FromTime.contains(Timefrom),"Correct from time is displayed");
		Asserts.assertTrue(ToTime.contains(Timeto),"Correct to time is displayed");
	}

	@Step("To validate whether duplicate entries allowed are not")
	public void ValidateDuplicateEnteries(String Shiftname, String Timefrom, String Timeto) throws Throwable {
		Selenium.sendKeys(shift.Shift, Shiftname);
		Selenium.sendKeys(shift.TimeFrom, Timefrom);
		Selenium.sendKeys(shift.TimeTo, Timeto);
		Selenium.click(shift.Create_button);
		WebInteract.WaitForAlert();
		String Alertmessaege = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessaege, "Are you sure you wish to add this Shift?","Correct alert message is displayed on add shift");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(shift.Error_message);
		String message = WebInteract.getNonstaleElementGetText(shift.Error_message);
		Asserts.assertEqual(message, "This Shift already exists","Correct message is displayed for duplicate shift record");
		Selenium.click(shift.Cancel_btn);
	}

	@Step("To Delete the entry of the page")
	public void DeleteShiftdetails(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(shift.Delete_btn);
		Selenium.click(shift.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Are you sure you wish to delete this Shift?","Correct alert message is displayed on deletion of shift");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Shift deleted successfully","Correct message is displayed on deletion of shift");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(shift.Add_btn);

	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(shift.Search_option, searchtext);
		Selenium.click(shift.Go_button);
	}

	@Step("To delete used record")
	public void DeleteUsedRecords(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(shift.Delete_btn);
		Selenium.click(shift.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Are you sure you wish to delete this Shift?","Correct message is displayed while deleting shift");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertTrue(Deletemessage.contains("Record can not be Deleted. It has a dependency."),"Correct message is displayed for used records");
		WebInteract.AcceptAlert();
	}
}
