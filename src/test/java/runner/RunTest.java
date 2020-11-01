package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun.txt",
        "com.cucumber.listener.ExtentCucumberFormatter:target/extent.html"},
        glue = "",
        features = "src/test/resources/features",
        dryRun = false,
        tags = {"@Regression"},

        monochrome = true)
public class RunTest extends AbstractTestNGCucumberTests {

};
