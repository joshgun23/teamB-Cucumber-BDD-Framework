package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Expense",
        features = "src/test/resources",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/basic-report/report.html"
        }
)


public class ExpensesRunners {

}
