package com.concerto.db.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MsSQLQuery {
	
	public static ArrayList<LinkedHashMap<String,String>> GetQueryResults(String Url,String DBName,String UserName, String Password,String Query) throws InstantiationException,
	IllegalAccessException {
	ArrayList<LinkedHashMap<String,String>> AllRows = new ArrayList<>();	
	try {
	Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
	System.out.println("driver loaded...");
	} catch (ClassNotFoundException e) {
	System.out.println("Error in loading the driver..." + e);
	System.exit(0);
	}
	try {
	Connection dbConnection = DriverManager
	        .getConnection("jdbc:jtds:sqlserver://"+Url+"/"+DBName, UserName, Password);
	System.out.println("Connection successful...");
	Statement statement = dbConnection.createStatement();
	    ResultSet resultSet= statement.executeQuery(Query);
	    
	    int ColCount=resultSet.getMetaData().getColumnCount();
			 while (resultSet.next()){
				 LinkedHashMap<String,String> rowsData= new LinkedHashMap<String,String>();
				 for (int i=1;i<=ColCount;i++) {
					 try {
					 rowsData.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i).toString());
					 }catch(NullPointerException e) {
							 rowsData.put(resultSet.getMetaData().getColumnName(i), "null");
					 }
				 }
				 AllRows.add(rowsData);
			 }
			 try {
				 if(dbConnection!=null) {
					 dbConnection.close();
				 }
			 }catch(SQLException se) {
				 se.printStackTrace();
			 }
			 
	} catch (SQLException e) {
	System.out.println("database-ConnectionError: " + e);
	System.exit(0);
	}
	return AllRows;
	}

}
