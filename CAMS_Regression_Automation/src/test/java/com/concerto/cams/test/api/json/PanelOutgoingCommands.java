package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PanelOutgoingCommands {
	
	public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

	public static String ResetPanel (String loginId, String clientName, String panelId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("sessionId", sessionId);

		String ResetPanelJson = gson.toJson(loginmap);
		return ResetPanelJson;
	}

	public static String SilenceCommand (String loginId, String clientName, String panelId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("sessionId", sessionId);

		String SilenceCommandJson = gson.toJson(loginmap);
		return SilenceCommandJson;
	}
	
	public static String StartSiren(String loginId, String clientName, String panelId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("sessionId", sessionId);

		String StartSirenJson = gson.toJson(loginmap);
		return StartSirenJson;
	}
	
	public static String NetworkPingStatus(String loginId, String clientName, String panelId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("sessionId", sessionId);

		String NetworkPingStatusJson = gson.toJson(loginmap);
		return NetworkPingStatusJson;
	}
	
}









