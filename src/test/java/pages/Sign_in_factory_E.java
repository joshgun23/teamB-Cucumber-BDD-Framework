package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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


    @FindBy(id = "email")
    private WebElement userName;

    public void userName() {

        userName.sendKeys( "e.bayarsaikhan@outlook.com" );
    }

    @FindBy(id = "password")
    public WebElement setPassword;

    public void setPassword() {

        setPassword.sendKeys( "Password" );

    }

    @FindBy(xpath = "//label[@for='realtor2']")
    public WebElement realtorNo;
    @FindBy(id = "estimatedprice")
    public WebElement estimatedPrice;

    @FindBy(id = "downpayment")
    public WebElement downPaymentAmount;

    @FindBy(id = "downpaymentpercentage")
    public WebElement downPaymentPercentage;
    @FindBy(xpath = "//span[@class='Summary']//span")
    public WebElement summaryLink;
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
        sendKeysToSetPassword( ConfigReader.getProperty( "Password" ) );
        loginButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );

    }

    public void SignIn() {
        userName.sendKeys( ConfigReader.getProperty( "username" ) );
        setPassword.sendKeys( ConfigReader.getProperty( "Password" ) );
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait( Duration.ofSeconds( 3 ) );
    }

    @FindBy(xpath = "//span[@data-i18n='eCommerce']")
    public WebElement mortgageSummary;

    public void clickMortgageSummary() {
        mortgageSummary.click();
    }

    public void realtorCheckBox() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript( "arguments[0].click()", realtorNo );
    }
    public void realtorInformationField(String realtor){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",realtorNo);
        realtorNo.sendKeys(realtor);
    }

    public void setPreapproval_method(String realtor, int num, int downPay) {
        new Sign_in_factory_E().realtorNo.isSelected();
        realtorNo.sendKeys( realtor );
        estimatedPrice.sendKeys( Integer.toString( num ) );
        downPaymentAmount.sendKeys( Integer.toString( downPay ) );
        summaryLink.click(); //summary
    }
}