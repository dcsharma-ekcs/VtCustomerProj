package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageFactory.OnBoarding_PF;
import util.UtilFunctions;


public class OnBoardingSteps {

    WebDriver driver;
    OnBoarding_PF onBoardingObj;



    @And("user click on describe your business")
    public void user_click_on_describe_your_business() throws InterruptedException {
        System.out.println("=========describe_your_business===========");
        driver = VtLoginSteps_PF.getDriver();
        onBoardingObj = new OnBoarding_PF(driver);


        onBoardingObj.clickDescribeYourBusiness();
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton1();
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton2();
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton2();
        Thread.sleep(1000);
        onBoardingObj.selectVerticals("Marketplace");
        Thread.sleep(1000);
        onBoardingObj.selectSubVerticals("Physical Good");
        Thread.sleep(1000);
        onBoardingObj.clickProceedButton3();
        Thread.sleep(1000);
        onBoardingObj.selectPaymentProcessor("Atome");
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
