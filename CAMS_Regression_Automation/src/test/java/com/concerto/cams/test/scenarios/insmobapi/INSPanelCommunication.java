package com.concerto.cams.test.scenarios.insmobapi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.api.utilities.RestMethods;
import com.concerto.cams.test.api.json.InstallationLogin;
import com.concerto.cams.test.api.json.InstallationPanelTracking;
import com.concerto.cams.test.api.json.InstallationSelectClient;
import com.concerto.cams.test.api.json.InstallationselectPanelId;
import com.concerto.cams.test.api.json.PanelCommunication;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

import io.restassured.response.Response;

public class INSPanelCommunication extends BaseClass {

	String ClassName;
	String PackageName;

	@BeforeMethod(alwaysRun = true, groups = { "API" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
	}
	
	@Test(description = "TC0001::Validate Panel Communication Status in installtion tool ", groups = { "API" }, dataProvider = "DataReader")
    public void ValidatePanelCommunicationStatus(String TCNo, String Description,String loginId,String Password,String deviceId,String clientName,String panelId,String tracking) throws Throwable{
		
		String LoginJson = InstallationLogin.login(loginId, Password, deviceId);
		System.out.println(LoginJson);
		Response Loginresponse = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "login", "", LoginJson);
		
		String sessionId = Loginresponse.path("sessionId");
		
        String ClientJson = InstallationSelectClient.SelectClient(loginId, clientName, sessionId);
		
		Response Clientresponse = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "selectClient", "", ClientJson);
	   
		String PanelIdJson = InstallationselectPanelId.selectPanelId(loginId, clientName, panelId, sessionId);
			
		Response PanelIdresponse = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "selectPanelId", "", PanelIdJson);
			
		String PanelTrackingJson = InstallationPanelTracking.StartPanelTracking(loginId, clientName, panelId, tracking, sessionId);
		
		Response PanelTrackingresponse = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "panelTracking", "", PanelTrackingJson);
		
		String Json = PanelCommunication.PanelCommunicationStatus(loginId, clientName, panelId, sessionId);
		
		Response response = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "panelCommunication", "", Json);
				
		System.out.println(response.prettyPrint());
		
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
