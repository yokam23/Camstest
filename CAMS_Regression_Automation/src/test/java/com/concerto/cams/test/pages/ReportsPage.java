package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class ReportsPage {
	
	//Search Fields
	
	@Name(Description="PanelType")
	@FindBy(id = "ddlPaneltype")
    public WebElement PanelType;
	
	@Name(Description="ddlReportType")
	@FindBy(id = "ddlReportType")
    public WebElement ddlReportType;
	
	@Name(Description="ddlClientID")
	@FindBy(id = "ddlClientID")
    public WebElement ddlClientID;
	
	@Name(Description="txtPanelID")
	@FindBy(id = "txtPanelID")
    public WebElement txtPanelID;
	
	@Name(Description="txtSiteID")
	@FindBy(id = "txtSiteID")
    public WebElement txtSiteID;
	
	@Name(Description="ddlOCircleID")
	@FindBy(id = "ddlOCircleID")
    public WebElement ddlOCircleID;
	
	@Name(Description="btnGenerateReport")
	@FindBy(id = "btnGenerateReport")
    public WebElement btnGenerateReport;
	
	//Table Fields
	
	@Name(Description="Panel")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[2]")
    public WebElement Panel;
	
	@Name(Description="Client")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[17]")
    public WebElement Client;
	
	@Name(Description="RouterModel")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[27]")
    public WebElement RouterModel;
	
	@Name(Description="NetworkType")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[32]")
    public WebElement NetworkType;
	
	@Name(Description="NetworkProvider")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[33]")
    public WebElement NetworkProvider;
	
	@Name(Description="Date")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[35]")
    public WebElement Date;
	
	@Name(Description="Time")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[36]")
    public WebElement Time;
	
	@Name(Description="BranchStatus")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[33]")
    public WebElement BranchStatus;
	
	@Name(Description="LastStatus")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[34]")
    public WebElement LastStatus;
	
	@Name(Description="BranchStatus")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[22]")
    public WebElement BranchOpenStatus;
	
	@Name(Description="BranchStatus")
	@FindBy(xpath = "//table[@id='myPendingDataTable']/tbody/tr/td[25]")
    public WebElement BranchOpenLastStatus;


public ReportsPage() {
	PageFactory.initElements(DriverManager.getWebDriver(), this);
}

}
