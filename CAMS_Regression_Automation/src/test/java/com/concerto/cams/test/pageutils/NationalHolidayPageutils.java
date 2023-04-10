package com.concerto.cams.test.pageutils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;

import com.concerto.cams.test.pages.NationalHoliday;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class NationalHolidayPageutils {

	protected NationalHoliday nationalholiday;

	public NationalHolidayPageutils() {
		nationalholiday = new NationalHoliday();
	}

	@Step("To get the header of National holiday page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("National Holiday");
		WebInteract.waitForVisibility(nationalholiday.Page_Header);
		String PageHeader = Selenium.getText(nationalholiday.Page_Header);
		Asserts.assertEqual(PageHeader, "National Holiday","National Holiday page header is Correct");
	}

	@Step("To get the header of Add new National holiday page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(nationalholiday.Addbtn);
		WebInteract.waitForVisibility(nationalholiday.Holiday_Name);
		String PageHeader = Selenium.getText(nationalholiday.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Page header of Add new National holiday is Correct");
	}

	@Step("To get the header of Edit National holiday page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(nationalholiday.Edit_Page_Header);
		String PageHeader = Selenium.getText(nationalholiday.Edit_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit National holiday page header is Correct");
	}

	@Step("Add new National holiday")
	public void addNationalHoliday(String Holidayname, String Date) throws Throwable {
		Selenium.sendKeys(nationalholiday.Holiday_Name, Holidayname);
		Selenium.sendKeys(nationalholiday.Date_select, Date);
		Selenium.click(nationalholiday.Add_holiday);
		// WebInteract.waitForVisibility(nationalholiday.Successfull_message);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(nationalholiday.Successfull_message);
		// String SuccessMessage =
		// Selenium.getText(nationalholiday.Successfull_message);
		Asserts.assertEqual(SuccessMessage, "Holiday details added successfully.","Holiday details added successfully");
		Selenium.click(nationalholiday.Close_btn);
		WebInteract.waitForVisibility(nationalholiday.Search_option);
		searchfuncforValidData(Holidayname);
		WebInteract.waitForVisibility(nationalholiday.Date_text);
		Asserts.assertEqual(Selenium.getText(nationalholiday.Date_text), Date,"Correct date is display for added holiday");
		Asserts.assertEqual(Selenium.getText(nationalholiday.NationalHoliday_text), Holidayname,"Correct holiday name is display for added holiday");
	}

	@Step("To validate whether duplicate entries allowed or not")
	public void ValidateDuplicateEntries(String Holidayname, String Date) throws Throwable {
		Selenium.sendKeys(nationalholiday.Holiday_Name, Holidayname);
		Selenium.sendKeys(nationalholiday.Date_select, Date);
		Selenium.click(nationalholiday.Add_holiday);
		// WebInteract.waitForVisibility(nationalholiday.Error_message);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(nationalholiday.Error_message);
		// String SuccessMessage = Selenium.getText(nationalholiday.Error_message);
		Asserts.assertEqual(SuccessMessage, "This Holiday is already exists.","Validation message is displayed for Duplicate national holiday");
		Selenium.click(nationalholiday.Close_btn);
	}

	@Step("Edit National holiday details")
	public void EditnationalHoliday(String Holidayname, String Date, String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(nationalholiday.Edit_btn);
		Selenium.click(nationalholiday.Edit_btn);
		GetEditPageHeader();
		WebInteract.waitForVisibility(nationalholiday.Holiday_Name);
		Selenium.clear(nationalholiday.Holiday_Name);
		Selenium.sendKeys(nationalholiday.Holiday_Name, Holidayname);
		Selenium.clear(nationalholiday.Date_select);
		Selenium.sendKeys(nationalholiday.Date_select, Date);
		Selenium.click(nationalholiday.Update_btn);
		// WebInteract.waitForVisibility(nationalholiday.Update_message);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(nationalholiday.Update_message);
		// String Successmessage = Selenium.getText(nationalholiday.Update_message);
		Asserts.assertEqual(SuccessMessage, "Holiday details updated successfully.","Holiday details updated successfully.");
		Selenium.click(nationalholiday.Close_btn);
		WebInteract.waitForVisibility(nationalholiday.Search_option);
		searchfuncforValidData(Holidayname);
		WebInteract.waitForVisibility(nationalholiday.Date_text);
		Asserts.assertEqual(Selenium.getText(nationalholiday.Date_text), Date,"Date is match for the updated holiday record");
		Asserts.assertEqual(Selenium.getText(nationalholiday.NationalHoliday_text), Holidayname,"Holiday name is match for updated holiday record");

	}

	@Step("To refresh the added details")
	public void Refreshdetails(String Holidayname, String Date) throws Throwable {
		Selenium.sendKeys(nationalholiday.Holiday_Name, Holidayname);
		Selenium.sendKeys(nationalholiday.Date_select, Date);
		Selenium.click(nationalholiday.Refreshbtn);
		Asserts.assertTrue(Selenium.getAttribute(nationalholiday.Holiday_Name, "value").isEmpty(),"Holiday name field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(nationalholiday.Date_select, "value").isEmpty(),"Date field is blank on refreshing");
		Selenium.click(nationalholiday.Close_btn);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(nationalholiday.Search_option, searchtext);
		Selenium.click(nationalholiday.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(nationalholiday.Search_option, searchtext);
		Selenium.click(nationalholiday.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Alert message is displayed for No records on National holiday page");
		WebInteract.AcceptAlert();
	}

	@Step("To delete the entry of Natioanal holiday page")
	public void DeleteNationalHolidayRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(nationalholiday.Delete_btn);
		Selenium.click(nationalholiday.Delete_btn);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to Delete this Holiday Details?","Alert message is displayed for deletion of holiday details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Holiday details deleted successfully.","Holiday details deleted successfully.");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(nationalholiday.Addbtn);
		searchfuncforInValidData(Searchtxt);
	}

	@Step("To Delete Used data")
	public void DeleteUsedData(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(nationalholiday.Delete_btn);
		Selenium.click(nationalholiday.Delete_btn);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to delete this holiday Details?","Alert message is displayed for delete holiday details");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertTrue(Deletemessage.contains("Unable to delete"),"Correct message is displayed while deleting used records");
		WebInteract.AcceptAlert();

	}

	@Step("To get validation message")
	public void GetValidationMessage() throws Throwable {
		Selenium.click(nationalholiday.Add_holiday);
		//WebInteract.waitForVisibility(nationalholiday.Validation_HolidayName);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(nationalholiday.Validation_HolidayName), "Required","Validation message is displayed for mandatory fields of holiday page");
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(nationalholiday.Validation_DateField), "Required","Validation message is displayed for mandatory fields of holiday page");
		Selenium.click(nationalholiday.Close_btn);
	}
	
	public String getDateFormat(String date) throws ParseException {

		SimpleDateFormat format1 = new SimpleDateFormat("dd-mm-yyyy");
   
		Date inActiveDate = format1.parse(date);
		
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-mm-dd");
		return format2.format(inActiveDate);
	}
}
