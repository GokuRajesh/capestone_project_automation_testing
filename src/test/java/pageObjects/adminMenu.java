package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class adminMenu {
	WebDriver driver;
	
	public adminMenu(WebDriver driver) {
		this.driver=driver;
	}
	public void navigateToProdcuts() {
		driver.findElement(By.linkText("Products")).click();
	}
	public void addNew() {
		driver.findElement(By.linkText("Add New")).click();
	}
	public void editStoreProductsCategory(String category) {
		Select select=new Select(driver.findElement(By.name("category_id")));
		select.selectByVisibleText(category);
	}
	public void editStoreProductsEnterProductName(String productname) {
		driver.findElement(By.name("product_name")).sendKeys(productname);
	}
	public void editStoreProductsEnterPrice(String price) {
		driver.findElement(By.name("price")).sendKeys(price);
	}
	public void clickAdd() {
		driver.findElement(By.name("Insert1")).click();
	}
	public void findProduct(String product,String category) {
		driver.findElement(By.name("s_product_name")).sendKeys(product);
		Select selector=new Select(driver.findElement(By.name("product_category")));
		selector.selectByContainsVisibleText(category);
		driver.findElement(By.xpath("//input[@name='Search']")).click();
	}
	public void clickDelete() {
		driver.findElement(By.name("Delete1")).click();
	}
	public void acceptAlert() {
		// Handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Press OK on the alert
	}
}
