package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnBoarding_PF {

    @FindBy(xpath="//div[@class='common-layout-content-div']//div//div[3]//div[1]//div[2]//h5[1]")
    WebElement describe_your_business;



    WebDriver drive;

    public OnBoarding_PF(WebDriver driver){
        this.drive = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDescribeYourBusiness(){
        describe_your_business.click();
    }


}
