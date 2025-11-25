package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.adminMenu;
import utilities.reportgenerator;

public class tc8_deleteProducts extends reportgenerator{

	int flag=1;
	adminMenu menu=new adminMenu(hooks.driver);
	
	@When("he deletes the {string},{string}")
	public void he_deletes_the(String product,String category) {
		int prev,after;
	   menu.navigateToProdcuts();
	   menu.findProduct(product,category);
	   try {
		   List<WebElement> links = hooks.driver.findElements(By.linkText(product));
		   prev = links.isEmpty() ? 0 : links.size();
		   
		   hooks.driver.findElement(By.linkText(product)).click();
		   menu.clickDelete();
		   menu.acceptAlert();
		   menu.findProduct(product,category);
		   
		   List<WebElement> links2 = hooks.driver.findElements(By.linkText(product));
		   after = links2.isEmpty() ? 0 : links2.size();
		   if(after==prev) {
			   flag=0;
		   }
	   }
	   catch(Exception e) {
		  flag=0;
	   }
	   System.out.println(product);
	}

	@Then("the product is deleted")
	public void the_product_is_deleted() {
		logger=extent.startTest("Delete the products test");
		if(flag==0) {
			logger.log(LogStatus.FAIL, "Delete the product test failed");
			assertTrue(false);
			
		}
		else {
			logger.log(LogStatus.PASS, "Delete the product test passed");
			assertTrue(true);
		}
	    System.out.println("product deleted");
	}
}
