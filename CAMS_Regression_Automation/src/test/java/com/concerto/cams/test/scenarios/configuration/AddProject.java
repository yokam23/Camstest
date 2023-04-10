package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.cams.test.pageutils.ProjectPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.LogOutUsers;

public class AddProject extends BaseClass{
	
	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	ProjectPageUtils ProjectPageUtils;
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		ProjectPageUtils = new ProjectPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}

	@Test(description = "TC0001::Validate Add panel for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddProject(String TcNO, String PanelType, String ClientName,  String ProjectName, String ZoneNoText, String SensorLocation,
			String DescriptionTextbox, String CameraDropDown, String SensorManufacturerDropdown, String CameraManuf,
			String CameraModel, String DVRManufacturerName, String DVRModelName, String DVRVersionName, String DVRSerialNo,
			String RouterManufacturerName, String RouterModelName, String RouterVersionName, String RouterSerialNo,
			String HDDManufacturerName, String HDDModelName, String HDDVersionName, String HDDSerialNo,String NetworkProvider, 
			String NetworkType, String TemplateSelectDropdown) throws Throwable {
		TCName.append(TcNO);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		
		/*
		 * Navigate To Project Screen
		 */		
		Homepageutils.GetProjectPage();
		/**
		 * Project
		 */
		ProjectPageUtils.navigateToAddProject();
		ProjectPageUtils.AddProject(PanelType, ClientName, ProjectName, ZoneNoText, SensorLocation, DescriptionTextbox, CameraDropDown, SensorManufacturerDropdown, CameraManuf, CameraModel, DVRManufacturerName, DVRModelName, DVRVersionName, DVRSerialNo, RouterManufacturerName, RouterModelName, RouterVersionName, RouterSerialNo, HDDManufacturerName, HDDModelName, HDDVersionName, HDDSerialNo, NetworkProvider, NetworkType, TemplateSelectDropdown);
		LoginPageUtils.Logout();
		LogOutUsers.LogoutOperator();
		Asserts.AssertAll(TcNO);
	}    
	
	@DataProvider(name = "DataReader")
	public Object[][] DataReader() throws Throwable {
		Object[][] tabArray = ExcelDataProvider.getTableArray(Config.DataProvider_File_Path,
				this.getClass().getSimpleName());
		// System.out.println(tabArray);
		return tabArray;
	}
}


//, String ESCName, String ESCComments, String ESCTelephoneNo,String 	ESCMobileNo, String ESCEmailID, String ESCPriority, String ESCRepeatInterval 