package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ShopifyHomePageObject;
import util.UtilFunctions;

public class InstallAppAfterChangeEmailSteps {

    InstallAppSteps installAppSteps = new InstallAppSteps();
    ShopifyHomePageObject shopifyHomePageObject =installAppSteps.getShopifyHomePageObject();
    WebDriver driver = installAppSteps.getDriver();
    UtilFunctions util = new UtilFunctions(driver);
    String storeName = installAppSteps.getStoreName();

    @When("^user change store general settings (.*)$")
    public void user_change_store_general_settings(String newEmail) throws InterruptedException {
        System.out.println("newEmail: "+newEmail);
        util.switchToChildWindow();
        shopifyHomePageObject.clickStoreSettings();
        shopifyHomePageObject.clickGeneralSettings();
        shopifyHomePageObject.setStoreContactEmail(newEmail);
        util.switchToParentWindow();
    }

}
