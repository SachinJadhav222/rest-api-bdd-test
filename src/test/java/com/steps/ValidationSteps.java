package com.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utility.Utils;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

public class ValidationSteps {
    public Logger logger = Logger.getLogger(ValidationSteps.class);
    private Response response;
    private RequestSpecification request;
    private String BASE_PATH;

    @Given("The endpoint URI is already configured")
    public void theEndpointIsAlreadyConfigured() {
        request = RestAssured.given();
    }

    @Then("I set the base path {string} to URI")
    public void iSetTheBasePathToURI(String basePath) {
        BASE_PATH = basePath;
        logger.info("Base Path set: " + BASE_PATH);
    }

    @Then("content type should be in {string}format")
    public void contentTypeFormat(String format) {
        File file = new File(Utils.getSchemaFilePath(BASE_PATH));
        if (format.equals("JSON")) {
            response.then().assertThat().contentType(ContentType.JSON);

        }
    }

    @Then("the body response content should be matched")
    public void responseBodyContentMatched(DataTable table) {

        List<List<String>> data = table.asLists();
        List<Map<String, String>> mapData = table.asMaps();
        //	response.then().body("id", equalTo(Integer.parseInt(data.get(1).get(1))));
        for (int i = 2; i < data.size(); i++) {
            response.then().assertThat().body(data.get(i).get(0), equalTo(data.get(i).get(1)));

        }
    }

    @When("I GET the valid endpoint at {string}")
    public void iGETTheValidEndpointAt(String endP) {
        response = request.basePath(BASE_PATH).when().get("/" + endP);
        response.then().log().all();
    }

    @Then("the following json response is sent")
    public void theFollowingJsonResponseIsSent(String json) {
        request.header("Content-Type", "application/json");

    }

    @Then("I POST data in json format")
    public void iPOSTDataInJsonFormat(String requestBody) {

        request.body(requestBody);

        response = request.basePath(BASE_PATH).post();

    }

    @And("I DELETE the valid user {string}")
    public void iDELETETheValidUser(String userID) {
        response = request.basePath(BASE_PATH).when().delete("/" + userID);
    }

    @And("I PUT the user {string} with following data")
    public void iPUTUPDATETheUserWithFollowingData(String userID, String requestBody) {

        request.body(requestBody);

        response = request.basePath(BASE_PATH).put();

    }

    @Then("The response body should match")
    public void theResponseBodyShouldMatch(String expectedBody) {
        Assert.assertSame(response.body().print(), expectedBody);

    }

    @And("I validate the Schema of the response")
    public void iValidateTheSchemaOfTheResponse() {
        File file = new File(Utils.getSchemaFilePath(BASE_PATH));
        // response.then().body(matchesJsonSchema(file));
    }

    @And("I set the request header {string} as {string}")
    public void iSetTheRequestHeaderAs(String headType, String headValue) {
        request.header(headType, headValue);
    }

    @When("I GET a valid userId {string} from resource")
    public void iGETAValidUserIdFromResource(String userId) {
        response = request.basePath(BASE_PATH).when().get("/" + userId);
    }

    @Then("I should have the status code {string} displayed")
    public void iShouldHaveTheStatusCodeDisplayed(String statusCode) {
        response.then().statusCode(Integer.parseInt(statusCode));
    }

    @And("content type should be in {string} format")
    public void contentTypeShouldBeInFormat(String format) {
        File file = new File(Utils.getSchemaFilePath(BASE_PATH));
        if (format.equals("JSON")) {
            response.then().assertThat().contentType(ContentType.JSON);
        }
    }

    @And("I PUT the post {string} with following data")
    public void iPUTThePostWithFollowingData(String userID, String requestBody) {
        request.body(requestBody);
        response = request.basePath(BASE_PATH).put();
    }

    @And("I DELETE the valid post {string}")
    public void iDELETETheValidPost(String userID) {
        response = request.basePath(BASE_PATH).when().delete("/" + userID);
    }

    @And("I DELETE the valid comment {string}")
    public void iDELETETheValidComment(String id) {
        response = request.basePath(BASE_PATH).when().delete("/" + id);
    }
}
