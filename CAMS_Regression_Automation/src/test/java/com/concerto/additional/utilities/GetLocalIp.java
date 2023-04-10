package com.concerto.additional.utilities;

import java.net.InetAddress;

import org.testng.annotations.Test;

public class GetLocalIp {
	

    public static String GetIp() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String IPAddress = inetAddress.getHostAddress();
        return IPAddress;
    }

}
