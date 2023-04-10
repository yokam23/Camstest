package com.concerto.db.methods;

import com.concerto.common.contsants.Config;
import com.concerto.db.utilities.MsSqlUpdate;

public class LogOutUsers {
	
	public static void LogoutOperator() throws Throwable, Throwable 
	{
		String Url= Config.DBHost;
		String DBName=Config.DBName;
		String UserName = "sa";
		String Password="sqlserver@1";
		String Query1 = "update users set LoginStatus=0 where LoginID like 'operator1'";	
		String Query2 = "update users set LoginStatus=0 where LoginID like 'operator2'";	
		String Query3 = "update users set LoginStatus=0 where LoginID like 'operator3'";	
		String Query4 = "update users set LoginStatus=0 where LoginID like 'operator4'";
		String Query5 = "update users set LoginStatus=0 where LoginID like 'operator5'";
		String Query6 = "update users set LoginStatus=0 where LoginID like 'operator6'";
		String Query7 = "update users set LoginStatus=0 where LoginID like 'operator7'";
		String Query8 = "update users set LoginStatus=0 where LoginID like 'superadmin1'";
		String Query9 = "update users set LoginStatus=0 where LoginID like 'Superadmin2'";
		String Query10 = "update users set LoginStatus=0 where LoginID like 'admin1'";
		String Query11 = "update users set LoginStatus=0 where LoginID like 'Supervisor5'";
		String Query12 = "update users set LoginStatus=0 where LoginID like 'Serviceuser1'";
		String Query13 = "update users set LoginStatus=0 where LoginID like 'Siteuser1'";
		String Query14 = "update users set LoginStatus=0 where LoginID like 'Clientadmin1'";
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query1);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query2);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query3);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query4);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query5);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query6);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query7);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query8);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query9);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query10);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query11);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query12);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query13);
		MsSqlUpdate.Ms_Sql_Update(Url,DBName, UserName, Password, Query14);
	}

}
