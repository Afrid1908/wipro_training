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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class GroupExample {
	 WebDriver driver;
	 WebDriverWait wait;
	 
	@Test(groups = "smoke")
    public void loginTest() {
        System.out.println("Smoke: Login Test");
        driver = new ChromeDriver();   	
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open site
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username"))).sendKeys("Tester");
        
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
       

        // Verify login
        Assert.assertTrue(driver.getTitle().contains("Web Orders"), "Login failed - Title mismatch");
    }

    @Test(groups = "smoke")
    public void viewAllOrdersTest() {
        System.out.println("Smoke: All orders Test");
        WebElement ordersLink = wait.until(
	            ExpectedConditions.elementToBeClickable(By.linkText("View all orders"))
	        );
	        ordersLink.click();
	        Assert.assertTrue(driver.getPageSource().contains("List of All Orders"), "Orders page not loaded");
    }

    @Test(groups = "regression")
    public void viewAllProductsTest() {
        System.out.println("Regression: All products Test");
        WebElement productsLink = wait.until(
	            ExpectedConditions.elementToBeClickable(By.linkText("View all products"))
	        );
	        productsLink.click();
	        Assert.assertTrue(driver.getPageSource().contains("List of Products"), "Products page not loaded");
    }

    @Test(groups = "regression")
    public void placeOrderTest() {
        System.out.println("Regression: place order Test");
        WebElement orderLink = wait.until(
	            ExpectedConditions.elementToBeClickable(By.linkText("Order"))
	        );
	        orderLink.click();
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("=== Browser Closed ===");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("=== Test Suite Completed ===");
    }
}
