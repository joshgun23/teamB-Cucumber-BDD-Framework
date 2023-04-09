package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
@Data
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

    @FindBy(id = "email")
    private WebElement invalidEmail;

    @FindBy(id = "password")
    private WebElement invalidPassword;

    @FindBy(xpath = "//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]/text()")
    public WebElement errorMessage;

    @FindBy(id = "email")
    private WebElement noUserName;

    @FindBy(id = "password")
    private WebElement noPassword;


    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-lg loginbtn']")
    private WebElement login2;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-lg loginbtn']")
    private WebElement login3;

    @FindBy(xpath = "//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[2]/div/div[3]/a")
    public WebElement signUpLink;


    public void username(String email) {
        eMail.sendKeys(email);


    }



    public void SignIn() {
        eMail.sendKeys(ConfigReader.getProperty("username"));
        password.sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        login.click();

        Assert.assertEquals("Dashboard", dashboard.getText());
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
        eMail.sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        login.click();

    }

    public void noUserName() {
        noUserName.sendKeys("");
        password.sendKeys(ConfigReader.getProperty("password"));
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void noPassword() {
        eMail.sendKeys(ConfigReader.getProperty("username"));
        noPassword.sendKeys("");
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void errorMessage() {
        Assert.assertEquals("Invalid email or password", errorMessage.getText());
    }


    public void welcomeMessage() {
        Assert.assertEquals("Welcome to Duobank", errorMessage.getText());
    }

    public void blankCredentials() {
        noUserName.sendKeys("");
        noPassword.sendKeys("");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        login.click();

    }


    public void invalidUsernamePassword() {
        invalidEmail.sendKeys("Coshgun.Ismailov@gmail.com");
        invalidPassword.sendKeys("123456");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        login.click();
    }

    public void signUpLink() {
        signUpLink.click();
        Assert.assertEquals("https://duobank-dev.herokuapp.com/signup", Driver.getDriver().getCurrentUrl());
    }

    public void forgotPasswordLink() {
        //forgotPasswordLink.click();
        //Assert.assertEquals("https://duobank-dev.herokuapp.com/forgot-password", Driver.getDriver().getCurrentUrl());
        //there is no forgot password link on the web app
        //user should be able to reset password by clicking on the forgot password link
        //make sure to add it
    }
}

