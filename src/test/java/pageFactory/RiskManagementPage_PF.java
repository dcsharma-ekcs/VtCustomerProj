package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilFunctions;

public class RiskManagementPage_PF {


    UtilFunctions util;
    WebDriver driver;

    public RiskManagementPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
    }

    String srtRiskManagement = "//li[normalize-space()='Risk Management']";
    @FindBy(xpath = "//li[normalize-space()='Risk Management']")
    WebElement risk_management_tab;

    public void clickOnRiskManagementTab() throws InterruptedException {
        util.waitForXpathElement(srtRiskManagement);
        risk_management_tab.click();
    }


    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement search_input_field;

    public  void  setSearchText(String orderId){
        search_input_field.click();
        search_input_field.clear();
        search_input_field.sendKeys(orderId);
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/span[1]")
    WebElement positive_attributes_count;

    public String getPositiveAttributesCount(){
        return positive_attributes_count.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/span[2]")
    WebElement negative_attributes_count;

    public String getNegativeAttributesCount(){

        return negative_attributes_count.getText();
    }
}
