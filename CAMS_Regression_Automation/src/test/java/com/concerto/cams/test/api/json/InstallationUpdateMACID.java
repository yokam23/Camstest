package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InstallationUpdateMACID {
	
public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	
	public static String UpdateMACID(String loginId, String clientName, String macId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("macId", macId);
		loginmap.put("sessionId", sessionId);

		String SelectClientJson = gson.toJson(loginmap);
		return SelectClientJson;
	}
	
}