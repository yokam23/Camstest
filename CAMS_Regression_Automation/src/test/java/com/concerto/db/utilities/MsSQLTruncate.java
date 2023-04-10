package com.concerto.db.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MsSQLTruncate {
	
	public static void Ms_Sql_Truncate(String Url,String DBName, String UserName,String password,String TableName) {
		
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("net.sourceforge.jtds.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:jtds:sqlserver://"+Url+";databaseName="+DBName, UserName, password);
		      stmt = conn.createStatement();
		      stmt.executeUpdate("TRUNCATE TABLE "+TableName);
		      System.out.println("Successfully Connected to the database!");
		   }catch(SQLException se){	      
		      se.printStackTrace();
		   }catch(Exception e){	      
		      e.printStackTrace();
		   }finally{	      
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		}

}
