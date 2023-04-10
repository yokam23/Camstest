package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.SearchTicketsPage;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class SearchTicketsPageUtils {
	
	SearchTicketsPage SearchTicketsPage;

	public SearchTicketsPageUtils() {
		
		SearchTicketsPage = new SearchTicketsPage();
	}

	@Step("navigate to Search Ticket")
	public void navigateToSearchTicket() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(SearchTicketsPage.SearchButton);	
	}
	
	@Step("Entries for Search Ticket")
	public void SearchTicket(String TicketNo, String TicketStatus, String AssignedTo, String ClientName,String ClientCircle,
			String PanelID, String PanelMode, String SiteID, String TimeFrom, String TimeTo, String subscription,
			String TicketType) throws Throwable {
		WebInteract.waitForVisibility(SearchTicketsPage.TicketNoText);
		Selenium.sendKeys(SearchTicketsPage.TicketNoText, TicketNo);
		WebInteract.selectByTextFomDropdownfromStale(SearchTicketsPage.TicketStatusDD, TicketStatus);
		WebInteract.selectByTextFomDropdownfromStale(SearchTicketsPage.AssignedToDD, AssignedTo);
		WebInteract.selectByTextFomDropdownfromStale(SearchTicketsPage.ClientNameDD, ClientName);
		WebInteract.selectByTextFomDropdownfromStale(SearchTicketsPage.ClientCircleDD, ClientCircle);
		Selenium.sendKeys(SearchTicketsPage.PanelIDText, PanelID);
		WebInteract.selectByTextFomDropdownfromStale(SearchTicketsPage.PanelModeDD, PanelMode);
		Selenium.sendKeys(SearchTicketsPage.SiteID, SiteID);
		Selenium.sendKeys(SearchTicketsPage.StartDateCal, TimeFrom);
		Selenium.sendKeys(SearchTicketsPage.EndDateCal, TimeTo);
		WebInteract.selectByTextFomDropdownfromStale(SearchTicketsPage.SubNameDD, subscription);
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
}
