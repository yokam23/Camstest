package com.concerto.db.methods;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.concerto.common.contsants.Config;
import com.concerto.db.utilities.MsSQLQuery;

public class InstallationToolDBdetails {
	
	public static ArrayList<LinkedHashMap<String,String>> GetPanelDetails(int Testmode) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select Client_Name,PanelID from panels p join clients c on p.ClientID = c.ClientID  where panel_ip is not Null and PanelType = 'ATM' and testmode = '"+Testmode+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
	} 
	
	public static ArrayList<LinkedHashMap<String,String>> GetPanelDetails(String ClientName,String Panelid) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select TestMode,MfgID from panels p join clients c on p.clientid = c.clientid where panel_ip is not Null and PanelType = 'ATM' AND Client_Name = '"+ClientName+"' and Panelid = '"+Panelid+"'";
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;
	} 
	

}
