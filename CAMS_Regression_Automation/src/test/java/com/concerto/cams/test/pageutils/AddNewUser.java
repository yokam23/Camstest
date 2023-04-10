package com.concerto.cams.test.pageutils;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.concerto.cams.test.pages.Users;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class AddNewUser {

	Users user;

	public AddNewUser() {
		user = new Users();
	}

	@Step("To get the user page title")
	public void GetPageTitle() throws Throwable {
		WebInteract.waitForVisibility(user.Adduserbtn);
		WebInteract.validatePageTitle("User :: CAMSPlus");
	}

	@Step("To get the add user page header")
	public void AdduserPageheader() throws Throwable {
		Asserts.assertEqual(Selenium.getText(user.Adduserheader), "Add User",
				"Correct page header is displayed on add page header");
	}

	@Step("To add new user")
	public void Adduser(String Username, String Usertype, String Address, String MobileNo, String Emailid,
			String StateName, String cityname, String Pincode, String loginid, String Password, String CircleName)
			throws Throwable {
		WebInteract.waitForVisibility(user.Adduserbtn);
		Selenium.click(user.Adduserbtn);
		WebInteract.waitForVisibility(user.Adduserheader);
		AdduserPageheader();
		Selenium.sendKeys(user.Username, Username);
		WebInteract.selectByTextFomDropdownfromStale(user.Usertype, Usertype);
		WebInteract.selectByTextFomDropdownfromStale(user.Shift, GetShift());
		Selenium.sendKeys(user.Address, Address);
		Selenium.sendKeys(user.MobileNo, MobileNo);
		Selenium.sendKeys(user.Emailid, Emailid);
		WebInteract.selectByTextFomDropdownfromStale(user.StateName, StateName);
		Thread.sleep(1000);
		WebInteract.selectByTextFomDropdownfromStale(user.CityName, cityname);
		Selenium.sendKeys(user.Pincode, Pincode);
		Selenium.sendKeys(user.Loginid, loginid);
		Selenium.sendKeys(user.Password, Password);
		Selenium.sendKeys(user.ConfirmPassword, Password);
		if (Usertype.equalsIgnoreCase("Client Admin")) {
			WebInteract.selectByTextFomDropdownfromStale(user.Clientname, CircleName);
			Selenium.click(user.Chartcheckbox);
			Selenium.click(user.Reportcheckbox);
			Selenium.click(user.Liveviewcheckbox);
			Selenium.click(user.Addbtn);
			WebInteract.WaitForAlert();
			Asserts.assertEqual(WebInteract.AlertGetText(), "User Added successfully",
					"correct alert message is displayed");
			WebInteract.AcceptAlert();
		}

		if (Usertype.equalsIgnoreCase("Operator")) {
			Selenium.click(user.Addbtn);
			WebInteract.WaitForAlert();
			Asserts.assertEqual(WebInteract.AlertGetText(), "User Added successfully.Assign circle to this user.",
					"correct alert message is displayed");
			WebInteract.AcceptAlert();
			WebInteract.waitForVisibility(user.AssignCircle);
			Selenium.click(user.AssignCircle);
			WebInteract.waitForVisibility(user.AssignCircleHeader);
			SelectCircle(CircleName);
			Selenium.click(user.Savebtn);
			WebInteract.WaitForAlert();
			Asserts.assertEqual(WebInteract.AlertGetText(), "Are you sure you want to assign circle to user ?",
					"Correct alert message is displayed while assigning circle");
			WebInteract.AcceptAlert();
			Asserts.assertEqual(WebInteract.getNonstaleElementGetText(user.Successmsg), "Circle assigned successfully",
					"Correct success message is displayed");
			Selenium.click(user.Closebtn);
		}

	}

	@Step("To change the password for new user")
	public void ChangePassword() throws Throwable {
		WebInteract.waitForVisibility(user.Pageheader);
		Thread.sleep(2000);
		Selenium.sendKeys(user.OldPassword, "Concerto@1");
		Selenium.sendKeys(user.NewPassword, "Concerto@123");
		Selenium.sendKeys(user.ConfirmNewPassword, "Concerto@123");
		Selenium.click(user.Submitbtn);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Password Changed Successfully ",
				"Correct message is displayed after changing password");
		WebInteract.AcceptAlert();
	}

	public String GetShift() {
		LinkedList<String> l1 = new LinkedList<String>();
		l1.clear();
		List<WebElement> Schedulelist = new Select(
				DriverManager.getWebDriver().findElement(By.xpath("//select[@id='ddlshift']"))).getOptions();
		for (int i = 0; i < Schedulelist.size(); i++) {
			String a = Schedulelist.get(i).getText();
			l1.add(a);
		}
		// System.out.println(l1);
		return l1.get(Schedulelist.size() - 1);
	}

	public void SelectCircle(String CircleName) throws Throwable {
		List<WebElement> circlelist = DriverManager.getWebDriver()
				.findElements(By.xpath("(//div[@class='modal-body']//div[@class='col-md-12'])[2]//div//div"));
		String Beforexpath = "//div[@class='modal-body']//input[@name='[";
		String Afterxpath = "].IsChecked']";
		for (int i = 0; i < circlelist.size(); i++) {
			System.out.println(circlelist.get(i).getText());
			System.out.println(CircleName);
			if (circlelist.get(i).getText().equalsIgnoreCase(CircleName)) {
				Selenium.click(DriverManager.getWebDriver().findElement(By.xpath(Beforexpath + i + Afterxpath)));
			}
		}
	}
}
