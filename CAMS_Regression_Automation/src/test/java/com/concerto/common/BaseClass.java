package com.concerto.common;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import com.concerto.cams.common.dataprep.AllData;
import com.concerto.common.contsants.Config;
import com.concerto.common.reports.ConsolidatedReportBuilder;
import com.concerto.common.reports.ErrorReportBuilder;
import com.concerto.common.reports.ExcelReport;
import com.concerto.common.reports.PassReportBuilder;
import com.concerto.common.reports.ReportWriter;
import com.concerto.common.utilities.AllureManager;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DriverManager;
import com.concerto.common.utilities.FileHandler;
import com.concerto.common.utilities.Logger;
import com.concerto.db.methods.LogOutUsers;

public class BaseClass {
	
	/**
	 * @author abhijit.bhattacharya
	 */
	
	protected static StringBuffer verificationErrors = new StringBuffer();
	public static List<HashMap<String,String>> AllErrors;
	public static HashMap<String,List<HashMap<String,String>>> TCErrors;
	static HashMap <Integer,HashMap<String,List<HashMap<String,String>>>> ErrorMap;
	protected static StringBuffer TCName = new StringBuffer();
	
	@BeforeSuite(alwaysRun=true,groups = { "UI","API","DB","Single" })
	public void InitiateSuite() throws Throwable {
		ErrorMap = new HashMap <Integer,HashMap<String,List<HashMap<String,String>>>>();
//		ErrorMap.clear();
		FileHandler.filePermission(Config.Test_Cases);
		FileHandler.filePermission(Config.TEST_DATA_FILE_PATH);
		FileHandler.filePermission(Config.DataProvider_File_Path);
		FileHandler.filePermission("Reports/ErrorReport.html");
		FileHandler.filePermission("Reports/ConsolidatedErrorReport.html");
		AllData.generateData();


	}
	
	@BeforeClass(groups = { "UI","Single" })
	@Parameters({"Browser","RunEnv","GRID_HUB_IP","Port"})
	public void InitiateClassUI(String Browser, String RunEnv, String GRID_HUB_IP,String Port) throws Throwable {
		Asserts.verificationErrors=Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCErrors= new HashMap<String,List<HashMap<String,String>>>();
		AllErrors = new ArrayList<HashMap<String,String>>();
		LogOutUsers.LogoutOperator();
		DriverManager.initiateWebDriver(Browser, RunEnv, GRID_HUB_IP, Port);	
		DriverManager.getWebDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		EventFiringWebDriver eventDriver = new EventFiringWebDriver(DriverManager.getWebDriver());
	}
	
	@BeforeClass(groups = { "API","Single" })
	@Parameters({"Browser","RunEnv","GRID_HUB_IP","Port"})
	public void InitiateClassAPI(String Browser, String RunEnv, String GRID_HUB_IP,String Port) throws Throwable {
		Asserts.verificationErrors=Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCErrors= new HashMap<String,List<HashMap<String,String>>>();
		AllErrors = new ArrayList<HashMap<String,String>>();
		LogOutUsers.LogoutOperator();
	}
	
	@BeforeClass(groups = { "DB","Single" })
	@Parameters({"Browser","RunEnv","GRID_HUB_IP","Port"})
	public void InitiateClassDB(String Browser, String RunEnv, String GRID_HUB_IP,String Port) throws Throwable {
		Asserts.verificationErrors=Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCErrors= new HashMap<String,List<HashMap<String,String>>>();
		AllErrors = new ArrayList<HashMap<String,String>>();
		LogOutUsers.LogoutOperator();
	}
	
	
	@AfterMethod(alwaysRun=true,groups = { "UI","API","DB","Single" })
	@Parameters({"Browser"})
	public void TeardownTest(String Browser,ITestResult result) throws Throwable {	
		LogOutUsers.LogoutOperator();
		try {
			AllureManager.attachScreenshot();
		}catch(Exception E) {
			Logger.logConsoleMessage(">>>>Unable To Attach Screenshot<<<<");
		}
		String verificationErrorString = Asserts.verificationErrors.toString();   
		if (!"".equals(verificationErrorString)) {		
			   System.out.print("Error Found");
//		ExcelReport.GenerateExcelReport(result.getMethod().getDescription(), "FAILED", verificationErrorString);			   
			     String ClassName= this.getClass().getSimpleName()+":"+result.getMethod().getDescription();			     
			     LinkedHashSet<HashMap<String,String>> 
		            newList = new LinkedHashSet<>(AllErrors);
			     ArrayList <HashMap<String,String>> finalList = new ArrayList<>(newList);
			     TCErrors.put(ClassName, finalList);
			     ErrorMap.put(ErrorMap.entrySet().size()+1, TCErrors);
			     result.setStatus(ITestResult.FAILURE);
			     Reporter.setCurrentTestResult(result);
		   }else if(!(result.getStatus()==ITestResult.SUCCESS)) {
			   if (!result.getThrowable().toString().isEmpty()) {
				   try {
				   if(result.getThrowable().getMessage().contains("::Request::")) {
				ExcelReport.GenerateExcelReport(TCName.toString(), "FAILED",result.getThrowable().getMessage().split("::Request::")[0]
						);
				   				   System.out.print("Exception Found");
				   }else {
					   ExcelReport.GenerateExcelReport(TCName.toString(), "FAILED",result.getThrowable().getMessage());	   
				   }
				   }catch(Exception e1) {
					   ExcelReport.GenerateExcelReport(TCName.toString(), "FAILED",result.getThrowable().getMessage());
				   }
//		ExcelReport.GenerateExcelReport(result.getMethod().getDescription(), "FAILED", result.getThrowable().getMessage().toString());	   
				   String ClassName= this.getClass().getSimpleName()+":"+result.getMethod().getDescription();
			   System.out.println(result.getThrowable().getMessage());
					HashMap<String,String> Errors = new HashMap<>();
					try {
					if(result.getThrowable().getMessage().contains("on:")) {
					Errors.put("Exception", result.getThrowable().getMessage().split("on:")[0]);
					Errors.put("Page", result.getThrowable().getMessage().split("on:")[1]);
					AllErrors.add(Errors);	
					} else{
						Errors.put("Exception", result.getThrowable().getMessage());
						Errors.put("Page", "NA");
					}
					}catch(Exception E) {
						Errors.put("Exception", result.getThrowable().getMessage());
						Errors.put("Page", "NA");
					}
					Set<HashMap<String,String>>  newList = Collections.synchronizedSet(new LinkedHashSet<>(AllErrors));
					     ArrayList <HashMap<String,String>> finalList = new ArrayList<>(newList);
					     TCErrors.put(ClassName, finalList);
					     ErrorMap.put(ErrorMap.entrySet().size()+1, TCErrors);
					     result.setStatus(ITestResult.FAILURE);
					     Reporter.setCurrentTestResult(result);
			   }
		   }else{
			   System.out.print("Test Case Has Passed");
//			   ExcelReport.GenerateExcelReport(result.getMethod().getDescription(), "PASSED", "NA");
		   }
	}
	
	@AfterClass(groups = { "UI","Single"})
	@Parameters({"Browser"})
	public void TeardownClassUI(String Browser) throws Throwable {
		DriverManager.stopWebDriver(Browser);
	}
	
	@AfterClass(groups = { "API","Single"})
	@Parameters({"Browser"})
	public void TeardownClassAPI(String Browser) throws Throwable {
	//	DriverManager.stopWebDriver(Browser);
	}
	
	@AfterClass(groups = { "DB","Single"})
	@Parameters({"Browser"})
	public void TeardownClassDB(String Browser) throws Throwable {
	//	DriverManager.stopWebDriver(Browser);
	}
	
	@AfterSuite(alwaysRun=true,groups = { "UI","API","DB","Single" })
	public void CompleteSuite(ITestContext ctx) throws Throwable {	
		
		XmlSuite xmlSuite = ctx.getCurrentXmlTest().getSuite();
	    ISuite suite = ctx.getSuite();
	    String suiteName = suite.getName();
	    
        //Getting the results for the said suite
        Map<String, ISuiteResult> suiteResults = suite.getResults();
        for (ISuiteResult sr : suiteResults.values()) {
           ITestContext tc = sr.getTestContext();
           int Passed = tc.getPassedTests().getAllResults().size();
           int Failed = tc.getFailedTests().getAllResults().size();
           int Skipped = tc.getSkippedTests().getAllResults().size();
           int Total = Passed+Failed+Skipped;
        	   if(!ErrorMap.isEmpty()) {
        String Report = ErrorReportBuilder.HTML_Header_Builder(ErrorMap,ErrorReportBuilder.htmlSummaryTable_Final(Total, Passed, Failed, Skipped));
   		ReportWriter.WriteReports("Reports/ErrorReport.html", Report);
   		System.out.println(ExcelReport.CreateFailureMap().toString());
   		String ConsolidatedReport = ConsolidatedReportBuilder.HTML_Header_Builder(ExcelReport.CreateFailureMap(),ConsolidatedReportBuilder.htmlSummaryTable_Final(
   				ExcelReport.GenerateTotalCases()-ExcelReport.GenerateNotRunCases()-2, ExcelReport.GeneratePassedCases(), ExcelReport.GenerateFailedCases(), 0));
   		ReportWriter.WriteReports("Reports/ConsolidatedErrorReport.html", ConsolidatedReport);
        	   }else {
        String Report = PassReportBuilder.HTML_Header_Builder(PassReportBuilder.htmlSummaryTable_Final(Total, Passed, Failed, Skipped));
        	System.out.println("Test passed Without Errors");
        	String ConsolidatedReport = ConsolidatedReportBuilder.HTML_Header_Builder(ExcelReport.CreateFailureMap(),ConsolidatedReportBuilder.htmlSummaryTable_Final(
        			ExcelReport.GenerateTotalCases()-ExcelReport.GenerateNotRunCases()-2, ExcelReport.GeneratePassedCases(), ExcelReport.GenerateFailedCases(), 0));
       		ReportWriter.WriteReports("Reports/ConsolidatedErrorReport.html", ConsolidatedReport);
        	
        	}
        
        }

	}

}
