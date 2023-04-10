package com.concerto.common.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

    private int count = 0;
    private static int maxTry = 3;
 
    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {     
//            	result.getTestContext().getFailedTests().removeResult(result);
//            	result.getTestContext().getSkippedTests().removeResult(result);
                count++;                                     //Increase the maxTry count by 1 //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } 
        } else {
        	result.setStatus(ITestResult.SUCCESS);
            return false;       //If test passes, TestNG marks it as passed
        }
		return false;
    }
}
