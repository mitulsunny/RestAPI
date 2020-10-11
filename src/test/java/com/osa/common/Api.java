package com.osa.common;

import com.osa.utility.Utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api {
	public static void main(String[] args) {
		Response resp=myGET("/api/users?id=2");
		         String body= resp.getBody().asString();
		         String email= resp.jsonPath().getString("data.email");
		         String fName= resp.jsonPath().getString("data.first_name");
		         String lName= resp.jsonPath().getString("data.last_name");
		         String avatar= resp.jsonPath().getString("data.avatar");
		         Utilities.verifyString("janet.weaver@reqres.in", email);
		         Utilities.verifyString("Janet", fName);
		         Utilities.verifyString("Weaver", lName);
		         Utilities.verifyString("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", avatar);       
	}
	
	public static Response myGET(String endpoint) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification request= RestAssured.given();
		Response res=request.get(endpoint);
		return res;
	}
	
	
}
