# REST API Test Automation Project
REST API Automation Demo project using Rest Assured and Cucumber BDD .

## Tools/Framework/Libraries
- JDK 8
- Maven - build tool
- Junit - test runner
- Cucumber - BDD/Gherkin style feature files
- Rest assured - Rest api verification library

## Setup Instruction
This is maven project , so start with 
```shell script
mvn clean install
```

## Run the tests using maven
Using "--tags " we can run any or all feature files
```shell script
mvn clean  test -Dcucumber.options="--tags @user"
```
## CircleCI SetUp
https://app.circleci.com/pipelines/github/SachinJadhav222/rest-api-bdd-test?invite=true
This project is configured in CICD pipeline using circleCI to build,  After each commit or merge the project will be build and notified.

## Cucumber Reports on Cloud: 
https://reports.cucumber.io/report-collections/5727440b-66d4-49de-b7ec-590c1fc74a92
This is API-Test run Reports collection ready to share with team 

## Swagger API documentation:
https://app.swaggerhub.com/apis/SachinJadhav222/json-placeholder/1.0.0


### BDD (Feature file / Step definition)
BDD requires a feature file to invoke the step definitions:
- Create the scenarios in feature file as per the requirements, so each step in feature file has to match a step definition in class file;
- Following the BDD practices for coding;
- Using the special annotation like "@Before" which is the first method to run for each scenario. Moreover, this is the right place to set up the URI (endpoint) which will be called by HTTP request;

###REST API
- This project is aimed at calling Jsonplaceholder' API to validate the Users. This is written in a feature file using Cucumber.
- Each line of the scenario is tied to backend code that actually executes the line (step).


### Secret Key file: 
/src/test/resources/secret_keys.properties    Keep API tokens and credentials into this file 



### Verify JSON GET Request

Testing a simple response containing some JSON data.

- Request URL: https://jsonplaceholder.typicode.com/users/1
- Request Method: GET
- Response Content-Type: application/json
- Response Body:
```json
{
  "id": 1,
  "name": "Leanne Graham",
  "username": "Bret",
  "email": "Sincere@april.biz",
  "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  },
  "phone": "1-770-736-8031 x56442",
  "website": "hildegard.org",
  "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
  }
}
```
- Status Code: 200 OK

### Request not found
- Request URL: https://jsonplaceholder.typicode.com/users/25
- Request Method: GET
- Response Body:
```json
{
  
}
```
- Status Code: 404 Not Found

### JSON schema validation
- The main goal is to ensure that the JSON format is correct as well as all data inside it. Therefore, it was created a json file (schema) and stored it in "resource" file in the package project. In the source-code is validated by the statement 'body(matchesJsonSchemaInClasspath(" file path json"))';

### How it is done (source-code)
#### Passing a userId by parameter in feature file and calling GET request
- when().get("/" + userId)

#### Print in console the response
- then().log().all();

#### Check the status code, so the expected status is passed by parameter in feature file
- then().statusCode(Integer.parseInt(statusCode));

#### Check body response - In this case, the required format is JSON
- then().assertThat().contentType(ContentType.JSON).and().body(matchesJsonSchemaInClasspath("schema-json.json"));

