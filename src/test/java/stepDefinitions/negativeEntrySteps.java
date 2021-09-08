package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageFactory.PositiveNegativeListPage_PF;

public class negativeEntrySteps {

    WebDriver driver;
    PositiveNegativeListPage_PF pnl_pf ;

    @When("click on Negative Button")
    public void click_on_negative_button() throws InterruptedException {
        driver = VtLoginSteps_PF.getDriver();
        pnl_pf = new PositiveNegativeListPage_PF(driver);
        pnl_pf.clickOnNegativeList();
    }
    @When("click on Add Negative Entry")
    public void click_on_add_negative_entry() throws InterruptedException {
        pnl_pf.clickOnAddNegativeEntry();
    }
    @When("user Fill Negative Add New Entry Form")
    public void user_fill_negative_add_new_entry_form() throws InterruptedException {
        System.out.println("fill form data....");
        pnl_pf.setData_Add_New_Entry_Form("Email", "test_negative_1@xyz.in", "vesta","08-31-2021","This is for test.");
    }
}
