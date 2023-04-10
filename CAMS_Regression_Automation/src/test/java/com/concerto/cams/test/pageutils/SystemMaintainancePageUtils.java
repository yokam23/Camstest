package com.concerto.cams.test.pageutils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.concerto.cams.test.pages.SystemMaintainancePage;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class SystemMaintainancePageUtils {
	
	SystemMaintainancePage SystemMaintainancePage;

	public SystemMaintainancePageUtils() {
		
		SystemMaintainancePage = new SystemMaintainancePage();
	}
	
	@Step("Entries for Activate client In System Maintainance")
	public void ActivateClientInSM(String SelectClient, String DualLoginID, String Password, String Comments) throws Throwable {
		WebInteract.waitForVisibility(SystemMaintainancePage.SelectClient);
		WebInteract.selectByTextFomDropdownfromStale(SystemMaintainancePage.SelectClient, SelectClient);
		Selenium.click(SystemMaintainancePage.ActivateClientButton);
		Selenium.sendKeys(SystemMaintainancePage.DualLoginIDText, DualLoginID);
		Selenium.sendKeys(SystemMaintainancePage.DualPasswordText, Password);
		Selenium.sendKeys(SystemMaintainancePage.DualCommentText, Comments);
		Selenium.click(SystemMaintainancePage.DualOkButton);
		WebInteract.WaitForAlert();
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertContains(SuccessMessage, " Able to Activate Client", "Correct Alert Message Is Displayed for Activate client");
		WebInteract.AcceptAlert();
}

	@Step("Entries for Deactivate client In System Maintainance ")
	public void DeactivateClientInSM(String SelectClient, String DualLoginID, String Password, String Comments) throws Throwable {
		WebInteract.waitForVisibility(SystemMaintainancePage.SelectClient);
		WebInteract.selectByTextFomDropdownfromStale(SystemMaintainancePage.SelectClient, SelectClient);
		Selenium.click(SystemMaintainancePage.DeactivateClientButton);
		Selenium.sendKeys(SystemMaintainancePage.DualLoginIDText, DualLoginID);
		Selenium.sendKeys(SystemMaintainancePage.DualPasswordText, Password);
		Selenium.sendKeys(SystemMaintainancePage.DualCommentText, Comments);
		Selenium.click(SystemMaintainancePage.DualOkButton);
		WebInteract.WaitForAlert();
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertContains(SuccessMessage, " Able to Deactivate Client", "Correct Alert Message Is Displayed for Activate client");
		WebInteract.AcceptAlert();
   }
	
	@Step("navigate to Select client for change Panel Mode")
	public void navigateToSelectClient(String SelectClient) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(SystemMaintainancePage.SelectClient, SelectClient);	
	}

	@Step("Entries for Change Panel Mode Test To Quality In System Maintainance")
	public void TestToQuality(String SelectClient, String SelectLeft, String DualLoginID, String Password,
			String Comments, String SelectCircle) throws Throwable {
		WebInteract.waitForVisibility(SystemMaintainancePage.SelectClient);
		new Select(DriverManager.getWebDriver().findElement(By.xpath("//select[@id='clients']"))).selectByVisibleText(SelectClient);
		//WebInteract.selectByTextFomDropdownfromStale(SystemMaintainancePage.SelectClient, SelectClient);
		Thread.sleep(1000);
		List<WebElement> list = DriverManager.getWebDriver().findElements(By.xpath("//select[@id='SelectLeft']//option"));
		//System.out.println(list.size());
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase(SelectLeft)) {
				DriverManager.getWebDriver().findElement(By.xpath("(//select[@id='SelectLeft']//option)["+(i+1)+"]")).click();
				break;
			}
		}
		Selenium.click(SystemMaintainancePage.SelectRightButton);
		Selenium.click(SystemMaintainancePage.QualitytRadioButton);
		Selenium.sendKeys(SystemMaintainancePage.DualLoginIDText, DualLoginID);
		Selenium.sendKeys(SystemMaintainancePage.DualPasswordText, Password);
		Selenium.sendKeys(SystemMaintainancePage.DualCommentText, Comments);
		Selenium.sendKeys(SystemMaintainancePage.DualSelectCircle, SelectCircle);
		Selenium.click(SystemMaintainancePage.DualOkButton);
		WebInteract.WaitForAlert();
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertContains(SuccessMessage, "1 Panel(s) mode changed from Test to  Quality , and","Correct alert message is displayed on changing panel mode");
		WebInteract.AcceptAlert();
	}
	
	@Step("Entries for Change Panel Mode Quality to Live In System Maintainance")
	public void ChangePanelModeQualityToLive(String SelectClient, String SelectLeft, String DualLoginID, String Password,
			String Comments, String SelectCircle) throws Throwable {
		WebInteract.waitForVisibility(SystemMaintainancePage.SelectClient);
		WebInteract.selectByTextFomDropdownfromStale(SystemMaintainancePage.SelectClient, SelectClient);
		Selenium.sendKeys(SystemMaintainancePage.SelectLeft, SelectLeft);
		Selenium.click(SystemMaintainancePage.SelectRightButton);
		Selenium.click(SystemMaintainancePage.LivetRadioButton);
		Selenium.sendKeys(SystemMaintainancePage.DualLoginIDText, DualLoginID);
		Selenium.sendKeys(SystemMaintainancePage.DualPasswordText, Password);
		Selenium.sendKeys(SystemMaintainancePage.DualCommentText, Comments);
		Selenium.sendKeys(SystemMaintainancePage.DualSelectCircle, SelectCircle);
		Selenium.click(SystemMaintainancePage.DualOkButton);
		WebInteract.WaitForAlert();
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertContains(SuccessMessage, "Panel Mode chnaged from Quality to Live", "Correct Alert Message Is Displayed for change panel mode");
		WebInteract.AcceptAlert();
	}
	
	@Step("Entries for Change Panel Mode Live to service In System Maintainance")
	public void LiveToService(String SelectClient, String SelectLeft, String DualLoginID, String Password,
			String Comments, String SelectCircle) throws Throwable {
		WebInteract.waitForVisibility(SystemMaintainancePage.SelectClient);
		WebInteract.selectByTextFomDropdownfromStale(SystemMaintainancePage.SelectClient, SelectClient);
		Thread.sleep(1000);
		List<WebElement> list = DriverManager.getWebDriver().findElements(By.xpath("//select[@id='SelectLeft']//option"));
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase(SelectLeft)) {
				DriverManager.getWebDriver().findElement(By.xpath("(//select[@id='SelectLeft']//option)["+(i+1)+"]")).click();
				break;
			}
		}
		Selenium.click(SystemMaintainancePage.SelectRightButton);
		Selenium.click(SystemMaintainancePage.ServiceRadioButton);
		Selenium.sendKeys(SystemMaintainancePage.DualLoginIDText, DualLoginID);
		Selenium.sendKeys(SystemMaintainancePage.DualPasswordText, Password);
		Selenium.sendKeys(SystemMaintainancePage.DualCommentText, Comments);
		Selenium.sendKeys(SystemMaintainancePage.DualSelectCircle, SelectCircle);
		Selenium.click(SystemMaintainancePage.DualOkButton);
		WebInteract.WaitForAlert();
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertContains(SuccessMessage, "1 Panel(s) mode changed from Live to  Service , and","Correct alert message is displayed on changing panel mode");
		WebInteract.AcceptAlert();
	}
	
	@Step("Entries for Change Panel Mode Live to service In System Maintainance")
	public void ServiceTolive(String SelectClient, String SelectLeft, String DualLoginID, String Password,
			String Comments, String SelectCircle) throws Throwable {
		WebInteract.waitForVisibility(SystemMaintainancePage.SelectClient);
		WebInteract.selectByTextFomDropdownfromStale(SystemMaintainancePage.SelectClient, SelectClient);
		Thread.sleep(1000);
		List<WebElement> list = DriverManager.getWebDriver().findElements(By.xpath("//select[@id='SelectLeft']//option"));
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase(SelectLeft)) {
				DriverManager.getWebDriver().findElement(By.xpath("(//select[@id='SelectLeft']//option)["+(i+1)+"]")).click();
				break;
			}
		}
		Selenium.click(SystemMaintainancePage.SelectRightButton);
		Selenium.click(SystemMaintainancePage.LivetRadioButton);
		Selenium.sendKeys(SystemMaintainancePage.DualLoginIDText, DualLoginID);
		Selenium.sendKeys(SystemMaintainancePage.DualPasswordText, Password);
		Selenium.sendKeys(SystemMaintainancePage.DualCommentText, Comments);
		Selenium.sendKeys(SystemMaintainancePage.DualSelectCircle, SelectCircle);
		Selenium.click(SystemMaintainancePage.DualOkButton);
		WebInteract.WaitForAlert();
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertContains(SuccessMessage, "1 Panel(s) mode changed from Service to  Live , and","Correct alert message is displayed on changing panel mode");
		WebInteract.AcceptAlert();
	}
	
	@Step("Entries for Change Panel Mode Service To Live In System Maintainance")
	public void QualityTolive(String SelectClient, String SelectLeft, String DualLoginID, String Password,
			String Comments, String SelectCircle) throws Throwable {
		WebInteract.waitForVisibility(SystemMaintainancePage.SelectClient);
		WebInteract.selectByTextFomDropdownfromStale(SystemMaintainancePage.SelectClient, SelectClient);
		List<WebElement> list = DriverManager.getWebDriver().findElements(By.xpath("//select[@id='SelectLeft']//option"));
		//System.out.println(list.size());
		Thread.sleep(1000);
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase(SelectLeft)) {
				DriverManager.getWebDriver().findElement(By.xpath("(//select[@id='SelectLeft']//option)["+(i+1)+"]")).click();
				break;
			}
		}	
		Selenium.click(SystemMaintainancePage.SelectRightButton);
		Selenium.click(SystemMaintainancePage.LivetRadioButton);
		Selenium.sendKeys(SystemMaintainancePage.DualLoginIDText, DualLoginID);
		Selenium.sendKeys(SystemMaintainancePage.DualPasswordText, Password);
		Selenium.sendKeys(SystemMaintainancePage.DualCommentText, Comments);
		Selenium.sendKeys(SystemMaintainancePage.DualSelectCircle, SelectCircle);
		Selenium.click(SystemMaintainancePage.DualOkButton);
		WebInteract.WaitForAlert();
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertContains(SuccessMessage, "1 Panel(s) mode changed from Quality to  Live , and", "Correct Alert Message Is Displayed for change panel mode");
		WebInteract.AcceptAlert();
	}
	
	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}
}