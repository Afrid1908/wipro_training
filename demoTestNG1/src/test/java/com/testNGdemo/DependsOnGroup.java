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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DependsOnGroup {
	 WebDriver driver;
	 WebDriverWait wait;

	  @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("=== Start of Test Suite ===");
	    }

	    @BeforeClass
	    public void setUp() {
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

	    @Test(groups="home")
	    public void verifyHomePage() {
	        String title = driver.getTitle();
	        Assert.assertTrue(title.contains("Web Orders"), "Home page not loaded correctly");
	    }

	    @Test(groups="order")
	    public void viewAllOrders() {
	        WebElement ordersLink = wait.until(
	            ExpectedConditions.elementToBeClickable(By.linkText("View all orders"))
	        );
	        ordersLink.click();
	        Assert.assertTrue(driver.getPageSource().contains("List of All Orders"), "Orders page not loaded");
	    }

	    @Test(groups="product")
	    public void viewAllProducts() {
	        WebElement productsLink = wait.until(
	            ExpectedConditions.elementToBeClickable(By.linkText("View all products"))
	        );
	        productsLink.click();
	        Assert.assertTrue(driver.getPageSource().contains("List of Products"), "Products page not loaded");
	    }

	    @Test(dependsOnGroups= {"home","order","product"})
	    public void placeOrder() {
	        // Navigate to Order page
	        WebElement orderLink = wait.until(
	            ExpectedConditions.elementToBeClickable(By.linkText("Order"))
	        );
	        orderLink.click();

	        // Uncomment and use if you want to actually place an order with pauses
	        /*
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_fmwOrder_ddlProduct"))).sendKeys("FamilyAlbum");
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("John Doe");
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Main St");
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("New York");
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("NY");
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("12345");
	        pause(1);

	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4111111111111111");
	        pause(1);
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/25");
	        pause(1);

	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	        pause(2);

	        Assert.assertTrue(driver.getPageSource().contains("New order has been successfully added."),
	                "Order placement failed");
	        pause(2);
	        */
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
