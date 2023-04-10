package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class ADImageReportPage {

	@Name(Description="WebElement to indicate to AD Image Report Page")
	@FindBy(xpath="//h2[contains(text(),'AD Image Report')]")
	public WebElement LaunchADImageReportPage;
	
	@Name(Description="Select Start date calendar dropdown")
	@FindBy(id="TicketDate")
	public WebElement StartDateCal;
	
	@Name(Description="Select Client dropdown")
	@FindBy(id="ddlClientID")
	public WebElement SelectClientDD;

	@Name(Description="Select panel ID dropdown")
	@FindBy(id="ddlPanelID")
	public WebElement SelectPanelID;

	@Name(Description="Select Ticket List dropdown")
	@FindBy(id="ddlTicketNo")
	public WebElement SelectTicketList;

	@Name(Description="Search Button")
	@FindBy(id="btnView")
	public WebElement SearchButton;

	@Name(Description="Reset Button")
	@FindBy(className="btn btn-info")
	public WebElement ResetButton;
			
	
	public ADImageReportPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
