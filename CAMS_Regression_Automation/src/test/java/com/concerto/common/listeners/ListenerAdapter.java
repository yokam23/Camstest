package com.concerto.common.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerAdapter extends TestListenerAdapter{
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		result.getTestContext().getSkippedTests().removeResult(result.getMethod());
	}

}
