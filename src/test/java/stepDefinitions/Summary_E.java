package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardSection_E;
import pages.PreApproval_Details_Page_R;
import pages.Sign_in_factory_E;
import utils.Driver;
import utils.SeleniumUtils;

public class Summary_E extends DashboardSection_E {


    @Given("the user is on the sign in page")
    public void the_user_is_on_the_sign_in_page() {
        System.out.println("The user is on the sign in page");
       // SeleniumUtils.waitFor(2);
        //Sign_in_factory_E factory_e = new Sign_in_factory_E();
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");

    }

    @When("the user entering a information")
    public void the_user_entering_a_information() {
     //   Sign_in_factory_E signIn = new Sign_in_factory_E();
     //   signIn.SignIn();
        System.out.println( "the user entering a information" );
        Sign_in_factory_E factory_e = new Sign_in_factory_E();
        SeleniumUtils.waitFor(5);
        factory_e.userName();
        factory_e.setPassword();
        //new Sign_in_factory_E().SummaryLogInMethod();
    }



    @And("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        System.out.println( "The user should be able to sign in" );
        SeleniumUtils.waitFor( 2 );
        Sign_in_factory_E factory_e = new Sign_in_factory_E();
        factory_e.loGin();

    }
    @Then("user enters loan application page")
    public void user_enters_loan_application_page() {
        new PreApproval_Details_Page_R().clickMortgageApplication();
            SeleniumUtils.waitFor(5);

    }

}
