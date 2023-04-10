package com.concerto.cams.test.pageutils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.concerto.cams.test.pages.MonitoringPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DateTimeFunctions;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class MonitoringPageUtils {
	
	MonitoringPage MonitoringPage;
	
public MonitoringPageUtils() {
		
	MonitoringPage = new MonitoringPage();
	}
	
@Step("Entries for Scheduled  View Monitoring")
public void ViewScheduledMonitoring(String Client, String SiteID,String Sitelocation, String Location) throws Throwable {
	WebInteract.waitForVisibility(MonitoringPage.SelectClientDropDown);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectClientDropDown, Client);
	Thread.sleep(1000);
	//WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectSiteIDDropDown, SiteID);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectSiteIDDropDown,SiteID+"-"+Sitelocation);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectLocationDropDown,Location);
	System.out.println(DateTimeFunctions.GenerateOffsetDateDDMMYYYY());
	Selenium.sendKeys(MonitoringPage.SelectDateTextbox, DateTimeFunctions.GenerateOffsetDateDDMMYYYY());
	Thread.sleep(1000);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectTimeSlotDropDown, GetScheduler());
	Selenium.click(MonitoringPage.MonitoringViewButton);
	WebInteract.waitForVisibility(MonitoringPage.LaunchImagesPage);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.Statusdropdown, "Yes");
	Selenium.sendKeys(MonitoringPage.Remark, "Ok");
	Selenium.sendKeys(MonitoringPage.Comment, "Test");
	Selenium.click(MonitoringPage.btnsubmit);
	 WebInteract.WaitForAlert();
	 String AlertText = WebInteract.AlertGetText();
	 Asserts.assertContains(AlertText, "Do you want to submit this feedback?", "Correct Alert Message Is Displayed while submitting status");
	 WebInteract.AcceptAlert();
	 Asserts.assertEqual(WebInteract.getNonstaleElementGetText(MonitoringPage.SuccessMsg),"Feedback submitted sucessfully", "Correct message is displayed after submitting status");
	//String SuccessMessage = WebInteract.getNonstaleElementGetText(SurveillanceIndicatorPage.AddSurveIndicatorSuccessMsg);
	//String SuccessMessage =Selenium.getText(DealersPage.SuccessMsg);
	//Asserts.assertEqual(SuccessMessage, "Surveillance Indicator added successfully", "Success Message Displayed for Surveillance Indicator Addition");	
	//Selenium.click(CameraLocationPage.CancelCameraLocationButton);
}

@Step("Entries for Latest  View Monitoring")
public void ViewLatestMonitoring(String Client, String SiteID, String Sitelocation,String Location) throws Throwable {
	WebInteract.waitForVisibility(MonitoringPage.MonitoringTypeLatestRadioButn);
	Selenium.click(MonitoringPage.MonitoringTypeLatestRadioButn);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectClientDropDown, Client);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectSiteIDDropDown,SiteID+"-"+Sitelocation);
	WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectLocationDropDown,Location);
	//WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectDateDropDown, Date);
	//WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectTimeSlotDropDown, TimeSlot);
	Selenium.click(MonitoringPage.MonitoringViewButton);
	System.out.println(DriverManager.getWebDriver().findElements(By.tagName("iframe")).size());
	WebInteract.waitForVisibility(MonitoringPage.Liveimageheader);
	
}

public String GetScheduler() {
	List<String> l1 = new ArrayList<String>();
	l1.clear();
	List<WebElement> Schedulelist = new Select(
			DriverManager.getWebDriver().findElement(By.xpath("//select[@id='ddlScheduleTime']"))).getOptions();
	for (int i = 0; i < Schedulelist.size(); i++) {
		String a = Schedulelist.get(i).getText();
		l1.add(a);
	}
	System.out.println(l1);
	return l1.get(Schedulelist.size() - 1);
}

}
    


