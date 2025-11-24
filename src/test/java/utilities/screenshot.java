package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class screenshot {
	int i=1;
	WebDriver driver;
	public screenshot(WebDriver driver) {
		this.driver=driver;
	}
	public void takeScreenshot(String filename) throws IOException {
		System.out.println("Taking Screenshot");
		File scrFile;
		scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile,new File("C:\\Selenium demo\\Capstone_project_maven\\screenshots\\"+filename+"\\steps_"+i+".jpeg"));
		i++;
	}
}
