package com.concerto.common.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.testng.annotations.Test;

import com.concerto.common.utilities.FileHandler;

public class SFTPUtils {
	

	 public static void SendFile(String remoteIP,String username,String Password,
			 String filepath, String Destination,String firstRemoteFile) throws Throwable {
	        FTPClient ftpClient = new FTPClient();
	        try {
	 
	            ftpClient.connect(remoteIP, 21);
	            ftpClient.login(username, Password);
	            ftpClient.enterLocalPassiveMode();
	 
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	            // APPROACH #1: uploads first file using an InputStream
	            File firstLocalFile = new File(filepath);
	 
	            InputStream inputStream = new FileInputStream(firstLocalFile);
	 
	            System.out.println("Start uploading first file");
	            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
	            inputStream.close();
	            if (done) {
	                System.out.println("Config file is uploaded successfully.");
	                RemoteSysUtils.MoveFile();
	            }

	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	 }
	 
	
	 public static void ftpTimeFile(String remoteIP,int port,String username,String Password,
			 String filepath, String Destination) {
	        FTPClient ftpClient = new FTPClient();
	        try {
	 
	            ftpClient.connect(remoteIP, port);
	            ftpClient.login(username,Password);
	            ftpClient.enterLocalPassiveMode();
	 
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	            // APPROACH #1: uploads first file using an InputStream
	            File firstLocalFile = new File(FileHandler.getFullFilePath(filepath));
	 
	            String firstRemoteFile = Destination;
	            InputStream inputStream = new FileInputStream(firstLocalFile);
	 
	            System.out.println("Start uploading first file");
	            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
	            inputStream.close();
	            if (done) {
	                System.out.println("Config file is uploaded successfully.");
	            }
	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
		 
	 }
	 

}
