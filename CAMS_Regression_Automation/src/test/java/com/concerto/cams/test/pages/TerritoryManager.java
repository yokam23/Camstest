package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class TerritoryManager {
	
	@Name(Description="Page Header")
	@FindBy(xpath="//h2[text()='Territory Manager']")
	public WebElement Page_Header;
	
	@Name(Description = "Add Territory Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Add New Territory Name']")
	public WebElement Add_Territory_Page_Header;

	@Name(Description = "Add Territory Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Add']")
	public WebElement Add_Page_Header;

	@Name(Description = "Edit Page Header")
	@FindBy(xpath = "//div[@class='modal-header']//h3[text()='Edit']")
	public WebElement Edit_Page_Header;

	@Name(Description = "Create_territory")
	@FindBy(id = "btnCreateTerritoryMaster")
	public WebElement Create_territory;

	@Name(Description = "Add_territory")
	@FindBy(xpath = "//a[@id='btnAddnewTerritory']//span[contains(text(),'Add New Territory')]")
	public WebElement Add_new_territory;

	@Name(Description = "territory_name")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtTerritoryName']")
	public WebElement territory_name;

	@Name(Description = "Add territory_name")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddterritoryname']")
	public WebElement Add_territory_name;

	@Name(Description = "Delete_territory_name")
	@FindBy(xpath = "(//div[@class='modal-body']//a[contains(@href,'DeleteTerritoryName')])")
	public WebElement Delete_territory_name;

	@Name(Description="Add New")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnaddTerritoryMaster']")
	public WebElement Add_new;

	@Name(Description = "Refresh_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnRefresh']")
	public WebElement Refresh_button;

	@Name(Description = "Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Cancel']")
	public WebElement Close_btn;

	@Name(Description = "Edit Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Edit_Closebtn;

	@Name(Description = "Add_territory")
	@FindBy(xpath = "//div[@class='modal-body']//select[@id='ddlTerritoryName']")
	public WebElement Add_territory;

	@Name(Description = "Territory_manager")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtTerritoryManager']")
	public WebElement Territory_manager;

	@Name(Description = "Mobile no")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtMobileNo']")
	public WebElement Mobile_no;

	@Name(Description = "Email id")
	@FindBy(xpath = "//div[@class='modal-body']//input[@id='txtEmailID']")
	public WebElement Email_id;

	@Name(Description = "Add_master_button")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='btnaddTerritoryMaster']")
	public WebElement Add_master_button;

	@Name(Description = "Cancel_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//input[@value='Cancel']")
	public WebElement Cancel_btn;

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
	@FindBy(xpath = "//input[@placeholder='Search by Territory Name Or Manager Name']")
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

	@Name(Description="Validation message")
	@FindBy(xpath="//div[@class='modal-content']//span[@id='errorIsValidAgencyName']")
	public WebElement Validation_message;
	
	@Name(Description = "Territory Name text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement Territoryname_txt;

	@Name(Description = "Territory Manager text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
	public WebElement TerritoryManagername_txt;

	@Name(Description = "Territory Mobile no text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[3]")
	public WebElement Phoneno_txt;

	@Name(Description = "Emailid text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[4]")
	public WebElement Emailid_txt;

	public TerritoryManager() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
