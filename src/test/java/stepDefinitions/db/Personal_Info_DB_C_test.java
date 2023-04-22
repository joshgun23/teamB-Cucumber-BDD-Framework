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
import java.util.*;

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
        personalI_page_factory_c.commanMethod();

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
        personalI_page_factory_c.commanMethodCo();
        new PersonalI_Page_Factory_C().setCoLastNameDB(colastName);
        personalI_page_factory_c.commanMethodCo1();
        personalI_page_factory_c.secondEmployer2.sendKeys(employerName);
        personalI_page_factory_c.commanMethodCo2();

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
        personalI_page_factory_c.commanMethod();

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
        personalI_page_factory_c.commanMethod1();

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
    String expectedfirstNameMap;
    String middleNameMap;
    String lastNameMap;
    String email12Map;
    String dateOfBirth12Map;

    @When("the user enters the personal information page mapping")
    public void theUserEntersThePersonalInformationPageMapping(List<Map<String,String>> dataTable) {

        expectedfirstNameMap = dataTable.get(0).get("firstName");
        middleNameMap = dataTable.get(0).get("middleName");
        lastNameMap = dataTable.get(0).get("lastName");
        email12Map = dataTable.get(0).get("emailmaping");
        dateOfBirth12Map = dataTable.get(0).get("dob");

        // Fill out the personal information section
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        Employment_And_Income_Page_R employment_and_income_page_r = new Employment_And_Income_Page_R();
        personalI_page_factory_c.setPersonalDataTName(expectedfirstNameMap);
        personalI_page_factory_c.setPersonalDataTMiddleName(middleNameMap);
        personalI_page_factory_c.setPersonalDataTLastName(lastNameMap);
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setNewEmail(email12Map);
        personalI_page_factory_c.setPerdataDataTBirth(dateOfBirth12Map);
        personalI_page_factory_c.commanMethod();

    }
    @Then("A table named tbl_mortagage should store the correcect mapping information")
    public void a_table_named_tbl_mortagage_should_store_the_correcect_mapping_information(List<Map<String,String>>  dataTable) throws SQLException {

        String expectedfirstNameMap = null;


        expectedfirstNameMap = dataTable.get(0).get("firstName");
        String expMiddle = dataTable.get(0).get("middleName");
        String expLast = dataTable.get(0).get("lastName");
        String expEmail = dataTable.get(0).get("emailmaping");
        String expDob = dataTable.get(0).get("dob");

        List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * from tbl_mortagage where b_firstName='" + expectedfirstNameMap + "'");

        String actFirstName = (String)(actual.get(0).get("b_firstName"));
        String actMiddleName = (String) (actual.get(0).get("b_middleName"));
        String actLast = (String)(actual.get(0).get("b_lastName"));
        String actEmail = (String)(actual.get(0).get("b_email"));
        String actDob = (String)(actual.get(0).get("b_dob"));

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actFirstName).isEqualTo(expectedfirstNameMap);
        softAssertions.assertThat(actMiddleName).isEqualTo(expMiddle);
        softAssertions.assertThat(actLast).isEqualTo(expLast);
        softAssertions.assertThat(actEmail).isEqualTo(expEmail);
        softAssertions.assertThat(actDob).isEqualTo(expDob);

        softAssertions.assertAll();

    }

    //Database cheking only
    List<String> actual;
    @When("I send request to retrive email from user table")
    public void i_send_request_to_retrive_email_from_user_table() {
        //List<List<Object>> listOfLists = DBUtils.getListOfLists("select email from tbl_user limit 5");
        actual = DBUtils.getSingleColumnValues("email", "tbl_user limit 5");
        System.out.println("actual" + actual);
    }
    @Then("It shoul be folowing exepted email")
    public void it_shoul_be_folowing_exepted_email(List<String> expected) {
        Collections.sort(actual);
        expected = new ArrayList<>(expected);
        Collections.sort(expected);

        Assert.assertEquals(expected, actual);
    }

    List<String> list;
    @When("I send request to retrive email")
    public void i_send_request_to_retrive_email() {

        list = DBUtils.getSingleColumnValues("email", "tbl_user limit 10");

        System.out.println(list);

    }
    @Then("It result should contain dublicate email")
    public void it_result_should_contain_dublicate_email() {

        ArrayList<String> actual = new ArrayList<>(new LinkedHashSet<>(list));

        System.out.println(actual);
        System.out.println(list);

        Assert.assertEquals(list, actual);

    }

    List<Map<String, Object>> expectedList;
    @When("I send a request to retrieve duplicate usernames")
    public void i_send_a_request_to_retrieve_duplicate_usernames() {

        expectedList = DBUtils.getListOfMaps("SELECT  email,count(*) from tbl_user GROUP BY email having count(*) > 1");

    }
    @Then("The result should be empty")
    public void the_result_should_be_empty() {

        Assert.assertEquals(0, expectedList.size());

    }

    List<List<Object>> joinExcepted;
    @When("I send a request to join tbl mortgace to tbl user")
    public void i_send_a_request_to_join_tbl_mortgace_to_tbl_user() {

        joinExcepted = DBUtils.getListOfLists("select * from tbl_mortagage as m join tbl_user as u on m.id=u.id");
        System.out.println(joinExcepted);
    }
    @Then("The result should be joined")
    public void the_result_should_be_joined() {

        List<List<Object>> expected = DBUtils.getListOfLists("SELECT * FROM tbl_mortagage AS m JOIN tbl_user AS u ON m.id=u.id");

        List<List<Object>> actual = joinExcepted;

        Assert.assertEquals(expected, actual);

    }

    List<List<Object>> exceptedEmail;
    String emailExclude = "patricia.koss@yahoo.com";
    @When("I send a request to the exclude special email {string} tbl mortgace")
    public void i_send_a_request_to_the_exclude_special_email_tbl_mortgace(String emailExclude) {


        exceptedEmail = DBUtils.getListOfLists("SELECT b_email FROM tbl_mortagage WHERE b_email <> '" + emailExclude + "'");
        System.out.println(exceptedEmail);


    }
    @Then("The result should be veryfy exclude")
    public void the_result_should_be_veryfy_exclude() {

        List<List<Object>> actuly = DBUtils.getListOfLists("SELECT b_email FROM tbl_mortagage");

        Assert.assertEquals(exceptedEmail,actuly);


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