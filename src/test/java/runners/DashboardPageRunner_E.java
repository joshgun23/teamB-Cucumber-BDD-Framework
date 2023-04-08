package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      //  tags = "eric",
        features = "src/test/resources", // the relative path of the folder where the feature files are located
        glue = "stepDefinitions", // the relative path of the folder where step definition methods are located
        stepNotifications = true,
        plugin = {
                "pretty", // adds more detailed output log in the cmd console
                "html:target/basic-report/report.html"  // to generate a basic built-in report
        }
)

public class DashboardPageRunner_E {
}