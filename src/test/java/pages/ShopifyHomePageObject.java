package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.UtilFunctions;


public class ShopifyHomePageObject {
    WebDriver driver = null;
    WebDriverWait wait;
    JavascriptExecutor js;
    String userEmail = null;
    String userPassword = null;
    UtilFunctions utilFunctions;


    By log_in_link = By.xpath("//a[@class='marketing-nav__item marketing-nav__item--user'][normalize-space()='Log in']");
    By user_email_address = By.xpath("//input[@id='account_email']");
    By next_button = By.xpath("//button[normalize-space()='Next']");
    By account_password = By.xpath("//input[@id='account_password']");
    By account_log_in_button = By.xpath("//button[normalize-space()='Log in']");
    By vesta_corporation = By.xpath("//span[normalize-space()='Vesta Corporation']");
    By app_link = By.xpath("//span[normalize-space()='Apps']");
    By search_text_field1 = By.xpath("//input[@id='PolarisTextField1']");
    By search_button = By.xpath("//span[contains(text(),'Search')]");
    By search_row = By.xpath("//th[@scope='row']//div//a");
    By select_store = By.xpath("//a[normalize-space()='Select store']");
    By search_text_field2 = By.xpath("//input[@id='PolarisTextField2']");
    By search_store_row = By.xpath("//div[@id='StoresListItemContainer']//div[@aria-hidden='true']");
    By install_app_anyway_button = By.xpath(" //span[contains(text(),'Install anyway')]");
    By install_app_button = By.xpath("//button[normalize-space()='Install unlisted app']");
    By store_link = By.xpath("//span[normalize-space()='Stores']");
    By store_login = By.xpath("//div[@class='ui-title-bar__actions-group']//a[@class='ui-button ui-button--primary ui-title-bar__action'][normalize-space()='Log in']");
    By app_delete_confirmation = By.xpath("//div[@role='dialog']//div//div//div//div//div//div//div//button[@type='button']//span//span[contains(text(),'Delete')]");
    By delete_app_success_message = By.xpath("//div[@id='PolarisBanner2Content']");
    By store_settings_button = By.xpath("//span[normalize-space()='Settings']");
    By store_general_setting = By.xpath("//p[normalize-space()='General']");
    By store_contact_email = By.xpath("//input[@id='PolarisTextField2']");
    By save_store_Change_email = By.xpath("//body/div[@id='app']/div/div/div/div[@data-polaris-layer='true']/div/div/div/div/div/div/div[2]/button[1]/span[1]/span[1]");
    By search_product_field = By.xpath("//summary[@aria-label='Search']//span");
    By store_orders_tab = By.xpath("//span[normalize-space()='Orders']");
    By store_search_field = By.xpath("//input[@placeholder='Filter orders']");
    By store_payment_status = By.xpath("//tbody/tr/td/div/div/div/span[1]");

    public ShopifyHomePageObject(WebDriver driver, String userEmail, String userPassword) {
        this.driver = driver;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        utilFunctions = new UtilFunctions(this.driver);
        wait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
    }


    public String getOrderPaymentStatus() throws InterruptedException {
           String paymentStatus =  driver.findElement(store_payment_status).getText();

           return paymentStatus;
    }

    public void clickStoreOrdersTab() throws InterruptedException {
        //utilFunctions.waitForXpath(store_orders_tab);
        Thread.sleep(3000);
        System.out.println("this.....");
        driver.findElement(store_orders_tab).click();
    }

    public void searchOrder(String srtOrder) throws InterruptedException {
        utilFunctions.waitForXpath(store_search_field);
        driver.findElement(store_search_field).click();
        driver.findElement(store_search_field).clear();
        driver.findElement(store_search_field).sendKeys(srtOrder);
    }






    public void clickOnLogInLink() throws InterruptedException {
        utilFunctions.waitForXpath(log_in_link);
        driver.findElement(log_in_link).click();
    }

    public void setUserEmailAddress() throws InterruptedException {
        utilFunctions.waitForXpath(user_email_address);
        wait.until(ExpectedConditions.elementToBeClickable(user_email_address));

        driver.findElement(user_email_address).click();
        driver.findElement(user_email_address).clear();
        driver.findElement(user_email_address).sendKeys(userEmail);
    }

    public void clickNextButton() throws InterruptedException {
        utilFunctions.waitForXpath(next_button);
        driver.findElement(next_button).submit();
    }

    public void setPassword() throws InterruptedException {
        utilFunctions.waitForXpath(account_password);
        wait.until(ExpectedConditions.elementToBeClickable(account_password));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(account_password));

        driver.findElement(account_password).click();
        driver.findElement(account_password).clear();
        driver.findElement(account_password).sendKeys(userPassword);
    }

    public void clickAccountsLogInButton() throws InterruptedException {
        utilFunctions.waitForXpath(account_log_in_button);
        Thread.sleep(1000);
        driver.findElement(account_log_in_button).submit();
    }

    public void clickVestaCorporation() throws InterruptedException {
        utilFunctions.waitForXpath(vesta_corporation);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(vesta_corporation));
        driver.findElement(vesta_corporation).click();
    }

    public void clickAppLink() throws InterruptedException {
        utilFunctions.waitForXpath(app_link);
        driver.findElement(app_link).click();
    }

    public void setSearch_text_field1(String strText) throws InterruptedException {

        driver.findElement(search_text_field1).sendKeys(strText);
        Thread.sleep(1000);
    }

    public void clickSearchButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(search_button));
        driver.findElement(search_button).click();
        Thread.sleep(1000);
    }

    public void clickSearchRow() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(search_row));
        driver.findElement(search_row).click();
    }

    public void clickSelectStore() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,400)", "");
        utilFunctions.waitForXpath(select_store);
        wait.until(ExpectedConditions.elementToBeClickable(select_store));
        driver.findElement(select_store).click();
    }

    public void setSearch_text_field2(String strText) throws InterruptedException {
        driver.findElement(search_text_field2).sendKeys(strText);
    }

    public void clickSearchStoreRow() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(search_store_row));
        driver.findElement(search_store_row).click();

    }

    public  void clickInstallAppAnywayButton() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(install_app_anyway_button));
            Thread.sleep(2000);
            driver.findElement(install_app_anyway_button).submit();

        } catch (Exception exp){
            System.out.println("Exception..."+exp);
        }

    }
    public  void clickInstallAppButton() throws InterruptedException {

        try {
            Thread.sleep(3000);
            js.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(install_app_button));
            wait.until(ExpectedConditions.visibilityOfElementLocated(install_app_button));
            utilFunctions.waitForXpath(install_app_button);
            Thread.sleep(3000);
            driver.findElement(install_app_button).submit();

        } catch (Exception exp){
            System.out.println("Exception..."+exp);
        }

    }

    public void loginInToStore(String srtStore) throws InterruptedException {
        System.out.println("...loginInToStore...");
        String storeXpath = "//span[normalize-space()='"+srtStore+"']";
        System.out.println("loginInToStore..."+storeXpath);
        utilFunctions.waitForXpath(store_link);
        wait.until(ExpectedConditions.visibilityOfElementLocated(store_link));
        driver.findElement(store_link).click();

        setSearch_text_field1(srtStore);

        utilFunctions.waitAndClickXpath(storeXpath);
        utilFunctions.waitForXpath(store_login);
        wait.until(ExpectedConditions.visibilityOfElementLocated(store_login));
        driver.findElement(store_login).click();
    }

    public void deleteAppFromStore(String srtApp) throws InterruptedException {
        String appDeleteButtonXpath = "//button[@aria-label='"+"Delete "+srtApp+"']";
        utilFunctions.waitAndClickXpath(appDeleteButtonXpath);
        clickOnConfirmationDeleteButton();
    }

    public void clickOnConfirmationDeleteButton() throws InterruptedException {

        driver.switchTo().activeElement();
        Thread.sleep(3000);
        utilFunctions.waitForXpath(app_delete_confirmation);
        wait.until(ExpectedConditions.visibilityOfElementLocated(app_delete_confirmation));
        driver.findElement(app_delete_confirmation).click();
        driver.switchTo().defaultContent();
    }

    public void findAndCompareMessage(String message){

        String elementMessage = getTextFromElement(delete_app_success_message);
        System.out.println("Given message: "+message);
        System.out.println("elementMessage: "+elementMessage);

        boolean flag =  elementMessage.equalsIgnoreCase(message);
        if(flag) System.out.println("You successfully deleted App... ");


    }

    public String getTextFromElement(By element){
        String message = driver.findElement(element).getText();

        return message;
    }

    public void goBackOnDefaultWindow() throws InterruptedException {
        String parent = driver.getWindowHandle();
        driver.switchTo().window(parent);
        driver.switchTo().defaultContent();
        Thread.sleep(4000);
    }

    public void clickStoreSettings() throws InterruptedException {
        System.out.println("...clickStoreSettings...");
        driver.switchTo().activeElement();
        utilFunctions.waitForXpath(store_settings_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(store_settings_button));
        driver.findElement(store_settings_button).click();
    }

    public void clickGeneralSettings() throws InterruptedException {
        utilFunctions.waitForXpath(store_general_setting);
        wait.until(ExpectedConditions.visibilityOfElementLocated(store_general_setting));
        driver.findElement(store_general_setting).click();
    }

    public void setStoreContactEmail(String newEmail) throws InterruptedException {
        utilFunctions.waitForXpath(store_contact_email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(store_contact_email));
        wait.until(ExpectedConditions.visibilityOfElementLocated(store_contact_email));

        driver.findElement(store_contact_email).click();

        driver.findElement(store_contact_email).sendKeys(Keys.CONTROL + "a");
        driver.findElement(store_contact_email).sendKeys(Keys.DELETE);

        driver.findElement(store_contact_email).sendKeys(newEmail);
        driver.switchTo().activeElement();
        driver.findElement( save_store_Change_email).click();


    }

}
