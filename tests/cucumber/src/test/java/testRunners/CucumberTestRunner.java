package testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        glue = {"stepDefs"},
        features = {"src/test/resources/features"},
        format = {"pretty",
                "json:target/cucumber.json",
                "html:target/reports-pretty/"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}