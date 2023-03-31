package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "sighn_in",
        features = "src/test/resources/user_login_Z.feature",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/basic-report/report.html"
        }
)
public class Sighn_In_runner_Z {}
