package com.concerto.cams.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concerto.annotations.Name;
import com.concerto.common.utilities.DriverManager;

public class PanelStatusPage {


	@Name(Description="WebElement to indicate to Panel Status Page")
	@FindBy(xpath="//h2[contains(text(),'AD on Request')]")
	public WebElement LaunchADonRequestPage;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PanelStatusPage()  {		
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
}
