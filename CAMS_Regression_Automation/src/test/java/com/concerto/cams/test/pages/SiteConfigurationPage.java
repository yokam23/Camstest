package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class SiteConfigurationPage {
	// Site Configuration Page
	
		@Name(Description="WebElement to indicate to Site Configuration Page")
		@FindBy(xpath="//h2[contains(text(),'Brand Hygiene Site Details')]")
		public WebElement LaunchSiteConfigurationPage;

		@Name(Description="Search Site Configuration textbox")
		@FindBy(xpath="//body/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
		public WebElement SearchSiteDetails;
		
		@Name(Description="Search Site Configuration Go Button")
		@FindBy(xpath="//button[contains(text(),'Go')]")
		public WebElement GoButton;
		
		
		//Add Brand Hygiene Site Details page....
		
			@Name(Description="Brand Hygiene Site Details Add Button")
			@FindBy(xpath="//a[@id='btnaddui']")
			public WebElement ADDButton;
			
			@Name(Description="WebElement to indicate to Add Site Details Page")
			@FindBy(xpath="//h2[contains(text(),'Add Site Details')]")
			public WebElement ADDSiteDetailsPage;
			
			@Name(Description="Brand Hygiene Site Details Back to List Button")
			@FindBy(xpath="//a[@id='btnlistui']")
			public WebElement BackToListButton;
		
			@Name(Description="Brand Hygiene Site Details Client Name DropDown")
			@FindBy(xpath="//select[@id='ddlClientID']")
			public WebElement AddSiteDetailsClientNameDD;

			@Name(Description="Brand Hygiene Site Details Site ID Texbox")
			@FindBy(xpath="//input[@id='txtSiteID']")
			public WebElement AddSiteIDTextBox;
			//input[@id='txtSiteID']
			@Name(Description="Brand Hygiene Site Details State Name DropDown")
			@FindBy(xpath="//select[@id='ddlstate']")
			public WebElement AddSiteDetailsStateNameDD;
		
			@Name(Description="Brand Hygiene Site Details City Name DropDown")
			@FindBy(xpath="//select[@id='ddlcity']")
			public WebElement AddSiteDetailsCityNameDD;
		
			@Name(Description="Brand Hygiene Site Details Pincode Texbox")
			@FindBy(xpath="//input[@id='txtPinCode']")
			public WebElement AddPincodeTextBox;

			@Name(Description="Brand Hygiene Site Details Address Texbox")
			@FindBy(xpath="//textarea[@id='txtSiteAdd']")
			public WebElement AddSiteAddressTextBox;

			@Name(Description="Brand Hygiene Site Details Site Location Texbox")
			@FindBy(xpath="//textarea[@id='txtSiteLoc']")
			public WebElement AddSiteLocationTextBox;

			@Name(Description="Brand Hygiene Site Details Site Name Texbox")
			@FindBy(xpath="//textarea[@id='txtSiteName']")
			public WebElement AddSiteNameTextBox;

			@Name(Description="Brand Hygiene Site Details HK Agency DropDown")
			@FindBy(xpath="//select[@id='ddlHKAgencyID']")
			public WebElement AddHKAgencyDD;

			@Name(Description="Brand Hygiene Site Details MDN NO TextBox")
			@FindBy(xpath="//input[@id='txtMDNNo']")
			public WebElement AddMDNNOTextBox;

			@Name(Description="Brand Hygiene Site Details Antenna Dropdown")
			@FindBy(xpath="//select[@id='ddlAntenna']")
			public WebElement AddAntennaDD;

			@Name(Description="Brand Hygiene Site Details DVR Type Dropdown")
			@FindBy(xpath="//select[@id='ddlDVRType']")
			public WebElement AddDVRTypeDD;

			@Name(Description="Brand Hygiene Site Details DVR IP textbox")
			@FindBy(xpath="//input[@id='txtDVRIP']")
			public WebElement AddDVRIPTextBox;

			@Name(Description="Brand Hygiene Site Details DVR User ID textbox")
			@FindBy(xpath="//input[@id='txtDVRUserID']")
			public WebElement AddDVRUserIDTextBox;

			@Name(Description="Brand Hygiene Site Details DVR Password textbox")
			@FindBy(xpath="//input[@id='txtDVRPassword']")
			public WebElement AddDVRPasswordTextBox;

			@Name(Description="Brand Hygiene Site Details DVR Port textbox")
			@FindBy(xpath="//input[@id='txtDVRport']")
			public WebElement AddDVRPortTextBox;

			@Name(Description="Brand Hygiene Site Details DVR Channels DropDown")
			@FindBy(xpath="//select[@id='ddldvrchannel']")
			public WebElement AddDVRChannelsDD;

			@Name(Description="Brand Hygiene Site Details HDD 1 Total Space(TB) TextBox")
			@FindBy(xpath="//input[@id='txtHDD1']")
			public WebElement AddHDDSpaceTextBox1;

			@Name(Description="Brand Hygiene Site Details HDD 2 Total Space(TB) TextBox")
			@FindBy(xpath="//input[@id='txtHDD2']")
			public WebElement AddHDDSpaceTextBox2;

			//Add Escalation Configuration.....
			
			@Name(Description="Brand Hygiene Site Details Email ID TextBox")
			@FindBy(xpath="//input[@id='txtEmail']")
			public WebElement AddESCEmailIDTextBox;

			@Name(Description="Brand Hygiene Site Details Contac Name TextBox")
			@FindBy(xpath="//input[@id='txtContactName']")
			public WebElement AddESCContactNameTextBox;

			@Name(Description="Brand Hygiene Site Details Mobile Number TextBox")
			@FindBy(xpath="//input[@id='txtPhone']")
			public WebElement AddMobileNOTextBox;
			
			@Name(Description="Brand Hygiene Site Details Save Button")
			@FindBy(xpath="//input[@id='AddSiteDetails']")
			public WebElement AddSiteDetailsSaveButton;

			@Name(Description="Brand Hygiene Site Details Reset Button")
			@FindBy(xpath="//a[@id='btnrefresh']")
			public WebElement AddSiteDetailsResetButton;
			
			@Name(Description="Display Site Details Success message")
			@FindBy(xpath="//strong[contains(text(),'Site added successfully')]")
			public WebElement AddSiteDetailsSuccessMsg;
			
			//Add Brand Hygiene Site Details page....
			
				@Name(Description="Brand Hygiene Site Details Edit Button")
				@FindBy(xpath="(//a[@name='Edit'])[1]")
				public WebElement EditButton;
				
				@Name(Description="WebElement to indicate to Edit Site Details Page")
				@FindBy(xpath="//h2[contains(text(),'Edit Site Details')]")
				public WebElement EditSiteDetailsPage;
				
				@Name(Description="Brand Hygiene Site Details Back to List Button")
				@FindBy(xpath="//a[@id='btnlistui']")
				public WebElement BackToListButtonEditPage;
			
				/*@Name(Description="Brand Hygiene Site Details  Client Name DropDown")
				@FindBy(xpath="//select[@id='ddlClientID']")
				public WebElement AddSiteDetailsClientNameDD;

				@Name(Description="Brand Hygiene Site Details Edit Site ID Texbox")
				@FindBy(xpath="//input[@id='txtSiteID']")
				public WebElement AddSiteIDTextBox;*/
			
				@Name(Description="Brand Hygiene Site Details Edit State Name DropDown")
				@FindBy(xpath="//select[@id='ddlstate']")
				public WebElement EditSiteDetailsStateNameDD;
			
				@Name(Description="Brand Hygiene Site Details Edit City Name DropDown")
				@FindBy(xpath="//select[@id='ddlcity']")
				public WebElement EditSiteDetailsCityNameDD;
			
				@Name(Description="Brand Hygiene Site Details Edit Pincode Texbox")
				@FindBy(xpath="//input[@id='Pincode']")
				public WebElement EditPincodeTextBox;

				@Name(Description="Brand Hygiene Site Details Edit Address Texbox")
				@FindBy(xpath="//textarea[@id='SiteAddress']")
				public WebElement EditSiteAddressTextBox;

				@Name(Description="Brand Hygiene Site Details Edit Site Location Texbox")
				@FindBy(xpath="//textarea[@id='SiteLandmark']")
				public WebElement EditSiteLocationTextBox;

				@Name(Description="Brand Hygiene Site Details Edit Site Name Texbox")
				@FindBy(xpath="//textarea[@id='SiteName']")
				public WebElement EditSiteNameTextBox;

				@Name(Description="Brand Hygiene Site Details Edit HK Agency DropDown")
				@FindBy(xpath="//select[@id='ddlHKAgencyID']")
				public WebElement EditHKAgencyDD;

				@Name(Description="Brand Hygiene Site Details Edit MDN NO TextBox")
				@FindBy(xpath="//input[@id='MDNNo']")
				public WebElement EditMDNNOTextBox;

				@Name(Description="Brand Hygiene Site Details Edit Antenna Dropdown")
				@FindBy(xpath="//select[@id='Antenna']")
				public WebElement EditAntennaDD;

				@Name(Description="Brand Hygiene Site Details Edit DVR Type Dropdown")
				@FindBy(xpath="//select[@id='DVRType']")
				public WebElement EditDVRTypeDD;

				@Name(Description="Brand Hygiene Site Details Edit DVR IP textbox")
				@FindBy(xpath="//input[@id='DVRIP']")
				public WebElement EditDVRIPTextBox;

				@Name(Description="Brand Hygiene Site Details Edit DVR User ID textbox")
				@FindBy(xpath="//input[@id='DVRUserID']")
				public WebElement EditDVRUserIDTextBox;

				@Name(Description="Brand Hygiene Site Details Edit DVR Password textbox")
				@FindBy(xpath="//input[@id='txtDVRPassword']")
				public WebElement EditDVRPasswordTextBox;

				@Name(Description="Brand Hygiene Site Details Edit DVR Port textbox")
				@FindBy(xpath="//input[@id='DVRPort']")
				public WebElement EditDVRPortTextBox;

				@Name(Description="Brand Hygiene Site Details Edit DVR Channels DropDown")
				@FindBy(xpath="//select[@id='ddldvrchannel']")
				public WebElement EditDVRChannelsDD;

				@Name(Description="Brand Hygiene Site Details Edit HDD 1 Total Space(TB) TextBox")
				@FindBy(xpath="//input[@id='HDD1']")
				public WebElement EditHDDSpaceTextBox1;

				@Name(Description="Brand Hygiene Site Details Edit HDD 2 Total Space(TB) TextBox")
				@FindBy(xpath="//input[@id='HDD2']")
				public WebElement EditHDDSpaceTextBox2;
				
				@Name(Description="Display Site Details Success message")
				@FindBy(xpath="//body/div[1]/div[1]/div[1]")
				public WebElement UpdateSiteDetailsSuccessMsg;
				
				@Name(Description="Display Site Details delete Button")
				@FindBy(xpath="//a[@id='btndelete']")
				public WebElement DeleteSiteDetailsSuccessMsg;
				
			
				//Edit Escalation Configuration.....
				
				@Name(Description="Brand Hygiene Site Details Edit Email ID TextBox")
				@FindBy(xpath="//input[@id='EmailID']")
				public WebElement EditESCEmailIDTextBox;

				@Name(Description="Brand Hygiene Site Details Edit Contact Name TextBox")
				@FindBy(xpath="//input[@id='ContactName']")
				public WebElement EditESCContactNameTextBox;

				@Name(Description="Brand Hygiene Site Details Edit Mobile Number TextBox")
				@FindBy(xpath="//input[@id='ContactPhoneNo']")
				public WebElement EditMobileNOTextBox;
				
				@Name(Description="Brand Hygiene Site Details Update Button")
				@FindBy(xpath="//input[@id='btnupdate']")
				public WebElement UpdateSiteDetailsButton;

				@Name(Description="Brand Hygiene Site Details Delete Button")
				@FindBy(xpath="//a[@id='btndelete']")
				public WebElement DeleteSiteDetailsButton;

				@Name(Description="Brand Hygiene Site Details Image Scheduler Button")
				@FindBy(xpath="//a[@id='btnImageScheduler']")
				public WebElement ImageSchedulerButton;
				
				@Name(Description="Scheduler page header")
				@FindBy(xpath="//strong[contains(text(),'Image scheduler')]")
				public WebElement schedulerPageHeader;
				
				@Name(Description = "Location drop down")
				@FindBy(xpath="//select[@id='ddlCameraLoc']")
				public WebElement LocationDropDown;
				
				@Name(Description="FromTime")
				@FindBy(xpath="//input[@id='txtTimeFrom']")
				public WebElement FromTime;
				
				@Name(Description="ToTime")
				@FindBy(xpath="//input[@id='txtTimeTo']")
				public WebElement ToTime;
				
				@Name(Description="ScheduleSuccessMsg")
				@FindBy(xpath="//strong[contains(text(),'Image schedule added successfully')]")
				public WebElement ScheduleSuccessMsg;
				
				@Name(Description="CameraSuccessMsg")
				@FindBy(xpath="//strong[contains(text(),'Camera configuration added successfully')]")
				public WebElement CameraSuccessMsg;
				
				@Name(Description="Siteupdatemsg")
				@FindBy(xpath="//strong[contains(text(),'Site Details updated successfully')]")
				public WebElement Siteupdatemsg;
				
				
				@Name(Description="Sitedeletemsg")
				@FindBy(xpath="//strong[contains(text(),'Site details deleted successfully')]")
				public WebElement Sitedeletemsg;

				@Name(Description="CameraConfiguration")
				@FindBy(xpath="//a[text()='Camera configuration']")
				public WebElement CameraConfiguration;

				@Name(Description="CameraConfigurationHeader")
				@FindBy(xpath="//h2[contains(text(),'Camera Configuration')]")
				public WebElement CameraConfigurationHeader;
				
				@Name(Description="CameraLocation")
				@FindBy(xpath="//select[@id='ddlCameraLocation']")
				public WebElement CameraLocation;
				
				@Name(Description ="SelectCamera")
				@FindBy(xpath="//label[@id='lblCameraNo+0']")
				public WebElement SelectCamera;
				
				@Name(Description="SelectAll")
				@FindBy(xpath="//label[@class='chkselect-all']")
				public WebElement CheckAll;
				
				@Name(Description="SaveCamera")
				@FindBy(xpath="//input[@id='btnAdd']")
				public WebElement SaveCamera;
				@Name(Description="Savebtn")
				@FindBy(xpath="//input[@id='btnUpdateImageScheduler']")
				public WebElement ScheduleSave;
				
				//Edit Image scheduler 
				
				@Name(Description="WebElement to indicate to Edit Image scheduler Page")
				@FindBy(xpath="//strong[contains(text(),'Image scheduler')]")
				public WebElement EditImageSchedulerPage;
				
				    public SiteConfigurationPage()  {		
					PageFactory.initElements(DriverManager.getWebDriver(), this);
				}
				

}
