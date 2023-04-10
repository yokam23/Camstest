package com.concerto.api.utilities;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RestMethods {
	/**
	 * GetRequest
	 * @param URL
	 * @param API
	 * @param Path
	 * @return
	 */
	public  static Response GET_Request(String URL,String API,String Path) {
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
		
		Response response = given().relaxedHTTPSValidation().config(RestAssured.config).
				urlEncodingEnabled(false)
	            .contentType("application/json")
	            .accept("application/json").
	            when().redirects().follow(true).redirects().max(100).
	            get(URL+API+Path);
		System.out.println(response.asString());
		return response;
	}
	/**
	 * GetWithoutAuth
	 * @param URL
	 * @param API
	 * @param Parameters
	 * @param accessToken
	 * @return
	 */
	public  static Response GET_Request_With_Parameters(String URL,String API,String Parameters,String accessToken) {
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
		
		Response response = given().relaxedHTTPSValidation().config(RestAssured.config).
				urlEncodingEnabled(false)
	            .contentType("application/json")
	            .accept("text/html").
	            when().redirects().follow(true).redirects().max(100).
	            get(URL+API+Parameters+accessToken);
		System.out.println(response.asString());
		return response;
	}

	/**
	 * PostWithAuth
	 * @param URL
	 * @param API
	 * @param JSON
	 * @param accessToken
	 * @return
	 */
	public  static Response POST_Request_With_Auth(String URL,String API,String JSON,String accessToken) {
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
		
		Response response = 
		        given().relaxedHTTPSValidation().config(RestAssured.config)
		        .auth().oauth2(accessToken)
		            .contentType("application/json")
		            .accept("application/json")
		            .body(JSON)
		        .when()
		        .post(URL+API);
		return response;
	}
	
	/**
	 * Post Without Auth
	 * @param URL
	 * @param API
	 * @param Path
	 * @param JSON
	 * @return
	 */
	public  static Response POST_Request(String URL,String API,String Path,String JSON) {
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",30000).
			       setParam("http.socket.timeout",30000).
			       setParam("http.connection-manager.timeout",30000));
		
		
		
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Cache-Control", "no-cache");
//		headers.put("Postman-Token", "aef06ebd-2eb7-439e-a309-2f7bc1efff3a");
		
		Response response = 
		        given().relaxedHTTPSValidation().config(RestAssured.config).headers(headers)
		            .contentType("application/json")
		            .accept("application/json")
		            .body(JSON)
		        .when()
		        .post(URL+API+Path);
		return response;
	}
	
	/**
	 * Put With Auth
	 * @param URL
	 * @param API
	 * @param JSON
	 * @param accessToken
	 * @return
	 */
	public  static Response PUT_Request(String URL,String API,String JSON,String accessToken) {
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
		
		Response response = 
		        given().relaxedHTTPSValidation().config(RestAssured.config)
		        .auth().oauth2(accessToken)
		            .contentType("application/json")
		            .accept("application/json")
		            .body(JSON)
		        .when()
		        .put(URL+API);
		return response;
	}
	
	/**
	 * Patch with Auth
	 * @param URL
	 * @param API
	 * @param JSON
	 * @param accessToken
	 * @return
	 */
	public  static Response PATCH_Request(String URL,String API,String JSON,String accessToken) {
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
		
		Response response = 
		        given().relaxedHTTPSValidation().config(RestAssured.config)
		        .auth().oauth2(accessToken)
		            .contentType("application/json")
		            .accept("application/json")
		            .body(JSON)
		        .when()
		        .patch(URL+API);
		return response;
	}
	
	/**
	 * Post MultiPart
	 * @param URL
	 * @param API
	 * @param file
	 * @param JSON
	 * @param accessToken
	 * @return
	 */
	public  static Response POST_MultiPart_Request(String URL,String API,File file,String JSON,String accessToken) {
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
		
		Response response = 
		        given().relaxedHTTPSValidation().config(RestAssured.config)
		        .auth().oauth2(accessToken)
		            .multiPart("file", file,"multipart/form-data").
					multiPart("promotion", JSON,"application/json")
		        .when()
		        .post(URL+API);
		return response;
	}

}
