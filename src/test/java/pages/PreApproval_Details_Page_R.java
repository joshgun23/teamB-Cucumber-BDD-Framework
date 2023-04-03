package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import java.time.Duration;

public class PreApproval_Details_Page_R {


    public PreApproval_Details_Page_R() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "signin")
    public WebElement signInButton;

    @FindBy(xpath = "//span[@data-i18n='eCommerce']")
    public WebElement mortgageLink;

    @FindBy(id="steps-uid-0-t-0")
    public WebElement preapprovalDetails;

    @FindBy(xpath = "//label[@for='realtor1']")
    public WebElement realtorYes;

    @FindBy(xpath = "//label[@for='realtor2']")
    public WebElement realtorNo;

    @FindBy(xpath = "//label[.='Yes']")
    public WebElement loanOfficerYes;

    @FindBy(xpath = "//label[@for='loanofficer2']")
    public WebElement loanOfficerNo;

    @FindBy(id="realtorinfo")
    public WebElement realtorInfoField;

    @FindBy(xpath = "//span[@title='Purchase a Home']")
    public WebElement purposeOfLoanButton;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement purposeOfLoanField;

    @FindBy(xpath = "//span[.='Personal Information']")
    public WebElement personalInformationPageText;

    @FindBy(id="estimatedprice")
    public WebElement estimatedPrice;

    @FindBy(id="downpayment")
    public WebElement downPaymentAmount;

    @FindBy(id="downpaymentpercentage")
    public WebElement downPaymentPercentage;

    @FindBy(id="loanamount")
    public WebElement loanAmount;

    @FindBy(xpath = "//input[@id='loanamount']")
    public WebElement calculatedLoanAmountValue;

    @FindBy(name="src_down_payment")
    public WebElement sourceOfDownPayment;

    @FindBy(xpath = "//span[@role='textbox' and .='Checking/Savings (most recent bank statement)']")
    public WebElement downPaymentSourceButton;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement downPaymentSourceField;

    @FindBy(id="select2-src_down_payment-r2-result-tosd-Other type of Down Payment")
    public WebElement otherTypeOfDownPayment;

    @FindBy(id="additionalfunds")
    public WebElement additionalFunds;

    @FindBy(xpath=" //a[@href='#next'] ")
    public WebElement buttonNext;



    public void sendKeysToEmailField(String keys) {
        emailField.sendKeys(keys);
    }

    public WebElement getEmail() {
        return emailField;
    }

    public WebElement getPassword() {
        return passwordField;
    }

    public void sendKeysToPasswordField(String keys) {
        passwordField.sendKeys(keys);
    }

    public void LogInMethod(){
        sendKeysToEmailField(ConfigReader.getProperty("username"));
        sendKeysToPasswordField(ConfigReader.getProperty("password"));
        signInButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickMortgageApplication(){
        mortgageLink.click();
    }

    public WebElement getPreapprovalDetails() {
        return preapprovalDetails;
    }

    public void setPreapproval_method(String realtor, int num, int downPay){
        realtorInfoField.sendKeys(realtor);
        estimatedPrice.sendKeys(Integer.toString(num));
        downPaymentAmount.sendKeys(Integer.toString(downPay));
        buttonNext.click();
    }

    public void realtorCheckBox(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",realtorYes);
    }

    public void realtorInformationField(String realtor){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",realtorInfoField);
        realtorInfoField.sendKeys(realtor);
    }

    public void loanOfficerCheckBox(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",loanOfficerNo);
    }

    public void sourceOfDownPaymentDropdown(){
        Select select = new Select(sourceOfDownPayment);
        select.selectByIndex(2);
    }


}
