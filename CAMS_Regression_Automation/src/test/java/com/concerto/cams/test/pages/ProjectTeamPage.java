package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class ProjectTeamPage {
	
	@Name(Description="WebElement to indicate to Project Team page")
	@FindBy(xpath="//h2[contains(text(),'Project Team')]")
	public WebElement LaunchProjectTeamPage;
	
	@Name(Description="Search Project Team Textbox")
	@FindBy(xpath="//input[contains(@placeholder,'Search team members')]")
	public WebElement SearchProjectTeamPage;
	
	@Name(Description="Go Button")
	@FindBy(xpath ="//button[@value='cityMaster']") 
	public WebElement GoButton;
	
	//Add Team Member.
	
	@Name(Description="ADD Button")
	@FindBy(id="btnCreate")
	public WebElement AddButton;
	
	@Name(Description="WebElement to indicate AddTeam page is loaded")
	@FindBy(xpath="//h3[@class='modal-title']")
	public WebElement LaunchAddTeam;

	@Name(Description="Add Team Member name Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='MemberName']")
	public WebElement AddMemberName;
	
	@Name(Description="Add Role Dropdown")
	@FindBy(xpath="//div[@class='modal-body']//select[@id='Role']")
	public WebElement AddRole;
	
	@Name(Description="Add EmailID Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='EmailID']")
	public WebElement AddEmailID;
	
	@Name(Description="Add MobileNo Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='MobileNo']")
	public WebElement AddMobileNo;
	
	@Name(Description="ADD Team Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnadd']")
	public WebElement AddTeamButton;
	
	@Name(Description="Display Success message for Project team member")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement ProjectTeamSuccessMsg;
		
	
	@Name(Description="Close Button")
	@FindBy(xpath ="//div[@class='modal-footer']//input[@class='btn btn-warning']") 
	public WebElement CloseButton;
	
	// Update Team Member.
	
	@Name(Description="WebElement to indicate Edit Team page is loaded")
	@FindBy(xpath="//h3[@class='modal-title']")
	public WebElement LaunchEditTeam;

	@Name(Description="Edit Team Member name Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='MemberName']")
	public WebElement EditMemberName;
	
	@Name(Description="Edit Role Dropdown")
	@FindBy(xpath="//div[@class='modal-body']//select[@id='Role']")
	public WebElement EditRole;
	
	@Name(Description="Edit EmailID Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='EmailID']")
	public WebElement EditEmailID;
	
	@Name(Description="Edit MobileNo Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='MobileNo']")
	public WebElement EditMobileNo;
	
	@Name(Description="Update Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnUpdate']")
	public WebElement UpdateButton;
	
	@Name(Description="Display Success message for Project team member")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement UpdateProjectTeamSuccessMsg;
	
	@Name(Description = "Edit btn")
	@FindBy(xpath="(//a[@name='Edit'])[1]")
	public WebElement Editbtn;
	
	@Name(Description="Close Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Close']")
	public WebElement CloseBtn;

	@Name(Description="Delete Button")
	@FindBy(xpath="//tbody/tr[1]/td[6]/a[1]")
	public WebElement DeleteButton;
	
	public ProjectTeamPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
	
}






