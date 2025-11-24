package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdministrationPage;
import utilities.reportgenerator;
import utilities.screenshot;

public class tc6_loginAdminUppercasePassword extends reportgenerator {

	AdministrationPage admin=new AdministrationPage(hooks.driver);
	screenshot shot=new screenshot(hooks.driver);
	String filename="login_using_valid_uppercase_password";
	
	@When("enter login as {string} and uppercase password as {string}")
	public void enter_login_as_and_uppercase_password_as(String login, String password) throws IOException {
		logger=extent.startTest("admin login using valid password in uppercase test");
		shot.takeScreenshot(filename);
		admin.enterLogin(login);
		shot.takeScreenshot(filename);
		admin.enterPassword(password);
		shot.takeScreenshot(filename);
		admin.clickLogin();
	}
	
	@Then("he should not be navigated to admin menu page")
	public void he_should_not_be_navigated_to_admin_menu_page() throws IOException {
		String currentUrl = hooks.driver.getCurrentUrl();
		shot.takeScreenshot(filename);
		if(currentUrl.contains("notLogged")){
			logger.log(LogStatus.PASS, "admin login using valid password in uppercase pass");
			assertTrue(true);
		}
		else {
			logger.log(LogStatus.FAIL, "admin login using valid password in uppercase failed");
			assertTrue(false);
		}
		extent.endTest(logger);
		
	}
}
