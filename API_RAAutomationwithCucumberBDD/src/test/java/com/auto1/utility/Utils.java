package com.auto1.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		System.out.println("Inside request spec");
		PropReader.GetInstance();
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			System.out.println(PropReader.getBaseUrl());
			req = new RequestSpecBuilder().setBaseUri(PropReader.getBaseUrl())
					.addQueryParam("wa_key", "coding-puzzle-client-449cc9d")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			System.out.println(req.log().all());
			return req;
		}
		System.out.println(req.log().all());
		return req;

	}

	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}
