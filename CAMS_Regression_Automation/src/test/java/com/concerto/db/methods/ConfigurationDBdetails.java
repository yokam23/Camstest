package com.concerto.db.methods;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.concerto.common.contsants.Config;
import com.concerto.db.utilities.MsSQLQuery;

public class ConfigurationDBdetails { 
	
	public static ArrayList<LinkedHashMap<String,String>> GetClientdetails(String ClientName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "select Client_Name,Pincode,c.CityName,s.StateName from Clients cl join City_Master c on cl.CityID = c.CityID join State_Master s on \r\n" + 
				"s.StateID = cl.StateID where Client_Name =  '"+ClientName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetPaneldetails(String ClientName,String Solid) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "select Client_Name,PanelType,ProjectID,SOLID,p.MfgID,StateName,CityName,p.Pincode,Panel_Address,Panel_Location,Panel_Name,CompanyName,AgencyName,ATMID1,\r\n" + 
				"MDNNo,Antenna,DVRUserID,DVRPassword,DVRPort from panels p join clients c on p.ClientID = c.ClientID join State_Master s on p.StateID = s.StateID\r\n" + 
				"join City_Master city on city.CityID = p.CityID join Manufacturer m on p.PanelMakeID = m.MfgID join AgencyMaster a on a.AgencyID = p.InstAgencyID\r\n" + 
				"where c.Client_Name = '"+ClientName+"'  and SOLID = '"+Solid+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}
	
	public static ArrayList<LinkedHashMap<String,String>> getProjecttemadetails(String memberName,String role) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "select MemberName,p.Role,EmailID from ProjectTeam pt join ProjectTeamRoles p on pt.Role = p.RoleID\r\n" + 
				"where MemberName = '"+memberName+"' and p.Role ='"+role+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetDealerdetails(String DealerName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "Select Dealer_Name,ContactPerson,c.CityName,S.StateName,Dealer_Phone, Dealer_EmailID, Dealer_Mobile,Pincode From Dealers DL join City_Master c on DL.CityID = c.CityID join State_Master s \r\n" + 
				" on S.StateID = DL.StateID where Dealer_Name = '"+DealerName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetCirclesdetails(String CircleName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "Select CircleName from Circles where CircleName = '"+CircleName+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}

}






