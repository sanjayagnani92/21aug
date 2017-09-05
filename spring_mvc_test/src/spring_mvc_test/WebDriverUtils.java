package spring_mvc_test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class WebDriverUtils {

	WebDriver driver;

	public WebDriverUtils(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	
	public void takeScreenshot(String ssname)
	{
		File screenshotfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotfile, new File("/Users/sanjay.agnani/Desktop/"+ssname+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
}


