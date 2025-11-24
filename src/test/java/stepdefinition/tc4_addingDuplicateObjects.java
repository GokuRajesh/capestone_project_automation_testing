package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.adminMenu;
import utilities.reportgenerator;
import utilities.screenshot;

public class tc4_addingDuplicateObjects extends reportgenerator {
	screenshot shot=new screenshot(hooks.driver);
	adminMenu menu=new adminMenu(hooks.driver);
	String filename="adding_duplicate_objects";
	
	@When("he adds the duplicate product in the product list as {string} ,{string} and {string}")
	public void he_adds_the_new_product_in_the_product_list(String category,String name,String price) throws IOException {
		logger=extent.startTest("add the duplicate products test");
		shot.takeScreenshot(filename);
		menu.navigateToProdcuts();
		shot.takeScreenshot(filename);
		menu.addNew();
		shot.takeScreenshot(filename);
		menu.editStoreProductsCategory(category);
		shot.takeScreenshot(filename);
		menu.editStoreProductsEnterProductName(name);
		shot.takeScreenshot(filename);
		menu.editStoreProductsEnterPrice(price);
		shot.takeScreenshot(filename);
		menu.clickAdd();
		shot.takeScreenshot(filename);
	    System.out.println("he adds the duplicate product in the product list");
	}
	
	@Then("the {string} is not added from {string}")
	public void the_is_not_added(String product,String category) throws IOException {
		shot.takeScreenshot(filename);
		menu.findProduct(product,category);
		List<WebElement> links = hooks.driver.findElements(By.linkText(product));
	    if(links.size()>1) {
	    	shot.takeScreenshot(filename);
	    	logger.log(LogStatus.FAIL, "add the duplicate product test failed");
	    	assertTrue(false);
	    }
	    else {
	    	shot.takeScreenshot(filename);
	    	logger.log(LogStatus.PASS, "add the duplicate product test passed");
	    	assertTrue(true);
	    }
		extent.endTest(logger);
	}
	
}
