package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.ADImagePage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ADPageUtils {
	
	
		
		protected ADImagePage ADImagePage;

		public ADPageUtils() {
			ADImagePage = new ADImagePage();
		}
		
		@Step("Get First Ticket Number")
		public String GetTicketNumber() throws Throwable {		
			return Selenium.getText(ADImagePage.TicketNo);
			
		}
		
		@Step("Validate Ticket Details")
		public void ValidateAD(String ActivityId,String Zone, String PanelId) throws Throwable {
			Asserts.assertEqual(Selenium.getText(ADImagePage.ActivityId), ActivityId, "Correct ActivityID is Displayed");
			Asserts.assertEqual(Selenium.getText(ADImagePage.ZoneNo), Zone, "Correct Zone Is Displayed");
			Asserts.assertEqual(Selenium.getText(ADImagePage.PanelId), PanelId, "Correct Panel is displayed");
		}
		
		@Step("Close Ticket")
		public String CloseTicket() throws Throwable {
			Selenium.click(ADImagePage.ADImage);
			WebInteract.waitForVisibility(ADImagePage.ADTicket);
			String TicketNumber= Selenium.getText(ADImagePage.ADTicket);
			WebInteract.selectByTextFomDropdownfromStale(ADImagePage.Comment, "Others");
			Selenium.click(ADImagePage.CloseTicket);
			return TicketNumber;
		}
		

}
