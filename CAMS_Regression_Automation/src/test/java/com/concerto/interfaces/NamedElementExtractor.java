package com.concerto.interfaces;

import java.awt.List;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import org.openqa.selenium.WebElement;

import com.concerto.annotations.Name;

public class NamedElementExtractor {
	
/*	   public static Collection<NamedElement> getNamedElements(Object instanceWithWebElements) {
		   //instanceWithElements in your case would be an instance of the class that has the "gmail" field, i.e. the one I referred to as ClassWithGmailField above
		     Collection<NamedElement> namedElements = new ArrayList<NamedElement>();
		     for (Field field : instanceWithWebElements.getClass().getDeclaredFields()) {
		        field.setAccessible(true);
		        //maybe first check field.isAnnotationPresent(Name.class)
		        String desc = field.getAnnotation(Name.class).Description();
		        WebElement element = field.get(obj).getValue(instanceWithWebElements);
		        namedElements.add(new NamedElement(desc, element));
		     }
		   }
*/
}
