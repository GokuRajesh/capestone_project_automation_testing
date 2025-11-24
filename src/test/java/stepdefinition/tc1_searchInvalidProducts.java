package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import utilities.reportgenerator;

public class tc1_searchInvalidProducts extends reportgenerator{

		homePage home=new homePage(hooks.driver);
		
		@Given("the user in the Home page")
		public void the_user_in_the_Home_page() {
			System.out.println("user is in the home page");
		}
		
		@When("he searches invalid product in category all as {string}")
		public void he_searches_invalid_product_in_category_all(String product) {
			logger=extent.startTest("search invalid products test");
			home.search(product);
			home.clickSearch();
			System.out.println("user searches invalid product in all");
		}

		@Then("he should be able to view no record found")
		public void he_should_be_able_to_view_no_record_found() {
			try {
				hooks.driver.findElement(By.xpath("//*[contains(text(),'No records')]"));
				logger.log(LogStatus.PASS, "search invalid product test passed");
				assertTrue(true);
			}
			catch(Exception e){
				logger.log(LogStatus.FAIL, "search invalid product test fail");
				assertTrue(false);
			}
			finally {
				extent.endTest(logger);
			}
		    System.out.println("shows no record found");
		}

}
