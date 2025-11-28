import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="features",glue= {"stepdefinition"},
plugin = {"pretty", "html:testReports/cucumber-reports.html","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
monochrome = true)
public class testrunner extends AbstractTestNGCucumberTests {
	
	
}
