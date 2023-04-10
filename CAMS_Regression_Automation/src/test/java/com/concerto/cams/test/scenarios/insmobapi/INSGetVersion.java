package com.concerto.cams.test.scenarios.insmobapi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.api.utilities.RestMethods;
import com.concerto.cams.test.api.json.InstallationLogin;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;

import io.restassured.response.Response;

public class INSGetVersion {
	
	String ClassName;
	String PackageName;

	@BeforeMethod(alwaysRun = true, groups = { "API" })
	public void initiateTest() {
		ClassName = this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
	}
	
	@Test(description = "TC0001::Validate Version no", groups = { "API" }, dataProvider = "DataReader")
    public void ValidateInstallationLogin(String TCNo, String Description,String version) throws Throwable{
		
		String Json = InstallationLogin.GetVersion(version);
		
		Response response = RestMethods.POST_Request("http://10.10.10.212:8080/InstallationTool/", "getVersion", "", Json);
			
		response.prettyPrint();
		//System.out.println(response.prettyPrint());
		
		String Status = response.path("VersionNo");
		
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
