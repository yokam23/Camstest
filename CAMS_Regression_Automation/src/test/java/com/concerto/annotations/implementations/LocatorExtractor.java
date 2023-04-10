package com.concerto.annotations.implementations;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.WebElement;

public class LocatorExtractor {
	/**
	 * @author abhijit.bhattacharya
	 * @param element
	 * @return
	 * @throws ReflectiveOperationException
	 */
	   public static String ExtractBy(WebElement element) throws ReflectiveOperationException {
		Object proxyOrigin = FieldUtils.readField(element, "h", true);
		Object locator = FieldUtils.readField(proxyOrigin, "locator", true);
		Object findBy = FieldUtils.readField(locator, "by", true);
		return findBy.toString();
	   }
}
