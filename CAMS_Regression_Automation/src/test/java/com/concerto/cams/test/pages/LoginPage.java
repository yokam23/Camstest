package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class LoginPage {

	@Name(Description = "WebElement to indicate homepage is loaded")
	@FindBy(xpath = "//strong[contains(text(),'Welcome to CAMSPlus')]")
	public WebElement LaunchIcon;
	

	@Name(Description = "UserName TextBox")
	@FindBy(id = "loginID")
	public WebElement UserName;

	@Name(Description = "Password TextBox")
	@FindBy(id = "Password")
	public WebElement Password;

	@Name(Description = "Login Button")
	@FindBy(id = "btnSubmit")
	public WebElement LoginButton;

	@Name(Description = "Error Message WhileLogging In")
	@FindBy(id = "divinvalid")
	public WebElement LoginError;
	
	@Name(Description = "Move to logout option")
	@FindBy(xpath = "//a[contains(@id,'ddlticketCount')]")
	public WebElement MoveToLogout;

	@Name(Description = "Move to Ins logout")
	@FindBy(xpath="//span[@class='username']")
	public WebElement InsLogoutoption;
	
	@Name(Description = "INS Logout")
	@FindBy(id="LinkButton1")
	public WebElement InsLogout;
	
	@Name(Description = "Logout option")
	@FindBy(xpath = "//a[text()='Log Out']")
	public WebElement Logout;

	@Name(Description = "Username for installation tool")
	@FindBy(id="txtLoginID")
	public WebElement InsUsername;
	
	@Name(Description = "Password for installation tool")
	@FindBy(id="txtPassword")
	public WebElement InsPassword;
	
	@Name(Description = "Password for installation tool")
	@FindBy(id="btnSign")
	public WebElement InsLoginBtn;
	
	@Name(Description = "Installation login page text")
	@FindBy(xpath="//strong[text()='Welcome to CAMSPlus Installation Tool']")
	public WebElement INSloginPageTxt;
	
	public LoginPage() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
