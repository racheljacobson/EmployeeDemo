package com.sw409.bootstrapdemo;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class EmployeeDemoApplicationTests {

	@org.testng.annotations.Test
	void getManager() {
		RestAssured.baseURI="http://localhost:8080/api/manager";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/patient");
		String res = response.getBody().asString();
		System.out.println("******* Response is " + res);
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
	}
	
	@org.testng.annotations.Test
	void createManager() {
		RestAssured.baseURI="http://localhost:8080/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("name", "rachel");
		json.put("id", "1");
		
		httprequest.body(json);
		httprequest.header("Content-Type", "application/json");
		Response response = httprequest.request(Method.POST, "create");
		int statuscode = response.statusCode();
		String str = response.getBody().asString();
		String statusMessage = response.jsonPath().getString("status");
		System.out.println("********* Response is " + str);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 405); 
		Assert.assertEquals(statusMessage, "success");
	}

}
