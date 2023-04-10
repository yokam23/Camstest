package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Networkprovider {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='Network Provider']")
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

	@Name(Description = "Agency_name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtAgencyName']")
	public WebElement Agency_name;

	@Name(Description = "Validation text")
	@FindBy(xpath = "//div[@class='modal-body']//p")
	public WebElement Validationtxt;
	
	@Name(Description = "Add_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddNetworkProvider']")
	public WebElement Add_button;

	@Name(Description = "Edit_button")
	@FindBy(xpath = "(//a[@name='Edit'])[1]")
	public WebElement Edit_button;

	@Name(Description = "Cancel_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Cancel_btn;

	@Name(Description = "AddCancel_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Cancel']")
	public WebElement AddCancel_btn;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Update']")
	public WebElement Update_btn;

	@Name(Description = "Delete_btn")
	@FindBy(xpath = "(//a[@name='Delete'])[1]")
	public WebElement Delete_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@placeholder='Search by Agency Name']")
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
	@FindBy(xpath = "//div[@class='modal-content']//span[@id='errorIsValidAgencyName']")
	public WebElement Validation_message;

	@Name(Description = "Agency Name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
    public WebElement AgencyName_txt;
	
	public Networkprovider() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
