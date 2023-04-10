package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class City {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='City Master']")
	public WebElement Page_Header;

	@Name(Description = "Add Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Add']")
	public WebElement Add_Page_Header;

	@Name(Description = "Edit Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Edit City Master']")
	public WebElement Edit_Page_Header;

	@Name(Description = "Add city")
	@FindBy(xpath = "//a[@id='btnCreate']")
	public WebElement Add_City;

	@Name(Description = "Add_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddcity']")
	public WebElement Add_btn;

	@Name(Description = "Cancel_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Cancel_btn;

	@Name(Description = "Edit_btn")
	@FindBy(xpath = "//a[@data-original-title='Edit']")
	public WebElement Edit_btn;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[contains(@class,'btn-success')]")
	public WebElement Update_btn;

	@Name(Description = "Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//a[text()='Cancel']")
	public WebElement Close_btn;

	@Name(Description = "statename")
	@FindBy(xpath = "//div[@class='modal-body']//select[@id='StateName']")
	public WebElement statename;
	
	@Name(Description = "EditStateName")
    @FindBy(xpath ="//div[@class='modal-body']//select[@id='statename']")
	public WebElement EditStateName;
	
	@Name(Description = "cityname")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='CityName']")
	public WebElement cityname;

	@Name(Description = "Delete_btn")
	@FindBy(xpath = "(//a[@name='Delete'])[1]")
	public WebElement Delete_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@placeholder='Search by city or state name']")
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
	
	@Name(Description = "Update message")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Update_message;
	
	@Name(Description = "Validation message")
	@FindBy(xpath = "//div[@class='modal-body']//span[@id='errorInValidCityName']")
	public WebElement Validation_message;
	
	@Name(Description = "Text of City")
	@FindBy(xpath="(//div[@class='table-responsive']//table//tbody//td)[1]")
	public WebElement City_text;
	
	@Name(Description = "Text of State")
	@FindBy(xpath="(//div[@class='table-responsive']//table//tbody//td)[2]")
	public WebElement State_text;
	
	

	public City() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
