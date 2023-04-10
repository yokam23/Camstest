package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.TicketTransactionPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class TicketTransactionPageUtils {
	
	protected TicketTransactionPage TicketTransactionPage;

	public TicketTransactionPageUtils() {
		TicketTransactionPage = new TicketTransactionPage();
	}
	
	@Step("Search AcnowledgedTicket On The Transaction Page")
	public void NavigateToADPage() throws Throwable {
		WebInteract.waitForVisibility(TicketTransactionPage.Ticket_AD);
		Selenium.click(TicketTransactionPage.Ticket_AD);
	}
	
	@Step("Search AcnowledgedTicket On The Transaction Page")
	public void GetTicketTransactionPage(String TicketNo) throws Throwable {
		WebInteract.waitForVisibility(TicketTransactionPage.AckTicketSearchText);
		Selenium.sendKeys(TicketTransactionPage.AckTicketSearchText, TicketNo);
		Selenium.click(TicketTransactionPage.AckTicketSearchBtn);
		Logger.logMessage("Ticket Transaction page is displayed");
	}
	
	@Step("Search AcnowledgedTicket On The Transaction Page")
	public void ValidateTicketNo(String TicketNo, String Sensor,String PanelId) throws Throwable {
		WebInteract.waitForVisibility(TicketTransactionPage.TicketField);
		
		Asserts.assertContains(Selenium.getText(TicketTransactionPage.TicketField), TicketNo, "Correct Ticket Number Is Displayed");
		Asserts.assertContains(Selenium.getText(TicketTransactionPage.Sensor),Sensor,"Correct Sensor Number is Displayed");
		Asserts.assertEqual(Selenium.getText(TicketTransactionPage.PanelId), PanelId, "Correct PanelId Number is Displayed");
	}

}
