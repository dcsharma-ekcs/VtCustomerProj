package pageFactory;

import dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.UtilFunctions;

public class BusinessInsightsPage_PF {


    UtilFunctions util;
    WebDriver driver;
    WebDriverWait wait;
    ConfigFileReader configFileReader;

    public BusinessInsightsPage_PF(WebDriver driver) {
        this.driver = driver;
        configFileReader= new ConfigFileReader();
        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
        wait  = new WebDriverWait(driver, configFileReader.getFluentWait());
    }

    //li[normalize-space()='Risk Management']
    String srtBusinessInsights = "//img[@id='Business InsightsId']";
    @FindBy(xpath = "//img[@id='Business InsightsId']")
    WebElement business_insights_tab;
    public void clickOnBusinessInsightsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(business_insights_tab));
        business_insights_tab.click();
    }


}
