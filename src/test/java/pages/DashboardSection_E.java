package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;


import java.util.List;

public class DashboardSection_E {


    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement dashboard;

    public void dashboard() {
        Assert.assertTrue( dashboard.isDisplayed() );

    }
        @FindBy(xpath = "//div[@class='brand-logo']//span")
    public List<WebElement> brandLogo;


    @FindBy(xpath = "//div[@class='menu-title']//span")
    public List<WebElement> dashboardSection;

    @FindBy(xpath = "//div[@class='menu-title']//span")
    public List<WebElement> mortgageApplication;

    @FindBy(xpath = "//div[@class='menu-title']//span")
    public List<WebElement> applicationList;

    @FindBy(xpath = "//div[@class='dropdown-item']//span")
    public List<WebElement> logOut;
    @FindBy(xpath = "//span[@class='user-name']//span")
    public List<WebElement> userNam ; // check name?

}



