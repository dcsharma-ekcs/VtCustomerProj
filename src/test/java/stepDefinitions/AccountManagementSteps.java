package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.AccountManagementPage_PF;
import pageFactory.OnBoardingPage_PF;
import pageFactory.RiskManagementPage_PF;
import pageFactory.VtCustomerPage_PF;
import util.UtilFunctions;

import java.util.Locale;

public class AccountManagementSteps {

    WebDriver driver;
    AccountManagementPage_PF accountManagementPageObj;
    ConfigFileReader configFileReader;

    @When("user click on account management tab")
    public void userClickOnAccountManagementTab() throws InterruptedException {
        driver = VtLoginSteps_PF.getDriver();
        accountManagementPageObj = new AccountManagementPage_PF(driver);
        Thread.sleep(3000);
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

}
