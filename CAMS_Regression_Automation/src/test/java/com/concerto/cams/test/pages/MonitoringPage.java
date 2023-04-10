package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class MonitoringPage {
	@Name(Description="WebElement to indicate to Monitoring Page")
	@FindBy(xpath="//h2[contains(text(),'Monitoring')]")
	public WebElement LaunchMonitoringPage;

	@Name(Description="Monitoring type Scheduled radio button")
	@FindBy(xpath="//input[@id='rdoSchedule']")
	public WebElement MonitoringTypeScheduleRadioButn;
	
	@Name(Description="Monitoring type Latest radio button")
	@FindBy(xpath="//input[@id='rdoLatest']")
	public WebElement MonitoringTypeLatestRadioButn;

	@Name(Description="Select Client DropDown")
	@FindBy(xpath="//select[@id='ddlClientID']")
	public WebElement SelectClientDropDown;

	@Name(Description="Select Site ID DropDown")
	@FindBy(xpath="//select[@id='ddlSiteID']")
	public WebElement SelectSiteIDDropDown;

	@Name(Description="Select Location DropDown")
	@FindBy(xpath="//select[@id='ddlLocationList']")
	public WebElement SelectLocationDropDown;

	@Name(Description="Select Date Textbox")
	@FindBy(xpath="//input[@id='txtDate']")
	public WebElement SelectDateTextbox;

	@Name(Description="Select Time Slot DropDown")
	@FindBy(xpath="//select[@id='ddlScheduleTime']")
	public WebElement SelectTimeSlotDropDown;

	@Name(Description="WebElement to indicate to Images Page")
	@FindBy(xpath="//h2[contains(text(),'Images')]")
	public WebElement LaunchImagesPage;

    @Name(Description="Status drop down")
	@FindBy(xpath="//select[@name='ChecklistStatus']")
    public WebElement Statusdropdown;
    
    @Name(Description="Remark text box")
	@FindBy(xpath="//input[@class='form-control']")
    public WebElement Remark;
   
	@Name(Description="Monitoring View Button")
	@FindBy(xpath="//input[@id='btnView']")
	public WebElement MonitoringViewButton;

	@Name(Description="LiveImages Header")
	@FindBy(xpath="//h2[text()='Images']")
	public WebElement Liveimageheader;
	
	@Name(Description="Monitoring Reset Button")
	@FindBy(xpath="//input[@id='btnReset']")
	public WebElement MonitoringResetButton;
	
	@Name(Description="Comment")
	@FindBy(xpath="//textarea[@id='txtMonitoringComment']")
	public WebElement Comment;
	// Monitoring Items page 
	
	@Name(Description="Submit status")
	@FindBy(xpath="//input[@id='btnSubmit']")
	public WebElement btnsubmit;
	
	

	@Name(Description="SuccessMsg")
	@FindBy(xpath="//strong[contains(text(),'Feedback submitted sucessfully')]")
	public WebElement SuccessMsg;
	
		@Name(Description="WebElement to indicate to Monitoring Items Page")
		@FindBy(xpath="//h2[contains(text(),'Monitoring Items')]")
		public WebElement LaunchMonitoringItemsPage;
	
		@Name(Description="Select category Dropdown")
		@FindBy(xpath="//select[@id='ddlChecklistCategory']")
		public WebElement SelectMonitoringCategoryDropdown;
		
		@Name(Description="Select Indicator Proirity Dropdown")
		@FindBy(xpath="//select[@id='ddlChecklistPriority-1']")
		public WebElement SelectIndicatorProirityDropdown;
		
		@Name(Description="Select Indicator Status Dropdown")
		@FindBy(xpath="//select[@id='ddlChecklistStatus-1']")
		public WebElement SelectIndicatorStatusDropdown;
		
		@Name(Description="Select Indicator Remarks Dropdown")
		@FindBy(xpath="//input[@id='txtCheckedComments1']")
		public WebElement SelectIndicatorRemarksDropdown;
		
		@Name(Description="Select Indicator Remarks Dropdown")
		@FindBy(xpath="//textarea[@id='txtMonitoringComment']")
		public WebElement SelectIndicatorCommentDropdown;
		
		@Name(Description="Select Indicator Remarks Dropdown")
		@FindBy(xpath="//input[@id='btnSubmit']")
		public WebElement MonitoringItemsSubmitButton;
	
		public MonitoringPage() {
			PageFactory.initElements(DriverManager.getWebDriver(), this);
		}
		


}
