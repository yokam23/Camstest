package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class PanelServiceVendor {
	
	@Name(Description="Page Header")
	@FindBy(xpath="//h2[text()='Panel Service Vendor']")
	public WebElement Page_Header;
	
	@Name(Description = "Add Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Add']")
	public WebElement Add_Page_Header;

	@Name(Description = "Edit Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Edit ']")
	public WebElement Edit_Page_Header;

	@Name(Description = "Add_btn")
	@FindBy(xpath = "//a[@id='btnCreate']")
	public WebElement Add_btn;

	@Name(Description = "Company name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtCompanyName']")
	public WebElement Company_name;

	@Name(Description = "Company Address")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtCompanyAddress']")
	public WebElement Company_address;

	@Name(Description = "State")
	@FindBy(xpath = "//div[@class='modal-body']//select[@id='ddlState']")
	public WebElement State;

	@Name(Description = "City")
	@FindBy(xpath = "//div[@class='modal-body']//select[@id='ddlCity']")
	public WebElement City;

	@Name(Description = "Pin_code")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtPinCode']")
	public WebElement Pin_code;

	@Name(Description = "Contact_person_name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtContactPerson']")
	public WebElement Contact_person_name;

	@Name(Description = "Phone_no")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtPhoneNo']")
	public WebElement Phone_no;

	@Name(Description = "Mobile_no")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtMobileNo']")
	public WebElement Mobile_no;

	@Name(Description = "Email_id")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtEmailID']")
	public WebElement Email_id;

	@Name(Description = "Add_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddPanelServiceVendor']")
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
	@FindBy(xpath = "//input[@placeholder='Search by Company Name or Address']")
	public WebElement Search_option;

	@Name(Description = "Go_button")
	@FindBy(xpath = "//button[text()='Go']")
	public WebElement Go_button;
	
	@Name(Description = "Succesfull message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Successfull_message;

	@Name(Description = "Error message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement Error_message;

	@Name(Description = "Validation for Phone field")
	@FindBy(xpath = "//div[@class='modal-body']//span[@Id='errorIsValidPhoneNo']")
	public WebElement Validation_PhoneField;

	@Name(Description = "Validation for Mobile field")
	@FindBy(xpath = "//div[@class='modal-body']//span[@Id='errorIsValidMobileNo']")
	public WebElement Validation_MobileField;
	
	@Name(Description = "Validation for Email field")
	@FindBy(xpath = "//div[@class='modal-body']//span[@Id='errorIsValidEmailID']")
	public WebElement Validation_EmailField;
	
	@Name(Description = "Company name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
    public WebElement CompanyName_txt;
	
	@Name(Description = "State name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[3]")
    public WebElement State_txt;
	
	@Name(Description = "City name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[4]")
    public WebElement City_txt;
	
	@Name(Description = "Address name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
    public WebElement Address_txt;
	
	@Name(Description = "Contact name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[5]")
    public WebElement ContactPerson_txt;
	
	@Name(Description = "Phone no text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[6]")
    public WebElement Phoneno_txt;
	
	@Name(Description="Mobile no text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[7]")
    public WebElement Mobile_txt;
	
	@Name(Description="Emailid text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[8]")
    public WebElement Emailid_txt;
	


	public PanelServiceVendor() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
