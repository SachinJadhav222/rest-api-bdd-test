
import com.sun.codemodel.JForEach;
import io.cucumber.datatable.DataTable;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        validatableResponse = null;
        responseBody=response.getBody();
        jsonResponse = response.jsonPath().getList("$");


//
//        }
//        LinkedHashMap<String, String> lhmap= (LinkedHashMap<String, String>) jsonResponse;
//        for (String field : jsonResponse){
//            System.out.println(field);
//
//        }
      // System.out.println(responseBody.peek());
//       for(String temp: jsonResponse){
//           System.out.println(temp);
//       }
       //System.out.println(response.getBody().peek());
    }
    @Given("User creates POST to the base path {string} request with payload:")
    public void userCreatesPOSTToTheBasePathRequestWithPayload(String basePath,Map<String,String> responseFields) {
        RestAssured.basePath=basePath;
//
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("name", "Zion");
//        requestParams.put("age", 23);
//        requestParams.put("salary", 12000);


        for (Map.Entry<String, String> field : responseFields.entrySet()){
            System.out.println(field.getKey());
            System.out.println(field.getValue());
        }
    }

    @And("User creates POST request with payload:")
    public void userCreatesPOSTRequestWithPayload(Map<String,String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()){
            System.out.println(field.getKey());
            System.out.println(field.getValue());
        }

        response= request.when().post().then().extract().response();
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
//        List<List<String>> cells = data.cells();
//
//        for(List<String> dat:cells){
//            for(String dat2: dat){
//                System.out.println(dat2);
//            }
//
//        }
//
//
//        validatableResponse = response.then();
//        System.out.println(validatableResponse);
//    }

    @And("User check the response for following contents:")
    public void userCheckTheResponseForFollowingContents(Map<String,String> responseFields) {

        for (Map.Entry<String, String> field : responseFields.entrySet()){
            System.out.println(field.getKey());
            System.out.println(field.getValue());
        }
          //  System.out.println(responseFields.get("Leanne Graham"));
      //  System.out.println(responseFields.get("email"));

//        validatableResponse = response;
//        System.out.println(validatableResponse.);

    }



}

