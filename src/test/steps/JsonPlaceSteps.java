import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class JsonPlaceSteps {
    private RequestSpecification request;
    private Response response;
    private ResponseBody responseBody;
    private ValidatableResponse validatableResponse;
    private List<String> jsonResponse;


    @Given("User sets base API path {string}")
    public void userSetsBaseAPIPath(String basePath) {
        RestAssured.basePath=basePath;
        request = given();
    }

    @And("User creates GET request")
    public void userCreatesGETRequest() {
        response= request.when().get().then().extract().response();
        validatableResponse = (ValidatableResponse) response;
        responseBody=response.getBody();
       // jsonResponse = response.jsonPath().getList("$");
       System.out.println(responseBody.peek());
//       for(String temp: jsonResponse){
//           System.out.println(temp);
//       }
       //System.out.println(response.getBody().peek());
    }

    @Then("User validate status code is {string}")
    public void userValidateStatusCodeIs(String statCode) {
        Assert.assertEquals(Integer.parseInt(statCode),response.getStatusCode());

    }

    @And("User validates Status string is {string}")
    public void userValidatesStatusStringIs(String statusString) {
        Assert.assertEquals(statusString,response.getStatusLine());
    }

    @Then("User validates Content-type to be {string}")
    public void userValidatesContentTypeToBe(String contentType) {
        Assert.assertEquals(contentType, response.getContentType());


    }

//    @And("User check the response for following contents:")
//    public void userCheckTheResponseForFollowingContents(Map<String,String> responseFields) {
//        System.out.println(">>>>>>>>>"+responseFields);
//        json1 = response.then();
//        System.out.println(json1);
//        for (Map.Entry<String, String> field : responseFields.entrySet()) {
//            System.out.println(field.getValue());
//            System.out.println(field.getKey());
//            if(StringUtils.isNumeric(field.getValue())){
//                json1.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
//            }
//            else{
//                json1.body(field.getKey(), containsInAnyOrder(field.getValue()));
//            }
//        }
//    }
//    @And("User check the response for following contents:")
//    public void userCheckTheResponseForFollowingContents(DataTable data) {
//        List<List<String>> data1 = data.raw();
//       // data1 = data.raw();
//        System.out.println(">>>>>>>>>"+data[0][1]);
//        json1 = response.then();
//        System.out.println(json1);
//
//    }
    }

