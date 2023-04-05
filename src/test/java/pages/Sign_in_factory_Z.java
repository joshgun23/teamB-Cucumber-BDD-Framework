package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class Sign_in_factory_Z {
    public Sign_in_factory_Z() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    private WebElement eMail;

    public void userName() {
        eMail.click();
        eMail.sendKeys(ConfigReader.getProperty("username"));
    }

    @FindBy(name = "password")
    private WebElement password;

    public void passWord() {
        password.sendKeys(ConfigReader.getProperty("Password"));
    }

    @FindBy(name = "login")
    private WebElement login;

    public void loGin() {
        login.click();
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement dashboard;

    public void dashboard() {
        Assert.assertTrue(dashboard.isDisplayed());


    }

    @FindBy(name = "email")
    private WebElement invalidEmail;

    public void invaliUserName() {
        Faker faker = new Faker();
        String email = faker.name().username() + "@gmail.com";
        invalidEmail.sendKeys(email);


    }

    @FindBy(name = "password")
    private WebElement invalidPassword;

    public void invalidPassword() {
        Faker faker = new Faker();
        String password = faker.name().username();
        invalidPassword.sendKeys(password);
    }

    @FindBy(xpath = "//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]/text()")
    private WebElement errorMessage;

    public void errorMessage() {
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @FindBy(name = "email")
    private WebElement noUserName;

    public void noUserName() {
        noUserName.sendKeys("");

    }
    @FindBy(name = "password")
    private WebElement noPassword;

    public void noPassword(){
        noPassword.sendKeys("");
    }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-lg loginbtn']")
    private WebElement login2;
    public void disabledButton() {
        Assert.assertTrue(login.isEnabled());

    }
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-lg loginbtn']")
    private WebElement login3;
    public void missingField() {
        Assert.assertTrue(login.isEnabled());
    }

    @FindBy (id = "hideLogin")
    private WebElement signUpLink;

    public void signUpLink() {
        signUpLink.click();

    }

    public void signUpPage() {
        Assert.assertTrue(signUpLink.isDisplayed());
    }


    public void forgotPasswordLink() {
    }
}
