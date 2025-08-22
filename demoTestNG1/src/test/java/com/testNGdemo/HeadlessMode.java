package com.testNGdemo;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessMode {
	WebDriver driver;
	WebDriverWait wait;
	Logger logger = LogManager.getLogger(HeadlessMode.class);
	
	@BeforeClass
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); 	//enable headless mode
		options.addArguments("--window-size=1920,1080");	//for full screen window
		driver = new ChromeDriver(options);
		logger.info("Launching browser....");
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	public void loginTest() {
		//login
		logger.info("loding login page...");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username"))).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		logger.info("Login successful...");
		
		//verify login
		Assert.assertTrue(driver.getTitle().contains("Web Orders"), "Login failed - Title Mismatch");
		
	}
	
	@Test(priority=2)
	public void viewHomePage() {
		String title = driver.getTitle();
		logger.info("loding Home page...");
		Assert.assertTrue(title.contains("Web Orders"), "Home page not loaded correctly");
		logger.info("Home page loaded successfully...");
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("closing browser...");
		if(driver != null) {
			driver.quit();
		}
	}
	
}
