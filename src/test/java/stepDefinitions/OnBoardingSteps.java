package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageFactory.OnBoarding_PF;


public class OnBoardingSteps {

    WebDriver driver;


    @And("user click on describe your business")
    public void user_click_on_describe_your_business() throws InterruptedException {
        System.out.println("=========OnBoardingSteps===========");
        driver = VtLoginSteps_PF.getDriver();
        OnBoarding_PF onBoardingObj = new OnBoarding_PF(driver);

        onBoardingObj.clickDescribeYourBusiness();

    }



}
