package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Escalation {
	
	@Name(Description="Page Header")
	@FindBy(xpath="//h2[text()='Escalation Master']")
	public WebElement Page_Header;
	
	@Name(Description = "Escalation page header")
	@FindBy(xpath="//h2[text()='Add New Escalation']")
	public WebElement Escalation_Page_Header;

	@Name(Description = "Template_name")
	@FindBy(id = "ddlEscTemplate")
	public WebElement Template_name;

	@Name(Description = "Add_btn")
	@FindBy(id = "btnCreate")
	public WebElement Add_btn;

	@Name(Description = "Name")
	@FindBy(id = "txtcontactperson1")
	public WebElement Name;
	
	@Name(Description = "Edit name")
	@FindBy(xpath = "//input[@name='[0].Contact_Person']")
	public WebElement Edit_name;

	@Name(Description = "Comment")
	@FindBy(xpath = "//input[@name='[0].Comments']")
	public WebElement Comment;

	@Name(Description = "Telephone_no")
	@FindBy(xpath = "//input[@id='txtTelno1']")
	public WebElement Telephone_no;

	@Name(Description = "SMS")
	@FindBy(xpath = "//input[@id='chksms1']")
	public WebElement sms;

	@Name(Description = "Mobile_no")
	@FindBy(xpath = "//input[@id='txtcellno1']")
	public WebElement Mobile_no;

	@Name(Description = "Email_checkbox")
	@FindBy(xpath = "//input[@id='chkemail1']")
	public WebElement Email_checkbox;

	@Name(Description = "Email")
	@FindBy(xpath = "//input[@id='txtemail1']")
	public WebElement Email;
	
	@Name(Description ="Edit email")
	@FindBy(xpath = "//input[@name='[0].EmailID']")
	public WebElement Edit_email;

	@Name(Description = "Priority")
	@FindBy(xpath = "//select[@id='ddlPriority-1']")
	public WebElement Priority;
	
	@Name(Description = "Edit priority")
	@FindBy(xpath = "//select[@name='[0].Priority']")
	public WebElement Edit_priority;

	@Name(Description = "Interval")
	@FindBy(xpath = "//select[@id='ddlInterval1']")
	public WebElement Interval;

	@Name(Description = "Repeat_Interval")
	@FindBy(xpath = "//select[@id='ddlRepeatInterval1']")
	public WebElement Repeat_Interval;
	
	@Name(Description = "Edit repeat interval")
	@FindBy(xpath ="//select[@name='[0].RepeatInterval']")
	public WebElement Edit_repeat_interval;

	@Name(Description = "Add_esc")
	@FindBy(xpath = "//input[@id='btnAddnewtemplate']")
	public WebElement Add_esc;
	
	@Name(Description = "Update btn")
	@FindBy(xpath = "//input[@id='btnupdate']")
	public WebElement Update_btn;

	@Name(Description = "Refresh_btn")
	@FindBy(xpath = "//input[@id='btnRefresh']")
	public WebElement Refresh_btn;

	@Name(Description = "Delete btn")
	@FindBy(id = "btnDelete")
	public WebElement deletebutton;
	
	@Name(Description = "Cancel_btn")
	@FindBy(xpath = "//input[contains(@class,'btn-warning')]")
	public WebElement Cancel_btn;

	@Name(Description = "Template_name_search")
	@FindBy(xpath = "//input[@id='TemplateName']")
	public WebElement Template_name_search;

	public Escalation() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
