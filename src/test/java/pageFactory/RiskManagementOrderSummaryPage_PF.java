package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilFunctions;

public class RiskManagementOrderSummaryPage_PF {


    UtilFunctions util;
    WebDriver driver;

    public RiskManagementOrderSummaryPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
    }

    String strOrderStatus = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div/div/label[1]";
    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div/div/label[1]")
    WebElement order_status;
    public String getOrderStatus(){
        if(driver.findElement(By.xpath(strOrderStatus)).isDisplayed()){
            return order_status.getText();
        }else{
            return "Noon Guaranteed";
        }
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/span[2]")
    WebElement risk_score;
    public String getRiskScore(){
        return risk_score.getText();
    }

    public void clickRiskScore(){
         risk_score.click();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/span[1]")
    WebElement positive_attributes_count;
    public String getPositiveAttributesCount(){
        return positive_attributes_count.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/span[2]")
    WebElement negative_attributes_count;
    public String getNegativeAttributesCount(){
        return negative_attributes_count.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/span[1]")
    WebElement contactInformation;
    public String getContactInformation(){
        return contactInformation.getText();
    }

    @FindBy(xpath = "")
    WebElement shippingMethod;
    public String getAttributeShippingMethod(){
        return shippingMethod.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/span[1]")
    WebElement shippingAddress;
    public String getShippingAddress(){
        return shippingAddress.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/span[1]")
    WebElement billingAddress;
    public String getBillingAddress(){
        return billingAddress.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
    WebElement shoppingCartPurchaser;
    public String getShoppingCartPurchaser(){
        return shoppingCartPurchaser.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/span[1]")
    WebElement purchaserEmail;
    public String getPurchaserEmail(){
        return purchaserEmail.getText();
    }

    @FindBy(xpath = "//div[@id='__next']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//span//b")
    WebElement shoppingCartAmount;
    public String getCartAmount(){
        return shoppingCartAmount.getText();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
    WebElement cardNumber;
    public String getCardNumber(){
        return cardNumber.getText();
    }

    @FindBy(xpath = "//body//div[@id='__next']//div//div//div//div//div//div//div//div//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//span[1]")
    WebElement mapAttributes;
    public String getMapAttributes(){
        return mapAttributes.getText();
    }

    @FindBy(xpath = "//button[@title='Zoom in']")
    WebElement mapZoomIn;
    public void clickMapZoomIn(){
         mapZoomIn.click();
    }

    @FindBy(xpath = "//button[@title='Zoom out']")
    WebElement mapZoomOut;
    public void clickMapZoomOut(){
        mapZoomOut.click();
    }

    @FindBy(xpath = "//button[@title='Toggle fullscreen view']")
    WebElement mapToggleFullScreenView;
    public void clickToggleFullScreenView(){
        mapToggleFullScreenView.click();
    }

    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div/div/div[@coordinates='[object Object],[object Object],[object Object]']/div/div/div/div[@aria-label='Map']/div/div/div[3]/div[2]/img[1]")
    WebElement mapBillingAddPinter;
    public void clickMapBillingAddPinter(){

        mapBillingAddPinter.click();
    }

    @FindBy(xpath = "//div[@aria-label='Map']//span[1]")
    WebElement mpBillingAddAttributes;
    public String getMapBillingAddAttributes(){
        return mpBillingAddAttributes.getText();
    }


}
