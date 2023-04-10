package com.concerto.cams.test.pageutils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.concerto.cams.test.pages.OfficeMonitoringReportPage;
import com.concerto.common.utilities.DateTimeFunctions;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class OfficeMonitoringReportPageUtils {
	
	OfficeMonitoringReportPage OfficeMonitoringReportPage;
	
	public OfficeMonitoringReportPageUtils() {
			
		OfficeMonitoringReportPage = new OfficeMonitoringReportPage();
		}

	@Step("Entries for Scheduled  View Monitoring")
	public void ViewOfficeMonitoringReport(String SiteID,String SiteLocation, String Location) throws Throwable {
		//WebInteract.waitForVisibility(OfficeMonitoringReportPage.LaunchOfficeMonitoringReportPage);
		//WebInteract.selectByTextFomDropdownfromStale(MonitoringPage.SelectClientDropDown, Client);
		int a =DriverManager.getWebDriver().findElements(By.tagName("iframe")).size();
		System.out.println(a);
		DriverManager.getWebDriver().switchTo().frame(0);
		WebInteract.waitForVisibility(OfficeMonitoringReportPage.LaunchOfficeMonitoringReportPage);
		System.out.println(Selenium.getText(OfficeMonitoringReportPage.LaunchOfficeMonitoringReportPage));
		WebInteract.selectByTextFomDropdownfromStale(OfficeMonitoringReportPage.SelectOMRSiteDropDown,SiteID+"-"+SiteLocation);
		WebInteract.selectByTextFomDropdownfromStale(OfficeMonitoringReportPage.SelectOMRCAMLocDropDown, Location);
		Thread.sleep(1000);
		Selenium.sendKeys(OfficeMonitoringReportPage.SelectOMRDateDropDown, DateTimeFunctions.GenerateOffsetDateDDMMYYYY());
		//WebInteract.selectByTextFomDropdownfromStale(OfficeMonitoringReportPage.SelectOMRDateDropDown, DateTimeFunctions.GenerateOffsetDateDDMMYYYY());
		WebInteract.selectByTextFomDropdownfromStale(OfficeMonitoringReportPage.SelectOMRTimeSlotDropDown, GetScheduler());
		Selenium.click(OfficeMonitoringReportPage.OMRGenerateButton);
		WebInteract.waitForVisibility(OfficeMonitoringReportPage.RecordCount);
		Selenium.click(OfficeMonitoringReportPage.ExportExcel);
		Selenium.click(OfficeMonitoringReportPage.Exportpdf);
		//WebInteract.WaitForAlert();
		DriverManager.getWebDriver().switchTo().defaultContent();
	}
	
	public String GetScheduler() {
		List<String> l1 = new ArrayList<String>();
		l1.clear();
		List<WebElement> Schedulelist = new Select(
				DriverManager.getWebDriver().findElement(By.xpath("//div[@class='widget-body']//select[@id='ddlTimeInterval']"))).getOptions();
		for (int i = 0; i < Schedulelist.size(); i++) {
			String a = Schedulelist.get(i).getText();
			l1.add(a);
		}
		System.out.println(l1);
		return l1.get(Schedulelist.size() - 1);
	}
	
}
