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


    @FindBy(xpath = "//a[@class='menu-title']")
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

    @FindBy(xpath = "////span[@data-i18n='eCommerce']")
    public List<WebElement> MortgageApplicationLink  ; //
    @FindBy(xpath = "//span[@class='Summary']//span")
    public List<WebElement>  Summary ; //

    @FindBy(xpath = "//a[href[@class='btn btn-success buttonEdit']]")
    public List<WebElement>  editButton ; //

    @FindBy(xpath = "//a[@href='#finish']")
    public List<WebElement>  submitButton ; //

    @FindBy(id="steps-uid-0-t-0")
    public WebElement preapprovalDetailsE;

    @FindBy(xpath = "//label[@for='realtor2']")
    public WebElement noRealtor;

    @FindBy(xpath = "//label[.='No']")
    public WebElement loanOfficerNo;

    @FindBy(id="estimatedprice")
    public WebElement estimatedPriceFeild;

    @FindBy(id="downpayment")
    public WebElement downPayment;




}



