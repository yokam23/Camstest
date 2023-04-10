package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Sensors {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='Sensor Master']")
	public WebElement Page_Header;

	@Name(Description = "Add Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Add']")
	public WebElement Add_Page_Header;

	@Name(Description = "Edit Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Edit']")
	public WebElement Edit_Page_Header;

	@Name(Description = "Add_btn")
	@FindBy(xpath = "//a[@id='btnCreate']")
	public WebElement Add_btn;

	@Name(Description = "Sensortype")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='SensorType']")
	public WebElement Sensortype;

	@Name(Description = "Panel_manufacturer")
	@FindBy(xpath = "//div[@class='modal-body']//div//select[@id='PnlManufacturer']")
	public WebElement Panel_manufacturer;

	@Name(Description = "Alarm")
	@FindBy(xpath = "//div[@class='modal-body']//select[@id='ddlAlarmType']")
	public WebElement Alarm;

	@Name(Description = "Restoral type")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='txtRestoral']")
	public WebElement Restoral_type;

	@Name(Description = "Autobypass_Yes")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='rbtAutoByPassYes']")
	public WebElement Autobypass_Yes;

	@Name(Description = "Autobypass_No")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='rbtAutoByPassNo']")
	public WebElement Autobypass_No;

	@Name(Description = "Zonetype_Hard")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='rbtZoneTypeHard']")
	public WebElement Zonetype_Hard;

	@Name(Description = "Zonetype_Soft")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='rbtZoneTypeSoft']")
	public WebElement Zonetype_Soft;

	@Name(Description = "Alert_priority")
	@FindBy(xpath = "//div[@class='modal-body']//div//select[@id='AlertPriority']")
	public WebElement Alert_priority;

	@Name(Description = "Alarm_sms_message")
	@FindBy(xpath = "//div[@class='modal-body']//div//textarea[@id='AlarmSMSMessage']")
	public WebElement Alarm_sms_message;

	@Name(Description = "Restoral_sms_message")
	@FindBy(xpath = "//div[@class='modal-body']//div//textarea[@id='RestoralSMSMessage']")
	public WebElement Restoral_sms_message;

	@Name(Description = "Alarm_email_subject")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='AlarmEmailSubject']")
	public WebElement Alarm_email_subject;

	@Name(Description = "Restoral_email_subject")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='RestoralEmailSubject']")
	public WebElement Restoral_email_subject;

	@Name(Description = "Alarm_email_message")
	@FindBy(xpath = "//div[@class='modal-body']//div//textarea[@id='AlarmEmailMesaage']")
	public WebElement Alarm_email_message;

	@Name(Description = "Restoral_email_message")
	@FindBy(xpath = "//div[@class='modal-body']//div//textarea[@id='RestoralEmailMesaage']")
	public WebElement Restoral_email_message;

	@Name(Description = "Create_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//div//input[@id='btnaddShift']")
	public WebElement Create_btn;

	@Name(Description = "Cancel_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//div//input[@value='Cancel']")
	public WebElement Cancel_btn;

	@Name(Description = "Edit btn")
	@FindBy(xpath = "(//td[@class='action']//a)[1]")
	public WebElement Edit_btn;

	@Name(Description = "Delete_btn")
	@FindBy(xpath = "(//a[@title='Delete'])[1]")
	public WebElement Delete_btn;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//div//input[contains(@class,'btn-success')]")
	public WebElement Update_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@placeholder='Search by Sensors']")
	public WebElement Search_option;

	@Name(Description = "Go_button")
	@FindBy(xpath = "//button[text()='Go']")
	public WebElement Go_button;

	@Name(Description = "Successfull message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Successfull_message;

	@Name(Description = "Error message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement Error_message;

	@Name(Description = "Validation message for sensor type field")
	@FindBy(xpath = "//div[@class='modal-body']//span[@data-valmsg-for='SensorType']")
	public WebElement Validation_SensorType;

	@Name(Description = "Validation message for Alarm sms field")
	@FindBy(xpath = "//div[@class='modal-body']//span[@data-valmsg-for='AlarmSMSMessage']")
	public WebElement Validation_Alarmsms;

	@Name(Description = "Get sensor type text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement SensorType_txt;

	@Name(Description = "Get Alarm text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
	public WebElement Alarm_txt;

	@Name(Description = "Get Restoraltype text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[3]")
	public WebElement RestoralType_txt;

	@Name(Description = "Get Alert priority text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[5]")
	public WebElement AlertPriority_txt;

	public Sensors() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
