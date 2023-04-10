package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class CameraLocationPage {
	//Alert Panel page....
	
		@Name(Description="WebElement to indicate to Alert Panel Page")
		@FindBy(xpath="//h2[contains(text(),'AlertPanel')]")
		public WebElement LaunchAlertPanelPage;

		@Name(Description="Search Alert Panel OK Button")
		@FindBy(xpath="//a[contains(text(),'Ok')]")
		public WebElement AlertPanelOKButton;

		@Name(Description="Search Alert Panel Ignore Button")
		@FindBy(xpath="//a[contains(text(),'Ignore')]")
		public WebElement AlertPanelIgnoreButton;

		//Add Camera Location Page.....
		
		@Name(Description="WebElement to indicate to Camera Location Page")
		@FindBy(xpath="//h2[contains(text(),'Camera Location')]")
		public WebElement LaunchCameraLocationPage;

		@Name(Description="Search Camera Location textbox")
		@FindBy(xpath="//body/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
		public WebElement SearchCameraLocation;
		
		@Name(Description="Search Camera Location Go Button")
		@FindBy(xpath="//button[contains(text(),'Go')]")
		public WebElement GoButton;
		
		@Name(Description="Camera Location Add Button")
		@FindBy(xpath="//a[@id='btnaddui']")
		public WebElement ADDButton;

		@Name(Description="WebElement to indicate to Add Camera Location Page")
		@FindBy(xpath="//div[@class='modal-header']//h3[contains(text(),'Add Camera Location')]")
		public WebElement ADDCameraLocationPage;

		@Name(Description="Add Camera Location textbox")
		@FindBy(xpath="//div[@class='modal-body']//input[@id='Location']")
		public WebElement AddCameraLocationText;
		
		@Name(Description="Add Camera Location Add Button")
		@FindBy(xpath="//div[@class='modal-footer']//input[@value='Add']")
		public WebElement ADDCameraLocationButton;

		@Name(Description="Add Camera Location Cancel Button")
		@FindBy(xpath="//div[@class='modal-footer']//input[@value='Cancel']")
		public WebElement CancelCameraLocationButton;

		@Name(Description="Display Camera Location Success message")
		@FindBy(xpath="//strong[contains(text(),'Camera Location added successfully')]")
		public WebElement CAMLOCSuccessMsg;

		
		@Name(Description="Display Camera Location Delete message")
		@FindBy(xpath="//strong[contains(text(),'Camera Location deleted successfully')]")
		public WebElement CAMLOCDeleteMsg;

		//Edit Camera Location Page.....
		
		@Name(Description="Edit Camera Location Button")
		@FindBy(xpath="(//a[@data-original-title='Edit'])[1]")
		public WebElement EditCameraLocationButton;
		
		@Name(Description="WebElement to indicate to Edit Camera Location Page")
		@FindBy(xpath="//div[@class='modal-header']//h3[contains(text(),'Edit Camera Location')]")
		public WebElement EditCameraLocationPage;
		
		@Name(Description="Edit Camera Location textbox")
		@FindBy(xpath="//div[@class='modal-body']//input[@id='txtCameraLocation']")
		public WebElement EditCameraLocationText;
		
		@Name(Description="Add Camera Location Update Button")
		@FindBy(xpath="//div[@class='modal-footer']//input[@value='Update']")
		public WebElement UpdateCameraLocationButton;

		@Name(Description="Update Camera Location Cancel Button")
		@FindBy(xpath="//div[@class='modal-footer']//input[@value='Cancel']")
		public WebElement UpdateCancelCameraLocationButton;
		
		@Name(Description="Display Camera Location Success message")
		@FindBy(xpath="//strong[contains(text(),'Camera Location updated successfully')]")
		public WebElement UpdateCAMLOCSuccessMsg;
		
		//Delete Camera Location Page.....

		@Name(Description="Delete  Camera Location button")
		@FindBy(xpath="(//a[@name='Delete'])[1]")
		public WebElement DeleteCameraLocation;
		

		@Name(Description="Display Camera Location Success message")
		@FindBy(xpath="//body/div[1]/div[1]/div[1]")
		public WebElement DeleteCAMLOCSuccessMsg;
		
		// Camera Location Bulk Upload Page.....
		
		@Name(Description="Camera Location Bulk Upload Button")
		@FindBy(xpath="//a[@id='btnBulkUpload']")
		public WebElement CameraLocationBulkUploadButton;
		
		@Name(Description="WebElement to indicate to Camera Location Bulk Upload Page")
		@FindBy(xpath="//h2[contains(text(),'Location Bulk Upload')]")
		public WebElement CameraLocationBulkUploadPage;
		
		@Name(Description="Back To Camera Location Bulk Upload Button")
		@FindBy(xpath="//a[@id='btnlistui']")
		public WebElement BackToCameraLocationBulkUploadButton;

		@Name(Description="Camera Location Bulk Upload Choose File Button")
		@FindBy(xpath="//input[@id='FileUpload1']")
		public WebElement CamLocChooseFileBulkUploadButton;

		@Name(Description="Camera Location Bulk Upload 'Upload' Button")
		@FindBy(xpath="//input[@id='btnupload']")
		public WebElement UploadButton;

		@Name(Description="Camera Location Bulk Upload Download Sample Button")
		@FindBy(xpath="//input[@id='btnDlFile']")
		public WebElement DownloadSampleButton;
		
		@Name(Description="Search filter")
		@FindBy(xpath="//input[@placeholder='Search by location']")
		public WebElement Searchbox;
		
		@Name(Description="Gobutton")
		@FindBy(xpath="//button[text()='Go']")
		public WebElement Gobutton;
		
		public CameraLocationPage() {
			PageFactory.initElements(DriverManager.getWebDriver(), this);
		}

}
