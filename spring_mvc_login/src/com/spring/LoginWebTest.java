package com.spring;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class LoginWebTest {

	
	@Before
    public void prepare() {

		
				
		setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        setBaseUrl("http://localhost:8080/spring_mvc_login");
    }
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080/spring_mvc_login");
		
	
		System.out.println("A");
		beginAt("login"); //Open the browser on http://localhost:8080/test/home.xhtml
        clickLink("home");}

}
