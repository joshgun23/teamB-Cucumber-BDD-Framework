package stepDefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ExpensesPage_M;
import pages.Sign_in_factory_Z;
import utils.SeleniumUtils;

public class Step_def_M {


    @Given("the user is on the Expenses page")
    public void givenTheUserIsOnTheExpensesPage() {
        ExpensesPage_M expenses = new ExpensesPage_M();
        expenses.fillOutExpensesForm();


    }
//    public void givenTheUserIsOnTheExpensesPage() {
//        System.out.println("The user is on the Expenses in page");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//
//    }
//
//    @When("the user selects \"Rent\" button from question")
//    public void whenTheUserSelectsRentButtonFromQuestion() {
//        System.out.println("the user selects \"Rent\" button from question");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//    }
//
//    @Then("another section payment is displayed")
//    public void ThenAnotherSectionPaymentIsDisplayed() {
//        System.out.println("another section payment is displayed");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//    }
//
//    @Given("the user is on the Expenses page")
//    public void givenTheUserIsOnTheExpensesPage2() {
//        System.out.println("The user is on the Expenses in page");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//
//    }
//
//    @When("the user enter the rent amount")
//    public void WhenTheUserEntersTheRentAmount() {
//        System.out.println("the user enter the rent amount");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//    }
//
//    @Then("the user should not see message \"This field is required\"")
//    public void ThenTheUserShouldNotSeeMessageThisFieldIsRequired() {
//        System.out.println("another section payment is displayed");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//    }
//
//    @Given("the user is on the Expenses page")
//    public void givenTheUserIsOnTheExpensesPage3() {
//        System.out.println("The user is on the Expenses in page");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//
//    }
//
//    @When("the user choose \"save\" button")
//    public void WhenTheUserChooseSaveButton() {
//        System.out.println("the user enter the rent amount");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//    }
//
//    @Then("all the required fields are filled out")
//    public void ThenAllTheRequiredFieldsAreFilledOut() {
//        System.out.println("another section payment is displayed");
//        ExpensesPage_M expenses = new ExpensesPage_M();
//
//
//    }

}









