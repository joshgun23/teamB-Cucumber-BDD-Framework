package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        tags = "@testOutline2",//"@smoke",//"@smoke and @negativ" "@smoke or @positive","@smoke or @regression","@regression","@test12"
        features = "src/test/resources",
        glue = "stepDefinitions",
        stepNotifications = true,//give us all step detailed result
        //dryRun = true,//same the headless code running but UI not opening
        plugin = {
                "pretty", // adds more detailed output log in the cmd console
                "html:target/basic-report/report.html"  // to generate a basic built-in report
        }

)
public class PersonalInfo_C_Runner {



}