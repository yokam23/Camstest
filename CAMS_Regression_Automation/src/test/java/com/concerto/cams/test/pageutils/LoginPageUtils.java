package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.LoginPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

public class LoginPageUtils {

	protected LoginPage LoginPage;

	public LoginPageUtils() {
		LoginPage = new LoginPage();
	}

	public Boolean LaunchCams(String Url) throws Throwable {
		Boolean status = false;
		DriverManager.getWebDriver().get(Url);
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(LoginPage.LaunchIcon);
		if (Selenium.isDisplayed(LoginPage.LaunchIcon)) {
			Logger.logMessage("Login Page is displayed");
			status = true;
		}

		return status;

	}

	public Boolean LaunchIns(String URL) throws Throwable {
		Boolean status = false;
		DriverManager.getWebDriver().get(URL);
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(LoginPage.INSloginPageTxt);
		if (Selenium.isDisplayed(LoginPage.INSloginPageTxt)) {
			Logger.logMessage("Installation tool login page is displayed");
			status = true;
		}
		return status;
	}

	public void ValidLoginToCams(String UserName, String Password) throws Throwable {
		Selenium.sendKeys(LoginPage.UserName, UserName);
		Selenium.sendKeys(LoginPage.Password, Password);
		Selenium.click(LoginPage.LoginButton);
	}

	public void ValidLoginToInstool(String UserName, String Password) throws Throwable {
		Selenium.sendKeys(LoginPage.InsUsername, UserName);
		Selenium.sendKeys(LoginPage.InsPassword, Password);
		Selenium.click(LoginPage.InsLoginBtn);
	}

	public void InValidLoginToCams(String UserName, String Password, String ErrorMessage) throws Throwable {
		Selenium.sendKeys(LoginPage.UserName, UserName);
		Selenium.sendKeys(LoginPage.Password, Password);
		Selenium.click(LoginPage.LoginButton);
		Thread.sleep(1000);
		Asserts.verifyElementPresent(LoginPage.LoginError, "Validate Error Message Is Displayed");
		Asserts.assertEqual(ErrorMessage, Selenium.getText(LoginPage.LoginError),
				"Validate Correct ErrorMessage Is Displayed");
	}

	/*
	 * public void Logout(String Url) throws Throwable { Thread.sleep(2000);
	 * DriverManager.getWebDriver().navigate().to(Url); Thread.sleep(4000);
	 * WebInteract.waitForVisibility(LoginPage.MoveToLogout);
	 * WebInteract.mouseOver(LoginPage.MoveToLogout);
	 * WebInteract.waitForVisibility(LoginPage.Logout);
	 * Selenium.click(LoginPage.Logout);
	 * 
	 * 
	 * }
	 */

	public void InsLogout() throws Throwable {
		WebInteract.waitForVisibility(LoginPage.InsLogoutoption);
		Selenium.click(LoginPage.InsLogoutoption);
		WebInteract.waitForVisibility(LoginPage.InsLogout);
		Selenium.click(LoginPage.InsLogout);
		WebInteract.waitForVisibility(LoginPage.INSloginPageTxt);
		System.out.println("User logged out successfully from application");
	}

	public void Logout() throws Throwable {
		WebInteract.waitForVisibility(LoginPage.MoveToLogout);
		WebInteract.mouseOver(LoginPage.MoveToLogout);
		WebInteract.waitForVisibility(LoginPage.Logout);
		Selenium.click(LoginPage.Logout);

	}

}
