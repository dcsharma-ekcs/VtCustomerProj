package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import pageFactory.VtCustomerPage_PF;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class VtLoginSteps_PF {

    static WebDriver driver = null;
    ConfigFileReader configFileReader;
    static String browser;
    VtCustomerPage_PF vtLogin;

    @Given("vt user is on customer portal login page")
    public void vt_user_on_login_page() throws InterruptedException {
        System.out.println("..........VtLoginSteps..........");
        configFileReader= new ConfigFileReader();
        browser = configFileReader.getBrowserName();

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

        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        vtLogin = new VtCustomerPage_PF(driver);

    }
    @When("vt user is enter username and password")
    public void vt_user_is_enter_user_and_password() {

       vtLogin.setUserEmailAddress(configFileReader.getUserName());
       vtLogin.setUserPassword(configFileReader.getUserPassword());
    }

    @When("^vt user is enter username (.*) and password (.*)$")
    public void vt_user_is_enter_user_and_password(String userName, String password) {

        vtLogin.setUserEmailAddress(userName);
        vtLogin.setUserPassword(password);
    }

    @When("vt user is enter username and wrong password")
    public void vt_user_is_enter_user_and_wrong_password() {
        vtLogin.setUserEmailAddress(configFileReader.getUserName());
        vtLogin.setUserPassword(configFileReader.getUserWrongPassword());
    }

    @When("click on vt login button")
    public void click_on_vt_login_button() {
        vtLogin.clickNextButton();
    }

    @Then("user is navigated to the vt home page")
    public void user_is_navigated_to_the_vt_home_page() throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            try { if ("Dashboard".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
            System.out.println("Title...: "+driver.getTitle());
        }
    }

    @Then("error message {string} should throw")
    public void error_message_should_throw(String msg) throws InterruptedException {
        Thread.sleep(3000);
        String errorMsg =  vtLogin.getPasswordHint();
        System.out.println("errorMsg: "+errorMsg) ;

        if(msg.contains(errorMsg)){
            System.out.println("Test Pass");
        }else{
            Assert.fail("Test fail");
        }
        //Assert.assertEquals(msg.toLowerCase(Locale.ROOT), errorMsg.toLowerCase(Locale.ROOT));

    }

    public static WebDriver getDriver() {
        return driver;
    }


}
