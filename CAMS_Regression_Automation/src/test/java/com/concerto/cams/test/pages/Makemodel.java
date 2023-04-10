package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Makemodel {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='Make Model']")
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

	@Name(Description = "Generic_name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtGenericName']")
	public WebElement Generic_name;

	@Name(Description = "Manufacturer_name")
	@FindBy(xpath = "//div[@class='modal-body']//select[@id='ddlCompanyName']")
	public WebElement Manufacturer_name;

	@Name(Description = "Model_name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtModelName']")
	public WebElement Model_name;

	@Name(Description = "Device_version")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtDeviceVersion']")
	public WebElement Device_version;

	@Name(Description = "Device_capacity")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtDeviceValue']")
	public WebElement Device_capacity;

	@Name(Description = "Add_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddModel']")
	public WebElement Add_button;

	@Name(Description = "Refresh_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnRefresh']")
	public WebElement Refresh_btn;

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
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnsubmit']")
	public WebElement Update_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//select[@id='ddlDeviceType']")
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
	@FindBy(xpath = "//div[@class='modal-body']//span[@Id='errorIsValidCompanyName']")
	public WebElement Validation_message;

	public Makemodel() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
