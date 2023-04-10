package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class SearchTicketsPage {
	
	@Name(Description="WebElement to indicate to Search Ticket Page")
	@FindBy(xpath="//h2[contains(text(),'Search Tickets')]")
	public WebElement LaunchSearchTicketsPage;
	
	@Name(Description="Select Ticket no textbox")
	@FindBy(id="txtTicketNo")
	public WebElement TicketNoText;
	
	@Name(Description="Select Ticket status Dropdown")
	@FindBy(id="TicketStatus")
	public WebElement TicketStatusDD;
	
	@Name(Description="Select  Assigned To Dropdown")
	@FindBy(id="AssignedTo")
	public WebElement AssignedToDD;

	@Name(Description="Select Client name Dropdown")
	@FindBy(id="clientlist")
	public WebElement ClientNameDD;

	@Name(Description="Select Client Circle Dropdown")
	@FindBy(id="clientCircle")
	public WebElement ClientCircleDD;

	@Name(Description="Select Panel ID Textbox")
	@FindBy(id="PanelID")
	public WebElement PanelIDText;

	@Name(Description="Select Panel mode Dropdown")
	@FindBy(id="PanelMode")
	public WebElement PanelModeDD;
	
	@Name(Description="Select Site ID Textbox")
	@FindBy(id="SiteID")
	public WebElement SiteID;
	
	@Name(Description="Select Start date calendar dropdown")
	@FindBy(id="timeFrom")
	public WebElement StartDateCal;

	@Name(Description="Select End date calendar dropdown")
	@FindBy(id="timeTo")
	public WebElement EndDateCal;
	
	@Name(Description="Select subscription name dropdown")
	@FindBy(id="SubName")
	public WebElement SubNameDD;

	@Name(Description="Select Ticket Type dropdown")
	@FindBy(id="alarm")
	public WebElement TicketTypeDD;
	
	@Name(Description="Search Button")
	@FindBy(id="btnSearch")
	public WebElement SearchButton;
	

	public SearchTicketsPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
