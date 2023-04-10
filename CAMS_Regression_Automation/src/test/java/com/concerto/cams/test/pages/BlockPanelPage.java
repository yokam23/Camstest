package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.concerto.annotations.Name;

public class BlockPanelPage {

	@Name(Description="WebElement to indicate to Block Panels page")
	@FindBy(xpath="//h2[contains(text(),'Block Panels')]")
	public WebElement LaunchBlockPanelPage;
	
	@Name(Description="Search Block Panels textbox")
	@FindBy(xpath="//input[@placeholder='Search by dealer']")
	public WebElement SearchBlockPanels;
	
	@Name(Description="Search Go Block Panels button")
	@FindBy(xpath="//button[contains(text(),'Go')]")
	public WebElement BlockPanelSearchGoButton;
	
	@Name(Description="Select all Block Panels checkbox")
	@FindBy(xpath="//input[@id='cbSelectAll']")
	public WebElement SelectAllPanelCheckBox;
	
	@Name(Description="Select Single Block Panels checkbox")
	@FindBy(xpath="//tbody/tr[1]/td[1]/input[1]")
	public WebElement SelectSinglePanelCheckBox;
	
	@Name(Description=" UnBlock Panels Button")
	@FindBy(xpath="//input[@id='btnUnblock']")
	public WebElement UnBlockPanelButton;
	
}

