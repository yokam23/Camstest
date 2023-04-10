package com.concerto.common.listeners;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.concerto.common.BaseClass;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.Logger;

public class TestListeners extends BaseClass implements ITestListener{

    @Override
    public void onFinish(final ITestContext context) {
    	Logger.logConsoleMessage("========TEST FINISH========");
    }

    @Override
    public void onStart(final ITestContext test) {
    	Logger.logConsoleMessage("========TEST START========");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {

    }

    @Override
    public void onTestFailure(final ITestResult result) {
        teardownTest(result);
		if (!(result.getStatus()==ITestResult.SUCCESS)) {
		if (!result.getThrowable().toString().isEmpty()) {
/*			HashMap<String,String> Errors = new HashMap<>();
			Errors.put("Exception", result.getThrowable().getMessage().split("on")[0]);
			Errors.put("Page", result.getThrowable().getMessage().split("on")[1]);
			AllErrors.add(Errors);			*/
			result.getTestName();
			result.getTestClass();
			result.getThrowable().getMessage();
			System.out.println(result.getThrowable().getMessage());
		}
		}
    }

    @Override
    public void onTestSkipped(final ITestResult result) {
    	result.getTestContext().getSkippedTests().removeResult(result.getMethod());
        teardownTest(result);
    }

    @Override
    public void onTestStart(final ITestResult result) {
       
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        teardownTest(result);
    }

    private void teardownTest(ITestResult result) {
        String status = result.isSuccess() ? "SUCCESS" : "FAILURE";
        Logger.logConsoleMessage("======" + status + "======");
        Logger.logConsoleMessage("Test: " + result.getInstanceName() + "." + result.getName());

        // attach screenshot
//        AllureManager.attachScreenshot();
        //AllureManager.attachSeleniumLog(Config.SELENIUM_LOG_PATH);
        //AllureManager.attachVideo(Config.SELENIUM_LOG_PATH);
    }

}
