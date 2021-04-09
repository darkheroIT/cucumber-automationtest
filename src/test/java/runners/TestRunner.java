package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty", "html:target/HTMLReports/report.html",
                "pretty", "json:target/JSONReports/cucumber-report.json",
                "pretty", "junit:target/JUnitReports/report.xml"
        },
        dryRun = false,
        tags = "@Create",
        monochrome = true
)
public class TestRunner {

}
