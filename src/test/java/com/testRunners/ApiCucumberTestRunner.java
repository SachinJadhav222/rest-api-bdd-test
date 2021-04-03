package com.testRunners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import org.junit.runner.RunWith;
import utility.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/featureFiles/api/UserValidation.feature", "src/test/featureFiles/api/PostsValidation.feature", "src/test/featureFiles/api/CommentsValidation.feature"},
        glue = "com.steps",
        plugin = {"pretty", "html:target/reports/api-test-report.html"},
        dryRun = true,
        monochrome = true,
        tags= "@api"
)
public class ApiCucumberTestRunner {

}
