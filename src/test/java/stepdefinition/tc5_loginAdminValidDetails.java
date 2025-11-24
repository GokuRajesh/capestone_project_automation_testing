package stepdefinition;

import static org.testng.Assert.assertTrue;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdministrationPage;
import utilities.reportgenerator;

public class tc5_loginAdminValidDetails extends reportgenerator {
	
	AdministrationPage admin=new AdministrationPage(hooks.driver);
	
	@Given("user is in the Admin page")
	public void user_is_in_the_Admin_page() {
		admin.navigateToAdminPage();
	    System.out.println("user in admin page");
	}
	@When("enter login as {string} and password as {string}")
	public void enter_login_as_and_password_as(String login, String password) {
		logger=extent.startTest("admin login using valid details test");
		admin.enterLogin(login);
		admin.enterPassword(password);
		admin.clickLogin();
	   System.out.println("enter login in admin");
	}
	@Then("he should be navigates to admin menu page")
	public void he_should_be_navigates_to_admin_menu_page() {
		String currentUrl = hooks.driver.getCurrentUrl();
		if(currentUrl.contains("AdmMenu")){
			logger.log(LogStatus.PASS, "admin login using valid details pass");
			assertTrue(true);
		}
		else {
			logger.log(LogStatus.FAIL, "admin login using valid details failed");
			assertTrue(false);
		}
		extent.endTest(logger);
	    System.out.println("navigates to the admin menu page");
	}


}
