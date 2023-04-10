package com.concerto.cams.test.pageutils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.concerto.cams.test.pages.HKScheduler;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class HKSchedulerPageUtils {
	
	protected HKScheduler hkschedule;
	protected HouseKeepingPoolUtils hkp;
	
	public HKSchedulerPageUtils() {
		hkschedule = new HKScheduler();
		hkp = new HouseKeepingPoolUtils();
	}
	
	@Step("To get the header of HK scheduler page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Scheduler :: CAMSPlus");
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		String PageHeader = Selenium.getText(hkschedule.SchedulerHeader);
		Asserts.assertEqual(PageHeader, "Scheduler", "Correct Scheduler page header is displayed");
	}

	@Step("To add the new scheduler ")
	public void AddScheduler(String ClientName,String PoolName) throws Throwable {
		searchfuncforValidData(PoolName);
		Asserts.assertEqual(RecordCount(),1, "Correct record count is displayed after filtering record");
		Asserts.assertEqual(Selenium.getText(hkschedule.ClientName), ClientName, "Correct client name is displayed on scheduler page");
		Asserts.assertEqual(Selenium.getText(hkschedule.PoolName), PoolName, "Correct pool name is displayed on scheduler page");
		Selenium.click(hkschedule.AddScheduler);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerHeader), "Scheduler", "Correct schedule page header is displayed");
		Selenium.click(hkschedule.SchedulerAddbtn);
		//WebInteract.waitForVisibility(hkschedule.AddschedulerHeader);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.AddschedulerHeader), "Add Schedule", "Correct scheduler popup page is displayed");
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.SchedulerPoolName), PoolName, "Correct poolname is displayed on popup screen");
		String FromTime= GetCurrenttime();
		String ToTime = Gettime();
		Selenium.sendKeys(hkschedule.FromTime, FromTime);
		Selenium.sendKeys(hkschedule.ToTime, ToTime);
		Selenium.click(hkschedule.AddNewScheduler);
		Thread.sleep(5000);
		//WebInteract.waitForVisibility(hkschedule.AddSchedulerMessage);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.AddSchedulerMessage), "Schedule added successfully","Schedule added successfully");
	    WebInteract.waitForNonVisibility(hkschedule.AddSchedulerMessage, 10);
		Asserts.assertEqual(Selenium.getText(hkschedule.FromTimeTxt), FromTime, "Correct From time is displayed on scheduler page");
	    Asserts.assertEqual(Selenium.getText(hkschedule.ToTimeTxt), ToTime, "Correct ToTime is displayed on scheduler page");
	    Selenium.click(hkschedule.PoolListBtn);
	    WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
	    Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerHeader), "Scheduler", "Correct schedule page header is displayed");
	    hkp.DeleteAllocatesitePool(PoolName);
	    Thread.sleep(5000);
	}
	
	@Step("To Edit the scheduler details")
	public void EditSchedulerdetails(String ClientName,String PoolName) throws Throwable {
		searchfuncforValidData(PoolName);
		WebInteract.waitForVisibility(hkschedule.ClientName);
		Asserts.assertEqual(Selenium.getText(hkschedule.ClientName), ClientName, "Correct client name is displayed on scheduler page");
		Asserts.assertEqual(Selenium.getText(hkschedule.PoolName), PoolName, "Correct pool name is displayed on scheduler page");
		Selenium.click(hkschedule.AddScheduler);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerHeader), "Scheduler", "Correct schedule page header is displayed");
		Selenium.click(hkschedule.Editbtn);
		WebInteract.waitForVisibility(hkschedule.EditSchedulerPageHeader);
		Asserts.assertEqual(Selenium.getText(hkschedule.EditSchedulerPageHeader), "Edit Schedule", "Correct edit page header is displayed");
		Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerPoolName), PoolName, "Correct poolname is displayed on popup screen");
		Selenium.clear(hkschedule.FromTime);
		Selenium.clear(hkschedule.ToTime);
		Selenium.sendKeys(hkschedule.FromTime, "07:00");
		Selenium.sendKeys(hkschedule.ToTime, "07:30");
		Selenium.click(hkschedule.Updatebtn);
		//WebInteract.waitForVisibility(hkschedule.UpdateSchedulerMessage);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.UpdateSchedulerMessage), "Schedule updated successfully", "Schedule updated successfully");
		WebInteract.waitForNonVisibility(hkschedule.UpdateSchedulerMessage, 10);
		Asserts.assertEqual(Selenium.getText(hkschedule.FromTimeTxt), "07:00", "Correct From time is displayed on scheduler page");
	    Asserts.assertEqual(Selenium.getText(hkschedule.ToTimeTxt), "07:30", "Correct ToTime is displayed on scheduler page");
	    Selenium.click(hkschedule.PoolListBtn);
	    Thread.sleep(5000);
	    WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
	    Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerHeader), "Scheduler", "Correct schedule page header is displayed");
	}
	
	@Step("To delete the schedule")
	public void DeleteSchedule(String ClientName,String PoolName) throws Throwable {
		searchfuncforValidData(PoolName);
		WebInteract.waitForVisibility(hkschedule.ClientName);
		Asserts.assertEqual(Selenium.getText(hkschedule.ClientName), ClientName, "Correct client name is displayed on scheduler page");
		Asserts.assertEqual(Selenium.getText(hkschedule.PoolName), PoolName, "Correct pool name is displayed on scheduler page");
		Selenium.click(hkschedule.AddScheduler);
		Thread.sleep(5000);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerHeader), "Scheduler", "Correct schedule page header is displayed");
        Selenium.click(hkschedule.Deletebtn); 
        WebInteract.WaitForAlert();
        String Alertmsg = WebInteract.AlertGetText();
        Asserts.assertEqual(Alertmsg, "Are you sure you wish to delete this schedule?", "Correct alert message is displayed while deleting scheduler");
        WebInteract.AcceptAlert();
        WebInteract.waitForVisibility(hkschedule.DeleteSchedulerMessage);
        Asserts.assertEqual(Selenium.getText(hkschedule.DeleteSchedulerMessage), "Schedule Deleted successfully", "Schedule Deleted successfully");
	    WebInteract.waitForNonVisibility(hkschedule.DeleteSchedulerMessage, 10);
	}
	
	@Step("To get the validation message on scheduler page")
	public void GetValidationmsg(String ClientName,String PoolName) throws Throwable {
		searchfuncforValidData(PoolName);
		WebInteract.waitForVisibility(hkschedule.ClientName);
		Asserts.assertEqual(Selenium.getText(hkschedule.ClientName), ClientName, "Correct client name is displayed on scheduler page");
		Asserts.assertEqual(Selenium.getText(hkschedule.PoolName), PoolName, "Correct pool name is displayed on scheduler page");
		Selenium.click(hkschedule.AddScheduler);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerHeader), "Scheduler", "Correct schedule page header is displayed");
		Selenium.click(hkschedule.SchedulerAddbtn);
		WebInteract.waitForVisibility(hkschedule.AddschedulerHeader);
		Selenium.click(hkschedule.AddNewScheduler);
		//WebInteract.waitForVisibility(hkschedule.SchedulerValidation2);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.SchedulerValidation2), "Scheduled time cannot be less than 1 minute", "Correct validation message is displayed");
		Thread.sleep(2000);
		Selenium.click(hkschedule.ClosebtnScheduler);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Selenium.click(hkschedule.SchedulerAddbtn);
		WebInteract.waitForVisibility(hkschedule.AddschedulerHeader);
		Selenium.sendKeys(hkschedule.FromTime, "10:15");
		Selenium.click(hkschedule.AddNewScheduler);
		//WebInteract.waitForVisibility(hkschedule.SchedulerValidation3);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.SchedulerValidation3), "From time should not be greater than To time", "Correct validation message is displayed");
		Selenium.click(hkschedule.ClosebtnScheduler);
		Thread.sleep(2000);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Selenium.click(hkschedule.SchedulerAddbtn);
		WebInteract.waitForVisibility(hkschedule.AddschedulerHeader);
		Selenium.sendKeys(hkschedule.FromTime, "14:15");
		Selenium.sendKeys(hkschedule.ToTime, "17:15");
		Selenium.click(hkschedule.AddNewScheduler);
		//WebInteract.waitForVisibility(hkschedule.SchedulerValidation1);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.SchedulerValidation1), "Scheduled time cannot be more than 1 hour", "Correct validation message is displayed");
		Selenium.click(hkschedule.ClosebtnScheduler);
		Thread.sleep(2000);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Selenium.click(hkschedule.SchedulerAddbtn);
		WebInteract.waitForVisibility(hkschedule.AddschedulerHeader);
		Selenium.sendKeys(hkschedule.FromTime, "05:15");
		Selenium.sendKeys(hkschedule.ToTime, "05:45");
		Selenium.click(hkschedule.AddNewScheduler);
		//WebInteract.waitForVisibility(hkschedule.AddSchedulerMessage);
		//Selenium.click(hkschedule.ClosebtnScheduler);
		//WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Thread.sleep(2000);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.AddSchedulerMessage), "Schedule added successfully","Schedule added successfully");
		Selenium.click(hkschedule.SchedulerAddbtn);
		WebInteract.waitForVisibility(hkschedule.AddschedulerHeader);
		Selenium.sendKeys(hkschedule.FromTime, "05:15");
		Selenium.sendKeys(hkschedule.ToTime, "05:45");
		Selenium.click(hkschedule.AddNewScheduler);
	   // WebInteract.waitForVisibility(hkschedule.ConflictValidation);
	    Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.ConflictValidation), "This Schedule conflicts with another schedule", "Correct conflict validation message is displayed");
		Selenium.click(hkschedule.ClosebtnScheduler);
		Thread.sleep(2000);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Selenium.click(hkschedule.PoolListBtn);
	}
	
	@Step("To delete schedule for which monitored data is exists")
	public void DeleteMonitoredschedule(String Poolname) throws Throwable {
		searchfuncforValidData(Poolname);
		Selenium.click(hkschedule.AddScheduler);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
		Asserts.assertEqual(Selenium.getText(hkschedule.SchedulerHeader), "Scheduler", "Correct schedule page header is displayed");
		Selenium.click(hkschedule.Deletebtn);
		//WebInteract.waitForVisibility(hkschedule.DeleteValidationMsg);
		WebInteract.WaitForAlert();
		String message = WebInteract.AlertGetText();
		Asserts.assertEqual(message, "Are you sure you wish to delete this schedule?", "Correct validation message displayed while deleting schedule");
		WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(hkschedule.DeleteValidationMsg);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkschedule.DeleteValidationMsg), "Can not delete schedule as monitoring data present for given schedule", "Correct validation message displayed while deleting schedule");
		Selenium.click(hkschedule.PoolListBtn);
		WebInteract.waitForVisibility(hkschedule.SchedulerHeader);
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
	
	public int RecordCount() throws Throwable {
		WebInteract.waitForVisibility(hkschedule.RecordCount);
		String TotalCount = Selenium.getText(hkschedule.RecordCount);
		String[] count = TotalCount.split(":");
		String a = count[1].trim();
		int RecordCount = Integer.parseInt(a);
		return RecordCount;
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(hkschedule.Search_option, searchtext);
		Selenium.click(hkschedule.Go_option);
	}

}
