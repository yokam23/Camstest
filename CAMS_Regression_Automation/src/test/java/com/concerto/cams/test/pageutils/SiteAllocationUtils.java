package com.concerto.cams.test.pageutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.concerto.cams.test.pages.HKSiteAllocation;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class SiteAllocationUtils {

	protected HKSiteAllocation Hksite;
	protected Homepageutils hmutil;
	protected HouseKeepingPoolUtils hmp;

	public SiteAllocationUtils() {
		Hksite = new HKSiteAllocation();
		hmutil = new Homepageutils();
		hmp = new HouseKeepingPoolUtils();
	}

	@Step("To get the header of HK site allocation page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Pool :: CAMSPlus");
		WebInteract.waitForVisibility(Hksite.HKSiteAllocation_pageHeader);
		String PageHeader = Selenium.getText(Hksite.HKSiteAllocation_pageHeader);
		Asserts.assertEqual(PageHeader, "Site Allocation", "Correct Site Allocation page header is displayed");
	}

	@Step("To get the header of Allocate site page")
	public void GetAllocateSitesPageHeader(String PoolName) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(PoolName);
		WebInteract.waitForVisibility(Hksite.AllocatePanel);
		Selenium.click(Hksite.AllocatePanel);
		WebInteract.waitForVisibility(Hksite.Allocate_PageHeader);
		Logger.logMessage("Add Hk allocate sites page is displayed");
		String PageHeader = Selenium.getText(Hksite.Allocate_PageHeader);
		Asserts.assertEqual(PageHeader, "Allocate sites", "Allocate sites page header is Correct");
		Asserts.assertEqual(Selenium.getText(Hksite.PoolName), PoolName,
				"Correct poolname is displayed on allocate site page");
	}

	@Step("To get the header of view allocate site page")
	public void GetViewAllocateSitesPageHeader(String PoolName) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(PoolName);
		WebInteract.waitForVisibility(Hksite.ViewPanel);
		Selenium.click(Hksite.ViewPanel);
		WebInteract.waitForVisibility(Hksite.ViewSite_PageHeader);
		Logger.logMessage("View Allocate site page is displayed");
		String PageHeader = Selenium.getText(Hksite.ViewSite_PageHeader);
		Asserts.assertEqual(PageHeader, "View allocated sites", "View allocate sites page header is Correct");
		Asserts.assertEqual(Selenium.getText(Hksite.PoolName), PoolName,
				"Correct poolname is displayed on View allocate site page");
	}

	@Step("To search record on allocate site page")
	public void SearchRecord() throws Throwable {
		String Panelid = Selenium.getText(Hksite.Panelid_txt);
		Selenium.sendKeys(Hksite.SearchBy, Panelid);
		Selenium.click(Hksite.SearchOption);
		WebInteract.waitForVisibility(Hksite.Panelid_txt);
		Asserts.assertEqual(Selenium.getText(Hksite.Panelid_txt), Panelid,
				"Correct panelid is displayed after filtering records");
		Asserts.assertEqual(RecordCount(), 1, "Correct record count is displayed on page");
	}
	
	public void SearchViewSiteRecord() throws Throwable {
		String Panelid = Selenium.getText(Hksite.Panelid_txt);
		Selenium.sendKeys(Hksite.Search_option, Panelid);
		Selenium.click(Hksite.SearchOption);
		WebInteract.waitForVisibility(Hksite.Panelid_txt);
		Asserts.assertEqual(Selenium.getText(Hksite.Panelid_txt), Panelid,
				"Correct panelid is displayed after filtering records");
		Asserts.assertEqual(RecordCount(), 1, "Correct record count is displayed on page");
	}

	@Step("To allocate the sites to pool on allocate site page")
	public void AllocateSites(String PoolName, String Camera) throws Throwable {
		GetAllocateSitesPageHeader(PoolName);
		SearchRecord();
		Selenium.click(Hksite.Poollistbtn);
		GetAllocateSitesPageHeader(PoolName);
		Selenium.click(Hksite.checkall);
		int a = RecordCount();
		UpdateCamera(Camera,a);
		List<String> AllocatePanelid = GetPanelist();
		Collections.sort(AllocatePanelid);
		Selenium.click(Hksite.AllocateBtn);
		String message = WebInteract.getNonstaleElementGetText(Hksite.AllocateSitemsg);
		Asserts.assertEqual(message, "Site(s) allocated to pool successfully", "Sites allocated to pool successfully");
		Selenium.click(Hksite.Poollistbtn);
		GetViewAllocateSitesPageHeader(PoolName);
		//Asserts.assertEqual(RecordCount(), 10, "Correct site record count is displayed");
		List<String> ViewPanelid = GetPanelist();
		Collections.sort(ViewPanelid);
		Asserts.assertTrue(AllocatePanelid.equals(ViewPanelid),
				"Correct site list is displayed on allocated and view allocate site page");
		GetCameraNo(Camera);
		Selenium.click(Hksite.Poollistbtn);
		WebInteract.waitForVisibility(Hksite.HKSiteAllocation_pageHeader);
	}

	@Step("To update camera on view allocate site page")
	public void UpdateCameraOnViewSitepage(String PoolName, String CameraNo) throws Throwable {
		GetViewAllocateSitesPageHeader(PoolName);
		Selenium.click(Hksite.checkall);
		int d = RecordCount();
		UpdateCamera(CameraNo,d);
		Selenium.click(Hksite.UpdateCameraBtn);
		//WebInteract.waitForVisibility(Hksite.CameraUpdatemsg);
		String message = WebInteract.getNonstaleElementGetText(Hksite.CameraUpdatemsg);
		Asserts.assertEqual(message, "Camera no updated for site(s) successfully", "Camera no updated successfully");
		GetCameraNo(CameraNo);
	}

	@Step("To deallocate the sites from view allocated sites page")
	public void DeallocateSites(String poolname) throws Throwable {
		GetViewAllocateSitesPageHeader(poolname);
		Selenium.click(Hksite.checkall);
		Selenium.click(Hksite.DeallocateBtn);
		//WebInteract.waitForVisibility(Hksite.Deallocatesitemsg);
		String message = WebInteract.getNonstaleElementGetText(Hksite.Deallocatesitemsg);
		Asserts.assertEqual(message, "Site(s) deallocated sucessfully", "Sites are deallocated");
		int count = RecordCount();
		Asserts.assertEqual(count,0, "All sites are deallocated");
		Selenium.click(Hksite.Poollistbtn);
		WebInteract.waitForVisibility(Hksite.HKSiteAllocation_pageHeader);
		Asserts.assertEqual(Selenium.getText(Hksite.HKSiteAllocation_pageHeader), "Site Allocation",
				"Correct page is displayed on pool list");
		hmutil.GetHKpoolpage();
		hmp.DeletePoolRecord(poolname);
	}

	@Step("To Switch site from one pool to another pool")
	public void SwitchPool(String poolname, String SwitchPool) throws Throwable {
		GetViewAllocateSitesPageHeader(poolname);
		String Panelid = Selenium.getText(Hksite.Panelid_txt);
		SearchViewSiteRecord();
		Selenium.click(Hksite.checkall);
		Asserts.assertTrue(Hksite.checkall.isSelected(), "Select All checkbox is checked");
		Thread.sleep(1000);
		new Select(DriverManager.getWebDriver().findElement(By.xpath("//select[@id='UpdatedPoolID']"))).selectByVisibleText(SwitchPool);
		Selenium.click(Hksite.Switchpoolbtn);
		WebInteract.waitForVisibility(Hksite.SwitchSiteMsg);
		Asserts.assertEqual(Selenium.getText(Hksite.SwitchSiteMsg), "site(s) has been switch successfully",
				"Site is switch to selected pool");
		Selenium.click(Hksite.Poollistbtn);
		WebInteract.waitForVisibility(Hksite.HKSiteAllocation_pageHeader);
		GetViewAllocateSitesPageHeader(SwitchPool);
		searchfuncforValidData(Panelid);
		WebInteract.waitForVisibility(Hksite.RecordCount);
		Asserts.assertEqual(RecordCount(),1, "Correct count is displayed on allocate site page");
		Asserts.assertEqual(Selenium.getText(Hksite.Panelid_txt), Panelid,
				"Correct panelid is displayed on allocate site page");
		Selenium.click(Hksite.Poollistbtn);
		WebInteract.waitForVisibility(Hksite.HKSiteAllocation_pageHeader);
	}

	public void UpdateCamera(String CameraNo,int b) throws Throwable {

		String Beforexpath = "//select[@id='PanelList_";
		String Afterxpath = "__Camera']";
        int c;
        
        if(b >= 10) {
        	c = 10;
        }else {
        	c = b;
        }
		for (int i = 0; i < c; i++) {
			new Select(DriverManager.getWebDriver().findElement(By.xpath(Beforexpath + i + Afterxpath)))
					.selectByVisibleText(CameraNo);
		}
	}

	public void GetCameraNo(String camera) throws Throwable {
		String Beforexpath = "//select[@id='PanelList_";
		String Afterxpath = "__Camera']";
		int c = RecordCount();
		int b;
        if(c >= 10) {
        	b = 10;
        }else {
        	b = c;
        }
		for (int i = 0; i < b; i++) {
			String CameraList = DriverManager.getWebDriver().findElement(By.xpath(Beforexpath + i + Afterxpath))
					.getAttribute("value");
			Asserts.assertEqual(CameraList, camera, "Correct camera no is displayed on view allocate site page");
		}
	}

	public List<String> GetPanelist() {
		List<WebElement> Panellist = Hksite.Panelid_List;
		List<String> MyList = new ArrayList<String>();
		MyList.clear();
		for (int i = 0; i < Panellist.size(); i++) {
			String s = Panellist.get(i).getText();
			MyList.add(s);
		}
		return MyList;
	}

	public List<String> PanelListReport(){
		return GetPanelist();
	}
	
	public int RecordCount() throws Throwable {
		String TotalCount = Selenium.getText(Hksite.RecordCount);
		String[] count = TotalCount.split(":");
		String a = count[1].trim();
		int RecordCount = Integer.parseInt(a);
		return RecordCount;
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(Hksite.Search_option, searchtext);
		Selenium.click(Hksite.Go_option);
	}

	@Step("To get the validation message on site allocation page")
	public void GetValidationMsg(String PoolName) throws Throwable {
		GetAllocateSitesPageHeader(PoolName);
		Selenium.click(Hksite.AllocateBtn);
		WebInteract.waitForVisibility(Hksite.GetValidationAllocateSite);
		Asserts.assertEqual(Selenium.getText(Hksite.GetValidationAllocateSite),
				"Please select atleast one site for allocation",
				"Correct validation message is displayed on allocate site page");
		WebInteract.waitForNonVisibility(Hksite.GetValidationAllocateSite, 10);
		Selenium.click(Hksite.Poollistbtn);
		GetViewAllocateSitesPageHeader(PoolName);
		Selenium.click(Hksite.DeallocateBtn);
		WebInteract.waitForVisibility(Hksite.GetValidationDeAllocateSite);
		//Asserts.assertEqual(Hksite.GetValidationDeAllocateSite,"Please select at least one site to deallocate",
		//		"Correct validation message is displayed for deallocate button");
		WebInteract.waitForNonVisibility(Hksite.GetValidationDeAllocateSite, 10);
		Selenium.click(Hksite.UpdateCameraBtn);
		WebInteract.waitForVisibility(Hksite.GetValidationUpdateCamera);
		Asserts.assertEqual(Selenium.getText(Hksite.GetValidationUpdateCamera),
				"Please select at least one site to update camera",
				"Correct validation message is displayed for update camera button");
		WebInteract.waitForNonVisibility(Hksite.GetValidationUpdateCamera, 10);
		Selenium.click(Hksite.Switchpoolbtn);
		WebInteract.waitForVisibility(Hksite.GetValidationSwitchpool);
		Asserts.assertEqual(Selenium.getText(Hksite.GetValidationSwitchpool),
				"Please select pool to switch to another pool",
				"Correct validation message is displayed for switch pool button");
		
	}

	@Step("To deallocate monitoring done site")
	public void DeallocateMonitoringsites(String PoolName) throws Throwable {
		hmutil.GetHKSiteAllocationpage();
		GetViewAllocateSitesPageHeader(PoolName);
		Selenium.click(Hksite.checkall);
		Selenium.click(Hksite.DeallocateBtn);
		WebInteract.waitForVisibility(Hksite.DeallocatesitePopupTitle);
		Asserts.assertEqual(Selenium.getText(Hksite.DeallocatesitePopupTitle), "Deallocate Site",
				"Correct popup title is displayed on Deallocate site page");
		Asserts.assertEqual(Selenium.getText(Hksite.DeallocateAlertMsg),"By deallocating the sites from this pool, monitoring and report data for these sites will be deleted. Do you want to deallocate the sites?",
				"Correct alert message is displayed on deallocate page");
		Selenium.click(Hksite.DellocateNoOption);
		WebInteract.waitForVisibility(Hksite.ViewSite_PageHeader);
		Selenium.click(Hksite.DeallocateBtn);
		Selenium.click(Hksite.DellocateYesOption);
		WebInteract.waitForVisibility(Hksite.ViewSite_PageHeader);
		}

	@Step("To Switch monitoring done sites")
	public void SwitchMonitoredSites(String PoolName, String SwitchPool) throws Throwable {
		GetViewAllocateSitesPageHeader(PoolName);
		Selenium.click(Hksite.checkall);
		WebInteract.selectByTextFomDropdownfromStale(Hksite.SelectSwitchPool, SwitchPool);
		Selenium.click(Hksite.Switchpoolbtn);
		Asserts.assertEqual(Selenium.getText(Hksite.SwitchsitePopupTitle), "Switch Pool",
				"Correct switch pool popup is displayed");
		Asserts.assertEqual(Selenium.getText(Hksite.SwitchAlertMsg),
				"By switching the sites from this pool, monitoring and report data for these sites will be deleted. Do you want to switch the sites to another pool?\r\n"
						+ "",
				"Correct alert message is displayed for switch pool");
		Selenium.click(Hksite.DellocateNoOption);
		WebInteract.waitForVisibility(Hksite.ViewSite_PageHeader);
		Selenium.click(Hksite.Switchpoolbtn);
		Selenium.click(Hksite.DellocateYesOption);
		WebInteract.waitForVisibility(Hksite.SwitchSiteMsg);
		Asserts.assertEqual(Selenium.getText(Hksite.SwitchSiteMsg), "site(s) has been switch successfully\r\n" + "",
				"Correct switch pool is message is displayed");
	}

	public List<String> GetPanellistForDB(String PoolName) throws Throwable {
		GetAllocateSitesPageHeader(PoolName);
		List<String> list = GetPanelist();
		for(int i =0;i<10;i++) {
			list.get(i).replace("A", "1");
		}
		return list;
	}
}