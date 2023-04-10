package com.concerto.common.utilities;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.concerto.annotations.implementations.LocatorExtractor;
import com.concerto.common.exceptions.CannotFindElementOnPageException;
import com.concerto.common.exceptions.HTMLElementExpiredException;
import com.concerto.common.exceptions.InvalidHTMLElementStateException;
import com.concerto.common.exceptions.InvalidWebLocatorException;
import com.concerto.common.exceptions.UnableToInteractWithElementException;
import com.concerto.common.exceptions.UnableToSelectHtmlLocator;

public class Selenium {
	
	
	public static void click(WebElement element) throws Throwable {
		try {
			element.click();
		} catch(ElementClickInterceptedException E1) {
			element.sendKeys(Keys.RETURN);
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
	}
	
    public static void sendKeys(WebElement element,String Text) throws Throwable {
		try {
			element.sendKeys(Text);
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}		
	}
    
    public static void sendKeysActions(WebElement element,Keys keys) throws Throwable {
 		try {
 			element.sendKeys(keys);
 		} catch(ElementNotInteractableException E1) {
 			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
 		} catch(ElementNotSelectableException E1) {
 			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
 		} catch(InvalidElementStateException E1) {
 			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
 		} catch(InvalidSelectorException E1) {
 			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
 		}  catch(NoSuchElementException E1) {
 			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
 		}  catch(StaleElementReferenceException E1) {
 			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
 		}		
 	}
    
    public static void clear(WebElement element) throws Throwable {
		try {
			element.clear();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}    	
    }
    
    public static void select(WebElement element) throws ReflectiveOperationException {
		try {
			element.click();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}    	
    }
    
    public static void submit(WebElement element) throws Throwable {
		try {
			element.submit();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
    }
    
    public static String getTagName(WebElement element) throws Throwable {
		try {
		return	element.getTagName();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
    }
    
    public static String getAttribute(WebElement element,String Attribute) throws Throwable {
		try {
			return element.getAttribute(Attribute);
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
    }
    
    public static String getText(WebElement element) throws Throwable {
		try {
		return	element.getText();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
    }
    
    public static Point getLocation(WebElement element) throws Throwable {
		try {
		return	element.getLocation();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
    }
    
    public static Dimension getSize(WebElement element) throws Throwable {
		try {
		return	element.getSize();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}    	
    }
    
    public static Rectangle getRect(WebElement element) throws Throwable {
		try {
		return	element.getRect();
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}    	
    }
    
    public static String getCssValue(WebElement element,String attribute) throws Throwable {
		try {
		return	element.getCssValue(attribute);
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
    }
    
    public static boolean isSelected(WebElement element) throws Throwable {
		try {
			boolean status = element.isSelected();
			return status;
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
		
    }
    
    public static boolean isEnabled(WebElement element) throws Throwable {
		try {
			boolean status = element.isEnabled();
			return status;
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}		
    }
    
    public static boolean isDisplayed(WebElement element) throws Throwable {    	
		try {
			boolean status = element.isDisplayed();
			return status;
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select HTM Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale For HTML Locator " + LocatorExtractor.ExtractBy(element)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}		
    }

}
