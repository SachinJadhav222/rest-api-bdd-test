package com.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import utility.Utils;

public class CucumberHooks {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_CYAN = "\u001B[36m";



    @Before
    public void beforeScenario(Scenario scenario)  {
        System.out.println(TEXT_CYAN+"SCENARIO-->>"+ scenario.getName()+ TEXT_RESET);
        RestAssured.baseURI= Utils.getProperties("baseUrl");
    }

    @After
    public void afterScenario(){
        System.out.println("<<----Scenario Ends---->>");
    }
}
