package com.concerto.api.utilities;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;

public class Authorization {
	
	
	public String authenticateUser(String URL, String API, String username, String password,RestAssuredConfig Proxyconfig) {
		
		RestAssured.config= RequestConfigMethods.proxy_config();			

	    String response =
	            given().relaxedHTTPSValidation().config(Proxyconfig)
	                .auth()
	                .preemptive()
	                .basic(username,password)
	            .when()
	                .get(URL+API)
	                .asString();

	    System.out.println(response);
	    JsonPath jsonPath = new JsonPath(response);
	    String accessToken = jsonPath.getString("access_token");
	    return accessToken;

	}
   
	public String authenticateUseroAuth2(String URL, String API, String grant_type, String client_id, String client_secret,
			String url,String api) {

		
	    String response =
	            given().relaxedHTTPSValidation()
	                .params( "grant_type", grant_type,
	                           "client_id", client_id, "client_secret", client_secret)
	                .auth()
	                .preemptive()
	                .basic("web","pass")
	            .when()
	                .post(url+api)
	                .asString();

	    JsonPath jsonPath = new JsonPath(response);
	    String accessToken = jsonPath.getString("access_token");
	    return accessToken;
	}
	
	
	public void authenticateUserdemo(String username,String password,String url, String API) {

	    String response =
	            given().relaxedHTTPSValidation()
	                .auth()
	                .preemptive()
	                .basic(username,password)
	            .when()
	                .get(url+API)
	                .asString();

	    System.out.println(response);
	    JsonPath jsonPath = new JsonPath(response);
	    String accessToken = jsonPath.getString("access_token");
	    	    

	}


}
