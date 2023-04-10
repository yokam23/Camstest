package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class InstallationToolPage {
	
	@Name(Description = "ClientName")
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlClientID']")
	public WebElement Clientname;
	
	@Name(Description = "PanelID")
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlTmpPanelID']")
	public WebElement Panelid;
	
	@Name(Description = "Start Tracking")
	@FindBy(id="btnsubmitchange")
	public WebElement StartTrack;
	
	@Name(Description = "Stop Tracking")
	@FindBy(id="btnStop")
	public WebElement StopTrack;
	
	@Name(Description = "Edit btn")
	@FindBy(id="btnEditMfgID")
	public WebElement Editbtn;
	
	@Name(Description="Panelid_Txt")
	@FindBy(id="ContentPlaceHolder1_lblpanelid")
	public WebElement panelidtxt;
	
	@Name(Description="MFGID field")
	@FindBy(id="ContentPlaceHolder1_txtMfgID")
	public WebElement MFGID;
	
	@Name(Description = "Reset btn")
	@FindBy(id="btnReset")
	public WebElement Resetbtn;
	
	@Name(Description = "Silence btn")
	@FindBy(id="btnSilence")
	public WebElement Silencebtn;
	
	@Name(Description = "StartSiren btn")
	@FindBy(id="btnStartSiren")
	public WebElement StartSirenbtn;
	
	@Name(Description="Remarks")
	@FindBy(id="txtRemark")
	public WebElement Remarks;
	
	@Name(Description = "Moveqcbtn")
	@FindBy(xpath="//input[@id='btnMoveToQC']")
	public WebElement MoveQCbtn;
	
	@Name(Description="Savebtn")
	@FindBy(id="btnsave")
	public WebElement Savebtn;
	
	@Name(Description="Update MFGID btn")
	@FindBy(id="btnUpdateMfgID")
	public WebElement UpdateMFGID;
	
	@Name(Description="Reset btn error msg")
	@FindBy(id="lblPControlErrorPanelReset")
	public WebElement Resetbtnerror;
	
	@Name(Description="Silence btn error msg")
	@FindBy(id="lblPControlErrorSilence")
	public WebElement Silencebtnerror;
	
	@Name(Description="Start siren btn error msg")
	@FindBy(id="lblPControlErrorSiren")
	public WebElement StartSirenbtnerror;
	
	@Name(Description = "Installation tool page header")
	@FindBy(id="ContentPlaceHolder1_lblbreadcrumb")
	public WebElement INSPageHeader;
	
	@Name(Description="cancel btn")
	@FindBy(id="btnCancelUpdate")
	public WebElement Cancelbtn;
	
	public InstallationToolPage() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
	
	


}
