package com.concerto.cams.test.pageutils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.gradle.internal.impldep.org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.util.AssertionErrors;

import com.concerto.cams.test.pages.HKMonitoring;
import com.concerto.common.exceptions.CannotFindElementOnPageException;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class HKMonitoringPageUtils {

	protected HKMonitoring hkmonitor;
	protected HKSchedulerPageUtils hkm;
	protected SiteAllocationUtils sutils;
	protected Homepageutils hmpage;

	public HKMonitoringPageUtils() {
		hkmonitor = new HKMonitoring();
		hkm = new HKSchedulerPageUtils();
		sutils = new SiteAllocationUtils();
		hmpage = new Homepageutils();
	}

	@Step("To get the header of monitoring page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Pool Monitoring :: CAMSPlus");
		WebInteract.waitForVisibility(hkmonitor.MonitoringHeader);
		String PageHeader = Selenium.getText(hkmonitor.MonitoringHeader);
		Asserts.assertEqual(PageHeader, "Pool Monitoring", "Correct Monitoring page header is displayed");
	}

	@Step("To get the validation message on monitoring page")
	public void GetvalidationMessage(String ClientName, String PoolName) throws Throwable {
		GetPageHeader();
		Selenium.click(hkmonitor.SearchRecord);
		WebInteract.waitForVisibility(hkmonitor.GetClientFieldValidation);
		Asserts.assertEqual(Selenium.getText(hkmonitor.GetClientFieldValidation), "Client is Required",
				"Correct validation message is displayed for client field");
		Thread.sleep(2000);
		WebInteract.selectByTextFomDropdownfromStale(hkmonitor.ClientName, ClientName);
		Selenium.click(hkmonitor.SearchRecord);
		Asserts.assertEqual(Selenium.getText(hkmonitor.GetPoolFieldValidation), "Pool is Required",
				"Correct validation message is displayed for pool field");
		Thread.sleep(2000);
		WebInteract.selectByTextFomDropdownfromStale(hkmonitor.Pool, PoolName);
		Selenium.click(hkmonitor.SearchRecord);
		Thread.sleep(3000);
		Asserts.assertEqual(Selenium.getText(hkmonitor.GetSchedulerFieldValidation), "Schedule is Required",
				"Correct validation message is displayed for Schedule field");
	}

	public String GetCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// System.out.println(formatter.format(date));
		return formatter.format(date);
	}

	@Step("To get the monitor data on monitoring page")
	public void GetMonitoringData(String clientName, String Poolname) throws Throwable {
		int c = Getcount(Poolname);
		hmpage.GetHKMonitoringpage();
		WebInteract.waitForVisibility(hkmonitor.datefield);
		Asserts.assertEqual(Selenium.getAttribute(hkmonitor.datefield, "value"), GetCurrentDate(),
				"Correct date is displayed in date field");
		WebInteract.selectByTextFomDropdownfromStale(hkmonitor.ClientName, clientName);
		WebInteract.selectByTextFomDropdownfromStale(hkmonitor.Pool, Poolname);
		WebInteract.selectByTextFomDropdownfromStale(hkmonitor.Scheduler, GetScheduler());
		/*
		 * Thread.sleep(15000); Selenium.click(hkmonitor.SearchRecord);
		 * Thread.sleep(6000); Selenium.click(hkmonitor.SearchRecord);
		 * Thread.sleep(8000); Selenium.click(hkmonitor.SearchRecord);
		 */
		System.out.println(c);
		boolean b = false;
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(8000);
				Selenium.click(hkmonitor.SearchRecord);
				try {
					WebInteract.waitForVisibility(hkmonitor.TotalImageCount);
					System.out.println(Selenium.getText(hkmonitor.TotalImageCount));
					//System.out.println("Showing " + c + " of " + c + " Images");
					if (Selenium.getText(hkmonitor.TotalImageCount).equalsIgnoreCase("Showing " + c + " of " + c + " Images")) {
						b = true;
					}
					if (b == true) {
						break;
					}
				} catch (Exception e) {
					continue;
				}
			}
		} catch (CannotFindElementOnPageException e) {
			System.out.println("Please start the house keeping service");
		}
		//WebInteract.waitForVisibility(hkmonitor.TotalImageCount);

		// GetMonitoredData();
		// WebInteract.selectByTextFomDropdownfromStale(hkmonitor.ImagesPerPage, "5");
		// WebInteract.waitForVisibility(hkmonitor.TotalImageCount);
		// Thread.sleep(2000);
		SelectNotcleanStatus();
		WebInteract.moveToElement(hkmonitor.Submitstatus);
		Selenium.click(hkmonitor.Submitstatus);
		WebInteract.waitForVisibility(hkmonitor.SubmitStatusMsg);
		Asserts.assertEqual(Selenium.getText(hkmonitor.SubmitStatusMsg),
				"Data has been monitored and submitted for selected Pool and Schedule",
				"Correct message is displayed after submitting the status");
		WebInteract.waitForVisibility(hkmonitor.MonitoringMessage);
		Asserts.assertEqual(Selenium.getText(hkmonitor.MonitoringMessage), "Data has been submitted",
				"Status has been submitted for pool records");
	}

	@Step("To validate reset button on monitoring page")
	public void ValidateResetButton(String clientName, String Poolname) throws Throwable {
		Asserts.assertEqual(Selenium.getAttribute(hkmonitor.datefield, "value"), GetCurrentDate(),
				"Correct date is displayed in date field");
		WebInteract.selectByTextFomDropdownfromStale(hkmonitor.ClientName, clientName);
		WebInteract.selectByTextFomDropdownfromStale(hkmonitor.Pool, Poolname);
		new Select(DriverManager.getWebDriver().findElement(By.xpath("//select[@id='ddlScheduleID']"))).selectByVisibleText(GetScheduler());
		Selenium.click(hkmonitor.ResetBtn);
		Asserts.assertTrue(Selenium.getAttribute(hkmonitor.datefield, "value").isEmpty(),"Date field is blank on refreshing");
		Asserts.assertTrue(Selenium.getAttribute(hkmonitor.ClientName, "value").isEmpty(),"ClientName field is blank on refreshing");
		String b = Selenium.getAttribute(hkmonitor.Pool, "value");
		Asserts.assertTrue(b.equals("0"),"Pool field is blank on refreshing");
		String b1 = Selenium.getAttribute(hkmonitor.Scheduler, "value");
		Asserts.assertTrue(b1.equals("0"),"Scheduler field is blank on refreshing");
	}

	public void SelectNotcleanStatus() {
		String xpath1 = "(//input[@id='ImageData_";
		String xpath2 = "__StatusID'])[2]";

		for (int i = 0; i < 1; i++) {
			DriverManager.getWebDriver().findElement(By.xpath(xpath1 + i + xpath2)).click();
		}
	}

	public String GetScheduler() {
		List<String> l1 = new ArrayList<String>();
		l1.clear();
		List<WebElement> Schedulelist = new Select(
				DriverManager.getWebDriver().findElement(By.xpath("//select[@id='ddlScheduleID']"))).getOptions();
		for (int i = 0; i < Schedulelist.size(); i++) {
			String a = Schedulelist.get(i).getText();
			l1.add(a);
		}
		return l1.get(Schedulelist.size() - 1);
	}

	public int Getcount(String PoolName) throws Throwable {
		hmpage.GetHKSiteAllocationpage();
		sutils.GetViewAllocateSitesPageHeader(PoolName);
		return sutils.RecordCount();
	}
}
