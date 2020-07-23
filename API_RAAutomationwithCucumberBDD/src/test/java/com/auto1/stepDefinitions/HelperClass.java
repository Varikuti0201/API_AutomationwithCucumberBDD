package com.auto1.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import com.auto1.pojo.GetCar;
import com.auto1.resources.APIResources;
import com.auto1.utility.Utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class HelperClass extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	GetCar gc;

	public void getRequest() {
		try {
			res = given().spec(requestSpecification());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public GetCar userCallWithHttpRequest_manufacturer(String resource, String requestmethod) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (requestmethod.equalsIgnoreCase("POST")) {
			response = res.expect().defaultParser(Parser.JSON).when().post(resourceAPI.getResource());
			gc = response.as(GetCar.class);
		}

		else if (requestmethod.equalsIgnoreCase("GET")) {
			response = res.expect().defaultParser(Parser.JSON).when().get(resourceAPI.getResource());
			gc = response.as(GetCar.class);
		}

		return gc;

	}

	public GetCar userCallHttpRequest_forCarMainTypes(String resource, String requestmethod, String manufactureCode) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		res.queryParams("manufacturer", manufactureCode);

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (requestmethod.equalsIgnoreCase("POST")) {
			response = res.expect().defaultParser(Parser.JSON).when().post(resourceAPI.getResource());
			gc = response.as(GetCar.class);
		}

		else if (requestmethod.equalsIgnoreCase("GET")) {
			response = res.expect().defaultParser(Parser.JSON).when().get(resourceAPI.getResource());
			gc = response.as(GetCar.class);
		}
		return gc;

	}

	public GetCar userCallHttpRequest_forBuiltDates(String resource, String manufactureCode, String mainTypeCode,
			String requestmethod) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		res.queryParam("main-type", mainTypeCode);

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (requestmethod.equalsIgnoreCase("POST")) {
			response = res.expect().defaultParser(Parser.JSON).when().post(resourceAPI.getResource());
			gc = response.as(GetCar.class);
		}

		else if (requestmethod.equalsIgnoreCase("GET")) {
			response = res.expect().defaultParser(Parser.JSON).when().get(resourceAPI.getResource());
			gc = response.as(GetCar.class);
		}

		return gc;

	}

	public void getRequestStatus(String code) {
		assertEquals(response.getStatusCode(), Integer.parseInt(code));

	}

	public void getJsonPath(String Key, String expectedVal) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		String value = js.get(Key).toString();
		System.out.println(value);
		System.out.println(expectedVal);
		assertEquals(value, expectedVal);

	}

	public void validate_if_userInput_in_response_body(String inputkeyValue, String input) {

		Map<Object, Object> list = gc.getWkda();

		if (input.equalsIgnoreCase("valid")) {

			if (list.isEmpty()) {
				System.out.println("User is returned with empty response for valid input");
				assertFalse("User is returned with empty response for valid input", true);
			} else {
				for (Object key : list.keySet()) {

					if (key.toString().equalsIgnoreCase(inputkeyValue)) {
						System.out.println("*******User Input value Displayed " + list.get(key));
						assertTrue("User input value is present in the response body", true);
						break;
					}

				}
			}
		}

		else if (input.equalsIgnoreCase("Invalid")) {
			if (list.isEmpty()) {
				System.out.println("User is displayed with empty response for invalid input ");
				assertTrue("User is displayed with empty response for invalid input ", true);
			} else {
				System.out.println("List Size***********" + list.size());
				System.out.println("User is returned with some response for invalid input");
				assertFalse("User is returned with some response for invalid input", true);
			}
		}

	}

	public void userCallWithInvalidResource_HttpRequest(String resource, String requestmethod) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(404).expectContentType(ContentType.JSON).build();

		if (requestmethod.equalsIgnoreCase("POST")) {
			response = res.expect().defaultParser(Parser.JSON).when().post(resourceAPI.getResource());

		}

		else if (requestmethod.equalsIgnoreCase("GET")) {
			response = res.expect().defaultParser(Parser.JSON).when().get(resourceAPI.getResource());

		}

	}

	public enum UserInput {
		VALID("valid"), INVALID("invalid");

		private String value;

		public String getValue() {
			return this.value;
		}

		private UserInput(String value) {
			this.value = value;
		}
	}

}
