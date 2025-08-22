package com.handleElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestSetup {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
