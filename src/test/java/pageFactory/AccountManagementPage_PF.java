package pageFactory;

import dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.UtilFunctions;

import java.util.Locale;

public class AccountManagementPage_PF {

    UtilFunctions util;
    WebDriver driver;
    WebDriverWait wait;
    ConfigFileReader configFileReader;

    public AccountManagementPage_PF(WebDriver driver) {
        this.driver = driver;
        configFileReader= new ConfigFileReader();
        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
        wait  = new WebDriverWait(driver, configFileReader.getFluentWait());
    }

    String srtAccountManagement = "//div[@id='__next']//div//header//div//div//img[@id='Account ManagementId']";
    @FindBy(xpath = "//div[@id='__next']//div//header//div//div//img[@id='Account ManagementId']")
    WebElement account_management_tab;
    public void clickOnAccountManagementTab() throws InterruptedException {
        util.waitForXpathElement(srtAccountManagement);
        wait.until(ExpectedConditions.elementToBeClickable(account_management_tab));
        Thread.sleep(5000);
        account_management_tab.click();
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement search_input_field;
    public  void  setSearchText(String searchText) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(search_input_field));
        Thread.sleep(3000);
        search_input_field.click();
        search_input_field.clear();
        search_input_field.sendKeys(searchText);
    }

    @FindBy(xpath = "//tbody//tr//td[2]")
    WebElement stage_status;
    public  String  getStageStatus() throws InterruptedException {
        Thread.sleep(3000);
        return  stage_status.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[8]/span[1]//*[name()='svg']")
    WebElement arrow_button;
    public  void  clickArrowButton() throws InterruptedException {
        arrow_button.click();
    }

    @FindBy(xpath = "//body//div[@id='__next']//div[@id='tab-Configure']//div//div//div[1]//div[2]//div[1]//div[1]//div[1]//button[1]")
    WebElement merchant_vertical;
    public  String  getMerchantVertical() throws InterruptedException {
        return  merchant_vertical.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//body//div[@id='__next']//div[@id='tab-Configure']//div//div//div//div[2]//div[2]//div[1]//div[1]//div[1]//button[1]")
    WebElement merchant_sub_vertical;
    public  String  getMerchantSubVertical() throws InterruptedException {
        return  merchant_sub_vertical.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    WebElement payment_processor;
    public  String  getPaymentProcessor() throws InterruptedException {
        return  payment_processor.getAttribute("value").trim().toLowerCase(Locale.ROOT);
    }



}
