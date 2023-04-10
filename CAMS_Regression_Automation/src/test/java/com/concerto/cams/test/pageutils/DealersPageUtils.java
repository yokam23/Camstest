package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.DealersPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class DealersPageUtils {

	
	DealersPage DealersPage;

	public DealersPageUtils() {
		
		DealersPage = new DealersPage();
	}
	
	@Step("navigate to add dealer")
	public void navigateToAddDealer() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(DealersPage.AddButton);	
	}
	
	@Step("Entries for add dealer")
	public void AddDealer(String DealerName, String Address, String State, String City,String Pincode, String ContactPerson,
			String PhoneNo, String MobileNo, String EmailID) throws Throwable {
		WebInteract.waitForVisibility(DealersPage.AddDealerNameText);
		Selenium.sendKeys(DealersPage.AddDealerNameText, DealerName);
		Selenium.sendKeys(DealersPage.AddDealerAddressText, Address);
		WebInteract.selectByTextFomDropdownfromStale(DealersPage.AddstateDD, State);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(DealersPage.AddCityDD, City);
		Selenium.sendKeys(DealersPage.AddPincode, Pincode);
		Selenium.sendKeys(DealersPage.AddContactPerson, ContactPerson);
		Selenium.sendKeys(DealersPage.AddPhoneNo, PhoneNo);
		Selenium.sendKeys(DealersPage.AddMobileNo, MobileNo);
		Selenium.sendKeys(DealersPage.AddEmailID, EmailID);
		Selenium.click(DealersPage.AddDealerButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you wish to add Dealer?", "Correct Alert Message Is Displayed for Add Dealer");
		WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(DealersPage.SuccessMsg);
		//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Dealer added successfully", "Success Message Displayed for Dealer Addition");	
		Selenium.click(DealersPage.CloseEditDealerBtn);
	}
	
	
	@Step("Entries for Edit dealer")
	public void EditDealer( String DealerName, String Address, String State, String City,String Pincode, String ContactPerson,
			String PhoneNo, String MobileNo, String EmailID,String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(DealersPage.EditDealerButton);
		Selenium.click(DealersPage.EditDealerButton);
		WebInteract.waitForVisibility(DealersPage.EditDealerNameText);
		Selenium.clear(DealersPage.EditDealerNameText);
		Selenium.sendKeys(DealersPage.EditDealerNameText, DealerName);
		Selenium.clear(DealersPage.EditDealerAddressText);
		Selenium.sendKeys(DealersPage.EditDealerAddressText, Address);
		WebInteract.selectByTextFomDropdownfromStale(DealersPage.EditStateDD, State);
		WebInteract.selectByTextFomDropdownfromStale(DealersPage.EditCityDD, City);
		//Selenium.sendKeys(DealersPage.EditPincode, Pincode);
		//Selenium.sendKeys(DealersPage.EditContactPerson, ContactPerson);
		//Selenium.sendKeys(DealersPage.EditPhoneNo, PhoneNo);
		//Selenium.sendKeys(DealersPage.EditMobileNo, MobileNo);
		//Selenium.sendKeys(DealersPage.EditEmailID, EmailID);
		Selenium.click(DealersPage.UpdateDealerButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you wish to update this dealer?", "Correct Alert Message Is Displayed for Edit Dealer");
		WebInteract.AcceptAlert();
		
		//String SuccessMessage =Selenium.getText(DealersPage.UpdateSuccessMsg);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(DealersPage.UpdateSuccessMsg);

		Asserts.assertEqual(SuccessMessage, "Dealer updated Successfully", "Success Message Displayed for Dealer Updation");	
		Selenium.click(DealersPage.CloseEditDealerBtn);
	}
	
	private void searchfuncforValidData(String searchDealer) throws Throwable {
		Selenium.sendKeys(DealersPage.SearchDealer, searchDealer);
		Selenium.click(DealersPage.GoButton);
		
	}

	@Step("navigate to Search dealer")
	public void navigateToSearchDealer(String SearchDealer) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(DealersPage.SearchDealer, SearchDealer);
		Selenium.click(DealersPage.GoButton);
		}
	
	@Step("navigate to Delete dealer")
	public void DeleteDealer(String SearchDealer) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		navigateToSearchDealer(SearchDealer);
		WebInteract.waitForVisibility(DealersPage.DeleteDealer);
		Selenium.click(DealersPage.DeleteDealer);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Are you sure you wish to delete this dealer?","Correct alert message is displayed on deletion of dealer");
		WebInteract.AcceptAlert();
		String Deletemessage = WebInteract.AlertGetText();
		Asserts.assertContains(Deletemessage, "deleted Successfully", "Correct deletion message is displayed on deletion of the dealer");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(DealersPage.AddButton);
		searchfuncforInValidData(SearchDealer);
	}
	
	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String SearchDealer) throws Throwable {
		Selenium.sendKeys(DealersPage.SearchDealer, SearchDealer);
		Selenium.click(DealersPage.GoButton);
		String Alertmessage = WebInteract.AlertGetText();
		Asserts.assertEqual(Alertmessage, "There are no such records available.","Correct alert message is displayed for no reocrds");
		WebInteract.AcceptAlert();
	}
}







