package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.AccountManagementPage_PF;
import pageFactory.BusinessInsightsPage_PF;
import pageFactory.PositiveNegativeListPage_PF;
import pageFactory.RiskManagementPage_PF;
import util.UtilFunctions;

import java.util.*;

public class UserFeatureSteps {

    WebDriver driver;
    UtilFunctions util;
    AccountManagementPage_PF accountManagementPageObj;
    RiskManagementPage_PF riskManagementPageObj;
    BusinessInsightsPage_PF businessInsightsPageObj;
    PositiveNegativeListPage_PF positiveNegativeListPageObj;
    ConfigFileReader configFileReader;


    @And("^user read top level feature for role (.*)$")
    public void userReadTopLevelFeatureForRole(String srtRole) throws InterruptedException {
        driver = VtLoginSteps_PF.getDriver();
        accountManagementPageObj = new AccountManagementPage_PF(driver);
        riskManagementPageObj = new RiskManagementPage_PF(driver);
        businessInsightsPageObj = new BusinessInsightsPage_PF(driver);
        positiveNegativeListPageObj = new PositiveNegativeListPage_PF(driver);
        util = new UtilFunctions(driver);

        Thread.sleep(1000);

        String strHeaderTopNav = accountManagementPageObj.geHeaderTopNav();
        //System.out.println("strHeaderTopNav: " + strHeaderTopNav);

        HashMap<String, HashMap> mapHeaderTopNav = new HashMap<String, HashMap>();

        /* Account Management */
        String strTableHeaderRow = accountManagementPageObj.getTableHeaderRow();

        HashMap<String, Integer> accountManagementSubMane = new HashMap<String, Integer>();

        if (strTableHeaderRow.contains("merchants")) {
            accountManagementSubMane.put("merchants_list", 1);
            if (accountManagementPageObj.isManagementDetailPresent())
                accountManagementSubMane.put("merchants_view", 1);

        }

        if (strTableHeaderRow.contains("users")) {
            accountManagementSubMane.put("users_list", 1);
            accountManagementPageObj.checkProgressbarStatus();
            accountManagementPageObj.clickOnUsersTab();
            if (accountManagementPageObj.isAddUserButtonPresent())
                accountManagementSubMane.put("users_add", 1);
        }

        if (strTableHeaderRow.contains("my account"))
            accountManagementSubMane.put("my_account", 1);

        if (strHeaderTopNav.contains("account management"))
            mapHeaderTopNav.put("account_management", accountManagementSubMane);

        /* Risk Management */
        HashMap<String, Integer> riskManagementSubMane = new HashMap<String, Integer>();


        if (strHeaderTopNav.contains("risk management")) {
            accountManagementPageObj.checkProgressbarStatus();
            riskManagementPageObj.clickOnRiskManagementTab();
            accountManagementPageObj.checkProgressbarStatus();

            strTableHeaderRow = accountManagementPageObj.getTableHeaderRow();
            System.out.println("strTableHeaderRow:" + strTableHeaderRow);
            if (strTableHeaderRow.contains("orders")) {
                riskManagementSubMane.put("orders_list", 1);

                if (riskManagementPageObj.isOrderDetailPresent())
                    riskManagementSubMane.put("orders_view", 1);
            }

            if (strTableHeaderRow.contains("decisions"))
                riskManagementSubMane.put("decisions", 1);

            if (strTableHeaderRow.contains("configurations")) {
                riskManagementSubMane.put("positive_negative_list", 1);
                positiveNegativeListPageObj.clickOnConfigurationsButton();
                positiveNegativeListPageObj.clickOnPositiveNegativeButton();
                if (riskManagementPageObj.isAddPNButtonPresent())
                    riskManagementSubMane.put("positive_negative_add", 1);
            }

            mapHeaderTopNav.put("risk_management", riskManagementSubMane);
        }

        /* Business Insights */
        HashMap<String, Integer> businessInsightsSubMane = new HashMap<String, Integer>();
        accountManagementPageObj.checkProgressbarStatus();
        if (strHeaderTopNav.contains("business insights")) {

            businessInsightsPageObj.clickOnBusinessInsightsTab();
            accountManagementPageObj.checkProgressbarStatus();

            strTableHeaderRow = accountManagementPageObj.getTableHeaderRow();
            System.out.println("strTableHeaderRow:" + strTableHeaderRow);
            if (strTableHeaderRow.contains("performance"))
                businessInsightsSubMane.put("performance", 1);

            if (strTableHeaderRow.contains("growth"))
                businessInsightsSubMane.put("growth", 1);

            if (strTableHeaderRow.contains("direction"))
                businessInsightsSubMane.put("direction", 1);

            mapHeaderTopNav.put("business_insights", businessInsightsSubMane);

        }

        /* Dashboard */
        HashMap<String, Integer> dashboardSubMane = new HashMap<String, Integer>();
        dashboardSubMane.put("dashboard", 1);
        if (strHeaderTopNav.contains("dashboard"))
            mapHeaderTopNav.put("dashboard", dashboardSubMane);


        /* Display content using Iterator*/
        Set set = mapHeaderTopNav.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

        /* Admin Role and Permission HashMap */
        System.out.println("strRole: " + srtRole);
        String userRole = srtRole;

        HashMap<String, HashMap> mapAdminRole = new HashMap<String, HashMap>();

        HashMap<String, Integer> dashboardSubMane1 = new HashMap<String, Integer>();
        HashMap<String, Integer> accountManagementSubMane1 = new HashMap<String, Integer>();
        HashMap<String, Integer> riskManagementSubMane1 = new HashMap<String, Integer>();
        HashMap<String, Integer> businessInsightsSubMane1 = new HashMap<String, Integer>();

        if (userRole.equalsIgnoreCase("Admin")) {

            dashboardSubMane1.put("dashboard", 1);
            mapAdminRole.put("dashboard", dashboardSubMane);

            accountManagementSubMane1.put("merchants_list", 1);
            accountManagementSubMane1.put("merchants_view", 1);
            accountManagementSubMane1.put("users_list", 1);
            accountManagementSubMane1.put("users_add", 1);
            accountManagementSubMane1.put("my_account", 1);
            mapAdminRole.put("account_management", accountManagementSubMane1);

            riskManagementSubMane1.put("orders_list", 1);
            riskManagementSubMane1.put("orders_view", 1);
            riskManagementSubMane1.put("decisions", 1);
            riskManagementSubMane1.put("positive_negative_list", 1);
            riskManagementSubMane1.put("positive_negative_add", 1);
            mapAdminRole.put("risk_management", riskManagementSubMane1);

            businessInsightsSubMane1.put("performance", 1);
            businessInsightsSubMane1.put("growth", 1);
            businessInsightsSubMane1.put("direction", 1);
            mapAdminRole.put("business_insights", businessInsightsSubMane1);

        } else if (userRole.equalsIgnoreCase("Fraud Ops")) {

            dashboardSubMane1.put("dashboard", 1);
            mapAdminRole.put("dashboard", dashboardSubMane);

            accountManagementSubMane1.put("merchants_list", 1);
            accountManagementSubMane1.put("my_account", 1);
            mapAdminRole.put("account_management", accountManagementSubMane1);

            riskManagementSubMane1.put("orders_list", 1);
            riskManagementSubMane1.put("orders_view", 1);
            riskManagementSubMane1.put("decisions", 1);
            riskManagementSubMane1.put("positive_negative_list", 1);
            riskManagementSubMane1.put("positive_negative_add", 1);
            mapAdminRole.put("risk_management", riskManagementSubMane1);


        } else if (userRole.equalsIgnoreCase("Reviewer")) {

            dashboardSubMane1.put("dashboard", 1);
            mapAdminRole.put("dashboard", dashboardSubMane);

            accountManagementSubMane1.put("my_account", 1);
            mapAdminRole.put("account_management", accountManagementSubMane1);

            riskManagementSubMane1.put("orders_list", 1);
            riskManagementSubMane1.put("orders_view", 1);
            riskManagementSubMane1.put("decisions", 1);
            riskManagementSubMane1.put("positive_negative_list", 1);
            mapAdminRole.put("risk_management", riskManagementSubMane1);


        } else if (userRole.equalsIgnoreCase("Default")) {

            dashboardSubMane1.put("dashboard", 1);
            mapAdminRole.put("dashboard", dashboardSubMane);

            accountManagementSubMane1.put("my_account", 1);
            mapAdminRole.put("account_management", accountManagementSubMane1);

            riskManagementSubMane1.put("orders_list", 1);
            riskManagementSubMane1.put("decisions", 1);
            mapAdminRole.put("risk_management", riskManagementSubMane1);

        }


        if (mapAdminRole.equals(mapHeaderTopNav)) {
            System.out.println(" Test Pass");
        } else {
            Assert.fail("Permissions and According Role");
        }


    }


}
