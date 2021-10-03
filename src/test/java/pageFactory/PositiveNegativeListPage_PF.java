package pageFactory;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.UtilFunctions;

import java.nio.channels.spi.AbstractSelector;
import java.util.Iterator;
import java.util.Set;


public class PositiveNegativeListPage_PF {

    UtilFunctions util;
    WebDriver driver;
    WebDriverWait wait;

    String srtRiskManagement = "//li[normalize-space()='Risk Management']";
    @FindBy(xpath = "//li[normalize-space()='Risk Management']")
    WebElement risk_management_tab;

    String srtConfigurations = "//div[contains(text(),'Configurations')]";
    @FindBy(xpath = "//div[contains(text(),'Configurations')]")
    WebElement configuration_button;

    String srtPositive = "//li[normalize-space()='Positive Negative']";
    @FindBy(xpath = "//li[normalize-space()='Positive Negative']")
    WebElement positive_negative_button;

    String srtNegativeList = "//button[@value='Negative']//span[1]";
    @FindBy(xpath = "//button[@value='Negative']//span[1]")
    WebElement negative_list_button;

    String srtAddPositiveEntry = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]";
    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]")
    WebElement add_positive_entry_button;

    String srtAddNegativeEntry = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]";
    @FindBy(xpath = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]")
    WebElement add_negative_entry_button;

    //String strKeysXpath = "//input[@name='Search']";
    @FindBy(xpath = "//input[@name='Search']")
    WebElement form_keys;

    //String strValueXpath = "//input[@placeholder='Enter']";
    @FindBy(xpath = "//input[@placeholder='Enter']")
    WebElement form_key_value;

    String strCustomerXpath = "//textarea[@name='Customer']";
    @FindBy(xpath = "//textarea[@name='Customer']")
    WebElement form_customer;

    String strExpireDateXpath = "//input[@placeholder='Choose']";
    @FindBy(xpath = "//input[@placeholder='Choose']")
    WebElement form_expire_date;

    @FindBy(name = "Notes")
    WebElement form_notes;

    String strCreateButtonXpath = "//span[normalize-space()='CREATE']";
    @FindBy(xpath = " //span[normalize-space()='CREATE']")
    WebElement form_create_button;


    String strsearchInputXpath = "//input[@id='searchInput']";
    @FindBy(xpath = " //input[@id='searchInput']")
    WebElement form_search_input;

    public PositiveNegativeListPage_PF(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
        wait  = new WebDriverWait(driver, 1);
    }

    public void clickOnSearchInput(String strText) throws InterruptedException {
        Actions act =  new Actions(driver);
        Thread.sleep(3000);
        act.moveToElement(form_search_input).click().perform();
        form_search_input.sendKeys(strText);
    }

    public void clickOnCreateButton() throws InterruptedException {
        util.waitForXpathElement(strCreateButtonXpath);
        wait.until(ExpectedConditions.elementToBeClickable(form_create_button));
        form_create_button.click();
    }

    public void setData_Add_New_Entry_Form(String strKeys, String strKeyValue, String strCustomer, String strExpireDate, String strNotes) throws InterruptedException {
        form_keys.click();
        form_keys.clear();
        form_keys.sendKeys(strKeys);
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        form_key_value.click();
        form_key_value.clear();
        form_key_value.sendKeys(strKeyValue);

        driver.findElement(By.xpath(strCustomerXpath)).click();
        Thread.sleep(1000);
         driver.findElement(By.xpath("//p[normalize-space()='"+strCustomer+"']")).click();
        util.clickOutside();

        form_expire_date.click();
        form_expire_date.clear();
        form_expire_date.sendKeys(strExpireDate);

        form_notes.click();
        form_notes.clear();
        form_notes.sendKeys(strNotes);
        action.moveToElement(form_create_button);

    }


    public void clickOnNegativeList() throws InterruptedException {
         System.out.println("srtNegativeList:   "+srtNegativeList);
         util.waitForXpathElement(srtNegativeList);
         Thread.sleep(10000);
         WebDriverWait wait;
         wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(srtNegativeList)));
         negative_list_button.click();


    }


    public void clickOnRiskManagementTab() throws InterruptedException {
        util.waitForXpathElement(srtRiskManagement);
        wait.until(ExpectedConditions.elementToBeClickable(risk_management_tab));
        risk_management_tab.click();
    }

    public void clickOnConfigurationsButton() throws InterruptedException {
        util.waitForXpathElement(srtConfigurations);
        wait.until(ExpectedConditions.elementToBeClickable(configuration_button));
        configuration_button.click();
    }

    public void clickOnPositiveNegativeButton() throws InterruptedException {
        util.waitForXpathElement(srtPositive);
        wait.until(ExpectedConditions.elementToBeClickable(positive_negative_button));
        positive_negative_button.click();
    }

    public void clickOnAddPositiveEntry() throws InterruptedException {
        System.out.println("....clickOnAddPositiveEntry....");
        wait.until(ExpectedConditions.elementToBeClickable(add_positive_entry_button));
        Thread.sleep(5000);
        add_positive_entry_button.click();

    }

    public void clickOnAddNegativeEntry() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(add_negative_entry_button));
        Thread.sleep(5000);
        add_negative_entry_button.click();

    }

    public void clickStickyArrow() throws InterruptedException {
        util.clickStickyArrow();
    }

}
