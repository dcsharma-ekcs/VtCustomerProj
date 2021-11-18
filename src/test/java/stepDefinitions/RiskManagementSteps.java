package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageFactory.RiskManagementPage_PF;
import pageFactory.VtCustomerPage_PF;
import util.UtilFunctions;

public class RiskManagementSteps {


    static boolean acceptGuaranteedOrders;
    static boolean declineNonGuaranteedOrders;
    ConfigFileReader configFileReader;

    InitiateTransactionsSteps initiateTransactionsSteps = new InitiateTransactionsSteps();
    WebDriver driver = initiateTransactionsSteps.getDriver();
    String orderId = initiateTransactionsSteps.getOrderId();
    UtilFunctions util = new UtilFunctions(driver);
    RiskManagementPage_PF riskManagementPagePF = new RiskManagementPage_PF(driver);
    VtCustomerPage_PF vtCustomerPagePF = new VtCustomerPage_PF(driver);


    @And("user login to vt customer portal url username and password")
    public void user_login_to_vt_customer_portal() {
        configFileReader= new ConfigFileReader();
        driver.navigate().to(configFileReader.getApplicationUrl());
        vtCustomerPagePF.setUserEmailAddress(configFileReader.getUserName());
        vtCustomerPagePF.setUserPassword(configFileReader.getUserPassword());
        vtCustomerPagePF.clickNextButton();

    }
    @And("navigate to risk management list page")
    public void navigate_to_risk_management_list_page() throws InterruptedException {
            riskManagementPagePF.checkProgressbarStatus();
            Thread.sleep(5000);
            riskManagementPagePF.checkProgressbarStatus();
            riskManagementPagePF.clickOnRiskManagementTab();

    }
    @And("search order with order id")
    public void search_order_with_order_id() throws InterruptedException {
            //orderId = "1025";
            riskManagementPagePF.setSearchText(orderId);
            System.out.println("risk ManagementSteps OrderId:  "+orderId);

    }
    @And("click for transaction summary")
    public void click_for_transaction_summary() throws InterruptedException {
        //td[normalize-space()='1020']
        //orderId = "1025";
        String strXpath = "//td[normalize-space()='"+orderId+"']";
        System.out.println("strXpath:  "+strXpath);
        Thread.sleep(2000);
        util.waitAndClickXpath5sec(strXpath);
       // util.clickStickyArrow();
    }


    @And("click decisions tab")
    public void click_decisions_tab() throws InterruptedException {
        Thread.sleep(2000);
        riskManagementPagePF.clickOnDecisionsTab();


    }

    @And("search store for get decisions settings")
    public void search_store_for_get_decisions_settings() throws InterruptedException {
        Thread.sleep(2000);

          riskManagementPagePF.setSrtSearchDecisions(configFileReader.getShopifyStoreName());

          acceptGuaranteedOrders = riskManagementPagePF.getAcceptDecisions();
          declineNonGuaranteedOrders = riskManagementPagePF.getNoonAcceptDecisions();

        System.out.println("Accept Decisions Settings:"+riskManagementPagePF.getAcceptDecisions());
        System.out.println("Decline Decisions Settings:"+riskManagementPagePF.getNoonAcceptDecisions());

    }


    @Then("user logout")
    public void user_logout() {

    }

    public static boolean getAcceptGuaranteedOrdersSetting() {
        return acceptGuaranteedOrders;
    }

    public static boolean getDeclineNonGuaranteedOrdersSetting() {
        return declineNonGuaranteedOrders;
    }

}
