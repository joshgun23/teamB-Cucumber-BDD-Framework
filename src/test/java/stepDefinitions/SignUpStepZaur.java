package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.Driver;

public class SignUpStepZaur {


    @When("I am on the Sign Up page")
    public void i_am_on_the_sign_up_page() {
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");


    }

    @When("I enter my First Name as {string}")
    public void i_enter_my_first_name_as(String string) {
        Driver.getDriver().findElement( By.xpath("//input[@type='first_name']")).sendKeys("Zaur");


    }

    @When("I enter my Last Name as {string}")
    public void i_enter_my_last_name_as(String string) {
        Driver.getDriver().findElement( By.xpath("//input[@type='last_name']")).sendKeys("Aghayev");

    }

    @When("I enter my Email Address as {string}")
    public void i_enter_my_email_address_as(String string) {
        Driver.getDriver().findElement( By.xpath("//input[@type='email']")).sendKeys("agayev.zaur@gmail.com");

    }

    @When("I enter my Password as {string}")
    public void i_enter_my_password_as(String string) {
        Driver.getDriver().findElement( By.xpath("//input[@type='password']")).sendKeys( "Abc12345" );

    }

    @When("I click on the Sign Up button")
    public void i_click_on_the_sign_up_button() {
        Driver.getDriver().findElement( By.xpath("//button[contains(text(),\"\" )]")).click();



    }

    @Then("I should be redirected to the Sign In page")
    public void i_should_be_redirected_to_the_sign_in_page() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Sign In";
        Assert.assertEquals(expectedTitle, actualTitle);
        WebDriver driver = Driver.getDriver();
        driver.quit();

    }

    @Given("an existing user with Email Address {string}")
    public void an_existing_user_with_email_address(String string) {
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
        HomePage homepg = new HomePage();
        homepg.clickOnSignUpLink();




    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Sign Up";
        Assert.assertEquals(expectedTitle, actualTitle);
        WebDriver driver = Driver.getDriver();
        driver.quit();






        }

    }


