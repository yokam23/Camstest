package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Users {
	
	@Name(Description="AddUserbtn")
	@FindBy(xpath="//a[@Id='btnCreate']")
    public WebElement Adduserbtn;
	
	@Name(Description="Add user page Header")
	@FindBy(xpath="//h2[contains(text(),'Add User')]")
	public WebElement Adduserheader;
	
	@Name(Description="UserName")
	@FindBy(xpath="//input[@id='txtUserName']")
	public WebElement Username;
	
	@Name(Description="Usertype")
	@FindBy(xpath="//select[@id='ddlUserType']")
	public WebElement Usertype;
	
	@Name(Description="Shift")
	@FindBy(xpath="//select[@id='ddlshift']")
	public WebElement Shift;
	
	@Name(Description="Address")
	@FindBy(xpath="//input[@id='txtAddress']")
	public WebElement Address;
	
	@Name(Description="MobileNo")
	@FindBy(xpath="//input[@id='txtMobileNo']")
	public WebElement MobileNo;
	
	@Name(Description="Emailid")
	@FindBy(xpath="//input[@id='txtEmailID']")
	public WebElement Emailid;
	
	@Name(Description="StateName")
	@FindBy(xpath="//select[@id='ddlstate']")
	public WebElement StateName;
	
	@Name(Description="CityName")
	@FindBy(xpath="//select[@id='ddlCity']")
	public WebElement CityName;
	
	@Name(Description="Pincode")
	@FindBy(xpath="//input[@id='txtPincode']")
	public WebElement Pincode;
	
	@Name(Description="Loginid")
	@FindBy(xpath="//input[@id='txtULoginID']")
	public WebElement Loginid;
	
	@Name(Description="Password")
	@FindBy(xpath="//input[@id='txtUserPassword']")
	public WebElement Password;
	
	@Name(Description="ConfirmPassword")
	@FindBy(xpath="//input[@id='txtconfirmpassword']")
	public WebElement ConfirmPassword;
	
	@Name(Description="OldPassword")
	@FindBy(xpath="//div[@class='panel-body']//input[@id='OldPassword']")
	public WebElement OldPassword;
	
	@Name(Description="NewPassword")
	@FindBy(xpath="//div[@class='panel-body']//input[@id='NewPassword']")
	public WebElement NewPassword;
	
	@Name(Description="ConfirmnewPassword")
	@FindBy(xpath="//div[@class='panel-body']//input[@id='ConfirmPassword']")
	public WebElement ConfirmNewPassword;
	
	@Name(Description="Change password header")
	@FindBy(xpath="//div[contains(text(),'Changed Password')]")
	public WebElement Pageheader;
	
	@Name(Description="Submit btn")
	@FindBy(xpath="//button[@id='btnChange']")
	public WebElement Submitbtn;
	
	@Name(Description="Addbtn")
	@FindBy(xpath="//input[@id='btnadduser']")
	public WebElement Addbtn;
	
	@Name(Description="AssignCircle")
	@FindBy(xpath="//a[@id='btncirclelist']")
	public WebElement AssignCircle;
	
	@Name(Description="AssignCircleHeader")
	@FindBy(xpath="//h3[@class='modal-title']")
	public WebElement AssignCircleHeader;
	
	@Name(Description="CircleList")
	@FindBy(xpath="//div[@class='modal-body']")
	public WebElement CircleList;
	
	@Name(Description="Save btn")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnfinish']")
	public WebElement Savebtn;
	
	@Name(Description="Close btn")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Close']")
	public WebElement Closebtn;
	
	@Name(Description="ClientName")
	@FindBy(xpath="//select[@id='ddlClients']")
	public WebElement Clientname;
	
	@Name(Description="Chartcheckbox")
	@FindBy(xpath="//input[@id='ChkDashboardBool']")
	public WebElement Chartcheckbox;
	
	@Name(Description="Reportcheckbox")
	@FindBy(xpath="//input[@id='ChkReportsBool']")
	public WebElement Reportcheckbox;
	
	@Name(Description="Liveviewcheckbox")
	@FindBy(xpath="//input[@id='ChkImageBool']")
	public WebElement Liveviewcheckbox;
	
	@Name(Description="Success message")
	@FindBy(xpath="//div[@class='modal-body']//div[@id='divSuccessfullnoticecircle']")
	public WebElement Successmsg;
	
	public Users()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
