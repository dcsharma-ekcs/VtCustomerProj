package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageFactory.AccountManagementPage_PF;
import pageFactory.OnBoardingPage_PF;
import pageFactory.RiskManagementPage_PF;
import pageFactory.VtCustomerPage_PF;
import util.UtilFunctions;

import java.util.Locale;
import java.util.Random;

import static junit.framework.TestCase.fail;

public class AccountManagementSteps {

    WebDriver driver;
    AccountManagementPage_PF accountManagementPageObj;
    ConfigFileReader configFileReader;

    @When("user click on account management tab")
    public void userClickOnAccountManagementTab() throws InterruptedException {
        driver = VtLoginSteps_PF.getDriver();
        accountManagementPageObj = new AccountManagementPage_PF(driver);
        Thread.sleep(6000);
        accountManagementPageObj.clickOnAccountManagementTab();
    }

    @And("^user search merchant (.*) by search field$")
    public void user_search_merchant_by_search_field(String merchantName) throws InterruptedException {
        accountManagementPageObj.setSearchText(merchantName);

    }

    @And("^user get and check merchant tage status (.*)$")
    public void user_get_and_check_merchant_tage_status(String strStatus) throws InterruptedException {
        Thread.sleep(3000);
        String tageStatus = accountManagementPageObj.getStageStatus();
        Assert.assertEquals(strStatus.toLowerCase(Locale.ROOT), tageStatus);
    }

    @And("user click merchant detail button")
    public void user_click_merchant_detail_button() throws InterruptedException {
        accountManagementPageObj.clickArrowButton();
    }

    @And("^user check merchant vertical (.*)$")
    public void user_check_merchant_vertical(String strInput) throws InterruptedException {
        Thread.sleep(3000);
        String srtVertical = accountManagementPageObj.getMerchantVertical();
        System.out.println("srtVertical:"+ srtVertical);
        Assert.assertEquals(strInput.toLowerCase(Locale.ROOT), srtVertical);
    }

    @And("^user check merchant sub vertical (.*)$")
    public void user_check_merchant_sub_vertical(String strInput) throws InterruptedException {
        String strSubVertical = accountManagementPageObj.getMerchantSubVertical();
        System.out.println("strSubVertical:"+ strSubVertical);
        Assert.assertEquals(strInput.toLowerCase(Locale.ROOT), strSubVertical);
    }

    @And("^user check payment processor (.*)$")
    public void user_check_payment_processor(String strInput) throws InterruptedException {
        String strPaymentProcessor = accountManagementPageObj.getPaymentProcessor();
        System.out.println("strPaymentProcessor:"+ strPaymentProcessor);
        Assert.assertEquals(strInput.toLowerCase(Locale.ROOT), strPaymentProcessor);
    }

    @And("user click billing tab")
    public void user_click_billing_tab() throws InterruptedException {

        accountManagementPageObj.clickTabBilling();
    }

    @And("user click product tab")
    public void user_click_product_tab() throws InterruptedException {

        accountManagementPageObj.clickTabProduct();
    }

    @And("^user check merchant invoice currency (.*)$")
    public void user_check_merchant_invoice_currency(String strInput) throws InterruptedException {
        String strInvoiceCurrency = accountManagementPageObj.getInvoiceCurrency();
        System.out.println("strSubVertical:"+ strInvoiceCurrency);
        Assert.assertEquals(strInput.toLowerCase(Locale.ROOT), strInvoiceCurrency);
    }

    @And("user check merchant billing address")
    public void user_check_merchant_billing_address() throws InterruptedException {
        String strBillingAddress = accountManagementPageObj.getBillingAddress();
        System.out.println("strBillingAddress:"+ strBillingAddress);
    }

    @And("user check billing end on date")
    public void user_check_billing_end_on_date() throws InterruptedException {
        String strEndOnDate  = accountManagementPageObj.getEndsOnDate();
        System.out.println("strEndOnDate:"+ strEndOnDate);
    }

    @And("user check merchant product details")
    public void user_check_merchant_product_details() throws InterruptedException {
        String strProductName  = accountManagementPageObj.getMerchantProductName();
        System.out.println("strProductName:"+ strProductName);

        String strProductAmount  = accountManagementPageObj.getMerchantProductAmount();
        System.out.println("strProductAmount:"+ strProductAmount);
    }

    @And("user click on users tab")
    public void userClickOnUsersTab() throws InterruptedException {
        Thread.sleep(2000);
        accountManagementPageObj.clickOnUsersTab();
    }

    //user click on add new user button
    @And("user click on add new user button")
    public void userClickAddNewUserButton() throws InterruptedException {
        Thread.sleep(2000);
        accountManagementPageObj.clickAddNewUserButton();
        Thread.sleep(1000);

        accountManagementPageObj.fillCreateNewUserForm();
    }


}
