package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class MasterTemplate {

	@Name(Description="WebElement to Tempalate page")
	@FindBy(xpath="//h2[contains(text(),'Master Template')]")
	public WebElement LaunchTemplatePage;
	
	@Name(Description="Panel Type Label")
	@FindBy(xpath="//label[contains(text(),'Panel Type')]\"))")
	public WebElement PanelType;
	
	@Name(Description="Select Panel Type Dropdown")
	@FindBy(xpath="//select[@id='ddlPanelType']") 
	public WebElement SelectPaneType;
		
	@Name(Description="Go Button")
	@FindBy(id="btnGo")
	public WebElement GoButton;
	
	//ATM template
	@Name(Description="WebElement to ATM Template page")
	@FindBy(xpath="//h2[contains(text(),'ATMTemplate')]")
	public WebElement LaunchATMTemplatePage;
	
	@Name(Description="WebElement to Template Details page")
	@FindBy(xpath="//a[contains(text(),'Template Details')]")
	public WebElement LaunchATMTemplateDetails;
	
	@Name(Description="	Location Textbox")
	@FindBy(xpath="(//div[@class='table-responsive']//table//tbody//td[2])[1]") 
	public WebElement LocationATMTextbox;
	
	@Name(Description="TemplateHeader")
	@FindBy(xpath="//h2[text()='ATMTemplate']")
	public WebElement TemplateHeader;
	
	@Name(Description="	Description Textbox")
	@FindBy(xpath="(//div[@class='table-responsive']//table//tbody//td[3])[1]") 
	public WebElement DescriptionATMTextbox;
	
	@Name(Description="	Scheduler CheckBox")
	@FindBy(xpath="//input[@id='chksch514']") 
	public WebElement SchedulerATMCheckbox;
	
	@Name(Description="	Camera DropDown")
	@FindBy(xpath="(//div[@class='table-responsive']//table//tbody//td[5])[1]") 
	public WebElement CameraATMDropDown;

	@Name(Description="	ATM Template SMS CheckBox")
	@FindBy(xpath="//tbody/tr[@id='514']/td[6]/input[1]") 
	public WebElement ATMTempSMSCheckbox;
	
	@Name(Description="Template Update Button")
	@FindBy(id="btnupdate")
	public WebElement TemplateATMUpdateButton;
	
	@Name(Description="Display Success message")
	@FindBy(xpath="//div[@id='divSuccess']")
	public WebElement UpdateSuccessMsg;
	
	@Name(Description="Template Delete Button")
	@FindBy(name="btndelete")
	public WebElement TemplateATMDeleteButton;
	
	@Name(Description="Template Cancel Button")
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement TemplateATMCancelButton;

	
	//Escalation ATM template Details.
	
	
	@Name(Description="WebElement to Escalation Details page")
	@FindBy(xpath="//a[contains(text(),'Escalation Details')]")
	public WebElement LaunchEscalationDetails;
	
	@Name(Description="Select Template name Dropdown")
	@FindBy(id="ddlesctemplate") 
	public WebElement SelectTemplateName;
	
	@Name(Description="Name Textbox")
	@FindBy(id="ddlesctemplate") 
	public WebElement NameTextbox;
	
	@Name(Description="Comments Textbox")
	@FindBy(xpath="//tbody/tr[@id='11']/td[3]/input[1]") 
	public WebElement CommentsTextbox;
	
	@Name(Description="Telephone No Textbox")
	@FindBy(xpath="//tbody/tr[@id='11']/td[4]/input[1]") 
	public WebElement TelephoneNoTextbox;
	
	@Name(Description="Escalation Template SMS Checkbox")
	@FindBy(xpath="//input[@id='chksms11']") 
	public WebElement EscTempSMSCheckbox;
	
	@Name(Description="Mobile No Textbox")
	@FindBy(xpath="//input[@id='txtcellno11']") 
	public WebElement MobileTextbox;
	
	@Name(Description="Email Checkbox")
	@FindBy(xpath="//input[@id='chkemail11']") 
	public WebElement EmailCheckbox;
	
	@Name(Description="Email ID Textbox")
	@FindBy(xpath="//input[@id='txtemail11']") 
	public WebElement EmailIDTextbox;
	
	@Name(Description="Priority DropDown")
	@FindBy(xpath="//select[@id='ddlPriority-11']") 
	public WebElement PriorityDropDown;

	@Name(Description="Repeat Interval (min.) DropDown")
	@FindBy(xpath="//select[@id='ddlRepeatInterval11']") 
	public WebElement RepeatIntervalMinDropDown;

	@Name(Description="Escalation Update Button")
	@FindBy(id="btnUpdate")
	public WebElement EscUpdateButton;
	
	@Name(Description="Escalation Delete Button")
	@FindBy(name="btndelete")
	public WebElement EscDeleteButton;
	
	@Name(Description="Escalation Cancel Button")
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement EscCancelButton;
	
	
	//Commercial template
	
	//ATM template
		@Name(Description="WebElement to ATM Template page")
		@FindBy(xpath="//h2[contains(text(),'ATMTemplate')]")
		public WebElement LaunchCommercialTemplatePage;
		
		@Name(Description="WebElement to Template Details page")
		@FindBy(xpath="//a[contains(text(),'Template Details')]")
		public WebElement LaunchCommercialTemplateDetails;
		
		@Name(Description="	Location Textbox")
		@FindBy(xpath="//input[@id='txtlocation464']") 
		public WebElement LocationCommercialTextbox;
		
		@Name(Description="	Description Textbox")
		@FindBy(xpath="//input[@id='txtdescription464']") 
		public WebElement DescriptionCommercialTextbox;
		
		@Name(Description="	Scheduler CheckBox")
		@FindBy(xpath="//input[@id='chksch464']") 
		public WebElement SchedulerCommercialCheckbox;
		
		@Name(Description="	Camera Textbox")
		@FindBy(xpath="//tbody/tr[@id='464']/td[5]/select[1]") 
		public WebElement CameraCommercialTextbox;

		@Name(Description="	ATM Template SMS CheckBox")
		@FindBy(xpath="//tbody/tr[@id='464']/td[6]/input[1]") 
		public WebElement CommercialTempSMSCheckbox;
		
		@Name(Description="Template Update Button")
		@FindBy(xpath="//input[@id='btnupdate']")
		public WebElement TemplateCommercialUpdateButton;
		
		@Name(Description="Template Delete Button")
		@FindBy(xpath="//input[@id='btndelete']")
		public WebElement TemplateCommercialDeleteButton;
		
		@Name(Description="Template Cancel Button")
		@FindBy(xpath="//a[contains(text(),'Cancel')]")
		public WebElement TemplateCommercialCancelButton;

		//Escalation commercial template Details.
		
		
		@Name(Description="WebElement to Escalation Details page")
		@FindBy(xpath="//a[contains(text(),'Escalation Details')]")
		public WebElement LaunchCommercialEscalationDetails;
		
		@Name(Description="Select Template name Dropdown")
		@FindBy(xpath="//select[@id='ddlesctemplate']") 
		public WebElement SelectCommercialTemplateName;
		
		@Name(Description="Name Textbox")
		@FindBy(id="txtcontactperson1") 
		public WebElement CommercialEscNameTextbox;
		
		@Name(Description="Comments Textbox")
		@FindBy(xpath="//tbody/tr[@id='1']/td[3]/input[1]") 
		public WebElement CommercialEscCommentsTextbox;
		
		@Name(Description="Telephone No Textbox")
		@FindBy(xpath="//tbody/tr[@id='1']/td[4]/input[1]") 
		public WebElement CommercialEscTelephoneNoTextbox;
		
		@Name(Description="Escalation Template SMS Checkbox")
		@FindBy(xpath="//input[@id='chksms1']") 
		public WebElement CommercialEscTempSMSCheckbox;
		
		@Name(Description="Mobile No Textbox")
		@FindBy(xpath="//input[@id='txtcellno1']") 
		public WebElement CommercialEscMobileTextbox;
		
		@Name(Description="Email Checkbox")
		@FindBy(xpath="//input[@id='chkemail1']") 
		public WebElement CommercialEscEmailCheckbox;
		
		@Name(Description="Email ID Textbox")
		@FindBy(xpath="//input[@id='txtemail1']") 
		public WebElement CommercialEscEmailIDTextbox;
		
		@Name(Description="Priority DropDown")
		@FindBy(xpath="//select[@id='ddlPriority-1']") 
		public WebElement CommercialEscPriorityDropDown;

		@Name(Description="Repeat Interval (min.) DropDown")
		@FindBy(xpath="//select[@id='ddlRepeatInterval1']") 
		public WebElement CommercialEscRepeatIntervalMinDropDown;

		@Name(Description="Escalation Update Button")
		@FindBy(id="btnUpdate")
		public WebElement CommercialEscEscUpdateButton;
		
		@Name(Description="Escalation Delete Button")
		@FindBy(name="btndelete")
		public WebElement CommercialEscDeleteButton;
		
		@Name(Description="Escalation Cancel Button")
		@FindBy(xpath="//a[@class='btn btn-primary']")
		public WebElement CommercialEscCancelButton;
		

	//Scheduler Details
		
		@Name(Description="WebElement to Scheduler Details page")
		@FindBy(xpath="//a[contains(text(),'Scheduler Details')]")
		public WebElement LaunchSchedulerDetails;
		
		@Name(Description="WebElement to Arming-Disarming Scheduler Details page")
		@FindBy(xpath="//a[contains(text(),'Scheduler Details')]")
		public WebElement LaunchArmDisarmSchedulerDetails;
		
		@Name(Description="	Commercial Temp DAY Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[2]/input[1]") 
		public WebElement CommercialTempDAYTextbox;
		
		@Name(Description="	Commercial Temp DAY Type Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[3]/input[1]") 
		public WebElement CommercialTempDAYTypeTextbox;
		
		@Name(Description="	Commercial Open time Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[3]/input[1]") 
		public WebElement CommercialTempOpenTimeTextbox;
		
		@Name(Description="	Commercial Early Open time Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[5]/input[1]") 
		public WebElement CommercialTempEarlyOpenTimeTextbox;
		
		@Name(Description="	Commercial Late Open time Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[6]/input[1]") 
		public WebElement CommercialTempLateOpenTimeTextbox;
		
		@Name(Description="	Commercial Close time Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[7]/input[1]") 
		public WebElement CommercialTempCloseTimeTextbox;
		
		@Name(Description="	Commercial Early Close time Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[8]/input[1]") 
		public WebElement CommercialTempEarlyCloseTimeTextbox;
		
		@Name(Description="	Commercial Late Close time Textbox")
		@FindBy(xpath="//tbody/tr[1]/td[9]/input[1]") 
		public WebElement CommercialTempLateCloseTimeTextbox;
		
		@Name(Description="	Commercial Schedular Update button")
		@FindBy(xpath="//input[@id='btnupdateSchedular']") 
		public WebElement UpdateSchedularButton;
		
		
	public MasterTemplate() {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
} 
