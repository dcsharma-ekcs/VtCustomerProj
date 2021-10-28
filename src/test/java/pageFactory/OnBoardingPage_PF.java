package pageFactory;

import dataProviders.ConfigFileReader;
import org.apache.xpath.functions.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import util.UtilFunctions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OnBoardingPage_PF {

    private static final TimeUnit SECONDS = null;
    @FindBy(xpath="//div[@class='common-layout-content-div']//div//div[3]//div[1]//div[2]//h5[1]")
    WebElement describe_your_business;

    @FindBy(xpath="//body/div[@role='dialog']/div/div/div/div/div/div/button[1]")
    WebElement proceed_button1;

    @FindBy(xpath="//button[2]")
    WebElement proceed_button2;

    @FindBy(xpath="//body/div[contains(@role,'dialog')]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement select_verticals;

    @FindBy(xpath="//div[2]//div[1]//div[1]//div[1]//input[1]")
    WebElement select_sub_verticals;

    @FindBy(xpath="//input[@type='text']")
    WebElement select_payment_processor;

    @FindBy(xpath="//body/div[@role='dialog']/div/div/div/div/div/div/button[2]")
    WebElement proceed_button3;

    @FindBy(xpath="//input[@type='checkbox']")
    WebElement checkbox_terms;

    @FindBy(xpath=" //button[contains(text(),'LET’S GO!')]")
    WebElement lets_go_button;

    String strProgressbar = "//div[@role='progressbar']//*[name()='svg']";
    @FindBy(css="//div[@role='progressbar']//*[name()='svg']")
    WebElement progressbar;





    WebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    UtilFunctions util;
    ConfigFileReader configFileReader;

    
    public OnBoardingPage_PF(WebDriver driver){
        this.driver = driver;
        configFileReader= new ConfigFileReader();
        PageFactory.initElements(driver, this);
        wait  = new WebDriverWait(driver, configFileReader.getFluentWait());
        util = new UtilFunctions(driver);

        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    public void clickDescribeYourBusiness(){
        wait.until(ExpectedConditions.elementToBeClickable(describe_your_business));
        describe_your_business.click();
    }

    public void clickProceedButton1(){
        wait.until(ExpectedConditions.elementToBeClickable(proceed_button1));
        proceed_button1.click();
    }

    public void clickProceedButton2() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(proceed_button2));
        Thread.sleep(1000);
        proceed_button2.click();
    }

    public void clickProceedButton3(){
        wait.until(ExpectedConditions.elementToBeClickable(proceed_button3));
        proceed_button3.click();
    }

    public void selectVerticals(String strVertical) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(select_verticals));
        select_verticals.click();
        select_verticals.clear();
        Thread.sleep(3000);
        //select_verticals.sendKeys(strVertical);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
    }

    public void selectSubVerticals(String strSubVertical) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(select_sub_verticals));
        select_sub_verticals.click();
        select_sub_verticals.clear();
        Thread.sleep(3000);
        //select_sub_verticals.sendKeys(strSubVertical);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
    }

    public void selectPaymentProcessor(String strPaymentProcessor) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(select_payment_processor));
         select_payment_processor.click();
         Actions action = new Actions(driver);
         action.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
    }

    public void clickCheckboxProceed() throws InterruptedException {
        driver.switchTo().activeElement();
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", checkbox_terms);
        Thread.sleep(3000);
        boolean t = checkbox_terms.isSelected();
        if (t) {
            System.out.println("Checkbox is checked");
        }else {
            System.out.println("Checkbox is not checked");
            j.executeScript("arguments[0].click();", checkbox_terms);
        }
    }

    public void clickLetsGoButton() throws InterruptedException {
        System.out.println("lets_go_button........");
        fluentWait.until(ExpectedConditions.elementToBeClickable(lets_go_button));
        lets_go_button.click();
    }

    public void checkProgressbarStatus() throws InterruptedException {
        System.out.println("....checkProgressbarStatus........");
        util.checkProgressbar(strProgressbar);
    }




}
