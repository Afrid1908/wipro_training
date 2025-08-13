package com.testNGdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFlipKartLogin {

	WebDriver driver;
    WebDriverWait wait;

	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	
//	@Test(priority=1)
//	public void verifyMobileNumber() throws InterruptedException {
//		
//		//click login button
//		WebElement loginBtn = driver.findElement(By.xpath("//a[text()='Login']"));
//		loginBtn.click();
//		Thread.sleep(2000);
//		
//		//enter invalid mobile number
//		 WebElement inputBox = driver.findElement(By.cssSelector("input[class='_2IX_2- VJZDxU']"));
//	     inputBox.sendKeys("12345");
//	     Thread.sleep(1000);
//	     
//	     //request otp
//	     WebElement otpBtn = driver.findElement(By.xpath("//button/span[text()='Request OTP']"));
//	     otpBtn.click();
//	     Thread.sleep(1000);
//	     
//	     //validate error msg
//	     WebElement errorMsg = driver.findElement(By.xpath("//span[contains(text(),'Please enter a valid')]"));
//	     Assert.assertTrue(errorMsg.isDisplayed(),"Error message not displayed for invalid number");	
//	}
	
	 @Test(priority = 1)
	    public void loginWithManualOTP() throws Exception {
	        // Click Login
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']"))).click();

	        // Enter mobile number
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input._2IX_2-"))).sendKeys("8956605173");

	        // Click Request OTP
	        driver.findElement(By.xpath("//span[text()='Request OTP']")).click();

	        // Wait for OTP entry (manual step)
	        System.out.println("Please enter OTP manually on Flipkart and then press ENTER in console...");
	        System.in.read(); // Wait until you press Enter

	        // Wait until login is successful (account name appears)
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='My Account']")));
	        System.out.println("Login successful!");
	    }
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
