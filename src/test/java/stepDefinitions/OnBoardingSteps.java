package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageFactory.AccountManagementPage_PF;
import pageFactory.OnBoardingPage_PF;


public class OnBoardingSteps {

    WebDriver driver;
    OnBoardingPage_PF onBoardingObj;




    @And("user click on describe your business")
    public void user_click_on_describe_your_business() throws InterruptedException {
        System.out.println("=========describe_your_business===========");
        driver = VtLoginSteps_PF.getDriver();
        onBoardingObj = new OnBoardingPage_PF(driver);
        onBoardingObj.clickDescribeYourBusiness();
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton1();
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton2();
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton2();
    }

    @And("^user set verticals (.*) and sub verticals (.*)$")
    public void user_set_verticals_and_sub_verticals(String strVertical, String strSubVertical) throws InterruptedException {
        Thread.sleep(1000);
        onBoardingObj.selectVerticals(strVertical);
        Thread.sleep(1000);
        onBoardingObj.selectSubVerticals(strSubVertical);
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton3();
    }

    @And("^user set payment processor (.*)$")
    public void user_set_payment_processor(String strPaymentProcessor) throws InterruptedException {
        Thread.sleep(1000);
        onBoardingObj.selectPaymentProcessor(strPaymentProcessor);
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton3();
    }

    @And("user go live")
    public void user_go_live() throws InterruptedException {
        System.out.println("=========user_go_live===========");
        Thread.sleep(9000);
        //util.switchToChildWindow();
        onBoardingObj.clickCheckboxProceed();
        Thread.sleep(1000);
        onBoardingObj.clickLetsGoButton();
    }

    @Then("user check progressbar status")
    public void userCheckProgressbarStatus() throws InterruptedException {
        Thread.sleep(3000);
        onBoardingObj.checkProgressbarStatus();
    }




}
