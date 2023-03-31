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

    @Given("the user is on the sign in page")
    public void givenTheUserIsOnTheHomePage() {
        System.out.println("The user is on the sign in page");
        SeleniumUtils.waitFor(2);
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();

    }

    @When("the user enters a valid email address and password")
    public void whenTheUserEntersAValidEmailAddressAndPassword() {
        System.out.println("The user enters a valid email address and password");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.userName();
        factory_z.passWord();

    }

    @And("clicks on the sign in button")
    public void clicksOnTheSignInButton() {
        System.out.println("The user should be able to sign in");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.loGin();

    }

    @Then("the user should be redirected to the mortgage account dashboard")
    public void thenTheUserShouldBeRedirectedToTheMortgageAccountDashboard() {
        System.out.println("The user should be redirected to the mortgage account dashboard");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.dashboard();

    }

    @When("the user enters an invalid email address and\\/or password")
    public void theUserEntersAnInvalidEmailAddressAndOrPassword() {
        System.out.println("The user enters an invalid email address and/or password");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.invaliUserName();
        factory_z.invalidPassword();


    }


    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String arg0) {
        System.out.println("The user should see an error message");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.errorMessage();




    }

    @When("the user attempts to sign in without entering an email address or password")
    public void whenTheUserAttemptsToSignInWithoutEnteringAnEmailAddressAndPassword() {
        System.out.println("The user attempts to sign in without entering an email address and password");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.noUserName();
        factory_z.noPassword();


    }

    @Then("the sign in button should be disabled")
    public void thenTheSignInButtonShouldBeDisabled() {
        System.out.println("The sign in button should be disabled");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.disabledButton();


    }

    @And("the user should see an error message indicating the missing field")
    public void andTheUserShouldSeeAnErrorMessageIndicatingTheMissingFieldS() {
        System.out.println("The user should see an error message indicating the missing field(s)");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.missingField();


    }

    @When("the user clicks the \"Don't have an account? Sign up\" link")
    public void whenTheUserClicksTheDonTHaveAnAccountSignUpLink() {
        System.out.println("The user clicks the \"Don't have an account? Sign up\" link");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.signUpLink();

    }

    @Then("the user should be redirected to the sign up page")
    public void thenTheUserShouldBeRedirectedToTheSignUpPage() {
        System.out.println("The user should be redirected to the sign up page");
        Sign_in_factory_Z factory_z = new Sign_in_factory_Z();
        factory_z.signUpPage();

    }

    @When("the user clicks the \"Forgot your password?\" link")
    public void whenTheUserClicksTheForgotYourPasswordLink() {
        System.out.println("The user clicks the \"Forgot your password?\" link");

        // !! There is no link on the page to click on


    }

    @Then("the user should be redirected to the forgot password page")
    public void thenTheUserShouldBeRedirectedToTheForgotPasswordPage() {
        System.out.println("The user should be redirected to the forgot password page");
        // !! There is no page to be redirected to

    }

    @And("the user should see a form to reset their password.")
    public void theUserShouldSeeAFormToResetTheirPassword() {
        System.out.println("The user should see a form to reset their password.");
        // !! There is no form to reset the password

    }
}





