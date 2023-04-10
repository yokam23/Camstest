package com.concerto.cams.test.pageutils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;

import com.concerto.cams.test.pages.SiteConfigurationPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class SiteConfigurationPageUtils {


	SiteConfigurationPage SiteConfigurationPage;

	public SiteConfigurationPageUtils() {
		
		SiteConfigurationPage = new SiteConfigurationPage();
	}
	
	@Step("navigate to add Site Configuration")
	public void navigateToAddSiteConfiguration() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(SiteConfigurationPage.ADDButton);	
	}
	
	
	
	@Step("Entries for add Site Configuration")
	public void AddSiteConfiguration(String ClientName, String SiteID, String StateName, String CityName, String Pincode, String SiteAddress,
			String SiteLocation, String SiteName, String HKAgency, String MDNNo, String Antenna, String DVRType, String  DVRIP, String DVRUserID,
			String DVRPassword, String DVRPort, String DVRChannels, String HDD1TotalSpace,String HDD2TotalSpace, String EmailID, 
			String ContactName, String  MobileNo,String Location ) throws Throwable {
		WebInteract.waitForVisibility(SiteConfigurationPage.AddSiteDetailsClientNameDD);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddSiteDetailsClientNameDD, ClientName);
		Selenium.sendKeys(SiteConfigurationPage.AddSiteIDTextBox, SiteID);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddSiteDetailsStateNameDD, StateName);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddSiteDetailsCityNameDD, CityName);
		Selenium.sendKeys(SiteConfigurationPage.AddPincodeTextBox, Pincode);
		Selenium.sendKeys(SiteConfigurationPage.AddSiteAddressTextBox, SiteAddress);
		Selenium.sendKeys(SiteConfigurationPage.AddSiteLocationTextBox, SiteLocation);
		Selenium.sendKeys(SiteConfigurationPage.AddSiteNameTextBox, SiteName);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddHKAgencyDD, HKAgency);
		Selenium.sendKeys(SiteConfigurationPage.AddMDNNOTextBox, MDNNo);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddAntennaDD, Antenna);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddDVRTypeDD, DVRType);
		Selenium.sendKeys(SiteConfigurationPage.AddDVRIPTextBox, DVRIP);
		Selenium.sendKeys(SiteConfigurationPage.AddDVRUserIDTextBox, DVRUserID);
		Selenium.sendKeys(SiteConfigurationPage.AddDVRPasswordTextBox, DVRPassword);
		Selenium.sendKeys(SiteConfigurationPage.AddDVRPortTextBox, DVRPort);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddDVRChannelsDD, DVRChannels);
		Selenium.sendKeys(SiteConfigurationPage.AddHDDSpaceTextBox1, HDD1TotalSpace);
		Selenium.sendKeys(SiteConfigurationPage.AddHDDSpaceTextBox2, HDD2TotalSpace);
		Selenium.sendKeys(SiteConfigurationPage.AddESCEmailIDTextBox, EmailID);
		Selenium.sendKeys(SiteConfigurationPage.AddESCContactNameTextBox, ContactName);
		Selenium.sendKeys(SiteConfigurationPage.AddMobileNOTextBox, MobileNo);
		Selenium.click(SiteConfigurationPage.AddSiteDetailsSaveButton);
		//WebInteract.WaitForAlert();
		//String AlertText = WebInteract.AlertGetText();
		//Asserts.assertContains(AlertText, "Are you sure you wish to add Dealer?", "Correct Alert Message Is Displayed for Add Dealer");
		//WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(SiteConfigurationPage.AddSiteDetailsSuccessMsg);
		//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Site added successfully", "Success Message Displayed for Site details Addition");	
		//Selenium.click(CameraLocationPage.CancelCameraLocationButton);
		Selenium.click(SiteConfigurationPage.ImageSchedulerButton);
		WebInteract.waitForVisibility(SiteConfigurationPage.schedulerPageHeader);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.LocationDropDown, Location);
		Selenium.sendKeys(SiteConfigurationPage.FromTime, GetCurrenttime());
		Selenium.sendKeys(SiteConfigurationPage.ToTime, Gettime());
		Selenium.click(SiteConfigurationPage.ScheduleSave);
		//WebInteract.waitForVisibility(SiteConfigurationPage.ScheduleSuccessMsg);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(SiteConfigurationPage.ScheduleSuccessMsg), "Image schedule added successfully", "Correct message is displayed on schedule configuration page");
		Selenium.click(SiteConfigurationPage.CameraConfiguration);
		WebInteract.waitForVisibility(SiteConfigurationPage.CameraConfigurationHeader);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.CameraLocation, Location);
        Thread.sleep(2000); 
		Selenium.click(SiteConfigurationPage.SelectCamera);
		Selenium.click(SiteConfigurationPage.CheckAll);
		Selenium.click(SiteConfigurationPage.SaveCamera);
		//WebInteract.waitForVisibility(SiteConfigurationPage.CameraSuccessMsg);
        Asserts.assertEqual(WebInteract.getNonstaleElementGetText(SiteConfigurationPage.CameraSuccessMsg), "Camera configuration added successfully", "Correct message is displayed on camera configuration page");
	}
	
	@Step("Entries for Edit Site Configuration")
	public void EditSiteConfiguration(String Siteid,String Pincode,String MDNNo, String DVRChannels, String HDD1TotalSpace, String HDD2TotalSpace, String EmailID, 
			String ContactName, String  MobileNo ) throws Throwable {
		navigateToSearchSiteDetails(Siteid);
		WebInteract.waitForVisibility(SiteConfigurationPage.EditButton);
		Selenium.click(SiteConfigurationPage.EditButton);
		WebInteract.waitForVisibility(SiteConfigurationPage.EditSiteDetailsStateNameDD);
		//WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.AddSiteDetailsClientNameDD, ClientName);
		//Selenium.sendKeys(SiteConfigurationPage.AddSiteAddressTextBox, SiteID);
		Selenium.clear(SiteConfigurationPage.EditPincodeTextBox);
		Selenium.sendKeys(SiteConfigurationPage.EditPincodeTextBox, Pincode);
		Selenium.clear(SiteConfigurationPage.EditMDNNOTextBox);
		Selenium.sendKeys(SiteConfigurationPage.EditMDNNOTextBox, MDNNo);
		WebInteract.selectByTextFomDropdownfromStale(SiteConfigurationPage.EditDVRChannelsDD, DVRChannels);
		Selenium.clear(SiteConfigurationPage.EditHDDSpaceTextBox1);
		Selenium.sendKeys(SiteConfigurationPage.EditHDDSpaceTextBox1, HDD1TotalSpace);
		Selenium.clear(SiteConfigurationPage.EditESCEmailIDTextBox);
		Selenium.sendKeys(SiteConfigurationPage.EditESCEmailIDTextBox, EmailID);
		Selenium.clear(SiteConfigurationPage.EditESCContactNameTextBox);
		Selenium.sendKeys(SiteConfigurationPage.EditESCContactNameTextBox, ContactName);
		Selenium.clear(SiteConfigurationPage.EditMobileNOTextBox);
		Selenium.sendKeys(SiteConfigurationPage.EditMobileNOTextBox, MobileNo);
		Selenium.click(SiteConfigurationPage.UpdateSiteDetailsButton);
		String SuccessMessage = WebInteract.getNonstaleElementGetText(SiteConfigurationPage.Siteupdatemsg);
		//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Site Details updated successfully", "Success Message Displayed for Site details updation");	
		//Selenium.click(CameraLocationPage.CancelCameraLocationButton);
	}
	
	 void searchfuncforValidData(String SearchSiteDetails) throws Throwable {
			Selenium.sendKeys(SiteConfigurationPage.SearchSiteDetails, SearchSiteDetails);
			Selenium.click(SiteConfigurationPage.GoButton);
			
		}

		@Step("navigate to Search Site details")
		public void navigateToSearchSiteDetails(String SearchSiteDetails) throws Throwable {
			WebInteract.waitForPageLoad(DriverManager.getWebDriver());
			Selenium.sendKeys(SiteConfigurationPage.SearchSiteDetails, SearchSiteDetails);
			Selenium.click(SiteConfigurationPage.GoButton);
			}
		
	
		@Step("To delete the site configuration details")
	    public void DeleteSiteconfiguration(String Siteid) throws Throwable {
			WebInteract.waitForVisibility(SiteConfigurationPage.EditButton);
			navigateToSearchSiteDetails(Siteid);
			Selenium.click(SiteConfigurationPage.EditButton);
			WebInteract.waitForVisibility(SiteConfigurationPage.EditSiteDetailsStateNameDD);
			WebInteract.moveToElement(SiteConfigurationPage.DeleteSiteDetailsButton);
			Selenium.click(SiteConfigurationPage.DeleteSiteDetailsButton);
			WebInteract.WaitForAlert();
			Asserts.assertEqual(WebInteract.AlertGetText(),"Are you sure you wish to delete this site?","Correct Alert message is displayed while deleting site");
			//WebInteract.waitForVisibility(SiteConfigurationPage.Sitedeletemsg);
			WebInteract.AcceptAlert();
			Asserts.assertEqual(WebInteract.getNonstaleElementGetText(SiteConfigurationPage.Sitedeletemsg), "Site details deleted successfully","Correct message is displayed after deleting site");
		}	
		
		@Step("To search the entry on page with invalid data")
		public void searchfuncforInValidData(String SearchSiteDetails) throws Throwable {
			Selenium.sendKeys(SiteConfigurationPage.SearchSiteDetails, SearchSiteDetails);
			Selenium.click(SiteConfigurationPage.GoButton);
			String Alertmessage = WebInteract.AlertGetText();
			Assert.assertEquals(Alertmessage, "No records found");
			WebInteract.AcceptAlert();
		}	
		
		public String Gettime() {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
			   LocalDateTime now = LocalDateTime.now();  
			   //System.out.println(dtf.format(now));  
			   now =  now.plusMinutes(1);
			   return dtf.format(now);
			
		}
		
		public String GetCurrenttime() {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
			   LocalDateTime now = LocalDateTime.now();  
			   //System.out.println(dtf.format(now));  
			   return dtf.format(now);
		}
}
