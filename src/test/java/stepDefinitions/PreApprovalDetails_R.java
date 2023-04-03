package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.PreApproval_Details_Page_R;
import utils.Driver;
import utils.SeleniumUtils;


public class PreApprovalDetails_R {


    String purposeOfLoan;
    String estimatedPurchasePrice;
    String downPaymentAmount;
    String paymentSourceAnotherType;
    String realtorInfo;
    String expectedLoanAmount;
    String calculatedLoanAmount;


    @Given("The user navigates to the SignIn page")
    public void the_user_navigates_to_the_sign_in_page() {
      PreApproval_Details_Page_R signInPage = new PreApproval_Details_Page_R();
        SeleniumUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/");
    }

    @When("The user enters a valid email address and password")
    public void the_user_enters_a_valid_email_address_and_password() {
        new PreApproval_Details_Page_R().LogInMethod();
    }
    @When("The user clicks on the Mortgage application page")
    public void the_user_clicks_on_the_mortgage_application_page() {
        new PreApproval_Details_Page_R().clickMortgageApplication();
        SeleniumUtils.waitFor(5);
    }

    @Then("The user should be able to sign in and should be redirected to the mortgage application page")
    public void the_user_should_be_able_to_sign_in() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Duobank Mortgage Application"));
    }

    @When("The user clicks on the realtor checkbox")
    public void the_user_clicks_on_the_realtor_checkbox() {
        new PreApproval_Details_Page_R().realtorCheckBox();
    }
    @Then("The realtor checkbox is checked")
    public void the_realtor_checkbox_is_checked() {
        new PreApproval_Details_Page_R().realtorYes.isSelected();
    }

    @When("The user fills out all fields on the preapproval details page")
    public void the_user_fills_out_all_fields_on_the_preapproval_details_page() {
        purposeOfLoan = "Purchase A Home";
        estimatedPurchasePrice = "" + (40000 + (int)(Math.random() * 40000));
        downPaymentAmount = "" + (10000 + (int)(Math.random() * 30000));
        paymentSourceAnotherType = "Other type of Down Payment";
        realtorInfo = new Faker().name().fullName() + ", " + new Faker().internet().emailAddress();
        PreApproval_Details_Page_R applicationPage = new PreApproval_Details_Page_R();
        applicationPage.realtorInfoField.sendKeys(realtorInfo);
        applicationPage.loanOfficerNo.click();
        applicationPage.purposeOfLoanButton.click();
        applicationPage.purposeOfLoanField.sendKeys(purposeOfLoan, Keys.ENTER);
        applicationPage.estimatedPrice.sendKeys(estimatedPurchasePrice);
        applicationPage.downPaymentAmount.sendKeys(downPaymentAmount);
        applicationPage.downPaymentSourceButton.click();
        applicationPage.downPaymentSourceField.sendKeys(paymentSourceAnotherType, Keys.ENTER);
        applicationPage.buttonNext.click();
    }
    @Then("The user move on to the personal information page by clicking on Next button")
    public void the_user_move_on_to_the_personal_information_page_by_clicking_on_next_button() {
        String personalInfoPage = "PERSONAL INFORMATION";
        PreApproval_Details_Page_R applicationPage = new PreApproval_Details_Page_R();
        Assert.assertEquals(applicationPage.personalInformationPageText.getText(), personalInfoPage);
    }
    @When("The user fills out necessary fields on the preapproval details page")
    public void the_user_fills_out_necessary_fields_on_the_preapproval_details_page() {
        purposeOfLoan = "Purchase A Home";
        estimatedPurchasePrice = "" + (40000 + (int)(Math.random() * 40000));
        downPaymentAmount = "" + (10000 + (int)(Math.random() * 30000));
        paymentSourceAnotherType = "Other type of Down Payment";
        realtorInfo = new Faker().name().fullName() + ", " + new Faker().internet().emailAddress();
        PreApproval_Details_Page_R applicationPage = new PreApproval_Details_Page_R();
        applicationPage.realtorInfoField.sendKeys(realtorInfo);
        applicationPage.loanOfficerNo.click();
        applicationPage.purposeOfLoanButton.click();
        applicationPage.purposeOfLoanField.sendKeys(purposeOfLoan, Keys.ENTER);
        applicationPage.estimatedPrice.sendKeys(estimatedPurchasePrice);
        applicationPage.downPaymentAmount.sendKeys(downPaymentAmount);
        applicationPage.downPaymentSourceButton.click();
        applicationPage.downPaymentSourceField.sendKeys(paymentSourceAnotherType, Keys.ENTER);
    }
    @Then("The user can check calculated loan amount percentage")
    public void the_user_can_check_calculated_loan_amount_percentage() {
        String calculatedPercentage = new PreApproval_Details_Page_R().downPaymentPercentage.getAttribute("value");
        String expectedDownPaymentPercentage = "" + (Integer.parseInt(downPaymentAmount) * 100
                / Integer.parseInt(estimatedPurchasePrice));
        Assert.assertEquals(calculatedPercentage, expectedDownPaymentPercentage);
    }

    @Then("The user can check calculated loan amount")
    public void the_user_can_check_calculated_loan_amount() {
        expectedLoanAmount = "" + (Integer.parseInt(estimatedPurchasePrice) - Integer.parseInt(downPaymentAmount));
        calculatedLoanAmount = new PreApproval_Details_Page_R().calculatedLoanAmountValue.getAttribute("value");
        Assert.assertEquals(calculatedLoanAmount, expectedLoanAmount);
    }

    @When("The user fills out all the necesarry fields on the preapproval details page using {string} as a realtor information")
    public void the_user_fills_out_all_the_necesarry_fields_on_the_preapproval_details_page_using_as_a_realtor_information(String string) {
        purposeOfLoan = "Purchase A Home";
        estimatedPurchasePrice = "" + (40000 + (int)(Math.random() * 40000));
        downPaymentAmount = "" + (10000 + (int)(Math.random() * 30000));
        paymentSourceAnotherType = "Other type of Down Payment";
        realtorInfo = "!@#$%^&*()";
        PreApproval_Details_Page_R applicationPage = new PreApproval_Details_Page_R();
        applicationPage.realtorInfoField.sendKeys(realtorInfo);
        applicationPage.loanOfficerNo.click();
        applicationPage.purposeOfLoanButton.click();
        applicationPage.purposeOfLoanField.sendKeys(purposeOfLoan, Keys.ENTER);
        applicationPage.estimatedPrice.sendKeys(estimatedPurchasePrice);
        applicationPage.downPaymentAmount.sendKeys(downPaymentAmount);
        applicationPage.downPaymentSourceButton.click();
        applicationPage.downPaymentSourceField.sendKeys(paymentSourceAnotherType, Keys.ENTER);
        applicationPage.buttonNext.click();
    }
    @Then("The user should not be able to move on to the personal information page by clicking on Next button")
    public void the_user_should_not_be_able_to_move_on_to_the_personal_information_page_by_clicking_on_next_button() {
        String personalInformationPageTextExpected = "PERSONAL INFORMATION";
        PreApproval_Details_Page_R applicationPage = new PreApproval_Details_Page_R();
        Assert.assertEquals(applicationPage.personalInformationPageText.getText(), personalInformationPageTextExpected);
    }
}
