package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VtCustomerPage_PF {

    @FindBy(id="emailFront")
    WebElement user_email_address;

    @FindBy(id="passwordFront")
    WebElement user_password;

    @FindBy(id="next")
    WebElement login_button;

    @FindBy(id="passwordHint")
     WebElement password_hint;


    WebDriver driver;
    WebDriverWait wait;


    public VtCustomerPage_PF(WebDriver driver){
        this.driver = driver;

        // For Ajax related pages.
        //AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        //PageFactory.initElements(factory, this);

        PageFactory.initElements(driver, this);
        wait  = new WebDriverWait(driver, 30);
    }



    public void setUser_email_address(String userEmail){
        wait.until(ExpectedConditions.elementToBeClickable(user_email_address));
        user_email_address.click();
        user_email_address.clear();
        user_email_address.sendKeys(userEmail);
    }

    public void setUserPassword(String userPassword){
        wait.until(ExpectedConditions.elementToBeClickable(user_password));
        user_password.click();
        user_password.clear();
        user_password.sendKeys(userPassword);
    }

    public void clickNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(login_button));
        login_button.click();
    }

    public String getPasswordHint(){
        return  password_hint.getText();
    }
}
