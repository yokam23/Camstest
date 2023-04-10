package com.concerto.api.utilities;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class RestTransform {
	

	public String HashMap_To_Json(HashMap<String,Object> Serialize) {		
		String Json = new Gson().toJson(Serialize);	
		return Json;
	}

	
	public JsonElement HashMap_To_JsonTree(HashMap<String,Object> Serialize) {		
		JsonElement Json = new Gson().toJsonTree(Serialize);
		return Json;
	}
	
	
	public <T> String POJO_To_JsonTree(Class<T> classOfT) {		
		String Json = new Gson().toJson(classOfT);
		return Json;
	}
	
	
}
