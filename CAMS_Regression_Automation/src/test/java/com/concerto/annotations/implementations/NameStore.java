package com.concerto.annotations.implementations;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;

import com.concerto.annotations.Name;

public class NameStore extends NameFactory {

	
    private static HashMap<WebElement, String> map = new HashMap<>();
/**
 * @author abhijit.bhattacharya
 * @param pageObject
 * @throws ReflectiveOperationException
 * @throws SecurityException
 */
    public static void store(Object pageObject) throws ReflectiveOperationException, SecurityException {
    	System.out.println(pageObject.getClass().getSimpleName());    	
    	Class pageClass= pageObject.getClass();
//    	System.out.println(pageClass.getDeclaredFields());
    	System.out.println(pageClass.getDeclaredMethods());
        Field[] fields = pageObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            Name annotation = field.getAnnotation(Name.class);
            if (annotation != null) {
                try {
                	System.out.println(field.getName());
                	System.out.println((WebElement) field.get(pageObject));
                	Object obj = (Object)field;
                	System.out.println((WrapsElement) obj);
                    map.put((WebElement) obj, annotation.Description());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void Namestore(Object pageObject) throws ReflectiveOperationException, SecurityException {
    	System.out.println(pageObject.getClass().getSimpleName());    	
    	Class pageClass= pageObject.getClass();
    }
    
    
    public static void getFieldNames(Object pageObject) {
    	Class pageClass= pageObject.getClass();
    	Field[] fields = pageObject.getClass().getDeclaredFields();
    }
    
    public static void extractWebElement(WebElement element,String field) throws Throwable, Throwable {
    	Object handler = Proxy.getInvocationHandler(element);
    	Class handlerClass = handler.getClass();
    	Field objField = handlerClass.getDeclaredField(field);
    	objField.setAccessible(true);
    	Object behindProxy = objField.get(handler);
    }
    
/**
 * @author abhijit.bhattacharya
 * @param element
 * @return
 * @throws Throwable
 */
    public static String getDescription(WebElement element) throws Throwable {
    	
    	Object proxyOrigin = FieldUtils.readField(element, "h", true);
        return map.get(((WrapsElement)element).getWrappedElement());
    }

}
