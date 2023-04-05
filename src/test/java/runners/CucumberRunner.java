package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
       tags = "TestEric", // runs scenarios with the given tag only
        features = "src/test/resources/user_login_Z.feature", // the path where all feature files are located
      glue = "stepDefinitions", // path where all step definition classes are located
        plugin = {
                "pretty", // adds more detailed output log in the cmd console
                "html:target/basic-report/report.html"  // to generate a basic built-in report
        }
//        stepNotifications = true  // to display detailed step results
//        ,dryRun = true  // to generate step definition snippets without actually running the scenario

)
public class CucumberRunner {
}

