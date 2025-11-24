package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	WebDriver driver;
	
	public homePage(WebDriver driver){
		this.driver=driver;
	}
	public void search(String product) {
		driver.findElement
		(By.xpath("//form[@name='products_search']/table[2]/tbody/tr/td/input"))
		.sendKeys(product);
	}
	public void clickSearch() {
		driver.findElement
		(By.xpath("//form[@name='products_search']/table[2]/tbody/tr/td/input[@type='image']"))
		.click();		
	}
}
