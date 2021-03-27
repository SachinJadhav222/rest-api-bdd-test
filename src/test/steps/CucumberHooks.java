import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utility.Utils;

import java.io.IOException;

public class CucumberHooks {
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    @Before
    public void beforeScenario()  {
        System.out.println("Scenario Started---->>");
        RestAssured.baseURI= Utils.getProperties("baseUrl");
    }

    @After
    public void afterScenario(){
        System.out.println("<<----Scenario Ends");

    }
}
