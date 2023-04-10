package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class HKMonitoring {
	
	@Name(Description="HK Monitoring page Header")
	@FindBy(xpath="//h2[text()='Pool Monitoring ']")
	public WebElement MonitoringHeader;
	
	@Name(Description = "Date field")
	@FindBy(xpath="//input[@id='ImageDate']")
	public WebElement datefield;
	
	@Name(Description="Search record")
	@FindBy(xpath="//input[@id='btnSearch']")
	public WebElement SearchRecord;
	
	@Name(Description="ClientName")
	@FindBy(xpath="//select[@id='ddlClientID']")
	public WebElement ClientName;
	
	@Name(Description="Pool")
	@FindBy(xpath="//select[@id='ddlPoolID']")
	public WebElement Pool;
	
	@Name(Description="Scheduler")
	@FindBy(xpath="//select[@id='ddlScheduleID']")
	public WebElement Scheduler;
	
	@Name(Description="Get validation message for Client field")
	@FindBy(xpath="//span[@id='RequiredClientID']")
	public WebElement GetClientFieldValidation;
	
	@Name(Description="Get validation message for Pool field")
	@FindBy(xpath="//span[@id='RequiredPoolID']")
	public WebElement GetPoolFieldValidation;
	
	@Name(Description="Get monitoring record count")
	@FindBy(xpath="//div[@class='pull-right']")
	public WebElement TotalImageCount;
	
	@Name(Description="Get validation message for Scheduler field")
	@FindBy(xpath="//span[@id='RequiredScheduleID']")
	public WebElement GetSchedulerFieldValidation;
	
	@Name(Description ="Monitoring page message")
    @FindBy(xpath="//div[contains(text(),' Image capturing is in process, please wait till schedule time...')]")
	public WebElement MonitoringMsg;
	
	@Name(Description="StatusSubmit")
	@FindBy(xpath="//button[@id='SubmitData']")
	public WebElement Submitstatus;
	
	@Name(Description="Images per page")
	@FindBy(xpath="//select[@id='ddlImgPerPage']")
	public WebElement ImagesPerPage;
	
	@Name(Description="Reset button")
	@FindBy(xpath="//input[@id='reset']")
	public WebElement ResetBtn;
	
	@Name(Description="Submit status message")
	@FindBy(xpath="//strong[contains(text(),'Data has been monitored and submitted for selected')]")
	public WebElement SubmitStatusMsg;
	
	@Name(Description="Monitoring message")
	@FindBy(xpath="//div[text()='Data has been submitted ']")
	public WebElement MonitoringMessage;
	
	@Name(Description="Error Monitoring message")
	@FindBy(xpath="//div[text()='No images found']")
	public WebElement ErrorMessage;
	
	//div[contains(@class,'col-md-3')]//div
	
	public HKMonitoring() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}


}
