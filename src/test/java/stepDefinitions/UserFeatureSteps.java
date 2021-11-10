package stepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.AccountManagementPage_PF;
import pageFactory.BusinessInsightsPage_PF;
import pageFactory.RiskManagementPage_PF;
import util.UtilFunctions;

import java.util.*;

public class UserFeatureSteps {

    WebDriver driver;
    UtilFunctions util;
    AccountManagementPage_PF accountManagementPageObj;
    RiskManagementPage_PF riskManagementPageObj;
    BusinessInsightsPage_PF businessInsightsPageObj;
    ConfigFileReader configFileReader;


    @And("^user read top level feature for role (.*)$")
    public void userReadTopLevelFeatureForRole(String srtRole) throws InterruptedException {
        driver = VtLoginSteps_PF.getDriver();
        accountManagementPageObj = new AccountManagementPage_PF(driver);
        riskManagementPageObj = new RiskManagementPage_PF(driver);
        businessInsightsPageObj = new BusinessInsightsPage_PF(driver);
        util = new UtilFunctions(driver);

        Thread.sleep(1000);
        System.out.println("strRole: " +srtRole);
        String strHeaderTopNav = accountManagementPageObj.geHeaderTopNav();
       // System.out.println("strHeaderTopNav: " + strHeaderTopNav);

        HashMap<String, HashMap> mapHeaderTopNav = new HashMap<String, HashMap>();

        /* dashboard */
        HashMap<String, Integer> dashboardSubMane = new HashMap<String, Integer>();

        dashboardSubMane.put("dashboard", 1);

        if(strHeaderTopNav.contains("dashboard"))
               mapHeaderTopNav.put("dashboard", dashboardSubMane);


        /* Account Management */
        String strTableHeaderRow = accountManagementPageObj.getTableHeaderRow();

        HashMap<String, Integer> accountManagementSubMane = new HashMap<String, Integer>();

        if(strTableHeaderRow.contains("merchants"))
            accountManagementSubMane.put("merchants", 1);

        if(strTableHeaderRow.contains("users"))
            accountManagementSubMane.put("users", 1);

        if(strTableHeaderRow.contains("my account"))
            accountManagementSubMane.put("my_account", 1);

        if(strHeaderTopNav.contains("account management"))
            mapHeaderTopNav.put("account_management", accountManagementSubMane);

        /* Risk Management */
        HashMap<String, Integer> riskManagementSubMane = new HashMap<String, Integer>();

        accountManagementPageObj.checkProgressbarStatus();
        riskManagementPageObj.clickOnRiskManagementTab();
        accountManagementPageObj.checkProgressbarStatus();
        strTableHeaderRow = accountManagementPageObj.getTableHeaderRow();
        System.out.println("strTableHeaderRow:" +strTableHeaderRow);
        if(strTableHeaderRow.contains("orders"))
            riskManagementSubMane.put("orders", 1);

        if(strTableHeaderRow.contains("decisions"))
            riskManagementSubMane.put("decisions", 1);

        if(strTableHeaderRow.contains("configurations"))
            riskManagementSubMane.put("configurations", 1);

        if(strHeaderTopNav.contains("risk management"))
            mapHeaderTopNav.put("risk_management", riskManagementSubMane);

        /* Business Insights */
        HashMap<String, Integer> businessInsightsSubMane = new HashMap<String, Integer>();

        businessInsightsPageObj.clickOnBusinessInsightsTab();
        accountManagementPageObj.checkProgressbarStatus();
        strTableHeaderRow = accountManagementPageObj.getTableHeaderRow();
        System.out.println("strTableHeaderRow:" +strTableHeaderRow);
        if(strTableHeaderRow.contains("performance"))
            businessInsightsSubMane.put("performance", 1);

        if(strTableHeaderRow.contains("growth"))
            businessInsightsSubMane.put("growth", 1);

        if(strTableHeaderRow.contains("direction"))
            businessInsightsSubMane.put("direction", 1);

        if(strHeaderTopNav.contains("business insights"))
            mapHeaderTopNav.put("business_insights", businessInsightsSubMane);



        /* Display content using Iterator*/
        Set set = mapHeaderTopNav.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }


    }


}
