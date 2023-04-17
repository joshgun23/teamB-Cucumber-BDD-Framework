package stepDefinitions.db;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DB_Z_page;
import pages.Sign_in_factory_Z;
import utils.DBUtils;
import utils.Driver;

import static pages.Sign_in_factory_Z.email;


public class SignInDB_Z {


    @Given("the user is on the signup page")
    public void theUserIsOnTheSignupPage() {
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
    }

    @When("the user submits multiple signups concurrently")
    public void the_user_submits_multiple_signups_concurrently() {
        DB_Z_page.the_user_submits_multiple_signups_concurrently();

    }


    @Then("the signups should complete within a reasonable time frame")
    public void the_signups_should_complete_within_a_reasonable_time_frame() {
        DB_Z_page.the_signups_should_complete_within_a_reasonable_time_frame();

    }

    @Then("the system should not slow down or crash")
    public void the_system_should_not_slow_down_or_crash() {
        DB_Z_page.the_system_should_not_slow_down_or_crash();

    }


    @Given("a user with username {string} already exists")
    public void aUserWithUsernameAndEmailAlreadyExists(String email) {
        DBUtils.createConnection();
        DBUtils.executeQuery("select * from users where email = '" + email + "'");
        DBUtils.getSingleColumnValues("email", " tbl_user");
        Assert.assertTrue(DBUtils.getSingleColumnValues("email", " tbl_user").contains(email));


    }


    @When("the user attempts to sign up with the same username and email")
    public void theUserAttemptsToSignUpWithTheSameUsernameAndEmail() throws InterruptedException {
        Sign_in_factory_Z existingEmail = new Sign_in_factory_Z();
        existingEmail.sameUsername();


    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String errorMessage) {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(errorMessage));


    }

    @And("the new user account should not be created")
    public void theNewUserAccountShouldNotBeCreated() {
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Welcome to DuoBank!"));


    }

    @Given("a user with email {string} which does not exist")
    public void aUserWithEmailDoesNotExist(String mail) throws InterruptedException {
        Sign_in_factory_Z michael = new Sign_in_factory_Z();
        michael.signUpMichael(mail);
        // rest of the code
    }






    @Then("the user account should be created in the database")
    public void theUserAccountShouldBeCreatedInTheDatabase() {

        DBUtils.createConnection();
        DBUtils.executeQuery("select * from users where email = '" + email + "'");
        DBUtils.getSingleColumnValues("email", " tbl_user");
        Assert.assertTrue(DBUtils.getSingleColumnValues("email", " tbl_user").contains(email));
    }

    @And("the {string} table should contain the correct information")
    public void theTableShouldContainTheCorrectInformation(String tableName) {
        DBUtils.createConnection();
        DBUtils.executeQuery("select * from " + tableName + " where email = '" + email + "'");
        DBUtils.getSingleColumnValues("email", " tbl_user");
        Assert.assertTrue(DBUtils.getSingleColumnValues("email", " tbl_user").contains(email));
    }

    @And("the {string} table should have a unique constraint on the email column")
    public void theTableShouldHaveAUniqueConstraintOnTheEmailColumn(String tableName) {
        DBUtils.createConnection();
        DBUtils.executeQuery("select * from " + tableName + " where email = '" + email + "'");
        DBUtils.getSingleColumnValues("email", " tbl_user");
        Assert.assertTrue(DBUtils.getSingleColumnValues("email", " tbl_user").contains(email));
    }




}

//    }
//
//    @Given("a user with email {string} exists")
//    public void aUserWithEmailExists(String email) {
//
//    }
//
//
//
//    @When("the user logs in with the correct password")
//    public void theUserLogsInWithTheCorrectPassword() {
//
//    }
//
//    @Then("the user should be authenticated successfully")
//    public void theUserShouldBeAuthenticatedSuccessfully() {
//
//    }
//
//    @And("the password in the database should be encrypted with MD{int} hash")
//    public void thePasswordInTheDatabaseShouldBeEncryptedWithMDHash(int password) {
//
//    }
//
//
//
//    @And("the system should display a message {string}")
//    public void theSystemShouldDisplayAMessage(String successMessage) {
//
//    }
//
//
//
//    @And("the user should be redirected to the login page")
//    public void theUserShouldBeRedirectedToTheLoginPage() {
//    }
//}
//
//
