package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class Sign_in_factory_E {


    public Sign_in_factory_E() {
        PageFactory.initElements( Driver.getDriver(), this );
    }


    @FindBy(id= "email")
    private WebElement userName;

    public void userName() {

        userName.sendKeys( "e.bayarsaikhan@outlook.com" );
    }

    @FindBy(id = "password")
    public WebElement setPassword;

    public void setPassword() {

         setPassword.sendKeys( "Password" );

    }

    @FindBy(xpath = " //a[@href='#next'] ")
    public WebElement loginButtonNext;
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement login;

    @FindBy(id = "signin")
    public WebElement loginButton;

    public void loGin() {
        login.click();

    }

    @FindBy(xpath = "//a[@class='menu-title']")
    private WebElement dashboard1;

    public void dashboard1() {
        Assert.assertTrue( dashboard1.isDisplayed() );
    }



    public void sendKeysToUserName(String keys) {
        userName.sendKeys( keys );
    }

    public void sendKeysToSetPassword(String keys) {
        setPassword.sendKeys( keys );
    }

    public void SummaryLogInMethod() {
        sendKeysToUserName( ConfigReader.getProperty( "username" ) );
        sendKeysToSetPassword( ConfigReader.getProperty( "password" ) );
        loginButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );

    }
    public void SignIn() {
        userName.sendKeys( ConfigReader.getProperty( "username" ) );
        setPassword.sendKeys( ConfigReader.getProperty( "Password" ) );
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait( Duration.ofSeconds( 3 ) );
    }
}