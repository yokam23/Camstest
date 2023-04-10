package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Manufacturer {
	
	@Name(Description="Page Header")
	@FindBy(xpath="//h2[text()='Manufacturer']")
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

	@Name(Description = "Device_name")
	@FindBy(xpath = "//div[@class='modal-body']//select[@id='DeviceTypeName']")
	public WebElement Device_name;

	@Name(Description = "Company_name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtCompanyName']")
	public WebElement Company_name;

	@Name(Description = "Add_manufacturer")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddManufacturer']")
	public WebElement Add_manufacturer;

	@Name(Description = "Refresh_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnRefresh']")
	public WebElement Refresh_btn;

	@Name(Description = "cancel_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//button[@id='btnCancelManufacturer']")
	public WebElement cancel_btn;

	@Name(Description = "Edit_btn")
	@FindBy(xpath = "(//a[@name='Edit'])[1]")
	public WebElement Edit_btn;

	@Name(Description = "Delete_btn")
	@FindBy(xpath = "(//a[@name='Delete'])[1]")
	public WebElement Delete_btn;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnUpdate']")
	public WebElement Update_btn;

	@Name(Description = "Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//button[@id='btnCancelManufacturer']")
	public WebElement Close_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@placeholder='Search by Device or Company Name']")
	public WebElement Search_option;

	@Name(Description = "Go_button")
	@FindBy(xpath = "//button[text()='Go']")
	public WebElement Go_button;
	
	@Name(Description = "Update message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divSuccess2']")
	public WebElement Update_message;
	
	@Name(Description = "Success message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Succesfull_message;
	
	@Name(Description = "Close button of edit pop up")
   @FindBy(xpath = "//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Edit_closeBtn;
	
	@Name(Description = "Error message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement Error_message;
	
	@Name(Description = "Validation message")
	@FindBy(xpath = "//div[@class='modal-body']//span[@Id='errorIsValidDeviceTypeName']")
	public WebElement Validation_message;

	@Name(Description = "Device name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement Device_txt;
	
	@Name(Description = "Company name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
	public WebElement companyName_txt;

	public Manufacturer() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
