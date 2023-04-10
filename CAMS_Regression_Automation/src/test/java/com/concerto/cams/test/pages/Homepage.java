package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class Homepage {

	@Name(Description = "Homepage logo")
	@FindBy(xpath = "//a[@class='navbar-brand']//img")
	public WebElement logoimage;

	@Name(Description = "Master")
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Master')]")
	public WebElement Master;
	
	@Name(Description="HouseKeeping")
	@FindBy(xpath="//a[contains(text(),'House Keeping')]")
	public WebElement HouseKeeping;
	
	@Name(Description="BrandHygiene")
    @FindBy(xpath="//a[contains(text(),'Brand Hygiene')]")
	public WebElement BrandHygiene;
	
	@Name(Description = "Alarm Monitoring")
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Alarm Monitoring')]")
	public WebElement AlarmMonitoring;

	@Name(Description="Camera location")
	@FindBy(xpath="//a[text()='Camera Location']")
	public WebElement CameraLocationPage;
	
	@Name(Description="Surveillance Indicators")
	@FindBy(xpath="//a[text()='Surveillance Indicators']")
	public WebElement SurveillanceIndicatorsPage;
	
	@Name(Description="Site Configuration")
	@FindBy(xpath="//a[text()='Site Configuration']")
	public WebElement SiteConfigurationPage;
	
	@Name(Description="Monitoring")
	@FindBy(xpath="//a[text()='Monitoring']")
	public WebElement MonitoringPage;
	
	@Name(Description="Reports")
	@FindBy(xpath="(//a[text()='Reports'])[2]")
	public WebElement OfficeMonitoringReportPage;
	
	@Name(Description="Dashboard")
	@FindBy(xpath="//a[text()='Dashboard']")
	public WebElement OfficeMonitoringDashboardPage;
	
	@Name(Description = "Configuration")
	@FindBy(xpath = "//a[contains(text(),'Configuration')]")
	public WebElement Configuration;

	@Name(Description = "Monitoring")
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Monitoring')]")
	public WebElement Monitoring;

	@Name(Description = "Administrator")
	@FindBy(xpath = "//a[contains(text(),'Administrator')]")
	public WebElement Administrator;

	@Name(Description = "City")
	@FindBy(xpath = "//a[text()='City']")
	public WebElement City;

	@Name(Description = "Circles")
	@FindBy(xpath = "//a[text()='Circles']")
	public WebElement Circles;

	@Name(Description = "National Holiday")
	@FindBy(xpath = "//a[text()='National Holiday']")
	public WebElement National_Holiday;

	@Name(Description = "Operator comments")
	@FindBy(xpath = "//a[text()='Operator Comments']")
	public WebElement Operator_comments;

	@Name(Description = "Sensors")
	@FindBy(xpath = "//a[text()='Sensors']")
	public WebElement Sensors;

	@Name(Description = "Manufacturer")
	@FindBy(xpath = "//a[text()='Manufacturer']")
	public WebElement Manufacturer;

	@Name(Description = "Make Model")
	@FindBy(xpath = "//a[text()='Make Model']")
	public WebElement Make_model;

	@Name(Description = "Dispatch Vendor")
	@FindBy(xpath = "//a[text()='Dispatch Vendor']")
	public WebElement Dispatch_Vendor;

	@Name(Description = "Panel service Vendor")
	@FindBy(xpath = "//a[text()='Panel Service Vendor']")
	public WebElement Panel_service_vendor;

	@Name(Description = "Shift")
	@FindBy(xpath = "//a[text()='Shift']")
	public WebElement Shift;

	@Name(Description = "HK Agency")
	@FindBy(xpath = "//a[text()='HK Agency']")
	public WebElement HK_Agency;

	@Name(Description = "CRA Agency")
	@FindBy(xpath = "//a[text()='CRA Agency']")
	public WebElement CRA_Agency;

	@Name(Description = "MSP Agency")
	@FindBy(xpath = "//a[text()='MSP Agency']")
	public WebElement MSP_Agency;

	@Name(Description = "QRT Agency")
	@FindBy(xpath = "//a[text()='QRT Agency']")
	public WebElement QRT_Agency;

	@Name(Description = "Network Provider")
	@FindBy(xpath = "//a[text()='Network Provider']")
	public WebElement Network_Provider;

	@Name(Description = "Installation vendor")
	@FindBy(xpath = "//a[text()='Installation Vendor']")
	public WebElement Installation_Vendor;

	@Name(Description = "Territory Manager")
	@FindBy(xpath = "//a[text()='Territory Manager']")
	public WebElement Territory_Manager;

	@Name(Description = "Escalation")
	@FindBy(xpath = "//a[text()='Escalation']")
	public WebElement Escalation;

	@Name(Description = "Service partner")
	@FindBy(xpath = "//a[text()='Service Partner']")
	public WebElement Service_partner;

	@Name(Description = "Subscription")
	@FindBy(xpath = "//a[text()='Subscription']")
	public WebElement Subscription;

	@Name(Description = "Master Template")
	@FindBy(xpath = "//a[text()='Master Template']")
	public WebElement Master_template;

	@Name(Description = "Client")
	@FindBy(xpath = "//a[text()='Client']")
	public WebElement Client;

	@Name(Description = "Project")
	@FindBy(xpath = "//a[text()='Project']")
	public WebElement Project;

	@Name(Description = "Project Team")
	@FindBy(xpath = "//a[text()='Project Team']")
	public WebElement Project_team;

	@Name(Description = "Panel_category")
	@FindBy(xpath = "//a[text()='Panel Category']")
	public WebElement Panel_category;

	@Name(Description = "Panels")
	@FindBy(xpath = "//a[text()='Panels']")
	public WebElement Panels;

	@Name(Description = "Dealers")
	@FindBy(xpath = "//a[text()='Dealers']")
	public WebElement Dealers;

	@Name(Description = "System Maintenance")
	@FindBy(xpath = "//a[text()='System Maintenance']")
	public WebElement System_maintenance;

	@Name(Description = "Block Panels")
	@FindBy(xpath = "//a[text()='Block Panels']")
	public WebElement Block_Panels;

	@Name(Description = "Panel Template")
	@FindBy(xpath = "//a[text()='Panel Template']")
	public WebElement Panel_Template;

	@Name(Description = "Bulk Upload")
	@FindBy(xpath = "//a[text()='Bulk Upload']")
	public WebElement Bulk_Upload;

	@Name(Description = "Ticket transaction")
	@FindBy(xpath = "//a[text()='Ticket Transaction']")
	public WebElement Ticket_transaction;
	
	@Name(Description = "Reports")
	@FindBy(xpath = "//a[text()='Reports']")
	public WebElement Reports;

	@Name(Description = "AD Images")
	@FindBy(xpath = "//a[text()='AD Images']")
	public WebElement AD_Images;

	@Name(Description = "Search Ticket")
	@FindBy(xpath = "//a[text()='Search Ticket']")
	public WebElement Search_ticket;

	@Name(Description = "Panel Message Tracking")
	@FindBy(xpath = "//a[text()='Panel Message Tracking']")
	public WebElement Panel_Message_tracking;

	@Name(Description = "Panel Status")
	@FindBy(xpath = "//a[text()='Panel Status']")
	public WebElement Panel_Status;

	@Name(Description = "AD on Request")
	@FindBy(xpath = "//a[text()='Active Deterrence on Request']")
	public WebElement AD_On_Request;

	@Name(Description = "Users")
	@FindBy(xpath = "//a[text()='Users']")
	public WebElement Users;

	@Name(Description="Hk Pool page")
	@FindBy(xpath = "//a[text()='Pools']")
	public WebElement HKPool;
	
	@Name(Description="Hk SiteAllocation page")
	@FindBy(xpath = "//a[text()='Site Allocation']")
	public WebElement HKSiteAllocation;
	
	@Name(Description="Hk Scheduler page")
	@FindBy(xpath = "//a[text()='Scheduler']")
	public WebElement HKScheduler;
	
	@Name(Description="Hk Monitoring page")
	@FindBy(xpath = "//a[text()='Monitoring']")
	public WebElement HKMonitoring;
	
	@Name(Description="Hk Report page")
	@FindBy(xpath = "//a[text()='Report']")
	public WebElement HKReport;
	
	
	
	public Homepage() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
