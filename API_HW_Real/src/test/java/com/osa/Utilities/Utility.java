package com.osa.Utilities;
import com.osa.steps.API_Steps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {

	public static Response myGET(String type, String endpoint) {
		RestAssured.baseURI = "https://reqres.in";
		Response res;
		RequestSpecification request = RestAssured.given();
		System.out.println("---------------------------------------------------");
		if (type.equals("GET")) {
			res = request.get(endpoint);
		} else if (type.equals("POST")) {
			res = request.post(endpoint);

		} else if (type.equals("PATCH")) {
			res = request.patch(endpoint);
		} else {
			res = request.delete(endpoint);
		}
		return res;
	}
	
	public static void verifyCode(String a,String b,String c) {
		int code =API_Steps.res.statusCode();
		if (Integer.parseInt(c)==code) {
			System.out.println("Sucessful "+b+" " +c);
		}
		else {
			System.out.println("Unsucessful "+b  );
		}
		
		
	}
	
	public static void verifyInfo(String actual, String expected) {
		
		System.out.println("--------------------------------------------------");
		if (API_Steps.res.jsonPath().getString(actual).equals(expected)) {
			System.out.println("The actual and expected are matched");
		} else {
			System.out.println("The actual and expected did not match");
			System.out.println("The expected value is: " + expected);
			System.out.println("But the actual value is: " + API_Steps.res.jsonPath().getString(actual));

		}
		
	}
}
