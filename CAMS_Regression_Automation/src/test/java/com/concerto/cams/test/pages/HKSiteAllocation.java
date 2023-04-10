package com.concerto.cams.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class HKSiteAllocation {

	@Name(Description = "Page Header")
	@FindBy(xpath = "//div[@class='col-md-7']//h2[text()='Site Allocation']")
	public WebElement HKSiteAllocation_pageHeader;

	@Name(Description = "Close Message")
	@FindBy(xpath = "//a[contains(text(),'×')]")
	public WebElement Closesign;

	@Name(Description = "Search text")
	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement Search_option;

	@Name(Description = "Search sites on allocate page")
	@FindBy(xpath = "//input[@placeholder='Search by']")
	public WebElement SearchBy;

	@Name(Description = "Search button on allocate page")
	@FindBy(xpath = "//button[@value='Search']")
	public WebElement SearchOption;

	@Name(Description = "Allocate button")
	@FindBy(xpath = "//input[@value='Allocate']")
	public WebElement AllocateBtn;

	@Name(Description = "Pool list button")
	@FindBy(xpath = "//a[text()='Pool List']")
	public WebElement Poollistbtn;

	@Name(Description = "Panelid text")
	@FindBy(xpath = "(//div[@class='table-responsive']//table//tbody//tr//td[5])[1]")
	public WebElement Panelid_txt;

	@Name(Description = "Panelid text")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr//td[5]")
	public List<WebElement> Panelid_List;

	@Name(Description = "camera no field")
	@FindBy(xpath = "//div[@class='table-responsive']//table//tbody//tr//td//select[@id='PanelList_")
	public WebElement BeforeCameraNoField;

	@Name(Description = "Camera no field")
	@FindBy(xpath = "__Camera']")
	public WebElement AfterCameraField;

	@Name(Description = "Records count")
	@FindBy(xpath = "//div[@class='pull-right']")
	public WebElement RecordCount;

	@Name(Description = "CheckAll")
	@FindBy(xpath = "//input[@id='cbSelectAll']")
	public WebElement checkall;

	@Name(Description = "Allocate page header")
	@FindBy(xpath = "//h2[text()='Allocate sites ']")
	public WebElement Allocate_PageHeader;

	@Name(Description = "View sites page header")
	@FindBy(xpath = "//h2[text()='View allocated sites']")
	public WebElement ViewSite_PageHeader;

	@Name(Description = "Pool name")
	@FindBy(xpath = "//label[@id='lbl1']")
	public WebElement PoolName;

	@Name(Description = "Deallocate button")
	@FindBy(xpath = "//input[@value='Deallocate']")
	public WebElement DeallocateBtn;

	@Name(Description = "UpdateCamera button")
	@FindBy(xpath = "//input[@value='Update Camera']")
	public WebElement UpdateCameraBtn;

	@Name(Description = "Search Go option")
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Go_option;

	@Name(Description = "View panels")
	@FindBy(xpath = "(//a[@name='ViewPanel'])[1]")
	public WebElement ViewPanel;

	@Name(Description = "Allocate panels")
	@FindBy(xpath = "(//a[@name='AllocatePanel'])[1]")
	public WebElement AllocatePanel;

	@Name(Description = "Switch pool Drop down")
	@FindBy(xpath = "//select[@name='UpdatedPoolID']")
	public WebElement SelectSwitchPool;

	@Name(Description = "Switch pool button")
	@FindBy(xpath = "//input[@id='btnSwitchPool']")
	public WebElement Switchpoolbtn;

	@Name(Description = "Allocate site message")
	@FindBy(xpath = "//strong[contains(text(),'Site(s) allocated to pool successfully')]")
	public WebElement AllocateSitemsg;

	@Name(Description = "Camera update message")
	@FindBy(xpath = "//strong[contains(text(),'Camera no updated for site(s) successfully')]")
	public WebElement CameraUpdatemsg;

	@Name(Description = "Deallocate site message")
	@FindBy(xpath = "//strong[contains(text(),'Site(s) deallocated sucessfully')]")
	public WebElement Deallocatesitemsg;

	@Name(Description = "Deallocate site popup title")
	@FindBy(xpath = "//h3[@class='modal-title']")
	public WebElement DeallocatesitePopupTitle;

	@Name(Description = "Deallocate site popup alert message")
	@FindBy(xpath = "(//div[@class='modal-body']//label)[1]")
	public WebElement DeallocateAlertMsg;

	@Name(Description = "Deallocate alert message Yes option")
	@FindBy(xpath = "(//div[@class='modal-body']//input[@id='btnDelete'])[1]")
	public WebElement DellocateYesOption;

	@Name(Description = "Deallocate alert message No option")
	@FindBy(xpath = "(//div[@class='modal-body']//input[@value='No'])[1]")
	public WebElement DellocateNoOption;

	@Name(Description = "Switch site popup title")
	@FindBy(xpath = "//h3[@class='modal-title']")
	public WebElement SwitchsitePopupTitle;

	@Name(Description = "Switch site popup alert message")
	@FindBy(xpath = "//div[@class='modal-body']//label")
	public WebElement SwitchAlertMsg;

	@Name(Description = "Switch site message")
	@FindBy(xpath = "//strong[contains(text(),'site(s) has been switch successfully')]")
	public WebElement SwitchSiteMsg;

	@Name(Description = "GetValidationAllocateSite")
	@FindBy(xpath = "//strong[contains(text(),'Please select atleast one site for allocation')]")
	public WebElement GetValidationAllocateSite;

	@Name(Description = "GetValidationDeAllocateSite")
	@FindBy(xpath = "//strong[contains(text(),'Please select at least one site to deallocate')]")
	public WebElement GetValidationDeAllocateSite;

	@Name(Description = "GetValidationupdatecamera")
	@FindBy(xpath = "//strong[contains(text(),'Please select at least one site to update camera')]")
	public WebElement GetValidationUpdateCamera;

	@Name(Description = "GetValidationswitchSite")
	@FindBy(xpath = "//strong[contains(text(),'Please select pool to switch to another pool')]")
	public WebElement GetValidationSwitchpool;

	public HKSiteAllocation() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

}
