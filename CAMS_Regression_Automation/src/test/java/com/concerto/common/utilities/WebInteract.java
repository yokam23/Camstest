package com.concerto.common.utilities;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.concerto.annotations.implementations.LocatorExtractor;
import com.concerto.common.contsants.Config;
import com.concerto.common.exceptions.CannotFindElementOnPageException;
import com.concerto.common.exceptions.HTMLElementExpiredException;
import com.concerto.common.exceptions.InvalidHTMLElementStateException;
import com.concerto.common.exceptions.InvalidWebLocatorException;
import com.concerto.common.exceptions.UnableToInteractWithElementException;
import com.concerto.common.exceptions.UnableToSelectHtmlLocator;
import com.concerto.common.exceptions.UnknownException;
import com.concerto.common.exceptions.WaitingFailedForElementLoad;



public class WebInteract {
	
	   /**
	    * Method to Wait for Page to load
	    * @param driver
	    */
		public static void waitForPageLoad(WebDriver driver) 
		{
			 ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
		     {
				 public Boolean apply(WebDriver driver) 
				 {
					 return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		          }
		      };
		        
		      WebDriverWait wait = new WebDriverWait(driver, 30);
		      wait.until(pageLoadCondition);
		 }
		
		/**
		 * Method to get fluint wait
		 * @param driver
		 * @return
		 */
		private static FluentWait<WebDriver> getFluentWait() {
			return new FluentWait<WebDriver>(DriverManager.getWebDriver())
					.withTimeout(Duration.ofSeconds(Config.PAGE_LOADWAI_TTIME))
					.pollingEvery(Duration.ofMillis(Config.POLLING_TIME));
		}
		
		/**
		 * Method to move to element
		 * @param driver
		 * @param webElement
		 * @throws Throwable 
		 */
		public static void moveToElement(WebElement webElement) throws Throwable {
			try {
			((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
		}
		
		/**
		 * Select by Value From DropDown
		 * @param webElement
		 * @param value
		 * @throws Throwable 
		 */
		public static void selectByValueFomDropdown(WebElement webElement,String value) throws Throwable {
			try {
			new Select(webElement).selectByValue(value);
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
		}
		
		/**
		 * Select by Text From DropDown
		 * @param webElement
		 * @param text
		 * @throws Throwable 
		 */
		public static void selectByTextFomDropdown(WebElement webElement,String text) throws Throwable {
			try {
			new Select(webElement).selectByVisibleText(text);
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
		}
		
		/**
		 * 
		 * @param webElement
		 * @param text
		 * @throws Throwable
		 */
		public static void selectByTextFomDropdownfromStale(WebElement webElement,String text) throws Throwable {
			try {
			new Select(webElement).selectByVisibleText(text);
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
//				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
				for (int i=0;i<10;i++) {
					try {
					new Select(webElement).selectByVisibleText(text);
					}catch (StaleElementReferenceException E2) {
						continue;
					}
				}
			}
		}
		
		public static void multiselectByTextFomDropdownfromStale(WebElement webElement,String text) throws Throwable {
			try {
				Select Select = new Select(webElement);
				String[] options= text.split(",");
				for (int i=0;i< options.length;i++) {
					System.out.println(i+"th Multi Option is :"+options[i]);
					Select.selectByVisibleText(options[i]);
				}
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
//				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
				for (int i=0;i<10;i++) {
					try {
						Select Select = new Select(webElement);
						String[] options= text.split(",");
						for (int j=0;j< options.length;j++) {					
							Select.selectByVisibleText(options[j]);
						}
					}catch (StaleElementReferenceException E2) {
						continue;
					}
				}
			}
		}
		
		public static void selectByValueFomDropdownfromStale(WebElement webElement,String text) throws Throwable {
			try {
			new Select(webElement).selectByValue(text);
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
//				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
				for (int i=0;i<10;i++) {
					try {
						new Select(webElement).selectByValue(text);
					}catch (StaleElementReferenceException E2) {
						continue;
					}
				}
			}
		}
		/**
		 * 
		 * @param webElement
		 * @param text
		 * @throws Throwable
		 */
		public static void selectByJSTextFomDropdownfromStale(WebElement webElement,String text) throws Throwable {
			try {
			new Select(webElement).selectByValue(text);
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
//				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
				for (int i=0;i<10;i++) {
					try {
						((JavascriptExecutor)DriverManager.getWebDriver()).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", webElement, text);
					}catch (StaleElementReferenceException E2) {
						continue;
					}
				}
			}
		}



		/**
		 * Method to move to element
		 * @param driver
		 * @param webElement
		 * @throws Throwable 
		 */
		public static void moveToElementAndClick(WebElement webElement) throws Throwable {
			try {
			((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
			webElement.click();
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
		}
		
		/**
		 * Method to click on object
		 * @param driver
		 * @param webElement
		 * @throws Throwable 
		 */
		public static void clickWhenReady(WebElement webElement) throws Throwable {
			try {
				((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
				getFluentWait().until(ExpectedConditions.elementToBeClickable(webElement)).click();
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
		}

		/**
		 * Method to get no stale element and click
		 * @param driver
		 * @param webElement
		 * @return 
		 * @throws Throwable 
		 */
		public static void getNonstaleElementAndClick(WebElement webElement) throws Throwable {
			try {
				((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
				getFluentWait().until(ExpectedConditions.elementToBeClickable(webElement)).click();

			} catch (StaleElementReferenceException e) {
				for (int i = 0; i <= 10; ++i) {
					try {
						getFluentWait()
						.until(ExpectedConditions.elementToBeClickable(webElement))
						.click();
								
						break;
					} catch (StaleElementReferenceException e1) {
						continue;
					}	
				}
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  
			
		} 
		
		public static void getNonstaleElementAndSendKeys(WebElement webElement,String Input) throws Throwable {
			try {
				((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
				getFluentWait().until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(Input);

			} catch (StaleElementReferenceException e) {
				for (int i = 0; i <= 10; ++i) {
					try {
						getFluentWait()
						.until(ExpectedConditions.elementToBeClickable(webElement))
						.sendKeys(Input);
								
						break;
					} catch (StaleElementReferenceException e1) {
						continue;
					}	
				}
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  
			
		} 
		
		public static String getNonstaleElementGetText(WebElement webElement) throws Throwable {
			String text= null;
			try {
					((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
					text=	getFluentWait().until(ExpectedConditions.elementToBeClickable(webElement)).getText();

			} catch (StaleElementReferenceException e) {
				for (int i = 0; i <= 10; ++i) {
					try {
						text=		getFluentWait()
						.until(ExpectedConditions.elementToBeClickable(webElement))
						.getText();
								
						break;
					} catch (StaleElementReferenceException e1) {
						continue;
					}	
				}
			} catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  
			return text;
		} 
		
		
		public static void PersistentFind(WebElement webElement) throws Throwable {
			try {
				((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
				
				getFluentWait().until(ExpectedConditions.elementToBeClickable(webElement));

			} catch (NoSuchElementException e) {
				for (int i = 0; i <= 10; ++i) {
					try {
						getFluentWait()
						.until(ExpectedConditions.elementToBeClickable(webElement));								
						break;
					} catch (NoSuchElementException e1) {
						continue;
					}catch (ElementNotInteractableException e1) {
						continue;
					}catch (InvalidElementStateException e1) {
						continue;
					}		
				}
			} catch (ElementNotInteractableException e) {
				for (int i = 0; i <= 10; ++i) {
					try {
						getFluentWait()
						.until(ExpectedConditions.elementToBeClickable(webElement));								
						break;
					} catch (NoSuchElementException e1) {
						continue;
					}catch (ElementNotInteractableException e1) {
						continue;
					}catch (InvalidElementStateException e1) {
						continue;
					}	
				}
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				for (int i = 0; i <= 10; ++i) {
					try {
						getFluentWait()
						.until(ExpectedConditions.elementToBeClickable(webElement));								
						break;
					} catch (NoSuchElementException e1) {
						continue;
					}catch (ElementNotInteractableException e1) {
						continue;
					}catch (InvalidElementStateException e1) {
						continue;
					}	
				}
			} catch(StaleElementReferenceException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} 
			
		} 
		
		/**
		 * WebDriver wait
		 * @param element
		 * @return 
		 * @throws Throwable 
		 */
		public static void waitForVisibility(WebElement webElement) throws Throwable {
		try {	
			getFluentWait().until(ExpectedConditions.visibilityOf(webElement));
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(TimeoutException E1) {
			throw new WaitingFailedForElementLoad("Element Did not Load for element " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		}catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
		}
		
		public static void waitForInteractibility(WebElement webElement) throws Throwable {
		try {	
			getFluentWait().until(ExpectedConditions.elementToBeClickable(webElement));
		} catch(ElementNotInteractableException E1) {
			throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(ElementNotSelectableException E1) {
			throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidElementStateException E1) {
			throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		} catch(InvalidSelectorException E1) {
			throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(NoSuchElementException E1) {
			throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		}  catch(TimeoutException E1) {
			throw new WaitingFailedForElementLoad("Element Did not Load for element " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
		}catch(StaleElementReferenceException E1) {
			throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
		}
		}
		
		/**
		 * WebDriver wait
		 * @param element
		 * @return 
		 * @throws Throwable 
		 */
		public static void waitForNonVisibility(WebElement webElement, int timeOut) throws Throwable {
		try {	
			getFluentWait().until(ExpectedConditions.invisibilityOf(webElement));
			} catch (Exception e) {
//				Logger.logMessage("Exception: Webelement visible in waitForNonVisibility: " + webElement);
				throw new UnknownException("error with element "+LocatorExtractor.ExtractBy(webElement)+" on: "+DriverManager.getWebDriver().getCurrentUrl(), e);
			}	
		}
		
		 /**
		 * WebDriver wait
		 * @param element
		 * @return 
		 * @throws Throwable 
		 */
		public static void waitForAttribute(WebElement webElement, String attribute, String value) throws Throwable {
		try {	
			getFluentWait().until(ExpectedConditions.attributeContains(webElement, attribute, value));
			} catch (Exception e) {
//				Logger.logMessage("Exception: Webelement not visible in waitForAttribute: " + webElement);
				throw new UnknownException("error with element "+LocatorExtractor.ExtractBy(webElement)+" on: "+DriverManager.getWebDriver().getCurrentUrl(), e);
			}
		} 
	    
	   /**
	    * Verify webelement is present
	    * @return
	    */
	   	public static Boolean isPresent(WebElement webElement, int timeOut) {
		   	Boolean found = false;
		   	
		   	WebInteract.waitForPageLoad(DriverManager.getWebDriver());
		   
		   	try {
			   		new WebDriverWait(DriverManager.getWebDriver(), timeOut)
			   		.until(ExpectedConditions.visibilityOf(webElement));
			   		
				   	if (webElement.isDisplayed())
				   		found = true;
			     
		   	} catch(Exception e) {
		   		Logger.logMessage("Exception: Webelement not present in isPresent: " + webElement);
		   		found = false;
		   	}
			  
	       return found;
	   	}
	   
	    /**
	     * 
	     * @param url
	     */
	    public static void openUrl(String url) {
	    	DriverManager.getWebDriver().navigate().to(url);
	        Logger.logMessage("Open url '" + url + "'.");
	    }
	    
	    /**
		 * Method for mouse hover with JS
		 * @param webElement
		 * @return
	     * @throws Throwable 
		 */
		public static void mouseOverByJS(WebElement webElement) throws Throwable {
			try {
	        String mouseOverJS = "var evObj = document.createEvent('MouseEvents');evObj.initMouseEvent"
	        		+ "(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
	        		+ "arguments[0].dispatchEvent(evObj);";
	        ((JavascriptExecutor)DriverManager.getWebDriver()).executeScript(mouseOverJS, webElement);
	        }catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
	    }
		
		/**
		 * Method to Mouse over the web element using the touch action class.
		 * @throws Throwable 
		 */
	    public static void mouseOver(WebElement webElement) throws Throwable {
	    	try {
	        new Actions(DriverManager.getWebDriver()).moveToElement(webElement).build().perform();
	    	}catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
	    }
	    
		/**
		 * Method to Mouse over the web element using the touch action class.
		 * @throws Throwable 
		 */
	    public static void actionsclick(WebElement webElement) throws Throwable {
	    	try {
	        new Actions(DriverManager.getWebDriver()).moveToElement(webElement).click().build().perform();
	    	}catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
	    }
	    
	    /**
	     * Clicks the identified web element by javascript.
	     * @return
	     * @throws Throwable 
	     */
	    public static void clickByJS(WebElement webElement) throws Throwable {
	    	try {
	     	((JavascriptExecutor)DriverManager.getWebDriver()).executeScript("arguments[0].click();", webElement);
	    	}catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
	     }
		
	    /**
	     * sets value in the identified web element by javascript.
	     * @return
	     * @throws Throwable 
	     */
	    public static void setTextByJS(WebElement webElement, String value) throws Throwable {
	    	try {
	    	JavascriptExecutor js = (JavascriptExecutor)DriverManager.getWebDriver();
	    	js.executeScript("arguments[0].value='"+ value +"';", webElement);
	    	}catch(ElementNotInteractableException E1) {
				throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(ElementNotSelectableException E1) {
				throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidElementStateException E1) {
				throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			} catch(InvalidSelectorException E1) {
				throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(NoSuchElementException E1) {
				throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}  catch(StaleElementReferenceException E1) {
				throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
			}
	    }
	    
	    /**
	     * sets value in the identified web element by javascript.
	     * @return
	     */
	    public static void backtByJS() {
	    	waitForPageLoad(DriverManager.getWebDriver());
	    	JavascriptExecutor js = (JavascriptExecutor)DriverManager.getWebDriver(); 
	    	js.executeScript("window.history.go(-1)");
	    }
	    
	    public static void validatePageTitle(String Expected) {
	    	String Title = DriverManager.getWebDriver().getTitle();
	    	System.out.println(Title);
	    	Asserts.assertTrue(Title.contains(Expected), "User Navigated To "+Expected+" Page successfully");
	    }
	    
	    public static void validatePageURL(String Expected) {
	    	String Title = DriverManager.getWebDriver().getCurrentUrl();
	    	System.out.println(Title);
	    	Asserts.assertTrue(Title.contains(Expected), "User Navigated To "+Expected+" URL successfully");
	    }
	    
	    public static String returnPageURL() {
	    	String Title = DriverManager.getWebDriver().getCurrentUrl();
	    	System.out.println(Title);
	    	return Title;
	    }
	    
		public static void scrollDown(int x,int y) {
			((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("window.scrollBy(0,1000)");
		}
		
		public static void SectionPageDown(WebElement element) throws Throwable {
			new Actions(DriverManager.getWebDriver()).moveToElement(element).perform();
			new Actions(DriverManager.getWebDriver()).moveToElement(element).perform();
			Selenium.sendKeysActions(element, Keys.PAGE_DOWN);
		}
		
		public static void scrollDownonDiv(WebElement divWithScrollbarElement,WebElement elementToScrollTo) {
			((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollTop=arguments[1].offsetTop",
				    divWithScrollbarElement,
				    elementToScrollTo);
		}
		
		 public static void senKeysActions(WebElement webElement,CharSequence keys) throws Throwable {
		    	try {
		        new Actions(DriverManager.getWebDriver()).sendKeys(webElement, keys).build().perform();
		    	}catch(ElementNotInteractableException E1) {
					throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
				} catch(ElementNotSelectableException E1) {
					throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				} catch(InvalidElementStateException E1) {
					throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				} catch(InvalidSelectorException E1) {
					throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				}  catch(NoSuchElementException E1) {
					throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				}  catch(StaleElementReferenceException E1) {
					throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				}
		    }
		 
		 
		 
		 public static void multiSelectCheckbox(List<WebElement> webElement1,List<WebElement> webElement2, String Text) 
				 throws Throwable {
				
			    String [] options= Text.split(",");
			    int count=options.length;
			    WebInteract.waitForVisibility(webElement1.get(0));
			    WebInteract.waitForVisibility(webElement2.get(0));
			    
			    for(int i=0;i<count;i++)
			    {
			    	for(int j=0;j<webElement1.size();j++)
			    	{
			    		if(Selenium.getText(webElement1.get(j)).equalsIgnoreCase(options[i]))
			    		{
			    			Selenium.click(webElement2.get(j));
			    			break;
			    		}
			    	}
			    }
				
			}
		 
		 
		 
		 
		 
		 
		 
		 public static void clicksActions(WebElement webElement) throws Throwable {
		    	try {
		        new Actions(DriverManager.getWebDriver()).click(webElement).build().perform();
		    	}catch(ElementNotInteractableException E1) {
					throw new UnableToInteractWithElementException("Unable To Interact With " + LocatorExtractor.ExtractBy(webElement)+ " on: " + DriverManager.getWebDriver().getCurrentUrl(), E1);
				} catch(ElementNotSelectableException E1) {
					throw new UnableToSelectHtmlLocator("Unable To Select " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				} catch(InvalidElementStateException E1) {
					throw new InvalidHTMLElementStateException("Unable To Interact Due To Invalid State Of " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				} catch(InvalidSelectorException E1) {
					throw new InvalidWebLocatorException("Selector Is Invalid For " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				}  catch(NoSuchElementException E1) {
					throw new CannotFindElementOnPageException("Unable To Find On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				}  catch(StaleElementReferenceException E1) {
					throw new HTMLElementExpiredException("Unable To Click As HTML Is Stale On " + LocatorExtractor.ExtractBy(webElement)+ " on: " +DriverManager.getWebDriver().getCurrentUrl(), E1);
				}
		    }
		    
			
			
			
			public static void AcceptAlert() {
				DriverManager.getWebDriver().switchTo().alert().accept();
			}
			
			public static void DismissAlert() {
				DriverManager.getWebDriver().switchTo().alert().dismiss();
			}
			
			public static void AlertTypeText(String text) {
				DriverManager.getWebDriver().switchTo().alert().sendKeys(text);
			}
			
			
			public static boolean WaitForAlert() throws Throwable {
				boolean AlertExists= false;
				for(int i=0;i<=10;i++) {
					if(isAlertPresent()) {
						AlertExists= true;
						break;
					}else {
						Thread.sleep(2500);
						continue;
					}
				}
					return AlertExists;
				
			}
			
			public static String AlertGetText() {
			return	DriverManager.getWebDriver().switchTo().alert().getText();
			}
			
			public static boolean isAlertPresent(){
			      try{
			    	  DriverManager.getWebDriver().switchTo().alert();
			          return true;
			      }catch(NoAlertPresentException ex){
			          return false;
			      }
			}
		 
		    



}
