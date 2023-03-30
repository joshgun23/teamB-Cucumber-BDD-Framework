package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.SeleniumUtils;

public class PersonalI_C {
    @Given("userName1")
    public void username() {

        SeleniumUtils.waitFor(2);
        PersonalI_C personalI_c = new PersonalI_C();
        personalI_c.username();

    }

    @When("password1")
    public void password() {
        new PersonalI_C().password();
    }


    @And("login1")
    public void login() {
        new PersonalI_C().login();
    }
}
