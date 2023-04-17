package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.time.Duration;

@Data
public class PreApproval_Details_Page_R {

    public PreApproval_Details_Page_R() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signin")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='dashboard.php']")
    private WebElement dashBoardButton;

    @FindBy(xpath = "//a[@href='mortgage.php']")
    private WebElement mortgageLink;

    @FindBy(id = "steps-uid-0-t-0")
    private WebElement preapprovalDetails;

    @FindBy(xpath = "//label[@for='realtor1']")
    public WebElement realtorYes;

    @FindBy(xpath = "//input[@id='realtor1']")
    private WebElement yesRealtorCheckBox;

    @FindBy(xpath = "//label[@for='realtor2']")
    private WebElement realtorNo;

    @FindBy(xpath = "//input[@id='realtor2']")
    private WebElement noRealtorCheckBox;

    @FindBy(id = "realtorinfo")
    public WebElement realtorInfoField;

    @FindBy(xpath = "//label[.='Yes']")
    private WebElement loanOfficerYes;

    @FindBy(xpath = "//input[@id='loanofficer1']")
    private WebElement yesLoanOfficerCheckBox;

    @FindBy(xpath = "//label[@for='loanofficer2']")
    public WebElement loanOfficerNo;

    @FindBy(xpath = "//input[@id='loanofficer2']")
    private WebElement noLoanOfficerCheckBox;

    @FindBy(xpath = "//select[@name='purpose_loan']")
    private WebElement loanPurposeDropDown;

    @FindBy(xpath = "//span[@title='Purchase a Home']")
    public WebElement purposeOfLoanButton;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement purposeOfLoanField;

    @FindBy(xpath = "//span[.='Personal Information']")
    public WebElement personalInformationPageText;

    @FindBy(id = "estimatedprice")
    public WebElement estimatedPrice;

    @FindBy(id = "downpayment")
    public WebElement downPaymentAmount;

    @FindBy(id = "downpaymentpercentage")
    public WebElement downPaymentPercentage;

    @FindBy(id = "loanamount")
    private WebElement loanAmount;

    @FindBy(xpath = "//input[@id='loanamount']")
    public WebElement calculatedLoanAmountValue;

    @FindBy(name = "src_down_payment")
    private WebElement sourceOfDownPayment;

    @FindBy(xpath = "//span[@role='textbox' and .='Checking/Savings (most recent bank statement)']")
    public WebElement downPaymentSourceButton;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement downPaymentSourceField;

    @FindBy(id = "select2-src_down_payment-r2-result-tosd-Other type of Down Payment")
    private WebElement otherTypeOfDownPayment;

    @FindBy(id = "additionalfunds")
    private WebElement additionalFunds;

    @FindBy(xpath = " //a[@href='#next'] ")
    public WebElement buttonNext;

    @FindBy(xpath = "//ul[@role='tablist']/li[1]")
    private WebElement preapprovalDetailsTab;

    //Expenses elements

    @FindBy(xpath = "//label[@for='expense1']")
    private WebElement rent;

    @FindBy(id = "monthlyrentalpayment")
    private WebElement payment;

    //Econsent elements
    @FindBy(id = "eConsentdeclarerFirstName")
    private WebElement econsentFirstName;

    @FindBy(id = "eConsentdeclarerLastName")
    private WebElement econsentLastName;

    @FindBy(id = "eConsentdeclarerEmail")
    private WebElement econsentEmail;

    @FindBy(xpath = "//input[@name='consentagree']")
    private WebElement econsentAgreeButton;

    //Summary elements

    @FindBy(xpath = "//a[@id='steps-uid-0-t-0']")
    private WebElement preApprovaldetailsLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-1']")
    private WebElement personalInfoLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-2']")
    private WebElement expensesLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-3']")
    private WebElement employmentAndIncomeLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-4']")
    private WebElement creditReportLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-5']")
    private WebElement eConsentLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-6']")
    private WebElement summaryLink;

    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement submitButton;

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickNext() {
        buttonNext.click();
    }

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

    public void LogInMethod() {
        sendKeysToEmailField(ConfigReader.getProperty("username"));
        sendKeysToPasswordField(ConfigReader.getProperty("password"));
        signInButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickMortgageApplication() {
        mortgageLink.click();
    }

    public WebElement getPreapprovalDetails() {
        return preapprovalDetails;
    }

    public WebElement getLoanPurposeDropDown() {
        return loanPurposeDropDown;
    }

    public void setPreapproval_method(String realtor, int num, int downPay) {
        realtorInfoField.sendKeys(realtor);
        estimatedPrice.sendKeys(Integer.toString(num));
        downPaymentAmount.sendKeys(Integer.toString(downPay));
        buttonNext.click();
    }

    public void realtorCheckBox() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", realtorYes);
    }

    public void realtorCheckBoxNo() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", realtorNo);
    }

    public void realtorInformationField(String realtor) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", realtorInfoField);
        realtorInfoField.sendKeys(realtor);
    }

    public void loanOfficerCheckBoxYes() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", loanOfficerYes);
    }

    public void loanOfficerCheckBox() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", loanOfficerNo);
    }

    public void sourceOfDownPaymentDropdown() {
        Select select = new Select(sourceOfDownPayment);
        select.selectByIndex(2);
    }

    public void fillOutTheForm(
            String realtorStatus,
            String realtorInfo,
            String loanOfficerStatus,
            String purposeLoan,
            String estPurchasePrice,
            String downPayment,
            String downPaymentPercent,
            String totalLoanAmount,
            String srcDownPayment,
            String addFundAvailable) {
        if (realtorStatus.equalsIgnoreCase("Yes") || realtorStatus.equals("1")) {
            realtorCheckBox();
            this.realtorInfoField.sendKeys(realtorInfo);
        } else {
            realtorCheckBoxNo();
        }
        if (loanOfficerStatus.equalsIgnoreCase("Yes") || loanOfficerStatus.equals("1")) {
            loanOfficerCheckBoxYes();
        } else {
            loanOfficerCheckBox();
        }
        Select loanPurposeSelect = new Select(loanPurposeDropDown);
        loanPurposeSelect.selectByVisibleText(purposeLoan);
        this.estimatedPrice.sendKeys(estPurchasePrice);
        this.downPaymentAmount.sendKeys(downPayment);
        // downPaymentPercent and totalLoanAmount are calculated automatically
        Select srcDropdown = new Select(sourceOfDownPayment);
        srcDropdown.selectByVisibleText(srcDownPayment);
        this.additionalFunds.sendKeys(addFundAvailable);
    }

    public void personalInfo() {
        PersonalI_Page_Factory_C personalI_page_factory_c = new PersonalI_Page_Factory_C();
        personalI_page_factory_c.setPersonalName();
        personalI_page_factory_c.setPersonalMiddleName();
        personalI_page_factory_c.setPersonalLastName();
        personalI_page_factory_c.setPerSulfixPlace();
        personalI_page_factory_c.setPerSulfixIII();
        personalI_page_factory_c.setPerEmailAd();
        personalI_page_factory_c.setPerDateBirth();
        personalI_page_factory_c.setPerSSN();
        personalI_page_factory_c.setPerMarytalStatus();
        personalI_page_factory_c.setPerCell();
        personalI_page_factory_c.setPerHome();
        personalI_page_factory_c.setPerCoNextButton();

    }

    public void fillOutExpensesForm() {
        expensesLink.click();
        rent.click();
        payment.sendKeys("1000");
        buttonNext.click();
    }

    public void fillingCreditReport() {
        buttonNext.click();
    }

    public void fillingOutEconsent() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        econsentFirstName.sendKeys(firstName);
        econsentLastName.sendKeys(lastName);
        econsentEmail.sendKeys(email);
        SeleniumUtils.jsClick(econsentAgreeButton);
        buttonNext.click();
    }

}

