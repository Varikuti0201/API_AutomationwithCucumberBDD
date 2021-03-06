Feature: Validation of Online Review for the Car Selected 

# Verifies if the user is able to select the car type and build date to get the offer
Scenario: Verify if user is able to get manufacturer ,car type and built date to review the offers available 
Given  API Resources with car types for user to select 
When  user calls "GetManufacturerAPI" with "GET" http request 
Then  user should be displayed with status code "200" 
And   validate if "060" is displayed in the response body for "valid" input 
When  user calls "GetMainTypesAPI" for the input "060" with "GET" http request 
Then  user should be displayed with status code "200" 
And   validate if "A2" is displayed in the response body for "valid" input 
When  user calls "GetBuiltDatesAPI" for "060" & "A2" with "GET" http request 
Then  user should be displayed with status code "200" 
And   validate if "2006" is displayed in the response body for "valid" input 

# Verifies if the user gets the valid message for the invalid input
Scenario: Verify response for invalid userInput 
Given  API Resources with car types for user to select 
When  user calls "GetMainTypesAPI" for the input "0few" with "GET" http request 
Then  user should be displayed with status code "200" 
And   validate response body for "Invalid" input 



# Verifies if the user gets the valid message if he hits the invalid resource URI
Scenario: Verify response for invalid resource "GetManufacturerAPI" 
Given  API Resources with car types for user to select 
When  user calls invalid resource "GetManufacturerAPI_Invalid" with "GET" httprequest 
Then  user should be displayed with status code "404" 

  