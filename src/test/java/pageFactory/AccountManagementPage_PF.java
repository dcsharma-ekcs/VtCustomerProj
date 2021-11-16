package pageFactory;

import dataProviders.ConfigFileReader;
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

import java.util.Locale;
import java.util.Random;

public class AccountManagementPage_PF {

    UtilFunctions util;
    WebDriver driver;
    WebDriverWait wait;
    ConfigFileReader configFileReader;

    public AccountManagementPage_PF(WebDriver driver) {
        this.driver = driver;
        configFileReader= new ConfigFileReader();
        PageFactory.initElements(driver, this);
        util = new UtilFunctions(driver);
        wait  = new WebDriverWait(driver, configFileReader.getFluentWait());
    }

    String srtAccountManagement = "//div[@id='__next']//div//header//div//div//img[@id='Account ManagementId']";
    @FindBy(xpath = "//div[@id='__next']//div//header//div//div//img[@id='Account ManagementId']")
    WebElement account_management_tab;
    public void clickOnAccountManagementTab() throws InterruptedException {
        util.waitForXpathElement(srtAccountManagement);
        WebElement tmp = wait.until(ExpectedConditions.elementToBeClickable(account_management_tab));
        Thread.sleep(5000);
        account_management_tab.click();

    }

    @FindBy(xpath = "//li[normalize-space()='Users']//img[@class='img-fluid']")
    WebElement users_tab;
    public void clickOnUsersTab() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(users_tab));
        //Thread.sleep(5000);
        util.checkProgressbar(retrieving_information_popup);
        users_tab.click();

    }

    @FindBy(xpath = "//div[@id='customUserDiv']//div//div//div//div//div//button[@type='button']")
    WebElement add_new_user;
    public void clickAddNewUserButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(add_new_user));
        //util.clickStickyArrow();
        util.checkProgressbar(retrieving_information_popup);
        add_new_user.click();
    }

    @FindBy(xpath = "//div[@class='col-4 col']//input[@name='Name']")
    WebElement user_name;

    @FindBy(xpath = "//div[@class='col-4 col']//input[@name='Email Id']")
    WebElement user_email_id;

    @FindBy(xpath = "//div[@class='col-4 col']//input[@value='+1']")
    WebElement user_phone;

    @FindBy(xpath = "//div[@id='__next']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//button")
    WebElement user_role;

    @FindBy(xpath = "//button[contains(text(),'CREATE')]")
    WebElement create_button;

    String retrieving_information_popup = "//div[@role='dialog']//div//div//div//label//p";
    String adminStrId = "//body/div[@id='__next']/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/p[1]/span[1]";
    String fraudOpsStrId = "//body//div[@id='__next']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div[2]//p[1]//span[1]";
    String defaultStrId = "//body//div[@id='__next']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div[3]//p[1]//span[1]";
    String reviewerStrId = "//body//div[@id='__next']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div[3]//p[1]//span[1]";

    public void fillCreateNewUserForm(String srtRole) throws InterruptedException {
        Random rand = new Random();
        int randNumber = rand.nextInt(10000);
        String roleXPath = adminStrId;
        user_name.click();
        user_name.clear();
        user_name.sendKeys("Test User "+randNumber);
        user_email_id.click();
        user_email_id.clear();
        user_email_id.sendKeys(randNumber+"testuser@gmail.com");
        user_phone.click();
        user_phone.clear();
        user_phone.sendKeys(randNumber+""+randNumber);
        user_role.click();
        Thread.sleep(1000);
        // Actions action = new Actions(driver);
        // action.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        System.out.println("srtRole: "+srtRole);

        if(srtRole.equalsIgnoreCase("Admin")) roleXPath = adminStrId;
        if(srtRole.equalsIgnoreCase("Fraud Ops")) roleXPath = fraudOpsStrId;
        if(srtRole.equalsIgnoreCase("Default")) roleXPath = defaultStrId;
        if(srtRole.equalsIgnoreCase("Reviewer")) roleXPath = reviewerStrId;

        System.out.println("roleXPath: "+roleXPath);

        driver.findElement(By.xpath(roleXPath)).click();

        Thread.sleep(3000);
        create_button.click();
        Thread.sleep(3000);
    }

    String strSearchField = "//input[@id='searchInput']";
    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement search_input_field;
    public  void  setSearchText(String searchText) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strSearchField)));
        wait.until(ExpectedConditions.elementToBeClickable(search_input_field));
        util.checkProgressbar(retrieving_information_popup);
        //Thread.sleep(6000);

        search_input_field.click();
        search_input_field.clear();
        search_input_field.sendKeys(searchText);
    }

    @FindBy(xpath = "//tbody//tr//td[2]")
    WebElement stage_status;
    public  String  getStageStatus() throws InterruptedException {
        Thread.sleep(3000);
        return  stage_status.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[8]/span[1]//*[name()='svg']")
    WebElement arrow_button;
    public  void  clickArrowButton() throws InterruptedException {
        arrow_button.click();
    }

    @FindBy(xpath = "//body//div[@id='__next']//div[@id='tab-Configure']//div//div//div[1]//div[2]//div[1]//div[1]//div[1]//button[1]")
    WebElement merchant_vertical;
    public  String  getMerchantVertical() throws InterruptedException {
        return  merchant_vertical.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//body//div[@id='__next']//div[@id='tab-Configure']//div//div//div//div[2]//div[2]//div[1]//div[1]//div[1]//button[1]")
    WebElement merchant_sub_vertical;
    public  String  getMerchantSubVertical() throws InterruptedException {
        return  merchant_sub_vertical.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    WebElement payment_processor;
    public  String  getPaymentProcessor() throws InterruptedException {
        return  payment_processor.getAttribute("value").trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/button[1]")
    WebElement invoice_currency;
    public  String  getInvoiceCurrency() throws InterruptedException {
        return  invoice_currency.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]")
    WebElement billing_address;
    public  String  getBillingAddress() throws InterruptedException {
        return  billing_address.getAttribute("value").trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement ends_on_date;
    public  String  getEndsOnDate() throws InterruptedException {
        return  ends_on_date.getAttribute("value").trim().toLowerCase(Locale.ROOT);
    }


    @FindBy(xpath = "//div[@id='tab-Product']//div//div//div//h4")
    WebElement merchantProductName;
    public  String  getMerchantProductName() throws InterruptedException {
        return  merchantProductName.getText().trim().toLowerCase(Locale.ROOT);
    }

    @FindBy(xpath = "//div[@id='tab-Product']//div//div//h3")
    WebElement merchantProductAmount;
    public  String  getMerchantProductAmount() throws InterruptedException {
        return  merchantProductAmount.getText().trim().toLowerCase(Locale.ROOT);
    }

    String strTabConfigure = "//li[@data-tab='Configure']";
    @FindBy(xpath="//li[@data-tab='Configure']")
    WebElement tabConfigure;

    String strTabBilling = "//li[@data-tab='Billing']";
    @FindBy(xpath="//li[@data-tab='Billing']")
    WebElement tabBilling;

    String strTabProduct = "//li[@data-tab='Product']";
    @FindBy(xpath="//li[@data-tab='Product']")
    WebElement tabProduct;

    public void clickTabConfigure(){
        wait.until(ExpectedConditions.elementToBeClickable(tabConfigure));
        tabConfigure.click();
    }

    public void clickTabBilling(){
        wait.until(ExpectedConditions.elementToBeClickable(tabBilling));
        tabBilling.click();
    }

    public void clickTabProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(tabProduct));
        tabProduct.click();
    }

    //////////

    String strHeaderTop = "//div[@class='header-top-nav']";
    @FindBy(xpath="//div[@class='header-top-nav']")
    WebElement headerTop;
    public  String  geHeaderTopNav() throws InterruptedException {
        return  headerTop.getText().trim().toLowerCase(Locale.ROOT);
    }

    String strTableHeaderRow = "//div[@class='table-header-row']//ul";
    @FindBy(xpath="//div[@class='table-header-row']//ul")
    WebElement tableHeaderRow;
    public  String  getTableHeaderRow() throws InterruptedException {
        return  tableHeaderRow.getText().trim().toLowerCase(Locale.ROOT);
    }

    public  void  checkProgressbarStatus() throws InterruptedException {
        util.checkProgressbar(retrieving_information_popup);
    }

    String srtManagementDetailArrow = "//tbody/tr[1]/td[8]/span[1]//*[name()='svg']";
    public boolean isManagementDetailPresent() throws InterruptedException {
        return util.isElementPresent(By.xpath(srtManagementDetailArrow));
    }

    String srtAddUserButton = "//body//div[@id='__next']//div[@id='customUserDiv']//div//div//div//div//div//span[1]";
    public boolean isAddUserButtonPresent() throws InterruptedException {
        return util.isElementPresent(By.xpath(srtAddUserButton));
    }




}
