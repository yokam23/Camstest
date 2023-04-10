package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class NationalHoliday {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='National Holiday']")
	public WebElement Page_Header;
	
	@Name(Description = "Add Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h4[text()='Add']")
	public WebElement Add_Page_Header;

	@Name(Description = "Edit Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h4[text()='Edit']")
	public WebElement Edit_Page_Header;

	@Name(Description = "Addbtn")
	@FindBy(xpath = "//a[@id='btnCreate']")
	public WebElement Addbtn;

	@Name(Description = "Add_holiday")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnAdd']")
	public WebElement Add_holiday;

	@Name(Description = "Refreshbtn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnRefresh']")
	public WebElement Refreshbtn;

	@Name(Description = "Holiday_Name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtHDName']")
	public WebElement Holiday_Name;

	@Name(Description = "Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Close_btn;

	@Name(Description = "Date_selection")
	@FindBy(xpath = "//div[@class='modal-body']//div[@class='col-md-12']//input[@id='datepicker']")
	public WebElement Date_select;

	@Name(Description = "Delete_btn")
	@FindBy(xpath = "(//a[@name='Delete'])[1]")
	public WebElement Delete_btn;

	@Name(Description = "Edit_btn")
	@FindBy(xpath = "(//a[@name='Edit'])[1]")
	public WebElement Edit_btn;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[contains(@class,'btn-success')]")
	public WebElement Update_btn;
	
	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@placeholder='Search by Holiday Name']")
	public WebElement Search_option;

	@Name(Description = "Go_button")
	@FindBy(xpath = "//button[text()='Go']")
	public WebElement Go_button;
	
	@Name(Description = "Validation message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Successfull_message;

	@Name(Description = "Error message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement Error_message;

	@Name(Description = "Update message")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Update_message;
	
	@Name(Description = "Validation message for Holiday name field")
	@FindBy(xpath="//div[@class='modal-body']//span[@id='errorIsValidHolidayName']")
	public WebElement Validation_HolidayName;
	
	@Name(Description = "Validation message for Date field")
	@FindBy(xpath="//div[@class='modal-body']//span[@id='errorIsValidDate']")
	public WebElement Validation_DateField;

	
	@Name(Description = "National holiday text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement NationalHoliday_text;
	
	@Name(Description = "Date text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
	public WebElement Date_text;
	
	public NationalHoliday() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
