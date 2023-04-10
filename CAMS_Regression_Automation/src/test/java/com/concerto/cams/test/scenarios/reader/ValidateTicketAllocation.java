package com.concerto.cams.test.scenarios.reader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.readerutils.RequestFile;
import com.concerto.cams.readerutils.TCPRequest;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.DateTimeFunctions;
import com.concerto.common.utilities.Excel;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.GetTicketName;
import com.concerto.db.methods.LogOutUsers;

public class ValidateTicketAllocation extends BaseClass{
	
	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "API" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::Validate Login For InValid Data",groups = { "API" },dataProvider="DataReader")
	public void validateCorrectLogin(String TCNo,String TCDescription,String PanelId,String Alert,String Zone) throws Throwable {
//		Map<String, String> TestData = Excel.getTestData(Config.TEST_DATA_FILE_PATH, ClassName, PackageName);
/*		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(UserName, Password);*/
		TCName.append(TCNo);
		LogOutUsers.LogoutOperator();
		TCPRequest.sendTCPReq("10.10.10.212", 5558, RequestFile.
				generateRequest(PanelId, Alert, Zone, 
						DateTimeFunctions.GenerateOffsetTimeHHMMSS(), DateTimeFunctions.GenerateOffsetDateMMDDYYYY(0)));
		ArrayList<LinkedHashMap<String,String>> Results=GetTicketName.GetTicket(PanelId, Zone);
		String TicketNo=Results.get(0).get("TicketNo");
//		Asserts.assertTrue(Flag, Message);
		Asserts.AssertAll();
	}
	
	@DataProvider(name="DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray=ExcelDataProvider.getTableArray(Config.DataProvider_File_Path, this.getClass().getSimpleName());
//		System.out.println(tabArray);
		return tabArray;
	}

}
