package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdministrationPage;
import utilities.reportgenerator;

public class tc7_loginAdminInvalidDetails extends reportgenerator{
	
	AdministrationPage admin=new AdministrationPage(hooks.driver);
	
	@When("enter invalid login as {string} and invalid password as {string}")
	public void enter_invalid_login_as_and_invalid_password_as(String login, String password) throws IOException {
		admin.enterLogin(login);
		admin.enterPassword(password);
		admin.clickLogin();  
	}
	
	@Then("he should not be navigated to admin menu page after using invalid details")
	public void he_should_not_be_navigated_to_admin_menu_page_after_using_invalid_details() throws IOException {
		logger=extent.startTest("Admin login using invalid details test");
		String currentUrl = hooks.driver.getCurrentUrl();
		System.out.println(currentUrl);
		if(currentUrl.contains("notLogged")){
			logger.log(LogStatus.PASS, "Admin login using invalid details pass");
			assertTrue(true);
		}
		else {
			logger.log(LogStatus.FAIL, "Admin login using invalid details failed");
			assertTrue(false);
		}
		extent.endTest(logger);
		System.out.println("navigation");
	}

}
