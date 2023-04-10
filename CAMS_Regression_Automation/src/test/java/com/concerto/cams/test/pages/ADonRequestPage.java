package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class ADonRequestPage {

	@Name(Description="WebElement to indicate to AD on Request Page")
	@FindBy(xpath="//h2[contains(text(),'AD on Request')]")
	public WebElement LaunchADonRequestPage;


	@Name(Description="Select Client name Dropdown of AD on Request")
	@FindBy(id="ddlClientID")
	public WebElement SelectClientNameDD;

	@Name(Description="Select Panel ID Textbox of AD on Request")
	@FindBy(id="txtPanelID")
	public WebElement SelectPanelIDText;

	@Name(Description="Select Frame Frequency Textbox")
	@FindBy(id="ddlFrameFrequency")
	public WebElement SelectFramefrequencyText;
	
	@Name(Description="Select  Camera number dropdown")
	@FindBy(id="ddlCameraNo")
	public WebElement SelectCameraNo;

	@Name(Description="Select Start Date calendar dropdown")
	@FindBy(id="txtStartDate")
	public WebElement StartDateCal;

	@Name(Description="Select Start Time")
	@FindBy(id="txtStartTime")
	public WebElement StartTime;
	
	@Name(Description="Select End Time")
	@FindBy(id="txtEndTime")
	public WebElement EndTime;

	@Name(Description="Search AD on Request button")
	@FindBy(id="btnADrequest")
	public WebElement SearchADReuqestBtn;

	@Name(Description="Refresh Button ")
	@FindBy(xpath="//input[@class='btn btn-warning']")
	public WebElement RefreshButton;
	

	
	
	public ADonRequestPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}	
	
}
