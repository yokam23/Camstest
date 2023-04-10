package com.concerto.cams.readerutils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPRequest {
	
	public static void sendTCPReq(String ReaderIp,int ReaderPort,byte[] Request) throws Throwable {
		   Socket clientSocket = new Socket("10.10.10.212", 5558);  
		   OutputStream outToServer = clientSocket.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.write(Request);
        out.flush();
        
     
            BufferedReader fromServer = 
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())); 
            String line = "";
            System.out.println("Client received: ");
            while ((line = fromServer.readLine()) != null) {
                System.out.println(line);
                                   if(!line.isEmpty()) {
             	   if(line.contains("BACK")) {
 //            		   fail;
             	   }else{
//             		   Failure = true;
             	   }
                }
            }
        clientSocket.close();
	}

}
