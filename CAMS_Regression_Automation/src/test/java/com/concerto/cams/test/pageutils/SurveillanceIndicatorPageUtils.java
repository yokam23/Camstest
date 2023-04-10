package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.SurveillanceIndicatorPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class SurveillanceIndicatorPageUtils {
	SurveillanceIndicatorPage SurveillanceIndicatorPage;

	public SurveillanceIndicatorPageUtils() {
		
		SurveillanceIndicatorPage = new SurveillanceIndicatorPage();
	}
	

	@Step("navigate to add Surveillance Indicator")
	public void navigateToAddSurveillanceIndicator() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(SurveillanceIndicatorPage.ADDButton);	
	}
	
	@Step("Entries for add Surveillance Indicator")
	public void AddSurveillanceIndicator(String	Cameralocation, String	Category, String Indicator,  String Priority) throws Throwable {
		WebInteract.waitForVisibility(SurveillanceIndicatorPage.ADDSurveillanceIndicatorPage);
		WebInteract.selectByTextFomDropdownfromStale(SurveillanceIndicatorPage.AddCameralocationDropDown, Cameralocation);
		WebInteract.selectByTextFomDropdownfromStale(SurveillanceIndicatorPage.AddcategoryDropDown, Category);
		Selenium.sendKeys(SurveillanceIndicatorPage.AddIndicatorText, Indicator);
		WebInteract.selectByTextFomDropdownfromStale(SurveillanceIndicatorPage.AddPriorityDropdown, Priority);
		Selenium.click(SurveillanceIndicatorPage.AddSurveillanceIndicatorButton);
		//WebInteract.WaitForAlert();
		//String AlertText = WebInteract.AlertGetText();
		//Asserts.assertContains(AlertText, "Are you sure you wish to add Dealer?", "Correct Alert Message Is Displayed for Add Dealer");
		//WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(SurveillanceIndicatorPage.AddSurveIndicatorSuccessMsg);
		//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Indicator added successfully", "Success Message Displayed for Surveillance Indicator Addition");	
		//Selenium.click(CameraLocationPage.CancelCameraLocationButton);
	}
	

	@Step("Entries for Edit Surveillance Indicator")
	public void EditSurveillanceIndicator(String Indicator,  String Priority) throws Throwable {
		navigateToSearchSurveillanceIndicator(Indicator);
		WebInteract.waitForVisibility(SurveillanceIndicatorPage.EditSurveillanceIndicatorButton);
		Selenium.click(SurveillanceIndicatorPage.EditSurveillanceIndicatorButton);
		WebInteract.waitForVisibility(SurveillanceIndicatorPage.EditCameralocationDropDown);
		WebInteract.selectByTextFomDropdownfromStale(SurveillanceIndicatorPage.EditPriorityDropdown, Priority);
		Selenium.click(SurveillanceIndicatorPage.UpdateSurveillanceIndicatorButton);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(SurveillanceIndicatorPage.UpdateSurveIndicatorSuccessMsg);
		//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Indicator updated successfully", "Update Message Displayed for Surveillance Indicator Updatation.");	
		//Selenium.click(CameraLocationPage.CancelCameraLocationButton);
	}
	
	  void searchfuncforValidData(String SearchSurveillanceIndicator) throws Throwable {
			Selenium.sendKeys(SurveillanceIndicatorPage.SearchSurveillanceIndicator, SearchSurveillanceIndicator);
			Selenium.click(SurveillanceIndicatorPage.GoButton);
			
		}

		@Step("navigate to Search Surveillance Indicator")
		public void navigateToSearchSurveillanceIndicator(String SearchSurveillanceIndicator) throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			Selenium.sendKeys(SurveillanceIndicatorPage.SearchSurveillanceIndicator, SearchSurveillanceIndicator);
			Selenium.click(SurveillanceIndicatorPage.GoButton);
			}
	
		@Step("navigate to Delete Surveillance Indicator")
		public void DeleteSurveillanceIndicator(String SearchSurveillanceIndicator) throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			navigateToSearchSurveillanceIndicator(SearchSurveillanceIndicator);
			WebInteract.waitForVisibility(SurveillanceIndicatorPage.DeleteSurveillanceIndicatorButton);
			Selenium.click(SurveillanceIndicatorPage.DeleteSurveillanceIndicatorButton);
			String DeleteValidationMessage = WebInteract.AlertGetText();
			Asserts.assertEqual(DeleteValidationMessage, "Do you want to delete this indicator?","Correct alert message is displayed");
			WebInteract.AcceptAlert();
			Asserts.assertEqual(WebInteract.getNonstaleElementGetText(SurveillanceIndicatorPage.DeleteSurveIndicatorSuccessMsg), "Indicator deleted successfully","Correct deletion message is displayed");
		}
			@Step("To search the entry on page with invalid data")
			public void searchfuncforInValidData(String SearchSurveillanceIndicator) throws Throwable {
				Selenium.sendKeys(SurveillanceIndicatorPage.SearchSurveillanceIndicator, SearchSurveillanceIndicator);
				Selenium.click(SurveillanceIndicatorPage.GoButton);
				String Alertmessage = WebInteract.AlertGetText();
				Assert.assertEquals(Alertmessage, "There are no such records available.");
				WebInteract.AcceptAlert();
			}		

}
