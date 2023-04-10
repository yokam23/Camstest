package com.concerto.cams.test.pageutils;

import org.testng.Assert;

import com.concerto.cams.test.pages.ProjectTeamPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;

import io.qameta.allure.Step;

public class ProjectTeamPageUtils {


	ProjectTeamPage ProjectTeamPage;
	
	public ProjectTeamPageUtils() {
		
		ProjectTeamPage = new ProjectTeamPage();
	}
	
	@Step("navigate to add Project team")
	public void navigateToAddProjectTeam() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(ProjectTeamPage.AddButton);
	}
	

	@Step("Entries for add Project team")
	public void AddProjectTeam(String MemberName, String Role, String EmailID, String MobileNo) throws Throwable {
		WebInteract.waitForVisibility(ProjectTeamPage.AddMemberName);
		Selenium.sendKeys(ProjectTeamPage.AddMemberName, MemberName);
		WebInteract.selectByTextFomDropdownfromStale(ProjectTeamPage.AddRole, Role);
		Selenium.sendKeys(ProjectTeamPage.AddEmailID, EmailID);
		Selenium.sendKeys(ProjectTeamPage.AddMobileNo, MobileNo);
		Selenium.click(ProjectTeamPage.AddTeamButton);
		String message = WebInteract.AlertGetText();
		System.out.println(message);
		Asserts.assertEqual(message, "Are you sure you wish to add project team member?", "Correct Alert Message Is Displayed for Add Project team");
		WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(ProjectTeamPage.ProjectTeamSuccessMsg);
		//String SuccessMessage =Selenium.getText(ProjectTeamPage.ProjectTeamSuccessMsg);
		Asserts.assertEqual(SuccessMessage, "User added successfully", "Success Message Displayed for Project team Addition");	
		Selenium.click(ProjectTeamPage.CloseBtn);
			}
	 


	@Step("navigate to Edit Project team")
	public void navigateToEditProjectTeam() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.click(ProjectTeamPage.UpdateButton);
	}
	

	@Step("Entries for Edit Project team")
	public void EditProjectTeam(String MemberName, String EmailID, String MobileNo) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		searchfuncforValidData(MemberName);
		WebInteract.waitForVisibility(ProjectTeamPage.Editbtn);
		Selenium.click(ProjectTeamPage.Editbtn);
		WebInteract.waitForVisibility(ProjectTeamPage.EditMemberName);
		Selenium.clear(ProjectTeamPage.EditEmailID);
		Selenium.sendKeys(ProjectTeamPage.EditEmailID, EmailID);
		Selenium.clear(ProjectTeamPage.EditMobileNo);
		Selenium.sendKeys(ProjectTeamPage.EditMobileNo, MobileNo);
		Selenium.click(ProjectTeamPage.UpdateButton);
		WebInteract.WaitForAlert();
		String AlertText = WebInteract.AlertGetText();
		Asserts.assertContains(AlertText, "Are you sure you wish to update this project team member?", "Correct Alert Message Is Displayed for Add Project team");
		WebInteract.AcceptAlert();
		String SuccessMessage = WebInteract.getNonstaleElementGetText(ProjectTeamPage.UpdateProjectTeamSuccessMsg);
		//String SuccessMessage =Selenium.getText(ProjectTeamPage.UpdateProjectTeamSuccessMsg);
		Asserts.assertEqual(SuccessMessage, "Record Updated Successfully", "Success Message Displayed for Project team Addition");	
		Selenium.click(ProjectTeamPage.CloseBtn);
			}
	
	@Step("navigate to Search Project team")
	public void navigateToSearchDealer(String SearchProjectTeam) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		Selenium.sendKeys(ProjectTeamPage.SearchProjectTeamPage, SearchProjectTeam );
		Selenium.click(ProjectTeamPage.GoButton);
		}
	
	@Step("navigate to Delete Project team")
	public void DeleteProjectTeam(String SearchProjectTeam) throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		navigateToSearchDealer(SearchProjectTeam);
		WebInteract.waitForVisibility(ProjectTeamPage.DeleteButton);
		Selenium.click(ProjectTeamPage.DeleteButton);
		WebInteract.WaitForAlert();
		String DeleteValidationMessage = WebInteract.AlertGetText();
		Asserts.assertEqual(DeleteValidationMessage, "Are you sure you wish to delete this member?", "Correct alert message is displayed on deletion");
		//Asserts.assertContains(DeleteValidationMessage, "Deleted Successfully", "Correct deletion message is displayed");
		WebInteract.AcceptAlert();
		//WebInteract.WaitForAlert();
		//String message = WebInteract.AlertGetText();
		//Asserts.assertContains(message, "Deleted Successfully", "Correct deletion message is displayed");
		//WebInteract.AcceptAlert();
		//String Deletemessage = WebInteract.AlertGetText();
		//Assert.assertEquals(Deletemessage, "Project Team deleted successfully");
		//WebInteract.AcceptAlert();
		//WebInteract.waitForVisibility(ProjectTeamPage.AddButton);
		//searchfuncforInValidData(SearchProjectTeam);
		WebInteract.waitForVisibility(ProjectTeamPage.SearchProjectTeamPage);
		Selenium.sendKeys(ProjectTeamPage.SearchProjectTeamPage, SearchProjectTeam);
		Selenium.click(ProjectTeamPage.GoButton);
		String Alertmessage = WebInteract.AlertGetText();
		Assert.assertEquals(Alertmessage, "There are no such records available.");
		WebInteract.AcceptAlert();
	}
	
	@Step("To search the entry on page with invalid data")
	public void searchfuncforInValidData(String SearchProjectTeam) throws Throwable {
		Selenium.sendKeys(ProjectTeamPage.SearchProjectTeamPage, SearchProjectTeam);
		Selenium.click(ProjectTeamPage.GoButton);
		String Alertmessage = WebInteract.AlertGetText();
		Assert.assertEquals(Alertmessage, "There are no such records available.");
		WebInteract.AcceptAlert();
	}
	
	@Step("To search the entry on page with invalid data")
	public void searchfuncforValidData(String SearchProjectTeam) throws Throwable {
		Selenium.sendKeys(ProjectTeamPage.SearchProjectTeamPage, SearchProjectTeam);
		Selenium.click(ProjectTeamPage.GoButton);
	}
	
}











