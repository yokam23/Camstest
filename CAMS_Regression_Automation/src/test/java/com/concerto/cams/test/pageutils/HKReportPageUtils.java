package com.concerto.cams.test.pageutils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.gradle.internal.impldep.org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.concerto.cams.test.pages.HKReport;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;
import com.concerto.db.methods.HouseKeepingDBdetails;

import io.qameta.allure.Step;

public class HKReportPageUtils {
	
	protected HKReport hkreport;
	protected SiteAllocationUtils site;
	protected Homepageutils hmpage;
	
	public HKReportPageUtils() {
		hkreport = new HKReport();
		site = new SiteAllocationUtils();
		hmpage = new Homepageutils();
	}

	@Step("To get the header of report page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Pool :: CAMSPlus");
		WebInteract.waitForVisibility(hkreport.ReportHeader);
		String PageHeader = Selenium.getText(hkreport.ReportHeader);
		Asserts.assertEqual(PageHeader, "Scheduler", "Correct Mpnitoring page header is displayed");
	}
	
	@Step("To get the report of monitoring data")
	public void GetReportData(String ClientName,String PoolName) throws Throwable {
		Selenium.sendKeys(hkreport.HKDate, GetCurrentDate());
		System.out.println(Selenium.getAttribute(hkreport.HKDate, "value"));
		Asserts.assertEqual(Selenium.getAttribute(hkreport.HKDate, "value"), GetDate(), "Current date is displayed in date field");
		WebInteract.selectByTextFomDropdownfromStale(hkreport.HKClient, ClientName);
		WebInteract.selectByTextFomDropdownfromStale(hkreport.HKPool, PoolName);
		WebInteract.selectByTextFomDropdownfromStale(hkreport.HKScheduler, GetScheduler());
	    Selenium.click(hkreport.HKSearchOption);
	    WebInteract.waitForVisibility(hkreport.RecordCount);
	    int count  = RecordCount();
	    List<String> l1= ReportPanelList();
	   // Asserts.assertEqual(Selenium.getText(hkreport.RecordCount), "Total number of records : 10", "Correct count is displayed on report page");
		Selenium.click(hkreport.ExportData);
		 hmpage.GetHKSiteAllocationpage();
		 site.GetViewAllocateSitesPageHeader(PoolName);
		 int AllocatedSiteCount = site.RecordCount();
		 Asserts.assertEqual(count, AllocatedSiteCount, "Correct site's count is displayed on report page");
		 List<String> l2 = site.PanelListReport();
		 Collections.sort(l1);
		 Collections.sort(l2);
		 System.out.println(l1);
		 System.out.println(l2);
		 Asserts.assertTrue(l1.equals(l2), "Correct panelid's are displayed on report page"); 
		 Thread.sleep(10000);
		 String panel = HouseKeepingDBdetails.GetHKReportPanels(PoolName).get(0).get("PanelID").replaceFirst("1", "A");
		 //System.out.println(panel);
		 //System.out.println(HouseKeepingDBdetails.GetHKReportPanels(PoolName).get(0).get("StatusName"));
		 Asserts.assertEqual(panel, l2.get(0), "Correct panelid is displayed in database");
		 Asserts.assertEqual(HouseKeepingDBdetails.GetHKReportPanels(PoolName).get(0).get("StatusName"), "Not Clean", "Correct status is displayed in database for panelid");
		 
		 for(int i=1;i<l2.size();i++) {
			 String panel1 = HouseKeepingDBdetails.GetHKReportPanels(PoolName).get(i).get("PanelID").replaceFirst("1", "A");
			 //System.out.println(panel1);
			// System.out.println(HouseKeepingDBdetails.GetHKReportPanels(PoolName).get(i).get("StatusName"));
			 Asserts.assertEqual(panel1, l2.get(i), "Correct panelid is displayed in database");
			 Asserts.assertEqual(HouseKeepingDBdetails.GetHKReportPanels(PoolName).get(i).get("StatusName"), "Clean", "Correct status is displayed in database for panelid");	  
		 }
	}
	
	@Step("To validate the reset button")
	public void ValidateResetButton(String clientName, String Poolname) throws Throwable {
	Selenium.sendKeys(hkreport.HKDate, GetCurrentDate());
	WebInteract.selectByTextFomDropdownfromStale(hkreport.HKClient, clientName);
	WebInteract.selectByTextFomDropdownfromStale(hkreport.HKPool, Poolname);
	WebInteract.selectByTextFomDropdownfromStale(hkreport.HKScheduler, GetScheduler());
	Selenium.click(hkreport.Resetbtn);
	Assert.assertTrue(Selenium.getAttribute(hkreport.HKDate, "value").isEmpty());
	//Assert.assertTrue(Selenium.getAttribute(hkreport.HKClient, "value").isEmpty());
	String b2 = Selenium.getAttribute(hkreport.HKClient, "value");
	Assert.assertTrue(b2.equals("0"));
	String b = Selenium.getAttribute(hkreport.HKPool, "value");
	Assert.assertTrue(b.equals("0"));
	String b1 = Selenium.getAttribute(hkreport.HKScheduler, "value");
	Assert.assertTrue(b1.equals("0"));
}
	
	@Step("To validate the error messages")
	public void ValidateErrorMsg(String clientName, String Poolname) throws Throwable {
		Selenium.click(hkreport.HKSearchOption);
		Asserts.assertEqual(Selenium.getText(hkreport.DateField), "Required","Correct validation message is displayed for date field");
		Selenium.sendKeys(hkreport.HKDate, GetCurrentDate());
		Selenium.click(hkreport.HKSearchOption);
		Asserts.assertEqual(Selenium.getText(hkreport.ClientField), "Required","Correct validation message is displayed for Client field"); 
	}
	
	@Step("To validate the report message if data not available")
	public void ValidateReportMsg(String ClientName,String PoolName) throws Throwable {
		hmpage.GetHKReportspage();
		WebInteract.waitForVisibility(hkreport.HKDate);
		Selenium.sendKeys(hkreport.HKDate, GetCurrentDate());
		WebInteract.selectByTextFomDropdownfromStale(hkreport.HKClient, ClientName);
		WebInteract.selectByTextFomDropdownfromStale(hkreport.HKPool, PoolName);
		Selenium.click(hkreport.HKSearchOption);
		WebInteract.waitForVisibility(hkreport.RecordCount);
		Asserts.assertEqual(Selenium.getText(hkreport.RecordCount), "Total number of records : 0", "Correct count is displayed on report page");
	    Asserts.assertEqual(Selenium.getText(hkreport.Reportmsg), "No records found.", "Correct message is displayed on report page");
	}
	
	public List<String> ReportPanelList() {
		List<WebElement> panellist = hkreport.PanelList;
		List<String> list = new ArrayList<String>();
		list.clear();
		for(int i =0;i<10;i++) {
			String s = panellist.get(i).getText();
			list.add(s);
		}
		System.out.println(list);
		return list;
	}
	
	public String GetCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		// System.out.println(formatter.format(date));
		return formatter.format(date);
	}
	
	public String GetDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// System.out.println(formatter.format(date));
		return formatter.format(date);
	}
	
	public String GetScheduler() {
		List<String> l1 = new ArrayList<String>();
		l1.clear();
		List<WebElement> Schedulelist = new Select(DriverManager.getWebDriver().findElement(By.xpath("//select[@id='ddlSchedule']"))).getOptions();
	    for(int i=0;i<Schedulelist.size();i++) {
	    	String a = Schedulelist.get(i).getText();
	    	l1.add(a);
	    }    
	    System.out.println(l1.get(Schedulelist.size()-1));
	    return l1.get(Schedulelist.size()-1);
	}
	
	public int RecordCount() throws Throwable {
		String TotalCount = Selenium.getText(hkreport.RecordCount);
		String[] count = TotalCount.split(":");
		String a = count[1].trim();
		int RecordCount = Integer.parseInt(a);
		return RecordCount;
	}
}
