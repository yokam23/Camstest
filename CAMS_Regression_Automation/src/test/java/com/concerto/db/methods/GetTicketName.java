package com.concerto.db.methods;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.concerto.common.contsants.Config;
import com.concerto.db.utilities.MsSQLQuery;

public class GetTicketName {
	
	public static ArrayList<LinkedHashMap<String,String>> GetTicket(String PanelId,String ZoneNo) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		String Query = "Select top 1 TicketNo,Ticket_Status,AssignOperator,Comments from TicketTransaction where PanelID='"+PanelId+"' and ZoneNo='"+ZoneNo+"' order by Added_Date";		
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetADStatus(String TicketNo) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		String Query = "Select * from ADQueue where TicketNo='"+TicketNo+"'";		
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetADImageStatus(String TicketNo) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		String Query = "Select * from ADImage where TicketID='"+TicketNo+"'";		
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	
	public static ArrayList<LinkedHashMap<String,String>> GetUserTicket(String PanelId,String ZoneNo,String user) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		String Query = "Select top 1 TicketNo from TicketTransaction where PanelID='"+PanelId+"' and ZoneNo='"+ZoneNo+"' and AssignOperator='"+user+"' order by Added_Date";		
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	
	public static ArrayList<LinkedHashMap<String,String>> GetTicketDetails(String TicketNo) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		String Query = "Select ActivityID,ZoneNo,PanelID,SOLID,Ticket_Status from TicketTransaction where TicketNo='"+TicketNo+"'";		
		
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	
	
}
