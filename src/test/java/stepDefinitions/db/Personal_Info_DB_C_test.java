package stepDefinitions.db;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.DBUtils;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class Personal_Info_DB_C_test {

    String expectedfirstName;

    Faker faker = new Faker();
    @Then("The  tbl_mortagage table should have columns named apply_co_borrower, b_firstName,")
    public void the_tbl_mortagage_table_should_have_columns_named_apply_co_borrower_b_first_name() {

        DBUtils.createConnection();
        List<String> actuallycolumnNames = DBUtils.getColumnNames("SELECT b_firstName,\n" +
                "b_middleName, b_lastName, b_suffix, b_email, b_dob, b_ssn, b_marital, b_cell, b_home\n" +
                "FROM tbl_mortagage\n");

        String expectedColumnNames = "b_firstName, b_middleName, b_lastName, b_suffix, b_email, b_dob, b_ssn, b_marital, b_cell, b_home";

        List<String> expectedColumnNamesList = Arrays.asList(expectedColumnNames.split("\\s*,\\s*"));

        Assert.assertEquals(actuallycolumnNames, expectedColumnNamesList);
        System.out.println(actuallycolumnNames);

    }

    @When("the user enters the personal information page")
    public void theUserEntersThePersonalInformationPage( List<List<String>> dataTable) {

        expectedfirstName = dataTable.get(0).get(0);
        String middleName = dataTable.get(0).get(1);
        String lastName = dataTable.get(0).get(2);
        String email12 = dataTable.get(0).get(3);
        String dateOfBirth12 = dataTable.get(0).get(4);

        // Fill out the personal information section
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        Employment_And_Income_Page_R employment_and_income_page_r = new Employment_And_Income_Page_R();
        personalI_page_factory_c.setPersonalDataTName(expectedfirstName);
        personalI_page_factory_c.setPersonalDataTMiddleName(middleName);
        personalI_page_factory_c.setPersonalDataTLastName(lastName);
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailDataTAd(email12);
        personalI_page_factory_c.setPerdataDataTBirth(dateOfBirth12);
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();
        personalI_page_factory_c.setHousingExpenses();
        personalI_page_factory_c.setHousingExpensesClick();
        employment_and_income_page_r.employer.sendKeys("joshKOnur");
        employment_and_income_page_r.position.sendKeys("menager");
        employment_and_income_page_r.enterCity.sendKeys("columbia");
        employment_and_income_page_r.state.sendKeys("maryland");
        employment_and_income_page_r.startDate.sendKeys("02022223");
        employment_and_income_page_r.enterGrossMonthlyIncome.sendKeys("10000");
        employment_and_income_page_r.nextButton.click();
        personalI_page_factory_c.setCreditReportJoshgun();
        personalI_page_factory_c.setCreditReportClick();
        personalI_page_factory_c.seteConsentFName();
        personalI_page_factory_c.seteConsentLName();
        personalI_page_factory_c.seteConsentEmail();
        personalI_page_factory_c.seteConsentAgree();
        personalI_page_factory_c.seteConsentClick();
        personalI_page_factory_c.setSummarySubmit();
    }

    @Then("A table named tbl_mortagage should store the borrower's and co-borrower’s personal information.")
    public void aTableNamedTbl_mortagageShouldStoreTheBorrowerSAndCoBorrowerSPersonalInformation() {


        List<List<Object>> listOfLists = DBUtils.getListOfLists("select b_firstName from tbl_mortagage where b_firstName='" + expectedfirstName + "'");

        System.out.println("Expected First Name: " + expectedfirstName);
        String actualFirstNameRecorded = (String) (listOfLists.get(0).get(0));
        System.out.println("Actual First Name Recorded in the DB: " + actualFirstNameRecorded);
        Assert.assertEquals(expectedfirstName, actualFirstNameRecorded);

    }
    }

//    @When("I enter the borrower's information:")
//    public void i_enter_the_borrower_s_information(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I select {string} for co-borrower question")
//    public void i_select_for_co_borrower_question(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I enter the co-borrower's information:")
//    public void i_enter_the_co_borrower_s_information(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I submit the form")
//    public void i_submit_the_form() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("the borrower's and co-borrower's information should be stored in the {string} table in the database")
//    public void the_borrower_s_and_co_borrower_s_information_should_be_stored_in_the_table_in_the_database(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }



