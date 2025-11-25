package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdministrationPage;
import pageObjects.adminMenu;
import utilities.reportgenerator;

public class tc3_addingNewProducts extends reportgenerator {
	
	AdministrationPage admin=new AdministrationPage(hooks.driver);
	adminMenu menu=new adminMenu(hooks.driver);
	
	@Given("user is in the Admin page, enter login as {string} and password as {string}")
	public void user_is_in_the_Admin_page(String login,String password) {
		admin.navigateToAdminPage();
		admin.enterLogin(login);
		admin.enterPassword(password);
	    System.out.println("user is in the admin page");
	    admin.clickLogin();
	}
	@When("he adds the product in the product list as {string} ,{string} and {string}")
	public void he_adds_the_new_product_in_the_product_list(String category,String name,String price) {
		logger=extent.startTest("Add the products test");
		menu.navigateToProdcuts();
		menu.addNew();
		menu.editStoreProductsCategory(category);
		menu.editStoreProductsEnterProductName(name);
		menu.editStoreProductsEnterPrice(price);
		menu.clickAdd();
	    System.out.println("he adds the new product in the product list");
	}
	
	@Then("the new product is added to the product list as {string},{string}")
	public void the_new_product_is_added_to_the_product_list(String name,String category) {
		menu.findProduct(name,category);
		try {
			hooks.driver.findElement(By.linkText(name));
			logger.log(LogStatus.PASS, "Add the product test passed");
			assertTrue(true);
		}
		catch(Exception e) {
			logger.log(LogStatus.FAIL, "Add the product test failed");
			assertTrue(false);
		}
		finally {
			extent.endTest(logger);
		}
	    System.out.println("the new product is added to the product list");
	}

}
