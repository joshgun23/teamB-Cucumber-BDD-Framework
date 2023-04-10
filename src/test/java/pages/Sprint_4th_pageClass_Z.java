package pages;

        import lombok.Data;
        import org.junit.Assert;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import utils.ConfigReader;
        import utils.Driver;

        import java.time.Duration;
        import java.util.List;
        import java.util.Map;

@Data public class Sprint_4th_pageClass_Z {

    public Sprint_4th_pageClass_Z() {
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

    @FindBy(xpath = "/html//form[@id='steps-uid-0']/div[2]/fieldset[5]//ul[@class='list-unstyled mb-0']//label[.='No']")
    public WebElement noButton;

    @FindBy(xpath = "//form[@id='steps-uid-0']//ul[@role='menu']/li[2]/a[@role='menuitem']")
    public WebElement creditRepNext;

    @FindBy(xpath="/html//input[@id='eConsentdeclarerFirstName']")
    public WebElement firstName;

    @FindBy(xpath="/html//input[@id='eConsentdeclarerLastName']")
    public WebElement lastName;

    @FindBy(xpath="/html//input[@id='eConsentdeclarerEmail']")
    public WebElement email;

    @FindBy(xpath="/html//form[@id='steps-uid-0']/div[2]/fieldset[6]/ul[@class='list-unstyled mb-0']/li[1]/fieldset/div[@class='custom-control custom-radio']/label[@class='custom-control-label']")
    public WebElement agreeButton;

    @FindBy(xpath="/html//form[@id='steps-uid-0']/div[2]/fieldset[6]/ul[@class='list-unstyled mb-0']/li[2]/fieldset/div[@class='custom-control custom-radio']/label[@class='custom-control-label']")
    public WebElement disagreeButton;

    @FindBy(xpath="//form[@id='steps-uid-0']//ul[@role='menu']/li[1]/a[@role='menuitem']")
    public WebElement previousButton;

    @FindBy(xpath="//form[@id='steps-uid-0']//ul[@role='menu']/li[2]/a[@role='menuitem']")
    public WebElement nextButton;

    @FindBy(xpath="/html//label[@id='eConsentdeclarerFirstName-error']")
    public WebElement firstNameError;

    @FindBy(xpath="/html//label[@id='eConsentdeclarerLastName-error']")
    public WebElement lastNameError;

    @FindBy(xpath="/html//label[@id='eConsentdeclarerEmail-error']")
    public WebElement emailError;


    public void LogInMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        emailField.sendKeys(ConfigReader.getProperty("username"));
        passwordField.sendKeys(ConfigReader.getProperty("password"));
        signInButton.click();
    }

    public void mortgageLinkMethod(){
        mortgageLink.click();
    }

    public void noButtonMethod(){
        noButton.click();
    }

    public void creditRepNextMethod(){
        creditRepNext.click();
    }

    public void fillOutFields(List<Map<String, String>> dataTable ) {
        firstName.sendKeys(dataTable.get(0).get("firstName"));
        lastName.sendKeys(dataTable.get(0).get("lastName"));
        email.sendKeys(dataTable.get(0).get("email"));
        nextButton.click();

    }

    public void verifyRadioButtons(String agree, String desagree) {
        if (agree.equals("agree")) {
            agreeButton.click();
        } else if (desagree.equals("disagree")) {
            disagreeButton.click();
        }

    }

    public void verifyDefaultButton(String agree) {
        Assert.assertTrue(agreeButton.isSelected());
    }

    public void fillOutFields(String firstname, String lastNam, String emailAdress) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastNam);
        email.sendKeys(emailAdress);
        nextButton.click();
    }

    public void errorMethod() {
        lastName.sendKeys(lastName.getText());
        email.sendKeys(email.getText());
        Assert.assertTrue(firstNameError.isDisplayed());


    }

    public void errorMethod2() {
        firstName.sendKeys(firstName.getText());
        email.sendKeys(email.getText());
        Assert.assertTrue(lastNameError.isDisplayed());

    }

    public void errorMethod3() {
        firstName.sendKeys(firstName.getText());
        lastName.sendKeys(lastName.getText());
        Assert.assertTrue(emailError.isDisplayed());
    }
}
