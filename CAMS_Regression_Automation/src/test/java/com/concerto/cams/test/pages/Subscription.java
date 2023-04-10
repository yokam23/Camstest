package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Subscription {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='Subscription Details']")
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

	@Name(Description = "Subscription_name")
	@FindBy(id = "txtSubName")
	public WebElement Subscription_name;

	@Name(Description = "Subscription_count")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtSubName']")
	public WebElement Subscription_count;

	@Name(Description = "SMS Count")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtSMSCnt']")
	public WebElement SMS_Count;

	@Name(Description = "Phone_count")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtPhoneCnt']")
	public WebElement Phone_count;

	@Name(Description = "Email_count")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtEmailCnt']")
	public WebElement Email_count;

	@Name(Description = "Repeat_count")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtRepeatCnt']")
	public WebElement Repeat_count;

	@Name(Description = "Video_confirmation_yes")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='rbtVideoCat1']")
	public WebElement Video_confirmation_yes;

	@Name(Description = "Video_confirmation_no")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='rbtVideoCat2']")
	public WebElement Video_confirmation_no;

	@Name(Description = "Dispatch_yes")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='rbtDispatchCat1']")
	public WebElement Dispatch_yes;

	@Name(Description = "Dispatch_No")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='rbtDispatchCat2']")
	public WebElement Dispatch_No;

	@Name(Description = "SLA For Video Verification (min.)")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtVideoIntervalCnt']")
	public WebElement SLA_For_Video;

	@Name(Description = "Add_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddSubscriptionDetails']")
	public WebElement Add_button;

	@Name(Description = "Refresh_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnRefresh']")
	public WebElement Refresh_button;

	@Name(Description = "Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Close_btn;

	@Name(Description = "Edit_btn")
	@FindBy(xpath = "(//a[@name='Edit'])[1]")
	public WebElement Edit_btn;

	@Name(Description = "Delete_btn")
	@FindBy(xpath = "(//a[@name='Delete'])[1]")
	public WebElement Delete_btn;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Update']")
	public WebElement Update_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@placeholder='Search by Subscription']")
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

	@Name(Description = "Validation message")
	@FindBy(xpath = "//div[@class='modal-body']//span[@id='errorIsValidSubName']")
	public WebElement Validation_message;

	@Name(Description = "Subscription Text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement Subscription_txt;

	@Name(Description = "Sms Text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
	public WebElement SMS_txt;

	@Name(Description = "Phone Text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[3]")
	public WebElement Phone_txt;

	@Name(Description = "Email Text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[4]")
	public WebElement Email_txt;

	@Name(Description = "Repeat Text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[6]")
	public WebElement Repeat_txt;

	public Subscription() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
