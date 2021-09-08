package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilFunctions;


public class PositiveNegativeListPage_PF {

    UtilFunctions util;
    WebDriver driver;

    String srtRiskManagement = "//li[normalize-space()='Risk Management']";
    @FindBy(xpath = "//li[normalize-space()='Risk Management']")
    WebElement risk_management_tab;

    String srtConfigurations = "//div[contains(text(),'Configurations')]";
    @FindBy(xpath = "//div[contains(text(),'Configurations')]")
    WebElement configuration_button;

    String srtPositive = "//li[normalize-space()='Positive Negative']";
    @FindBy(xpath = "//li[normalize-space()='Positive Negative']")
    WebElement positive_negative_button;

    String srtNegativeList = "//span[normalize-space()='Negative']";
    @FindBy(xpath = "//span[normalize-space()='Negative']")
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
        // For Ajax related pages.
        //AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        //PageFactory.initElements(factory, this);

        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
    }

    public void clickOnSearchInput(String strText) throws InterruptedException {
        Actions act =  new Actions(driver);
        Thread.sleep(3000);
        act.moveToElement(form_search_input).click().perform();
        form_search_input.sendKeys(strText);
        //form_search_input.click();
        //form_search_input.clear();
        //form_search_input.sendKeys(strText);
    }

    public void clickOnCreateButton() throws InterruptedException {
        util.waitForXpathElement(strCreateButtonXpath);
        form_create_button.click();
    }

    public void setData_Add_New_Entry_Form(String strKeys, String strKeyValue, String strCustomer, String strExpireDate, String strNotes) throws InterruptedException {
        System.out.println("setData_Add_New_Entry_Form is : ");

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
        // select wanted KPT //p[normalize-space()='regress-01-01']
        //p[normalize-space()='All Customers']
        //p[normalize-space()='DC-Test-04-09-01']
        driver.findElement(By.xpath("//p[normalize-space()='DC-Test-04-09-01']")).click();
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
        Thread.sleep(3000);
        System.out.println("srtNegativeList:   "+srtNegativeList);
        util.waitForXpathElement(srtNegativeList);
        System.out.println(" ------------   ");
        negative_list_button.click();
    }


    public void clickOnRiskManagementTab() throws InterruptedException {
        util.waitForXpathElement(srtRiskManagement);
        risk_management_tab.click();
    }

    public void clickOnConfigurationsButton() throws InterruptedException {
        util.waitForXpathElement(srtConfigurations);
        configuration_button.click();
    }

    public void clickOnPositiveNegativeButton() throws InterruptedException {
        util.waitForXpathElement(srtPositive);
        positive_negative_button.click();
    }

    public void clickOnAddPositiveEntry() throws InterruptedException {
        util.waitForXpathElement(srtAddPositiveEntry);
        add_positive_entry_button.click();
    }

    public void clickOnAddNegativeEntry() throws InterruptedException {
        Actions act =  new Actions(driver);
        Thread.sleep(3000);
        act.moveToElement(add_negative_entry_button).click().perform();
//        util.waitForXpathElement(srtAddNegativeEntry);
//        add_negative_entry_button.click();
    }

    public void clickStickyArrow() throws InterruptedException {
        util.clickStickyArrow();
    }

}
