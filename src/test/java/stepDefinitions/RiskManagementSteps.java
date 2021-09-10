package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageFactory.RiskManagementPage_PF;
import pageFactory.VtCustomerPage_PF;
import util.UtilFunctions;

public class RiskManagementSteps {


    InitiateTransactionsSteps initiateTransactionsSteps = new InitiateTransactionsSteps();
    WebDriver driver = initiateTransactionsSteps.getDriver();
    String orderId = initiateTransactionsSteps.getOrderId();
    UtilFunctions util = new UtilFunctions(driver);
    RiskManagementPage_PF riskManagementPagePF = new RiskManagementPage_PF(driver);
    VtCustomerPage_PF vtCustomerPagePF = new VtCustomerPage_PF(driver);

    @When("user login to vt customer portal {string} user {string} and password {string}")
    public void user_login_to_vt_customer_portal(String url, String userNAme, String password) {
        driver.navigate().to(url);

        vtCustomerPagePF.setUser_email_address(userNAme);
        vtCustomerPagePF.setUserPassword(password);
        vtCustomerPagePF.clickNextButton();

    }
    @When("navigate to risk management list page")
    public void navigate_to_risk_management_list_page() throws InterruptedException {

            riskManagementPagePF.clickOnRiskManagementTab();

    }
    @When("search order with order id")
    public void search_order_with_order_id() {
           // orderId = "1020";
            riskManagementPagePF.setSearchText(orderId);
            System.out.println("risk ManagementSteps OrderId:  "+orderId);

    }
    @When("click for transaction summary")
    public void click_for_transaction_summary() throws InterruptedException {
        //td[normalize-space()='1020']

        String strXpath = "//td[normalize-space()='"+orderId+"']";
        //System.out.println("strXpath:  "+strXpath);
        util.waitAndClickXpath5sec(strXpath);
       // util.clickStickyArrow();
    }
    @When("check positive negative attributes")
    public void check_positive_negative_attributes() {
        String positiveCount = riskManagementPagePF.getPositiveAttributesCount();
        System.out.println("positiveCount:  "+positiveCount);
        String negativeCount = riskManagementPagePF.getNegativeAttributesCount();
        System.out.println("negativeCount:  "+negativeCount);

    }
    @Then("user logout")
    public void user_logout() {

    }



}
