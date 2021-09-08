package stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


//NegativeList/addNegativeEntry.feature

//PositiveList/addPositiveEntry.feature

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Riskmanagement/Configurations/PositiveList/addPositiveEntry.feature"
        ,glue={"stepDefinitions"}
        ,monochrome = true
        ,plugin = {"pretty", "html:target/HtmlReports/htmlReports.html"
        ,"json:target/JsonReports/jsonReports.json"
        ,"junit:target/JunitReports/junitReports.xml"}
)

public class TestRunner {
}
