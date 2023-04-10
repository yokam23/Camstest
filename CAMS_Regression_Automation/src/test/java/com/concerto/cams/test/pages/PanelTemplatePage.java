package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class PanelTemplatePage {

	@Name(Description="WebElement to indicate to Panel Template page")
	@FindBy(xpath="//h2[contains(text(),'Panel Template')]")
	public WebElement LaunchPanelTemplatePage;
	
	@Name(Description="Panel Template search box")
	@FindBy(xpath="//input[@placeholder='Search by Template name or panel type']")
	public WebElement PanelTempSearch;
	
	@Name(Description="Search Go Button")
	@FindBy(xpath="//button[@class='btn btn-default']")
	public WebElement GoButton;
	
	@Name(Description="Add Button")
	@FindBy(id="btnCreate")
	public WebElement AddButton;
	
	//Add panel template...
	
	@Name(Description="Add Panel Template Name textbox")
	@FindBy(id="TemplateName")
	public WebElement AddTemplateName;
	
	@Name(Description="Add Client Dropdown")
	@FindBy(id="ClientID")
	public WebElement AddClient;
	
	@Name(Description="Add PanelType Dropdown")
	@FindBy(id="PanelType")
	public WebElement AddPanelType;
	
	@Name(Description="Add Select State Dropdown")
	@FindBy(id="ddlstate")
	public WebElement StateDD;
	
	@Name(Description="Add Select City Dropdown")
	@FindBy(id="ddlcity")
	public WebElement CityDD;
	
	@Name(Description="Add phone no Textbox")
	@FindBy(id="PhoneNo1")
	public WebElement AddPhoneNo1;
	
	@Name(Description="Add Pincode Textbox")
	@FindBy(id="Pincode")
	public WebElement PanelTempPincode;
	
	@Name(Description="Add Panel Template CRA Agency Dropdown")
	@FindBy(id="CRAID")
	public WebElement PAnelTempCRAAgencyDD;
	
	@Name(Description="Add Panel Template MSP Agency Dropdown")
	@FindBy(id="MSPID")
	public WebElement PanelTempMSPAgencyDD;
 
	@Name(Description="Add Panel Template Panel Manufacturer Textbox")
	@FindBy(id="ddlpanelmfgid")
	public WebElement PanelTempPanelMfgDD;
	
	@Name(Description="Add Panel Model Dropdown")
	@FindBy(id="ddlpanelmodelid")
	public WebElement PanelTempPanelModelDD;
	
	@Name(Description="Add Panel Template HK agency Dropdown")
	@FindBy(id="HKAID")
	public WebElement PanelTempHKAgencyDD;
	
	@Name(Description="Add Panel Template Installation Vendor Dropdown")
	@FindBy(id="INSID")
	public WebElement PanelTempInstallationVendorDD;
	
	@Name(Description="Add Panel Template Project Co-Ordinator Dropdown")
	@FindBy(id="CoordinatorID")
	public WebElement PanelTempProCodDD;
	
	@Name(Description="Add Panel Template Project lead Dropdown")
	@FindBy(id="LeadID")
	public WebElement PanelTempProjectLeadDD;
	
	@Name(Description="Add Panel Template Territory Name Dropdown")
	@FindBy(id="ddlTerritoryName")
	public WebElement PanelTempTerritoryNameDD;

	@Name(Description="Add Panel template Territory Manager Name Dropdown")
	@FindBy(id="ddlTerritoryManager")
	public WebElement PanelTempTerritoryMgrName;
	
	@Name(Description="Add Panel Template Project Manager Dropdown")
	@FindBy(id="ManagerID")
	public WebElement PanelTempProjectDD;
	
	@Name(Description="Add Panel Template Create Button")
	@FindBy(id="btnadd")
	public WebElement CreateButton;
	
	@Name(Description="Display Success message of add panel template")
	@FindBy(xpath="//div[@id='divSuccess']")
	public WebElement PanelTempSuccessMsg;
	
	@Name(Description="Add Panel Template Cancel Button")
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement CancelButton;
	
	public PanelTemplatePage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
