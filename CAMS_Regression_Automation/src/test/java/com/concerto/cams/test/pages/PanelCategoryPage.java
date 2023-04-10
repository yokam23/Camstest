package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class PanelCategoryPage {
	
	@Name(Description="WebElement to indicate to Panel Category page")
	@FindBy(xpath="//h2[contains(text(),'Panel Category')]")
	public WebElement LaunchPanelCategoryPage;
	
	//For Select panel Category radio button
	
	@Name(Description="Select panel Category radio button")
	@FindBy(xpath="//label[contains(text(),'Panel Category *')]")
	public WebElement SelectPanlCategory;
	
	@Name(Description="General panel Category radio button")
	@FindBy(id="rbtPanel1")
	public WebElement GeneralRButton;
	
	@Name(Description="VIP panel Category radio button")
	@FindBy(id="rbtPanel2")
	public WebElement VIPRButton;
	
	@Name(Description="VVIP panel Category radio button")
	@FindBy(id="rbtPanel3")
	public WebElement VVIPRButton;
	
	@Name(Description="Assign all panel checkbox")
	@FindBy(id="cbSelectAll")
	public WebElement AssignAllCheckbox;
	
	@Name(Description="Assign panel checkbox")
	@FindBy(id="assignChkBx")
	public WebElement AssignCheckbox;
	
	@Name(Description="Search Panel id Textbox")
	@FindBy(xpath="//body/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/input[1]")
	public WebElement SearchPanelID;
		
	@Name(Description="Go Button")
	@FindBy(id ="btnSearch") 
	public WebElement GoButton;
	
	//For Select Panel Category To Change radio button
	
	@Name(Description="Select Panel Category To Change radio button")
	@FindBy(xpath="//label[contains(text(),'Select Panel Category To Change *')]")
	public WebElement SelectPanlCategoryToChange;
	
	@Name(Description="General panel Category radio button")
	@FindBy(id="rbtchangeCat1")
	public WebElement GeneralRButtonChg;
	
	@Name(Description="VIP panel Category radio button")
	@FindBy(id="rbtchangeCat2")
	public WebElement VIPRButtonChg;
	
	@Name(Description="VVIP panel Category radio button")
	@FindBy(id="rbtchangeCat3")
	public WebElement VVIPRButtonChg;

	@Name(Description="CHange panel category button")
	@FindBy(id="btnchangeCat1")
	public WebElement ChangePanelCatBtn;
	
	
	public PanelCategoryPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
	
	
}
