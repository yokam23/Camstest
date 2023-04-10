package com.concerto.api.utilities;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

public class RequestConfigMethods {
	
	public static RestAssuredConfig proxy_config(){
		return RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
	}
	
	public static RestAssuredConfig ssl_config(){
		return RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
			       setParam("http.connection.timeout",3000).
			       setParam("http.socket.timeout",3000).
			       setParam("http.connection-manager.timeout",3000));
	}

}
