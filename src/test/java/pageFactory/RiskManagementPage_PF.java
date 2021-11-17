package pageFactory;

import dataProviders.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.UtilFunctions;

public class RiskManagementPage_PF {


    UtilFunctions util;
    WebDriver driver;
    WebDriverWait wait;
    ConfigFileReader configFileReader;

    public RiskManagementPage_PF(WebDriver driver) {
        this.driver = driver;
        configFileReader= new ConfigFileReader();
        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
        wait  = new WebDriverWait(driver, configFileReader.getFluentWait());
    }


    String retrieving_information_popup = "//div[@role='dialog']//div//div//div//label//p";
    public  void  checkProgressbarStatus() throws InterruptedException {
        util.checkProgressbar(retrieving_information_popup);
    }

    //li[normalize-space()='Risk Management']
    String srtRiskManagement = "//div[@id='__next']//div//header//div//div//img[@id='Risk ManagementId']";
    @FindBy(xpath = "//div[@id='__next']//div//header//div//div//img[@id='Risk ManagementId']")
    WebElement risk_management_tab;
    public void clickOnRiskManagementTab() throws InterruptedException {
        //util.waitForXpathElement(srtRiskManagement);
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.elementToBeClickable(risk_management_tab));
        Thread.sleep(5000);
        risk_management_tab.click();
    }


    String srtDecisions = "//img[@src='/img/sidemenu/default/decisions.svg']";
    @FindBy(xpath = "//img[@src='/img/sidemenu/default/decisions.svg']")
    WebElement risk_management_decisions;
    public void clickOnDecisionsTab() throws InterruptedException {
        util.waitForXpathElement(srtDecisions);
        wait.until(ExpectedConditions.elementToBeClickable(risk_management_decisions));
        risk_management_decisions.click();
    }

    String srtSearchDecisions = "//div[@class='table-dekstop']//input[@type='text']";
    @FindBy(xpath = "//div[@class='table-dekstop']//input[@type='text']")
    WebElement search_decisions;
    public void setSrtSearchDecisions(String strStore) throws InterruptedException {
        util.waitForXpathElement(srtSearchDecisions);
        wait.until(ExpectedConditions.elementToBeClickable(search_decisions));
        Thread.sleep(1000);
        search_decisions.click();
        search_decisions.sendKeys(strStore);
    }

    String acceptDecisions = "//tbody/tr[@role='row']/td[2]/div[1]/label[1]/span[1]/span[1]/span[1]/input[1]";
    @FindBy(xpath = "//tbody/tr[@role='row']/td[2]/div[1]/label[1]/span[1]/span[1]/span[1]/input[1]")
    WebElement checkboxAcceptDecisions;
    public boolean getAcceptDecisions() throws InterruptedException {
        Thread.sleep(1000);
       boolean flag = checkboxAcceptDecisions.isSelected();
       return flag;
    }

    String noonAcceptDecisions = "//tbody/tr[@role='row']/td[3]/div[1]/label[1]/span[1]/span[1]/span[1]/input[1]";
    @FindBy(xpath = "//tbody/tr[@role='row']/td[3]/div[1]/label[1]/span[1]/span[1]/span[1]/input[1]")
    WebElement checkboxNoonAcceptDecisions;
    public boolean getNoonAcceptDecisions() throws InterruptedException {
        Thread.sleep(1000);
        boolean flag = checkboxNoonAcceptDecisions.isSelected();
        return flag;
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement search_input_field;
    public  void  setSearchText(String orderId) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(search_input_field));
        Thread.sleep(3000);
        search_input_field.click();
        search_input_field.clear();
        search_input_field.sendKeys(orderId);
    }

    String srtOrderDetailButton = "//tbody/tr[1]/td[8]/button[1]/span[1]//*[name()='svg']";
    public boolean isOrderDetailPresent() throws InterruptedException {
        return util.isElementPresent(By.xpath(srtOrderDetailButton));
    }

    String srtPNaddButton = "//div[@id='customBreadCrumbs']//div//div[2]//div[1]//div[1]//div[1]//button[1]//span[1]";
    public boolean isAddPNButtonPresent() throws InterruptedException {
        return util.isElementPresent(By.xpath(srtPNaddButton));
    }




}
