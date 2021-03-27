import io.cucumber.datatable.DataTable;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.Utils;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class UserValidationSteps {
	
	private Response response;
	private RequestSpecification request;
	private String BASE_PATH;
	
	@Given("^The endpoint URI is already configured$")
	public void theEndpointIsAlreadyConfigured() {
		request = RestAssured.given();
	}
	@Then("I set the base path {string} to URI")
	public void iSetTheBasePathToURI(String basePath) {
		BASE_PATH=basePath;
	}
	
	@When("^I GET a valid userId \"([^\"]*)\"$")
	public void inputValidUserId(String userId) {
		response = request.basePath(BASE_PATH).when().get("/" + userId);
		response.then().log().all();
	}

	@Then("^I should have the status code \"([^\"]*)\"$")
	public void statusXCode(String statusCode) {
		response.then().statusCode(Integer.parseInt(statusCode));
	}

	@Then("^content type should be in \"([^\"]*)\" format$")
	public void contentTypeFormat(String format) {
		File file = new File(Utils.getSchemaFilePath(BASE_PATH));
		if(format.equals("JSON")){
			response.then().assertThat().contentType(ContentType.JSON);
			//	.and()
			//.body(matchesJsonSchemaInClasspath("src/main/resources/json-schema/*.json"));
			//.body(matchesJsonSchema(file));
		}
	}
	
	@Then("^the body response content should be matched$")
	public void responseBodyContentMatched(DataTable table) {

		List<List<String>> data = table.asLists();
		List<Map<String, String>> mapData =  table.asMaps();

	//	response.then().body("id", equalTo(Integer.parseInt(data.get(1).get(1))));

		for(int i = 2; i < data.size(); i++) {
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
		request.header("Content-Type","application/json");
		System.out.println(json);
	}

	@Then("I POST data in json format")
	public void iPOSTDataInJsonFormat(String requestBody) {
		request.header("Content-Type","application/json");
		request.body(requestBody);
		//System.out.println(requestBody);
		response=request.basePath(BASE_PATH).post();
		//System.out.println(response.peek());
	}
}
