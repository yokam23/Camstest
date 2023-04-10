package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class HkPool {
	
	@Name(Description="Page Header")
	@FindBy(xpath="//div[@class='col-md-7']//h2[text()='Pool']")
	public WebElement Page_Header;
	
	@Name(Description="Search text")
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement Search_option;
	
	@Name(Description="Search Go option")
	@FindBy(xpath="//button[text()='Go']")
	public WebElement Go_option;
	
	@Name(Description ="Add button")
	@FindBy(id="btnCreate")
	public WebElement Addpoolbtn;
	
	@Name(Description="Add page header")
	@FindBy(xpath="//div[@class='modal-header']//h3[text()='Add Pool']")
    public WebElement Add_page_header;
	
	@Name(Description="Edit page header")
	@FindBy(xpath="//div[@class='modal-header']//h3[text()='Edit Pool']")
    public WebElement Edit_page_header;
	
	@Name(Description="Client selection")
	@FindBy(xpath="//div[@class='modal-body']//select[@id='ClientID']")
	public WebElement SelectClient;
	
	@Name(Description="Pool name")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='PoolName']")
	public WebElement PoolName;
	
	@Name(Description="Add pool btn")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnadd']")
	public WebElement NewPoolAdd;
	
	@Name(Description="Close add page")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Close']")
	public WebElement CloseBtn;
	
	@Name(Description="Update button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Update']")
	public WebElement Updatebtn;
	
	@Name(Description="Validate Duplicate record")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement ValidateDuplicates;
	
	@Name(Description="Validate successful message")
	@FindBy(xpath="//strong[contains(text(),'Pool added successfully')]")
	public WebElement SuccessfulMsg;
	
	@Name(Description="Delete message")
	@FindBy(xpath="//strong[contains(text(),'Pool has been deleted successfully')]")
	public WebElement DeleteMsg;
	
	@Name(Description="Update message")
	@FindBy(xpath="//strong[contains(text(),'Pool updated successfully')]")
	public WebElement UpdateMsg;
	
	@Name(Description="Get validation for Add pool")
	@FindBy(xpath="//div[@class='modal-body']//span[text()='Pool is required']")
	public WebElement AddPoolValidation;
	
	@Name(Description="Records count")
	@FindBy(xpath="//div[@class='pull-right']")
	public WebElement RecordCount;
	
	@Name(Description="Delete validation message")
	@FindBy(xpath="//strong[contains(text(),'Sites should be deallocated before deleting Pool.')]")
	public WebElement Deletevalidation;
	
	@Name(Description="Validate Client name")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement ValidateClientName;
	
	@Name(Description="Validate Pool Name")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
	public WebElement ValidatePoolName;
	
	@Name(Description="Edit button")
	@FindBy(xpath="(//a[@name='Edit'])[1]")
	public WebElement EditBtn;
	
	@Name(Description="Delete button")
	@FindBy(xpath="(//a[@name='Delete'])[1]")
	public WebElement DeleteBtn;
	
	public HkPool() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}


}
