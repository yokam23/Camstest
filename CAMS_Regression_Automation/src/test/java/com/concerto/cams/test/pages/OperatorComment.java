package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class OperatorComment {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//h2[text()='Operator Comments']")
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

	@Name(Description = "Add comment")
	@FindBy(xpath = "//div[@class='modal-footer']//div//input[@id='btnaddComment']")
	public WebElement Add_Cmt;

	@Name(Description = "Refresh comment")
	@FindBy(xpath = "//div[@class='modal-footer']//div//input[@id='btnRefresh']")
	public WebElement Refresh_btn;

	@Name(Description = "Close_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//div//input[@value='Close']")
	public WebElement Close_btn;

	@Name(Description = "Comment")
	@FindBy(xpath = "//div[@class='modal-body']//div//input[@id='txtUserComments']")
	public WebElement comment;

	@Name(Description = "CommentTXT")
	@FindBy(xpath = "//p[@class='mandatory']")
	public WebElement commenttxt;

	
	@Name(Description = "Edit btn")
	@FindBy(xpath = "(//a[@name='Edit'])[1]")
	public WebElement Edit_btn;

	@Name(Description = "Delete btn")
	@FindBy(xpath = "(//a[@name='Delete'])[1]")
	public WebElement Delete_btn;

	@Name(Description = "Closure cmt")
	@FindBy(xpath = "//a[contains(text(),'Closure Comments')]")
	public WebElement closure_cmt;

	@Name(Description = "Reopen cmt")
	@FindBy(xpath = "//a[contains(text(),'Reopen Comments')]")
	public WebElement Reopen_cmt;

	@Name(Description = "Update_btn")
	@FindBy(xpath = "//div[@class='modal-footer']//div//input[@id='btnUpdate']")
	public WebElement Update_btn;

	@Name(Description = "Search_option")
	@FindBy(xpath = "//input[@id='txtfilter']")
	public WebElement Search_option;

	@Name(Description = "Go_button")
	@FindBy(xpath = "//a[text()='Go']")
	public WebElement Go_button;

	@Name(Description = "Validation message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Successfull_message;

	@Name(Description = "Error message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement Error_message;

	@Name(Description = "Update message")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement Update_message;

	@Name(Description = "Validation message for User comment")
	@FindBy(xpath = "//div[@class='modal-body']//span[@id='errorInValidUserComments']")
	public WebElement Validation_usercmt;

	@Name(Description = "Validation message for Closure comment")
	@FindBy(xpath = "//div[@class='modal-body']//span[@id='errorInValidUserComments']")
	public WebElement Validation_Closurecmt;

	@Name(Description = "Validation message for Reopen comment")
	@FindBy(xpath = "//div[@class='modal-body']//span[@id='errorInValidUserComments']")
	public WebElement Validation_Reopencmt;

	@Name(Description = "User comment text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement Usercmt_text;
	
	@Name(Description = "Closure text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement Closure_txt;
	
	@Name(Description = "Reopen text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement Reopen_txt;

	public OperatorComment() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
