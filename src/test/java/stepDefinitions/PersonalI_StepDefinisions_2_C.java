package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.PersonalI_Page_Factory_C;
import utils.Driver;
import utils.SeleniumUtils;

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
        new PersonalI_Page_Factory_C().setCoMarytalStatus();
        SeleniumUtils.waitFor(2);
        new PersonalI_Page_Factory_C().setCophoneNumber();
        new PersonalI_Page_Factory_C().setCoHomephoneNumber();
        personalI_page_factory_c.setPerCoNextButton();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Current Monthly Housing Expenses"));

    }




    ////input[starts-with(@name, 'name')]
//    @Then("all required fields are filled out")
//    public void allRequiredFieldsAreFilledOut() {
//    }
}

