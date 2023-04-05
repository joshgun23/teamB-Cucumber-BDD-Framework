package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Sign_in_factory_E {

    public void Sign_in_factory_E() {
        PageFactory.initElements( Driver.getDriver(), this );
    }


    @FindBy(name = "email")
    private WebElement userName;

    public void userName() {
        userName.click();
        userName.sendKeys( "e.bayarsaikhan@outlook.com" );
    }

    @FindBy(name = "Password")
    private WebElement password;

    public void passWord() {
        password.sendKeys( "Password" );
    }

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement login;

    public void loGin() {
        login.click();

    }

    @FindBy(xpath = "//a[@class='menu-title']")
    private WebElement dashboard1;

    public void dashboard1() {
        Assert.assertTrue( dashboard1.isDisplayed() );
    }
}