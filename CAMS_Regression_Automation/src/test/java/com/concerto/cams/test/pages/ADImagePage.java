package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class ADImagePage {
	
	@Name(Description="TicketNo")
	@FindBy(id="dtlstAD_lblTicketID_0")
	public WebElement TicketNo;
	
	@Name(Description="TicketNo")
	@FindBy(id="dtlstAD_lblActivityID_0")
	public WebElement ActivityId;
	
	@Name(Description="TicketNo")
	@FindBy(id="dtlstAD_lblZoneNo_0")
	public WebElement ZoneNo;
	
	@Name(Description="TicketNo")
	@FindBy(id="dtlstAD_lblPanelID_0")
	public WebElement PanelId;
	
	@Name(Description="ADImage")
	@FindBy(id="dtlstAD_imgADImage_0")
	public WebElement ADImage;
	
	@Name(Description="ADImage")
	@FindBy(id="lblPopupTicketID")
	public WebElement ADTicket;
	
	@Name(Description="Comment")
	@FindBy(id="ddlComments")
	public WebElement Comment;
	
	@Name(Description="btnTicketClose")
	@FindBy(id="btnTicketClose")
	public WebElement CloseTicket;
			
	
	public ADImagePage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
