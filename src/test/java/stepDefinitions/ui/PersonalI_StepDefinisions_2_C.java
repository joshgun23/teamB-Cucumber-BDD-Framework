package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.PersonalI_Page_Factory_C;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class PersonalI_StepDefinisions_2_C  {


//    @Given("the user is on the Personal Information page")
//    public void theUserIsOnThePersonalInformationPage()  {
////        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
////        personalI_page_factory_c.userName1();
////        personalI_page_factory_c.passWord();
////        personalI_page_factory_c.loGin();
////        personalI_page_factory_c.mortageClick();
////        personalI_page_factory_c.preapruNo();
////        personalI_page_factory_c.estimatePri();
////        personalI_page_factory_c.setEstimateDownP();
////        personalI_page_factory_c.setPreaprovalNext();
//        Assert.assertTrue("personal information",Driver.getDriver().getPageSource().contains("Personal Information"));
//    }

    @Then("an additional section for personal information  information is displayed")
    public void anAdditionalSectionForPersonalInformationInformationIsDisplayed() {
        Assert.assertTrue("Personal Information", Driver.getDriver().getPageSource().contains("Personal Information"));

    }
    @Then("the user enters the personal information first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
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
    }

    @Then("all required fields are filled out")
    public void allRequiredFieldsAreFilledOut() {
        //String excepted = "Current Monthly Housing Expenses";
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Current Monthly Housing Expenses"));
    }

    @When("the user selects for the co-borrower question")
    public void theUserSelectsForTheCoBorrowerQuestion() throws InterruptedException {
        SeleniumUtils.waitFor(2);
        PersonalI_Page_Factory_C personalI_page_factory_c1 = new PersonalI_Page_Factory_C();
        personalI_page_factory_c1.setCoBorrower();
    }

    @Then("an additional section for co-borrower's information is displayed")
    public void anAdditionalSectionForCoBorrowerSInformationIsDisplayed() {
        Assert.assertTrue("Co-Borrower's Information",Driver.getDriver().getPageSource().contains("Co-Borrower's Information"));
    }
    @When("the user reads the Privacy Policy and clicks the checkbox to accept the terms")
    public void theUserReadsThePrivacyPolicyAndClicksTheCheckboxToAcceptTheTerms() {
        new PersonalI_Page_Factory_C().setPerPtivacyCheckBoxButton();
        new PersonalI_Page_Factory_C().setPerPtivacyCheckBoxButton();
    }
    @Then("the checkbox is checked and the user can move forward to the next page of the application")
    public void theCheckboxIsCheckedAndTheUserCanMoveForwardToTheNextPageOfTheApplication() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//label[@for='privacypolicy']")).isEnabled());
    }
    @Then("the user enters the co-borrower's first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersTheCoBorrowerSFirstNameLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
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
        new PersonalI_Page_Factory_C().setCoFirstName();
        new PersonalI_Page_Factory_C().setCoMiddleName();
        new PersonalI_Page_Factory_C().setCoLastName();
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

    }

    @Then("the user enters the personal information first name incoreccet only number, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameIncoreccetLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setNegativpersonalName();
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
    }

    @Then("the user enters the personal information first name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameIncoreccetNumberAndLettersLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setNegativ_2_personalName();
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
    }


    @Then("the user enters the personal information first name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameIncoreccetLettersWithSpaceLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setNegativ_3_personalName();
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
    }

    @Then("the user enters the personal information first name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameLettersWithCharctersMoreLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setNegativ_4_personalName();
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
    }

    @Then("the user enters the personal information Middle name incoreccet only number, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameIncoreccetOnlyNumberLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonal_1_MiddleName();
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
    }

    @Then("the user enters the personal information Middle name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameIncoreccetNumberAndLettersLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonal_2_MiddleName();
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
    }

    @Then("the user enters the personal information Middle name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameIncoreccetLettersWithSpaceLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonal_3_MiddleName();
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
    }

    @Then("the user enters the personal information Middle name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameLettersWithCharctersMoreLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonal_4_MiddleName();
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
    }

    @Then("the user enters the personal information Last name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationLastNameIncoreccetNumberAndLettersLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setPersonal_1_LastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailAd();
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();
    }

    @Then("the user enters the personal information Last name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationLastNameIncoreccetLettersWithSpaceLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setpersonal_2_LastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailAd();
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();
    }

    @Then("the user enters the personal information Last name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationLastNameLettersWithCharctersMoreLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setpersonal_3_LastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailAd();
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();
    }

    //Parametr
    @Then("the user enters the personal information neqativ first name {string}")
    public void theUserEntersThePersonalInformationFirstName(String name) {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalparametrName(name);
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

    }


    @Then("the user enters the personal information neqativ Middle name {string}")
    public void theUserEntersThePersonalInformationNeqativMiddleName(String nameMiddle) {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalParametrMiddleName(nameMiddle);
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
    }

    @Then("the user enters the personal information neqativ Last name {string}")
    public void theUserEntersThePersonalInformationNeqativLastName(String nameLast) {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setPersonalParametrLastName(nameLast);
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailAd();
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();
    }

    @Then("all required fields negativ are filled out")
    public void allRequiredFieldsNegativAreFilledOut() {
        Assert.assertTrue("ARE YOU APPLYING WITH A CO-BORROWER?",Driver.getDriver().getPageSource().contains("ARE YOU APPLYING WITH A CO-BORROWER?"));
    }

    //link text xpath
    @Then("sulfix {string}")
    public void sulfix(String linkName) {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setPersonalLastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixlinkxpath(linkName);
        personalI_page_factory_c.setPerEmailAd();
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();
    }

    @Then("all required xpath {string} are filled out")
    public void allRequiredXpathAreFilledOut(String linkName) {
        Assert.assertEquals(linkName,new PersonalI_Page_Factory_C().getCurrent());
    }

    //Data Table
    @Then("Click in sulfix place")
    public void clickInSulfixPlace() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPerSulfixPlace();
    }

    @Then("i should see following options")
    public void i_should_see_following_options(List<String> dataTable) {

        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        List<String> actualy = personalI_page_factory_c.getsulfixDataT();

        Assert.assertEquals(dataTable, actualy);
        System.out.println(dataTable);
    }
    @Then("Click in marytal status place")
    public void click_in_marytal_status_place() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.getPerMarytalStatus();
    }
    @Then("i should see marytal status following options")
    public void i_should_see_marytal_status_following_options(List<String> dataTable) {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        List<String> actualy = personalI_page_factory_c.marytalDataT();

        Assert.assertEquals(dataTable, actualy);
        System.out.println(dataTable);
    }


    //Scenario1 Outline
    @When("the user enters the personal information {string},{string},{string},{string},{string}")
    public void theUserEntersThePersonalInformation(String name, String middleName, String lastName, String email, String dateOfbirth) {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalOutlineName(name);
        personalI_page_factory_c.setPersonalOutlineMiddleName(middleName);
        personalI_page_factory_c.setPersonalOutlineLastName(lastName);
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailOutlineAd(email);
        personalI_page_factory_c.setPerDateOutlineBirth(dateOfbirth);
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();

    }


    @Then("all required fields positiv are filled out")
    public void allRequiredFieldsPositivAreFilledOut() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Current Monthly Housing Expenses"));

    }

    //Data table all in
    @When("the user enters the personal information")
    public void the_user_enters_the_personal_information( List<List<String>> dataTable) {

        String firstName = dataTable.get(0).get(0);
        String middleName = dataTable.get(0).get(1);
        String lastName = dataTable.get(0).get(2);
        String email12 = dataTable.get(0).get(3);
        String dateOfBirth12 = dataTable.get(0).get(4);

        // Fill out the personal information section
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalDataTName(firstName);
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
    }
}