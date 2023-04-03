package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.PersonalI_Page_Factory_C;
import utils.Driver;
import utils.SeleniumUtils;

public class PersonalI_StepDefinisions_C {
    @Given("userName1")
    public void perusername() {

        SeleniumUtils.waitFor(2);
        PersonalI_Page_Factory_C personalI_c = new PersonalI_Page_Factory_C();
        personalI_c.userName1();
        personalI_c.passWord();
        personalI_c.loGin();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Duobank Mortgage Application");
        new PersonalI_Page_Factory_C().mortageClick();
        new PersonalI_Page_Factory_C().preapruNo();
        new PersonalI_Page_Factory_C().estimatePri();
        new PersonalI_Page_Factory_C().setEstimateDownP();
        new PersonalI_Page_Factory_C().setPreaprovalNext();
        Assert.assertTrue("personal information",Driver.getDriver().getPageSource().contains("Personal Information"));

    }

//    @When("password1")
//    public void password() {
//        new PersonalI_Page_Factory_C().passWord();
//    }
//
//
//    @Then("login1")
//    public void signUp() {
//        new PersonalI_Page_Factory_C().loGin();
//        Assert.assertEquals(Driver.getDriver().getTitle(),"Duobank Mortgage Application");
//    }
//
//    @Then("check to personal infomation place")
//    public void checkToPersonalInfomationPlace() {
//        new PersonalI_Page_Factory_C().mortageClick();
//      new PersonalI_Page_Factory_C().preapruNo();
//      new PersonalI_Page_Factory_C().estimatePri();
//      new PersonalI_Page_Factory_C().setEstimateDownP();
//      new PersonalI_Page_Factory_C().setPreaprovalNext();
//     Assert.assertTrue("personal information",Driver.getDriver().getPageSource().contains("Personal Information"));
//    }
}

