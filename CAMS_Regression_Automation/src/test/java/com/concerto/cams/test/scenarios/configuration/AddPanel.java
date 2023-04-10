package com.concerto.cams.test.scenarios.configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concerto.cams.test.pageutils.PanelsPageUtils;
import com.concerto.cams.test.pageutils.Homepageutils;
import com.concerto.cams.test.pageutils.LoginPageUtils;
import com.concerto.common.BaseClass;
import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.Asserts;
import com.concerto.common.utilities.ExcelDataProvider;
import com.concerto.db.methods.ConfigurationDBdetails;

public class AddPanel extends BaseClass{

	String ClassName;
	String PackageName;
	LoginPageUtils LoginPageUtils;
	Homepageutils Homepageutils;
	PanelsPageUtils PanelsPageUtils;
	
	@BeforeMethod(alwaysRun=true,groups = { "UI" })
	public void initiateTest() {
		ClassName=this.getClass().getSimpleName();
		PackageName = this.getClass().getPackage().getName();
		LoginPageUtils = new LoginPageUtils();
		Homepageutils= new Homepageutils();
		PanelsPageUtils = new PanelsPageUtils();
		Asserts.verificationErrors = Asserts.verificationErrors.delete(0, Asserts.verificationErrors.length());
		TCName.delete(0, TCName.length());

	}
	
	@Test(description = "TC0001::Validate Add panel for Valid Data",groups = { "UI" },dataProvider="DataReader")
	public void validateAddPanel(String TCNo,String ClientName, String PanelType, String ProjectName, String PanelID,
			String ClientCircle,String SOLID, String ManufacturingID, String State, String City, String Pincode, 
			String SiteAddress, String SiteLocation,String BranchName, String PanelManufacturer, String PanelModel,
			String InstallationVendor, String CRAAgency,
		    String HKAgency, String MSPAgency, String ProjectCoOrdinator, String ProjectLead,String ProjectManager,
		    String TerritoryName, String TerritoryMgrName, String SubscriptionName, String MDNtextNo, String Antenna,
		    String ATM1ID, String ATM2ID, String ATM3ID, String ATM4ID, String ATM5ID, String PanelCurVersion,
		    String ServerPort,String Latitude, String Longitude, String DVRType, String DVRID, String DVRPassword,
		    String DVRPort, String DVRChannelDD,String HDD1Space, String HDD2Space) throws Throwable {
		TCName.append(TCNo);
		boolean status = LoginPageUtils.LaunchCams(Config.APPURL_CAMS);
		Asserts.assertTrue(status, "Launch Page Is Displayed");
		LoginPageUtils.ValidLoginToCams(Config.loginUsername, Config.loginPassword);
		
		/*
		 * Navigate To Panel Screen
		 */		
		Homepageutils.GetPanelPage();
		/**
		 * Panel
		 */
		PanelsPageUtils.navigateToAddPanel();
		PanelsPageUtils.AddPanel(ClientName, PanelType, ProjectName, PanelID, ClientCircle, SOLID, ManufacturingID, 
				State, City, Pincode, SiteAddress, SiteLocation, BranchName, PanelManufacturer, PanelModel, 
				InstallationVendor, CRAAgency, HKAgency, MSPAgency, ProjectCoOrdinator, ProjectLead, 
				ProjectManager, TerritoryName, TerritoryMgrName, SubscriptionName, MDNtextNo, Antenna, 
				ATM1ID, ATM2ID, ATM3ID, ATM4ID, ATM5ID, PanelCurVersion, ServerPort, Latitude, 
				Longitude, DVRType, DVRID, DVRPassword, DVRPort, DVRChannelDD, HDD1Space, HDD2Space);
		LoginPageUtils.Logout();
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("Client_Name"),ClientName,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("PanelType"),PanelType,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("ProjectID"),ProjectName,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("SOLID"),SOLID,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("MfgID"),ManufacturingID,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("StateName"),State,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("CityName"),City,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("Pincode"),Pincode,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("Panel_Address"),SiteAddress,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("Panel_Location"),SiteLocation,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("Panel_Name"),BranchName,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("CompanyName"),PanelManufacturer,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("ATMID1"),ATM1ID,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("MDNNo"),MDNtextNo,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("Antenna"),Antenna,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("DVRUserID"),DVRID,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("DVRPassword"),DVRPassword,"Correct client name is displayed in database");
		Asserts.assertEqual(ConfigurationDBdetails.GetPaneldetails(ClientName, SOLID).get(0).get("DVRPort"),DVRPort,"Correct client name is displayed in database");
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
