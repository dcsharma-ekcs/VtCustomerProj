package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ShopifyHomePageObject;
import util.UtilFunctions;

public class UnInstallAppSteps {

    InstallAppSteps installAppSteps = new InstallAppSteps();
    ShopifyHomePageObject shopifyHomePageObject =installAppSteps.getShopifyHomePageObject();
    WebDriver driver = installAppSteps.getDriver();
    UtilFunctions util = new UtilFunctions(driver);
    String appName = installAppSteps.getAppName();
    String storeName = installAppSteps.getStoreName();


    @When("click on stores and search and login in store")
    public void click_on_stores_and_search_and_login_in_store() throws InterruptedException {
        shopifyHomePageObject.loginInToStore(storeName);
    }

    @When("click on apps")
    public void click_on_apps() throws InterruptedException {
        util.switchToChildWindow();
        shopifyHomePageObject.clickAppLink();
    }
    @When("user find and delete app")
    public void user_find_app_click_delete_app() throws InterruptedException {
        shopifyHomePageObject.deleteAppFromStore(appName);
    }
    @Then("user give feedback and click delete")
    public void user_give_feedback_and_click_delete() {
        shopifyHomePageObject.findAndCompareMessage("You successfully deleted "+ appName+".");
    }
}
