package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pages.Employment_And_Income_Page_R;
import pages.PreApproval_Details_Page_R;
import utils.SeleniumUtils;
import utils.DBUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PreApproval_Details_DB_R_test {

    @Given("user navigates to the SignIn page")
    public void user_navigates_to_the_sign_in_page() {
    }
    @When("user enters a valid email address and password and clicks on Sing In button")
    public void user_enters_a_valid_email_address_and_password_and_clicks_on_sing_in_button() {
        PreApproval_Details_Page_R preApproval_details_page = new PreApproval_Details_Page_R();
        preApproval_details_page.LogInMethod();
        SeleniumUtils.waitFor(5);
    }
    @Then("user is redirected to the Dashboard page")
    public void user_is_redirected_to_the_dashboard_page() {
    }
    @When("user clicks on Mortgage Application button")
    public void user_clicks_on_mortgage_application_button() {
        PreApproval_Details_Page_R preApproval_details_page = new PreApproval_Details_Page_R();
        SeleniumUtils.waitFor(10);
        preApproval_details_page.clickMortgageApplication();
    }
    @Then("user is redirected to the PreApproval Details page")
    public void user_is_redirected_to_the_pre_approval_details_page() {
    }
    @Given("user is on the PreApproval Details page")
    public void user_is_on_the_pre_approval_details_page() {
    }
    @When("user fills out PreApproval Details page form fields using valid information")
    public void user_fills_out_preapproval_details_page_form_fields_using_valid_information(List<Map<String, String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
        new PreApproval_Details_Page_R().fillOutTheForm(
        data.get("realtor_status"),
        data.get("realtor_info"),
        data.get("loan_officer_status"),
        data.get("purpose_loan"),
        data.get("est_purchase_price"),
        data.get("down_payment"),
        data.get("down_payment_percent"),
        data.get("total_loan_amount"),
        data.get("src_down_payment"),
        data.get("add_fund_available"));
        new PreApproval_Details_Page_R().clickNext();
        new PreApproval_Details_Page_R().personalInfo();
        new PreApproval_Details_Page_R().fillOutExpensesForm();
        new Employment_And_Income_Page_R().passEmploymentPage();
        new PreApproval_Details_Page_R().fillingCreditReport();
        new PreApproval_Details_Page_R().fillingOutEconsent();
        new PreApproval_Details_Page_R().clickSubmit();
        SeleniumUtils.waitFor(5);
    }
    private String getLastId(){
        List<List<Object>> dbResults = DBUtils.getListOfLists("SELECT MAX(id) from tbl_mortagage");
        return dbResults.get(0).get(0).toString();
    }
    @Then("entered details for Mortgage PreApproval can be viewed by the user in their respective columns")
    public void entered_details_for_mortgage_preapproval_can_be_viewed_by_the_user_in_their_respective_columns(List<Map<String, String>> dataTable) throws SQLException {
        String actualId = null;
        try {
            actualId = getLastId();
            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage WHERE id = " + actualId);
            Map<String, String> expected = dataTable.get(0);

            String expectedRealtorStatus = expected.get("realtor_status");
            String expectedRealtorInfo = expected.get("realtor_info");
            String expectedLoanOfficerStatus = expected.get("loan_officer_status");
            String expectedPurposeLoan = expected.get("purpose_loan");
            String expectedEstPrice = expected.get("est_purchase_price");
            String expectedDownPayment = expected.get("down_payment");
            String expectedDownPaymentPercent = expected.get("down_payment_percent");
            String expectedTotalLoanAmount = expected.get("total_loan_amount");
            String expectedSrcDownPayment = expected.get("src_down_payment");
            String expectedAddFundAvailable = expected.get("add_fund_available");

            String actualRealtorStatus = actual.get(Integer.parseInt("realtor_status")).toString();
            String actualRealtorInfo = actual.get(Integer.parseInt("realtor_info")).toString();
            String actualLoanOfficerStatus = actual.get(Integer.parseInt("loan_officer_status")).toString();
            String actualPurposeLoan = actual.get(Integer.parseInt("purpose_loan")).toString();
            String actualEstPrice = actual.get(Integer.parseInt("est_purchase_price")).toString();
            String actualDownPayment = actual.get(Integer.parseInt("down_payment")).toString();
            String actualDownPaymentPercent = actual.get(Integer.parseInt("down_payment_percent")).toString();
            String actualTotalLoanAmount = actual.get(Integer.parseInt("total_loan_amount")).toString();
            String actualSrcDownPayment = actual.get(Integer.parseInt("src_down_payment")).toString();
            String actualAddFundAvailable = actual.get(Integer.parseInt("add_fund_available")).toString();

            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(actualRealtorStatus).isEqualTo(expectedRealtorStatus);
            softAssertions.assertThat(actualRealtorInfo).isEqualTo(expectedRealtorInfo);
            softAssertions.assertThat(actualLoanOfficerStatus).isEqualTo(expectedLoanOfficerStatus);
            softAssertions.assertThat(actualPurposeLoan).isEqualTo(expectedPurposeLoan);
            softAssertions.assertThat(actualEstPrice).isEqualTo(expectedEstPrice);
            softAssertions.assertThat(actualDownPayment).isEqualTo(expectedDownPayment);
            softAssertions.assertThat(actualDownPaymentPercent).isEqualTo(expectedDownPaymentPercent);
            softAssertions.assertThat(actualTotalLoanAmount).isEqualTo(expectedTotalLoanAmount);
            softAssertions.assertThat(actualSrcDownPayment).isEqualTo(expectedSrcDownPayment);
            softAssertions.assertThat(actualAddFundAvailable).isEqualTo(expectedAddFundAvailable);
            softAssertions.assertAll();
        } finally {
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage WHERE id =" + actualId);
        }
    }
}






