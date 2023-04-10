package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InstallationPanelTracking {
	
public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

	public static String StartPanelTracking (String loginId, String clientName, String panelId, String tracking, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("clientName", clientName);
		loginmap.put("tracking", tracking);

		String StartPanelTrackingJson = gson.toJson(loginmap);
		return StartPanelTrackingJson;
	}
	
	public static String StopPanelTracking (String loginId, String clientName, String panelId, String tracking, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("clientName", clientName);
		loginmap.put("tracking", tracking);

		String StopPanelTrackingJson = gson.toJson(loginmap);
		return StopPanelTrackingJson;
	}
}