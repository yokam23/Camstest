package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PanelCommunication {
	public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	
	public static String PanelCommunicationStatus(String loginId, String clientName, String panelId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("sessionId", sessionId);  

		String PanelCommunicationSTatusJson = gson.toJson(loginmap);
		return PanelCommunicationSTatusJson;
	}
	
	public static String SensorStatus(String loginId, String clientName, String panelId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("sessionId", sessionId);  

		String SensorStatusJson = gson.toJson(loginmap);
		return SensorStatusJson;
	}
}
