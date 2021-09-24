package pageFactory;

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

    public RiskManagementPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
        wait  = new WebDriverWait(driver, 30);
    }

    String srtRiskManagement = "//li[normalize-space()='Risk Management']";
    @FindBy(xpath = "//li[normalize-space()='Risk Management']")
    WebElement risk_management_tab;
    public void clickOnRiskManagementTab() throws InterruptedException {
        util.waitForXpathElement(srtRiskManagement);
        wait.until(ExpectedConditions.elementToBeClickable(risk_management_tab));
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
       boolean flag = checkboxAcceptDecisions.isSelected();
       return flag;
    }

    String noonAcceptDecisions = "//tbody/tr[@role='row']/td[3]/div[1]/label[1]/span[1]/span[1]/span[1]/input[1]";
    @FindBy(xpath = "//tbody/tr[@role='row']/td[3]/div[1]/label[1]/span[1]/span[1]/span[1]/input[1]")
    WebElement checkboxNoonAcceptDecisions;
    public boolean getNoonAcceptDecisions() throws InterruptedException {
        boolean flag = checkboxNoonAcceptDecisions.isSelected();
        return flag;
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement search_input_field;
    public  void  setSearchText(String orderId){
        wait.until(ExpectedConditions.elementToBeClickable(search_input_field));
        search_input_field.click();
        search_input_field.clear();
        search_input_field.sendKeys(orderId);
    }


}
