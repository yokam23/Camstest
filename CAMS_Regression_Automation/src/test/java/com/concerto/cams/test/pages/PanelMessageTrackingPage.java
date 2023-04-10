package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class PanelMessageTrackingPage {

	@Name(Description="WebElement to indicate to Panel Message Tracking Page")
	@FindBy(xpath="//h2[contains(text(),'Panel Message Tracking')]")
	public WebElement LaunchPanelMessageTrackingPage;
	
	@Name(Description="Select Client name Dropdown")
	@FindBy(id="ddlClientID")
	public WebElement ClientNameDD;

	@Name(Description="Select Panel ID Dropdown")
	@FindBy(id="ddlPanelId")
	public WebElement PanelID;

	@Name(Description="Select Start Tracking Button")
	@FindBy(id="btnStartTacking")
	public WebElement StartTrackBtn;

	@Name(Description="Select Stop Tracking Button")
	@FindBy(id="btnstop")
	public WebElement StopTrackBtn;
	
	@Name(Description="Select Print Button")
	@FindBy(id="btnPrint")
	public WebElement PrintButton;
	
	public PanelMessageTrackingPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}	
	
}
