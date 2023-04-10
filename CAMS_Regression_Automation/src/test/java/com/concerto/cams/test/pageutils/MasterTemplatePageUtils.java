package com.concerto.cams.test.pageutils;

import com.concerto.cams.test.pages.MasterTemplate;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class MasterTemplatePageUtils {

	MasterTemplate MasterTemplate;
	
public MasterTemplatePageUtils() {
		
	MasterTemplate = new MasterTemplate();
	}
	
@Step("navigate to Update ATM Master Template")
public void navigateToUpdateATMMasterTemplate() throws Throwable {
	WebInteract.waitForPageLoad(DriverManager.getWebDriver());
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.SelectPaneType, "ATM");
	Selenium.click(MasterTemplate.GoButton);	
}

@Step("Entries for Update ATM Master Template")
public void UpdateATMMasterTemplate(String Location, String Description, String Camera) throws Throwable {
	WebInteract.waitForVisibility(MasterTemplate.TemplateHeader);
	Thread.sleep(3000);
	//Selenium.sendKeys(MasterTemplate.LocationATMTextbox, Location);
	//Selenium.sendKeys(MasterTemplate.DescriptionATMTextbox, Description);
	//Selenium.click(MasterTemplate.SchedulerATMCheckbox);
	//WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.CameraATMDropDown, Camera);
	WebInteract.moveToElement(MasterTemplate.TemplateATMUpdateButton);
	Selenium.click(MasterTemplate.TemplateATMUpdateButton);
	WebInteract.WaitForAlert();
	String AlertText = WebInteract.AlertGetText();
	Asserts.assertContains(AlertText, "Are you sure you want to update ?", "Correct Alert Message Is Displayed for Update ATM Master Tempalate");
	WebInteract.AcceptAlert();
	
	String SuccessMessage =WebInteract.getNonstaleElementGetText(MasterTemplate.UpdateSuccessMsg);
	Asserts.assertEqual(SuccessMessage, "Template For ATM Panels Templates has been updated successfully", "Success Message Displayed for ATM Tamplate Update");		
}

@Step("navigate to Update ATMEscalationTemplate")
public void navigateToUpdateATMEscalationTemplate(String ATM) throws Throwable {
	WebInteract.waitForPageLoad(DriverManager.getWebDriver());
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.SelectPaneType, ATM);
	Selenium.click(MasterTemplate.GoButton);	
}

@Step("Entries for Update ATMEscalationTemplate")
public void UpdateATMEscalationTemplate(String Name, String Comments, String TelephoneNo, String SMS , String MobileNo,
		String Email, String EmailID, String Priority, String RepeatIntervalMin) throws Throwable {
	WebInteract.waitForVisibility(MasterTemplate.NameTextbox);
	Selenium.sendKeys(MasterTemplate.NameTextbox, Name);
	Selenium.sendKeys(MasterTemplate.CommentsTextbox, Comments);
	Selenium.sendKeys(MasterTemplate.TelephoneNoTextbox, TelephoneNo);
	Selenium.click(MasterTemplate.EscTempSMSCheckbox);
	Selenium.sendKeys(MasterTemplate.MobileTextbox, MobileNo);
	Selenium.click(MasterTemplate.EmailCheckbox);
	Selenium.sendKeys(MasterTemplate.EmailIDTextbox, EmailID);
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.PriorityDropDown, Priority);
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.RepeatIntervalMinDropDown, RepeatIntervalMin);
	Selenium.click(MasterTemplate.EscUpdateButton);
	WebInteract.WaitForAlert();
	String AlertText = WebInteract.AlertGetText();
	Asserts.assertContains(AlertText, "Are you sure you want to update ?", "Correct Alert Message Is Displayed for Update ATM Master Escalation Tempalate");
	WebInteract.AcceptAlert();
	
	String SuccessMessage =Selenium.getText(MasterTemplate.UpdateSuccessMsg);
	Asserts.assertEqual(SuccessMessage, "Escalation Updated Successfully", "Success Message Displayed for ATM Tamplate Update");		
}

@Step("navigate to Update Commercial MasterTemplate")
public void navigateToUpdateCommercialMasterTemplate(String Commercial) throws Throwable {
	WebInteract.waitForPageLoad(DriverManager.getWebDriver());
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.SelectPaneType, Commercial);
	Selenium.click(MasterTemplate.GoButton);	
}

@Step("Entries for Update Commercial Master Template")
public void UpdateCommercialMasterTemplate(String Location, String Description, String Scheduler, String Camera ,
		String SMS) throws Throwable {
	WebInteract.waitForVisibility(MasterTemplate.LocationCommercialTextbox);
	Selenium.sendKeys(MasterTemplate.LocationCommercialTextbox, Location);
	Selenium.sendKeys(MasterTemplate.DescriptionCommercialTextbox, Description);
	Selenium.click(MasterTemplate.SchedulerCommercialCheckbox);
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.CameraCommercialTextbox, Camera);
	Selenium.click(MasterTemplate.CommercialTempSMSCheckbox);
	Selenium.click(MasterTemplate.TemplateCommercialUpdateButton);
	WebInteract.WaitForAlert();
	String AlertText = WebInteract.AlertGetText();
	Asserts.assertContains(AlertText, "Are you sure you want to update ?", "Correct Alert Message Is Displayed for Update Commercial ATM Master Tempalate");
	WebInteract.AcceptAlert();
	
	String SuccessMessage =Selenium.getText(MasterTemplate.UpdateSuccessMsg);
	Asserts.assertEqual(SuccessMessage, "Template For Commercial Panels Templates has been updated successfully", "Success Message Displayed for Commercial Tamplate Update");		
}



@Step("navigate to Update Commercial Escalation Template")
public void navigateToUpdateCommercialEscalationTemplate(String Commercial) throws Throwable {
	WebInteract.waitForPageLoad(DriverManager.getWebDriver());
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.SelectPaneType, Commercial);
	Selenium.click(MasterTemplate.GoButton);	
}

@Step("Entries for Update Commercial Escalation Template")
public void UpdateCommercialEscalationTemplate(String Name, String Comments, String TelephoneNo, String SMS , String MobileNo,
		String Email, String EmailID, String Priority, String RepeatIntervalMin) throws Throwable {
	WebInteract.waitForVisibility(MasterTemplate.CommercialEscNameTextbox);
	Selenium.sendKeys(MasterTemplate.CommercialEscNameTextbox, Name);
	Selenium.sendKeys(MasterTemplate.CommercialEscCommentsTextbox, Comments);
	Selenium.sendKeys(MasterTemplate.CommercialEscTelephoneNoTextbox, TelephoneNo);
	Selenium.click(MasterTemplate.CommercialEscTempSMSCheckbox);
	Selenium.sendKeys(MasterTemplate.CommercialEscMobileTextbox, MobileNo);
	Selenium.click(MasterTemplate.CommercialEscEmailCheckbox);
	Selenium.sendKeys(MasterTemplate.CommercialEscEmailIDTextbox, EmailID);
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.CommercialEscPriorityDropDown, Priority);
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.CommercialEscRepeatIntervalMinDropDown, RepeatIntervalMin);
	Selenium.click(MasterTemplate.CommercialEscEscUpdateButton);
	WebInteract.WaitForAlert();
	String AlertText = WebInteract.AlertGetText();
	Asserts.assertContains(AlertText, "Are you sure you want to update ?", "Correct Alert Message Is Displayed for Update commercial Master Escalation Tempalate");
	WebInteract.AcceptAlert();
	
	String SuccessMessage =Selenium.getText(MasterTemplate.UpdateSuccessMsg);
	Asserts.assertEqual(SuccessMessage, "Escalation Updated Successfully", "Success Message Displayed for Commercial Escalation Tamplate Update");		
}

@Step("navigate to Update CommercialSchedulerTemplate")
public void navigateToUpdateCommercialSchedulerTemplate(String Commercial) throws Throwable {
	WebInteract.waitForPageLoad(DriverManager.getWebDriver());
	WebInteract.selectByTextFomDropdownfromStale(MasterTemplate.SelectPaneType, Commercial);
	Selenium.click(MasterTemplate.GoButton);	
}

@Step("Entries for Update CommercialSchedulerTemplate")
public void UpdateCommercialSchedulerTemplate(String Day, String DayType, String OpenTime, String EarlyOpenTime , String LateOpenTime,
		String CloseTime, String EarlyCloseTime, String LateCloseTime) throws Throwable {
	WebInteract.waitForVisibility(MasterTemplate.CommercialTempDAYTextbox);
	Selenium.sendKeys(MasterTemplate.CommercialTempDAYTextbox, Day);
	Selenium.sendKeys(MasterTemplate.CommercialTempDAYTypeTextbox, DayType);
	Selenium.sendKeys(MasterTemplate.CommercialTempOpenTimeTextbox, OpenTime);
	Selenium.sendKeys(MasterTemplate.CommercialTempEarlyOpenTimeTextbox, EarlyOpenTime);
	Selenium.sendKeys(MasterTemplate.CommercialTempLateOpenTimeTextbox, LateOpenTime);
	Selenium.sendKeys(MasterTemplate.CommercialTempCloseTimeTextbox, CloseTime);
	Selenium.sendKeys(MasterTemplate.CommercialTempEarlyCloseTimeTextbox, EarlyCloseTime);
	Selenium.sendKeys(MasterTemplate.CommercialTempLateCloseTimeTextbox, LateCloseTime);
	Selenium.click(MasterTemplate.CommercialEscEscUpdateButton);
	WebInteract.WaitForAlert();
	String AlertText = WebInteract.AlertGetText();
	Asserts.assertContains(AlertText, "Are you sure you want to update ?", "Correct Alert Message Is Displayed for Update Commercial Master schedular Tempalate");
	WebInteract.AcceptAlert();
	
	String SuccessMessage =Selenium.getText(MasterTemplate.UpdateSuccessMsg);
	Asserts.assertEqual(SuccessMessage, "schedular Updated Successfully", "Success Message Displayed forCommercial Master schedular  Update");		
}



}
