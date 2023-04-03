package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class Sign_in_factory_Z {
    public Sign_in_factory_Z() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement eMail;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "signin")
    public WebElement login;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement dashboard;

    @FindBy(name = "email")
    private WebElement invalidEmail;

    @FindBy(name = "password")
    private WebElement invalidPassword;

    @FindBy(xpath = "//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]/text()")
    private WebElement errorMessage;

    @FindBy(name = "email")
    private WebElement noUserName;

    @FindBy(name = "password")
    private WebElement noPassword;


    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-lg loginbtn']")
    private WebElement login2;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-lg loginbtn']")
    private WebElement login3;

    @FindBy(id = "hideLogin")
    public WebElement signUpLink;

    public void username(String email) {
        eMail.sendKeys(email);


    }

    public void password(String pass) {
        password.sendKeys(pass);
    }

    public WebElement geteMail() {
        return eMail;
    }

    public WebElement getPassword() {
        return password;
    }

    public void SignIn() {
        eMail.sendKeys(ConfigReader.getProperty("homepage"));
        password.sendKeys(ConfigReader.getProperty("password"));
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void invalidEmail() {
        Faker faker = new Faker();
        invalidEmail.sendKeys(faker.internet().emailAddress());
        password.sendKeys(ConfigReader.getProperty("password"));
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    public void invalidPassword() {
        Faker faker = new Faker();
        invalidPassword.sendKeys(faker.internet().password());
        eMail.sendKeys(ConfigReader.getProperty("homepage"));
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void noUserName() {
        noUserName.sendKeys("");
        password.sendKeys(ConfigReader.getProperty("password"));
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void noPassword() {
        eMail.sendKeys(ConfigReader.getProperty("homepage"));
        noPassword.sendKeys("");
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void errorMessage() {
        Assert.assertEquals("Invalid email or password", errorMessage.getText());
    }


   public void SighnUpLink() {
        signUpLink.click();
    }}
