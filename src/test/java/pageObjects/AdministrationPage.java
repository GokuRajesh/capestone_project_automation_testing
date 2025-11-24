package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministrationPage {
	WebDriver driver;
	public AdministrationPage(WebDriver driver) {
		this.driver=driver;
	}
	public void navigateToAdminPage() {
		driver.findElement(By.linkText("Administration")).click();
	}
	public void enterLogin(String login) {
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys(login);
	}
	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(By.name("DoLogin")).click();
	}
}
