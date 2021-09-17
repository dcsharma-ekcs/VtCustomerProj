package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import pageFactory.VtCustomerPage_PF;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class VtLoginSteps_PF {

    static WebDriver driver = null;
    static String browserType;

    VtCustomerPage_PF vtLogin;

    @Given("vt user on login page with browser {string}")
    public void vt_user_on_login_page(String browser) throws InterruptedException {
        System.out.println("=========VtLoginSteps_PF===========");

        browserType = browser;
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }else if(browser.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

        }else if(browser.equalsIgnoreCase("safari")){

            driver = new SafariDriver();

        }else if(browser.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        }else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }

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
