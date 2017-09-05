package spring_mvc_test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebTestExample {

	@Test
	public void sabhat() {
		
		final File file = new File("/Users/sanjay.agnani/Downloads/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
	
		WebDriverUtils utils= new WebDriverUtils(driver);
		
		driver.navigate().to("http://localhost:8080/spring_mvc_login");
		
		System.out.println("A");
		//beginAt("login"); //Open the browser on http://localhost:8080/test/home.xhtml
        //clickLink("home");}
		driver.navigate().to("http://localhost:8080/spring_mvc_login/login");
		utils.takeScreenshot("homepage");
		//driver.findElement(By.id("home")).click();;
		driver.findElement(By.id("username")).sendKeys("teacher");
		driver.findElement(By.id("password")).sendKeys("teacher");
		driver.findElement(By.id("login")).click();;
		
		
		System.out.println(driver);
		System.out.println(driver.manage().getCookies());
		
		System.out.println(driver.getWindowHandle());
		
		driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.SECONDS);
		
		driver.navigate().back();
	

		//driver.quit();
		

	}

}
