package com.concerto.cams.test.scenarios.insmobapi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.api.utilities.RestMethods;
import com.concerto.cams.test.api.json.InstallationLogin;
import com.concerto.cams.test.api.json.InstallationSelectClient;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

import io.restassured.response.Response;

public class SelectClient extends BaseClass{
	
	String ClassName;
	String PackageName;

	@BeforeMethod(alwaysRun = true, groups = { "API" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
	}
	
	@Test(description = "TC0001::Validate select client in installation tool ", groups = { "API" }, dataProvider = "DataReader")
    public void ValidateSelectClient(String TCNo, String Description,String loginId,String Password ,String clientName,String deviceId) throws Throwable{
		
		String Json = InstallationLogin.login(loginId, Password, deviceId);
		System.out.println(Json);
		Response response = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "login", "", Json);
		
		String sessionId = response.path("sessionId");
		
		String ClientJson = InstallationSelectClient.SelectClient(loginId, clientName, sessionId);
		
		Response Clientresponse = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "selectClient", "", ClientJson);
				
		System.out.println(Clientresponse.prettyPrint());
		
		String Status = Clientresponse.path("responseMsg");
		Asserts.assertEqual(Status, "Success", "Incorrect Status Displayed when Client API is called");
		Asserts.AssertAll(TCNo);
    }
	
	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}
}

