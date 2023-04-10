package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import java.util.ArrayList;
import java.util.List;

public class Employment_And_Income_Page_R {
    public Employment_And_Income_Page_R() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "currentjobsls")
    public WebElement currentJob;

    @FindBy(id = "employername1")
    public WebElement employer;

    @FindBy(id = "position1")
    public WebElement position;

    @FindBy(id = "city")
    public WebElement enterCity;

    @FindBy(id = "state1")
    public WebElement state;

    @FindBy(id = "start_date1")
    public WebElement startDate;

    @FindBy(id = "end_date1")
    public WebElement endDate;

    @FindBy(id = "addemployer")
    public WebElement addEmployer;

    @FindBy(id = "employername2")
    public WebElement secondEmployer;

    @FindBy(id = "position2")
    public WebElement secondEmployerPosition;

    @FindBy(id = "city2")
    public WebElement secondCity;

    @FindBy(id = "state2")
    public WebElement secondState;

    @FindBy(xpath = "//input[@id='start_date2']")
    public WebElement startDate2;

    @FindBy(xpath = "//input[@id='end_date2']")
    public WebElement endDate2;

    @FindBy(id = "grossmonthlyincome")
    public WebElement enterGrossMonthlyIncome;

    @FindBy(id = "monthlyovertime")
    public WebElement monthlyOverTime;

    @FindBy(id = "monthlybonuses")
    public WebElement enterMonthlyBonuses;

    @FindBy(id = "monthlycommission")
    public WebElement monthlyCommission;

    @FindBy(id = "monthlydividents")
    public WebElement monthlyDividents;

    @FindBy(xpath = "//div[@class='borrowertotalmonthlyincome']")
    public WebElement totalMonthlyIncome;

    @FindBy(id = "incomesource1")
    public WebElement incomesource1;

    @FindBy(id = "incomesource2")
    public WebElement incomesource2;

    @FindBy(id = "incomesource3")
    public WebElement incomesource3;

    @FindBy(linkText = "Employment and Income")
    public WebElement Employment_and_Income;

    @FindBy(id = "amount1")
    public WebElement amount1;

    @FindBy(id = "amount2")
    public WebElement amount2;

    @FindBy(id = "amount3")
    public WebElement amount3;

    @FindBy(id = "grossmonthlyincome-error")
    public WebElement error;

    @FindBy(id = "Alimony/Child Support")
    public WebElement clickOnAlimony;

    //elements from PersonalInfoPage
    @FindBy(xpath = "//input[@id='b_firstName']")
    public WebElement personalName;

    @FindBy(xpath = "//input[@id='b_lastName']")
    public WebElement personalLastName;

    @FindBy(xpath = "//input[@id='b_email']")
    public WebElement emailAddress;

    @FindBy(id = "b_ssn")
    public WebElement perSSN;

    @FindBy(xpath = "(//input[@id='b_cell'])[1]")
    public WebElement perCell;

    @FindBy(xpath = "//span[@id='select2-b_marital-container']")
    public WebElement perMarytalStatus;

    @FindBy(xpath = "//a[normalize-space()='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@id='b_dob']")
    public WebElement perDateBirth;

    //elements from ExpensesPage

    @FindBy(xpath = "//label[normalize-space()='Rent']")
    public WebElement rent;

    @FindBy(xpath = "//input[@id='monthlyrentalpayment']")
    public WebElement rentalPayment;

    public void getToEmploymentAndIncome() {
        PreApproval_Details_Page_R preapproval_details_page = new PreApproval_Details_Page_R();
        Employment_And_Income_Page_R employmentAndIncomePage = new Employment_And_Income_Page_R();
        preapproval_details_page.setPreapproval_method("John Smith", 40000, 10000);
        employmentAndIncomePage.Personal_Info_method("Elon", "Musk", "elonmusk@gmail.com", "05/05/2004", 987654321, "3055099345");
        employmentAndIncomePage.passExpensesPage();
    }

    public void Personal_Info_method(String name, String last, String email, String dob, int soc, String phone) {

        personalName.sendKeys(name);
        personalLastName.sendKeys(last);
        emailAddress.sendKeys(email);
        perDateBirth.sendKeys(dob);
        perSSN.sendKeys(Integer.toString(soc));
        perCell.sendKeys(phone);

        Actions actions = new Actions(Driver.getDriver());
        actions.click(perMarytalStatus).sendKeys("Married" + Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
        nextButton.click();
    }

    public void passExpensesPage() {
        rent.click();
        rentalPayment.sendKeys("3000");
        nextButton.click();
    }

    public void getToCreditReportPage() {
        Faker faker = new Faker();
        Employment_And_Income_Page_R employmentAndIncomePage = new Employment_And_Income_Page_R();
        new Employment_And_Income_Page_R().getToEmploymentAndIncome();
        employer.sendKeys(faker.name().fullName());
        position.sendKeys(faker.company().profession());
        enterCity.sendKeys(faker.address().city());
        state.click();
        state.sendKeys("F", Keys.ENTER);
        startDate.sendKeys(faker.backToTheFuture().date());
        int salary = faker.number().numberBetween(5000, 10000);
        enterGrossMonthlyIncome.sendKeys(String.valueOf(salary));
        nextButton.click();
    }

    public void enterCredentials(String employerName, String employerPosition,
                                 String city, String grossMonthlyIncome) {

        employer.sendKeys(employerName);
        position.sendKeys(employerPosition);
        enterCity.sendKeys(city);
        enterGrossMonthlyIncome.sendKeys(grossMonthlyIncome);
    }

    public void enterSecondEmployer(String employerName, String employerPosition,
                                    String city, String startDate1, String grossMonthlyIncome) {
        addEmployer.click();
        secondEmployer.sendKeys(employerName);
        secondEmployerPosition.sendKeys(employerPosition);
        secondCity.sendKeys(city);
        startDate2.sendKeys(startDate1);
        enterGrossMonthlyIncome.sendKeys(grossMonthlyIncome);
        nextButton.click();
    }

    public List<String> expectedStates() {
        List<String> statesCount;
        statesCount = List.of("--Select--", "Alabama (AL)", "Alaska (AK)", "Arizona (AZ)", "Arkansas (AR)",
                "California (CA)", "Colorado (CO)", "Connecticut (CT)", "Delaware (DE)", "Florida (FL)", "Georgia (GA)", "Hawaii (HI)", "Idaho (ID)",
                "Illinois (IL)", "Indiana (IN)", "Iowa (IA)", "Kansas (KS)", "Kentucky (KY)", "Louisiana (LA)", "Maine (ME)", "Maryland (MD)",
                "Massachusetts (MA)", "Michigan (MI)", "Minnesota (MN)", "Mississippi (MS)", "Missouri (MO)", "Montana (MT)", "Nebraska (NE)",
                "Nevada (NV)", "New Hampshire (NH)", "New Jersey (NJ)", "New Mexico (NM)", "New York (NY)", "North Carolina (NC)",
                "North Dakota (ND)", "Ohio (OH)", "Oklahoma (OK)", "Oregon (OR)", "Pennsylvania (PA)", "Rhode Island (RI)", "South Carolina (SC)",
                "South Dakota (SD)", "Tennessee (TN)", "Texas (TX)", "Utah (UT)", "Vermont (VT)", "Virginia (VA)", "Washington (WA)",
                "West Virginia (WV)", "Wisconsin (WI)", "Wyoming (WY)");
        return statesCount;
    }

    public List<String> actualStates() {
        List<WebElement> statesDropDown = new Select(state).getOptions();
        int optionsCount = new Select(state).getOptions().size();
        List<String> states = new ArrayList<>();

        for (WebElement state : statesDropDown) {
            states.add(state.getText());
        }
        return states;
    }

    public void enterAdditionalInfo(String employerName, String employerPosition,
                                    String city, String startDate1, String grossMonthlyIncome,
                                    String monthlyOvertime, String monthlyBonuses, String monthlyCommissions,
                                    String monthlyDividends) {
        employer.sendKeys(employerName);
        position.sendKeys(employerPosition);
        enterCity.sendKeys(city);
        startDate.sendKeys(startDate1);
        enterGrossMonthlyIncome.sendKeys(grossMonthlyIncome);
        monthlyOverTime.sendKeys(monthlyOvertime);
        enterMonthlyBonuses.sendKeys(monthlyBonuses);
        monthlyCommission.sendKeys(monthlyCommissions);
        monthlyDividents.sendKeys(monthlyDividends);
    }

}