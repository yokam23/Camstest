package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class SurveillanceIndicatorPage {
	//Surveillance Indicator page....
	
		@Name(Description="WebElement to indicate to Surveillance Indicator Page")
		@FindBy(xpath="//h2[contains(text(),'Surveillance indicator')]")
		public WebElement LaunchSurveillanceIndicatorPage;

		@Name(Description="Search Surveillance Indicator textbox")
		@FindBy(xpath="//body/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
		public WebElement SearchSurveillanceIndicator;

		@Name(Description="Search Surveillance Indicator Go Button")
		@FindBy(xpath="//button[contains(text(),'Go')]")
		public WebElement GoButton;

		//Add Surveillance Indicator page....
		
		@Name(Description="Surveillance Indicator Add Button")
		@FindBy(xpath="//a[@id='btnCreate']")
		public WebElement ADDButton;

		@Name(Description="WebElement to indicate to Add Surveillance Indicator Page")
		@FindBy(xpath="//div[@class='modal-header']//h3[contains(text(),'Add surveillance indicator')]")
		public WebElement ADDSurveillanceIndicatorPage;

		@Name(Description="Add Camera location DropDown")
		@FindBy(xpath="//div[@class='modal-body']//select[@id='CameraLoc']")
		public WebElement AddCameralocationDropDown;

		@Name(Description="Add category DropDown")
		@FindBy(xpath="//div[@class='modal-body']//select[@id='category']")
		public WebElement AddcategoryDropDown;

		@Name(Description="Add Indicator Textbox")
		@FindBy(xpath="//div[@class='modal-body']//input[@id='CheckListItem']")
		public WebElement AddIndicatorText;	
		
		@Name(Description="Add Priority DropDown")
		@FindBy(xpath="//div[@class='modal-body']//select[@id='priority']")
		public WebElement AddPriorityDropdown;	

		@Name(Description="Add Surveillance Indicator Button")
		@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnaddchecklist']")
		public WebElement AddSurveillanceIndicatorButton;
		
		@Name(Description="Cancel Surveillance Indicator Button")
		@FindBy(xpath="//div[@class='modal-footer']//a[contains(text(),'Cancel')]")
		public WebElement CancelSurveillanceIndicatorButton;	
		
		@Name(Description="Display Camera Location Success message")
		@FindBy(xpath="//strong[contains(text(),'Indicator added successfully')]")
		public WebElement AddSurveIndicatorSuccessMsg;
		
		//Edit Surveillance Indicator Page.....
		
		@Name(Description="Display surveillance Location Success message")
		@FindBy(xpath="//strong[contains(text(),'Indicator updated successfully')]")
		public WebElement UpdateSurveIndicatorSuccessMsg;
	
		@Name(Description="Display surveillance Location delete message")
		@FindBy(xpath="//strong[contains(text(),'Indicator deleted successfully')]")
		public WebElement DeleteSurveIndicatorSuccessMsg;

		@Name(Description="Edit Surveillance Indicator Button")
		@FindBy(xpath="(//a[@name='Edit'])[1]")
		public WebElement EditSurveillanceIndicatorButton;
		
		@Name(Description="WebElement to indicate to Edit Surveillance Indicator Page")
		@FindBy(xpath="//div[@class='modal-header']//h3[contains(text(),'Edit surveillance indicator')]")
		public WebElement EditSurveillanceIndicatorPage;
		
		@Name(Description="Edit Camera location DropDown")
		@FindBy(xpath="//div[@class='modal-body']//select[@id='CameraLoc']")
		public WebElement EditCameralocationDropDown;
		
		@Name(Description="Edit category DropDown")
		@FindBy(xpath="//div[@class='modal-body']//select[@id='category']")
		public WebElement EditcategoryDropDown;

		@Name(Description="Edit Indicator Textbox")
		@FindBy(xpath="//input[@id='CheckListItem']")
		public WebElement EditIndicatorText;	

		@Name(Description="Edit Priority DropDown")
		@FindBy(xpath="//div[@class='modal-body']//select[@id='priority']")
		public WebElement EditPriorityDropdown;	

		@Name(Description="Update Surveillance Indicator Button")
		@FindBy(xpath="//div[@class='modal-footer']//input[@value='Update']")
		public WebElement UpdateSurveillanceIndicatorButton;
		
		@Name(Description="Cancel Surveillance Indicator Button in update")
		@FindBy(xpath="//div[@class='modal-footer']//input[@value='Cancel']")
		public WebElement CancelButton;	
		
		//Delete Camera Location Page.....

			@Name(Description="Delete Surveillance Indicator button")
			@FindBy(xpath="(//a[@name='Delete'])[1]")
			public WebElement DeleteSurveillanceIndicatorButton;
			
			// Camera Location Bulk Upload Page.....
			@Name(Description="Surveillance Indicator Upload Button")
			@FindBy(xpath="//a[@id='btnBulkUpload']")
			public WebElement SurveillanceIndicatorBulkUploadButton;
			
			@Name(Description="WebElement to indicate to Surveillance Indicator Upload Page")
			@FindBy(xpath="//h2[contains(text(),'Indicators Bulk Upload')]")
			public WebElement SurveillanceIndicatorBulkUploadPage;
			
			@Name(Description="Back To Surveillance Indicator Bulk Upload Button")
			@FindBy(xpath="//a[@id='btnlistui']")
			public WebElement BackToSurveillanceIndicatorBulkUploadButton;

			@Name(Description=" Surveillance Indicator Bulk Upload Choose File Button")
			@FindBy(xpath="//input[@id='FileUpload1']")
			public WebElement SurveillanceIndicatorChooseFileBulkUploadButton;

			@Name(Description=" Surveillance Indicator Bulk Upload 'Upload' Button")
			@FindBy(xpath="//input[@id='btnupload']")
			public WebElement SurveillanceIndicatorUploadButton;

			@Name(Description=" Surveillance Indicator Bulk Upload Download Sample Button")
			@FindBy(xpath="//input[@id='btnDlFile']")
			public WebElement SurveillanceIndicatorDownloadSampleButton;
			
			public SurveillanceIndicatorPage()  {		
				PageFactory.initElements(DriverManager.getWebDriver(), this);
			}

}
