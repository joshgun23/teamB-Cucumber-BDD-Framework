package stepDefinitions.db;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.*;
import utils.DBUtils;
import utils.Driver;
import utils.SeleniumUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class Personal_Info_DB_C_test {

    String expectedfirstName;

    String middleName;

    String lastName;

    String colastName;

    String employerName;

    String exfirstName;

    String expLast;

    String expMiddle;

    String expEmail12;

    String dateOfBirth12;

    String email12;

    String email13;

    String emailDB1;

    String marytalStatusDB;

    Faker faker = new Faker();

    @Then("The  tbl_mortagage table should have columns named apply borrower, b_firstName,")
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
    public void theUserEntersThePersonalInformationPage(List<List<String>> dataTable) {

        expectedfirstName = dataTable.get(0).get(0);
        middleName = dataTable.get(0).get(1);
        lastName = dataTable.get(0).get(2);
        email12 = dataTable.get(0).get(3);
        dateOfBirth12 = dataTable.get(0).get(4);

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

    @Then("A table named tbl_mortagage should store the borrower's information")
    public void aTableNamedTbl_mortagageShouldStoreTheBorrowerSAndCoBorrowerSPersonalInformation() {


        List<List<Object>> listOfLists = DBUtils.getListOfLists("select b_firstName from tbl_mortagage where b_firstName='" + expectedfirstName + "'");

        System.out.println("Expected First Name: " + expectedfirstName);
        String actualFirstNameRecorded = (String) (listOfLists.get(0).get(0));
        System.out.println("Actual First Name Recorded in the DB: " + actualFirstNameRecorded);
        Assert.assertEquals(expectedfirstName, actualFirstNameRecorded);
//        DBUtils.close();
    }

    @Then("The  tbl_mortagage table should have columns named apply_co_borrower, b_firstName,")
    public void theTbl_mortagageTableShouldHaveColumnsNamedApply_co_borrowerB_firstName() {
        colastName = faker.name().lastName();
        employerName = faker.name().firstName();
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        Employment_And_Income_Page_R employment_and_income_page_r = new Employment_And_Income_Page_R();
        personalI_page_factory_c.setCoBorrower();
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
        new PersonalI_Page_Factory_C().setCoFirstName();
        new PersonalI_Page_Factory_C().setCoMiddleName();
        new PersonalI_Page_Factory_C().setCoLastNameDB(colastName);
        new PersonalI_Page_Factory_C().setCoSulfixPlace();
        SeleniumUtils.waitFor(2);
        new PersonalI_Page_Factory_C().setCoSulfixSr();
        new PersonalI_Page_Factory_C().setCoEmailAd();
        new PersonalI_Page_Factory_C().setCoDateBirth();
        SeleniumUtils.scrollDown(200);
        new PersonalI_Page_Factory_C().setCoSSN();
        new PersonalI_Page_Factory_C().setCoSSN();
        SeleniumUtils.waitFor(5);
        new PersonalI_Page_Factory_C().setCoMarytalStatus();
        SeleniumUtils.waitFor(2);
        new PersonalI_Page_Factory_C().setCophoneNumber();
        new PersonalI_Page_Factory_C().setCoHomephoneNumber();
        personalI_page_factory_c.setPerCoNextButton();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Current Monthly Housing Expenses"));
        personalI_page_factory_c.setHousingExpenses();
        personalI_page_factory_c.setHousingExpensesClick();
        employment_and_income_page_r.employer.sendKeys("joshKOnur");
        employment_and_income_page_r.position.sendKeys("menager");
        employment_and_income_page_r.enterCity.sendKeys("columbia");
        employment_and_income_page_r.state.sendKeys("maryland");
        employment_and_income_page_r.startDate.sendKeys("02022223");
        employment_and_income_page_r.enterGrossMonthlyIncome.sendKeys("10000");
        personalI_page_factory_c.secondEmployer2.sendKeys(employerName);
        personalI_page_factory_c.setSecondEmployerPosition();
        personalI_page_factory_c.setSecondEmployerCity();
        personalI_page_factory_c.getsecondEmployerState();
        personalI_page_factory_c.setSecondEmployerStartDate();
        employment_and_income_page_r.nextButton.click();
        personalI_page_factory_c.setCreditReportJoshgun();
        personalI_page_factory_c.setCreditReportClick();
        personalI_page_factory_c.seteConsentFName();
        personalI_page_factory_c.seteConsentLName();
        personalI_page_factory_c.seteConsentEmail();
        personalI_page_factory_c.setEconsantPlace();
        personalI_page_factory_c.seteConsentAgree();
        personalI_page_factory_c.seteConsentClick();
        personalI_page_factory_c.setSummarySubmit();
    }

    @Then("A table named tbl_mortagage should store the co_borrower's information")
    public void aTableNamedTbl_mortagageShouldStoreTheCo_borrowerSInformation() {
        List<Map<String, Object>> listOfMaps = DBUtils.getListOfMaps("select c_lastName from tbl_mortagage where c_lastName='" + colastName + "'");

        System.out.println("Expected Last Name: " + colastName);
        //String coactualFirstNameRecorded = (String) (listOfMaps.get(0).get("c_lastName"));
        // System.out.println("Actual First Name Recorded in the DB: " + coactualFirstNameRecorded);
        Assert.assertEquals(colastName, listOfMaps.get(0).get("c_lastName"));
    }

    @Then("The  tbl_mortagage table should have columns correct borrower, email adress")
    public void the_tbl_mortagage_table_should_have_columns_correct_borrower_email_adress() {

        emailDB1 = faker.internet().emailAddress();
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        Employment_And_Income_Page_R employment_and_income_page_r = new Employment_And_Income_Page_R();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setPersonalLastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailDB(emailDB1);
        personalI_page_factory_c.setPerDateBirth();
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

    @Then("A table named tbl_mortagage should store the correct borrower, email adress information")
    public void a_table_named_tbl_mortagage_should_store_the_correct_borrower_email_adress_information() {
        List<List<Object>> listOfLists = DBUtils.getListOfLists("select b_email from tbl_mortagage where b_email='" + emailDB1 + "'");

        System.out.println("Expected Email: " + emailDB1);
        String actualFirstNameRecorded = (String) (listOfLists.get(0).get(0));
        System.out.println("Actual Email Recorded in the DB: " + actualFirstNameRecorded);
        Assert.assertEquals(emailDB1, actualFirstNameRecorded);
    }

    @Then("The  b_marital column should only contain the values Single, Married, or Divorced.")
    public void the_b_marital_column_should_only_contain_the_values_single_married_or_divorced() {

        emailDB1 = faker.internet().emailAddress();
        marytalStatusDB = "Married";
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        Employment_And_Income_Page_R employment_and_income_page_r = new Employment_And_Income_Page_R();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setPersonalLastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailDB(emailDB1);
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatusDBCLICK();
        SeleniumUtils.waitFor(2);
        personalI_page_factory_c.setPerMarytalStatusDB(marytalStatusDB);
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

    @Then("A table named tbl_mortagage should store the correct borrower, marytal status information")
    public void a_table_named_tbl_mortagage_should_store_the_correct_borrower_marytal_status_information() {
        List<List<Object>> listOfLists = DBUtils.getListOfLists("select b_marital from tbl_mortagage where b_marital='" + marytalStatusDB + "'");

        System.out.println("Expected Marytal status: " + marytalStatusDB);
        String actualFirstNameRecorded = (String) (listOfLists.get(0).get(0));
        System.out.println("Actual Marytal status Recorded in the DB: " + actualFirstNameRecorded);
        Assert.assertEquals(marytalStatusDB, actualFirstNameRecorded);
    }

    //read from data base
    @Then("A table named tbl_mortagage should store should match borrower's information")
    public void aTableNamedTbl_mortagageShouldStoreShouldMatchBorrowerSInformation() {
        final List<Map<String, Object>> listOfMaps = DBUtils.getListOfMaps("select * from tbl_mortagage where b_firstName='" + expectedfirstName + "'");

        //String actualFirstNameRecorded = (String) (listOfMaps.get(0).get(0));
        System.out.println("Actual First Name Recorded in the DB: " + listOfMaps);
        Assert.assertEquals(expectedfirstName, listOfMaps.get(0).get("b_firstName"));
        Assert.assertEquals(middleName, listOfMaps.get(0).get("b_middleName"));
        Assert.assertEquals(lastName, listOfMaps.get(0).get("b_lastName"));
    }

    @Then("A table named tbl_mortagage should store the correct borrower,new email adress information")
    public void aTableNamedTbl_mortagageShouldStoreTheCorrectBorrowerNewEmailAdressInformation() {
        List<List<Object>> listOfLists = DBUtils.getListOfLists("select b_email from tbl_mortagage where b_email='" + email12 + "'");

        System.out.println("Expected Email: " + email12);
        String actualNewEmailRecorded = (String) (listOfLists.get(0).get(0));
        System.out.println("Actual Email Recorded in the DB: " + actualNewEmailRecorded);
        Assert.assertEquals(email12, actualNewEmailRecorded);

    }

    //Mapping
    @When("the user enters the personal information page mapping")
    public void theUserEntersThePersonalInformationPageMapping(List<List<String>> dataTable) {

        expectedfirstName = dataTable.get(1).get(0);
        middleName = dataTable.get(1).get(1);
        lastName = dataTable.get(1).get(2);
        email12 = dataTable.get(1).get(3);
        dateOfBirth12 = dataTable.get(1).get(4);

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
    @Then("A table named tbl_mortagage should store the correcect mapping information")
    public void a_table_named_tbl_mortagage_should_store_the_correcect_mapping_information(List<List<String>> dataTable)  {

//        List<List<Object>> listOfLists = DBUtils.getListOfLists("select b_firstName from tbl_mortagage where b_firstName='" + expectedfirstName + "'");
//
//        System.out.println("Expected First Name: " + expectedfirstName);
//        String actualFirstNameRecorded = (String) (listOfLists.get(0).get(0));
//        System.out.println("Actual First Name Recorded in the DB: " + actualFirstNameRecorded);
//        Assert.assertEquals(expectedfirstName, actualFirstNameRecorded);


        expectedfirstName = dataTable.get(0).get(0);
        middleName = dataTable.get(1).get(1);
        lastName = dataTable.get(1).get(2);
        email12 = dataTable.get(1).get(3);
        dateOfBirth12 = dataTable.get(1).get(4);

        final List<List<Object>> actualy = DBUtils.getListOfLists("SELECT * from tbl_mortagage where b_firstName='" + expectedfirstName + "'");

        System.out.println("Expected First Name: " + expectedfirstName);
        System.out.println("Actual First Name Recorded in the DB: " + actualy);
        Assert.assertEquals(expectedfirstName,actualy.get(0).get(12));
        Assert.assertEquals(expectedfirstName,actualy.get(0).get(13));
        Assert.assertEquals(expectedfirstName,actualy.get(0).get(14));
        Assert.assertEquals(expectedfirstName,actualy.get(0).get(15));
        Assert.assertEquals(expectedfirstName,actualy.get(0).get(16));

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
