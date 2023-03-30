package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PersonalI_Page_Factory_C;
import utils.Driver;
import utils.SeleniumUtils;

public class PersonalI_StepDefinisions_C {
    @Given("userName1")
    public void perusername() {

        SeleniumUtils.waitFor(2);
        PersonalI_Page_Factory_C personalI_c = new PersonalI_Page_Factory_C();
        personalI_c.userName1();

    }

    @When("password1")
    public void password() {
        new PersonalI_Page_Factory_C().passWord();
    }


    @Then("login1")
    public void signUp() {
        new PersonalI_Page_Factory_C().loGin();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Duobank Mortgage Application");
    }
}
