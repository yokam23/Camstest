package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class TicketTransactionPage {
	
	@Name(Description="WebElement to indicate to Ticket Transaction Page")
	@FindBy(xpath="//li[@id='liAllCount']//a")
	public WebElement LaunchTicketTransactionPage;

	@Name(Description="Assign To Supervisor button")
	@FindBy(id="btnAssignToSupervisor")
	public WebElement AssignToSupervisor;
	
	@Name(Description="Assign To Supervisor Dropdown")
	@FindBy(id="SupervisorLoginId")
	public WebElement AssignToSupervisorDD;
	
	@Name(Description="Assign To Supervisor Button after select supervisor")
	@FindBy(id="imgbtnAssign")
	public WebElement AssignToSupervisorBtn;
	
	@Name(Description="Stop auto refresh button")
	@FindBy(id="btnStartStopAutoRefersh")
	public WebElement StopAutoRefreshBtn;

	@Name(Description="Re-assign Ticket button")
	@FindBy(id="btnReAssignTicket")
	public WebElement ReassignTicket;
	
	//Unacknowledged Tickets......
	
	@Name(Description="Unacknowledged Tickets search textbox")
	@FindBy(id="txtsearchPending")
	public WebElement UnAckTicketSearchText;	

	@Name(Description="Unacknowledged Tickets search Button")
	@FindBy(id="btnsearchPending")
	public WebElement UnAckTicketSearchBtn;
	
	@Name(Description="Unacknowledged Tickets reset Button")
	@FindBy(id="btnsearchPendingReset")
	public WebElement UnAckTicketResetBtn;
	
	/**
	 * TicketPage Header
	 */
	
	@Name(Description = "FireCount")
	@FindBy(xpath = "//li[@id='liFireCount']/a/div/i")
	public WebElement Ticket_FireCount;
	
	@Name(Description = "Ticket IntrusionCount")
	@FindBy(xpath = "//li[@id='liIntrusionCount']/a/div/i")
	public WebElement Ticket_IntrusionCount;
	
	@Name(Description = "Ticket PIRCount")
	@FindBy(xpath = "//li[@id='liPIRCount']/a/div/i")
	public WebElement Ticket_PIRCount;
	
	@Name(Description = "Ticket SoftZoneCount")
	@FindBy(xpath = "//li[@id='liSoftZoneCount']/a/div/i")
	public WebElement Ticket_SoftZoneCount;
	
	@Name(Description = "Ticket VIPCount")
	@FindBy(xpath = "//li[@id='liVIPCount']/a/div/i")
	public WebElement Ticket_VIPCount;
	
	@Name(Description = "Ticket BlacklistZones")
	@FindBy(xpath = "//li[@id='liBlacklistZones']/a/div/i")
	public WebElement Ticket_BlacklistZones;
	
	@Name(Description = "Ticket AD")
	@FindBy(xpath = "//li[@id='liAD']/a/div/i")
	public WebElement Ticket_AD;
	
	//Acknowledged Tickets.....
	
	@Name(Description="Acknowledged Tickets search Button")
	@FindBy(id="txtsearchHold")
	public WebElement AckTicketSearchText;

	@Name(Description="Acknowledged Tickets search Button")
	@FindBy(id="btnsearchHold")
	public WebElement AckTicketSearchBtn;
	
	@Name(Description="Acknowledged Tickets reset Button")
	@FindBy(id="btnsearchreset")
	public WebElement AckTicketResetBtn;
	
	@Name(Description="Acknowledged Tickets Info")
	@FindBy(xpath="//table[@id='dtOnHoldDataTable']/tbody/tr/td/a")
	public WebElement TicketField;
	
	@Name(Description="Acknowledged Tickets Info")
	@FindBy(xpath="//table[@id='dtOnHoldDataTable']/tbody/tr/td/a")
	public WebElement ClientName;
	
	@Name(Description="Acknowledged Tickets Info")
	@FindBy(xpath="//table[@id='dtOnHoldDataTable']/tbody/tr/td[6]")
	public WebElement Sensor;
	
	@Name(Description="Acknowledged Tickets Info")
	@FindBy(xpath="//table[@id='dtOnHoldDataTable']/tbody/tr/td[7]")
	public WebElement PanelId;
	
	
	//Pending Tickets...
	
	@Name(Description="Pending Tickets search Button")
	@FindBy(id="txtsearchAddone")
	public WebElement PendingSearchText;

	@Name(Description="Pending Tickets search Button")
	@FindBy(id="btnsearchAddone")
	public WebElement PendingTicketSearchBtn;
	
	@Name(Description="Pending Tickets reset Button")
	@FindBy(id="txtResetAddone")
	public WebElement PendingTicketResetBtn;
	

	//
	
	
	
	//Current Status Page.......
	
	
	
	
	
	
	
	
	
	
	
	
	

	public TicketTransactionPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}