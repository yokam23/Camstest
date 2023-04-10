package com.concerto.common.utilities;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;

import org.testng.annotations.Test;

import com.concerto.common.contsants.Config;

public class ReadMail {
	
	  public static String checklastthirtymails(String host, String storeType, String user,
		      String password,String Key) 
		   {
		  Message[] messages=null;
		  String Body=null;
		      try {

		      //create properties field
		      Properties properties = new Properties();

		      properties.put("mail.pop3.host", host);
		      properties.put("mail.pop3.port", Config.port);
		      properties.put("mail.pop3.starttls.enable", "true");
		      Session emailSession = Session.getDefaultInstance(properties);
		  
		      //create the POP3 store object and connect with the pop server
		      Store store = emailSession.getStore("pop3");

		      store.connect(host, user, password);

		      //create the folder object and open it
		      Folder emailFolder = store.getFolder("INBOX");
		      emailFolder.open(Folder.READ_ONLY);
		      
		      Message[] Selectedmessage=new Message[30];
		      System.out.println(emailFolder.getMessageCount());
	            messages = emailFolder.getMessages(emailFolder.getMessageCount()-29, emailFolder.getMessageCount());
	            int count=0;
	            for(Message messageSelect:messages) {
	            	try {
                        if (messageSelect.getSubject().contains(Key)) {
                        	Selectedmessage[count]=messageSelect;
//                        	System.out.println(messageSelect.getContent().toString());
                        	
                        }
	            }catch(Exception e) {
	            	e.printStackTrace();
	            }
	            	count++;
	            }
//		      System.out.println("messages.length---" + messages.length);

		       Message NewMessage= Selectedmessage[Selectedmessage.length-1];
		      Body= NewMessage.getContent().toString();

		      //close the store and folder objects
		      emailFolder.close(false);
		      store.close();

		      } catch (NoSuchProviderException e) {
		         e.printStackTrace();
		      } catch (MessagingException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      return Body;
		   }

	
	  public static String check(String host, String storeType, String user,
		      String password,String Key) 
		   {
		  Message[] messages=null;
		  String Body=null;
		      try {

		      //create properties field
		      Properties properties = new Properties();

		      properties.put("mail.pop3.host", host);
		      properties.put("mail.pop3.port", "110");
		      properties.put("mail.pop3.starttls.enable", "true");
		      Session emailSession = Session.getDefaultInstance(properties);
		  
		      //create the POP3 store object and connect with the pop server
		      Store store = emailSession.getStore("pop3");

		      store.connect(host, user, password);

		      //create the folder object and open it
		      Folder emailFolder = store.getFolder("INBOX");
		      emailFolder.open(Folder.READ_ONLY);

		      SearchTerm searchCondition = new SearchTerm() {
	                @Override
	                public boolean match(Message message) {
	                    try {
	                        if (message.getSubject().contains(Key)) {
	                            return true;
	                        }
	                    } catch (MessagingException ex) {
	                        ex.printStackTrace();
	                    }
	                    return false;
	                }
	            };
 
		      // retrieve the messages from the folder in an array and print it
		      messages = emailFolder.search(searchCondition);
		      System.out.println("messages.length---" + messages.length);

		      Message message = messages[messages.length-1];
		      Body= message.getContent().toString();
/*		      for (int i = 0, n = messages.length; i < n; i++) {
		         Message message = messages[i];
		         System.out.println("---------------------------------");
		         System.out.println("Email Number " + (i + 1));
		         System.out.println("Subject: " + message.getSubject());
		         System.out.println("From: " + message.getFrom()[0]);
		         System.out.println("Text: " + message.getContent().toString());

		      }*/

		      //close the store and folder objects
		      emailFolder.close(false);
		      store.close();

		      } catch (NoSuchProviderException e) {
		         e.printStackTrace();
		      } catch (MessagingException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      return Body;
		   }
/*
		   public static String ReturnPaymentLinkUrl() throws Throwable, Throwable {

		      String host = "pop01.concertosoft.com";// change accordingly
		      String mailStoreType = "pop3";
		      String username = "sonal.borge@concertosoft.com";// change accordingly
		      String password = "SonalDeven@2122";// change accordingly
		      String Key= "UrwayMerchant";
		      
		     String Body = check(host, mailStoreType, username, password,Key);
		      
		      String Link = Body.split("Payment Link Id :<a href='")[1].split("'>")[0];
		      System.out.println(Link);
		      return Link;
		   }*/
		  
		   public static String ReturnPaymentLinkUrl() throws Throwable, Throwable {

			      String host = Config.host;// change accordingly
			      String mailStoreType = Config.mailStoreType;
			      String username = Config.mailusername;// change accordingly
			      String password = Config.mailpassword;// change accordingly
			      String Key= "UrwayMerchant";
			      
			     String Body = checklastthirtymails(host, mailStoreType, username, password,Key);
			     System.out.println(Body);
			      String Link = Body.split("Payment Link Id :<a href='")[1].split("'>")[0];
			      System.out.println(Link);
			      return Link;  
			   }

}
