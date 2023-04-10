sprint 4-2
        package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import pages.*;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class Sprint_4_stepDef_Z {
    @Given("the user is on the electronic consent page")
    public void the_user_is_on_the_electronic_consent_page() {
        Sprint_4th_pageClass_Z signInPage = new Sprint_4th_pageClass_Z();
        Driver.getDriver().manage().window().maximize();
        signInPage.LogInMethod();
        signInPage.mortgageLinkMethod();
        SeleniumUtils.waitFor(3);
        PreApproval_Details_Page_R preApprovalDetailsPage = new PreApproval_Details_Page_R();
        preApprovalDetailsPage.setPreapproval_method("Peppa Pig", 100000, 20000);


        //Coshgun's class -personal information
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setPersonalLastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailAd();
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();
        Assert.assertTrue("personal information", Driver.getDriver().getPageSource().contains("Personal Information"));


        //Martaba's class -expenses
        new ExpensesPage_M().fillOutExpensesForm();
        Assert.assertTrue("expenses", Driver.getDriver().getPageSource().contains("Expenses"));


        //Rina's class -employment and income
        new EmploymentAndIncomePage_R().getToCreditReportPage();
        Assert.assertTrue("employment and income", Driver.getDriver().getPageSource().contains("Employment and Income"));


        //Zaur's class -credit report
        Sprint_4th_pageClass_Z creditReportPage = new Sprint_4th_pageClass_Z();
        creditReportPage.noButtonMethod();
        creditReportPage.creditRepNextMethod();
        Assert.assertTrue("credit report", Driver.getDriver().getPageSource().contains("Credit Report"));


    }

    @When("the user enters their first name as {string}, last name as {string}, and email address as {string}")
    public void the_user_enters_their_first_name_as_last_name_as_and_email_address_as(List<Map<String, String>> dataTable ) {
        new Sprint_4th_pageClass_Z().fillOutFields(dataTable.get(0).get("first_name"), dataTable.get(0).get("last_name"), dataTable.get(0).get("email_address"));

    }

    @Then("the user should see two radio buttons for {string} and {string}")
    public void the_user_should_see_two_radio_buttons_for_and(String agree, String desagree) {
        new Sprint_4th_pageClass_Z().verifyRadioButtons(agree, desagree);

    }


    @Then("the {string} button should be selected by default")
    public void the_button_should_be_selected_by_default(String agree) {
        new Sprint_4th_pageClass_Z().verifyDefaultButton(agree);

    }

    @When("the user presses the {string} button the user should be redirected to the Summary page")
    public void theUserPressesTheButton(String nextButton) {
        Assert.assertTrue("NEXT button", Driver.getDriver().getPageSource().contains("SUMMARY"));


    }

//    @When("the user opens the page on {string} and {string}")
//    public void theUserOpensThePageOnAnd(List<String> browser) {
//        for (String browserName : browser) {
//            Driver.getDriver().get(browserName);

        }


    @When("the user not enters their first name")
    public void theUserNotEntersTheirFirstName() {
        Sprint_4th_pageClass_Z errorr = new Sprint_4th_pageClass_Z();
        errorr.errorMethod();



    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String arg0) {
        Assert.assertTrue("error message", Driver.getDriver().getPageSource().contains("THIS FIELD IS REQUIRED."));


    }

    @When("the user not enters their last name")
    public void theUserNotEntersTheirLastName() {
        Sprint_4th_pageClass_Z errorr = new Sprint_4th_pageClass_Z();
        errorr.errorMethod2();
        Assert.assertTrue("error message", Driver.getDriver().getPageSource().contains("THIS FIELD IS REQUIRED."));

    }

    @When("the user not enters their email address")
    public void theUserNotEntersTheirEmailAddress() {
        Sprint_4th_pageClass_Z errorr = new Sprint_4th_pageClass_Z();
        errorr.errorMethod3();
        Assert.assertTrue("error message", Driver.getDriver().getPageSource().contains("THIS FIELD IS REQUIRED."));

    }
}



