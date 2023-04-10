package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MoveToQCDescription {
	
public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	
	public static String MoveToQC(String loginId, String clientName, String panelId, String pingStatusTime, String pingStatusTtl,
	String sensorStatus, String sensorType, String zoneNo, String remark, String previousMode, String previousCircle, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("clientName", clientName);
		loginmap.put("panelId", panelId);
		loginmap.put("pingStatusTime", pingStatusTime); 
		loginmap.put("pingStatusTtl", pingStatusTtl); 
		loginmap.put("sensorStatus", sensorStatus); 
		loginmap.put("sensorType", sensorType); 
		loginmap.put("zoneNo", zoneNo); 
		loginmap.put("remark", remark); 
		loginmap.put("previousMode", previousMode); 
		loginmap.put("previousCircle", previousCircle); 
		loginmap.put("fcmToken", sessionId); 

		String MoveToQCDescriptionJson = gson.toJson(loginmap);
		return MoveToQCDescriptionJson;
	}

}


/*{"loginId":"E7+CXo3FeETU9vwLctn/hQ==","clientName":"Test Client","panelId":"A20005",
 "pingStatusTime":"0ms","pingStatusTtl":"100","sensorStatus":[{"zoneNo":"001","sensorType":"ATM chest door","sensorStatus":"Alarmed"}, 
 {"zoneNo":"002","sensorType":"AC failure","sensorStatus":"Normal"}],"remark":"All OK","previousMode":"0","previousCircle":"C1",
 "fcmToken":"yVyGwk6x0pDsBehs7vfjX2SKLxvYkvW/"}*/