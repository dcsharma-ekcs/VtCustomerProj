package stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Login/vtLogin.feature"
        ,glue = {"stepDefinitions"}
        ,monochrome = true
        ,plugin = {"pretty", "html:target/HtmlReports/vtLogin.html"
        ,"json:target/JsonReports/jsonReports.json"
        ,"junit:target/JunitReports/junitReports.xml"}
)

public class TestRunner {
}
