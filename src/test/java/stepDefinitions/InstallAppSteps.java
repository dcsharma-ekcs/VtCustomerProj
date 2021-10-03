package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopifyHomePageObject;

import java.util.concurrent.TimeUnit;


public class InstallAppSteps {

    static WebDriver driver = null;
    static ShopifyHomePageObject shopifyHomePageObject;
    static String appName;
    static String storeName;
    ConfigFileReader configFileReader;


    @Given("user on login partners shopify page")
    public void user_on_login_partners_shopify_page() {
        System.out.println("Open Shopify Page");
        configFileReader= new ConfigFileReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(configFileReader.getShopifyPartnersUrl());
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    @When("^user is enter (.*) and (.*) and (.*) and (.*)$")
    public void user_is_enter_login_detail(String email, String password, String storeName, String appName) throws InterruptedException {

        shopifyHomePageObject = new ShopifyHomePageObject(driver,configFileReader.getShopifyPartnersUserName(),configFileReader.getShopifyPartnersPassword());

        shopifyHomePageObject.clickOnLogInLink();
        shopifyHomePageObject.setUserEmailAddress();
        shopifyHomePageObject.clickNextButton();
        shopifyHomePageObject.setPassword();
        shopifyHomePageObject.clickAccountsLogInButton();
        System.out.println("storeName: "+configFileReader.getShopifyStoreName());
        System.out.println("appName: "+configFileReader.getVestaShopifyPluginApp());
        this.storeName = configFileReader.getShopifyStoreName();
        this.appName = configFileReader.getVestaShopifyPluginApp();

    }



    @When("user navigated to dashboard")
    public void user_navigated_to_dashboard() throws InterruptedException {
        shopifyHomePageObject.clickVestaCorporation();

    }
    @And("login in to store")
    public void login_in_to_store() throws InterruptedException {
        System.out.println("storeName:2: "+storeName);
        shopifyHomePageObject.loginInToStore(storeName);
        shopifyHomePageObject.goBackOnDefaultWindow();
    }

    @When("click on apps and search app")
    public void click_on_apps_and_search_app() throws InterruptedException {
        System.out.println("clickAppLink:....");
        shopifyHomePageObject.clickAppLink();

    }
    @When("user find app and click")
    public void user_find_app_and_click() throws InterruptedException {
        System.out.println("search app:....");
        shopifyHomePageObject.setSearch_text_field1(appName);
        shopifyHomePageObject.clickSearchButton();
        shopifyHomePageObject.clickSearchRow();
    }
    @When("user on apps detail page click select store button")
    public void user_on_apps_detail_page_click_select_store_button() throws InterruptedException {

        shopifyHomePageObject.clickSelectStore();
    }
    @When("user on search store page")
    public void user_on_search_store_page() throws InterruptedException {
        shopifyHomePageObject.setSearch_text_field2(storeName);

    }
    @When("search store and click on link install")
    public void search_store_and_click_on_link_install() throws InterruptedException {
        shopifyHomePageObject.clickSearchStoreRow();

    }
    @When("user on app detail page")
    public void user_on_app_detail_page() {

    }
    @When("click install unlisted app")
    public void click_install_unlisted_app() throws InterruptedException {
        Thread.sleep(2000);
       shopifyHomePageObject.clickInstallAppAnywayButton();
       Thread.sleep(2000);
       shopifyHomePageObject.clickInstallAppButton();
       Thread.sleep(3000);

    }
    @Then("user is navigated to b2c login page")
    public void user_is_navigated_to_b2c_login_page() {

    }

    public static WebDriver getDriver() {
        return driver;
    }
    public static String getStoreName() {
        return storeName;
    }
    public static String getAppName() {
        return appName;
    }
    public static ShopifyHomePageObject getShopifyHomePageObject() {
        return shopifyHomePageObject;
    }

}
