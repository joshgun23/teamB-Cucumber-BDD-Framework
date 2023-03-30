package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
       tags = "@current",
        features = "src/test/resources",
        glue = "stepDefinitions"

)
public class PersonalInfo_C_Runner {



}
