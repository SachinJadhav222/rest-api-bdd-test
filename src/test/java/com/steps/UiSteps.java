package com.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class UiSteps {
    public Logger logger = Logger.getLogger(UiSteps.class);
    @Given("I login to {string}")
    public void iLoginTo(String arg0) {
        System.out.println(arg0);
    }

    @Then("I enter my name {string}")
    public void iEnterMyName(String arg0) {
        System.out.println(arg0);
    }

    @Then("I can see my name {string}")
    public void iCanSeeMyName(String arg0) {
        System.out.println(arg0);
    }
}
