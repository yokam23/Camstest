package com.concerto.common.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.tools.ant.taskdefs.Retry;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}
