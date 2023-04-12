package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Employment_And_Income_Page_R;
import pages.PreApproval_Details_Page_R;
import utils.Driver;
import utils.SeleniumUtils;
import java.util.List;
import java.util.Map;


public class Employment_And_Income_Step_Def_R {
    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        Employment_And_Income_Page_R signInPage = new Employment_And_Income_Page_R();
        SeleniumUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/");
    }
    @When("User enters valid username and password and clicks on the sign-in button")
        public void user_enters_valid_username_and_password_and_clicks_on_the_sign_in_button() {
        new PreApproval_Details_Page_R().LogInMethod();
        SeleniumUtils.waitFor(5);
    }

    @When("User clicks mortgage application")
        public void user_clicks_mortgage_application() {
        Employment_And_Income_Page_R employment_and_income_page = new Employment_And_Income_Page_R();
        SeleniumUtils.waitFor(5);
        new PreApproval_Details_Page_R().clickMortgageApplication();
    }

    @Then("User fills out all the required fields and navigates to Employment and Income page")
        public void user_fills_out_all_the_required_fields_and_navigates_to_employment_and_income_page() {
        Employment_And_Income_Page_R employment_and_income_page = new Employment_And_Income_Page_R();
        new Employment_And_Income_Page_R().getToEmploymentAndIncome();
    }
    @Given("User is on the Employment and Income page")
    public void the_user_is_on_employment_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Borrower Employment Information"));
    }
    @When("User enters the employer information")
    public void user_enters_the_employer_information(List<List<String>> dataTable) {
        List<String> employerDetails = dataTable.get(1);
        System.out.println(dataTable);
        new Employment_And_Income_Page_R().enterCredentials(employerDetails.get(0),
        employerDetails.get(1),
        employerDetails.get(2),
        employerDetails.get(3));
    }

    @When("User enters another employer information with the following credentials")
    public void user_enters_another_employer_information_with_the_following_credentials(List<List<String>> dataTable) {
        List<String > secondEmployerDetails =  dataTable.get(1);
        System.out.println(dataTable);
        new Employment_And_Income_Page_R().enterSecondEmployer(secondEmployerDetails.get(0),
                secondEmployerDetails.get(1),
                secondEmployerDetails.get(2),
                secondEmployerDetails.get(3),
                secondEmployerDetails.get(4));
    }

    @Then("User should be able to click on next button")
    public void user_should_be_able_to_click_on_next_button() {
        Employment_And_Income_Page_R employment_and_income_page = new Employment_And_Income_Page_R();
        employment_and_income_page.nextButton.click();

    }
    @When("User is at STATE dropdown menu in Employment and Income page")
    public void user_is_at_state_dropdown_menu_in_employment_and_income_page() {
        new Employment_And_Income_Page_R().state.click();
    }

    @Then("User should be able to see a dropdown list with all {int} US states and their two letter abbreviations.")
    public void user_should_be_able_to_see_a_dropdown_list_with_all_us_states_and_their_two_letter_abbreviations(Integer int1) {
        Assert.assertEquals(new Employment_And_Income_Page_R().expectedStates(), new Employment_And_Income_Page_R().actualStates());
    }

    @When("User enters employer information with the following credentials including the following Gross Monthly Employment Income")
    public void user_enters_employer_information_with_the_following_credentials_including_the_following_gross_monthly_employment_income(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        Map<String,String> additionalIncome = dataTable.get(0);
        new Employment_And_Income_Page_R().enterAdditionalInfo(additionalIncome.get("Employer Name"),
                additionalIncome.get("Position"),
                additionalIncome.get("City"),
                additionalIncome.get("Start Date"),
                additionalIncome.get("Gross Monthly Income"),
                additionalIncome.get("Monthly Overtime"),
                additionalIncome.get("Monthly Bonuses"),
                additionalIncome.get("Monthly Commissions"),
                additionalIncome.get("Monthly Dividends"));
    }

}
