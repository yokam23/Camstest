package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class SystemMaintainancePage {

	@Name(Description="WebElement to indicate to System Maintainance page")
	@FindBy(xpath="//h2[contains(text(),'System Maintainance')]")
	public WebElement LaunchSystemMaintainancePage;
	
	@Name(Description="Select Client Dropdown")
	@FindBy(xpath="//select[@id='clients']")
	public WebElement SelectClient;
	
	@Name(Description="Activate Client Button")
	@FindBy(xpath="//div[@class='panel-body']//a[@id='btnActivate']")
	public WebElement ActivateClientButton;
	
	@Name(Description="Deactivate Client  Button")
	@FindBy(xpath="//div[@class='panel-body']//a[@id='btnDeactivate']")
	public WebElement DeactivateClientButton;
	
	@Name(Description="Panel select to left box ")
	@FindBy(xpath="//div[@class='panel-body']//select[@id='SelectLeft']//option")
	public WebElement SelectLeft;
	
	@Name(Description="Panel select to Right box ")
	@FindBy(xpath="//div[@class='panel-body']//select[@id='SelectRight']")
	public WebElement SelectRight;
	
	@Name(Description="Panel Move to Right Button")
	@FindBy(xpath="//div[@class='panel-body']//input[@id='MoveRight']")
	public WebElement SelectRightButton;
	
	@Name(Description="Panel Move to Left Button")
	@FindBy(xpath="//div[@class='panel-body']//input[@id='MoveLeft']")
	public WebElement SelectLeftButton;
	
	//Dual authentication..................
	 
	@Name(Description="Login id for dual authentication")
	@FindBy(xpath="//div[@id='DivLogin2']//input[@id='LoginID']")
	public WebElement DualLoginIDText;
	
	@Name(Description="Password for dual authentication")
	@FindBy(xpath="//div[@id='DivLogin2']//input[@id='Password']")
	public WebElement DualPasswordText;
	
	@Name(Description="Comment for dual authentication")
	@FindBy(xpath="//div[@id='DivLogin2']//input[@id='Comments']")
	public WebElement DualCommentText;
	
	@Name(Description="Comment for dual authentication")
	@FindBy(xpath="//div[@id='DivLogin2']//select[@id='CircleList']")
	public WebElement DualSelectCircle;

	@Name(Description="Change Test Mode Ok button for dual authentication")
	@FindBy(xpath="//div[@class='modal-footer']//a[@id='btnChangeTestModeOk']//span")
	public WebElement DualOkButton;
	
	@Name(Description="Cancel button for dual authentication")
	@FindBy(xpath="//div[@id='DivLogin2']//div[@class='modal-footer']//span[contains(text(),'Cancel')]")
	public WebElement DualCancelButton;
	
	//Panel Mode radio Buttons......
	
	@Name(Description="Select Test mode radio button")
	@FindBy(xpath="//div[@class='panel-body']//div[@id='rbtnDiv']//input[@id='testmode1']")
	public WebElement TestRadioButton;
	
	@Name(Description="Select Quality mode radio button")
	@FindBy(xpath="//div[@class='panel-body']//div[@id='rbtnDiv']//input[@id='testmode2']")
	public WebElement QualitytRadioButton;

	@Name(Description="Select Live mode radio button")
	@FindBy(xpath="//div[@class='panel-body']//div[@id='rbtnDiv']//input[@id='testmode3']")
	public WebElement LivetRadioButton;
	
	@Name(Description="Select Service mode radio button")
	@FindBy(xpath="//div[@class='panel-body']//div[@id='rbtnDiv']//input[@id='testmode4']")
	public WebElement ServiceRadioButton;
	
	@Name(Description="Select Low Priority mode radio button")
	@FindBy(xpath="//div[@class='panel-body']//div[@id='rbtnDiv']//input[@id='testmode5']")
	public WebElement LowPRRadioButton;
	
	@Name(Description="Select Dismantle mode radio button")
	@FindBy(xpath="//div[@class='panel-body']//div[@id='rbtnDiv']//input[@id='testmode6']")
	public WebElement DismantleRadioButton;
	
	@Name(Description="Activate Panel Button")
	@FindBy(xpath="//div[@class='panel-body']//a[@id='btnActivatePanel']")
	public WebElement ActivatePanelButton;
	
	@Name(Description="Deactivate Panel Button")
	@FindBy(xpath="//div[@class='panel-body']//a[@id='btnDeactivatePanel']")
	public WebElement DeactivatePanelButton;
	
	@Name(Description="Show Sensor Button")
	@FindBy(xpath="//button[@id='btnshowsensors']")
	public WebElement ShowSensorButton;
	
	@Name(Description="Select Sensor Dropdown")
	@FindBy(xpath="//div[@class='panel-body']//select[@id='Zones']")
	public WebElement SelectSensorDD;
	
	@Name(Description="Sensor Bypass Button")
	@FindBy(xpath="//div[@class='panel-body']//a[@id='btnBypassSensor']")
	public WebElement BypassSensor;

	public SystemMaintainancePage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
