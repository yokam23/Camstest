package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.concerto.annotations.Name;

public class OfficeMonitoringDashboard {
	

	@Name(Description="WebElement to indicate to Office Monitoring Dashboard page")
	@FindBy(xpath="//span[@id='ContentPlaceHolder1_lblBank']")
	public WebElement LaunchOfficeMonitoringDashboardPage;
	
	@Name(Description="Select client dropdown")
	@FindBy(xpath="//select[@id='ddlSiteID1']")
	public WebElement SelectCleintDropdown;

	@Name(Description="Select Category dropdown")
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_ddlCategory']")
	public WebElement SelectCategoryDropdown;
	
	@Name(Description="Select Location dropdown")
	@FindBy(xpath="//select[@id='ddlLocation']")
	public WebElement SelectLocationDropdown;
	
	@Name(Description="Select Indicator dropdown")
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_ddlIndicator']")
	public WebElement SelectIndicatorDropdown;
	
	@Name(Description="Select Year dropdown")
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_ddlYear']")
	public WebElement SelectYearDropdown;
	
	@Name(Description="Select Month dropdown")
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_ddlMonth']")
	public WebElement SelectMonthDropdown;
	
	@Name(Description="Select Generate Button")
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_btnGenerate']")
	public WebElement SelectGenerateButton;
}
