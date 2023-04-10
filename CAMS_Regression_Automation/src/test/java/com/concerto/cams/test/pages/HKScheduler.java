package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class HKScheduler {
	
	@Name(Description="HK Scheduler page Header")
	@FindBy(xpath="//h2[text()='Scheduler']")
	public WebElement SchedulerHeader;
	
	@Name(Description="Add Scheduler header")
	@FindBy(xpath="//div[@class='modal-header']//h3[@class='modal-title']")
	public WebElement AddschedulerHeader;
	
	@Name(Description="Search text")
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement Search_option;
	
	@Name(Description="Search Go option")
	@FindBy(xpath="//button[text()='Go']")
	public WebElement Go_option;
	
	@Name(Description="Records count")
	@FindBy(xpath="//div[@class='pull-right']")
	public WebElement RecordCount;
	
	@Name(Description="ClientName")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr[1]//td[1]")
	public WebElement ClientName;
	
	@Name(Description="PoolName")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr[1]//td[2]")
	public WebElement PoolName;
	
	@Name(Description="Schedulers")
	@FindBy(xpath="(//a[@name='Schedulers'])[1]")
	public WebElement AddScheduler;
	
	@Name(Description="SchedulerAddbtn")
	@FindBy(xpath="//a[@id='btnCreate']")
	public WebElement SchedulerAddbtn;
	
	@Name(Description="Pool list button")
	@FindBy(xpath="//a[contains(text(),'Pool List')]")
	public WebElement PoolListBtn;
	
	
	@Name(Description="PoolName on scheduler page")
	@FindBy(xpath="//div[@class='modal-body']//div[@class='col-sm-6']")
	public WebElement SchedulerPoolName;
	
	@Name(Description="Scheduler From time")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='FromTime']")
	public WebElement FromTime;
	
	@Name(Description="Scheduler To time")
	@FindBy(xpath="//div[@class='modal-body']//input[@id='ToTime']")
	public WebElement ToTime;
	
	@Name(Description="Add new Scheduler")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnadd']")
	public WebElement AddNewScheduler;
	
	@Name(Description="Close Scheduler")
	@FindBy(xpath="//div[@class='modal-footer']//input[@value='Close']")
	public WebElement ClosebtnScheduler;
	
	@Name(Description="Edit btn")
	@FindBy(xpath="(//a[@Name='Edit'])[1]")
	public WebElement Editbtn;
	
	@Name(Description="Delete btn")
	@FindBy(xpath="(//a[@Name='Delete'])[1]")
	public WebElement Deletebtn;
	
	@Name(Description="Edit scheduler page header")
	@FindBy(xpath="//h3[@class='modal-title']")
	public WebElement EditSchedulerPageHeader;
	
	@Name(Description="Edit scheduler btn")
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='btnedit']")
	public WebElement Updatebtn;
	
	@Name(Description="Update scheduler message")
	@FindBy(xpath="//strong[contains(text(),'Schedule updated successfully')]")
	public WebElement UpdateSchedulerMessage;
	
	@Name(Description="Add scheduler message")
	@FindBy(xpath="//strong[contains(text(),'Schedule added successfully')]")
	public WebElement AddSchedulerMessage;
	
	@Name(Description="From time text")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr//td[1]")
	public WebElement FromTimeTxt;
	
	@Name(Description="To time text")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr//td[2]")
	public WebElement ToTimeTxt;
	
	@Name(Description="Delete validation message")
	@FindBy(xpath="//strong[contains(text(),'Can not delete schedule as monitoring data present')]")
	public WebElement DeleteValidationMsg;
	
	//Validation message is difference between from and to is greater than 1 hour
	@Name(Description="Scheduler Validation1")
	@FindBy(xpath="//div[@class='modal-body']//span[@id='errorIsValidToTime']")
	public WebElement SchedulerValidation1;
	
	//Validation message if both fields are blank  
	@Name(Description="Scheduler Validation2")
	@FindBy(xpath="//div[@class='modal-body']//span[@id='errorIsValidToTime']")
	public WebElement SchedulerValidation2;
	
	//Validation message if one field is blank
	@Name(Description="Scheduler Validation3")
	@FindBy(xpath="//div[@class='modal-body']//span[@id='errorIsValidToTime']")
	public WebElement SchedulerValidation3;
	
	//Validation message if scheduler is conflicts
	@Name(Description="Scheduler validation4")
	@FindBy(xpath = "//div[@class='modal-footer']//div[@id='divinvalid']")
	public WebElement ConflictValidation;
	
	@Name(Description="DeleteSchedulerMessage")
	@FindBy(xpath="//strong[contains(text(),'Schedule Deleted successfully')]")
    public WebElement DeleteSchedulerMessage;	
	
	
	public HKScheduler() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}


}

