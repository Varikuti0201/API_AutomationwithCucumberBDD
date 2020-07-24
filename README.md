# API_AutomationwithCucumberBDD
This is  End to End Automation of API by integrating cucumber framework.

# Task and Requirements:
1. Write Automated Scripts , Ideally BDD , that black-box tests the given resources
2. GET /v1/car­types/manufacturer
3. GET /v1/car­types/main­types
4. GET /v1/car­types/built­dates

# Pre-Requisite/Toolset used for Automation Framework Development
1. Cucumber BDD (Test written in BDD style (feature file) with corresponding steps defined in Step Definition file)
2. Rest Assured (Testing and Validating Rest Services in JAVA)
3. JUnit(Testing Framework used for TestRunner , Assertions, Annotations)
4. POJO(Serialization /Deserialization –JSON Object)
5. Maven( Build Automation Tool)
6. Cucumber HTML Report( Test Execution Results )
 
# How to Run the Test ?
1. Extract the project files
2. Right Click on the Project -> Maven ->Update Project
3. Once the project is build,
4. Right Click on the project -> Run As -> Maven Test (or)
5. Right Click on the Test Runner Class -> Run As -> JUnit Test

Logging Text file in project directory will have all the logs of API Calls

To generate HTML Report, Please make sure the maven and JAVA is configured properly in the machine to run the test.

1. Open Command prompt and give command mvn verify
2. A Detailed HTML report will be generated under target -> cucumber-htmlreport. Report Path under Target folder: [cucumber-html-reports -> overviewfeatures]. Please download entire cucumber-html-reports folder to view the report.
3. Report with Chart and Tabular information of tests
4. Scenario with steps and corresponding results

# Test Scenarios: I have created the below tests to validate the API Calls
1. Validate if user is able to get manufacturer ,car type, built dates to review the offers
available [This scenario covers the E2E Happy Path for all the API Calls]
2. Verify response for InvalidUserInput [This scenario validates the response received for invalid
input (wrong manufacturer code ) ] – Similar Scenarios can be duplicated for other API calls
3. Verify response for invalid resource [Validates the response received for invalid resource
input (wrong manufacturer resource)] - Similar Scenario can be duplicated for other API Calls 


# Report on Findings:
1. Null or Invalid inputs of the API calls returning empty list (“wkda”{}) with status code 200. 
[Custom Error Handling [Status Code / Error Message ] would be a better approach]
2. Built-Dates API Call returns only the wkda list, page,Pagesize,totalpageCount in
response body is not displayed .

