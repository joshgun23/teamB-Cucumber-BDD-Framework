package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class DashboardSection_E {

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
    public List<WebElement> userName;

}



