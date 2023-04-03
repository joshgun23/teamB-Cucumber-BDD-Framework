package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class ExpensesPage_M {

    public ExpensesPage_M() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "Rent")
    private WebElement rent;

    public void rent() {
        rent.click();

    }

    @FindBy(xpath = "//a[@class='form-control']")
    private WebElement payment;
    public void payment() {
       payment.sendKeys("1000");
    }

    @FindBy(name = "Save")
    private WebElement save;

    public void Save() {
        save.click();
    }


}
