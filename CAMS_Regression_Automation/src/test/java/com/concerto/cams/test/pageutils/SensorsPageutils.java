package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.Sensors;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class SensorsPageutils {

	protected Sensors sensors;

	public SensorsPageutils() {
		sensors = new Sensors();
	}

	@Step("To get the header of National holiday page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Sensor");
		WebInteract.waitForVisibility(sensors.Page_Header);
		String PageHeader = Selenium.getText(sensors.Page_Header);
		Asserts.assertEqual(PageHeader, "Sensor Master","Sensor master page header is Correct");
	}

	@Step("To get the header of Add new National holiday page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(sensors.Add_btn);
		WebInteract.waitForVisibility(sensors.Sensortype);
		String PageHeader = Selenium.getText(sensors.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Add","Add new Sensor page header is Correct");
	}

	@Step("To get the header of Edit National holiday page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(sensors.Edit_Page_Header);
		String PageHeader = Selenium.getText(sensors.Add_Page_Header);
		Asserts.assertEqual(PageHeader, "Edit","Edit senspr page header is Correct");
	}

	@Step("Add new sensor")
	public void AddNewSensor(String Sensortype, String Panelmanufacturer, String Alarm, String RestoralType,
			String AlertPriority, String AlertsmsMessage, String RestoralsmsMessage, String AlarmEmailSubject,
			String RestoralEmailSubject, String AlarmEmailMessage, String RestoralEmailMessage) throws Throwable {
		Selenium.sendKeys(sensors.Sensortype, Sensortype);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Panel_manufacturer, Panelmanufacturer);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Alarm, Alarm);
		Selenium.click(sensors.Autobypass_No);
		Selenium.click(sensors.Zonetype_Hard);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Alert_priority, AlertPriority);
		Selenium.sendKeys(sensors.Alarm_sms_message, AlertsmsMessage);
		Selenium.sendKeys(sensors.Restoral_sms_message, RestoralsmsMessage);
		Selenium.sendKeys(sensors.Alarm_email_subject, AlarmEmailSubject);
		Selenium.sendKeys(sensors.Restoral_email_subject, RestoralEmailSubject);
		Selenium.sendKeys(sensors.Alarm_email_message, AlarmEmailMessage);
		Selenium.sendKeys(sensors.Restoral_email_message, RestoralEmailMessage);
		Selenium.click(sensors.Create_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you wish to add this Sensors?","Correct alert message is displayed on Add new sensor page");
		WebInteract.AcceptAlert();
		String message = WebInteract.getNonstaleElementGetText(sensors.Successfull_message);
		Asserts.assertEqual(message, "Sensor added successfully","New sensor gets added");
		Selenium.click(sensors.Cancel_btn);
		WebInteract.waitForVisibility(sensors.Search_option);
		searchfuncforValidData(Sensortype);
		WebInteract.waitForVisibility(sensors.SensorType_txt);
		Asserts.assertEqual(Selenium.getText(sensors.SensorType_txt), Sensortype,"Sensor type of newly added is Correct");
		Asserts.assertEqual(Selenium.getText(sensors.Alarm_txt), Alarm,"Alarm of newly added sensor is Correct");
		Asserts.assertEqual(Selenium.getText(sensors.AlertPriority_txt), AlertPriority,"Alert priority of added sensor is Correct");
		Asserts.assertEqual(Selenium.getText(sensors.RestoralType_txt), RestoralType,"Restoral type of added sensor is Correct");
	}

	@Step("To validate whether duplicate entries are allowed or not")
	public void ValidateDuplicateEntries(String Sensortype, String Panelmanufacturer, String Alarm, String RestoralType,
			String AlertPriority, String AlertsmsMessage, String RestoralsmsMessage, String AlarmEmailSubject,
			String RestoralEmailSubject, String AlarmEmailMessage, String RestoralEmailMessage) throws Throwable {
		Selenium.sendKeys(sensors.Sensortype, Sensortype);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Panel_manufacturer, Panelmanufacturer);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Alarm, Alarm);
		Selenium.click(sensors.Autobypass_No);
		Selenium.click(sensors.Zonetype_Hard);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Alert_priority, AlertPriority);
		Selenium.sendKeys(sensors.Alarm_sms_message, AlertsmsMessage);
		Selenium.sendKeys(sensors.Restoral_sms_message, RestoralsmsMessage);
		Selenium.sendKeys(sensors.Alarm_email_subject, AlarmEmailSubject);
		Selenium.sendKeys(sensors.Restoral_email_subject, RestoralEmailSubject);
		Selenium.sendKeys(sensors.Alarm_email_message, AlarmEmailMessage);
		Selenium.sendKeys(sensors.Restoral_email_message, RestoralEmailMessage);
		Selenium.click(sensors.Create_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you wish to add this Sensors?","Correct alert message is displayed on sensor page");
		WebInteract.AcceptAlert();
		String message = WebInteract.getNonstaleElementGetText(sensors.Error_message);
		Asserts.assertEqual(message, "This Sensor already exists","Correct validation message is displayed on sensor page for duplicate records");
		Selenium.click(sensors.Cancel_btn);
	}

	@Step("To Edit sensor record")
	public void Editsensors(String Sensortype, String Alarm, String RestoralType) throws Throwable {
		searchfuncforValidData(Sensortype);
		Selenium.click(sensors.Edit_btn);
		WebInteract.waitForVisibility(sensors.Alarm);
		//Selenium.clear(sensors.Alarm);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Alarm, Alarm);
		Selenium.click(sensors.Update_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you wish to update this Sensor?","Correct alert message is displayed for update sensor");
		WebInteract.AcceptAlert();
		String message = WebInteract.getNonstaleElementGetText(sensors.Successfull_message);
		Asserts.assertEqual(message, "Sensor updated successfully","Correct update message is displayed on sensor page");
		Selenium.click(sensors.Cancel_btn);
		WebInteract.waitForVisibility(sensors.Search_option);
		searchfuncforValidData(Sensortype);
		WebInteract.waitForVisibility(sensors.SensorType_txt);
		Asserts.assertEqual(Selenium.getText(sensors.Alarm_txt), Alarm,"Alarm for updated sensor details is Correct");
		Asserts.assertEqual(Selenium.getText(sensors.RestoralType_txt), RestoralType,"Restoral type for updated sensor details is Correct");
	}

	@Step("To Delete the sensor record")
	public void Deletesensor(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(sensors.Delete_btn);
		Selenium.click(sensors.Delete_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you wish to delete this Sensor?","Correct alert message is displayed while deleting sensor details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Cannot Delete Sensor as it is used in Master Template.","Correct alert message is displalyed on sensor deleion");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(sensors.Add_btn);
	}

	@Step("To delete used data")
	public void DeleteUsedRecord(String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(sensors.Delete_btn);
		Selenium.click(sensors.Delete_btn);
		WebInteract.WaitForAlert();
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "Are you sure you wish to delete this Sensor?","Correct alert message is displayed while deleting sensor details");
		WebInteract.AcceptAlert();
		WebInteract.WaitForAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Cannot Delete Sensor as it is used in Master Template.","Correct message is displayed while deleting used sensor records");
		WebInteract.AcceptAlert();
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(sensors.Search_option, searchtext);
		Selenium.click(sensors.Go_button);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(sensors.Search_option, searchtext);
		Selenium.click(sensors.Go_button);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Correct alert message is displayed for no records");
		WebInteract.AcceptAlert();
	}

	@Step("To get the validation message")
	public void GetValidationMessage(String Panelmanufacturer, String Alarm, String RestoralType, String AlertPriority,
			String RestoralsmsMessage, String AlarmEmailSubject, String RestoralEmailSubject, String AlarmEmailMessage,
			String RestoralEmailMessage) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(sensors.Panel_manufacturer, Panelmanufacturer);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Alarm, Alarm);
		Selenium.click(sensors.Autobypass_No);
		Selenium.click(sensors.Zonetype_Hard);
		WebInteract.selectByTextFomDropdownfromStale(sensors.Alert_priority, AlertPriority);
		Selenium.sendKeys(sensors.Restoral_sms_message, RestoralsmsMessage);
		Selenium.sendKeys(sensors.Alarm_email_subject, AlarmEmailSubject);
		Selenium.sendKeys(sensors.Restoral_email_subject, RestoralEmailSubject);
		Selenium.sendKeys(sensors.Alarm_email_message, AlarmEmailMessage);
		Selenium.sendKeys(sensors.Restoral_email_message, RestoralEmailMessage);
		Selenium.click(sensors.Create_btn);
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you wish to add this Sensors?","Correct alert message is displayed while adding new sensor");
		WebInteract.AcceptAlert();
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(sensors.Validation_SensorType),
				"The Sensor Type* field is required.","Correct validation message is displayed for mandatory fields");
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(sensors.Validation_Alarmsms),
				"The Alarm SMS Message * field is required.","Correct validation message is displayed for mandatory fields");
		Selenium.click(sensors.Cancel_btn);
	}

}
