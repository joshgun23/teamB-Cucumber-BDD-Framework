package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import pages.DashboardSection_E;
import pages.Sign_in_factory_E;
import pages.Sign_in_factory_Z;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashboardSectionDefs_E  {

    public class DashboardSteps {

        @Given("the user is on the sign in page")
        public void givenTheUserIsOnTheHomePage() {
            System.out.println("The user is on the sign in page");
            SeleniumUtils.waitFor(2);
            Sign_in_factory_E factory_e = new Sign_in_factory_E();

        }

        @When("the user enters a valid email address and password")
        public void whenTheUserEntersAValidEmailAddressAndPassword() {
            System.out.println("The user enters a valid email address and password");
            Sign_in_factory_E factory_e = new Sign_in_factory_E();
            factory_e.userName();
            factory_e.passWord();

        }

        @And("clicks on the sign in button")
        public void clicksOnTheSignInButton() {
            System.out.println("The user should be able to sign in");
            Sign_in_factory_E factory_e = new Sign_in_factory_E();
            factory_e.loGin();

        }

        @Then("the user should be redirected to the mortgage account dashboard")
        public void thenTheUserShouldBeRedirectedToTheMortgageAccountDashboard() {
            System.out.println("The user should be redirected to the mortgage account dashboard");
            Sign_in_factory_E factory_e = new Sign_in_factory_E();
            factory_e.dashboard();
            SeleniumUtils.waitFor(2);

        }
//
//        @Given("User is on the dashboard page")
//        public void user_on_the_dashboard_page() {
//            System.out.println( "User on the dashboard page" );
//            SeleniumUtils.waitFor( 2 );
//            Sign_in_factory_Z factory_z = new Sign_in_factory_Z(); //using_Z ???
//
//        }

        @Then("Bank logo should be displayed in the top left corner of the page")
        public void bank_logo_should_be_displayed_in_the_top_left_corner_of_the_page() {
            System.out.println("User should see the bank's logo in the top left corner");
            WebElement brandLogo = Driver.getDriver().findElement( By.xpath( "//div[@class='brand-logo']//span" ) );
            assertTrue( ((WebElement) brandLogo).isDisplayed() );
            DashboardSection_E dashboardPage = new DashboardSection_E();
            assertTrue("Bank logo is not displayed!", dashboardPage.brandLogo.isEmpty());
        }

        @And("User should see the \"Mortgage Application\" and \"Application List\" links")  //matches any string of characters between two double quotes
        public void user_should_see_the_and_links(String link1, String link2) {
            System.out.println("User should see the Mortgage Application and Application List links");
            List<WebElement> links = Driver.getDriver().findElements( By.xpath( "//div[@class='menu-title']//span" ) );
            List<String> expectedLinks = Arrays.asList( link1, link2 );
            List<String> actualLinks = links.stream().map( WebElement::getText ).collect( Collectors.toList() );
            assertEquals( expectedLinks, actualLinks );
        }

        @When("User click on the \"Mortgage Application\" link")  //matches any string of characters between two double quotes
        public void user_click_on_the_link(String link) {
            System.out.println("User click on the \"([^\"]*)\" link$");
            WebElement element = Driver.getDriver().findElement( By.xpath( "//div[@class='menu-title']//span[contains(text(),'" + link + "')]" ) );
            element.click();
        }

        @Then("User should be taken to a new page where user can apply for a new mortgage")
        public void user_should_be_taken_to_a_new_page_where_user_can_apply_for_a_new_mortgage() {
            System.out.println("User should be taken to a new page where I can apply for a new mortgage$");
            assertTrue( Driver.getDriver().getCurrentUrl().contains( "mortgage_application.php" ) );
        }

        @Then("User click on the \"Application List\" link")
        public void user_click_on_the_link() {
            System.out.println("^User should be taken to a page where I can view my previous mortgage applications$");
            assertTrue( Driver.getDriver().getCurrentUrl().contains( "application_list.php" ) );
        }

        @And("User should see my account information in the top right corner")
        public void user_should_see_my_account_information_in_the_top_right_corner() {
            System.out.println("^User should see my account information in the top right corner$");
            WebElement userName = Driver.getDriver().findElement( By.xpath( "//span[@class='user-name']//span" ) );
            assertTrue( userName.isDisplayed() );
        }

        @When("User click on my name or profile picture")
        public void user_click_on_my_name_or_profile_picture() {
            System.out.println("^User click on my name or profile picture$");
            WebElement accountInfo = Driver.getDriver().findElement( By.xpath( "//span[@class='user-name']//span" ) );
            accountInfo.click();
        }

        @Then("User should see a dropdown menu with a \"Logout\" link")
        public void user_should_see_a_dropdown_menu_with_a_link() {
            System.out.println("^User should see a dropdown menu with a \"Logout\" link$");
            WebElement logOutLink = Driver.getDriver().findElement( By.xpath( "//div[@class='dropdown-item']//span[contains(text(),'Logout')]" ) );
            assertTrue( logOutLink.isDisplayed() );
        }

        @And("User should be able to click on the \"Logout\" link to log out of the system")
        public void user_should_be_able_to_click_on_the_link_to_log_out_of_the_system() {
            System.out.println("^User should be able to click on the \"Logout\" link to log out of the system$");
            WebElement logOutLink = Driver.getDriver().findElement( By.xpath( "//div[@class='dropdown-item']//span[contains(text(),'Logout')]" ) );
            logOutLink.click();
        }
    }
}
