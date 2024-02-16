package testrunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
//        tags = "@demo",
		dryRun = false,
        monochrome = true
)
public class TestRunner {

}
