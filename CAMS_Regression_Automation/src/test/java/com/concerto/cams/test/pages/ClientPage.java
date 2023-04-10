package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class ClientPage {
	
	@Name(Description="WebElement to Client page")
	@FindBy(xpath="//h2[contains(text(),'Client')]")
	public WebElement LaunchClientPage;
	
	@Name(Description="Search Client name Textbox")
	@FindBy(xpath="//input[@placeholder='Search by Client Name']")
	public WebElement SearchClient;
	
	@Name(Description="Go Button")
	@FindBy(xpath ="//button[@class='btn btn-default']") 
	public WebElement GoButton;

	/* @Name(Description="Go Button")
	@FindBy(xpath ="//button[@class='btn btn-default']") 
	public WebElement GoButtn;*/
	
	@Name(Description="ADD Button")
	@FindBy(id="btnCreate")
	public WebElement AddButton;
	
	@Name(Description="WebElement to indicate AddClient page is loaded")
	@FindBy(xpath="//h2[contains(text(),'Add')]")
	public WebElement LaunchAdd;
	
	@Name(Description="Add Client Textbox")
	@FindBy(xpath="//input[@id='txtClientName']")
	public WebElement AddClient;
	
	@Name(Description="Add client category Dropdown")
	@FindBy(xpath="//select[@id='CategoryID']")
	public WebElement AddClientCategory;

	@Name(Description="Add Client Address Textbox")
	@FindBy(xpath="//input[@id='txtClientAddress']")
	public WebElement AddClientAddress;
	
	@Name(Description="Add State Name Dropdown")
	@FindBy(xpath="//select[@id='State']")
	public WebElement AddStateName;
	
	@Name(Description="Add City Name Dropdown")
	@FindBy(xpath="//select[@id='City']")
	public WebElement AddCityName;
	
	@Name(Description="Add Pincode no Textbox")
	@FindBy(xpath="//input[@id='txtPinCode']")
	public WebElement AddPincodeNo;
	
	@Name(Description = "Add client circle")
	@FindBy(xpath="(//a[@name='ClientCircle'])[1]")
	public WebElement AddCircle;
	
	@Name(Description = "Client circle header")
	@FindBy(xpath="//h3[@class='modal-title']")
	public WebElement ClientCircleHeader;
	
	@Name(Description="Add Circle Name textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='CircleName']")
	public WebElement CircleNametext;
	
	@Name(Description="Add Circle Name Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnadd']")
	public WebElement AddCircleButton;

	@Name(Description="Display Success message For add Circle")
	@FindBy(xpath="//div[@class='modal-body']//div[@id='divSuccess']")
	public WebElement AddCircleSuccessMsg;

	
	@Name(Description="CircleName")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='txtClientCircleName']")
	public WebElement CircleName;

	@Name(Description = "Add client circle name")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnaddClientCircleName']")
	public WebElement AddName;
	
	@Name(Description = "Success message of add circle")
	@FindBy(xpath="//div[@class='modal-body']//div[@id='divSuccess']")
	public WebElement Addcirclemsg;
	
	
	@Name(Description="Add phone no1 Textbox")
	@FindBy(xpath="//input[@id='txtClientPhone1']")
	public WebElement AddPhoneNo1;
	
	@Name(Description="Add phone no2 Textbox")
	@FindBy(xpath="//input[@id='txtClientPhone2']")
	public WebElement AddPhoneNo2;
	
	@Name(Description="Add Version no Textbox")
	@FindBy(id="txtversionNo")
	public WebElement AddVersionNo;

	@Name(Description="Add ContactPerson Textbox")
	@FindBy(xpath="//input[@id='txtContactPerson']")
	public WebElement AddContactPerson;
	
	@Name(Description="Add Designation Textbox")
	@FindBy(xpath="//input[@id='txtDesignation']")
	public WebElement AddDesignation;
	
	@Name(Description="Add Mobile No Textbox")
	@FindBy(xpath="//input[@id='txtDesignation']")
	public WebElement AddMobileNo;

	@Name(Description="Add Email ID Textbox")
	@FindBy(xpath="//input[@id='txtClient_Email']")
	public WebElement AddEmailID;
	
	@Name(Description="Add SLA in min DropDown")
	@FindBy(xpath="//select[@id='MaxActionDuration']")
	public WebElement AddSLAInMin;
	
	@Name(Description="Add Subscription name Dropdown")
	@FindBy(xpath="//select[@id='ddlSubName']")
	public WebElement AddSubName;
	
	@Name(Description="ADD Client Button")
	@FindBy(xpath="//input[@id='btnaddClient']")
	public WebElement AddClientButton;
	
	@Name(Description="Display Success message for add Client ")
	@FindBy(id="divSuccess2")
	public WebElement ClientSuccessMsg;
		
	
	@Name(Description="Close Button")
	@FindBy(xpath ="//input[@value='Close']") 
	public WebElement CloseButton;
	
	@Name(Description = "Client circle")
	@FindBy(xpath="//a[@name='ClientCircle']")
	public WebElement ClientCircle;
	
	@Name(Description="Edit Button")
	@FindBy(xpath="(//a[@name='Edit'])[1]")
	public WebElement EditButton;
	
	@Name(Description="WebElement to indicate EditClient page is loaded")
	@FindBy(xpath="//h2[contains(text(),'Edit')]")
	public WebElement LaunchEdit;
	
	@Name(Description="Edit Client name Textbox")
	@FindBy(id="txtClientName")
	public WebElement EditClient;
	
	@Name(Description="Edit Version no Textbox")
	@FindBy(id="txtversionNo")
	public WebElement EditVersionNo;

	@Name(Description="Edit Client Address Textbox")
	@FindBy(name="Client_Address")
	public WebElement EditClientAddress;
	
	@Name(Description="Edit State Name Dropdown")
	@FindBy(name="StateName")
	public WebElement EditStateName;
	
	@Name(Description="Edit City Name Dropdown")
	@FindBy(name="CityName")
	public WebElement EditCityName;
	
	@Name(Description="Edit Pincode no Textbox")
	@FindBy(id="txtPinCode")
	public WebElement EditPincodeNo;
	
	@Name(Description="Edit SubName Dropdown")
	@FindBy(xpath="//select[@id='ddlSubName']")
	public WebElement EditSubName;
	
	@Name(Description="Update Button")
	@FindBy(id="btnUpdate")
	public WebElement UpdateButton;
	
	@Name(Description="Display Success message")
	@FindBy(xpath="//div[@id='divSuccessUpdatenotice']")
	public WebElement UpdateSuccessMsg;
	
	@Name(Description="Close Button for edit client")
	@FindBy(xpath="//input[@class='btn btn-warning']")
	public WebElement EditCloseButton;

	@Name(Description="Delete Button")
	@FindBy(name="Delete")
	public WebElement DeleteButton;
	
	public ClientPage() {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}





