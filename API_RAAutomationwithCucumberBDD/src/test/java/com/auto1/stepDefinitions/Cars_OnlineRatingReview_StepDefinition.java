package com.auto1.stepDefinitions;

import io.cucumber.java.en.*;

public class Cars_OnlineRatingReview_StepDefinition {

	HelperClass helper = new HelperClass();

	@Given("^API Resources with car types for user to select$")
	public void resources_with_car_types_to_select() throws Throwable {

		helper.getRequest();

	}

	@When("user calls {string}  with {string}  http request")
	public void user_calls_with_http_request(String resource, String method) throws Throwable {
		helper.userCallWithHttpRequest_manufacturer(resource, method);

	}

	@Then("user should be displayed with status code {string}")
	public void user_should_be_displayed_with_status_code(String code) {
		helper.getRequestStatus(code);
	}

	@And("{string} in response body is {string}")
	public void something_in_response_body_is_something(String keyVal, String expectedValue) {
		helper.getJsonPath(keyVal, expectedValue);

	}

	@Then("validate if {string} is displayed in the response body for {string} input")
	public void validate_if_userInputValue_is_displayed_in_the_response_body(String userInput, String inputType) {
		helper.validate_if_userInput_in_response_body(userInput, inputType);
	}

	@When("user calls {string} for the input {string} with {string} http request")
	public void user_calls_car_maintypes_with_http_request(String resource, String param, String method) {
		helper.userCallHttpRequest_forCarMainTypes(resource, method, param);
	}

	@When("user calls {string} for {string} & {string} with {string} http request")
	public void user_calls_built_dates_http_request(String resource, String param1, String param2, String method) {
		helper.userCallHttpRequest_forBuiltDates(resource, param1, param2, method);
	}

	@Then("validate response body for {string} input")
	public void validate_response_body_for_input(String inputType) {
		helper.validate_if_userInput_in_response_body("", inputType);
	}

	@When("user calls invalid resource {string}  with {string}  http request")
	public void user_calls_invalid_resource_with_http_request(String resource, String request) {
		helper.userCallWithInvalidResource_HttpRequest(resource, request);
	}
}
