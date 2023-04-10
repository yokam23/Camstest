package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InstallationSelectClient {
	
	public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	
	public static String SelectClient(String loginId, String clientName, String sessionId) {
		HashMap<String,Object> ClinetMap= new HashMap<String,Object>();
		ClinetMap.put("loginId", loginId);
		ClinetMap.put("clientName", clientName);
		ClinetMap.put("sessionId", sessionId);

		String SelectClientJson = gson.toJson(ClinetMap);
		return SelectClientJson;
	}
		
}




