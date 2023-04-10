package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class ProjectPage {

	@Name(Description="WebElement to Project page")
	@FindBy(xpath="//h2[contains(text(),'Project')]")
	public WebElement LaunchProjectPage;
	
	// Show list of project
	
	@Name(Description="List button")
	@FindBy(id="btnlistui")
	public WebElement ListButton;

	
	
	// Add project details.
	@Name(Description="Add button")
	@FindBy(id="btnaddui")
	public WebElement AddButton;
	
	@Name(Description="Panel Type Dropdown")
	@FindBy(id="//select[@id='ddlPanelType']")
	public WebElement PanelTypeDropDown;
	
	@Name(Description="Client Name Dropdown")
	@FindBy(id="//select[@id='ddlClientID']")
	public WebElement ClientNameDropDown;
	
	@Name(Description=" Project Name Textbox")
	@FindBy(xpath="//input[@id='txtProjectName']")
	public WebElement TextProjectName;
	
	@Name(Description="Add Project button")
	@FindBy(xpath="//a[@id='btnadd']")
	public WebElement AddProjectButton;
	
	
	//Add sensor manufacture
	
	@Name(Description="WebElement to Add View Project page")
	@FindBy(xpath="//h2[contains(text(),'View Project')]")
	public WebElement AddViewProjectPage;
	
	@Name(Description="Select sensor checkbox")
	@FindBy(xpath="(//input[@name='[0].SelectBool'])[1]")
	public WebElement SelectSensorCheck;	
	
	@Name(Description="Select Zone no Textbox")
	@FindBy(xpath="//input[@name='[0].ZoneNo']")
	public WebElement ZoneNoTextbox;	
	
	@Name(Description="Select Sensor Type")
	@FindBy(xpath="//tbody/tr[@id='811']/td[3]")
	public WebElement SensorType;	

	@Name(Description="Select Sensor Location Dropdown")
	@FindBy(xpath="//select[@name='[0].SensorLocation']")
	public WebElement SensorLocationDropDown;	
	
	@Name(Description="Select Sensor Description Textbox")
	@FindBy(xpath="//input[@name='[0].ZoneDescription']")
	public WebElement SensorDescriptionTextbox;
	
	@Name(Description="Select Sensor Schedular Checkbox")
	@FindBy(xpath="//input[@id='chksch811']")
	public WebElement SensorSchedularCheckbox;
	
	@Name(Description="Select Sensor Camera DropDown")
	@FindBy(xpath="//select[@name='[0].CameraNo']")
	public WebElement SensorCameraDropDown;
	
	@Name(Description="Select Sensor SMS Checkbox")
	@FindBy(xpath="(//input[@name='[0].SMSBool'])[1]")
	public WebElement SensorSMSCheckbox;
	
	@Name(Description="Sensor List - Configure the Manufacturers of sensors")
	@FindBy(xpath="//p[contains(text(),'Sensor List - Configure the Manufacturers of senso')]")
	public WebElement SensorList;
	
	@Name(Description="Sensor Manufacturer Dropdown")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//td//select")
	public WebElement SensorManufacturerDropdown;
	
	@Name(Description="Apply button")
	@FindBy(id="btnapplytoall")
	public WebElement ApplyButton;
	
	@Name(Description="Next button")
	@FindBy(xpath="//input[@id='btnadd']")
	public WebElement NextButton;
	
	@Name(Description="Cancel button")
	@FindBy(id="btncancel2")
	public WebElement CancelButton;
	
	//Add Camera manufacture

	@Name(Description="Camera List - Configure the Manufacturers details of Camera, DVR, Router and Network Provider")
	@FindBy(xpath="//p[contains(text(),'Camera List - Configure the Manufacturers details ')]")
	public WebElement CameraList;
	
	@Name(Description="Camera Manufacturer textbox")
	@FindBy(xpath="//select[@id='CAMMfgID003']")
	public WebElement CameraManuf;

	@Name(Description="Camera Model textbox")
	@FindBy(xpath="//select[@id='CAMModelID003']")
	public WebElement CameraModel;
	
	
	//Add DVR manufacture
	
	@Name(Description="Assets List - Configure the Manufacturers details of HDD, DVR, Router and Network Provider")
	@FindBy(xpath="//p[contains(text(),'Assets List - Configure the Manufacturers details')]")
	public WebElement AssetsList;
	
	@Name(Description=" DVR Manufacturer Name Dropdown")
	@FindBy(id="ddldvrmfg")
	public WebElement DVRManufacturerName;
	
	@Name(Description=" DVR Model Name Dropdown")
	@FindBy(id="ddldvrModel")
	public WebElement DVRModelName;
	
	@Name(Description=" DVR Version Name Textbox")
	@FindBy(id="txtdvrversion")
	public WebElement DVRVersionName;
	
	@Name(Description=" DVR Serial No  Textbox")
	@FindBy(id="txtDVRSerialNo")
	public WebElement DVRSerialNo;
	
	//Add Router manufacture
	
	@Name(Description=" Indicate to router details.")
	@FindBy(id="ddlRoutermfg")
	public WebElement RouterDetails;
	
	@Name(Description=" Router Manufacturer Name Dropdown")
	@FindBy(id="ddlRoutermfg")
	public WebElement RouterManufacturerName;
	
	@Name(Description=" Router Model Name Dropdown")
	@FindBy(id="ddlRouterModel")
	public WebElement RouterModelName;
	
	@Name(Description=" Router Version Name Textbox")
	@FindBy(id="txtRouterVersion")
	public WebElement RouterVersionName;
	
	@Name(Description=" Router Serial No  Textbox")
	@FindBy(id="txtRouterSerialNo")
	public WebElement RouterSerialNo;
	
	
	//Add HDD manufacture
	
	@Name(Description=" Indicate to HDD details.")
	@FindBy(id="//div[contains(text(),'Router')]")
	public WebElement HDDDetails;
	
	@Name(Description=" HDD Manufacturer Name Textbox")
	@FindBy(id="ddlHDDmfg")
	public WebElement HDDManufacturerName;
	
	@Name(Description=" HDD Model Name Textbox")
	@FindBy(id="ddlHDDModel")
	public WebElement HDDModelName;
	
	@Name(Description=" HDD Version Name Textbox")
	@FindBy(id="txtHDDCapacity")
	public WebElement HDDVersionName;
	
	@Name(Description=" HDD Serial No  Textbox")
	@FindBy(id="txtHDDSerialNo")
	public WebElement HDDSerialNo;
	
	//Add Network details manufacture
	
	@Name(Description=" Indicate to Network	 details.")
	@FindBy(xpath="//div[contains(text(),'Network')]")
	public WebElement Networkdetails;
	
	@Name(Description=" Network provider Dropdown")
	@FindBy(id="ddlNtwProvider")
	public WebElement NetworkProvider;
	
	@Name(Description=" Network type Dropdown")
	@FindBy(id="ddlNtwType")
	public WebElement NetworkType;
	
	
	//Add escalation details.
	
	@Name(Description=" Indicate to Escalation Master")
	@FindBy(xpath="//p[contains(text(),'Escalation Master')]")
	public WebElement EscalationMasterpage;
	
	@Name(Description="Select Template Dropdown")
	@FindBy(xpath="(//select[@id='ddlesctemplate'])[1]")
	//@FindBy(xpath="//div[@class='form-group']//select")
	public WebElement TemplateSelectDropdown;

	@Name(Description="Add Project escalation name textbox")
	@FindBy(xpath="//input[@id='txtcontactperson1']")
	public WebElement AddProjectEscNameText;
	
	@Name(Description="Add Project escalation Comments textbox")
	@FindBy(xpath="//tbody/tr[@id='1']/td[3]/input[1]")
	public WebElement AddProjectEscCommentsText;
	
	@Name(Description="Add Project escalation Telephone textbox")
	@FindBy(xpath="//tbody/tr[@id='1']/td[4]/input[1]")
	public WebElement AddProjectEscTelephoneText;
	
	@Name(Description="Add Project escalation SMS Checkbox")
	@FindBy(xpath="//input[@id='chksms1']")
    public WebElement AddProjectEscSMSCheckbox;
	
	@Name(Description="Add Project escalation Mobile Textbox")
	@FindBy(xpath="//input[@id='txtcellno1']")
	public WebElement AddProjectEscMobileTextbox;

	@Name(Description="Add Project escalation Email Checkbox")
	@FindBy(xpath="//input[@id='txtcellno1']")
	public WebElement AddProjectEscEmailCheckox;

	@Name(Description="Add Project escalation EmailID Textbox")
	@FindBy(xpath="//input[@id='txtemail1']")
	public WebElement AddProjectEscEmailIDTextbox;

	@Name(Description="Add Project escalation Priority Dropdown")
	@FindBy(xpath="//select[@id='ddlPriority-1']")
	public WebElement AddProjectEscProrityDropdown;

	@Name(Description="Add Project escalation Repeat Interval  Dropdown")
	@FindBy(xpath="//select[@id='ddlRepeatInterval1']")
	public WebElement AddProjectEscRepeatIntervalDropdown;
	
	@Name(Description="Finish button")
	@FindBy(xpath="//input[@id='btnfinish']")
	public WebElement FinishButton;
	
	@Name(Description="Cancel button")
	@FindBy(xpath="//a[@class='btn btn-warning']")
	public WebElement CancleButton;

	//Project Added.
	
	//View and update project details.

	@Name(Description="Panel Type Dropdown")
	@FindBy(id="ddlPanelType")
	public WebElement PanelType;
	
	@Name(Description="Client Name Type Dropdown")
	@FindBy(id="ddlClientID")
	public WebElement ClientName;
	
	@Name(Description=" Project Name Type Dropdown")
	@FindBy(id="ddlProjectID")
	public WebElement ProjectNameDropdown;

	@Name(Description="View Project button")
	@FindBy(id="btnDummyView")
	public WebElement ViewProjectButton;
	
	//Update and delete template details page.
	
	@Name(Description="Update View Project Page")
	@FindBy(xpath="//div[@class='panel-heading']//div[@class='row']")
	public WebElement UpdateViewProjectPage;

	@Name(Description="Update template details")
	@FindBy(xpath="//a[contains(text(),'Template Details')]")
	public WebElement UpdatetemplateDetails;
	
	
	//Add sensor button in project
	
	@Name(Description="Add all Sensor checkbox")
	@FindBy(id="checkAll")
	public WebElement AllSensorCheckBox;
	
	@Name(Description="Add Sensor button")
	@FindBy(id="btnaddnewsensor")
	public WebElement AddsensorButton;
	
	@Name(Description="Update button for template details.")
	@FindBy(id="btnupdate")
	public WebElement UpdateTempDeButton;
	
	@Name(Description="Delete button for template details.")
	@FindBy(id="btndelete")
	public WebElement DeleteTempDButton;
	
	@Name(Description="Cancel button for template details.")
	@FindBy(xpath="//input[@class='btn btn-warning btn-sm']")
	public WebElement CancelTempDButton;
	
	//Update and delete Sensor details page.

		@Name(Description="Update sensor details")
		@FindBy(xpath="//a[contains(text(),'Sensor Details')]")
		public WebElement UpdateSensor;
		
		@Name(Description="Apply all button for Sensor details.")
		@FindBy(id="btnapplytoall")
		public WebElement ApplyAllButton;
		
		@Name(Description="Update button for Sensor details.")
		@FindBy(id="btnupdate")
		public WebElement UpdateSensorDeButton;
		
		@Name(Description="Cancel button for Sensor details.")
		@FindBy(xpath="//input[@class='btn btn-warning btn-sm']")
		public WebElement CancelSensorDeButton;
	
		//Update and delete camera details page.
		
		@Name(Description="Update Camera details")
		@FindBy(xpath="//a[contains(text(),'Camera Details')]")
		public WebElement UpdateCamera;
		
		@Name(Description="Update button for camera details.")
		@FindBy(id="btnupdatecam")
		public WebElement UpdatecameraDeButton;
		
		@Name(Description="Cancel button for camera details.")
		@FindBy(xpath="//input[@class='btn btn-warning btn-sm']")
		public WebElement CancelcameraDeButton;
		
		//Update and delete Asset details page.
		
		@Name(Description="Indicate to Update Asset details")
		@FindBy(xpath="//a[contains(text(),'Asset Details')]")
		public WebElement UpdateAsset;
	
		//Update and delete DVR details page
		
		@Name(Description="Update DVR details")
		@FindBy(xpath="//div[contains(text(),'DVR')]")
		public WebElement UpdateDVR;
	
		@Name(Description="Update DVR Manufacturer Name Dropdown")
		@FindBy(id="ddldvrmfg")
		public WebElement UpdateDVRManufacturerName;
		
		@Name(Description="Update DVR Model Name Dropdown")
		@FindBy(id="ddldvrModel")
		public WebElement UpdateDVRModelName;
		
		@Name(Description="Update DVR Version Name Textbox")
		@FindBy(id="txtdvrversion")
		public WebElement UpdateDVRVersionName;
		
		@Name(Description="Update DVR Serial No  Textbox")
		@FindBy(id="txtDVRSerialNo")
		public WebElement UpdateDVRSerialNo;
		
	
		//Update and delete Router manufacture
		
		@Name(Description="Indicate to Update router details.")
		@FindBy(xpath="//div[contains(text(),'Router')]")
		public WebElement UpdateRouterDetails;
		
		@Name(Description="Update Router Manufacturer Name Dropdown")
		@FindBy(id="ddlRoutermfg")
		public WebElement UpdateRouterMfgName;
		
		@Name(Description="Update Router Model Name Dropdown")
		@FindBy(id="ddlRouterModel")
		public WebElement UpdateRouterModelName;
		
		@Name(Description="Update Router Version Name Textbox")
		@FindBy(id="txtRouterVersion")
		public WebElement UpdateRouterVersionName;
		
		@Name(Description="Update Router Serial No  Textbox")
		@FindBy(id="txtRouterSerialNo")
		public WebElement UpdateRouterSerialNo;
	
		//Update and delete HDD manufacture
		
		@Name(Description=" Indicate to Update HDD details.")
		@FindBy(id="//div[contains(text(),'Router')]")
		public WebElement UpdateHDDDetails;
		
		@Name(Description="Update HDD Manufacturer Name Textbox")
		@FindBy(id="ddlHDDmfg")
		public WebElement UpdateHDDMfgName;
		
		@Name(Description="Update HDD Model Name Textbox")
		@FindBy(id="ddlHDDModel")
		public WebElement UpdateHDDModelName;
		
		@Name(Description="Update HDD Version Name Textbox")
		@FindBy(id="txtHDDCapacity")
		public WebElement UpdateHDDVersionName;
		
		@Name(Description="Update HDD Serial No  Textbox")
		@FindBy(id="txtHDDSerialNo")
		public WebElement UpdateHDDSerialNo;
		
		//Update and delete Network Provider
		
		@Name(Description=" Indicate to Update Network details.")
		@FindBy(xpath="//div[contains(text(),'Network')]")
		public WebElement UpdateNetworkdetails;
		
		@Name(Description="Update Network provider Dropdown")
		@FindBy(id="ddlNtwProvider")
		public WebElement UpdateNetworkProvider;
		
		@Name(Description="Update Network type Dropdown")
		@FindBy(id="ddlNtwType")
		public WebElement UpdateNetworkType;
		
		@Name(Description="Update Button")
		@FindBy(id="btnupdate")
		public WebElement UpdateButton;
		
		@Name(Description="Cancel Button")
		@FindBy(xpath="//input[@class='btn btn-warning btn-sm']")
		public WebElement CancelBut;
		
		//Update and delete escalation details.
		
		@Name(Description=" Indicate to Update the Escalation Master")
		@FindBy(xpath="//p[contains(text(),'Escalation Master')]")
		public WebElement UpdateEscalationMasterpage;
		
		@Name(Description="Update and Select Template Dropdown")
		@FindBy(id="ddlesctemplate")
		public WebElement UpdateTemplateSelect;
		
		@Name(Description="Update button")
		@FindBy(id="btnupdate")
		public WebElement UpdateEscButton;
		
		@Name(Description="Cancel button")
		@FindBy(xpath="//a[@class='btn btn-warning']")
		public WebElement CancleEscButton;
		
		//Update  completed.
		
	public ProjectPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
	}
	
	
