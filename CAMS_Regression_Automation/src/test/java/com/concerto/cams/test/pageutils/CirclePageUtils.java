package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.CirclePage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class CirclePageUtils {

	CirclePage CirclePage;
	
		public CirclePageUtils() {
			
			CirclePage = new CirclePage();
		}
		@Step("navigate to add Circle")
		public void navigateToAddCircle() throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			Selenium.click(CirclePage.AddButton);
		}
	
		@Step("Entries for add Circle")
		public void AddCircle(String CircleName,String ClientName) throws Throwable {
			WebInteract.waitForVisibility(CirclePage.CircleNametext);
			Selenium.sendKeys(CirclePage.CircleNametext, CircleName);
			Selenium.click(CirclePage.AddCircleButton);
			WebInteract.WaitForAlert();
			String AlertText = WebInteract.AlertGetText();
			Asserts.assertContains(AlertText, "Are you sure you wish to add circle?", "Correct Alert Message Is Displayed for Add Circle");
			WebInteract.AcceptAlert();
			String SuccessMessage = WebInteract.getNonstaleElementGetText(CirclePage.AddCircleSuccessMsg);
			//String SuccessMessage =Selenium.getText(CirclePage.AddCircleSuccessMsg);
			Asserts.assertEqual(SuccessMessage, "Circle added successfully", "Success Message Displayed for Circle Addition");
			Selenium.click(CirclePage.CloseButton);
			WebInteract.waitForVisibility(CirclePage.Allocatepanels);
			Searchvaliddata(CircleName);
			WebInteract.waitForVisibility(CirclePage.Allocatepanels);
			Selenium.click(CirclePage.Allocatepanels);
			WebInteract.waitForVisibility(CirclePage.AllocateCircle);
			Selenium.sendKeys(CirclePage.Searchby, ClientName);
			Selenium.click(CirclePage.SearchGo);
			WebInteract.waitForVisibility(CirclePage.SelectAllPanelCheckBox);
			Selenium.click(CirclePage.SelectAllPanelCheckBox);
			Thread.sleep(1000);
			Selenium.click(CirclePage.AllocateCircle);
			//WebInteract.waitForVisibility(CirclePage.SuccessMsgAllocate);
			Asserts.assertEqual(WebInteract.getNonstaleElementGetText(CirclePage.SuccessMsgAllocate), "Panels allocated to Circle successfully", "Correct message is displayed on panel allocation");
			}
		
		@Step("navigate to Allocate Panel Circle")
		public void navigateToAllocatePanelInCircle() throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			Selenium.click(CirclePage.AddNewPanel);
		}
		
		@Step("Entries for Allocate new panel in Circle")
		public void AllocatePanelInCircle() throws Throwable {
			WebInteract.waitForVisibility(CirclePage.LaunchViewPanelPage);
			Selenium.click(CirclePage.SelectAllPanelCheckBox);
			Selenium.click(CirclePage.AllocateCircle);
			String SuccessMessage =Selenium.getText(CirclePage.SuccessMsgAllocate);
			Asserts.assertEqual(SuccessMessage, "Panels allocated to Circle successfully", "Success Message Displayed for Panels allocated to  Circle");		
			}
		
		@Step("navigate to Deallocate Panel Circle")
		public void navigateToDeallocatePanelInCircle() throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			Selenium.click(CirclePage.AddNewPanel);
		}
		
		@Step("Entries for Deallocate new panel in Circle")
		public void DeallocatePanelInCircle(String CircleName) throws Throwable {
			Searchvaliddata(CircleName);
			WebInteract.waitForVisibility(CirclePage.ViewAllocatePanel);
			Selenium.click(CirclePage.ViewAllocatePanel);
			WebInteract.waitForVisibility(CirclePage.LaunchViewPanelPage);
			Selenium.click(CirclePage.SelectAllPanelCheckBox);
			Selenium.click(CirclePage.DeallocateCircle);
			WebInteract.waitForVisibility(CirclePage.DeallocateCircle);
			String SuccessMessage =Selenium.getText(CirclePage.SuccessMsgDeallocate);
			Asserts.assertEqual(SuccessMessage, "Panel removed successfully", "Success Message Displayed for Panels Deallocated to  Circle");		
			}
		
		@Step("navigate to Update Circle")
		public void navigateToUpdateCircle() throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			Selenium.click(CirclePage.AddButton);
		}
	
		@Step("Entries for add Circle")
		public void UpdateCircle(String CircleName,String Searchtxt) throws Throwable {
			WebInteract.waitForVisibility(CirclePage.EditBtn);
			Searchvaliddata(Searchtxt);
			WebInteract.waitForVisibility(CirclePage.EditBtn);
			Selenium.click(CirclePage.EditBtn);
			WebInteract.waitForVisibility(CirclePage.EditCircleNametext);
			Selenium.sendKeys(CirclePage.EditCircleNametext, CircleName);
			Selenium.click(CirclePage.UpdateCircleButton);
			WebInteract.WaitForAlert();
			String AlertText = WebInteract.AlertGetText();
			Asserts.assertContains(AlertText, "Are you sure you wish to update this circle name?", "Correct Alert Message Is Displayed for Add Circle");
			WebInteract.AcceptAlert();
			String SuccessMessage = WebInteract.getNonstaleElementGetText(CirclePage.UpdateCircleSuccessMsg);
			Asserts.assertEqual(SuccessMessage, "Not Allowed to Change Circle Name", "Success Message Displayed for Circle Addition");		
		    Selenium.click(CirclePage.CloseButton); 	
		}
		
		
		@Step("navigate to Search Project team")
		public void navigateToSearchDealer(String SearchCircle) throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			Selenium.sendKeys(CirclePage.SearchCircle, SearchCircle );
			Selenium.click(CirclePage.GoButton);
			}
		
		public void Searchvaliddata(String CircleName) throws Throwable {
			Selenium.sendKeys(CirclePage.Searchoption, CircleName);
			Selenium.click(CirclePage.Gooption);
		}
		
		@Step("navigate to Delete Cirlce")
		public void DeleteCircle(String SearchCircle) throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			DeallocatePanelInCircle(SearchCircle);
			Selenium.click(CirclePage.CircleListButton);
			WebInteract.waitForVisibility(CirclePage.Searchoption);
			Searchvaliddata(SearchCircle);
			WebInteract.waitForVisibility(CirclePage.DeleteCircle);
			Selenium.click(CirclePage.DeleteCircle);
			//String DeleteValidationMessage = WebInteract.AlertGetText();
			//Assert.assertEquals(DeleteValidationMessage, "Do you want to delete this dealer?");
			//WebInteract.AcceptAlert();
			WebInteract.WaitForAlert();
			String Deletemessage = WebInteract.AlertGetText();
			Asserts.assertEqual(Deletemessage, "Circle Deleted successfully","Correct message displayed on deletion of circle");
			WebInteract.AcceptAlert();
		}
}
			








