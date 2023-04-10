package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class PanelsPage {

	@Name(Description="WebElement to indicate to Panel page")
	@FindBy(xpath="//h2[contains(text(),'Panel')]")
	public WebElement LaunchPanelsPage;
	
	@Name(Description="Search panels textbox")
	@FindBy(id="txtsearch")
	public WebElement SearchPanels;
	
	@Name(Description="Active radio button")
	@FindBy(id="rbtAct")
	public WebElement ActivePanelsRB;
	
	@Name(Description="Inactive radio button")
	@FindBy(id="rbtDeactive")
	public WebElement InactivePanelsRB;
	
	@Name(Description="All radio button")
	@FindBy(id="rbtAct")
	public WebElement AllPanelsRB;
	
	@Name(Description="Search panels Buton")
	@FindBy(xpath="//input[@id='btnsearch']")
	public WebElement SearchPanelsBtn;
	
	@Name(Description="Editbtn")
	@FindBy(xpath="//a[@title='Edit']")
	public WebElement editbtn;
	
	@Name(Description="Edit page header")
	@FindBy(xpath="//h2[contains(text(),'Edit')]")
	public WebElement Editpageheader;
	
	@Name(Description="Export Buton")
	@FindBy(id="btnExport")
	public WebElement ExportButton;
	
	@Name(Description="List Buton")
	@FindBy(id="btnlistui")
	public WebElement ListButton;
	
 // For Add panels
	
	@Name(Description="Add Buton")
	@FindBy(id="btnaddui")
	public WebElement AddButton;
	
	@Name(Description="WebElement to indicate to Add Panel page")
	@FindBy(xpath="//h2[contains(text(),'Add Panel')]")
	public WebElement LaunchAddPanelPage;
	
	@Name(Description="Panel Template Search  textbox")
	@FindBy(id="ddlPanelTemplateID")
	public WebElement PanelTemplateTxt;
	
	@Name(Description="Select Client name Dropdown")
	@FindBy(id="ddlClientID")
	public WebElement ClientNameDD;
	
	@Name(Description="Select Panel type Dropdown")
	@FindBy(xpath="//select[@id='ddlPanelType']")
	public WebElement PanelTypeDD;
	
	@Name(Description="Select Project Name Dropdown")
	@FindBy(id="ddlProjectID")
	public WebElement ProjectName;
	
	@Name(Description="Panel ID textbox")
	@FindBy(id="txtPanelID")
	public WebElement PanelIDText;
	
	/* Panel IP and Panel port is auto generated.
	
	@Name(Description="Panel IP ")
	@FindBy(id="Panel_IP")
	public WebElement PanelIPText;
	
	@Name(Description="Panel Port")
	@FindBy(id="ClientPort")
	public WebElement PanelPortText;
	
	*/
	
	@Name(Description="Add Client Circle Dropdown")
	@FindBy(id="ddlclientcircle")
	public WebElement ClientCircle;
	
	@Name(Description="Add SOL ID/Site ID Textbox")
	@FindBy(id="txtSOLID")
	public WebElement SOLID;
	
	@Name(Description="Add Manufacturing ID Textbox")
	@FindBy(id="txtMfgID")
	public WebElement ManufacturingIDText;
	
	@Name(Description="Add Select State Dropdown")
	@FindBy(id="ddlstate")
	public WebElement StateDD;
	
	@Name(Description="Add Select City Dropdown")
	@FindBy(id="ddlcity")
	public WebElement CityDD;
	
	@Name(Description="Add Pincode Textbox")
	@FindBy(id="txtpincode")
	public WebElement PincodeText;
	
	@Name(Description="Pincode")
	@FindBy(xpath="//input[@Id='Pincode']")
	public WebElement pincode;
	
	@Name(Description="sitelocation")
	@FindBy(xpath="//textarea[@Id='Panel_Location']")
	public WebElement sitelocation;
	
	@Name(Description="siteaddress")
	@FindBy(xpath="//textarea[@Id='Panel_Address']")
	public WebElement siteaddress;
	
	@Name(Description="Branch")
	@FindBy(xpath="//input[@Id='Panel_Name']")
	public WebElement Branch;
	
	
	@Name(Description="Add Site Address Textbox")
	@FindBy(id="txtPanelAddress")
	public WebElement SiteAddressText;
	
	@Name(Description="Add Site Location Textbox")
	@FindBy(id="txtLocation")
	public WebElement SIteLocationText;
	
	@Name(Description="Add Branch Name Textbox")
	@FindBy(xpath="//input[@id='txtPanelName']")
	public WebElement BranchText;
	
	@Name(Description="Add Panel Manufacturer Textbox")
	@FindBy(xpath="//select[@id='ddlpanelmfgid']")
	public WebElement PanelMfgDD;
	
	@Name(Description="Add Panel Model Dropdown")
	@FindBy(id="ddlpanelmodelid")
	public WebElement PanelModelDD;
	
	@Name(Description="Add Installation Vendor Dropdown")
	@FindBy(id="ddlInstAgencyID")
	public WebElement InstallationVendorDD;
	
	@Name(Description="Add CRA Agency Dropdown")
	@FindBy(id="ddlCRAAgencyID")
	public WebElement CRAAgencyDD;
	
	@Name(Description="Add HK agency Dropdown")
	@FindBy(id="ddlHKAgencyID")
	public WebElement HKAgencyDD;
	
	@Name(Description="Add MSP Agency Dropdown")
	@FindBy(id="ddlMSPID")
	public WebElement MSPAgencyDD;
 
	@Name(Description="Add Project Co-Ordinator Dropdown")
	@FindBy(id="ddlcoordinator")
	public WebElement ProCodDD;
	
	@Name(Description="Add Project lead Dropdown")
	@FindBy(id="ddllead")
	public WebElement ProjectLeadDD;
	
	@Name(Description="Add Project Manager Dropdown")
	@FindBy(id="ddlmanager")
	public WebElement ProjectManagerDD;
	
	@Name(Description="Add Territory Name Dropdown")
	@FindBy(id="ddlTerritoryName")
	public WebElement TerritoryName;
	
	@Name(Description="Add Territory Manager Name Dropdown")
	@FindBy(id="ddlTerritoryManager")
	public WebElement TerritoryMgrName;
	
	@Name(Description="Add Subscription Dropdown")
	@FindBy(id="ddlSubName")
	public WebElement Subscription;
	
	@Name(Description="Add MDN no textbox")
	@FindBy(id="txtMDNNo")
	public WebElement MDNTextbox;

	@Name(Description="Add Antenna Dropdown")
	@FindBy(id="ddlAntenna")
	public WebElement AntennaDD;
	
	@Name(Description="Add ATM 1 ID textbox")
	@FindBy(id="txtATM1_ID")
	public WebElement ATM1ID;
	
	@Name(Description="Add ATM 2 ID textbox")
	@FindBy(id="txtATM2_ID")
	public WebElement ATM2ID;
	
	@Name(Description="Add ATM 3 ID textbox")
	@FindBy(id="txtATM2_ID")
	public WebElement ATM3ID;
	
	@Name(Description="Add ATM 4 ID textbox")
	@FindBy(id="txtATM4_ID")
	public WebElement ATM4ID;
	
	@Name(Description="Add ATM 5 ID textbox")
	@FindBy(id="txtATM5_ID")
	public WebElement ATM5ID;
	
	@Name(Description="Add Panel Current vesrion textbox")
	@FindBy(id="txtPanelCurrentVersion")
	public WebElement PanelCurVersion;
	
	@Name(Description="Add Server Port textbox")
	@FindBy(id="txtServerPort")
	public WebElement ServerPortText;
	
	@Name(Description="Add Latitude textbox")
	@FindBy(id="txtLatitude")
	public WebElement LatitudeText;
	
	@Name(Description="Add Longitude textbox")
	@FindBy(id="txtLongitude")
	public WebElement LongitudeText;
	
	@Name(Description="Add DVR Type DropDown")
	@FindBy(id="ddlDVRType")
	public WebElement DVRTypeDD;

	@Name(Description="Add DVR User ID Textbox")
	@FindBy(id="txtDVRUserid")
	public WebElement DVRIDDD;
	
	@Name(Description="Add DVR Password Textbox")
	@FindBy(id="txtDVRPassword")
	public WebElement DVRPass;
	
	@Name(Description="Add DVR Port Textbox")
	@FindBy(id="txtDVRPort")
	public WebElement DVRPort;
	
	@Name(Description="Add DVR Channel Dropdown")
	@FindBy(id="ddlDVRChannel")
	public WebElement DVRChannelDD;
	
	@Name(Description="DVRCHANNEL")
	@FindBy(xpath="//select[@id='DVRChannel']")
	public WebElement Channels;
	
	@Name(Description="Add HDD 1 Total space Textbox")
	@FindBy(id="txtHDDSpace1")
	public WebElement HDD1SpaceText;
	
	@Name(Description="Add HDD 2 Total space Textbox")
	@FindBy(id="txtHDDSpace2")
	public WebElement HDD2SpaceText;
	
	@Name(Description="Panel Details Save Button ")
	@FindBy(id="btnadd")
	public WebElement SaveButton;
	
	@Name(Description="Panel Details edit Button ")
	@FindBy(xpath="//input[@id='btnupdate']")
	public WebElement UpdateButton;
	
	@Name(Description="Update panel message")
	@FindBy(xpath="//div[@id='divSuccess']")
	public WebElement Updatemsg;
	
	@Name(Description="Delete Panel  button ")
	@FindBy(xpath="//a[@id='btndelete']")
	public WebElement DeletePanelButton;
	
	@Name(Description="Refresh button Button ")
	@FindBy(id="btnrefresh")
	public WebElement RefreshButton;
	
	@Name(Description="Display Success message for add panel")
	@FindBy(id="divSuccess")
	public WebElement SuccessMsg;
	
	@Name(Description="Check all")
	@FindBy(xpath="//input[@Id='chkAll']")
	public WebElement CheckAll;
		
	@Name(Description="Display alert  message for add duplicate panel")
	@FindBy(id="divinvalid")
	public WebElement DuplicateAlertMsg;
	
	// Add sensor Configuration.

	@Name(Description="Sensor Configuration Button ")
	@FindBy(id="btnsensors")
	public WebElement SensorConfigButton;
		
	//Add template details in sensor configuration page
	
	@Name(Description="WebElement to indicate to Template details Page")
	@FindBy(xpath="//a[contains(text(),'Template Details')]")
	public WebElement TemplateDetailsSC;
	
	@Name(Description="Add Sensor  button ")
	@FindBy(id="btnAddSensor")
	public WebElement AddSensorButton;
	
	@Name(Description="Sensor btn")
	@FindBy(xpath="//a[@id='btnsensors']")
	public WebElement Sensorbtn;
	
	@Name(Description="Update Sensor  button ")
	@FindBy(id="btnUpdate")
	public WebElement UpdateSensorButton;
	
	@Name(Description="Delete Sensor  button ")
	@FindBy(id="btnDelete")
	public WebElement DeleteSensorButton;
	
	@Name(Description="Cancel Sensor  button ")
	@FindBy(xpath="//input[@class='btn btn-warning btn-sm']")
	public WebElement CancelSensorButton;
	
	@Name(Description="UpdateTemplate message")
	@FindBy(xpath="//div[@id='divSuccessMsg']")
	public WebElement Templatemsg;
	
	@Name(Description="Sensor details")
	@FindBy(xpath="//a[contains(text(),'Sensor Details')]")
	public WebElement sensordetails;
	
	@Name(Description="Camera details")
	@FindBy(xpath="//a[contains(text(),'Camera Details')]")
	public WebElement Cameradetails;
	
	@Name(Description="Sensor update btn")
	@FindBy(xpath="//input[@id='btnUpdateSensorDetails']")
	public WebElement Sensorupdatebtn;
	
	@Name(Description="Sensor update message")
	@FindBy(xpath="//div[@id='divSuccess']")
	public WebElement sensorupdatemsg;
	
	@Name(Description="camera update btn")
	@FindBy(xpath="//input[@id='btnUpdateCameraDetails']")
	public WebElement cameraupdatebtn;
	
	@Name(Description="camera update message")
	@FindBy(xpath="//div[@id='divSuccess']")
	public WebElement cameraupdatemsg;
	
	@Name(Description="Asset details")
	@FindBy(xpath="//a[contains(text(),'Asset Details')]")
	public WebElement Assetdetails;
	
	@Name(Description="Asset update btn")
	@FindBy(xpath="//input[@id='btnUpdateAssetDetails']")
	public WebElement Assetupdatebtn;
	
	@Name(Description="Asset update message")
	@FindBy(xpath="//div[@id='divSuccess']")
	public WebElement Assetupdatemsg;
	
	//Add sensor details in sensor configuration
	//select sensor mfg for each zone no
	
	@Name(Description="WebElement to indicate to Sensor details Page")
	@FindBy(xpath="//a[contains(text(),'Sensor Details')]")
	public WebElement SensorDetailsSC;
	
	@Name(Description="Update Sensor details button ")
	@FindBy(id="btnUpdateSensorDetails")
	public WebElement UpdateSensorDetails;
	
	@Name(Description="Cancel Sensor  button ")
	@FindBy(xpath="//input[@class='btn btn-warning btn-sm']")
	public WebElement CancelSensorDetails;
	
	//Add Camera details.
	
	@Name(Description="WebElement to indicate to camera details Page")
	@FindBy(xpath="//a[contains(text(),'Sensor Details')]")
	public WebElement CameraDetailsSC;
	
	
	
	
	//Add escalation configuration.
	
	@Name(Description="Escalation configuration button Button ")
	@FindBy(id="btnescalations")
	public WebElement EscConfigButton;

	// Update and delete Panel is remaining.
	
	@Name(Description="Edit panel Buton")
	@FindBy(xpath="//a[@class='glyphicon glyphicon-edit btn btn-success btn-xs']")
	public WebElement EditPanelButton;
	
	@Name(Description="Searchpanel")
	@FindBy(xpath="//input[@id='txtsearch']")
	public WebElement panelsearch;
	
	@Name(Description="WebElement to indicate to edit Panel page")
	@FindBy(xpath="//h2[contains(text(),'Edit')]")
	public WebElement LaunchEditPanelPage;
	
	@Name(Description="Panel Template Search  textbox")
	@FindBy(id="ddlPanelTemplateID")
	public WebElement EditPanelTemplateTxt;
	
	@Name(Description="Select Client name Dropdown")
	@FindBy(id="ddlClientID")
	public WebElement EditClientNameDD;
	
	@Name(Description="Select Panel type Dropdown")
	@FindBy(id="ddlPanelType")
	public WebElement EditPanelTypeDD;
	
	@Name(Description="Select Project Name Dropdown")
	@FindBy(id="ddlProjectID")
	public WebElement EditProjectName;
	
	@Name(Description="Panel ID textbox")
	@FindBy(id="txtPanelID")
	public WebElement EditPanelIDText;
	
	/* Panel IP and Panel port is auto generated.
	
	@Name(Description="Panel IP ")
	@FindBy(id="Panel_IP")
	public WebElement EditPanelIPText;
	
	@Name(Description="Panel Port")
	@FindBy(id="ClientPort")
	public WebElement EditPanelPortText;
	
	*/
	
	@Name(Description="Add Client Circle Dropdown")
	@FindBy(id="ddlclientcircle")
	public WebElement EditClientCircle;
	
	@Name(Description="Add SOL ID/Site ID Textbox")
	@FindBy(id="txtSOLID")
	public WebElement EditSOLID;
	
	@Name(Description="Add Manufacturing ID Textbox")
	@FindBy(id="txtMfgID")
	public WebElement EditManufacturingIDText;
	
	@Name(Description="Add Select State Dropdown")
	@FindBy(id="ddlstate")
	public WebElement EditStateDD;
	
	@Name(Description="Add Select City Dropdown")
	@FindBy(id="ddlcity")
	public WebElement EditCityDD;
	
	@Name(Description="Add Pincode Textbox")
	@FindBy(id="txtpincode")
	public WebElement EditPincodeText;
	
	@Name(Description="Add Site Address Textbox")
	@FindBy(id="txtPanelAddress")
	public WebElement EditSiteAddressText;
	
	@Name(Description="Add Site Location Textbox")
	@FindBy(id="txtLocation")
	public WebElement EditSIteLocationText;
	
	@Name(Description="Add Branch Name Textbox")
	@FindBy(id="txtLocation")
	public WebElement EditBranchText;
	
	@Name(Description="Add Panel Manufacturer Textbox")
	@FindBy(id="txtLocation")
	public WebElement EditPanelMfgDD;
	
	@Name(Description="Add Panel Model Dropdown")
	@FindBy(id="ddlpanelmodelid")
	public WebElement EditPanelModelDD;
	
	@Name(Description="Add Installation Vendor Dropdown")
	@FindBy(id="ddlInstAgencyID")
	public WebElement EditInstallationVendorDD;
	
	@Name(Description="Add CRA Agency Dropdown")
	@FindBy(id="ddlCRAAgencyID")
	public WebElement EditCRAAgencyDD;
	
	@Name(Description="Add HK agency Dropdown")
	@FindBy(id="ddlHKAgencyID")
	public WebElement EditHKAgencyDD;
	
	@Name(Description="Add MSP Agency Dropdown")
	@FindBy(id="ddlMSPID")
	public WebElement EditMSPAgencyDD;
 
	@Name(Description="Add Project Co-Ordinator Dropdown")
	@FindBy(id="ddlcoordinator")
	public WebElement EditProCodDD;
	
	@Name(Description="Add Project lead Dropdown")
	@FindBy(id="ddllead")
	public WebElement EditProjectLeadDD;
	
	@Name(Description="Add Project Manager Dropdown")
	@FindBy(id="ddlmanager")
	public WebElement EditProjectManagerDD;
	
	@Name(Description="Add Territory Name Dropdown")
	@FindBy(id="ddlTerritoryName")
	public WebElement EditTerritoryName;
	
	@Name(Description="Add Territory Manager Name Dropdown")
	@FindBy(id="ddlTerritoryManager")
	public WebElement EditTerritoryMgrName;
	
	@Name(Description="Add Subscription Dropdown")
	@FindBy(id="ddlSubName")
	public WebElement EditSubscription;
	
	@Name(Description="Add MDN no textbox")
	@FindBy(id="txtMDNNo")
	public WebElement EditMDNTextbox;

	@Name(Description="Add Antenna Dropdown")
	@FindBy(id="ddlAntenna")
	public WebElement EditAntennaDD;
	
	@Name(Description="Add ATM 1 ID textbox")
	@FindBy(id="txtATM1_ID")
	public WebElement EditATM1ID;
	
	@Name(Description="Add ATM 2 ID textbox")
	@FindBy(id="txtATM2_ID")
	public WebElement EditATM2ID;
	
	@Name(Description="Add ATM 3 ID textbox")
	@FindBy(id="txtATM2_ID")
	public WebElement EditATM3ID;
	
	@Name(Description="Add ATM 4 ID textbox")
	@FindBy(id="txtATM4_ID")
	public WebElement EditATM4ID;
	
	@Name(Description="Add ATM 5 ID textbox")
	@FindBy(id="txtATM5_ID")
	public WebElement EditATM5ID;
	
	@Name(Description="Add Panel Current vesrion textbox")
	@FindBy(id="txtPanelCurrentVersion")
	public WebElement EditPanelCurVersion;
	
	@Name(Description="Add Server Port textbox")
	@FindBy(id="txtServerPort")
	public WebElement EditServerPortText;
	
	@Name(Description="Add Latitude textbox")
	@FindBy(id="txtLatitude")
	public WebElement EditLatitudeText;
	
	@Name(Description="Add Longitude textbox")
	@FindBy(id="txtLongitude")
	public WebElement EditLongitudeText;
	
	@Name(Description="Add DVR Type DropDown")
	@FindBy(id="ddlDVRType")
	public WebElement EditDVRTypeDD;

	@Name(Description="Add DVR User ID Textbox")
	@FindBy(id="txtDVRUserid")
	public WebElement EditDVRIDDD;
	
	@Name(Description="Add DVR Password Textbox")
	@FindBy(id="txtDVRPassword")
	public WebElement EditDVRPass;
	
	@Name(Description="Add DVR Port Textbox")
	@FindBy(id="txtDVRPort")
	public WebElement EditDVRPort;
	
	@Name(Description="Add DVR Channel Dropdown")
	@FindBy(id="ddlDVRChannel")
	public WebElement EditDVRChannelDD;
	
	@Name(Description="Add HDD 1 Total space Textbox")
	@FindBy(id="txtHDDSpace1")
	public WebElement EditHDD1SpaceText;
	
	@Name(Description="Add HDD 2 Total space Textbox")
	@FindBy(id="txtHDDSpace2")
	public WebElement EditHDD2SpaceText;
	
	@Name(Description="Panel Details Save Button ")
	@FindBy(id="btnupdate")
	public WebElement UpdateSaveButton;
	
	@Name(Description="Display Success message for update panel")
	@FindBy(id="divSuccess")
	public WebElement UpdateSuccessMsg;
	

	
	public PanelsPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
	
}










