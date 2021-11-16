package stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


//NegativeList/addNegativeEntry.feature

//PositiveList/addPositiveEntry.feature

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/AccountManagement/Merchant/userRolesPermissions.feature"
        ,glue={"stepDefinitions"}
        ,tags= "@smoke"
        ,monochrome = true
        ,plugin = {"pretty", "html:target/HtmlReports/userRolesPermissions.html"
        ,"json:target/JsonReports/jsonReports.json"
        ,"junit:target/JunitReports/junitReports.xml"}
)

public class TestRunnerUserFeature {
}
