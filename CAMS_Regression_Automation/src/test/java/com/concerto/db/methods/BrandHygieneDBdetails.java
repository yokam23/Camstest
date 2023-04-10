package com.concerto.db.methods;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.concerto.common.contsants.Config;
import com.concerto.db.utilities.MsSQLQuery;

public class BrandHygieneDBdetails {
	public static ArrayList<LinkedHashMap<String,String>> GetCameraLocationdetails(String Location) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "Select Location from BrandHygieneLocation where Location = '"+Location+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}

	public static ArrayList<LinkedHashMap<String,String>> GetSurveillanceIndicator(String Indicator) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "Select L.Location,CategoryType,ItemName,p.PriorityType from BrandHygieneChecklist BCL join BrandHygieneLocation L on\r\n" + 
				" BCL.CameraLocationID = L.CameraLocationID Join  \r\n" + 
				"BrandHygienePriority p  on p.PriorityID = BCL.PriorityID join BrandHygieneCategory c on BCL.CategoryID = c.CategoryID where ItemName = '"+Indicator+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}
	
	public static ArrayList<LinkedHashMap<String,String>> GetSiteConfiguration(String SiteID , String ClientName, String ContactName ) throws InstantiationException, IllegalAccessException{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		
		String Query= "Select SL.SiteID, ClientID,ContactName from BrandHygieneSites BS join BrandHygieneSiteLocations SL on BS.SiteID = BS.SiteID Where ContactName = '"+SiteID+"'";
		ArrayList<LinkedHashMap<String,String>> Results = MsSQLQuery.GetQueryResults(Url,DBName, UserName, Password, Query);
	    System.out.println(Results);
		
		return Results;	
	}
}

