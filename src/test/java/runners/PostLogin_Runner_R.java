package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        tags ="@api",
        features = "src/test/resources",  // the relative path of the folder where the feature files are located
        glue = "stepDefinitions", // the relative path of the folder where step definition methods are located

        stepNotifications = true  // shows the detailed step results
//      ,dryRun = true   // dryRun scans the resources folder and generates step definition snippets
//         used for generating snippets quickly
        ,snippets = CucumberOptions.SnippetType.CAMELCASE  // generates Camel Case Style Snippets
        ,plugin = {
        "pretty",  // displays more detailed output on the console
        "html:target/cucumber-built-in-report.html", // generates built in html report at the given the path
        "json:target/cucumber.json",
        "rerun:target/failed.txt"
}
)

public class PostLogin_Runner_R {
}
