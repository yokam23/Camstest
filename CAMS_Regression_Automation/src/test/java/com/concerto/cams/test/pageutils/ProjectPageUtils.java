package com.concerto.cams.test.pageutils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.concerto.cams.test.pages.ProjectPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ProjectPageUtils {
	
	ProjectPage ProjectPage;

	public ProjectPageUtils() {
		
		ProjectPage = new ProjectPage();
	}
	

	@Step("navigate to Add project")
	public void navigateToAddProject() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(ProjectPage.AddButton);	
	}
	
	@Step("Entries for Add project")
	public void AddProject(String PanelType, String ClientName,  String ProjectName, String ZoneNoText, String SensorLocation,
			String DescriptionTextbox, String CameraDropDown, String SensorManufacturerDropdown, String CameraManuf,
			String CameraModel, String DVRManufacturerName, String DVRModelName, String DVRVersionName, String DVRSerialNo,
			String RouterManufacturerName, String RouterModelName, String RouterVersionName, String RouterSerialNo,
			String HDDManufacturerName, String HDDModelName, String HDDVersionName, String HDDSerialNo,String NetworkProvider, 
			String NetworkType, String TemplateSelectDropdown ) throws Throwable {
		WebInteract.waitForVisibility(ProjectPage.PanelType);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.PanelType, PanelType);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.ClientName, ClientName);
		Selenium.sendKeys(ProjectPage.TextProjectName, ProjectName);
		Selenium.click(ProjectPage.AddProjectButton);
		WebInteract.waitForVisibility(ProjectPage.AddViewProjectPage);
		Selenium.click(ProjectPage.SelectSensorCheck);
		Selenium.sendKeys(ProjectPage.ZoneNoTextbox, ZoneNoText);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.SensorLocationDropDown, SensorLocation);
		Selenium.sendKeys(ProjectPage.SensorDescriptionTextbox, DescriptionTextbox);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.SensorCameraDropDown, CameraDropDown);
		Selenium.click(ProjectPage.SensorSMSCheckbox);
		WebInteract.moveToElement(ProjectPage.NextButton);
		Selenium.click(ProjectPage.NextButton);
		WebInteract.waitForVisibility(ProjectPage.SensorManufacturerDropdown);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.SensorManufacturerDropdown, SensorManufacturerDropdown);
		Selenium.click(ProjectPage.NextButton);
		WebInteract.waitForVisibility(ProjectPage.CameraManuf);
		Selenium.sendKeys(ProjectPage.CameraManuf, CameraManuf);
		Selenium.sendKeys(ProjectPage.CameraModel, CameraModel);
		Selenium.click(ProjectPage.NextButton);
		WebInteract.waitForVisibility(ProjectPage.DVRManufacturerName);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.DVRManufacturerName, DVRManufacturerName);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.DVRModelName, DVRModelName);
		Selenium.sendKeys(ProjectPage.DVRVersionName, DVRVersionName);
		Selenium.sendKeys(ProjectPage.DVRSerialNo, DVRSerialNo);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.RouterManufacturerName, RouterManufacturerName);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.RouterModelName, RouterModelName);
		Selenium.sendKeys(ProjectPage.RouterVersionName, RouterVersionName);
		Selenium.sendKeys(ProjectPage.RouterSerialNo, RouterSerialNo);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.HDDManufacturerName, HDDManufacturerName);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.HDDModelName, HDDModelName);
		Selenium.sendKeys(ProjectPage.HDDVersionName, HDDVersionName);
		Selenium.sendKeys(ProjectPage.HDDSerialNo, HDDSerialNo);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.NetworkProvider, NetworkProvider);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.NetworkType, NetworkType);
		Selenium.click(ProjectPage.NextButton);
		WebInteract.waitForVisibility(ProjectPage.TemplateSelectDropdown);
		new Select(DriverManager.getWebDriver().findElement(By.xpath("(//select[@id='ddlesctemplate'])[1]"))).selectByVisibleText(TemplateSelectDropdown);
		//WebInteract.selectByTextFomDropdownfromStale(ProjectPage.TemplateSelectDropdown, TemplateSelectDropdown);
		/*Selenium.sendKeys(ProjectPage.AddProjectEscNameText, ESCName);
		Selenium.sendKeys(ProjectPage.AddProjectEscCommentsText, ESCComments);
		Selenium.sendKeys(ProjectPage.AddProjectEscTelephoneText, ESCTelephoneNo);
		Selenium.sendKeys(ProjectPage.AddProjectEscMobileTextbox, ESCMobileNo);
		Selenium.click(ProjectPage.AddProjectEscEmailCheckox);
		Selenium.sendKeys(ProjectPage.AddProjectEscEmailIDTextbox, ESCEmailID);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.AddProjectEscProrityDropdown, ESCPriority);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.AddProjectEscRepeatIntervalDropdown, ESCRepeatInterval);*/
		Selenium.click(ProjectPage.FinishButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Project added successfully", "Correct Alert Message Is Displayed for Add Project");
		WebInteract.AcceptAlert();
	}
	
	@Step("navigate to view project")
	public void navigateToViewproject() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(ProjectPage.LaunchProjectPage);
	}
	

	@Step("Entries for view project")
	public void Viewproject(String PanelType, String ClientName,  String ProjectName, String AllSensor, String AddSensor) throws Throwable {
		WebInteract.waitForVisibility(ProjectPage.PanelType);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.PanelType, PanelType);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.ClientName, ClientName);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.ProjectNameDropdown, ProjectName);
		Selenium.click(ProjectPage.ViewProjectButton);
		
	}
	
	@Step("navigate to Update project")
	public void navigateToUpdateproject() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.waitForVisibility(ProjectPage.UpdateViewProjectPage);
	}
	
	@Step("Entries for Update project")
	public void Updateproject(String PanelType, String ClientName,  String ProjectName) throws Throwable {
		WebInteract.waitForVisibility(ProjectPage.PanelType);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.PanelType, PanelType);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.ClientName, ClientName);
		WebInteract.selectByTextFomDropdownfromStale(ProjectPage.ProjectNameDropdown, ProjectName);
		Selenium.click(ProjectPage.ViewProjectButton);
		WebInteract.waitForVisibility(ProjectPage.UpdatetemplateDetails);
		
	}
}


//, String ESCName, String ESCComments, String ESCTelephoneNo,String 	ESCMobileNo, String ESCEmailID, String ESCPriority, String ESCRepeatInterval
