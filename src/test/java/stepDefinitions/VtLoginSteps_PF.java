package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.VtCustomerPage_PF;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class VtLoginSteps_PF {

    static WebDriver driver = null;

    VtCustomerPage_PF vtLogin;

    @Given("vt user on login page")
    public void vt_user_on_login_page() throws InterruptedException {
        System.out.println("=========VtLoginSteps_PF===========");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vt-customer-dev.azurewebsites.net");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        vtLogin = new VtCustomerPage_PF(driver);

    }
    @When("^vt user is enter (.*) and (.*)$")
    public void vt_user_is_enter_user1_and_password1(String username, String password) throws InterruptedException {

       vtLogin.setUser_email_address(username);
       vtLogin.setUserPassword(password);
    }

    @When("click on vt login button")
    public void click_on_vt_login_button() {

        vtLogin.clickNextButton();
    }

    @Then("user is navigated to the vt home page")
    public void user_is_navigated_to_the_vt_home_page() throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Dashboard".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
            System.out.println("Title...: "+driver.getTitle());
        }
    }

    @Then("error message should throw")
    public void error_message_should_throw() throws InterruptedException {
        for (int second = 0;; second++) {
            System.out.println("Title...: "+driver.getTitle());
            if (second >= 60) fail("timeout");
            try { if ("Sign In".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);

        }
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
