package stepDefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.Sign_in_factory_Z;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class Stepdefs_Z {

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/", Driver.getDriver().getCurrentUrl());


    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        Sign_in_factory_Z signIn = new Sign_in_factory_Z();
        signIn.SignIn();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());


    }

    @Then("the user should be able to sign in successfully")
    public void theUserShouldBeAbleToSignInSuccessfully() {
        Sign_in_factory_Z signIn = new Sign_in_factory_Z();
        signIn.SignIn();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());
    }

    @And("the user should be able to see the welcome message {string}")
    public void theUserShouldBeAbleToSeeTheWelcomeMessage() {
        Sign_in_factory_Z welcome = new Sign_in_factory_Z();
        welcome.welcomeMessage();



    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        //user enters invalid credentials
        Sign_in_factory_Z invalid = new Sign_in_factory_Z();
        invalid.invalidEmail();

    }

    @Then("the user should not be able to sign in")
    public void theUserShouldNotBeAbleToSignIn() {
        SeleniumUtils.waitForVisibility(new Sign_in_factory_Z().errorMessage, 3);
        Assert.assertTrue(new Sign_in_factory_Z().errorMessage.isDisplayed());

    }

    @And("the user should be able to see the error message {string}")
    public void theUserShouldBeAbleToSeeTheErrorMessage(String arg0) {
        SeleniumUtils.waitForVisibility(new Sign_in_factory_Z().errorMessage, 5);
        Assert.assertTrue(new Sign_in_factory_Z().errorMessage.isDisplayed());


    }

    @When("the user enters blank credentials")
    public void theUserEntersBlankCredentials() {
        Sign_in_factory_Z blank = new Sign_in_factory_Z();
        blank.blankCredentials();
        Assert.assertTrue(new Sign_in_factory_Z().errorMessage.isDisplayed());

    }

    @And("the user should be able to see the error message \"Please fill out this field\"")
    public void theUserShouldBeAbleToSeeTheErrorMessagePleaseFillOutThisField()  {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String text = (String) js.executeScript("return document.getElementById('email').validationMessage");
        Assert.assertEquals("Please fill out this field.", text);

    }

    @When("the user enters invalid username")
    public void theUserEntersInvalidUsername() {
        Sign_in_factory_Z invalidusername = new Sign_in_factory_Z();
        invalidusername.invalidEmail();
    }

    @When("the user enters invalid password")
    public void theUserEntersInvalidPassword() {
        Sign_in_factory_Z invalidpassword = new Sign_in_factory_Z();
        invalidpassword.invalidPassword();
        Assert.assertTrue(new Sign_in_factory_Z().errorMessage.isDisplayed());

    }

    @When("the user enters blank username")
    public void theUserEntersBlankUsername() {
        Sign_in_factory_Z blankusername = new Sign_in_factory_Z();
        blankusername.noUserName();
        Assert.assertTrue(new Sign_in_factory_Z().errorMessage.isDisplayed());

    }

    @When("the user enters blank password")
    public void theUserEntersBlankPassword() {
        Sign_in_factory_Z blankpassword = new Sign_in_factory_Z();
        blankpassword.noPassword();
        Assert.assertTrue(new Sign_in_factory_Z().errorMessage.isDisplayed());

    }

    @When("the user enters invalid username and password")
    public void theUserEntersInvalidUsernameAndPassword() {
        Sign_in_factory_Z invalidusernamepassword = new Sign_in_factory_Z();
        invalidusernamepassword.invalidUsernamePassword();
        Assert.assertTrue(new Sign_in_factory_Z().errorMessage.isDisplayed());

    }

    @When("the user clicks on {string}")
    public void theUserClicksOn(String Sign_upLink) {
        Sign_in_factory_Z signup = new Sign_in_factory_Z();
        signup.signUpLink();
    }

    @Then("the user should be able to see the sign up page")
    public void theUserShouldBeAbleToSeeTheSignUpPage() {
        Sign_in_factory_Z signup = new Sign_in_factory_Z();
        signup.signUpLink();
    }

    @Then("the user should be able to see the forgot password page")
    public void theUserShouldBeAbleToSeeTheForgotPasswordPage() {
        Sign_in_factory_Z forgotpassword = new Sign_in_factory_Z();
        forgotpassword.forgotPasswordLink();
    }
}
