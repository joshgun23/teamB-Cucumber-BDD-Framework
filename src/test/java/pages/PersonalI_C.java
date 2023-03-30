package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class PersonalI_C {

    public PersonalI_C(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "email")
    private WebElement userName;

    public void userName1(){
        userName.click();
        userName.sendKeys("Coshgun.ismayilov@lenta.ru");
    }

    @FindBy(name = "password")
    private WebElement password;

    public void passWord(){
        password.sendKeys("198523");
    }

    @FindBy(name = "login")
    private WebElement login;

    public void loGin(){
        login.click();
    }

}
