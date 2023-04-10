package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.ClientPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ClientPageUtils {


	ClientPage ClientPage;

	public ClientPageUtils() {
		
		ClientPage = new ClientPage();
	}
	
	@Step("navigate to add Client")
	public void navigateToAddClient() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(ClientPage.AddButton);
		
	}
	
	@Step("Entries for add Client")
	public void AddClient(String Client, String ClientAddress,  String StateName,
			String CityName, String pincodeNo, String SLAInMIN, String Subscription,String ClientCircle) throws Throwable {
		WebInteract.waitForVisibility(ClientPage.AddClient);
		Selenium.sendKeys(ClientPage.AddClient, Client);
		Selenium.sendKeys(ClientPage.AddClientAddress, ClientAddress);
		WebInteract.selectByTextFomDropdownfromStale(ClientPage.AddStateName, StateName);
		WebInteract.selectByTextFomDropdownfromStale(ClientPage.AddCityName, CityName);
		Selenium.sendKeys(ClientPage.AddPincodeNo, pincodeNo);
		WebInteract.selectByTextFomDropdownfromStale(ClientPage.AddSLAInMin, SLAInMIN);
		//Selenium.sendKeys(ClientPage.AddSubName, Subscription);
		WebInteract.selectByTextFomDropdownfromStale(ClientPage.AddSubName, Subscription);
		Selenium.click(ClientPage.AddClientButton);		
		String SuccessMessage = WebInteract.getNonstaleElementGetText(ClientPage.ClientSuccessMsg);
		//String SuccessMessage =Selenium.getText(ClientPage.ClientSuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Client added successfully.", "Success Message Displayed for Client Addition");
		Selenium.click(ClientPage.CloseButton);
		WebInteract.waitForVisibility(ClientPage.AddButton);
		searchValiddata(Client);
		WebInteract.waitForVisibility(ClientPage.AddButton);
		Selenium.click(ClientPage.AddCircle);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "There are No Records Available.", "Correct message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(ClientPage.ClientCircleHeader);
		Selenium.click(ClientPage.AddButton);
		WebInteract.waitForVisibility(ClientPage.ClientCircleHeader);
		Selenium.sendKeys(ClientPage.CircleName, ClientCircle);
		Selenium.click(ClientPage.AddName);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure to Add Circle?", "Correct alert message is displayed on adding client circle");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(ClientPage.AddCircleSuccessMsg);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(ClientPage.AddCircleSuccessMsg), "Client circle added successfully.", "Correct successful message is displayed on adding circle");
		Selenium.click(ClientPage.CloseButton);
	}
				
	
	
		
	@Step("Entries for Edit Client")
	public void EditClient(String ClientName, String ClientAddress,String VersionNo, String StateName,
			String CityName, String pincodeNo, String Subscription,String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchValiddata(Searchtxt);
		Selenium.click(ClientPage.EditButton);	
		WebInteract.waitForVisibility(ClientPage.EditClient);
		Selenium.clear(ClientPage.EditClient);
		Selenium.sendKeys(ClientPage.EditClient, ClientName);
		Selenium.clear(ClientPage.EditClientAddress);
		Selenium.sendKeys(ClientPage.EditClientAddress, ClientAddress);
		Selenium.clear(ClientPage.EditVersionNo);
		Selenium.sendKeys(ClientPage.EditVersionNo, VersionNo);
		WebInteract.selectByTextFomDropdownfromStale(ClientPage.EditStateName, StateName);
		WebInteract.selectByTextFomDropdownfromStale(ClientPage.EditCityName, CityName);
		Selenium.clear(ClientPage.EditPincodeNo);
		Selenium.sendKeys(ClientPage.EditPincodeNo, pincodeNo);
		WebInteract.selectByTextFomDropdownfromStale(ClientPage.EditSubName, Subscription);
		Selenium.click(ClientPage.UpdateButton);
		//WebInteract.WaitForAlert();
		//String AlertText = WebInteract.AlertGetText();
		//Asserts.assertContains(AlertText, "Are you sure you wish to edit Client?", "Correct Alert Message Is Displayed for Edit Client");
		//WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(ClientPage.UpdateSuccessMsg);
		//String SuccessMessage =Selenium.getText(ClientPage.UpdateSuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Client updated successfully.", "Success Message Displayed for Client Updation");
		Selenium.click(ClientPage.CloseButton);
	}
	 
	@Step("navigate to Search Client")
	public void navigateToSearchClient(String SearchClient) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(ClientPage.SearchClient, SearchClient);
		Selenium.click(ClientPage.GoButton);
		}
	
	@Step("navigate to Delete Client")
	public void DeleteClient(String SearchClient) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchValiddata(SearchClient);
		WebInteract.waitForVisibility(ClientPage.DeleteButton);
		Selenium.click(ClientPage.DeleteButton);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Are you sure to Delete this Client Circle Details?","Correct alert message is displayed on deletion");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Deletemessage, "Client and its all dependencies has been Deleted successfully.","Correct message is displayed on deletion");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(ClientPage.AddButton);
		searchfuncforInValidData(SearchClient);
	}

	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String SearchClient) throws Throwable {
		Selenium.sendKeys(ClientPage.SearchClient, SearchClient);
		Selenium.click(ClientPage.GoButton);
		String Alertmessage = WebInteract.AlertGetText();
		Assert.assertEquals(Alertmessage, "There are no such records available.");
		WebInteract.AcceptAlert();
	}
	
	@Step("To search the entry on page with valid data")
	public void searchValiddata(String SearchClient) throws Throwable {
		Selenium.sendKeys(ClientPage.SearchClient, SearchClient);
		Selenium.click(ClientPage.GoButton);
		
	}
}
	
	
	
