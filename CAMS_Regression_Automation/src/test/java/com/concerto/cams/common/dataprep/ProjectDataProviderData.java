package com.concerto.cams.common.dataprep;

import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.DataProviderWriter;
import com.concerto.common.utilities.DateTimeFunctions;


public class ProjectDataProviderData {
	
	public static void SetDataProviderDataFeeProfile() throws Throwable {
//		int i;
		String Date= DateTimeFunctions.GenerateRandom();
		int number = DateTimeFunctions.Randomnumber();
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCity", 1,"Cityname", "Sydney"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCity", 2,"Cityname", "Sydney"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCity", 4,"Cityname", "New York"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditCity", 1,"CityName", "Auckland"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteCity", 1,"Searchtext", "New York"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditCity", 1,"Searchtext", "Sydney"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddNationalHoliday", 1,"Holidayname", "Holi"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddNationalHoliday", 2,"Holidayname", "Holi"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddNationalHoliday", 4,"Holidayname", "Independance day"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddNationalHoliday", 5,"Holidayname", "Easter day"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditNationalHoliday", 1,"Holidayname", "Christmas"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditNationalHoliday", 1,"Searchtxt", "Holi"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteNationalHolidayDetails", 1,"Searchtxt", "Easter day"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 1,"comment", "No response from customer care"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 2,"comment", "Customer feedback"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 3,"comment", "Branch closed till lockdown"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 4,"comment", "No response from customer care"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 5,"comment", "Customer feedback"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 6,"comment", "Branch closed till lockdown"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 7,"comment", "No response from support center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 8,"comment", "Need customer feedback"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 9,"comment", "Branch will open in may"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 13,"comment", "No response from support center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 14,"comment", "Need customer feedback"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddOperatorCmnt", 15,"comment", "Branch will open in may"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditOperatorCmt", 1,"comment", "No response from customer service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditOperatorCmt", 2,"comment", "Branch will open in next year"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditOperatorCmt", 3,"comment", "No feedback from customer"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteOperatorCmt", 1,"Searchtxt", "No response from support center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteOperatorCmt", 2,"Searchtxt", "Need customer feedback"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteOperatorCmt", 3,"Searchtxt", "Branch will open in may"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSensors", 1,"Sensortype", "CCTV21Switch"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSensors", 2,"Sensortype", "CCTV21Switch"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSensors", 4,"Sensortype", "MainACSwitch"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditSensorDetails", 1,"Sensortype", "CCTV21Switch"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteSensordetails", 1,"Searchtxt", "MainACSwitch"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 1,"companyName", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 2,"companyName", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 6,"companyName", "TestHikVision"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 5,"companyName", "TestCamera"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 7,"companyName", "TestRass"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 8,"companyName", "TestSecurico"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 9,"companyName", "Dolphin"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 10,"companyName", "TestWD"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddManufacturer", 11,"companyName", "TestDlink"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditManufacturer", 1,"companyName", "HikCamera"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditManufacturer", 1,"Searchtxt", "TestCamera"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteManufacturer", 1,"CompanyName", "HikCamera"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 1,"GenericName", "Analogue camera Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 2,"GenericName", "Analogue camera Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 3,"GenericName", "Analogue camera Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 4,"GenericName", "Analogue camera Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 5,"GenericName", "Generic Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 6,"GenericName", "Test DVR NVR"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 7,"GenericName", "Intrusion Alarm Panel Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 8,"GenericName", "Back Room Door"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 9,"GenericName", "Dolphin"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 10,"GenericName", "Test HardDisk"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 11,"GenericName", "TestDellRouter"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 1,"Manufacturer", "Jio"+Date);
	    DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 4,"Manufacturer", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 3,"Manufacturer", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 2,"Manufacturer", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 5,"Manufacturer", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 6,"Manufacturer", "TestHikVision"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 7,"Manufacturer", "TestRass"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 8,"Manufacturer", "TestSecurico"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 9,"Manufacturer", "Dolphin"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 10,"Manufacturer", "TestWD"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMakeModel", 11,"Manufacturer", "TestDlink"+Date);

		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddDispatchVendor", 1,"CompanyName", "Logistic service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddDispatchVendor", 2,"CompanyName", "Logistic service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddDispatchVendor", 3,"CompanyName", "Cosmos service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddDispatchVendor", 5,"CompanyName", "Dispatch service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditDispatchVendor", 1,"CompanyName", "Logistic service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteDispatchVendor", 1,"Searchtxt", "Dispatch service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanelServiceVendor", 1,"CompanyName", "Control Panel service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanelServiceVendor", 2,"CompanyName", "Control Panel service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanelServiceVendor", 3,"CompanyName", "Control Panel service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanelServiceVendor", 4,"CompanyName", "Panel service centre"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanelServiceVendor", 5,"CompanyName", "Dispatch service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditPanelServiceVendor", 1,"CompanyName", "Control Panel service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeletePanelServiceVendor", 1,"Searchtxt", "Dispatch service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddShift", 1,"Shiftname", "FirstShift"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddShift", 2,"Shiftname", "FirstShift"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddShift", 4,"Shiftname", "SecondShift"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditShift", 1,"Shiftname", "ThirdShift"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditShift", 1,"Searchtxt", "FirstShift"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteShift", 1,"Searchtxt", "SecondShift"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCRAAgency", 1,"CompanyName", "CRA service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCRAAgency", 2,"CompanyName", "CRA service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCRAAgency", 3,"CompanyName", "CRA service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCRAAgency", 4,"CompanyName", "Agency"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCRAAgency", 5,"CompanyName", "Test service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditCRAAgency", 1,"CompanyName", "CRA service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteCRAAgency", 1,"Searchtxt", "Test service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKAgency", 1,"CompanyName", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKAgency", 2,"CompanyName", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKAgency", 3,"CompanyName", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKAgency", 5,"CompanyName", "House keeping service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditHKdetails", 1,"CompanyName", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteHKdetails", 1,"Searchtxt", "House keeping service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMSPAgency", 1,"CompanyName", "MSP Agency"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMSPAgency", 2,"CompanyName", "MSP Agency"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMSPAgency", 3,"CompanyName", "MSP Agency"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddMSPAgency", 5,"CompanyName", "MSP service center"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditMSPAgency", 1,"Companyname", "MSP Agency"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteMSPAgency", 1,"Searchtxt", "MSP service center"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddQRTAgency", 1,"CompanyName", "QRT Pvt Ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddQRTAgency", 2,"CompanyName", "QRT Pvt Ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddQRTAgency", 3,"CompanyName", "QRT Pvt Ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddQRTAgency", 4,"CompanyName", "QRT Pvt Ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddQRTAgency", 5,"CompanyName", "QRT service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditQRTdetails", 1,"CompanyName", "QRT Pvt Ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteQRTdetails", 1,"Searchtxt", "QRT service"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddNetworkProvider", 1,"AgencyName", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddNetworkProvider", 2,"AgencyName", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddNetworkProvider", 4,"AgencyName", "Idea"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditNetworkProvider", 1,"AgencyName", "Dolphin"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditNetworkProvider", 1,"Searchtxt", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteNetworkProvider", 1,"Searchtxt", "Idea"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddInstallationPartner", 1,"CompanyName", "Installation partner center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddInstallationPartner", 2,"CompanyName", "Installation partner center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddInstallationPartner", 3,"CompanyName", "Installation partner center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddInstallationPartner", 5,"CompanyName", "Dummy Test center"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditInstallationPartner", 1,"CompanyName", "Installation partner center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteInstallationPartner", 1,"Searchtxt", "Dummy Test center"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddEscalationDetails", 1,"Templatename", "Dummy Template"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddEscalationDetails", 2,"Templatename", "Dummy Template"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddEscalationDetails", 3,"Templatename", "Dummy Template"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddEscalationDetails", 4,"Templatename", "Template"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddEscalationDetails", 5,"Templatename", "TestTemplate"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditEscalationdetails",1,"Templatename", "Dummy Template"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteEscalationDetails", 1,"Templatename", "TestTemplate"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddServicePartner",1,"CompanyName", "Service Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddServicePartner",2,"CompanyName", "Service Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddServicePartner",3,"CompanyName", "Service Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddServicePartner",5,"CompanyName", "Service Dummy Test"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditServicePartner",1,"CompanyName", "Service Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteServicePartner",1,"Searchtxt", "Service Dummy Test"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSubscription",1,"SubscriptionName", "Sub"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSubscription",2,"SubscriptionName", "Sub"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSubscription",3,"SubscriptionName", "Sub"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSubscription",4,"SubscriptionName", "Sub"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSubscription",5,"SubscriptionName", "Test"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditSubscription",1,"Searchtxt", "Sub"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteSubscription",1,"Searchtxt", "Test"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddTerritory",1,"TerritoryName", "EastTerritory"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddTerritory",2,"TerritoryName", "EastTerritory"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddTerritory",3,"TerritoryName", "WestTerritory"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddTerritory",4,"TerritoryName", "SouthTerritory"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddTerritory",5,"TerritoryName", "EastTerritory"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddTerritory",6,"TerritoryName", "NorthTerritory"+Date);
        
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditTerritoryManager",1,"TerritoryName", "NorthTerritory"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditTerritoryManager",1,"Searchtxt", "EastTerritory"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteTerritory",1,"searchtext", "SouthTerritory"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKPool",1,"PoolName", "TestPool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKPool",2,"PoolName", "TestPool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKPool",4,"PoolName", "ABC"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKPool",5,"PoolName", "Dummy"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddHKPool",6,"PoolName", "TestPool20"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditHKPool",1,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditHKPool",1,"Searchtxt", "TestPool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteHKPool",1,"PoolName", "ABC"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AllocateSite",1,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AllocateSite",2,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AllocateSite",3,"PoolName", "Test12Pool"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "SwitchSite",1,"PoolName", "Dummy"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "SwitchSite",1,"SwitchPool", "TestPool20"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "SwitchSite",2,"PoolName", "Dummy"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSchedule",1,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSchedule",2,"PoolName", "TestPool20"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditHKSchedule",1,"PoolName", "TestPool20"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteHkschedule",1,"PoolName", "TestPool20"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "HKMonitoring",1,"PoolName", "TestPool20"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "HKMonitoring",2,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "HKMonitoring",3,"PoolName", "Test12Pool"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "HKReport",1,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "HKReport",2,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "HKReport",3,"PoolName", "Test12Pool"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeallocateMonitoredSites",1,"PoolName", "Test12Pool"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeallocateMonitoredSites",2,"PoolName", "Test12Pool"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateMFG",1,"MFGID", "95874A"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateMFG",2,"MFGID", "95874A"+Date);
		
		/*DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCircle", 1,"CircleName", "Circle"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateCircle", 1,"CircleName", "Circles"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddAtm", 1,"CircleName", "Circles"+Date);
	*/
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCircle", 1,"CircleName", "C8"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCircle", 2,"CircleName", "C9"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCircle", 1,"ClientName", "Client"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCircle", 2,"ClientName", "Client"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateCircle", 1,"CircleName", "C1"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateCircle", 1,"SearchCircle", "C9"+Date);
				
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteCircle", 1,"SearchCircle", "C9"+Date);

		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddClient", 1,"Client", "Yogesh"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddClient", 2,"Client", "TestClient"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddClient", 1,"ClientCircle", "TestC"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddClient", 2,"ClientCircle", "TestD"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddClient", 1,"Subscription", "Sub"+Date);
				
				
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateClient", 1,"ClientName", "Client"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateClient", 1,"Searchtxt", "Yogesh"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteClient", 1,"Searchtxt", "TestClient"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Client Name", "Client"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Project Name", "Test ABC"+Date);
		/*DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Sensor Manufacturer", "Test ABC"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Camera Manufacturer", "Test ABC"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Sensor Manufacturer", "TestSecurico"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Camera Manufacturer", "Jio"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"DVR Manufacturer Name", "TestHikVision"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Router Manufacturer Name", "TestDlink"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"HDD Manufacturer Name", "TestWD"+Date);
		*/
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Network Provider", "Dolphin"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProject", 1,"Template ", "Dummy Template"+Date);
				
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProjectTeam", 1,"Member Name", "Yogesh"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProjectTeam", 2,"Member Name", "TestLead"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProjectTeam", 3,"Member Name", "TestCoordinator"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddProjectTeam", 4,"Member Name", "LeadTest"+Date);
				
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateProjectTeam", 1,"Member", "Yogesh"+Date);
				
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteProjectTeam", 1,"SearchProjectTeam", "LeadTest"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddDealer", 1,"DealerName", "YogeshKam"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddDealer", 2,"DealerName", "TestDealer"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateDealer", 1,"DealerName", "DealerTest"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdateDealer", 1,"SearchText", "YogeshKam"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteDealer", 1,"SearchDealer", "TestDealer"+Date);
		
		for(int i=1;i<=22;i++) {
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ClientName", "Client"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ProjectName", "Test ABC"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"PanelID", "2"+(number+i));
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ClientCircle", "TestC"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"SOLID", "A2"+(number+i));
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ManufacturingID", (number+i)+""+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"City", "Auckland"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"PanelManufacturer", "TestRass"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"InstallationVendor", "Installation partner center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"CRAAgency", "CRA service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"HKAgency", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"MSPAgency", "MSP Agency"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ProjectCoOrdinator", "TestCoordinator"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ProjectLead", "TestLead"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ProjectManager", "Yogesh"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"TerritoryName", "NorthTerritory"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"SubscriptionName", "Sub"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"MDNtextNo", "365214"+(number+i));
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"DVRType", "TestHikVision"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddPanel", i,"ATM1ID", "1"+(number+i));
		}
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "UpdatePanel", 1,"Panelid", "A2"+(number+1));
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeletePanel", 1,"Panelid", "A2"+(number+22));
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 1,"Searchtxt", "Auckland"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 2,"Searchtxt", "CCTV21Switch"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 3,"Searchtxt", "TestHikVision"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 4,"Searchtxt", "CRA service"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 5,"Searchtxt", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 6,"Searchtxt", "MSP Agency"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 7,"Searchtxt", "Dolphin"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 8,"Searchtxt", "Installation partner center"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 9,"Searchtxt", "NorthTerritory"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteUsedRecords", 10,"Searchtxt", "Sub"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCameraLocation", 1,"CameraLocation", "Front door1"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddCameraLocation", 2,"CameraLocation", "AC Room"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditCameraLocation", 1,"CameraLocation", "Front door2"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditCameraLocation", 1,"Searchtxt", "Front door1"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteCameraLocation", 1,"Location", "AC Room"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSurveillanceIndicator", 1,"Indicator", "Front door are opened"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSurveillanceIndicator", 1,"Camera location", "Front door2"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSurveillanceIndicator", 2,"Camera location", "Front door2"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSurveillanceIndicator", 2,"Indicator", "Are Desk clean"+Date);
		
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 1,"ClientName", "Client"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditSurveillanceIndicator", 1,"Indicator", "Front door are opened"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteSurveillanceIndicator", 1,"Indicator", "Are Desk clean"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 1,"SiteID", "A1"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 2,"SiteID", "A1"+(number+1));
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 1,"HKAgency", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 2,"HKAgency", "HK management pvt ltd"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditSiteConfiguration", 1,"SiteId", "A1"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteSiteConfiguration", 1,"Siteid","A1"+(number+1));
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "EditSiteConfiguration", 1,"Username", "Clientadmin"+number);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "DeleteSiteConfiguration", 1,"Username","Clientadmin"+number);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 1,"Location", "Front door2"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 1,"ClientName", "Client"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 2,"ClientName", "Client"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 1,"Username", "Clientadmin"+number);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "AddSiteConfiguration", 2,"Username", "Clientadmin"+number);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewScheduledMonitoring", 1,"SiteID", "A1"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewScheduledMonitoring", 1,"Location", "Front door2"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewScheduledMonitoring", 1,"ClientName", "Client"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewLatestMonitoring", 1,"SiteID", "A1"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewLatestMonitoring", 1,"Location", "Front door2"+Date);
		//DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewLatestMonitoring", 1,"ClientName", "Client"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewOfficeMonitoringReport", 1,"SiteID", "A1"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ViewOfficeMonitoringReport", 1,"Location", "Front door2"+Date);
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "Adduser", 1,"Username", "operator"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "Adduser", 2,"Username", "Clientadmin"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "Adduser", 1,"Loginid", "operator"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "Adduser", 2,"Loginid", "Clientadmin"+number);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "Adduser", 1,"CircleName", "C8"+Date);
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "Adduser", 2,"CircleName", "Client"+Date);
		
		for(int i=1;i<=20;i++) {
			DataProviderWriter.setTestData(Config.DataProvider_File_Path, "TestToQuality", i,"PanelID", "A2"+(number+i)+"-Test");
			DataProviderWriter.setTestData(Config.DataProvider_File_Path, "TestToQuality", i,"Select Client", "Client"+Date+"-Active");
			DataProviderWriter.setTestData(Config.DataProvider_File_Path, "TestToQuality", i,"SelectCircle", "C8"+Date);			
		}
		
		for(int i=1;i<=20;i++) {
			DataProviderWriter.setTestData(Config.DataProvider_File_Path, "QualityToLive", i,"PanelID", "A2"+(number+i)+"-Quality");
			DataProviderWriter.setTestData(Config.DataProvider_File_Path, "QualityToLive", i,"Select Client", "Client"+Date+"-Active");
			DataProviderWriter.setTestData(Config.DataProvider_File_Path, "QualityToLive", i,"SelectCircle", "C8"+Date);			
		}
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "LiveToService", 1,"Select Client", "Client"+Date+"-Active");
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "LiveToService", 1,"PanelID", "A2"+(number+19)+"-Live");
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "LiveToService", 1,"SelectCircle", "C8"+Date);			
		
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ServiceTolive", 1,"Select Client", "Client"+Date+"-Active");
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ServiceTolive", 1,"PanelID", "A2"+(number+19)+"-Service");
		DataProviderWriter.setTestData(Config.DataProvider_File_Path, "ServiceTolive", 1,"SelectCircle", "C8"+Date);			
		
	}	
}