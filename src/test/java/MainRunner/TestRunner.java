package MainRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features/AmazonTest.feature",
        glue = {"StepDefinitions","driverManage"},
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber-reports.html",
        },
        monochrome = true
)
public class TestRunner {
}
