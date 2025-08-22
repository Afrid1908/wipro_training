package com.loggerDemo;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoggerExample {
//	   Logger logger = LogManager.getLogger(LoggerExample.class);
//
//		WebDriver driver;
//		@Test
//		public void testIframe() {
//			logger.info("Starting Iframe test...");
//			
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get("https://the-internet.herokuapp.com/iframe");
//			logger.debug("Navigated to test page");
//			
//			driver.switchTo().frame("mce_0_ifr");
//			logger.info("Switched to iframe");
//			
//			WebElement editorBody = driver.findElement(By.id("tinymce"));
//			editorBody.clear();
//			editorBody.sendKeys("Hello from TestNG");
//			logger.info("Typed text inside frame");
//			
//			Assert.assertEquals(editorBody.getText(), "Hello TinyMCE!", "Text mismatch!!!");
//			logger.info("Assertion Passed");
//			
//			driver.switchTo().defaultContent();
//			logger.info("Switched back to main content");			
//		}
//		
//		@AfterClass
//		public void tearDown() throws InterruptedException {
//			if(driver!=null) {
//				logger.info("Closing browser");
//				driver.quit();
//			}
//		}	
	
	
		WebDriver driver;
	   @BeforeMethod
	   public void setup() {
	       driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   }
	   @Test
	   public void testIframes() {
	       driver.get("https://demoqa.com/frames");
	      
	       driver.switchTo().frame("frame1");
	       String text1 = driver.findElement(By.id("sampleHeading")).getText();
	       System.out.println("Frame1 Text: " + text1);
	       driver.switchTo().defaultContent();
	       
	       driver.switchTo().frame("frame2");
	       String text2 = driver.findElement(By.id("sampleHeading")).getText();
	       System.out.println("Frame2 Text: " + text2);
	       driver.switchTo().defaultContent();
	   }
	   @AfterMethod
	   public void tearDown() {
	       driver.quit();
	   }
	
}
