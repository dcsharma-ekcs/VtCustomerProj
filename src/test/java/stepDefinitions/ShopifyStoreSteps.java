package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageFactory.RiskManagementPage_PF;
import pageFactory.VtCustomerPage_PF;
import pages.ShopifyHomePageObject;
import util.UtilFunctions;

public class ShopifyStoreSteps {


    static ShopifyHomePageObject shopifyHomePageObject;
    static String storeName;
    ConfigFileReader configFileReader;

    InitiateTransactionsSteps initiateTransactionsSteps = new InitiateTransactionsSteps();
    RiskManagementOrderSummarySteps riskManagementOrderSummarySteps = new RiskManagementOrderSummarySteps();
    RiskManagementSteps riskManagementSteps = new RiskManagementSteps();
    WebDriver driver = initiateTransactionsSteps.getDriver();
    String orderId = initiateTransactionsSteps.getOrderId();
    String orderStatus = riskManagementOrderSummarySteps.getOrderStatus();
    UtilFunctions util = new UtilFunctions(driver);

    @When("user navigate to partners shopify page")
    public void user_navigate_to_partners_shopify_page() {
        configFileReader= new ConfigFileReader();
        driver.navigate().to(configFileReader.getShopifyPartnersUrl());
    }
    @When("user login in shopify partners with email and password for store")
    public void user_login_shopify_with_email_password_store() throws InterruptedException {

        shopifyHomePageObject = new ShopifyHomePageObject(driver,configFileReader.getShopifyPartnersUserName(),configFileReader.getShopifyPartnersPassword());
        shopifyHomePageObject.clickOnLogInLink();
        shopifyHomePageObject.setUserEmailAddress();
        shopifyHomePageObject.clickNextButton();
        shopifyHomePageObject.setPassword();
        shopifyHomePageObject.clickAccountsLogInButton();
        this.storeName = configFileReader.getShopifyStoreName();
        shopifyHomePageObject.clickVestaCorporation();
    }

    @And("shopify search and login in store")
    public void shopify_search_and_login_in_store() throws InterruptedException {
        shopifyHomePageObject.loginInToStore(storeName);
        util.switchToChildWindow();
    }

    @And("click on store tab")
    public void click_on_store_tab() throws InterruptedException {

        shopifyHomePageObject.clickStoreOrdersTab();
    }

    @And("search order in shopify with order id")
    public void search_order_in_shopify_with_order_id() throws InterruptedException {
        //shopifyHomePageObject.searchOrder(orderId);
        //orderId = "1025";
        shopifyHomePageObject.searchOrder(orderId);
    }

    @And("Check order payment status")
    public void check_order_payment_status() throws InterruptedException {
         //orderId = "1073";
         String strXpath = "//span[normalize-space()='#"+orderId+"']";
         String strOrderNo = driver.findElement(By.xpath(strXpath)).getText();
         System.out.println("orderId : "+strOrderNo);
         Assert.assertEquals("#"+orderId, strOrderNo);
        Thread.sleep(3000);
         String strPaymentStatus = shopifyHomePageObject.getOrderPaymentStatus();
         //strPaymentStatus = "Complete Paid";
         System.out.println("strPaymentStatus : "+strPaymentStatus);

         if(riskManagementSteps.getAcceptGuaranteedOrdersSetting() && orderStatus.equalsIgnoreCase("Guaranteed")){
                // Assert.assertEquals("Complete Paid", strPaymentStatus.replace("\n", " ").trim());
         }

        if(riskManagementSteps.getDeclineNonGuaranteedOrdersSetting() && orderStatus.equalsIgnoreCase("Noon Guaranteed")){
           // Assert.assertEquals("Complete Voided", strPaymentStatus.replace("\n", " ").trim());
        }

         //Complete Voided
         //Attention Incomplete Authorized
    }


    @And("click order row in shopify for order detail")
    public void click_order_row_in_shopify_for_order_detail() throws InterruptedException {

        shopifyHomePageObject.clickOrderPaymentStatus();

    }

    @And("check vesta payment guarantee full analysis")
    public void check_vesta_payment_guarantee_full_analysis() throws InterruptedException {

        boolean flag = shopifyHomePageObject.checkVestaPaymentGuaranteeTab();
        if(!flag) Assert.fail("Vesta Payment Guarantee Tab Not Found");
        shopifyHomePageObject.clickViewFullAnalysisTab();

        shopifyHomePageObject.clickVestaFullAnalysis();

        String text = shopifyHomePageObject.vestaFullAnalysisSection();
        System.out.println("text: " +text);
        if(text.length() < 10 ) Assert.fail("Vesta Payment Guarantee Indicators Found");

    }


}
