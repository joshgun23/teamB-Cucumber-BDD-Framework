package stepDefinitions.db;

import com.github.javafaker.Faker;
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
        PreApproval_Details_Page_R page = new PreApproval_Details_Page_R();
        page.LogInMethod();
        SeleniumUtils.waitFor(5);
    }

    @Then("user is redirected to the Dashboard page")
    public void user_is_redirected_to_the_dashboard_page() {
    }

    @When("user clicks on Mortgage Application button")
    public void user_clicks_on_mortgage_application_button() {
        PreApproval_Details_Page_R page = new PreApproval_Details_Page_R();
        SeleniumUtils.waitFor(10);
        page.clickMortgageApplication();
    }

    @Then("user is redirected to the PreApproval Details page")
    public void user_is_redirected_to_the_pre_approval_details_page() {
    }

    @Given("user is on the PreApproval Details page")
    public void user_is_on_the_pre_approval_details_page() {
    }

    @When("user fills out PreApproval Details page form fields using valid information")
    public void user_fills_out_preapproval_details_page_form_fields_using_valid_information(List<Map<String, String>> dataTable) {
        Map<String, String> formData = dataTable.get(0);
        PreApproval_Details_Page_R page = new PreApproval_Details_Page_R();
        page.fillOutTheForm(
                formData.get("realtor_status"),
                formData.get("realtor_info"),
                formData.get("loan_officer_status"),
                formData.get("purpose_loan"),
                formData.get("est_purchase_price"),
                formData.get("down_payment"),
                formData.get("down_payment_percent"),
                formData.get("total_loan_amount"),
                formData.get("src_down_payment"),
                formData.get("add_fund_available"));
        page.clickNext();
        page.personalInfo();
        page.fillOutExpensesForm();
        new Employment_And_Income_Page_R().passEmploymentPage();
        page.fillingCreditReport();
        page.fillingOutEconsent();
        page.clickSubmit();
        SeleniumUtils.waitFor(5);
    }

    private String getLastId() {
        List<List<Object>> dbResults = DBUtils.getListOfLists("SELECT MAX(id) from tbl_mortagage");
        return dbResults.get(0).get(0).toString();
    }

    @Then("verify mortgage preapproval details are stored in the table")
    public void verify_mortgage_preapproval_details_are_stored_in_the_table(List<Map<String, String>> dataTable) throws SQLException {
        String actualId = getLastId();
        try {
            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage WHERE id = " + actualId);
            Map<String, String> expectedData = dataTable.get(0);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(actual.get(0).get("realtor_status")).isEqualTo(Integer.parseInt(expectedData.get("realtor_status")));
            softAssertions.assertThat((String) actual.get(0).get("realtor_info")).isEqualTo(expectedData.get("realtor_info"));
            softAssertions.assertThat(actual.get(0).get("loan_officer_status")).isEqualTo(Integer.parseInt(expectedData.get("loan_officer_status")));
            softAssertions.assertThat((String) actual.get(0).get("purpose_loan")).isEqualTo(expectedData.get("purpose_loan"));
            softAssertions.assertThat((String) actual.get(0).get("est_purchase_price")).isEqualTo(expectedData.get("est_purchase_price"));
            softAssertions.assertThat((String) actual.get(0).get("down_payment")).isEqualTo(expectedData.get("down_payment"));
            softAssertions.assertThat((String) actual.get(0).get("down_payment_percent")).isEqualTo(expectedData.get("down_payment_percent"));
            softAssertions.assertThat((String) actual.get(0).get("total_loan_amount")).isEqualTo(expectedData.get("total_loan_amount"));
            softAssertions.assertThat((String) actual.get(0).get("src_down_payment")).isEqualTo(expectedData.get("src_down_payment"));
            softAssertions.assertThat((String) actual.get(0).get("add_fund_available")).isEqualTo(expectedData.get("add_fund_available"));
            softAssertions.assertAll();
        } finally {
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage WHERE id=" + actualId);
        }
    }

    @When("user selects checkboxes for {string} and {string} sections in the PreApproval details page")
    public void user_selects_checkboxes_for_and_sections_in_the_pre_approval_details_page(String realtor_status_checkbox, String loan_officer_status_checkbox) {
        Faker faker = new Faker();
        PreApproval_Details_Page_R page = new PreApproval_Details_Page_R();
        page.fillOutTheForm(realtor_status_checkbox,
                faker.name().fullName(),
                loan_officer_status_checkbox,
                "Purchase a Home",
                "700000",
                "50000",
                "7",
                "650000",
                "Other type of Down Payment",
                "35000");
        page.clickNext();
        page.personalInfo();
        page.fillOutExpensesForm();
        new Employment_And_Income_Page_R().passEmploymentPage();
        page.fillingCreditReport();
        page.fillingOutEconsent();
        page.clickSubmit();
        SeleniumUtils.waitFor(5);
    }

    @Then("the corresponding integer values should be stored in the {string} and {string} columns respectively")
    public void the_corresponding_integer_values_should_be_stored_in_the_and_columns_respectively(String realtor_status, String loan_officer_status) throws SQLException {
        String actualId = getLastId();
        try {
            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(actual.get(0).get("realtor_status")).isEqualTo(Integer.parseInt(realtor_status));
            softAssertions.assertThat(actual.get(0).get("loan_officer_status")).isEqualTo(Integer.parseInt(loan_officer_status));
            softAssertions.assertAll();
        } finally {
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }
    }

    @When("user enters the following information in the realtor_info, purpose_loan, and src_down_payment columns in the PreApproval details page:")
    public void user_enters_the_following_information_in_the_realtor_info_purpose_loan_and_src_down_payment_columns_in_the_pre_approval_details_page(List<Map<String, String>> dataTable) {
        Map<String, String> formData = dataTable.get(0);
        PreApproval_Details_Page_R page = new PreApproval_Details_Page_R();
        page.fillOutTheForm(
                "Yes",
                formData.get("realtor_info"),
                "Yes",
                formData.get("purpose_loan"),
                "700000",
                "50000",
                "7",
                "650000",
                formData.get("src_down_payment"),
                "35000");
        page.clickNext();
        page.personalInfo();
        page.fillOutExpensesForm();
        new Employment_And_Income_Page_R().passEmploymentPage();
        page.fillingCreditReport();
        page.fillingOutEconsent();
        page.clickSubmit();
        SeleniumUtils.waitFor(5);
    }

    @Then("all entered values should be stored as a String values")
    public void all_entered_values_should_be_stored_as_a_string_values() throws SQLException {
        String actualId = getLastId();
        try {
            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(actual.get(0).get("realtor_info") instanceof String);

            softAssertions.assertThat(actual.get(0).get("purpose_loan") instanceof String);

            softAssertions.assertThat(actual.get(0).get("src_down_payment") instanceof String);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }
    }
    @When("user inputs the following information for the est_purchase_price, down_payment, down_payment_percent, total_loan_amount, and add_fund_available columns")
    public void user_inputs_the_following_information_for_the_est_purchase_price_down_payment_down_payment_percent_total_loan_amount_and_add_fund_available_columns(List<Map<String, String>> dataTable) {
        Map<String, String> formData = dataTable.get(0);
        PreApproval_Details_Page_R page = new PreApproval_Details_Page_R();
        page.fillOutTheForm(
                "Yes",
                "Keller Williams",
                "Yes",
                "Purchase a Home",
                formData.get("est_purchase_price"),
                formData.get("down_payment"),
                formData.get("down_payment_percent"),
                formData.get("total_loan_amount"),
                "Other type of Down Payment",
                formData.get("add_fund_available"));
        page.clickNext();
        page.personalInfo();
        page.fillOutExpensesForm();
        new Employment_And_Income_Page_R().passEmploymentPage();
        page.fillingCreditReport();
        page.fillingOutEconsent();
        page.clickSubmit();
        SeleniumUtils.waitFor(5);
    }

    @Then("all entered values should be stored as integers in the system")
    public void all_entered_values_should_be_stored_as_integers_in_the_system() throws SQLException {
        String actualId = getLastId();
        try {
            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(actual.get(0).get("est_purchase_price") instanceof Integer);
            softAssertions.assertThat(actual.get(0).get("down_payment") instanceof Integer);
            softAssertions.assertThat(actual.get(0).get("down_payment_percent") instanceof Integer);
            softAssertions.assertThat(actual.get(0).get("total_loan_amount") instanceof Integer);
            softAssertions.assertThat(actual.get(0).get("add_fund_available") instanceof Integer);
            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }
    }
    @When("user enters the following data {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} into the PreApproval Details page form fields")
    public void user_enters_the_following_data_into_the_pre_approval_details_page_form_fields(String realtor_status, String realtor_info, String loan_officer_status,
                                                                                              String purpose_loan, String est_purchase_price, String down_payment,
                                                                                              String down_payment_percent, String total_loan_amount,
                                                                                              String src_down_payment, String add_fund_available) {
        PreApproval_Details_Page_R page = new PreApproval_Details_Page_R();
        page.fillOutTheForm(
                realtor_status,
                realtor_info,
                loan_officer_status,
                purpose_loan,
                est_purchase_price,
                down_payment,
                down_payment_percent,
                total_loan_amount,
                src_down_payment,
                add_fund_available);
        page.clickNext();
        page.personalInfo();
        page.fillOutExpensesForm();
        new Employment_And_Income_Page_R().passEmploymentPage();
        page.fillingCreditReport();
        page.fillingOutEconsent();
        page.clickSubmit();
        SeleniumUtils.waitFor(5);
    }
    @Then("the data should be correctly mapped to the following column names {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} in the tbl_mortagage table:")
    public void the_data_should_be_correctly_mapped_to_the_following_column_names_in_the_tbl_mortagage_table(String realtor_status, String realtor_info, String loan_officer_status,
                                                                                                             String purpose_loan, String est_purchase_price, String down_payment,
                                                                                                             String down_payment_percent, String total_loan_amount, String src_down_payment,
                                                                                                             String add_fund_available) throws SQLException {
        String actualId = getLastId();
        try {
            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat( actual.get(0).get("realtor_status")).isEqualTo(Integer.parseInt(realtor_status));
            softAssertions.assertThat((String) actual.get(0).get("realtor_info")).isEqualTo(realtor_info);
            softAssertions.assertThat( actual.get(0).get("loan_officer_status")).isEqualTo(Integer.parseInt(loan_officer_status));
            softAssertions.assertThat((String) actual.get(0).get("purpose_loan")).isEqualTo(purpose_loan);
            softAssertions.assertThat((String) actual.get(0).get("est_purchase_price")).isEqualTo(est_purchase_price);
            softAssertions.assertThat((String) actual.get(0).get("down_payment")).isEqualTo(down_payment);
            softAssertions.assertThat((String) actual.get(0).get("down_payment_percent")).isEqualTo(down_payment_percent);
            softAssertions.assertThat((String) actual.get(0).get("total_loan_amount")).isEqualTo(total_loan_amount);
            softAssertions.assertThat((String) actual.get(0).get("src_down_payment")).isEqualTo(src_down_payment);
            softAssertions.assertThat((String) actual.get(0).get("add_fund_available")).isEqualTo(add_fund_available);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }

    }

}





