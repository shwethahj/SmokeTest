package com.philips.ibec.functionLibrary;

/**
 * This Function library contains all rest api related functions ex. PUT,POST and GET etc...
 */

import java.util.logging.Logger;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAPI_Calls extends genericFunctionLib{
	
	final static Logger logger= Logger.getLogger("RestAPI_Calls");
	
	/** 
	 * This function is used to POST the message
	 * @param URL- The EndpointURL to send the request
	 * @param requestBody- This is request body. Example HL7 or JSON message
	 * @param asserttype-  Mention value as body if we asserting the response body or code if we assertign the response code
	 * @return Response body or response code based on asserttype parameter value
	 */
	
	public static String sendMessage( String URL,String requestBody,String asserttype)
	{   
	
		RestAssured.baseURI = URL;
	
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.body(requestBody);
		Response response = httpRequest.post();
		
		if  (asserttype == "body") {
			String responseBody = response.getBody().asString();
			return responseBody;
		}
		else {
			int responseCode = response.getStatusCode();
			return String.valueOf(responseCode);
		}
		
		
		

	}
	
	public static String postheader( String URL,String requestBody,String asserttype)
	{   
	
		RestAssured.baseURI = URL;
	
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames());
		
		httpRequest.body(requestBody);
		httpRequest.header("Authorization","Basic YWRtaW5pc3RyYXRvcjp3ZWxjb21l");
		httpRequest.header("Accept","application/json");
		httpRequest.header("Content-Type","application/json");
		
		Response response = httpRequest.post();

		if  (asserttype == "body") {
	
			String responseBody = response.getBody().asString();
			return responseBody;
			//return String.valueOf(responseBody);
			

		}	
			
		else {
			int responseCode = response.getStatusCode();
			return String.valueOf(responseCode);
		}
		
		
		

	}

}
;