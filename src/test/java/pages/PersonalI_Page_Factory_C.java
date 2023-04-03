import com.github.javafaker.Faker;
import io.cucumber.java.zh_cn.那么;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class PersonalI_Page_Factory_C {

    Faker faker = new Faker();
    public PersonalI_Page_Factory_C(){
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

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement login;

    public void loGin(){
        login.click();
    }
    @FindBy(xpath = "//span[.='Mortgage Application']")
    private WebElement mortgaceC;

    public void mortageClick(){
        mortgaceC.click();
    }
    @FindBy(xpath = "//label[@for='realtor2']")
    private WebElement preapNoButton;

    public void preapruNo(){
        preapNoButton.click();
    }

    @FindBy(xpath = "//input[@id='estimatedprice']")
    private WebElement estimatePrice;

    public void estimatePri(){
        estimatePrice.sendKeys("50000");
    }
    @FindBy(xpath = "//input[@id='downpayment']")
    private WebElement estimateDownP;

    public void setEstimateDownP(){
        estimateDownP.sendKeys("10000");
    }
    @FindBy(xpath = "//a[.='Next']")
    private WebElement preaprovalNext;

    public void setPreaprovalNext(){
        preaprovalNext.click();
    }

    @FindBy(xpath = "//label[@for='coborrower1']")
    private WebElement coBorrower;

    public void setCoBorrower(){
        SeleniumUtils.jsClick(coBorrower);
    }

    @FindBy(xpath = "//input[@id='c_firstName']")
    private WebElement coFirstName;

    public void setCoFirstName(){
        coFirstName.sendKeys("Josh");
    }
    @FindBy(xpath = "//input[@id='c_middleName']")
    private WebElement coMiddleName;

    public void setCoMiddleName(){
        coMiddleName.sendKeys("Joshua");
    }
    @FindBy(xpath = "//input[@id='c_lastName']")
    private WebElement coLastName;

    public void setCoLastName(){
        coLastName.sendKeys("JoshuaX");
    }

    @FindBy(xpath = "(//span[@id='select2-c_suffix-container'])[1]")
    private WebElement coSulfixPlace;

    public void setCoSulfixPlace(){
        //String name = "Sr.";
        coSulfixPlace.click();
//        coSulfixPlace.sendKeys(Keys.ENTER);
//       coSulfixPlace.sendKeys(name);

    }
    @FindBy(xpath = "//li[contains(text(), 'Sr.')]")
    private WebElement coSulfixSr;

    public void setCoSulfixSr(){
        //coSulfixSr.sendKeys(Keys.DOWN,Keys.DOWN);
        coSulfixSr.click();
    }
    @FindBy(xpath = "//input[@id='c_email']")
    private WebElement coEmailAd;

    public void setCoEmailAd(){
        Faker faker = new Faker();
        coEmailAd.sendKeys(faker.internet().emailAddress());
    }
    @FindBy(xpath = "//input[@id='c_dob']")
    private WebElement coDateBirth;

    public void setCoDateBirth(){
        String date = "05/05/2005";
        coDateBirth.sendKeys(date);
    }
    @FindBy(id = "ssn")
    private WebElement coSSN;

    public void setCoSSN(){
        //String date = "05/05/2005";
        coSSN.sendKeys("123456789");
    }
    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/form[1]/div[2]/fieldset[2]/div[3]/div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]")
    private WebElement coMarytalStatus;

    public void setCoMarytalStatus(){
        coMarytalStatus.click();
       //coMarytalStatus.sendKeys(Keys.ENTER);
//        SeleniumUtils.waitForClickablility(coMarytalStatus,10);
      //  coMarytalStatus.sendKeys("Married");
        //SeleniumUtils.waitFor(5);
        List<WebElement> maritalStatus = Driver.getDriver().findElements(By.xpath("//li[@class='select2-results__option']"));
        int dayIndex1 = (int) (Math.random() * maritalStatus.size());
       maritalStatus.get(dayIndex1).click();
    }
//    @FindBy(css = "#select2-c_marital-result-ujzf-Married")
//    private WebElement coMarytalp;
//
//    public void setCoMarytalp(){
//        coMarytalp.click();
//        //coMarytalp.sendKeys(Keys.PAGE_DOWN);
//    }
    @FindBy(xpath = "//div[@class='co-borrower']//input[contains(@id, 'cell')]")
    private WebElement cophoneNumber;

    public void setCophoneNumber(){
        cophoneNumber.sendKeys(faker.phoneNumber().cellPhone());
    }
    @FindBy(xpath = "//div[@class='co-borrower']//input[contains(@id, 'home')]")
    private WebElement coHomephoneNumber;

    public void setCoHomephoneNumber(){
        coHomephoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
    }

//Personal information section

    @FindBy(xpath = "//input[@id='b_firstName']")
    private WebElement personalName;

    public void setPersonalName(){
        personalName.sendKeys("OnurKevin");
    }
    @FindBy(xpath = "//input[@id='b_middleName']")
    private WebElement personalMiddleName;

    public void setPersonalMiddleName(){
        personalMiddleName.sendKeys("OnurKevin");
    }
    @FindBy(xpath = "//input[@id='b_lastName']")
    private WebElement personalLastName;

    public void setPersonalLastName(){
        personalLastName.sendKeys("OnurKevin");
    }
    @FindBy(xpath = "(//span[@id='select2-b_suffix-container'])[1]")
    private WebElement perSulfixPlace;

    public void setPerSulfixPlace() {
        //String name = "Sr.";
        perSulfixPlace.click();
    }
    @FindBy(xpath = "//li[contains(text(), 'III')]")
    private WebElement perSulfixIII;

    public void setPerSulfixIII(){
        perSulfixIII.click();
    }
    @FindBy(xpath = "//input[@id='b_email']")
    private WebElement perEmailAd;

    public void setPerEmailAd(){
        Faker faker = new Faker();
        perEmailAd.sendKeys(faker.internet().emailAddress());
    }
    @FindBy(xpath = "//input[@id='b_dob']")
    private WebElement perDateBirth;

    public void setPerDateBirth(){
        String date = "05/05/2004";
        perDateBirth.sendKeys(date);
    }
    @FindBy(id = "b_ssn")
    private WebElement perSSN;

    public void setPerSSN(){
        perSSN.sendKeys("987654321");
    }
    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/form[1]/div[2]/fieldset[2]/div[2]/div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")
    private WebElement perMarytalStatus;

    public void setPerMarytalStatus(){
        perMarytalStatus.click();
        List<WebElement> perMarytal = Driver.getDriver().findElements(By.xpath("//li[@class='select2-results__option']"));
        int dayIndex1 = (int) (Math.random() * perMarytal.size());
        perMarytal.get(dayIndex1).click();
    }
    @FindBy(xpath = "(//input[@id='b_cell'])[1]")
    private WebElement perCell;

    public void setPerCell(){
        perCell.sendKeys(faker.phoneNumber().cellPhone());
    }

    @FindBy(xpath = "//div[@class='borrower']//input[@id='b_home']")
    private WebElement perHome;

    public void setPerHome(){
        perHome.sendKeys(faker.phoneNumber().phoneNumber());
    }
    @FindBy(xpath = "//a[normalize-space()='Next']")
    private WebElement perCoNextButton;

    public void setPerCoNextButton(){
        perCoNextButton.click();
    }
    //Check box
    @FindBy(xpath = "//label[@for='privacypolicy']")
    private WebElement perPtivacyCheckBoxButton;

    public void setPerPtivacyCheckBoxButton(){
        perPtivacyCheckBoxButton.click();
    }
}