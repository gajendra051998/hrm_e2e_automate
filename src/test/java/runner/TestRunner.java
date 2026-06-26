package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features/login.feature","src/test/resources/features/user_search.feature"},
        glue = {"stepsdefinitions","hooks"},
        plugin = {"pretty" , "html:target/cucumber-reports/cucumber.html"},
        monochrome = true
        //tags = "@smoke or @regression"
        )

public class TestRunner extends AbstractTestNGCucumberTests {
}
