package com.concerto.annotations.implementations;

import java.lang.reflect.Field;

import org.openqa.selenium.WebElement;

import com.concerto.annotations.Name;

public class NameExtractor {
	/**
	 * @author abhijit.bhattacharya
	 * @param element
	 * @param PageObject
	 * @return
	 * @throws IllegalAccessException
	 */
	private static String getDescription(WebElement element,Object PageObject) throws IllegalAccessException {
	    //Get all the fields of the page object.
	    for (Field field : PageObject.getClass().getDeclaredFields()) {
	        Name name = field.getAnnotation(Name.class);
	        //Consider only the ones that is annotated by your @Name
	        if (name != null) {
	            WebElement classElement = (WebElement) field.get(element);
	            //Get the element from the class and compare with your current.
	            if (classElement != null && (classElement).equals(element)) {
	                return name.Description();
	            }
	        }
	    }
	    return ":C"; // or throw something, whatever you want...
	}

}
