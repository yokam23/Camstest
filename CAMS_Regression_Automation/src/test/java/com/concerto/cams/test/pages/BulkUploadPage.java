package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class BulkUploadPage {
	
	@Name(Description="WebElement to indicate to Bulk Upload Page")
	@FindBy(xpath="//h2[contains(text(),'Bulk Upload')]")
	public WebElement LaunchBulkUploadPage;
	
	@Name(Description="Select Upload radio button")
	@FindBy(id="upload")
	public WebElement UploadRadioButton;

	@Name(Description="Select update radio button")
	@FindBy(id="update")
	public WebElement UpdateRadioButton;

	@Name(Description="Choose Button for Upload file")
	@FindBy(id="FileUpload1")
	public WebElement ChoosetoUpload;
	
	@Name(Description="Choose Button for Update file")
	@FindBy(id="FileUpload1")
	public WebElement ChoosetoUpdate;
	
	@Name(Description="Select Sheet Dropdown")
	@FindBy(id="SheetType")
	public WebElement SelectSheetDD;
	
	@Name(Description="Download Sample Button")
	@FindBy(id="btnDlFile")
	public WebElement DownloadSample;
	
	

	
	
	
	
	
	
	
	
	
	
	public BulkUploadPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
