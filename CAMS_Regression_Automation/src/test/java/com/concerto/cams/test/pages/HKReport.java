package com.concerto.cams.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class HKReport {
	
	@Name(Description="Report Date")
	@FindBy(xpath="//input[@id='HKDate']")
	public WebElement HKDate;
	
	@Name(Description="No Report data")
	@FindBy(xpath="//td[text()='No records found.']")
	public WebElement Reportmsg;
	
	@Name(Description="Report Header")
	@FindBy(xpath="//div[@class='col-md-6']//h2")
	public WebElement ReportHeader;
	
	@Name(Description="Record Count")
	@FindBy(xpath="//div[@class='pull-right']")
	public WebElement RecordCount;
	
	@Name(Description="ClientName")
	@FindBy(xpath="//select[@id='ddlClientID']")
	public WebElement HKClient;
	
	@Name(Description="PoolName")
	@FindBy(xpath="//select[@id='ddlPoolID']")
	public WebElement HKPool;
	
	@Name(Description="HKScheduler")
	@FindBy(xpath="//select[@id='ddlSchedule']")
	public WebElement HKScheduler;
	
	@Name(Description="HKSearchOption")
	@FindBy(xpath="//a[@id='btnView']")
	public WebElement HKSearchOption;
	
	@Name(Description="ResetBtn")
	@FindBy(xpath="//input[@value='Reset']")
	public WebElement Resetbtn;
	
	@Name(Description="ExportData")
	@FindBy(xpath="//a[@href='ExportExcelSave']")
	public WebElement ExportData;
	
	@Name(Description="List of panels")
	@FindBy(xpath="//table[@id='grid']//tbody//tr//td[4]")
	public List<WebElement> PanelList;
	
	@Name(Description="Date field validation")
	@FindBy(xpath="//span[@id='RequiredDateID']")
	public WebElement DateField;
	
	@Name(Description="Client field validation")
	@FindBy(xpath="//span[@id='RequiredClientID']")
	public WebElement ClientField;
	
	
	public HKReport() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
