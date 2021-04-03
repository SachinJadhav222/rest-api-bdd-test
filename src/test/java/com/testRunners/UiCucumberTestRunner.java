package com.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/featureFiles/ui"},
        glue = "com.steps",
        plugin = {"pretty", "html:target/reports/ui-test-report.html"},
        dryRun = true,
        monochrome = true,
        tags= "@ui"
)
public class UiCucumberTestRunner {
}
