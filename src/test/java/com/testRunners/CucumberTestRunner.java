package com.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/featureFiles/UserValidation.feature", "src/test/featureFiles/PostsValidation.feature", "src/test/featureFiles/CommentsValidation.feature"},
        glue = "com.steps",
        plugin = {"pretty", "html:target/reports/test-report.html"},
        dryRun = true,
        monochrome = true,
        tags= "@api"
)
public class CucumberTestRunner {
}
