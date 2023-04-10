package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InstallationselectPanelId {
	
public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	
	public static String selectPanelId(String loginId, String clientName, String panelId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("oldPassword", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("sessionId", sessionId);

		String selectPanelIdJson = gson.toJson(loginmap);
		return selectPanelIdJson;
	}	

}
