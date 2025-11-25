package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import utilities.reportgenerator;

public class tc2_searchValidProducts extends reportgenerator {
	
	homePage home=new homePage(hooks.driver);
	@When("he searches product in category all as {string}")
	public void he_searches_product_in_category_all(String product) {
		logger=extent.startTest("Search valid products test");
		home.search(product);
		home.clickSearch();
	    System.out.println("searches product in caregory all"+product);
	}
	
	@Then("he should be able to view the product {string}")
	public void he_should_be_able_to_view_the_product(String product) { 
		try {
			hooks.driver.findElement(By.linkText(product));
			logger.log(LogStatus.PASS, "Search valid product test passed");
			assertTrue(true);
		}
		catch(Exception e) {
			logger.log(LogStatus.FAIL, "Search valid product test fail");
			assertTrue(false);
		}
		finally {
			extent.endTest(logger);
		}
	    System.out.println("view the product");
	}
}
