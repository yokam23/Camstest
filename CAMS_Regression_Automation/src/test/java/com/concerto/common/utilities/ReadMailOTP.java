package com.concerto.common.utilities;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;

public class ReadMailOTP 
{
	

		   public static String ReturnPaymentLinkUrl() throws Throwable, Throwable {
			   String Link =null;
			   for(int i=0;i<5;i++) {
				   try {
			   Thread.sleep(5000);
		      String host = "pop01.concertosoft.com";// change accordingly
		      String mailStoreType = "pop3";
		      String username = "sonal.borge@concertosoft.com";// change accordingly
		      String password = "SonalDeven@2122";// change accordingly
		      String Key= "Login";
		      
		     String Body = ReadMail.checklastthirtymails(host, mailStoreType, username, password,Key);
		      
		      Link = Body.split("OTP is :<B>")[1].split("</B>")[0];
		      System.out.println(Link);
				   }catch(Exception e1) {
					   continue;
				   }
			   }
				   
		      return Link;
		   }		   

}
