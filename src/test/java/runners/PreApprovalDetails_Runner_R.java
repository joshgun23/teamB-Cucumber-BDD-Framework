package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@db_preapp",
        features = "src/test/resources", // the relative path of the folder where the feature files are located
        glue = "stepDefinitions", // the relative path of the folder where step definition methods are located
//        stepNotifications = true, //to display detailed step results
        plugin = {
        "pretty", // adds more detailed output log in the cmd console
        "html:target/basic-report/report.html"  // to generate a basic built-in report
        }
//        ,dryRun = true  // to generate step definition snippets without actually running the scenario
)

public class PreApprovalDetails_Runner_R {

}
