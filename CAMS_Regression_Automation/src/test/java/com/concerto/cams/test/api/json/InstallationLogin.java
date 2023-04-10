package com.concerto.cams.test.api.json;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InstallationLogin {
	
	public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	
	public static String login(String loginId,String password,String deviceId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("password", password);
		loginmap.put("deviceId", deviceId);
		
		String loginJson = gson.toJson(loginmap);
		return loginJson; 
	}
	
	
	public static void Register() {
	}
	
	public static String ForgotPassword(String loginId, String emailID) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("emailID", emailID);
		
		String ForgotPasswordJson = gson.toJson(loginmap);
		return ForgotPasswordJson;
	}

	public static String ChangePassword(String loginId, String oldPassword, String newPassword, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("oldPassword", oldPassword);
		loginmap.put("newPassword", newPassword);
		loginmap.put("sessionId", sessionId);

		String ChangePasswordJson = gson.toJson(loginmap);
		return ChangePasswordJson;
	}
	
	public static String Logout(String loginId, String sessionId) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put("loginId", loginId);
		loginmap.put("sessionId", sessionId);

		String LogoutJson = gson.toJson(loginmap);
		return LogoutJson;
	}
	
	public static String GetVersion(String version) {
		HashMap<String,Object> loginmap= new HashMap<String,Object>();
		loginmap.put( "version", version);
		
		String GetVersionJson = gson.toJson(loginmap);
		return GetVersionJson;
	}
}


