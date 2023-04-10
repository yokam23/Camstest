 package com.concerto.db.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MsSQLDeleteFromWhere {
	
	public static void Ms_Sql_DeleteFromWhere(String Url,String DBName,String UserName,String password,String DeleteFromWhere) {
		
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("net.sourceforge.jtds.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:jtds:sqlserver://"+Url+"/"+DBName, UserName, password);
		      stmt = conn.createStatement();
		      stmt.executeUpdate(DeleteFromWhere);
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
