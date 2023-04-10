package com.concerto.cams.test.scenarios.insmobapi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.api.utilities.RestMethods;
import com.concerto.cams.test.api.json.InstallationLogin;
import com.concerto.cams.test.api.json.InstallationSelectClient;
import com.concerto.cams.test.api.json.PanelOutgoingCommands;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

import io.restassured.response.Response;

public class INSPanelOutgoingCommands extends BaseClass {
	

	String ClassName;
	String PackageName;
	Response response;

	@BeforeMethod(alwaysRun = true, groups = { "API" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
	}
	
	@Test(description = "TC0001::Validate outgoing commands for Panel in installtion tool ", groups = { "API" }, dataProvider = "DataReader")
    public void ValidateResetPanel(String TCNo, String Description,String loginId,String Password,String clientName,String panelId,String deviceId,String Switch) throws Throwable{
		
		String LoginJson = InstallationLogin.login(loginId, Password, deviceId);
		System.out.println(LoginJson);
		Response Loginresponse = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "login", "", LoginJson);
		
		String sessionId = Loginresponse.path("sessionId");
		
        String ClientJson = InstallationSelectClient.SelectClient(loginId, clientName, sessionId);
		
		Response Clientresponse = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "selectClient", "", ClientJson);
				
		Clientresponse.prettyPrint();
		
		String Json = PanelOutgoingCommands.ResetPanel(loginId, clientName, panelId, sessionId);
		
		if(Switch.equalsIgnoreCase("resetPanel")) {
		response = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "resetPanel", "", Json);
		}else if(Switch.equalsIgnoreCase("silenceCommand")) {
		response = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "silenceCommand", "", Json);
		}else if(Switch.equalsIgnoreCase("startSiren")) {
		response = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "startSiren", "", Json);
		}else if(Switch.equalsIgnoreCase("pingStatus")) {
		response = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "pingStatus", "", Json);
		}
		
		response.prettyPrint();
		
		String Status = response.path("LoginStatus");
		
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
