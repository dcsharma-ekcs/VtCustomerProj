package stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Transactions/initiateTransactionsCheckDecisionsCheckShopify.feature"
        ,glue={"stepDefinitions"}
        ,tags= "@smoke"
        ,monochrome = true
        ,plugin = {"pretty", "html:target/HtmlReports/initiateTransactionsCheckDecisionsCheckShopify.html"
        ,"json:target/JsonReports/jsonReports.json"
        ,"junit:target/JunitReports/junitReports.xml"}
)

public class TestRunnerTransactionsWithDecisions {
}
