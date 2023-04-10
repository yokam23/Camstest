package com.concerto.db.methods;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.concerto.common.contsants.Config;
import com.concerto.db.utilities.MsSQLQuery;

public class HouseKeepingDBdetails {
	
	public static ArrayList<LinkedHashMap<String,String>> GetHKPoolDetails(String Clientname,String Poolname) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select c.Client_Name,hk.PoolName from hkpool hk join Clients c on hk.ClientID = c.ClientID where poolname = '"+Poolname+"'  and Client_Name = '"+Clientname+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetHKAllocateSiteDetails(String Clientname,String Poolname) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select hk.SOLID,hk.CameraNo from HKPoolAllocation hk join hkpool p on hk.HKPoolID = p.HKPoolID join clients c on p.ClientID = c.ClientID where poolname = '"+Poolname+"' and Client_Name = '"+Clientname+"' order by panelid";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetHKSchedulerDetails(String Clientname,String Poolname) throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select hkp.PoolName,c.Client_Name,TimeFrom,TimeTo from HKScheduler hks join HKPool hkp on hks.HKPoolID = hks.HKPoolID join clients c on hkp.ClientID = c.ClientID\r\n" + 
				"where hkp.PoolName = '"+Poolname+"'and Client_Name = '"+Clientname+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		
		System.out.println(Results);
		
		return Results;
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetHKReportPanels(String PoolName) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query = "select PanelID,StatusName from HKMonitoring hk join HKStatus s on hk.StatusID = s.StatusID join HKPool pool on hk.HKPoolID = pool.HKPoolID where PoolName = '"+PoolName+"' order by PanelID asc ";
		
         ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
		// System.out.println(Results);
		
		 return Results;
	}


}
