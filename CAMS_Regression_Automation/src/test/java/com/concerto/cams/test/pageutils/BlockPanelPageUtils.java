package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.BlockPanelPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class BlockPanelPageUtils {
	
	BlockPanelPage BlockPanelPage;
	
public BlockPanelPageUtils() {
		
	BlockPanelPage = new BlockPanelPage();
	}
	
	@Step("navigate to UnBlock Panels")
	public void navigateToUnBlockPanels() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(BlockPanelPage.BlockPanelSearchGoButton);	
	}

	@Step("Entries for UnBlock Panels")
	public void UnBlockPanel(String SearchBlockPanel) throws Throwable {
		WebInteract.waitForVisibility(BlockPanelPage.LaunchBlockPanelPage);
		Selenium.sendKeys(BlockPanelPage.SearchBlockPanels, SearchBlockPanel);
		Selenium.click(BlockPanelPage.SelectSinglePanelCheckBox);
		Selenium.click(BlockPanelPage.UnBlockPanelButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you wish to unblock panels?", "Correct Alert Message Is Displayed for unblock panels");
		WebInteract.AcceptAlert();
		
		String SuccessMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(SuccessMessage, "Panel unblock successfully", "Success Message Displayed for Dealer Addition");		
	}
	
		
		
	}
