package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class CirclePage {

	@Name(Description="WebElement to indicate to Circel page")
	@FindBy(xpath="//h2[contains(text(),'Circle')]")
	public WebElement LaunchCirclePage;
	
	@Name(Description="Search Circle textbox")
	@FindBy(xpath="//input[@placeholder='Search by circle']")
	public WebElement SearchCircle;
	
	@Name(Description="Search Go Button")
	@FindBy(xpath="//button[@class='btn btn-default']")
	public WebElement GoButton;
	
	@Name(Description="Add Button")
	@FindBy(id="btnCreate")
	public WebElement AddButton;
	
	@Name(Description="Search option")
	@FindBy(xpath="//input[@placeholder='Search by circle']")
	public WebElement Searchoption;
	
	@Name(Description="Go button")
	@FindBy(xpath="//button[text()='Go']")
	public WebElement Gooption;
	
	// Add Circle Name.....
	

	@Name(Description="WebElement to indicate to add Circle Name page")
	@FindBy(xpath="//h3[@class='modal-title']")
	public WebElement LaunchCircleNamePage;
	
		
	
	@Name(Description="Close Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Close']")
	public WebElement CloseButton;
	
	//Edit Circle page.....
	//Click on edit button to each circle name...
	@Name(Description="Add Circle Name textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='CircleName']")
	public WebElement CircleNametext;
	
	@Name(Description="Add Circle Name Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnadd']")
	public WebElement AddCircleButton;

	@Name(Description="Display Success message For add Circle")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divSuccess']")
	public WebElement AddCircleSuccessMsg;

	
	@Name(Description="WebElement to indicate to Edit Circel Name page")
	@FindBy(xpath="//div[@class='modal-header']//h3[@class='modal-title']")
	public WebElement LaunchEditCirclePage;
	
	@Name(Description="Edit Circle Name textbox")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='CircleNameEdit']")
	public WebElement EditCircleNametext;

	@Name(Description="Update Circle Name Button")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Update']")
	public WebElement UpdateCircleButton;
	
	@Name(Description="Display Success message For Update Circle")
	@FindBy(xpath="//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement UpdateCircleSuccessMsg;
	
	
	//View panel page
	
	@Name(Description="WebElement to indicate to view panel page")
	@FindBy(xpath="//h2[contains(text(),'View Panel')]")
	public WebElement LaunchViewPanelPage;
	
	@Name(Description="Move to Circle Dropdown box")
	@FindBy(id="ddlCircleMoc")
	public WebElement MoveToCircle;
	
	@Name(Description="Switch Circle Button")
	@FindBy(xpath="//div[@class='form-inline']//input[@name='Command']")
	public WebElement SwitchCircleButton;
	
	@Name(Description="Search Circle Textbox")
	@FindBy(xpath="//input[@placeholder='Search by']")
	public WebElement SearchCircleView;
	
	@Name(Description="Search Circle Button")
	@FindBy(xpath="//button[@name='Command']")
	public WebElement SearchCircleButton;
	
	@Name(Description=" Circle List Button")
	@FindBy(xpath="//a[text()='Circle List']")
	public WebElement CircleListButton;
	
	@Name(Description="Add New Panel In Circle")
	@FindBy(name="Command")
	public WebElement AddNewPanel;
	
	@Name(Description="Add all panel Check box In Circle")
	@FindBy(id="cbSelectAll")
	public WebElement SelectAllPanelCheckBox;
	
	
	@Name(Description="Allocate Circle Button")
	@FindBy(xpath="//input[@name='Command']")
	public WebElement AllocateCircle;
	
	@Name(Description="Search by")
	@FindBy(xpath="//input[@placeholder='Search by']")
    public WebElement Searchby;
	
	@Name(Description="Go button")
	@FindBy(xpath="//button[@value='Search']")
    public WebElement SearchGo;
	
	@Name(Description = "Allocate panel to circle")
	@FindBy(xpath="//a[@Name='AddPanel']")
	public WebElement Allocatepanels;
	
    @Name(Description="Panels allocated to Circle successfully message")
    @FindBy(xpath="//div[@id='divSuccess']")
    public WebElement SuccessMsgAllocate;
    
    @Name(Description="Panel removed successfully ")
    @FindBy(xpath="//div[@id='divSuccess']")
    public WebElement SuccessMsgDeallocate;
                          

	@Name(Description="Deallocate Circle Button")
	@FindBy(xpath="//div[@class='col-xs-12 col-md-4']//input[1]")
	public WebElement DeallocateCircle;
	
	// For delete select each circle....
	@Name(Description="Delete Circle")
	@FindBy(xpath="(//a[@name='Delete'])[1]")
	public WebElement DeleteCircle;
	
	@Name(Description="View allocated panel")
	@FindBy(xpath="(//a[@name='ViewPanel'])[1]")
	public WebElement ViewAllocatePanel;
	
	@Name(Description="Edit btn")
	@FindBy(xpath="(//a[@name='Edit'])[1]")
	public WebElement EditBtn;

	public CirclePage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
