package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Shift {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='Shift Master']")
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

	@Name(Description = "Shift")
	@FindBy(xpath = "//div[@class='modal-body']//input[@Id='ShiftName']")
	public WebElement Shift;

	@Name(Description = "TimeFrom")
	@FindBy(xpath = "//div[@class='modal-body']//input[@Id='TimeFrom']")
	public WebElement TimeFrom;

	@Name(Description = "TimeTo")
	@FindBy(xpath = "//div[@class='modal-body']//input[@Id='TimeTo']")
	public WebElement TimeTo;

	@Name(Description = "Create_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddShift']")
	public WebElement Create_button;

	@Name(Description = "Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Close_btn;

	@Name(Description = "Cancel_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Cancel']")
	public WebElement Cancel_btn;

	@Name(Description = "Edit_btn")
	@FindBy(xpath = "(//a[@data-original-title='Edit'])[1]")
	public WebElement Edit_btn;

	@Name(Description = "Delete_btn")
	@FindBy(xpath = "(//div[@class='table-responsive']//td[6]//a)[1]")
	public WebElement Delete_btn;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Update']")
	public WebElement Update_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@placeholder='Search by model and company']")
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
	
	@Name(Description = "Validation message")
	@FindBy(xpath ="//div[@class='modal-content']//div[@class='validation-summary-errors']//ul//li[1]")
	public WebElement Validation_message;

    @Name(Description = "Shift name text")
    @FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
    public WebElement Shift_txt;
    
    
    @Name(Description = "Time from text")
    @FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
    public WebElement TimeFrom_txt;
    
    @Name(Description = "Time To text")
    @FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[3]")
    public WebElement TimeTo_txt;
    
	public Shift() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
