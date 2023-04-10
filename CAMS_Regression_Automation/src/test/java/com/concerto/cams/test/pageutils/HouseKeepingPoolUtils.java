package com.concerto.cams.test.pageutils;


import com.concerto.cams.test.pages.HkPool;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class HouseKeepingPoolUtils {

	protected HkPool hkpool;
	protected Homepageutils hmpage;

	public HouseKeepingPoolUtils() {
        hmpage = new Homepageutils();
		hkpool = new HkPool();
	}

	@Step("To get the header of HK pool page")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("Pool :: CAMSPlus");
		WebInteract.waitForVisibility(hkpool.Page_Header);
		String PageHeader = Selenium.getText(hkpool.Page_Header);
		Asserts.assertEqual(PageHeader, "Pool", "Correct Pool page header is displayed");
	}

	@Step("To get the header of Add new HK pool page")
	public void GetAddPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(hkpool.Addpoolbtn);
		WebInteract.waitForVisibility(hkpool.SelectClient);
		Logger.logMessage("Add Hk pool page is displayed");
		String PageHeader = Selenium.getText(hkpool.Add_page_header);
		Asserts.assertEqual(PageHeader, "Add Pool", "Add new HK pool page header is Correct");
	}

	@Step("To get the header of Edit HK Agency page")
	public void GetEditPageHeader() throws Throwable {
		WebInteract.waitForVisibility(hkpool.Edit_page_header);
		String PageHeader = Selenium.getText(hkpool.Edit_page_header);
		Asserts.assertEqual(PageHeader, "Edit Pool", "Edit HK pool page header is Correct");
	}

	@Step("To add new HK pool")
	public void AddNewPool(String ClientName, String HKPool) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(hkpool.SelectClient, ClientName);
		Selenium.sendKeys(hkpool.PoolName, HKPool);
		Selenium.click(hkpool.NewPoolAdd);
		// WebInteract.waitForVisibility(hkpool.SuccessfulMsg);
		String message = WebInteract.getNonstaleElementGetText(hkpool.SuccessfulMsg);
		Asserts.assertEqual(message, "Pool added successfully", "Correct message is displayed on pool page");
		searchfuncforValidData(HKPool);
		WebInteract.waitForVisibility(hkpool.ValidatePoolName);
		Asserts.assertEqual(RecordCount(), 1, "Record count is match on pool page");
		Asserts.assertEqual(Selenium.getText(hkpool.ValidateClientName), ClientName,
				"Correct client name is displayed on page");
		Asserts.assertEqual(Selenium.getText(hkpool.ValidatePoolName), HKPool,
				"Correct pool name is displayed on page");
	}

	@Step("To validate duplicate pool records")
	public void ValidateDuplicatePoolRecords(String ClientName, String HKPool) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(hkpool.SelectClient, ClientName);
		Selenium.sendKeys(hkpool.PoolName, HKPool);
		Selenium.click(hkpool.NewPoolAdd);
		// WebInteract.waitForVisibility(hkpool.ValidateDuplicates);
		String message = WebInteract.getNonstaleElementGetText(hkpool.ValidateDuplicates);
		Asserts.assertEqual(message, "This Pool already exists with selected Client",
				"Correct validation message is displayed for Duplicate records");
		Selenium.click(hkpool.CloseBtn);
	}

	@Step("To edit the hk pool record")
	public void EditPoolrecord(String HKPool, String Searchtxt) throws Throwable {
		searchfuncforValidData(Searchtxt);
		WebInteract.waitForVisibility(hkpool.RecordCount);
		Asserts.assertEqual(RecordCount(), 1, "Record count is match on pool page");
		Selenium.click(hkpool.EditBtn);
		GetEditPageHeader();
		Selenium.clear(hkpool.PoolName);
		Selenium.sendKeys(hkpool.PoolName, HKPool);
		Selenium.click(hkpool.Updatebtn);
		String message = WebInteract.getNonstaleElementGetText(hkpool.UpdateMsg);
		Asserts.assertEqual(message, "Pool updated successfully", "Pool updated successfully");
		searchfuncforValidData(HKPool);
		// WebInteract.waitForVisibility(hkpool.UpdateMsg);
		Asserts.assertEqual(WebInteract.getNonstaleElementGetText(hkpool.ValidatePoolName), HKPool,
				"Correct updated HKPool is displayed");
	}

	@Step("To delete the hk pool record")
	public void DeletePoolRecord(String HKPool) throws Throwable {
		searchfuncforValidData(HKPool);
		WebInteract.waitForVisibility(hkpool.RecordCount);
		Asserts.assertEqual(RecordCount(),1, "Record count is match on pool page");
		WebInteract.waitForVisibility(hkpool.DeleteBtn);
		Selenium.click(hkpool.DeleteBtn);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you wish to delete this pool?", "Correct alert message is displayed for deleting pool");
		WebInteract.AcceptAlert();
		// WebInteract.waitForVisibility(hkpool.DeleteMsg);
		String message = WebInteract.getNonstaleElementGetText(hkpool.DeleteMsg);
		Asserts.assertEqual(message, "Pool has been deleted successfully",
				"Correct deletion message is displayed on hk pool page");
		searchfuncforValidData(HKPool);
		WebInteract.waitForVisibility(hkpool.RecordCount);
		Asserts.assertEqual(RecordCount(),0, "Record count is match on pool page");
	}
	
	@Step("To get validation message for monitored sites")
	public void DeleteAllocatesitePool(String Poolname) throws Throwable {
		hmpage.GetHKpoolpage();
		searchfuncforValidData(Poolname);
		WebInteract.waitForVisibility(hkpool.RecordCount);
		Asserts.assertEqual(RecordCount(),1, "Record count is match on pool page");
		WebInteract.waitForVisibility(hkpool.DeleteBtn);
		Selenium.click(hkpool.DeleteBtn);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you wish to delete this pool?", "Correct alert message is displayed for deleting pool");
		WebInteract.AcceptAlert();
		WebInteract.waitForVisibility(hkpool.Deletevalidation);
		Asserts.assertEqual(Selenium.getText(hkpool.Deletevalidation), "Sites should be deallocated before deleting Pool.", "Correct validation message is displayed while deleting pool");
		WebInteract.waitForNonVisibility(hkpool.Deletevalidation, 10);
	}

	@Step("To validate the validation message while adding new pool")
	public void GetValidationMessage(String ClientName) throws Throwable {
		WebInteract.selectByTextFomDropdownfromStale(hkpool.SelectClient, ClientName);
		Selenium.click(hkpool.NewPoolAdd);
		// WebInteract.waitForVisibility(hkpool.AddPoolValidation);
		String message = WebInteract.getNonstaleElementGetText(hkpool.AddPoolValidation);
		Asserts.assertEqual(message, "Pool is required", "Correct validation message is displayed for pool field");
		Selenium.click(hkpool.CloseBtn);
	}

	@Step("To search the entry on page with valid data")
	public void searchfuncforValidData(String searchtext) throws Throwable {
		Selenium.sendKeys(hkpool.Search_option, searchtext);
		Selenium.click(hkpool.Go_option);
	}

	public int RecordCount() throws Throwable {
		String TotalCount = Selenium.getText(hkpool.RecordCount);
		String[] count = TotalCount.split(":");
		// System.out.println(count[1].trim());
		String a = count[1].trim();
		int RecordCount = Integer.parseInt(a);
		return RecordCount;
	}

}
