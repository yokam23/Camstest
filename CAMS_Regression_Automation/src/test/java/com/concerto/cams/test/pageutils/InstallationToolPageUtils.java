package com.concerto.cams.test.pageutils;



import com.concerto.cams.test.pages.InstallationToolPage;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Selenium;
import com.concerto.common.utilities.WebInteract;
import com.concerto.db.methods.InstallationToolDBdetails;

import io.qameta.allure.Step;

public class InstallationToolPageUtils {
	
	protected InstallationToolPage instool;
	
	public InstallationToolPageUtils() {
		instool = new InstallationToolPage();
	}
	
	@Step("To get the page title of installation tool")
	public void GetPageHeader() throws Throwable {
		WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		WebInteract.validatePageTitle("CAMS Installation & Service");
		String pageheader = Selenium.getText(instool.INSPageHeader);
		Asserts.assertEqual(pageheader, "Panel Service Tool","Correct page header is displayed in installation tool");
	}
	
	@Step("To Start and stop panel tracking")
	public void StartTracking() throws Throwable {
		GetPageHeader();
		String Client = GetClientName(0);
		String Panelid = GetPanelid(0);
		WebInteract.selectByTextFomDropdownfromStale(instool.Clientname, Client);
		WebInteract.selectByTextFomDropdownfromStale(instool.Panelid, Panelid);
		Asserts.assertTrue(!(instool.StopTrack.isEnabled()), "Stop tracking button in disable");
		Selenium.click(instool.StartTrack);
		WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Panel mode have been changed to Service successfully.Panel Tracking Started.", "Correct alert message is displayed for live mode panels");
	    WebInteract.AcceptAlert();
	    Asserts.assertEqual(Selenium.getText(instool.panelidtxt), Panelid, "Correct Panelid is displayed");
	    Asserts.assertTrue(!(instool.Editbtn.isEnabled()), "Edit button is disable before start tracking");
	    Selenium.click(instool.StopTrack);
	    WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Panel tracking stopped.", "Correct stop tracking message is displayed");
		WebInteract.AcceptAlert();
	}
	
	@Step("To update Manufacture id of panel")
	public void UpdateMFGID(String MFGID) throws Throwable {
		String Client = GetClientName(0);
		String Panelid = GetPanelid(0);
		WebInteract.selectByTextFomDropdownfromStale(instool.Clientname, Client);
		WebInteract.selectByTextFomDropdownfromStale(instool.Panelid, Panelid);
		WebInteract.waitForVisibility(instool.Editbtn);
		Selenium.click(instool.Editbtn);
		WebInteract.waitForVisibility(instool.UpdateMFGID);
		Selenium.clear(instool.MFGID);
		Selenium.sendKeys(instool.MFGID, MFGID);
	    Selenium.click(instool.UpdateMFGID);
	    WebInteract.WaitForAlert();
	    Asserts.assertEqual(WebInteract.AlertGetText(), "Manufacturing ID  updated successfully. ", "Correct mfg id update message is displayed");
	    WebInteract.AcceptAlert();
	    String a = Panelid.replaceFirst("A", "1");
	    Asserts.assertEqual(InstallationToolDBdetails.GetPanelDetails(Client, a).get(0).get("MfgID"),MFGID, "Updated MFGID is displayed in database");
	   // Asserts.assertEqual(Selenium.getText(instool.MFGID), MFGID, "mfg ID updated successfully");
	}
	
	@Step("To send Outgoing command to panel")
	public void ErrorMsgOutgoingCommands() throws Throwable {
		String Client = GetClientName(0);
		String Panelid = GetPanelid(0);
		WebInteract.selectByTextFomDropdownfromStale(instool.Clientname, Client);
		WebInteract.selectByTextFomDropdownfromStale(instool.Panelid, Panelid);
        Selenium.click(instool.Resetbtn);
        WebInteract.waitForVisibility(instool.Resetbtnerror);
        Thread.sleep(15000);
        Asserts.assertEqual(Selenium.getText(instool.Resetbtnerror), "Failed", "Correct error message displayed for reset button");
        Selenium.click(instool.StartSirenbtn);
        Thread.sleep(15000);
        Asserts.assertEqual(Selenium.getText(instool.StartSirenbtnerror), "Failed", "Correct error message displayed for start siren button");
        Selenium.click(instool.Silencebtn);
        Thread.sleep(15000);
        Asserts.assertEqual(Selenium.getText(instool.Silencebtnerror), "Failed", "Correct error message displayed for silence button");
	}
	
	@Step("To move panel from test to quality mode")
    public void MoveToQCPanel() throws Throwable {
		String Client = GetClientName(1);
		String Panelid = GetPanelid(1);
		System.out.println(Panelid);
		WebInteract.selectByTextFomDropdownfromStale(instool.Clientname, Client);
		WebInteract.selectByTextFomDropdownfromStale(instool.Panelid, Panelid);
        WebInteract.waitForVisibility(instool.panelidtxt);
        Selenium.click(instool.StartTrack);
        WebInteract.WaitForAlert();
        WebInteract.AcceptAlert();
        WebInteract.moveToElement(instool.MoveQCbtn);
        Selenium.sendKeys(instool.Remarks, "Test");
        Selenium.click(instool.MoveQCbtn);
        String a = Panelid.replaceFirst("A", "1");
        int testmode = Integer.parseInt(InstallationToolDBdetails.GetPanelDetails(Client, a).get(0).get("TestMode"));
        Asserts.assertEqual(testmode,4, "Panel move to Quality mode successfully");
	}
	
	public String GetClientName(int Testmode) throws InstantiationException, IllegalAccessException {
		String ClientName = InstallationToolDBdetails.GetPanelDetails(Testmode).get(0).get("Client_Name");
		return ClientName;
	}
	
	public String GetPanelid(int Testmode) throws InstantiationException, IllegalAccessException {
        String PanelId = InstallationToolDBdetails.GetPanelDetails(Testmode).get(0).get("PanelID");
        return PanelId.replaceFirst("1", "A");
	}
	
	@Step("To save the remark of panel")
	public void SaveRemark() throws Throwable {
		String Client = GetClientName(0);
		String Panelid = GetPanelid(0);
		WebInteract.selectByTextFomDropdownfromStale(instool.Clientname, Client);
		WebInteract.selectByTextFomDropdownfromStale(instool.Panelid, Panelid);
		WebInteract.waitForVisibility(instool.panelidtxt);
        Selenium.click(instool.StartTrack);
        WebInteract.WaitForAlert();
		Asserts.assertEqual(WebInteract.AlertGetText(), "Panel mode have been changed to Service successfully.Panel Tracking Started.", "Correct alert message is displayed for live mode panels");
        WebInteract.AcceptAlert();
        WebInteract.moveToElement(instool.Savebtn);
        Selenium.sendKeys(instool.Remarks, "Test");
        Selenium.click(instool.Savebtn);
        String a = Panelid.replaceFirst("A", "1");
        int testmode = Integer.parseInt(InstallationToolDBdetails.GetPanelDetails(Client, a).get(0).get("TestMode"));
        Asserts.assertEqual(testmode,3, "Panel move to service mode successfully");
	}
	
	@Step("To validate duplicate mfg id of panels")
	public void ValidateDuplicateMFGID(String MFGID) throws Throwable {
		String Client = GetClientName(3);
		String Panelid = GetPanelid(3);
		WebInteract.selectByTextFomDropdownfromStale(instool.Clientname, Client);
		WebInteract.selectByTextFomDropdownfromStale(instool.Panelid, Panelid);
		WebInteract.waitForVisibility(instool.Editbtn);
		Selenium.click(instool.Editbtn);
		WebInteract.waitForVisibility(instool.UpdateMFGID);
		Selenium.clear(instool.MFGID);
		Selenium.sendKeys(instool.MFGID, MFGID);
	    Selenium.click(instool.UpdateMFGID);
	    WebInteract.WaitForAlert();
	    Asserts.assertEqual(WebInteract.AlertGetText(), "Duplicate Manufacturing ID ", "Correct validation message is displayed for duplicate mfg id");
	    WebInteract.AcceptAlert();
	}
}
