package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.CameraLocationPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class CameraLocationPageUtils {
	CameraLocationPage CameraLocationPage;

	public CameraLocationPageUtils() {
		
		CameraLocationPage = new CameraLocationPage();
	}
	
	@Step("navigate to add Camera Location")
	public void navigateToAddCameraLocation() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(CameraLocationPage.ADDButton);
		Selenium.click(CameraLocationPage.ADDButton);
	}
	
	@Step("Entries for add Camera Location")
	public void AddCameraLocation(String CameraLocation) throws Throwable {
		WebInteract.waitForVisibility(CameraLocationPage.AddCameraLocationText);
		Selenium.sendKeys(CameraLocationPage.AddCameraLocationText, CameraLocation);
		Selenium.click(CameraLocationPage.ADDCameraLocationButton);
		//WebInteract.WaitForAlert();
		//String AlertText = WebInteract.AlertGetText();
		//Asserts.assertContains(AlertText, "Are you sure you wish to add Dealer?", "Correct Alert Message Is Displayed for Add Dealer");
		//WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(CameraLocationPage.CAMLOCSuccessMsg);
		//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Camera Location added successfully", "Success Message Displayed for Camera Location Addition");	
		//Selenium.click(CameraLocationPage.CancelCameraLocationButton);
	}
	
	@Step("Entries for Edit Camera Location")
	public void EditCameraLocation(String CameraLocation,String Searchtxt) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		navigateToSearchCameraLocation(Searchtxt);
		WebInteract.waitForVisibility(CameraLocationPage.EditCameraLocationButton);
		Selenium.click(CameraLocationPage.EditCameraLocationButton);
		WebInteract.waitForVisibility(CameraLocationPage.EditCameraLocationPage);
		Selenium.clear(CameraLocationPage.EditCameraLocationText);
		Selenium.sendKeys(CameraLocationPage.EditCameraLocationText, CameraLocation);
		Selenium.click(CameraLocationPage.UpdateCameraLocationButton);
	    //WebInteract.WaitForAlert();
	    //WebInteract.waitForVisibility(CameraLocationPage.UpdateCAMLOCSuccessMsg);
		//String AlertText = WebInteract.AlertGetText();
		//Asserts.assertContains(AlertText, "Are you sure you wish to add Dealer?", "Correct Alert Message Is Displayed for Add Dealer");
		//WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(CameraLocationPage.UpdateCAMLOCSuccessMsg);
		//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Camera Location updated successfully", "Success Message Displayed for Camera Location Updatation.");	
		//Selenium.click(CameraLocationPage.CancelCameraLocationButton);
	}
	
	    public void searchfuncforValidData(String SearchCameraLocation) throws Throwable {
		Selenium.sendKeys(CameraLocationPage.SearchCameraLocation, SearchCameraLocation);
		Selenium.click(CameraLocationPage.GoButton);
		
	}

	@Step("navigate to Search Camera Location")
	public void navigateToSearchCameraLocation(String SearchCameraLocation) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(CameraLocationPage.SearchCameraLocation, SearchCameraLocation);
		Selenium.click(CameraLocationPage.GoButton);
		}

	@Step("navigate to Delete Camera Location")
	public void DeleteCameraLocation(String SearchCameraLocation) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		navigateToSearchCameraLocation(SearchCameraLocation);
		WebInteract.waitForVisibility(CameraLocationPage.DeleteCameraLocation);
		Selenium.click(CameraLocationPage.DeleteCameraLocation);
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Do you want to delete this camera location?","Correct alert message is displayed ");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(CameraLocationPage.CAMLOCDeleteMsg);
		Asserts.assertEqual(Selenium.getText(CameraLocationPage.CAMLOCDeleteMsg),"Camera Location deleted successfully", "Correct camera deletion message is displayed");
		WebInteract.waitForVisibility(CameraLocationPage.DeleteCameraLocation);
		
		
	}
		@Step("To search the entry on page with invalid data")
		public void searchfuncforInValidData(String SearchCameraLocation) throws Throwable {
			Selenium.sendKeys(CameraLocationPage.SearchCameraLocation, SearchCameraLocation);
			Selenium.click(CameraLocationPage.GoButton);
			String Alertmessage = WebInteract.AlertGetText();
			Assert.assertEquals(Alertmessage, "There are no such records available.");
			WebInteract.AcceptAlert();
		}
}
