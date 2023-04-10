package com.concerto.db.methods;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.concerto.common.contsants.Config;
import com.concerto.db.utilities.MsSQLQuery;

public class MasterDBDetails {
	
	public static ArrayList<LinkedHashMap<String,String>> GetCityDetails(String CityName) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		String Query = "Select a.CityName,b.StateName,b.CountryName, b.Region from City_Master a, \r\n" + 
				"		State_Master b where a.CityName='"+CityName+"' and a.StateID=b.StateID ";	
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String, String>> GetTerritoryDetails(String TerritoryName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "SELECT TerritoryName,TerritoryManager,EmailID,MobileNo FROM TerritoryMaster where TerritoryName = '"+TerritoryName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
		
	}
	
	public static ArrayList<LinkedHashMap<String, String>> GetEscalationDetails(String TemplateName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select TemplateName,Contact_Person,Tel_No,Cell_No,EmailID,Priority,Interval,RepeatInterval from Escallation_Master where TemplateName = '"+TemplateName+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetSubscriptionDetails(String Subscription) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select SubName,SMS_Cnt,Phone_Cnt,Email_Cnt,Repeat,VideoConfirmation from Subscription where SubName = '"+Subscription+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetHolidayDetails(String HolidayName) throws InstantiationException, IllegalAccessException
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select HolidayName,HDate from HolidayMaster where HolidayName = '"+HolidayName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetCommentDetails(String Comment) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "select Comments from Comments where comments = '"+Comment+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
		
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetSensorDetails(String SensorName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "select SensorType,CompanyName,RestoralType,Alarm,AlertPriority,Alarm_SMS_Message,Restore_SMS_Message,\r\n" + 
				"Alarm_Email_Subject,Restore_Email_Subject,Alarm_Email_Message,Restore_Email_Message from SensorsMaster sm join Manufacturer m\r\n" + 
				"on sm.PanelManfgID=m.MfgID where SensorType = '"+SensorName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
		
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetDispactvendorsDetails(String CompanyName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select CompanyName,CompanyAddress,PhoneNo,MobileNo,ContactPerson,CityName,StateName,EmailID from servicevendors s join City_Master c on s.CityID= c.CityID join State_Master state on s.StateID = state.StateID\r\n" + 
				"  where CompanyName = '"+CompanyName+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
	} 
	
	public static ArrayList<LinkedHashMap<String,String>> GetManufacturerDetails(String Devicetype, String CompanyName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query="select DeviceTypeName,CompanyName,m.DeviceTypeID from Manufacturer m right join DeviceType d on \r\n" + 
				"m.DeviceTypeID = d.DeviceTypeID\r\n" + 
				"where DeviceTypeName = '"+Devicetype+"'and CompanyName ='"+CompanyName+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetMakeModelDetails(String GenericName,String DeviceTypeName,String CompanyName) throws InstantiationException, IllegalAccessException{
		
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select GenericName,CompanyName,ModelName,DeviceVersion,DeviceValue,DeviceTypeName from Make_Model mm join Manufacturer m on mm.DeviceTypeID = m.DeviceTypeID join DeviceType d on m.DeviceTypeID = d.DeviceTypeID where GenericName = '"+GenericName+"' and DeviceTypeName ='"+DeviceTypeName+"' and CompanyName ='"+CompanyName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
		
	}
	

	
	public static ArrayList<LinkedHashMap<String,String>> GetAgencyDetails(String AgencyName,String AgencyType) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select AgencyName,AgencyType,AgencyAddress,CityName,s.StateName,Pincode,ContactPerson,PhoneNo,MobileNo,EmailID\r\n" + 
				" from AgencyMaster a join City_Master c \r\n" + 
				"on a.CityID= c.CityID join State_Master s on \r\n" + 
				"c.StateID = s.StateID where AgencyType = '"+AgencyType+"'and AgencyName = '"+AgencyName+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;

	}
	
	public static  ArrayList<LinkedHashMap<String,String>> GetNetworkProviderDetails(String AgencyName,String AgencyType) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select AgencyType,AgencyName from AgencyMaster where AgencyType = '"+AgencyType+"' and AgencyName ='"+AgencyName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;

	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetMSPVendorDetails(String CompanyName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
	    String Query = "select CompanyName,CompanyAddress,CityName,StateName,PinCode,MobileNo,EmailID,ContactPerson,PhoneNo,MobileNo from MSPVendors m join City_Master c on m.CityID = c.CityID join State_Master s on \r\n" + 
	    		"s.StateID = c.StateID where CompanyName = '"+CompanyName+"'";	
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;

	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetPanelServiceVendorDetails(String CompanyName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select CompanyName,CompanyAddress,StateName,CityName,PinCode,ContactPerson,PhoneNo,MobileNo,EmailID\r\n" + 
				"  from PanelServiceVendors p join City_Master c\r\n" + 
				"  on p.CityID = c.CityID join State_Master s on \r\n" + 
				"  p.StateID = s.StateID\r\n" + 
				"  where CompanyName = '"+CompanyName+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;

	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetShiftDetails(String ShiftName) throws InstantiationException, IllegalAccessException{
		
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select ShiftName,TimeFrom,TimeTo from ShiftMaster where Shiftname ='"+ShiftName+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;

	}
}
