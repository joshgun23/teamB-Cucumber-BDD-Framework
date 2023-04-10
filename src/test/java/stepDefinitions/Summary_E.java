package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DashboardSection_E;
import pages.PreApproval_Details_Page_R;
import pages.Sign_in_factory_E;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import static org.junit.Assert.assertTrue;

public class Summary_E extends Sign_in_factory_E  {


    @Given("the user is on the sign in page")
    public void the_user_is_on_the_sign_in_page() {
        System.out.println( "The user is on the sign in page" );
            Driver.getDriver().get( ConfigReader.getProperty("homepage"));
        SeleniumUtils.waitFor(3);
    //    Sign_in_factory_E factory_e = new Sign_in_factory_E();

    }

    @When("the user entering a information")
    public void the_user_entering_a_information() {

        System.out.println( "the user entering a information" );
        Sign_in_factory_E factory_e = new Sign_in_factory_E();
     SeleniumUtils.waitFor( 5 );
       factory_e.userName();
       factory_e.setPassword();
       //new Sign_in_factory_E().SummaryLogInMethod();

       // Sign_in_factory_E signIn = new Sign_in_factory_E();
         //signIn.SignIn();
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
        SeleniumUtils.waitFor(2  );

    }

    @Given("user on the mortgageSummary page")
    public void user_on_the_summary_page() {
        new Sign_in_factory_E().clickMortgageSummary();
        SeleniumUtils.waitFor( 2 );

    }

    @When("user enters preapproval page")
    public void user_enters_preapprovel_page() {
        assertTrue( Driver.getDriver().getPageSource().contains( "Duobank Mortgage Application" ) );
    }

    @And("all required fields are filled out information")
    public void all_required_fields_are_filled_out_information() {
        new PreApproval_Details_Page_R().realtorNo.isSelected();
        String estimatedPurchasePrice;
        String downPaymentAmount;
        estimatedPurchasePrice = "" + (10 + (int) (Math.random() * 100));
        downPaymentAmount = "" + (1 + (int) (Math.random() * 9));

        Sign_in_factory_E summaryPage = new Sign_in_factory_E();
        summaryPage.estimatedPrice.sendKeys( estimatedPurchasePrice );
        summaryPage.downPaymentAmount.sendKeys( downPaymentAmount );
        SeleniumUtils.waitFor( 2 );
    }

    @Then("able to click summary page")
    public void able_to_click_summary_page() {
        Sign_in_factory_E summaryPage = new Sign_in_factory_E();
        summaryPage.summaryLink.click();
    }

    @And("user can see edit buttons")
    public void user_can_see_edit_buttons() {
        System.out.println( "user can see edit buttons" );
        WebElement editButton = Driver.getDriver().findElement( By.xpath( "//a[@class='btn btn-success buttonEdit' and @id='PersonalnformationEdit']" ) );
        assertTrue( editButton.isDisplayed() );
    }

    @When("user can click edit button")
    public void user_can_click_edit_button() {
        System.out.println( "user can click edit button" );
        WebElement editButton = Driver.getDriver().findElement( By.xpath( "//a[@class='btn btn-success buttonEdit' and @id='PersonalnformationEdit']" ) );
        editButton.click();
    }

    @And("user back to the relevant page")
    public void user_back_to_the_relevant_page() {
        Sign_in_factory_E summaryPage = new Sign_in_factory_E();
        summaryPage.summaryLink.click();
    }

    @Then("clicking the Submit button should submit the application")
    public void clicking_the_Submit_button_should_submit_the_application() {
        System.out.println( "clicking the Submit button should submit the application" );
        WebElement submitButton = Driver.getDriver().findElement( By.xpath( "//a[@href='#finish']" ) );
        submitButton.click();
    }
}