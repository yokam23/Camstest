package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class DealersPage {

	@Name(Description="WebElement to indicate to Dealers page")
	@FindBy(xpath="//h2[contains(text(),'Dealer')]")
	public WebElement LaunchDealersPage;
	
	@Name(Description="Search Dealer textbox")
	@FindBy(xpath="//input[@placeholder='Search by dealer']")
	public WebElement SearchDealer;
	
	@Name(Description="Search Go Button")
	@FindBy(xpath="//button[@class='btn btn-default']")
	public WebElement GoButton;
	
	@Name(Description="Add Button")
	@FindBy(xpath="//a[@id='btnCreate']")
	public WebElement AddButton;
	
	
	//Add dealer details.
	
	@Name(Description="Add Dealer Name textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerName']")
	public WebElement AddDealerNameText;
	
	@Name(Description="Add Dealer Address textbox")
	@FindBy(xpath="//div[@class='modal-body']//textarea[@id='DealerAddress']")
	public WebElement AddDealerAddressText;
	
	@Name(Description="Add State Dropdown")
	@FindBy(xpath="//div[@class='modal-body']//select[@id='State']")
	public WebElement AddstateDD;
	
	@Name(Description="Add City Dropdown")
	@FindBy(xpath="//div[@class='modal-body']//select[@id='City']")
	public WebElement AddCityDD;
	
	@Name(Description="Add pincode Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='Pincode']")
	public WebElement AddPincode;
	
	@Name(Description="Add Contact person Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='ContactPerson']")
	public WebElement AddContactPerson;
	
	@Name(Description="Add phone no Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerPhone']")
	public WebElement AddPhoneNo;
	
	@Name(Description="Add Mobile no Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerMobile']")
	public WebElement AddMobileNo;
	
	@Name(Description="Add EmailID Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerEmail']")
	public WebElement AddEmailID;
	
	@Name(Description="Add Dealer Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnadd']")
	public WebElement AddDealerButton;
	
	@Name(Description="Close Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@class='btn btn-warning']")
	public WebElement CloseButton;
	
	@Name(Description="Display Success message")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement SuccessMsg;
		
	//Edit Dealer details.
	
	@Name(Description="Edit Dealer Button")
	@FindBy(xpath="(//a[@name='Edit'])[1]")
	public WebElement EditDealerButton;
	
	@Name(Description="Edit Dealer Name textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerName']")
	public WebElement EditDealerNameText;
	
	@Name(Description="Edit Dealer Address textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerAddress']")
	public WebElement EditDealerAddressText;
	
	@Name(Description="Edit State Dropdown")
	@FindBy(xpath="//div[@class='modal-body']//select[@id='State']")
	public WebElement EditStateDD;
	
	@Name(Description="Edit City Dropdown")
	@FindBy(xpath="//div[@class='modal-body']//select[@id='City']")
	public WebElement EditCityDD;
	
	@Name(Description="Edit pincode Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='Pincode']")
	public WebElement EditPincode;
	
	@Name(Description="Edit Contact person Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='ContactPerson']")
	public WebElement EditContactPerson;
	
	@Name(Description="Edit phone no Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerPhone']")
	public WebElement EditPhoneNo;
	
	@Name(Description="Edit Mobile no Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerMobile']")
	public WebElement EditMobileNo;
	
	@Name(Description="Edit EmailID Textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='DealerEmail']")
	public WebElement EditEmailID;
	
	@Name(Description="Update Dealer Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Update']")
	public WebElement UpdateDealerButton;
	
	@Name(Description="Display Success message")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement UpdateSuccessMsg;
	
	@Name(Description="Close Dealer Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Close']")
	public WebElement CloseEditDealerBtn;
	
	// Allocate and deallocate button
	
	@Name(Description="Allocate panel button")
	@FindBy(xpath="//a[@name='AllocatePanel']")
	public WebElement AllocateButton;
	
	@Name(Description="Deallocate panel button")
	@FindBy(xpath="//a[@name='DeallocatePanel']")
	public WebElement DeallocateButton;
	
	@Name(Description="Delete Dealer button")
	@FindBy(xpath="//tbody/tr[1]/td[13]/a[1]")
	public WebElement DeleteDealer;	
	
	//Allocate panel page........ 
	
	@Name(Description="Indicate dealers page for allocate panel")
	@FindBy(xpath="//h2[contains(text(),'Dealer : testDealer')]")
	public WebElement DealerAllocatepage;
	
	@Name(Description="Allocate all panels Checkbox")
	@FindBy(id="cbSelectAll")
	public WebElement AllocateAllCheckbox;
	
	@Name(Description="Allocate  panels Button")
	@FindBy(id="allocate")
	public WebElement AllocatePanelsButton;
	
	@Name(Description="Dealer List button")
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement DealerListButton;
	
	//panel select by check box is remaining
	
	
	//Allocate panel page........ 
	
	@Name(Description="Indicate dealers page for allocate panel")
	@FindBy(xpath="//h2[contains(text(),'Dealer : testDealer')]Deallocate")
	public WebElement DealerDeallocatepage;
	
	@Name(Description="Deallocate all panels Checkbox")
	@FindBy(id="cbSelectAll")
	public WebElement DeallocateAllCheckbox;
	
	@Name(Description="Deallocate  panels Button")
	@FindBy(id="deallocate")
	public WebElement DeallocatePanelsButton;
	
	@Name(Description="Dealer List button")
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement DealerListButton1;
	
	//panel select by check box is remaining
	
	public DealersPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
