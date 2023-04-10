package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class OfficeMonitoringReportPage{
	
	@Name(Description="WebElement to indicate to  Office Monitoring Report Page")
	@FindBy(xpath="//div[@class='widget-title']//h2[contains(text(),'Office monitoring report')]")
	public WebElement LaunchOfficeMonitoringReportPage;

	@Name(Description="Select Office Monitoring Report Site Dropdown")
	@FindBy(xpath="//div[@class='widget-body']//select[@id='ddlSiteID']")
	public WebElement SelectOMRSiteDropDown;
	

	@Name(Description="Select Office Monitoring Report Camera Location Dropdown")
	@FindBy(xpath="//div[@class='widget-body']//select[@id='ddlCameraLocation']")
	public WebElement SelectOMRCAMLocDropDown;

	@Name(Description="Select Office Monitoring Report Date Dropdown")
	@FindBy(xpath="//div[@class='widget-body']//input[@id='txtDate']")
	public WebElement SelectOMRDateDropDown;

	@Name(Description="Select Office Monitoring Report Time Slot Dropdown")
	@FindBy(xpath="//div[@class='widget-body']//select[@id='ddlTimeInterval']")
	public WebElement SelectOMRTimeSlotDropDown;

	@Name(Description="Select Office Monitoring Report Generate Button")
	@FindBy(xpath="//div[@class='widget-footer']//input[@id='ContentPlaceHolder1_btnGenerate']")
	public WebElement OMRGenerateButton;
	
	@Name(Description="RecordCount")
	@FindBy(xpath="//span[@id='ContentPlaceHolder1_lblMsg']")
	public WebElement RecordCount;
	
	@Name(Description="ExportExcel")
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_exportControl1_imgbtnExportExcel']")
	public WebElement ExportExcel;
	
	@Name(Description="ExportPDF")
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_exportControl1_imgbtnExportPDF']")
	public WebElement Exportpdf;
	
	
	public OfficeMonitoringReportPage() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
	
}
