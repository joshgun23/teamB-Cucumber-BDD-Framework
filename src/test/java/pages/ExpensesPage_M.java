package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
@Data
public class ExpensesPage_M {

    public ExpensesPage_M() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"steps-uid-0-t-2\"]/span[4]")
    private WebElement expensesLink;

    @FindBy(name = "//*[@id=\"steps-uid-0-p-2\"]/div/div[1]/div/ul/li[1]/fieldset/div/label/text()")
    private WebElement rent;

    public void rent() {
        rent.click();

    }

    @FindBy(id = "monthlyrentalpayment")
    private WebElement payment;
   // public void payment() {
     //  payment.sendKeys("1000");
   // }

    @FindBy(xpath = "//*[@id=\"steps-uid-0\"]/div[3]/ul/li[2]/a")
    private WebElement next;

  //  public void Save() {
     //   next.click();
    public void expensesLink() {
        expensesLink.click();
    }

    public void fillOutExpensesForm() {
        expensesLink.click();
        rent.click();
        payment.sendKeys("1000");
        next.click();}




}
