package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import utils.Driver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashboardSectionDefs_E extends HomePage {

    public class DashboardSteps {
        @Given("^User on the dashboard page$")
        public void navigateToDashboardPage() {
            Driver.getDriver().get( "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php" );
        }

        @Then("^Bank logo should be displayed in the top left corner of the page$")
        public void verifyBankLogoDisplayed() {
            WebElement brandLogo = Driver.getDriver().findElement( By.xpath( "//div[@class='brand-logo']//span" ) );
            assertTrue( ((WebElement) brandLogo).isDisplayed() );
        }

        @And("^User should see the \"([^\"]*)\" and \"([^\"]*)\" links$")  //matches any string of characters between two double quotes
        public void verifyLinksDisplayed(String link1, String link2) {
            List<WebElement> links = Driver.getDriver().findElements( By.xpath( "//div[@class='menu-title']//span" ) );
            List<String> expectedLinks = Arrays.asList( link1, link2 );
            List<String> actualLinks = links.stream().map( WebElement::getText ).collect( Collectors.toList() );
            assertEquals( expectedLinks, actualLinks );
        }

        @When("^User click on the \"([^\"]*)\" link$")  //matches any string of characters between two double quotes
        public void clickOnLink(String link) {
            WebElement element = Driver.getDriver().findElement( By.xpath( "//div[@class='menu-title']//span[contains(text(),'" + link + "')]" ) );
            element.click();
        }

        @Then("^User should be taken to a new page where user can apply for a new mortgage$")
        public void verifyMortgageApplicationPage() {
            assertTrue( Driver.getDriver().getCurrentUrl().contains( "mortgage_application.php" ) );
        }

        @Then("^User should be taken to a page where user can view my previous mortgage applications$")
        public void verifyApplicationListPage() {
            assertTrue( Driver.getDriver().getCurrentUrl().contains( "application_list.php" ) );
        }

        @And("^User should see my account information in the top right corner$")
        public void verifyAccountInfoDisplayed() {
            WebElement userName = Driver.getDriver().findElement( By.xpath( "//span[@class='user-name']//span" ) );
            assertTrue( userName.isDisplayed() );
        }

        @When("^User click on my name or profile picture$")
        public void clickOnAccountInfo() {
            WebElement accountInfo = Driver.getDriver().findElement( By.xpath( "//span[@class='user-name']//span" ) );
            accountInfo.click();
        }

        @Then("^User should see a dropdown menu with a \"Logout\" link$")
        public void verifyLogoutLinkDisplayed() {
            WebElement logOutLink = Driver.getDriver().findElement( By.xpath( "//div[@class='dropdown-item']//span[contains(text(),'Logout')]" ) );
            assertTrue( logOutLink.isDisplayed() );
        }

        @And("^User should be able to click on the "Logout" link to log out of the system$")
        public void clickOnLogoutLink() {
            WebElement logOutLink = Driver.getDriver().findElement( By.xpath( "//div[@class='dropdown-item']//span[contains(text(),'Logout')]" ) );
            logOutLink.click();
        }
    }
}
