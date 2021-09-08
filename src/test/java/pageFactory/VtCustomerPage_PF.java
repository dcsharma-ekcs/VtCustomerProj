package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtCustomerPage_PF {

    @FindBy(id="emailFront")
    WebElement user_email_address;

    @FindBy(id="passwordFront")
    WebElement user_password;

    @FindBy(id="next")
    WebElement login_button;

    WebDriver drive;

    public VtCustomerPage_PF(WebDriver driver){
        this.drive = driver;

        // For Ajax related pages.
        //AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        //PageFactory.initElements(factory, this);

        PageFactory.initElements(driver, this);
    }

    public void setUser_email_address(String userEmail){
        user_email_address.click();
        user_email_address.clear();
        user_email_address.sendKeys(userEmail);
    }

    public void setUserPassword(String userPassword){
        user_password.click();
        user_password.clear();
        user_password.sendKeys(userPassword);
    }

    public void clickNextButton(){
        login_button.click();
    }
}
