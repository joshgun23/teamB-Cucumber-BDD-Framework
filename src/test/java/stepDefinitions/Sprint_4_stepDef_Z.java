package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ExpensesPage_M;
import pages.PersonalI_Page_Factory_C;
import pages.PreApproval_Details_Page_R;
import pages.Sign_in_factory_Z;
import utils.Driver;

public class Sprint_4_stepDef_Z {
    @Given("the user is on the electronic consent page")
    public void the_user_is_on_the_electronic_consent_page() {
        //from my class
        Sign_in_factory_Z signIn = new Sign_in_factory_Z();
        signIn.SignIn();

        //Rinata's class -preapproval
        PreApproval_Details_Page_R preApproval = new PreApproval_Details_Page_R();
        preApproval.setPreapproval_method("Albert Einstein", 100000, 20000);

        //Coshgun's class -personal information
        new PersonalI_Page_Factory_C().mortageClick();
        new PersonalI_Page_Factory_C().preapruNo();
        new PersonalI_Page_Factory_C().estimatePri();
        new PersonalI_Page_Factory_C().setEstimateDownP();
        new PersonalI_Page_Factory_C().setPreaprovalNext();
        Assert.assertTrue("personal information", Driver.getDriver().getPageSource().contains("Personal Information"));

        //Martaba's class -expenses
        new ExpensesPage_M().fillOutExpensesForm();
        Assert.assertTrue("expenses", Driver.getDriver().getPageSource().contains("Expenses"));




    }
    @When("the user enters their first name as {string}, last name as {string}, and email address as {string}")
    public void the_user_enters_their_first_name_as_last_name_as_and_email_address_as(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user reads the necessary disclosures related to the loan application")
    public void the_user_reads_the_necessary_disclosures_related_to_the_loan_application() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("the user should see two radio buttons for {string} and {string}")
    public void the_user_should_see_two_radio_buttons_for_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the {string} button should be selected by default")
    public void the_button_should_be_selected_by_default(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user selects the {string} button")
    public void the_user_selects_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("the user should be able to proceed with the application")
    public void the_user_should_be_able_to_proceed_with_the_application() {
        // Write code here that turns the phrase above into concrete actions

    }


}
