package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Sign_in_factory_Z;
import utils.Driver;
import utils.SeleniumUtils;

public class Step_def_Z {


    String eMail;
    String password;
    String login;
    String dashboard;
    String invalidEmail;
    String invalidPassword;
    String errorMessage;
    String noUserName;
    String noPassword;

    @Given("the user is on the sign in page")
    public void the_user_is_on_the_sign_in_page() {
        Sign_in_factory_Z signInPage = new Sign_in_factory_Z();
        SeleniumUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/");
    }
    @When("the user enters a valid email address and password")
    public void the_user_enters_a_valid_email_address_and_password() {
        new Sign_in_factory_Z().SignIn();

    }

    @When("the user clicks on the sign in button")
    public void the_user_clicks_on_the_sign_in_button() {
        new Sign_in_factory_Z().login.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard");
    }

    @Then("the user should be redirected to the mortgage account dashboard")
    public void the_user_should_be_able_to_sign_in_and_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Dashboard"));
    }

    @When("the user enters an invalid email address or password")
    public void the_user_enters_an_invalid_email_address_and_password() {

        new Sign_in_factory_Z().invalidEmail();


    }

    @Then("the user should see an error message \"Login Failed\"")
    public void the_user_should_see_an_error_message_login_failed() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Login Failed"));
    }
     @When("the user attempts to sign in without entering an email address or password")
    public void the_user_attempts_to_sign_in_without_entering_an_email_address_or_password() {
         new Sign_in_factory_Z().noUserName();
         new Sign_in_factory_Z().noPassword();
     }

//     @Then("the sign in button should be disabled")
//        public void the_sign_in_button_should_be_disabled() {
//            Assert.assertFalse(Driver.getDriver().getPageSource().contains("Login"));
//        }
    @And ("the user should see an error message indicating the missing field")
    public void the_user_should_see_an_error_message_indicating_the_missing_field() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Please enter your email address"));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Please enter your password"));
    }

    @When("the user clicks the \"Don't have an account? Sign up\" link")
    public void the_user_clicks_the_dont_have_an_account_sign_up_link() {
        new Sign_in_factory_Z().signUpLink.click();

    }
    @Then("the user should be redirected to the sign up page")
    public void the_user_should_be_redirected_to_the_sign_up_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/signup");
    }




}
